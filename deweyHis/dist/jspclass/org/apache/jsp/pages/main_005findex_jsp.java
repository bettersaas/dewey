package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/commons/taglibs.jsp");
    _jspx_dependants.add("/commons/meta.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=GB18030");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

//     ${ctx}/login.do      <c:url value='/login.do'/>        ->  /demo/login.do    -->
//    <!DOCTYPE html   PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

      out.write("\r\n<HTML>\r\n<HEAD>\r\n<TITLE>个人桌面</TITLE>\r\n");
      out.write('\r');
      out.write('\n');

	String path         = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath", basePath);
	// document.form1.action="${pageContext.request.contextPath}/"; 

      out.write("\r\n\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\" />\r\n\t<meta http-equiv=\"Cache-Control\" content=\"no-cache\"/>\r\n\t<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n\t<meta http-equiv=\"Expires\" content=\"0\"/>\r\n\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/favicon.ico\" type=\"image/x-icon\">\r\n\t<link  rel=\"stylesheet\"  type=\"text/css\"  href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n\t<script src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n\t<script src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"  type=\"text/javascript\"></script>");
      out.write("\r\n<LINK rel=stylesheet  href=\"styles/putong_1t.css\">\r\n<STYLE TYPE=\"text/css\">\r\n<!--\r\ntd.grzmRow\r\n{\r\n\tpadding:0px 4px 0px 4px;\t  \r\n}\r\ntd.grzmList\r\n{\r\n\tpadding:0px 4px 0px 0px;\t  \r\n}\r\nbody\r\n{\r\n\tbackground-color:#EBF1FA;\r\n}\r\n-->\r\n</style>\r\n<title>个人桌面</title>\r\n</HEAD>\r\n<BODY>\r\n<div id=\"proc\" name=\"proc\">\t\t\r\n\t\t\t<table width=\"300\" height=\"40\" align=\"center\" cellpadding=\"10\" class=\"tableframe\">\r\n\t\t\t<tr align=\"center\" class=\"listtitle\"><td valign=\"center\" class=\"listcelltitle\">\r\n\t\t\t正在装载桌面信息，请稍候.... ...\r\n\t\t\t</td></tr>\r\n\t\t\t</table>\t\t\t\r\n</div>\t\r\n<div class=\"TitleBar\">\r\n我的桌面\r\n</div>\r\n<div align=\"center\"> \r\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"98%\" style=\"margin:0px 0px 0px 0px\">\r\n    <tr> \r\n      <td width=\"73%\" height=\"423\"> \r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"margin:0px 0px 0px 0px\">\r\n          <tr> \r\n            <td width=\"23\" align=\"left\" class=\"grzmList\"><img src=\"images/list_wdgz.gif\" width=\"16\" height=\"16\"></td>\r\n            <td width=\"669\" align=\"left\"><div class=\"TableTitleText\"><nobr>待办事宜</nobr></div></td>\r\n");
      out.write("            <td width=\"78\" align=\"right\"><nobr><a href=\"../lkcrm/gsjj/gongsijianjie_dlh.asp\">更多...</a></nobr></td>\r\n          </tr>\r\n          <tr> \r\n            <td colspan=\"3\"> <div align=\"left\"> \r\n                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\" width=\"100%\" class=\"tabletoolbar\">\r\n                  <tr> \r\n                    <td></td>\r\n                  </tr>\r\n                </table>\r\n                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\" width=\"100%\">\r\n                  <tr> \r\n                    <td width=\"100%\"  height=\"120\" class=\"grzmRow\"> 此处添加待办连接 </td>\r\n                  </tr>\r\n                </table>\r\n              </div></td>\r\n          </tr>\r\n        </table>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"margin:0px 0px 0px 0px\">\r\n          <tr> \r\n            <td width=\"22\" align=\"left\" class=\"grzmList\"> <img src=\"images/list_srtx.gif\" width=\"16\" height=\"16\"> \r\n            </td>\r\n");
      out.write("            <td width=\"678\" align=\"left\"> <div class=\"TableTitleText\"><nobr>最新通知</nobr></div></td>\r\n            <td width=\"70\"><div align=\"right\"><a href=\"../lkcrm/gsjj/gongsijianjie_dlh.asp\">更多...</a></div></td>\r\n          </tr>\r\n          <tr> \r\n            <td colspan=\"3\"> <div align=\"left\"> \r\n                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\" width=\"100%\" class=\"tabletoolbar\">\r\n                  <tr> \r\n                    <td></td>\r\n                  </tr>\r\n                </table>\r\n                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\" width=\"100%\">\r\n                  <tr> \r\n                    <td width=\"100%\"  height=\"120\" class=\"grzmRow\"> 此处添加通知连接 </td>\r\n                  </tr>\r\n                </table>\r\n              </div></td>\r\n          </tr>\r\n        </table>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"margin:0px 0px 0px 0px\">\r\n          <tr> \r\n            <td width=\"21\" align=\"left\" class=\"grzmList\"> <img src=\"images/list_zxxx.gif\" width=\"16\" height=\"16\"> \r\n");
      out.write("            </td>\r\n            <td align=\"left\" width=\"679\"> <div class=\"TableTitleText\"><nobr>最新房态</nobr></div></td>\r\n            <td align=\"right\" width=\"70\"><nobr><a href=\"../lkcrm/gsjj/xsdzzzlb_dlh.asp\">更多...</a></nobr></td>\r\n          </tr>\r\n          <tr> \r\n            <td colspan=\"3\"> <div align=\"left\"> \r\n                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\" width=\"100%\" class=\"tabletoolbar\">\r\n                  <tr> \r\n                    <td></td>\r\n                  </tr>\r\n                </table>\r\n                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\" width=\"100%\">\r\n                  <tr> \r\n                    <td width=\"100%\"  height=\"120\" class=\"grzmRow\"> 邮件链接</td>\r\n                  </tr>\r\n                </table>\r\n              </div></td>\r\n          </tr>\r\n        </table></td>\r\n      <td width=\"25%\" valign=\"top\"> \r\n        <div align=\"right\">\r\n          <table width=\"90%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr> \r\n              <td colspan=\"2\"><img src=\"images/list_srtx.gif\" width=\"16\" height=\"16\"></td>\r\n              <td width=\"87%\"> <div class=\"TableTitleText\"> <nobr>天气预报</nobr> \r\n                </div>\r\n                <div align=\"right\"></div></td>\r\n            </tr>\r\n            <tr> \r\n              <td height=\"150\" colspan=\"3\"><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\"  class=\"tableFrame\">\r\n                  <tr>\r\n                    <td>&nbsp;<iframe name=\"weather_inc\" src=\"http://tianqi.xixik.com/cframe/2\" width=\"290\" height=\"70\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\"></iframe></td>\r\n                  </tr>\r\n                </table></td>\r\n            </tr>\r\n            <tr> \r\n              <td colspan=\"3\"><div align=\"right\"><a href=\"#\">更多&gt;&gt;</a></div></td>\r\n            </tr>\r\n            <tr> \r\n              <td width=\"12%\"><img src=\"images/list_cylj.gif\" width=\"16\" height=\"16\"></td>\r\n              <td colspan=\"2\"><div class=\"TableTitleText\"> <nobr>常用链接</nobr> </div></td>\r\n");
      out.write("            </tr>\r\n            <tr> \r\n              <td height=\"201\" colspan=\"3\"><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin:0px 0px 0px 0px\"  class=\"tableFrame\">\r\n                  <tr>\r\n                    <td>&nbsp;火车票查询</td>\r\n                  </tr>\r\n\t\t\t\t   <tr>\r\n                    <td>&nbsp;航班查询</td>\r\n                  </tr>\r\n\t\t\t\t   <tr>\r\n                    <td>&nbsp;星火旅行社</td>\r\n                  </tr>\r\n\t\t\t\t   <tr>\r\n                    <td>&nbsp;星火酒店用品网</td>\r\n                  </tr>\r\n                </table></td>\r\n            </tr>\r\n            <tr>\r\n              <td height=\"18\" colspan=\"3\"><div align=\"right\"><a href=\"#\">更多&gt;&gt;</a></div></td>\r\n            </tr>\r\n          </table>\r\n        </div></td>\r\n    </tr>\r\n  </table>\r\n</div>\r\n<script language=\"vbscript\">\r\n\tdocument.getElementById(\"proc\").style.display = \"none\"\r\n</script>\r\n</BODY>\r\n</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /commons/taglibs.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /commons/taglibs.jsp(8,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /commons/meta.jsp(14,49) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/styles/txz.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /commons/meta.jsp(15,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/scripts/application.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /commons/meta.jsp(16,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/scripts/jquery/jquery-1.6.1.min.js");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }
}
