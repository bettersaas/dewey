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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.service.MerRoleManager;
import com.dewey.his.sys.service.MerUserManager;

import common.base.constant.VOConstantList;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/merUser")
public class MerUserController  extends BaseController<MerUser, Long> {
	
	private MerUserManager merUserManager;

	public void setMerUserManager(MerUserManager merUserManager) {
		this.merUserManager = merUserManager;
	}
	
	/**
	 * ACTION视图
	 */
	private final String LIST_ACTION_VIEW      = pre_forward + "/merUser/list";         // 列表视图
	
	/**
	 * PAGE视图
	 */
	private final String LIST_PAGE_VIEW          = "/sys/merUser/list";           // 列表页面
	private final String NEW_PAGE_VIEW         = "/sys/merUser/new";        // 新增页面
	private final String EDIT_PAGE_VIEW          = "/sys/merUser/edit";         // 修改页面
	
	private final String LIST_MODEL          = "merUserList";
	private final String OBJ_MODEL           = "merUser";
	
	/**
	 * 商户角色
	 */
	private MerRoleManager merRoleManager;

	public void setMerRoleManager(MerRoleManager merRoleManager) {
		this.merRoleManager = merRoleManager;
	}
	
	private final String MER_ROLE_LIST_MODEL          = "merRoleList";
	
	@RequestMapping(value = "/list")
	public String index(HttpServletRequest request,ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerUser> merUserList =merUserManager.getMerAllUser(mer.getId());
		// 用户的类型和状态进行转码
		Map<String, String> typeMap = VOConstantList.getMerUserTypeMap();
		Map<String, String> statusMap = VOConstantList.getMerUserStatusMap();
		for(MerUser merUser : merUserList) {
			merUser.setType(typeMap.get(merUser.getType()));
			merUser.setStatus(statusMap.get(merUser.getStatus()));
		}
		model.addAttribute(LIST_MODEL,  merUserList);
		return LIST_PAGE_VIEW;
	}
	
	/**
	 * Ajax 检测登录名是否存在  Y: 已使用 N :没有被使用
	 */
	@RequestMapping(value = "/checkLoginNameUnique", method = RequestMethod.GET)
	@ResponseBody
	public String checkMerLoginNameUnique(HttpServletRequest request,@RequestParam(value="loginName") String loginName) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerUser> merUserList= merUserManager.getByMerLoginName(mer.getId(), loginName);
		if (merUserList == null || merUserList.isEmpty()) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request,ModelMap model) {
		MerUser merUser = new MerUser();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		merUser.setMer(mer);
		model.addAttribute(OBJ_MODEL, merUser);
		model.addAllAttributes(VOConstantList.getMerUserTypeListModelMap());
		model.addAllAttributes(VOConstantList.getMerUserStatusListModelMap());
		model.addAttribute(MER_ROLE_LIST_MODEL, merRoleManager.getMerAllRole(mer.getId()));
		return NEW_PAGE_VIEW;
	}

	/**
	 * 保存新增
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(MerUser merUser) throws Exception {
		merUserManager.save(merUser);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** 进入编辑 */
	@RequestMapping(value = "/edit/{id}")
	public String edit(HttpServletRequest request,@PathVariable(value="id")  long id,ModelMap model) throws Exception {
		model.addAttribute(OBJ_MODEL, merUserManager.getById(id));
		model.addAllAttributes(VOConstantList.getMerUserTypeListModelMap());
		model.addAllAttributes(VOConstantList.getMerUserStatusListModelMap());
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		model.addAttribute(MER_ROLE_LIST_MODEL, merRoleManager.getMerAllRole(mer.getId()));
		return EDIT_PAGE_VIEW;
	}

	/** 保存更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam(value="id")  Integer id, MerUser merUser) throws Exception {
		merUserManager.update(merUser);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** 删除 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") int id) {
		merUserManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
}
