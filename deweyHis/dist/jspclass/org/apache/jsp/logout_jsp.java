package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/commons/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
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
      response.setContentType("text/html;charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

//     ${ctx}/login.do      <c:url value='/login.do'/>        ->  /demo/login.do    -->
//    <!DOCTYPE html   PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

      out.write("\r\n\r\n\r\n<html>\r\n\t<head>\r\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\" />\r\n\t\t<title>�˳�ϵͳ</title>\r\n\t</head>\r\n\t<body>\r\n\t\t<script>\r\n\t\t\talert('��ϲ�����˳�ϵͳ�ɹ���');\r\n\t\t   //  window.parent.close();\r\n\t\t   // window.location.href �����ҳ�������--���ҳ���㴰����ת  window.location.href\"��\"location.href\"�Ǳ�ҳ����ת\t\t   \r\n\t\t    window.top.location=\"index.jsp\";\r\n\t\t    //window.top //��㴰��   top.location.href\"��������ҳ����ת\t\t    \r\n\t\t\t//window.self //��ǰ���� \r\n\t\t\t//window.parent //��������  \"parent.location.href\"����һ��ҳ����ת\r\n\t\t    //      \"menubar=no,status=no,scrollbars=no,toolbar=no,location=no\"\r\n\t\t    // window.open(\"../login.jsp\",\"_blank\",\"scrollbars=no\");\r\n\t\t    /********\r\n\t\t    \t���A,B,C,D����jsp��D��C��iframe��C��B��iframe��B��A��iframe�����D��js����д \r\n\t\t\t\t\"window.location.href\"��\"location.href\"��Dҳ����ת\r\n\t\t\t\t\"parent.location.href\"��Cҳ����ת\r\n\t\t\t\t\"top.location.href\"��Aҳ����ת\r\n\t\t\t\t���Dҳ������form�Ļ�,\r\n\t\t\t\t<form>: form�ύ��Dҳ����ת\r\n\t\t\t\t<form target=\"_blank\">: form�ύ�󵯳���ҳ��\r\n\t\t\t\t<form target=\"_parent\">: form�ύ��Cҳ����ת\r\n\t\t\t\t<form target=\"_top\"> : form�ύ��Aҳ����ת\r\n\t\t\t\t����ҳ��ˢ�£�D ҳ��������д��\r\n");
      out.write("\t\t\t\t\"parent.location.reload();\": Cҳ��ˢ�� ����Ȼ��Ҳ����ʹ���Ӵ��ڵ� opener ��������ø����ڵĶ���window.opener.document.location.reload(); ��\r\n\t\t\t\t\"top.location.reload();\": Aҳ��ˢ��\r\n\t\t\t\t\r\n\t\t\t\t��ʹ�ÿ��ʱ��������Կ����ҳ�����ҳ����������������ֻ�Ǽ򵥵�����location. href=\"\",��ʹ������ҳ����ʾ���ӿ���У����³����ص���ܡ���ν���أ��ܼ򵥡�ֻҪָ���ӿ�ܵĸ������ҳ��������Ŀ��ҳ�漴�ɡ��� \r\n\t\t\t\twindow.top.framename.location.href = url;\r\n\t\t\t\twindow.parent.location.href=url;\r\n\t\t\t\tmainframe.location.href=url;\r\n\t\t    ********/\r\n\t\t</script>\r\n\t</body>\r\n</html>\r\n");
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
}
