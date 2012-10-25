package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bakeleftmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/commons/taglibs.jsp");
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

      out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

//     ${ctx}/login.do      <c:url value='/login.do'/>        ->  /demo/login.do    -->
//    <!DOCTYPE html   PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
//    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

      out.write("\r\n<HTML>\r\n<HEAD>\r\n");

	String path         = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n<base href=\"");
      out.print(basePath );
      out.write("\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\" />\r\n<meta http-equiv=\"Cache-Control\" content=\"no-cache\"/>\r\n<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n<meta http-equiv=\"Expires\" content=\"0\"/>\r\n<!-- link rel=\"stylesheet\" rev=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" type=\"text/css\" media=\"screen\" / -->\r\n<script src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"  type=\"text/javascript\"></script>\r\n<style>\r\n* {\r\n\tfont: 13px '宋体'，Arial, Helvetica, sans-serif;\r\n}\r\nbody {\r\n\tmargin:0;\r\n\tpadding:0;\r\n}\r\n.bg1{\r\n\tbackground-color: #ffffff;\r\n}\r\n/****************快捷菜单************************/\r\na#quickmenutitle{\r\nwidth:180px;\r\npadding:4px 0;\r\ntext-decoration:none;\r\ndisplay:block;\r\n}\r\n.quickmenu{\r\n\tpadding-left:27px;\r\n}\r\na.quickmenu {\r\ntext-decoration:none;\r\ncolor:#174179;\r\nbackground:inherit;\r\n}\r\na.quickmenu:hover {\r\ncolor:red;\r\nbackground:inherit;\r\n}\r\n.chang{\r\npadding-left:27px;\r\ntext-decoration:none;\r\ncolor:red;\r\nbackground:none;\r\nline-height:22px;\r\n}\r\nul{\r\nmargin:0;\r\npadding:0;\r\n}\r\n.triangle_mark{\r\nwidth:180px;\r\npadding-left:1px;\r\n}\r\n.triangle_mark li{\r\nwidth:177px;\r\nline-height:22px;\r\nbackground-image:url(images/menu_arrow.gif);\r\nbackground-position: 15px center;\r\nbackground-repeat:no-repeat;\r\nbackground-color:#fff;\r\ntext-decoration:none;\r\ncolor:#174179 !important;\r\nborder-left:solid 1px #9accff;\r\nborder-right:solid 1px #9accff;\r\nborder-bottom:solid 1px #CCCCCC;\r\ndisplay:block;\r\n");
      out.write("overflow:hidden;\r\n}\r\n#nav {\r\n width:180px;\r\n padding-top:4px;\r\n padding-bottom:3px;\r\n list-style-type: none;\r\n text-align:left;\r\n margin-top:-3px;\r\n}\r\n#nav a {\r\n padding-left:25px;\r\n width:180px;\r\n display: block;\r\n padding-top:4px;\r\n padding-bottom:3px;\r\n}\r\n#nav li {\r\nbackground:url(images/menu01.gif) no-repeat;\r\nwidth:180px;\r\n float:left;\r\n}\r\n#nav li a:hover{\r\npadding-top:4px;\r\npadding-bottom:3px;\r\nbackground:url(images/menu01.gif) no-repeat;\r\nfloat:left;\r\n}\r\n#nav a:link  {\r\n color:#000; text-decoration:none;\r\n}\r\n#nav a:visited  {\r\n color:#000; text-decoration:none;\r\n}\r\n#nav a:hover  {\r\n color:#000; text-decoration:none;\r\n}\r\n#nav li ul {\r\nlist-style:none;\r\ntext-align:left;\r\nwidth:180px;\r\npadding:0 0 0 1px;\r\n}\r\n#nav li ul li{\r\nwidth:177px;\r\nborder-left:solid 1px #9accff;\r\nborder-right:solid 1px #9accff;\r\nborder-bottom:solid 1px #E0E4FE;\r\n}\r\n#nav li ul li a{\r\nwidth:177px;\r\nbackground-image:url(images/menu_arrow.gif);\r\nbackground-position: 15px center;\r\nbackground-repeat:no-repeat;\r\nbackground-color:#ffeede;\r\ntext-decoration:none;\r\n");
      out.write("color:#174179 !important;\r\ndisplay:block;\r\n}\r\n#nav li ul li a:hover{\r\nwidth:177px;\r\nbackground-image:url(images/menu_arrow.gif);\r\nbackground-position: 15px center;\r\nbackground-repeat:no-repeat;\r\nbackground-color:#fff;\r\ntext-decoration:none;\r\ncolor:#174179;\r\ndisplay:block;\r\n}\r\n#nav li ul a.ag{\r\nwidth:177px;\r\nbackground-image:url(images/menu_arrow.gif);\r\nbackground-position: 15px center;\r\nbackground-repeat:no-repeat;\r\nbackground-color:#fff;\r\ntext-decoration:none;\r\ncolor:#174179;\r\ndisplay:block;\r\n}\r\n#nav li:hover ul {\r\n left: auto;\r\n}\r\n#nav li.sfhover ul {\r\n left: auto;\r\n}\r\n#nav ul.collapsed {\r\n display: none;\r\n}\r\n</style>\r\n<script language=\"javascript\" type=\"text/javascript\">\r\n// <a onmouseover=\"javascript:onMenuOverOut('账户管理');\" onmouseout=\"javascript:onMenuOverOut('账户管理');\" />\r\nfunction onMenuOverOut(prm) {\r\n\twindow.status=prm;\r\n\treturn true;\r\n}\r\nfunction goto1(url){\r\n\tdocument.menuForm.action=url;\r\n\tdocument.menuForm.target=\"mainFrame\";\r\n\tdocument.menuForm.submit();\r\n}\r\n/** 快捷方式的连接 **/\r\nfunction quickmenuToggle(obj){\r\n");
      out.write("\tvar i;\r\n\tvar smsum;\r\n\tvar elementID=obj.id;\r\n\tvar obj2 = document.getElementById(\"subquickmenutitle\").getElementsByTagName(\"li\");\r\n\tfor (var i=0; i<obj2.length; i++) {\r\n\t\t obj2[i].getElementsByTagName(\"a\")[0].className=\"quickmenu\";\r\n\t} \r\n\tvar obj1 = document.getElementById(\"nav\").getElementsByTagName(\"li\");\r\n\tfor (var i=0; i<obj1.length; i++) {\r\n\t\tobj1[i].getElementsByTagName(\"a\")[0].className=\"nomal\";\r\n\t}\r\n\tobj.getElementsByTagName(\"a\")[0].className=\"chang\";\r\n}\r\n/** 一般方式的连接 **/\r\nfunction menuToggle(obj){\r\n\tvar i;\r\n\tvar smsum;\r\n\tvar elementID=obj.id;\r\n\tvar obj1 = document.getElementById(\"nav\").getElementsByTagName(\"li\");\r\n\tfor (var i=0; i<obj1.length; i++) {\r\n\t\tobj1[i].getElementsByTagName(\"a\")[0].className=\"nomal\";\r\n\t}\r\n\tvar obj2 = document.getElementById(\"subquickmenutitle\").getElementsByTagName(\"li\");\r\n\tfor (var i=0; i<obj2.length; i++) {\r\n\t\tobj2[i].getElementsByTagName(\"a\")[0].className=\"quickmenu\";\r\n\t}\r\n\tobj.getElementsByTagName(\"a\")[0].className=\"ag\";\r\n}\r\n/** 展开子菜单 **/\r\nvar LastLeftID = \"\";  /***新的MENU***/\r\n");
      out.write("function DoMenu1(emid) {\r\n\t// emid为要展开的ul的id\r\n\tvar obj = document.getElementById(emid);\r\n\tif (obj.className.toLowerCase() == \"expanded\") { // 是展开的则关闭\r\n\t\tobj.className = \"collapsed\";\r\n\t} else {\t// 是关闭的则展开\r\n\t\tobj.className = \"expanded\";\r\n\t}\r\n\t// 关闭上一个Menu\r\n\tif((LastLeftID!=\"\")&&(emid!=LastLeftID)) {\r\n\t\tdocument.getElementById(LastLeftID).className = \"collapsed\"; // 关闭\r\n\t}\r\n\tLastLeftID = emid;\r\n}\r\nvar count=0;\t\t\t\t\t//做计数器\r\nvar limit=new Array();\t//用于记录当前显示的哪几个菜单\r\nvar countlimit=2;\t\t\t//同时打开菜单数目，可自定义\r\nfunction doMenu(emid) {\r\n\tvar obj = document.getElementById(emid);\r\n\tif (obj.className.toLowerCase() == \"expanded\") { // 是展开的则关闭\r\n\t\tobj.className = \"collapsed\";\r\n\t\tvar j;\r\n\t\tfor (i=0;i<limit.length;i++) {\r\n\t\t\t//获取当前点击的菜单在limit数组中的位置\r\n\t\t\tif(limit[i]==emid) {\r\n\t\t\t\tj=i;\r\n\t\t\t\t// j以后的数组全部往前挪一位\r\n\t\t\t\tfor (i=j;i<limit.length-1;i++) {\r\n\t\t\t\t\tlimit[i]=limit[i+1];\r\n\t\t\t\t}\r\n\t\t\t\tlimit[limit.length-1]=null;//删除数组最后一位\r\n\t\t\t\tcount--;\r\n\t\t\t\tbreak;\r\n\t\t\t}\r\n\t\t}\r\n\t} else {\t// 是关闭的则展开\r\n\t\tobj.className = \"expanded\";\r\n\t\t// 少于限制的个数时\r\n\t\tif (count<countlimit) {\r\n");
      out.write("\t\t\tlimit[count]=emid;\t//录入数组\r\n\t\t\tcount++;\r\n\t\t} else { // 已达到限制个数时\r\n\t\t\tdocument.getElementById(limit[0]).className = \"collapsed\"; // 关闭最先的那个\r\n\t\t\tfor (i=0;i<limit.length-1;i++) {  // 后面的往前挪一位\r\n\t\t\t\tlimit[i]=limit[i+1];\r\n\t\t\t}\r\n\t\t\tlimit[limit.length-1]=emid; // 数组去掉头一位\r\n\t\t}\r\n\t}\r\n}\r\n</script>\r\n</HEAD>\r\n<BODY style=\"SCROLLBAR-FACE-COLOR: #C1D3FB;  SCROLLBAR-HIGHLIGHT-COLOR: #C1D3FB; SCROLLBAR-SHADOW-COLOR: #ffffff; SCROLLBAR-3DLIGHT-COLOR:#C1D3FB; SCROLLBAR-ARROW-COLOR: #4D6185; SCROLLBAR-TRACK-COLOR: #F5F5F5; SCROLLBAR-DARKSHADOW-COLOR: #C1D3FB;\">\r\n<DIV id=proc name=\"proc\">\r\n\t<TABLE class=tableframe cellPadding=10 width=\"100%\" align=center height=40>\r\n\t\t<TBODY>\r\n\t\t\t<TR class=listtitle align=middle>\r\n\t\t\t\t<TD class=listcelltitle vAlign=center>装载菜单... </TD>\r\n\t\t\t</TR>\r\n\t\t</TBODY>\r\n\t</TABLE>\r\n\t<BR>\r\n</DIV>\r\n<form name=\"menuForm\" action=\"/per/main\">\r\n\t<input  type=\"hidden\" name=\"transName\"/>\r\n</form>\r\n<TABLE WIDTH=\"100%\" HEIGHT=\"100%\" BORDER=\"0\" cellpadding=\"0\" cellspacing=\"0\" ALT=\"\">\r\n\t<TR>\r\n\t\t<TD valign=\"top\">\r\n\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t<div id=\"quickmenu\">\r\n\t\t\t\t\t<div class=\"menutitle\"><IMG SRC=\"./images/menu_title01.jpg\" WIDTH=\"180\" HEIGHT=\"30\" BORDER=\"0\" ALT=\"\"></div>\r\n\t\t\t\t\t<ul id=\"subquickmenutitle\" class=\"triangle_mark\">\r\n\t\t\t\t\t\t<li onclick =\"quickmenuToggle(this); \"><a onFocus=\"blur();\"class=\"quickmenu\" href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("');\" >入住登记</a></li>\r\n\t\t\t\t\t\t<li onclick =\"quickmenuToggle(this); \"><a onFocus=\"blur();\"class=\"quickmenu\" href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("');\" >旅客列表</a></li>\r\n\t\t\t\t\t\t<li onclick =\"quickmenuToggle(this); \"><a onFocus=\"blur();\"class=\"quickmenu\" href=\"javascript:goto1('/per/main?');\" >AAAAA</a></li>\r\n\t\t\t\t\t\t<li onclick =\"quickmenuToggle(this); \"><a onFocus=\"blur();\"class=\"quickmenu\" href=\"javascript:goto1('/per/main?');\" >AAAAA</a></li>\r\n\t\t\t\t\t\t<li onclick =\"quickmenuToggle(this); \"><a onFocus=\"blur();\"class=\"quickmenu\" href=\"javascript:goto1('/per/main?');\" >AAAAA</a></li>\r\n\t\t\t\t\t</ul> \r\n\t\t\t\t\t<div><IMG SRC=\"./images/menu_bottom01.jpg\" WIDTH=\"180\" HEIGHT=\"12\" BORDER=\"0\" ALT=\"\"></div> \r\n\t\t\t\t</div>\r\n\t\t\t\t<div id=\"totalmenu\">\r\n\t\t\t\t\t<div class=\"menutitle\"><IMG SRC=\"./images/menu_title02.jpg\" WIDTH=\"180\" HEIGHT=\"27\" BORDER=\"0\" ALT=\"\"></div>\r\n\t\t\t\t\t<ul id=\"nav\">\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu1');\" href=\"javascript:void(0)\">前台接待*</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu1\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("');\" >入住登记*</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("');\" >旅客列表*</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu2');\" href=\"javascript:void(0)\">前台收银</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu2\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >合并账单</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >拆分账单</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >结账退房</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu3');\" href=\"javascript:void(0)\">预订管理</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu3\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >房间预订</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >预订列表</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu4');\" href=\"javascript:void(0)\">客房管理</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu4\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >房态展示</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >客房列表</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu5');\" href=\"javascript:void(0)\">现金管理</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu5\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >交班</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >交班历史</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >回款计划</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu6');\" href=\"javascript:void(0)\">查询</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu6\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >收款管理</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >付款管理</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >帐户查询</a></li> \r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu7');\" href=\"javascript:void(0)\">客户关系管理*</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu7\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("');\" >协议单位管理*</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu8');\" href=\"javascript:void(0)\">报表中心</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu8\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >营业日报</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >营业汇总</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >营业月报</a></li> \r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu9');\" href=\"javascript:void(0)\">接口管理</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu9\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >电话计费管理</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >电子门锁管理</a></li> \r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu10');\" href=\"javascript:void(0)\">参数维护*</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu10\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f7(_jspx_page_context))
        return;
      out.write("');\" >房型设置*</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f8(_jspx_page_context))
        return;
      out.write("');\" >酒店信息设置*</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f9(_jspx_page_context))
        return;
      out.write("');\" >计费设置*</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<a  onclick=\"doMenu('menu11');\" href=\"javascript:void(0)\">系统管理*</a> \r\n\t\t\t\t\t\t\t<ul id=\"menu11\" class=\"collapsed\">\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f10(_jspx_page_context))
        return;
      out.write("');\" >房间维护*</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f11(_jspx_page_context))
        return;
      out.write("');\" >消费项目维护*</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f12(_jspx_page_context))
        return;
      out.write("');\" >用户维护*</a></li>\r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('");
      if (_jspx_meth_c_005furl_005f13(_jspx_page_context))
        return;
      out.write("');\" >角色维护*</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >注册信息维护</a></li> \r\n\t\t\t\t\t\t\t\t<li onclick =\"menuToggle(this);\"><a href=\"javascript:goto1('/per/main?');\" >日志查询</a></li>\r\n\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t</ul>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</TD>\r\n\t</TR> \r\n\t<TR height=\"30px\" >\r\n\t\t<TD valign=\"bottom\">\r\n\t\t\t<div style=\"margin-bottom=5px;\">\r\n\t\t\t\t<a href=\"/per/main?transName=logout\" target=\"_parent\"  onclick=\"hint();\"><img src=\"images/menu_title03.jpg\" title=\"安全退出系统\" width=\"180\" height=\"27\" border=\"0\"></a>\r\n\t\t\t</div>\r\n\t\t</TD>\r\n\t</TR>\r\n</TABLE>\r\n<SCRIPT language=javascript>\r\n\tdocument.onselectstart = CancelSelect;\r\n\tfunction CancelSelect()\r\n\t{\r\n\t\tevent.cancelBubble = true;\r\n\t\treturn false;\r\n\t}\r\n\tdocument.getElementById(\"proc\").style.display = \"none\"\r\n</SCRIPT>\r\n</BODY>\r\n</HTML>");
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
    // /pages/bakeleftmenu.jsp(15,50) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/styles/leftmenu.css");
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
    // /pages/bakeleftmenu.jsp(16,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/scripts/jquery/jquery-1.6.1.min.js");
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
    // /pages/bakeleftmenu.jsp(280,107) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/checkIn/new");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /pages/bakeleftmenu.jsp(281,107) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/guestList/query");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /pages/bakeleftmenu.jsp(294,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/checkIn/new");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /pages/bakeleftmenu.jsp(295,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/guestList/query");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /pages/bakeleftmenu.jsp(339,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/contractualUnit/list");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent(null);
    // /pages/bakeleftmenu.jsp(360,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/roomType/list");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent(null);
    // /pages/bakeleftmenu.jsp(361,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("/hotelInfoSetting/edit");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f9.setParent(null);
    // /pages/bakeleftmenu.jsp(362,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setValue("/chargeRuleSetting/edit");
    int _jspx_eval_c_005furl_005f9 = _jspx_th_c_005furl_005f9.doStartTag();
    if (_jspx_th_c_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f10.setParent(null);
    // /pages/bakeleftmenu.jsp(368,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setValue("/merRoom/query");
    int _jspx_eval_c_005furl_005f10 = _jspx_th_c_005furl_005f10.doStartTag();
    if (_jspx_th_c_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f11.setParent(null);
    // /pages/bakeleftmenu.jsp(369,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f11.setValue("/merServices/query");
    int _jspx_eval_c_005furl_005f11 = _jspx_th_c_005furl_005f11.doStartTag();
    if (_jspx_th_c_005furl_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f12.setParent(null);
    // /pages/bakeleftmenu.jsp(370,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f12.setValue("/merUser/list");
    int _jspx_eval_c_005furl_005f12 = _jspx_th_c_005furl_005f12.doStartTag();
    if (_jspx_th_c_005furl_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f13.setParent(null);
    // /pages/bakeleftmenu.jsp(371,68) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f13.setValue("/merRole/list");
    int _jspx_eval_c_005furl_005f13 = _jspx_th_c_005furl_005f13.doStartTag();
    if (_jspx_th_c_005furl_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
    return false;
  }
}
