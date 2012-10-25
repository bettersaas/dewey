package org.apache.jsp.commons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class pager1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\r\n\r\n\r\n");

//			<c:import url="/commons/pager1.jsp" charEncoding="GBK">
//				<c:param name="submitAction" 	value="action.do"/>
//				<c:param name="pageCount"    	value="12"/>
//			</c:import>
//			使用说明：
//				submitAction		必须参数	页面提交action值
//				countAll             必须参数	  记录总数
//				pageCount 		必须参数  记录总页数，查询得出
//				checkboxName	可选参数	全选\全不选\反选按钮的操作对象名（即复选框名）

      out.write("\r\n<style type=\"text/css\">\r\n<!--\r\n.style1 {font-size: 14px}\r\n-->\r\n</style>\r\n<form name=\"pagerForm1\" method=\"post\" action=\"\">\r\n\t");

		Enumeration enum1=request.getParameterNames();
		while(enum1.hasMoreElements())
		{
			String parameterName=(String)enum1.nextElement();
			if(!parameterName.equals("pageNo2") && !parameterName.equals("pageCount"))
				out.println("<input type=\"hidden\" name=\""+parameterName+"\" id=\""+parameterName+"\" value=\""+request.getParameter(parameterName)+"\">");
		}
	
      out.write("\r\n\t<input type=\"hidden\" name=\"pageCount\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.pageCount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n<table id=\"pagerTable\" align=\"center\" width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tbody>\r\n\t<tr height=\"35px\">\r\n\t\t<td id=\"td1\" align=\"center\" valign=\"middle\">\r\n\t\t\t");
 
				String checkboxName		=	request.getParameter("checkboxName");
			
      out.write("\r\n\t\t\t<script language=\"javascript\">checkboxName=\"");
      out.print(checkboxName );
      out.write("\" ;</script>\r\n\t\t\t");

					if(checkboxName!=null && !"".equals(checkboxName.trim()) )
					{
			 
      out.write("\r\n\t\t\t<script language=\"javascript\">\r\n\t\t\t\tvar ids = eval(\"document.getElementsByName('\"+checkboxName+\"')\");\r\n\t\t\t\tif(ids!=undefined)\r\n\t\t\t\t{\r\n\t\t\t\t\tdocument.write(\"『<a href='javascript:setChecked()'>全选</a>』『<a href='javascript:setUnChecked()'>全不选</a>』『<a href='javascript:setReverse()'>反选</a>』&nbsp;&nbsp;&nbsp;&nbsp;\");\r\n\t\t\t\t}\r\n\t\t\t\tfunction setChecked()\r\n\t\t\t\t{ \r\n\t\t\t\t\tvar targetLength=ids.length;\r\n\t\t\t\t\tif(isNaN(parseInt(targetLength)))\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\tif(eval(\"document.getElementsByName('\"+checkboxName+\"').disabled == false\"))\r\n\t\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"').checked=true;\");\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\tfor(var i=0;i<targetLength;i++)\r\n\t\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\tif(eval(\"document.getElementsByName('\"+checkboxName+\"')[i].disabled == false\"))\r\n\t\t\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\t   eval(\"document.getElementsByName('\"+checkboxName+\"')[i].checked=true;\");\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t    }\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t\r\n\t\t\t\t}\r\n\t\t\t\tfunction setUnChecked()\r\n\t\t\t\t{\r\n\t\t\t\t\tvar targetLength=ids.length;\r\n\t\t\t\t\tif(isNaN(parseInt(targetLength)))\r\n");
      out.write("\t\t\t\t\t{\r\n\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"').checked=false;\");\r\n\t\t\t\t\t}\r\n\t\t\t\t\telse\r\n\t\t\t\t\t{\r\n\t\t\t\t\t\tfor(var i=0;i<targetLength;i++)\r\n\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"')[i].checked=false;\");\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\tfunction setReverse()\r\n\t\t\t\t{\r\n\t\t\t\t\t\tvar targetLength=ids.length;\r\n\t\t\t\t\t\tif(isNaN(parseInt(targetLength)))\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\tvar temp=eval(\"document.getElementsByName('\"+checkboxName+\"').checked\");\r\n\t\t\t\t\t\t\tif(temp==true)\r\n\t\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"').checked=false;\");\r\n\t\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"').checked=true;\");\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t\telse\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\tfor (var i=0;i<targetLength;i++)\r\n\t\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t \tvar temp=eval(\"document.getElementsByName('\"+checkboxName+\"')[i].checked\");\r\n\t\t\t\t\t\t\t \tif(temp==true)\r\n\t\t\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"')[i].checked=false;\");\r\n\t\t\t\t\t\t\t\telse \r\n\t\t\t\t\t\t\t\t\teval(\"document.getElementsByName('\"+checkboxName+\"')[i].checked=true;\");\r\n\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t</script>\r\n\t\t\t");
 } 
      out.write("\r\n\t\t\t<script language=\"javascript\">document.write(\"合计 \" + pagerForm1.countAll.value + \" 条 \");</script>\r\n\t\t\t<script language=\"javascript\">document.write(\"共 \" + pagerForm1.pageCount.value + \" 页 \");</script>\r\n\t\t\t<script language=\"javascript\">document.write(\"第 \" + pagerForm1.pageNo.value + \" 页 \");</script>\r\n\t\t\t<script language=\"javascript\">document.write(pagerForm1.pageSize.value + \"/页 \");</script>\r\n\t\t\t<input type=button name=\"prevPage\" value=\"上一页\" onclick=\"prevSub()\" class=\"button3\">\r\n\t\t\t<input type=button name=\"nextPage\" value=\"下一页\" onclick=\"NextSub()\" class=\"button3\">\r\n\t\t\t<input type=button name=\"jump\" value=\"跳至\" onclick=\"jumpTo()\" class=\"button3\">\r\n\t\t\t<span>&nbsp;第<input name=\"pageNo2\" id=\"pageNo2\" style=\"text-align:center\" value=\"");
      out.print(request.getParameter("pageNo"));
      out.write("\" size=\"2\" onKeyPress=\"javascript:isEnterPress();\"></span>&nbsp;页\r\n\t\t</td>\r\n\t</tr>\r\n  </tbody>\r\n</table>\r\n</form>\r\n<script language=\"javascript\">\r\n\tif(parseInt(document.pagerForm1.pageNo.value)-1<1)\r\n\t{\r\n\t\tdocument.pagerForm1.prevPage.disabled=true;\r\n\t}\r\n\tif((document.pagerForm1.pageNo2.value) >= parseInt(pagerForm1.pageCount.value) || pagerForm1.pageCount.value==\"\" || pagerForm1.pageCount.value==\"0\")\r\n\t{\r\n\t\tdocument.pagerForm1.nextPage.disabled=true;\r\n\t}\r\n\tif(document.pagerForm1.prevPage.disabled==true&&document.pagerForm1.nextPage.disabled==true)\r\n\t{\r\n\t\tdocument.pagerForm1.jump.disabled=true;\r\n\t}\r\n\tif(document.pagerForm1.jump.disabled==true)\r\n\t{\r\n\t\tdocument.pagerForm1.pageNo2.disabled=true;\r\n\t}\r\n\tfunction prevSub()\r\n\t{\r\n\t   if(parseInt(document.pagerForm1.pageNo.value)>1)\r\n\t   {\r\n\t\t document.pagerForm1.pageNo.value=parseInt(document.pagerForm1.pageNo.value)-1;\r\n\t\t pagerForm1.action=pagerForm1.submitAction.value;\r\n\t\t pagerForm1.submit();\r\n\t   } \r\n\t}\r\n\tfunction NextSub()\r\n\t{ \r\n\t\t if(parseInt(document.pagerForm1.pageNo.value) < parseInt(pagerForm1.pageCount.value))\r\n");
      out.write("\t\t {\r\n\t\t \tdocument.pagerForm1.pageNo.value=parseInt(document.pagerForm1.pageNo.value)+1;\r\n\t\t \tpagerForm1.action=pagerForm1.submitAction.value;\r\n\t\t \tpagerForm1.submit();\r\n\t\t }\r\n\t}\r\n\tfunction jumpTo()\r\n\t{\r\n\t\tvar pageNo=document.pagerForm1.pageNo2.value;\r\n\t\tif(pageNo.match(/^[1-9]\\d*$/)==null)\r\n\t\t{\r\n\t\t\talert(\"您输入的页数不存在！\");\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(parseInt(document.pagerForm1.pageNo2.value) > parseInt(pagerForm1.pageCount.value))\r\n\t\t{\r\n\t\t\talert(\"您输入的页数不存在！\");\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tdocument.pagerForm1.pageNo.value=document.pagerForm1.pageNo2.value;\r\n\t\t pagerForm1.action=pagerForm1.submitAction.value;\r\n\t\t pagerForm1.submit();\r\n\t}\r\n\tfunction isEnterPress()\r\n\t{\r\n\t\tif(event.keyCode == 13)\r\n\t\t\tjumpTo();\r\n\t}\r\n\r\n\tdocument.onkeydown=function splitPage(){if(event.keyCode==33){prevSub();}if(event.keyCode==34){NextSub();}}\r\n</script>");
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
}
