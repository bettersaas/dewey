package common.base.controller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BaseController<Entity, PK> extends MultiActionController {
	
	protected Logger consoleLogger = Logger.getLogger("console");
	
	protected Logger fileLogger = Logger.getLogger("fileLog");
	
	/**
	 * Forward��
	 * ͨ����controller��HttpServletRequestʵ����
	 *    request.getRequestDispatcher(this.getViewFilename()).forward(request, response);
	 * 
	 * ע�⣺forward�����context root��
	 */
	protected  static String  pre_forward = "forward:";     // forward:url
	
	// 
	/**
	 * Redirect�����ַ�ʽ��
	 *ͨ����controller��new ModelAndView��
	 *    return new ModelAndView(new RedirectView(this.getViewFilename()));
	 * ͨ����controller��ʹ��HttpServletResponseʵ����
	 *    response.sendRedirect(this.getViewFilename());
	 *    return null;
	 *
	 *ע�⣺redirect�����document root��
	 */
	protected  static String  pre_redirect = "redirect:";      // redirect:url
	
	
	/**
	 * �հ�ҳ��
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
//	/** �������� */
//	@RequestMapping(value = "/new")
//	public ModelAndView _new(HttpServletRequest request, HttpServletResponse response, Entity model) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** ��ʾ */
//	@RequestMapping(value = "/{id}")
//	public ModelAndView show(@PathVariable
//	PK id) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** �༭ */
//	@RequestMapping(value = "/{id}/edit")
//	public ModelAndView edit(@PathVariable
//	PK id) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** �������� */
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView create(HttpServletRequest request, HttpServletResponse response, Entity model) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** ������� */
//	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
//	// method = RequestMethod.PUT
//	public ModelAndView update(@PathVariable
//	PK id, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** ɾ�� */
//	@RequestMapping(value = "/{id}")
//	// method = RequestMethod.DELETE
//	public ModelAndView delete(@PathVariable
//	PK id) {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/** ����ɾ�� */
//	@RequestMapping()
//	// method = RequestMethod.DELETE
//	public ModelAndView batchDelete(@RequestParam("items")
//	PK[] items) {
//		throw new UnsupportedOperationException("not yet implement");
//	}
//
//	/**
//	 * url����
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
//	 * ��ȡ���ʻ���Դ��ǩ
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
