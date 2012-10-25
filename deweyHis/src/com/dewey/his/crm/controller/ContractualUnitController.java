package com.dewey.his.crm.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.crm.model.ContractualUnit;
import com.dewey.his.crm.model.MerContractualRelation;
import com.dewey.his.crm.service.ContractualUnitManager;
import com.dewey.his.param.model.RoomType;
import com.dewey.his.param.service.RoomTypeManager;
import common.base.controller.BaseController;
import common.poi.PoiExcelServletUtil;

@Controller
@RequestMapping("/contractualUnit") 
public class ContractualUnitController  extends BaseController<ContractualUnit, Long> {
	
	private ContractualUnitManager contractualUnitManager;

	public void setContractualUnitManager(ContractualUnitManager contractualUnitManager) {
		this.contractualUnitManager = contractualUnitManager;
	}
	
	/**
	 * ACTION��ͼ
	 */
	private final String LIST_ACTION_VIEW      = pre_forward + "/contractualUnit/list";         // �б���ͼ
	
	/**
	 * PAGE��ͼ
	 */
	private final String LIST_PAGE_VIEW          = "/crm/contractualUnit/list";           // �б�ҳ��
	private final String NEW_PAGE_VIEW         = "/crm/contractualUnit/new";        // ����ҳ��
	private final String EDIT_PAGE_VIEW          = "/crm/contractualUnit/edit";         // �޸�ҳ��
	
	private final String LIST_MODEL          = "contractualUnitList";
	private final String OBJ_MODEL          = "contractualUnit";
	
	/**
	 * ����
	 */
	private RoomTypeManager roomTypeManager;

	public void setRoomTypeManager(RoomTypeManager roomTypeManager) {
		this.roomTypeManager = roomTypeManager;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView index(HttpServletRequest request) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		ModelAndView model = new ModelAndView();
		model.addObject(LIST_MODEL, contractualUnitManager.findMerAllContractualUnit(mer.getId()));
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/** 
	 * �û����� -> �����û���Ϣ�б� 
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/listAllExp")
	public String listExp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		String fileName = "Э�鵥λ����.xls";
		// ����Excel
		PoiExcelServletUtil ps = new PoiExcelServletUtil();
		ps.initWorkBook();
		ps.createSheet(0, "Э�鵥λ�б�");
		ps.createRow(0, 15);
		ps.setCell(0, "���",ps.getTitleStyle());
		ps.setCell(1, "��λ����",ps.getTitleStyle());
		ps.setCell(2, "��ϵ��",ps.getTitleStyle());
		ps.setCell(3, "�绰",ps.getTitleStyle());
		ps.setCell(4, "��ע",ps.getTitleStyle());
		ps.setCell(5, "�Ǽ�ʱ��",ps.getTitleStyle());
		// ������
		List<ContractualUnit> list  = contractualUnitManager.findMerAllContractualUnit(mer.getId());
		for (int i = 0; i< list.size(); i++ ) {
			ContractualUnit unit = list.get(i);
			ps.createRow((i+1), 13);
			ps.setCell(0, (i+1), ps.getContentStyle());
			ps.setCell(1, unit.getCompany(), ps.getContentStyle());
			ps.setCell(2, unit.getLinkman(), ps.getContentStyle());
			ps.setCell(3, unit.getTelphone(), ps.getContentStyle());
			ps.setCell(4, unit.getRemark(), ps.getContentStyle());
			ps.setCell(5, unit.getCreateTime(), ps.getContentStyle());
		}
		// ���л��ֽ���
		// InputStreamSerializable iss = new InputStreamSerializable(is);
		// return new  ModelAndView("downPoolReportFile","contentStream",iss.getInStream());
		request.setAttribute("fileName", fileName);
		request.setAttribute("contentStream", ps.exportServletInputStream());
		return "forward:/downloadExpFile";
	}
	
	/**
	 * ��������
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request, ModelMap model) {
		ContractualUnit contractualUnit = new ContractualUnit();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<RoomType> roomTypeList = roomTypeManager.findMerAllRoomType(mer.getId());
		List<MerContractualRelation> merContractualRelations = new ArrayList<MerContractualRelation>();
		// �����̻��µķ���
		for(RoomType roomType : roomTypeList) {
			MerContractualRelation cr = new MerContractualRelation();
			cr.setMerId(mer.getId());
			cr.setRoomType(roomType);
			merContractualRelations.add(cr);
		}
		contractualUnit.setMer(mer);
		contractualUnit.setMerContractualRelations(merContractualRelations);
		model.addAttribute(OBJ_MODEL, contractualUnit);
		return NEW_PAGE_VIEW;
	}
	
	/**
	 * ��������
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request,ContractualUnit contractualUnit) throws Exception {
		// ���¹�����Ϣ
		List<MerContractualRelation> cons = contractualUnit.getMerContractualRelations();
		for (MerContractualRelation con : cons) {
			con.setMerId(contractualUnit.getMer().getId());
			con.setContractualUnit(contractualUnit);
		}
		contractualUnitManager.save(contractualUnit);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
	
	/** ����༭ */
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value="id") 	int id, HttpServletRequest request,ModelMap model) throws Exception {
		model.addAttribute(OBJ_MODEL, contractualUnitManager.getById(id));
		return EDIT_PAGE_VIEW;
	}
	
	/** ������� */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ContractualUnit contractualUnit,HttpServletRequest request) throws Exception {
		// ���¹�����Ϣ
		List<MerContractualRelation> cons = contractualUnit.getMerContractualRelations();
		for (MerContractualRelation con : cons) {
			con.setMerId(contractualUnit.getMer().getId());
			con.setContractualUnit(contractualUnit);
		}
		contractualUnitManager.update(contractualUnit);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
	
	/** ɾ�� */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") 	int id) {
		contractualUnitManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
}