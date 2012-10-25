package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/commons/taglibs.jsp");
    _jspx_dependants.add("/commons/meta.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
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

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

//     ${ctx}/login.do      <c:url value='/login.do'/>        ->  /demo/login.do    -->
//    <!DOCTYPE html   PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("\r\n<html>\r\n<head>\r\n\t<title>登陆</title>\r\n\t");
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
      out.write("\r\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB18030\">\r\n\t<meta http-equiv=\"keywords\" content=\"deweyHis,登录\">\r\n\t<meta http-equiv=\"description\" content=\"登录首页\">\r\n\t<script language=\"javascript\">\r\n\t<!--\r\n\t\t\t//如果浏览器不是ie4+或ns6+\r\n\t\t\tif (typeof navigator.cookieEnabled==\"undefined\" && !cookieEnabled){ \r\n\t\t\t\tdocument.cookie=\"testcookie\";\r\n\t\t\t\tcookieEnabled=(document.cookie==\"testcookie\")? true : false;\r\n\t\t\t\tdocument.cookie=\"\";\r\n\t\t\t}\r\n\t\t\tif(cookieEnabled) {\r\n\t\t\t\tsetCookie(\"test\",\"test\");\r\n\t\t\t\tif(getCookie(\"test\") != \"test\") {\r\n\t\t\t\t\tcookieEnabled=false;\r\n\t\t\t\t} \r\n\t\t\t\tdelCookie(\"test\");\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\t// 初始化页面的显示数据\r\n\t\t\tfunction initUserInfo() {\r\n\t\t\t\tvar userNotRember = getCookie(\"user_noremember\");\r\n\t\t\t\tif (userNotRember == \"true\") {\r\n\t\t\t\t\twindow.document.form1.remUser.checked = false;\r\n\t\t\t\t\twindow.document.form1.loginName.autocomplete=\"off\";\r\n\t\t\t\t} else {\r\n\t\t\t\t\twindow.document.form1.loginName.autocomplete=\"on\";\r\n\t\t\t\t\twindow.document.form1.loginName.value= getCookie(\"loginName\");\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t\t///////////////////////////////////////////////////////////////////////////\r\n");
      out.write("\t\t\t\r\n\t\t\t//屏蔽F1帮助\r\n\t\t\tfunction window.onhelp(){\r\n\t\t\t\treturn false\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\t//屏蔽键盘所有键\r\n\t\t\tfunction document.onkeydown(){\r\n\t\t\t\tevent.keyCode = 0;\r\n\t\t\t\tevent.returnvalue = false;\r\n\t\t\t}\r\n\t\t\r\n\t\t\t//屏蔽鼠标右键、Ctrl+n、shift+F10、F5刷新、退格键\r\n\t\t\tdocument.onkeydown=function(){\r\n\t\t\t\tvar event = arguments[0]||window.event; \r\n\t\t\t\tvar currentKey = event.charCode||event.keyCode;\r\n\t\t\t\t//alert(currentKey);\r\n\t\t\t\t//alert(\"ASCII代码是：\"+event.keyCode);\r\n\t\t\t\tif ((window.event.altKey)&&\r\n\t\t\t\t((window.event.keyCode==37)|| //屏蔽 Alt+ 方向键 ←\r\n\t\t\t\t(window.event.keyCode==39))){ //屏蔽 Alt+ 方向键 →\r\n\t\t\t\t\talert(\"不准你使用ALT+方向键前进或后退网页！\");\r\n\t\t\t\t\tevent.returnValue=false;\r\n\t\t\t\t}\r\n\t\t\t\r\n\t\t\t\tif ((event.keyCode == 8) && \r\n\t\t\t\t(event.srcElement.type != \"text\" && \r\n\t\t\t\tevent.srcElement.type != \"textarea\" && \r\n\t\t\t\tevent.srcElement.type != \"password\") || //屏蔽退格删除键\r\n\t\t\t\t(event.keyCode==116)||    //屏蔽 F5 刷新键\r\n\t\t\t\t(event.keyCode==112)||    //屏蔽 F1 刷新键\r\n\t\t\t\t(event.keyCode==122)||    //屏蔽F11 最大化\r\n\t\t\t\t(event.ctrlKey && event.keyCode==82)){ //Ctrl + R\r\n\t\t\t\t\tevent.keyCode=0;\r\n");
      out.write("\t\t\t\t\tevent.cancelBubble=true;\r\n\t\t\t\t\tevent.returnValue=false;\r\n\t\t\t\t}\r\n\t\t\t\r\n\t\t\t\tif ((event.ctrlKey)&&(event.keyCode==78)) //屏蔽 Ctrl+n\r\n\t\t\t\t\tevent.returnValue=false;\r\n\t\t\t\r\n\t\t\t\tif ((event.shiftKey)&&(event.keyCode==121)) //屏蔽 shift+F10\r\n\t\t\t\t\tevent.returnValue=false;\r\n\t\t\t\r\n\t\t\t\tif ((event.altKey)&&(event.keyCode==115)){ //屏蔽Alt+F4\r\n\t\t\t\t\twindow.showModelessDialog(\"about:blank\",\"\",\"dialogWidth:1px;dialogheight:1px\");\r\n\t\t\t\t\treturn false;\r\n\t\t\t\t}\r\n\t\t\t\r\n\t\t\t\tif (window.event.srcElement.tagName.toUpperCase() == \"A\" && window.event.shiftKey)\r\n\t\t\t\t\twindow.event.returnValue = false; //屏蔽 shift 加鼠标左键新开一网页\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\t//禁止右键弹出菜单,里面还有一个刷新.. \r\n\t\t\tfunction document.oncontextmenu()   \r\n\t\t\t{\r\n\t\t\t\tevent.cancelBubble = true;\r\n\t\t\t\tevent.returnValue = false; \r\n\t\t\t\treturn false; \r\n\t\t\t}\r\n\t//-->\r\n\t</SCRIPT>\r\n\t<script language=\"JavaScript\" type=\"text/JavaScript\"> \r\n\t<!--\r\n\t\tfunction formSubmit()\r\n\t\t{\r\n\t\t\tif(isEmpty(form1.deweyNo)) {\r\n\t\t\t\twindow.alert(\"请输入杜威号!\") ;\r\n\t\t\t\tform1.deweyNo.focus();\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tif(isEmpty(form1.loginName)) {\r\n");
      out.write("\t\t\t\twindow.alert(\"请填写用户名!\") ;  \r\n\t\t\t\tform1.loginName.focus(); \r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tif(isEmpty(form1.password)) {\r\n\t\t\t\twindow.alert(\"请填写密码!\") ;  \r\n\t\t\t\tform1.password.focus(); \r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tif(isEmpty(form1.checkCode)) {\r\n\t\t\t\twindow.alert(\"请填写验证码!\") ;  \r\n\t\t\t\tform1.checkCode.focus(); \r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\r\n\t\t\tdocument.form1.action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/login\"; \r\n\t\t\tdocument.form1.target=\"_self\";     // _blank\r\n\t\t\treturn true;\r\n\t\t}\r\n\t\t\r\n\t\t//  等同于document.forms[0].reset();\r\n\t\tfunction resetNameAndPassword() \r\n\t\t{ \r\n\t\t\tdocument.form1.loginName.value=\"\"; \r\n\t\t\tdocument.form1.password.value=\"\"; \r\n\t\t\tdocument.form1.checkCode.value=\"\"; \r\n\t\t\tdocument.form1.loginName.focus(); \r\n\t\t\treturn false; \r\n\t\t} \r\n\t\t\r\n\t\t// 卸载页面-方法是在关闭窗口之后执行 页面关闭、刷新、转向新页面 时都触发\r\n\t\tfunction window.onunload(){\r\n\t\t}\r\n\t\t\r\n\t\t/*验证码上刷新 */\r\n\t\tfunction chkImage(){\r\n\t\t     var img = document.getElementById(\"checkCodeImg\");\r\n\t\t     img.src = \"checkCode.gif?\" + getRandom();\r\n\t\t}\r\n\t\t//-->\r\n\t</script>\r\n\t\r\n\t<style type=\"text/css\"> \r\n\r\n\t</style>\r\n</head>\r\n<body>\r\n<input type=\"hidden\"  id=\"retMsg\"  name=\"retMsg\" value=\"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\" >\r\n<DIV class=main2>\r\n<DIV id=blk></DIV>\r\n<DIV id=top2>\r\n<DIV class=logo2><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/txzlogo2.gif\"></DIV>\r\n<DIV class=txt2><A  onclick=\"this.style.behavior='url(#default#homepage)';this.setHomePage('#');return false;\"  href=\"javascript:;\" target=_self>设为首页</A> | <A href=\"login.htm\">SAAS系统</A> | <A href=\"#\">联系我们</A> | <A  href=\"#\">技术支持</A> | <A href=\"#\">帮助中心</A></DIV></DIV>\r\n<DIV class=lglf>\r\n<DIV id=conlf2>\r\n<DIV id=line2></DIV>\r\n<DIV id=box22>\r\n<DIV class=boxpic2><IMG style=\"MARGIN-TOP: 5px\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/pic01.gif\"></DIV>\r\n<DIV class=boxtxt2><A style=\"COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold\" href=\"#\">关于杜威</A><BR>关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威... &raquo;</DIV></DIV>\r\n<DIV id=box22>\r\n<DIV class=boxpic2><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/pic02.gif\"></DIV>\r\n<DIV class=boxtxt2><A style=\"COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold\" href=\"#\">加入杜威SAAS</A><BR>加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS... &raquo;</DIV></DIV>\r\n<DIV id=box22>\r\n<DIV class=boxpic2><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/pic03.gif\"></DIV>\r\n<DIV class=boxtxt2><A style=\"COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold\"  href=\"#\">杜威在线咨询</A><BR>杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询... &raquo;</DIV></DIV>\r\n<DIV id=box22>\r\n<DIV class=boxpic2><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/pic04.gif\"></DIV>\r\n<DIV class=boxtxt2><A style=\"COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold\" href=\"#\">杜威saas文档下载</A><BR>杜威saas文档下载杜威saas文档下载杜威saas文档下载杜威saas文档下载杜威saas文档下载...&raquo;</DIV></DIV></DIV>\r\n<DIV id=conrt2>\r\n<DIV id=rt2tp></DIV>\r\n<FORM id=\"form1\" name=\"form1\" action=\"login\" method=\"post\" onsubmit=\"return  formSubmit();\"  target=\"_self\">\r\n<DIV id=rt2mid>\r\n<DIV id=mdcion>\r\n<DIV class=lf><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/down.gif\"></DIV>\r\n<DIV class=tx>请输入登录帐号</DIV></DIV>\r\n<DIV id=mdcion2>\r\n<DIV class=lf>杜威号</DIV>\r\n<DIV class=tx><INPUT id=deweyNo class=input2 type=text name=deweyNo value=\"");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("\"  tabIndex=1> </DIV></DIV>\r\n<DIV id=mdcion2>\r\n<DIV class=lf>用户名</DIV>\r\n<DIV class=tx><INPUT id=loginName class=input2 type=text name=loginName  tabIndex=2> </DIV></DIV>\r\n<DIV id=mdcion2>\r\n<DIV class=lf>密&nbsp;&nbsp;&nbsp;&nbsp;码</DIV>\r\n<DIV class=tx><INPUT id=password class=input2 type=password name=password  tabIndex=3> </DIV></DIV>\r\n<DIV id=mdcion2>\r\n<DIV class=lf>验证码</DIV>\r\n<DIV style=\"WIDTH: auto\" class=tx><INPUT style=\"WIDTH: 70px; FLOAT: left\" class=input2 type=text name=\"checkCode\" minlength=\"4\" maxlength=\"4\"  tabIndex=4>&nbsp; </DIV>\r\n<DIV class=yzm><img name=\"checkCodeImg\" id= \"checkCodeImg\" src=\"checkCode.gif\"  alt=\"验证图片\" onclick=\"return chkImage();\" width=\"60\" height=\"20\" border=\"0\" align=\"absmiddle\"></DIV></DIV>\r\n<DIV style=\"MARGIN-TOP: 5px; WIDTH: 50%\" id=mdcion2>\r\n<DIV class=lf><INPUT value=checkbox CHECKED type=checkbox name=state><INPUT value=submit type=hidden name=Action> 记住我的登录状态 </DIV>\r\n<DIV style=\"WIDTH: auto\" class=tx></DIV>\r\n<DIV class=yzm></DIV></DIV>\r\n<DIV style=\"MARGIN-TOP: 5px; WIDTH: 50%\" id=mdcion2>\r\n");
      out.write("<DIV class=lf><INPUT src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/btnd.gif\" width=88 height=30 type=image></DIV>\r\n<DIV style=\"WIDTH: auto\" class=tx></DIV>\r\n<DIV class=yzm></DIV></DIV>\r\n<DIV style=\"WIDTH: 50%\" id=mdcion2>\r\n<DIV style=\"FONT-SIZE: 12px; FONT-WEIGHT: bold\" class=lf>您还没有帐号，赶紧注册吧</DIV>\r\n<DIV style=\"WIDTH: auto\" class=tx></DIV>\r\n<DIV class=yzm></DIV></DIV>\r\n<DIV style=\"WIDTH: 50%\" id=mdcion2>\r\n<DIV class=lf><A href=\"#\"><IMG border=0 src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/btnd2.gif\"></A></DIV>\r\n<DIV style=\"WIDTH: auto\" class=tx></DIV>\r\n<DIV class=yzm></DIV></DIV>\r\n<DIV style=\"WIDTH: 50%\" id=mdcion2>\r\n<DIV class=lf><A href=\"#\" target=_blank>忘记密码&gt;&gt;</A></DIV>\r\n<DIV style=\"WIDTH: auto\" class=tx></DIV>\r\n<DIV class=yzm></DIV></DIV></DIV></FORM>\r\n<DIV id=rt2btm></DIV></DIV></DIV>\r\n<DIV style=\"BORDER-TOP: #dfdfdf 1px solid\" id=footer>\r\n版权所有：杜威酒店管理系统\r\n</DIV></DIV>\r\n</body>\r\n<script language=\"javascript\">\r\n\t\t// 装载页面\r\n\t\tfunction window.onload(){\r\n\t\t\t// 弹出提示窗口\r\n\t\t\tvar retMsg = document.getElementById(\"retMsg\").value;\r\n\t\t\tif(retMsg != \"\"){\r\n\t\t\t\talert(retMsg);\r\n\t\t\t}\r\n\t\t}\r\n</script>\r\n</html>");
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

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /login.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("message");
    // /login.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /login.jsp(4,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setScope("page");
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /login.jsp(159,56) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /login.jsp(159,56) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent(null);
    // /login.jsp(189,75) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.deweyNo}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }
}
