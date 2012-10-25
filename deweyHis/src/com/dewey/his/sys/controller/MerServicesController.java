package com.dewey.his.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dewey.his.common.model.Mer;
import com.dewey.his.sys.model.MerServices;
import com.dewey.his.sys.service.MerServicesManager;

import common.base.constant.VOConstantList;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/merServices")
public class MerServicesController  extends BaseController<MerServices, Long> {
	
	private MerServicesManager merServicesManager;
	
	public void setMerServicesManager(MerServicesManager merServicesManager) {
		this.merServicesManager = merServicesManager;
	}

	/**
	 * ACTION视图
	 */
	private final String LIST_ACTION_VIEW = pre_redirect + "/merServices/list";        // 列表视图
	
	/**
	 * PAGE视图
	 */
	private final String LIST_PAGE_VIEW          = "/sys/merServices/list";           // 列表页面
	private final String NEW_PAGE_VIEW         = "/sys/merServices/new";        // 新增页面
	private final String EDIT_PAGE_VIEW          = "/sys/merServices/edit";         // 修改页面
	
	private final String LIST_MODEL          = "merServicesList";
	private final String OBJ_MODEL           = "merServices";
	
	@RequestMapping(value = "/query")
	public String query(ModelMap model) {
		model.addAllAttributes(VOConstantList.getMerServicesConsumeTypeListModelMap());
		return LIST_PAGE_VIEW;
	}
	
	@RequestMapping(value = "/list")
	public String index(HttpServletRequest request,@RequestParam(value="merServices.consumeType",required=false) String consumeType,ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerServices> merServicesList = null;
		if (consumeType == null || "".equals(consumeType.trim())) {
			merServicesList = merServicesManager.findMerAllMerServices(mer.getId());
		} else {
			merServicesList = merServicesManager.findConsumeTypeMerServices(mer.getId(), consumeType);
		}
		// 将服务类别由编码转为字符串
		Map<String, String> map = VOConstantList.getMerServicesConsumeTypeMap();
		for(MerServices merServices : merServicesList ) {
			merServices.setConsumeType(map.get(merServices.getConsumeType()));
		}
		model.addAttribute(LIST_MODEL, merServicesList);
		model.addAllAttributes(VOConstantList.getMerServicesConsumeTypeListModelMap());
		return LIST_PAGE_VIEW;
	}

	/**
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request,ModelMap model) {
		MerServices merServices = new MerServices();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		merServices.setMerId(mer.getId());
		model.addAllAttributes(VOConstantList.getMerServicesConsumeTypeListModelMap());
		model.addAttribute(OBJ_MODEL, merServices);
		return NEW_PAGE_VIEW;
	}

	/**
	 * 保存新增
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(MerServices merServices) throws Exception {
		merServicesManager.save(merServices);
		return LIST_ACTION_VIEW;
	}

	/** 进入编辑 */
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value="id") 	int id,ModelMap model) throws Exception {
		model.addAllAttributes(VOConstantList.getMerServicesConsumeTypeListModelMap());
		model.addAttribute(OBJ_MODEL, merServicesManager.getById(id));
		return EDIT_PAGE_VIEW;
	}

	/** 保存更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam 	Integer id, MerServices merServices) throws Exception {
		merServicesManager.update(merServices);
		return LIST_ACTION_VIEW;
	}

	/** 删除 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value="id") 	int id) {
		merServicesManager.deleteById(id);
		return LIST_ACTION_VIEW;
	}
}
