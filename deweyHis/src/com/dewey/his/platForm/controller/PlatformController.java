package com.dewey.his.platForm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.platForm.service.PlatformManager;
import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.service.MerRoleManager;
import com.dewey.his.sys.service.MerUserManager;

import common.base.constant.VOConstantList;
import common.base.controller.BaseController;


/**
 * @author jonathan
 * ����ƽ̨�����е�������Ҫ���̻�ע�ᣬ�̻���Ϣ�༭���̻�ɾ���ȹ��ܣ�
 *
 */
@Controller
@RequestMapping("/platForm")
public class PlatformController  extends BaseController<Mer, Long> {
	
	private PlatformManager platformManager;

	public void setPlatformManager(PlatformManager platformManager) {
		this.platformManager = platformManager;
	}
	
	/**
	 * ACTION��ͼ
	 */
	private final String LIST_ACTION_VIEW      = pre_forward + "/platForm/list";         // �б���ͼ
	
	/**
	 * PAGE��ͼ
	 */
	private final String LIST_PAGE_VIEW          = "/platForm/list";           // �б�ҳ��
	private final String NEW_PAGE_VIEW         = "/platForm/new";        // ����ҳ��
	private final String EDIT_PAGE_VIEW          = "/platForm/edit";         // �޸�ҳ��
	
	private final String LIST_MODEL          = "merList";
	private final String OBJ_MODEL           = "mer";
	
	@RequestMapping(value = "/list")
	public String index(HttpServletRequest request,ModelMap model) {
		List<Mer> merList =platformManager.getAllMer();
		// �û���״̬����ת��
		Map<String, String> statusMap = VOConstantList.getMerStatusMap();
		for(Mer mer : merList) {
			mer.setStatus(statusMap.get(mer.getStatus()));
		}
		model.addAttribute(LIST_MODEL,  merList);
		return LIST_PAGE_VIEW;
	}
	
	/**
	 * Ajax ����¼���Ƿ����  Y: ��ʹ�� N :û�б�ʹ��
	 
	@RequestMapping(value = "/checkLoginNameUnique", method = RequestMethod.GET)
	@ResponseBody
	public String checkMerLoginNameUnique(HttpServletRequest request,@RequestParam(value="loginName") String loginName) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerUser> merUserList= merUserManager.getByMerLoginName(mer.getId(), loginName);
		if (merUserList == null || merUserList.isEmpty()) {
			return "true";
		}
		return "false";
	}*/

	/**
	 * ��������
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request,ModelMap model) {
		Mer mer = new Mer();
		model.addAttribute(OBJ_MODEL, mer);
		model.addAllAttributes(VOConstantList.getMerUserTypeListModelMap());
		model.addAllAttributes(VOConstantList.getMerUserStatusListModelMap());
		return NEW_PAGE_VIEW;
	}

	/**
	 * ��������
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(Mer mer) throws Exception {
		platformManager.save(mer);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** ����༭ */
	@RequestMapping(value = "/edit/{id}")
	public String edit(HttpServletRequest request,@PathVariable(value="id")  long id,ModelMap model) throws Exception {
		model.addAttribute(OBJ_MODEL, platformManager.getById(id));
		model.addAllAttributes(VOConstantList.getMerUserTypeListModelMap());
		model.addAllAttributes(VOConstantList.getMerUserStatusListModelMap());
		return EDIT_PAGE_VIEW;
	}

	/** ������� */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam(value="id")  Integer id, Mer mer) throws Exception {
		platformManager.update(mer);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** ɾ�� */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") int id) {
		platformManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
}
