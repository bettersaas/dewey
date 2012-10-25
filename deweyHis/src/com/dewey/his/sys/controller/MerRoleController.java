package com.dewey.his.sys.controller;

import java.util.List;

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
import com.dewey.his.common.util.Constant;
import com.dewey.his.sys.model.MerRole;
import com.dewey.his.sys.service.MerRoleManager;

import common.base.constant.VOConstantList;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/merRole")
public class MerRoleController  extends BaseController<MerRole, Long> {
	
	private MerRoleManager merRoleManager;

	public void setMerRoleManager(MerRoleManager merRoleManager) {
		this.merRoleManager = merRoleManager;
	}
	
	/**
	 * ACTION视图
	 */
	private final String LIST_ACTION_VIEW      = pre_forward + "/merRole/list";         // 列表视图
	
	/**
	 * PAGE视图
	 */
	private final String LIST_PAGE_VIEW          = "/sys/merRole/list";           // 列表页面
	private final String NEW_PAGE_VIEW         = "/sys/merRole/new";        // 新增页面
	private final String EDIT_PAGE_VIEW          = "/sys/merRole/edit";         // 修改页面
	
	private final String LIST_MODEL          = "merRoleList";
	private final String OBJ_MODEL           = "merRole";
	
	/**
	 * 系统功能JSON串
	 */
	private final String SYS_FUNCTIONS_JSON = "SysFunctionJson";
	
	@RequestMapping(value = "/list")
	public String index(HttpServletRequest request,ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		model.addAttribute(LIST_MODEL,  merRoleManager.getMerAllRole(mer.getId()));
		return LIST_PAGE_VIEW;
	}

	/**
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request,ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		MerRole merRole = new MerRole();
		merRole.setMer(mer);
		model.addAttribute(OBJ_MODEL, merRole);
		model.addAttribute(SYS_FUNCTIONS_JSON, Constant.getFunctionsTreeConstantJson());
		model.addAllAttributes(VOConstantList.getMerRoleReadwriteListModelMap());
		return NEW_PAGE_VIEW;
	}
	
	/**
	 * Ajax 检测角色名是否存在  Y: 已使用 N :没有被使用
	 */
	@RequestMapping(value = "/checkMerRoleNameUnique", method = RequestMethod.GET)
	@ResponseBody
	public String checkMerRoleNameUnique(HttpServletRequest request,@RequestParam(value="roleName")  String roleName) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerRole> merRoleList= merRoleManager.getByMerRoleName(mer.getId(), roleName);
		if (merRoleList == null || merRoleList.isEmpty()) {
			return "true";
		}
		return "false";
	}

	/**
	 * 保存新增
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(MerRole merRole) throws Exception {
		merRoleManager.save(merRole);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** 进入编辑 */
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value="id")  long id,ModelMap model) throws Exception {
		model.addAttribute(OBJ_MODEL, merRoleManager.getById(id));
		model.addAttribute(SYS_FUNCTIONS_JSON, Constant.getFunctionsTreeConstantJson());
		model.addAllAttributes(VOConstantList.getMerRoleReadwriteListModelMap());
		return EDIT_PAGE_VIEW;
	}

	/** 保存更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(MerRole merRole) throws Exception {
		merRoleManager.update(merRole);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** 删除 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") int id) {
		merRoleManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
}
