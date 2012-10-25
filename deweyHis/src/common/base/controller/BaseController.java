package common.base.controller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BaseController<Entity, PK> extends MultiActionController {
	
	protected Logger consoleLogger = Logger.getLogger("console");
	
	protected Logger fileLogger = Logger.getLogger("fileLog");
	
	/**
	 * Forward：
	 * 通过在controller的HttpServletRequest实例：
	 *    request.getRequestDispatcher(this.getViewFilename()).forward(request, response);
	 * 
	 * 注意：forward是针对context root的
	 */
	protected  static String  pre_forward = "forward:";     // forward:url
	
	// 
	/**
	 * Redirect的两种方式：
	 *通过在controller的new ModelAndView：
	 *    return new ModelAndView(new RedirectView(this.getViewFilename()));
	 * 通过在controller中使用HttpServletResponse实例：
	 *    response.sendRedirect(this.getViewFilename());
	 *    return null;
	 *
	 *注意：redirect是针对document root的
	 */
	protected  static String  pre_redirect = "redirect:";      // redirect:url
	
	
	/**
	 * 空白页面
	 */
	protected static String  newBlank =  "/commons/newBlank.jsp";
	
	
//	protected BindException bindObject(HttpServletRequest request, Object command, Validator validator) throws Exception {
//		ServletRequestDataBinder binder = createBinder(request, command);
//		binder.bind(request);
//		BindException errors = new BindException(command, getCommandName(command));
//		if (validator.supports(command.getClass())) {
//			ValidationUtils.invokeValidator(validator, command, errors);
//		}
//		return errors;
//	}

//	@RequestMapping
//	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Entity model) {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 进入新增 */
//	@RequestMapping(value = "/new")
//	public ModelAndView _new(HttpServletRequest request, HttpServletResponse response, Entity model) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 显示 */
//	@RequestMapping(value = "/{id}")
//	public ModelAndView show(@PathVariable
//	PK id) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 编辑 */
//	@RequestMapping(value = "/{id}/edit")
//	public ModelAndView edit(@PathVariable
//	PK id) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 保存新增 */
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView create(HttpServletRequest request, HttpServletResponse response, Entity model) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 保存更新 */
//	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
//	// method = RequestMethod.PUT
//	public ModelAndView update(@PathVariable
//	PK id, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 删除 */
//	@RequestMapping(value = "/{id}")
//	// method = RequestMethod.DELETE
//	public ModelAndView delete(@PathVariable
//	PK id) {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** 批量删除 */
//	@RequestMapping()
//	// method = RequestMethod.DELETE
//	public ModelAndView batchDelete(@RequestParam("items")
//	PK[] items) {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/**
//	 * url定向
//	 * 
//	 * @param url
//	 * @param request
//	 * @return
//	 */
//	public ModelAndView toModelAndView(String url) {
//		return new ModelAndView(url);
//	}
//
//	/**
//	 * 获取国际化资源标签
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public String getMessageResByKey(String key) {
//		try {
//			return this.getMessageSourceAccessor().getMessage(key);
//		} catch (Exception ex) {
//			return key;
//		}
//	}
}
