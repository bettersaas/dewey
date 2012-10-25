package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
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

      out.write("\r\n<HTML><HEAD>\r\n");
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
      out.write("\r\n<META name=VI60_defaultClientScript content=VBScript>\r\n<META content=\"text/html; charset=gb2312\" http-equiv=Content-Type>\r\n<script type=\"text/javascript\">\r\n//URL的跳转\r\nfunction gotourl(url,sname,swidth,sheight,sreplace,sclose)\r\n{\r\n\tvar objNewWin;\t\t\t\t\r\n\tif (swidth==\"\") swidth = \"790\";\r\n\tif (sheight==\"\") sheight = \"480\";\r\n\tif (sreplace==\"\") sreplace = false;\r\n\tif (sclose==\"\") sclose = false;\r\n\tobjNewWin = window.open(url,sname,\"fullscreen=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=\" + swidth + \",height=\" + sheight + \",top=200,left=200\",sreplace);\t\r\n\tif (sclose) window.close();\r\n\t\tobjNewWin.focus();\t\r\n}\r\n\r\nfunction popdialog(url,swidth,sheight){\r\n\tif (swidth==\"\") swidth = \"280\";\r\n\tif (sheight==\"\") swidth = \"180\";\r\n\tvar sValue = showModalDialog(url,\"\",\"dialogWidth:\" + swidth + \";status:no;dialogHeight:\" + sheight);\r\n\treturn sValue;\r\n}\r\n</script>\r\n<STYLE type=text/css>\r\n.top {\r\n\tFONT-FAMILY: \"宋体\"; FONT-SIZE: 9pt; VERTICAL-ALIGN: bottom; PADDING-TOP: 0px; 006600: \r\n}\r\nBODY {\r\n");
      out.write("\tLINE-HEIGHT: 150%; BACKGROUND-COLOR: #ffffff; MARGIN-TOP: 0px; FONT-FAMILY: \"宋体\"; COLOR: #ffffff; MARGIN-LEFT: 0px; FONT-SIZE: 9pt; MARGIN-RIGHT: 0px\r\n}\r\nTD {\r\n\tLINE-HEIGHT: 150%; FONT-FAMILY: 宋体; COLOR: #ffffff; FONT-SIZE: 9pt\r\n}\r\nTD.top {\r\n\tPADDING-BOTTOM: 0px; PADDING-LEFT: 4px; PADDING-RIGHT: 4px; PADDING-TOP: 0px\r\n}\r\nA:link {\r\n\tCOLOR: #ffffff; TEXT-DECORATION: none\r\n}\r\nA:visited {\r\n\tCOLOR: #ffffff; TEXT-DECORATION: none\r\n}\r\nA:hover {\r\n\tCOLOR: #cebef7; TEXT-DECORATION: none\r\n}\r\n</STYLE>\r\n<SCRIPT language=javascript type=text/javascript  src=\"scripts/fun_Script.js\"></SCRIPT>\r\n<SCRIPT language=JavaScript>\r\n<!--\r\nfunction Show_Hide_Menu(){\r\nif(window.parent.oamenu_frame.cols==\"0,*,0,0,0\"){\r\ndocument.getElementById(\"menuICON\").src=\"images/top/hidemenu.gif\";\r\ndocument.getElementById(\"menuICON\").alt=\"隐藏菜单\"\r\nwindow.parent.oamenu_frame.cols=\"120,*,0,0,0\";\r\n}\r\nelse{\r\ndocument.getElementById(\"menuICON\").src=\"images/top/showmenu.gif\";\r\ndocument.getElementById(\"menuICON\").alt=\"显示菜单\"\r\nwindow.parent.oamenu_frame.cols=\"0,*,0,0,0\";}\r\n");
      out.write("}\r\n\r\nfunction MM_findObj(n, d) { //v3.0\r\n  var p,i,x;  if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\r\n    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\r\n  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\r\n  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); return x;\r\n}\r\nfunction MM_nbGroup(event, grpName) { //v3.0\r\n  var i,img,nbArr,args=MM_nbGroup.arguments;\r\n  if (event == \"init\" && args.length > 2) {\r\n    if ((img = MM_findObj(args[2])) != null && !img.MM_init) {\r\n      img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;\r\n      if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();\r\n      nbArr[nbArr.length] = img;\r\n      for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {\r\n        if (!img.MM_up) img.MM_up = img.src;\r\n        img.src = img.MM_dn = args[i+1];\r\n        nbArr[nbArr.length] = img;\r\n    } }\r\n  } else if (event == \"over\") {\r\n");
      out.write("    document.MM_nbOver = nbArr = new Array();\r\n    for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {\r\n      if (!img.MM_up) img.MM_up = img.src;\r\n      img.src = (img.MM_dn && args[i+2]) ? args[i+2] : args[i+1];\r\n      nbArr[nbArr.length] = img;\r\n    }\r\n  } else if (event == \"out\" ) {\r\n    for (i=0; i < document.MM_nbOver.length; i++) {\r\n      img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }\r\n  } else if (event == \"down\") {\r\n    if ((nbArr = document[grpName]) != null)\r\n      for (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }\r\n    document[grpName] = nbArr = new Array();\r\n    for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {\r\n      if (!img.MM_up) img.MM_up = img.src;\r\n      img.src = img.MM_dn = args[i+1];\r\n      nbArr[nbArr.length] = img;\r\n  } }\r\n}\r\n\r\nfunction MM_preloadImages() { //v3.0\r\n var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\r\n   var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\r\n");
      out.write("   if (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\r\n}\r\n\r\n//-->\r\n</SCRIPT>\r\n\r\n<SCRIPT language=vbscript>\r\n\tdim msgflag\r\n\tmsgflag = \"old\"\r\n\tfunction getmsgflag()\r\n\t\tgetmsgflag = msgflag\r\n\tend function\r\n  sub showzxrs(x)\r\n    document.getElementById(\"zxrs\").innertext=x\r\n  end sub\r\n  sub changemsgimg(x,id)\r\n    dim s1,s2   \r\n    s1=\"<a style='cursor:hand' onclick=\"\"javascript:parent.msg.location.href='../message/main.asp';\"\" \" _\r\n        & \" onMouseOut=\"\"MM_nbGroup('out');\"\"  \" _\r\n        & \"onMouseOver=\"\"MM_nbGroup('over','OAHeader_r1_c3','images/top/OAHeader_r1_c3_f2.gif','images/top/OAHeader_r1_c3_f3.gif',1);\"\"\" _\r\n        & \"  title='短消息管理'>\" _\r\n        & \"<img id='OAHeader_r1_c3' name='OAHeader_r1_c3' src='images/top/OAHeader_r1_c3.gif' border='0'></a>\"\r\n    s2=\"<a style='cursor:hand' onclick='vbscript:doview(\"\"\" & id & \"\"\")'\" _\r\n        & \" onMouseOut=\"\"MM_nbGroup('out');\"\"  \" _\r\n        & \"onMouseOver=\"\"MM_nbGroup('over','OAHeader_r1_c3','images/top/OAHeader_r1_c3_new.gif','images/top/OAHeader_r1_c3_new.gif',1);\"\"\" _\r\n");
      out.write("        & \"  title='查看新消息'>\" _\r\n        & \"<img id='OAHeader_r1_c3' name='OAHeader_r1_c3' src='images/top/OAHeader_r1_c3_new.gif'border='0'></a>\"\r\n    if x=\"new\" then\r\n\t\t\tif msgflag=\"old\" then\r\n\t\t\t\t'msgbox \"new\"\r\n\t\t\t\tdocument.getElementById(\"msg\").innerHTML=s2\r\n\t\t\t\tdocument.getElementById(\"OAHeader_r1_c3\").src=\"images/top/OAHeader_r1_c3_new.gif\"\r\n\t\t\t\tmsgflag = \"new\"\t\t\t\t\r\n      end if\r\n    else\r\n\t\t\tif msgflag=\"new\" then\r\n\t\t\t\t'msgbox \"old\"\r\n\t\t\t\tdocument.getElementById(\"msg\").innerHTML=s1\r\n\t\t\t\tdocument.getElementById(\"OAHeader_r1_c3\").src=\"images/top/OAHeader_r1_c3.gif\"\r\n\t\t\t\tmsgflag = \"old\"\r\n      end if\r\n    end if\r\n    \r\n  end sub\r\n  function doview(id)  \r\n\t\tchangemsgimg \"old\",\"\"\r\n\t\t'msgbox msgflag\r\n    openchromeless \"../message/msg_view.asp?xxxh=\" & id,\"MessageView\",360,160,(screen.availWidth-400)/2,(screen.availHeight-200)/2,\"../message/title.gif\",\"../message/btnclose_1.gif\",\"../message/btnclose_2.gif\",\"../message/btnclose_1.gif\",\"../message/btnmin_2.gif\",\"../message/btnmin_1.gif\",\"../message/btnmin_2.gif\",\"\",\"\",\"Message_View\",\"#009c24\",\"black\",\"\",\"\"    \r\n");
      out.write("  end function\r\n</SCRIPT>\r\n\r\n<SCRIPT language=vbscript>\r\nfunction exitsystem\r\n\tif msgbox (\"您确定要退出系统吗？\",vbYesNo+vbQuestion,\"退出确定\")=vbYes then\t\t\t\t\r\n\t\twindow.parent.close \r\n\tend if\r\nend function\r\n</SCRIPT>\r\n\r\n<META name=GENERATOR content=\"MSHTML 8.00.7600.16722\"></HEAD>\r\n<BODY  onload=\"MM_preloadImages('images/top/OAHeader_r1_c3_f2.gif','images/top/OAHeader_r1_c3_f3.gif','images/top/OAHeader_r1_c5_f2.gif','images/top/OAHeader_r1_c5_f3.gif','images/top/OAHeader_r1_c7_f2.gif','images/top/OAHeader_r1_c7_f3.gif','images/top/OAHeader_r1_c9_f2.gif','images/top/OAHeader_r1_c9_f3.gif','images/top/OAHeader_r1_c11_f2.gif','images/top/OAHeader_r1_c11_f3.gif');\" \r\nbgColor=#ffffff>\r\n<TABLE style=\"MARGIN: 0px\" border=0 cellSpacing=0 cellPadding=0 width=\"100%\" \r\nbgColor=#6386de valign=\"top\">\r\n  <TBODY>\r\n  <TR vAlign=top>\r\n    <TD vAlign=center width=350>\r\n      <TABLE style=\"MARGIN: 0px\" border=0 cellSpacing=0 cellPadding=0  bgColor=#6386de height=\"100%\">\r\n\t        <TBODY>\r\n\t\t        <TR>\r\n\t\t          <TD colSpan=2><IMG border=0 src=\"images/top/deweylog.gif\"></TD>\r\n");
      out.write("\t\t         </TR>\r\n\t\t        <TR height=18 vAlign=top>\r\n\t\t          <TD width=18><IMG style=\"CURSOR: hand\" id=menuICON  onclick=javascript:Show_Hide_Menu(); alt=隐藏菜单 src=\"images/top/hidemenu.gif\"></TD>\r\n\t\t          <TD class=top width=\"95%\">\r\n\t\t          \t<NOBR>| 当前用户：<A title=点击可修改密码 href=\"javascript:gotourl('chgPwd.jsp','','380px','190px','',false);\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</A></NOBR>\r\n\t\t          </TD>\r\n\t\t          </TR>\r\n\t          </TBODY>\r\n          </TABLE>\r\n    </TD>\r\n    <TD width=\"100%\">\r\n      <TABLE style=\"MARGIN: 0px\" border=0 cellSpacing=0 cellPadding=0 bgColor=#6386de height=\"100%\">\r\n        <TBODY></TBODY></TABLE></TD>\r\n    <TD width=300 align=right>\r\n      <TABLE style=\"MARGIN: 0px\" border=0 cellSpacing=0 cellPadding=0 bgColor=#6386de height=\"100%\">\r\n        <TBODY>\r\n        <TR height=20 vAlign=bottom>\r\n          <TD width=18><IMG border=0 src=\"images/top/top_toolbar.gif\"></TD>\r\n          <TD class=top bgColor=#000000><NOBR>酒店名称-假日酒店 | 当前日期-2005年04月25日&nbsp;&nbsp; </NOBR></TD></TR>\r\n        <TR height=38>\r\n          <TD></TD>\r\n          <TD vAlign=center align=right><A onmouseover=\"MM_nbGroup('over','OAHeader_r1_c0','images/top/OAHeader_r1_c0_f2.gif','images/top/OAHeader_r1_c0_f3.gif',1);\" \r\n            title=我的桌面 onmouseout=\"MM_nbGroup('out');\"   href=\"http://lkoa4.lkpower.com/dlh/lkoa_grzm_index.asp\"  target=middle><IMG border=0 name=OAHeader_r1_c0 \r\n            src=\"images/top/OAHeader_r1_c0.gif\"></A> &nbsp; <SPAN id=msg  name=\"msg\">\r\n");
      out.write("            <A style=\"CURSOR: hand\" onmouseover=\"MM_nbGroup('over','OAHeader_r1_c3','images/top/OAHeader_r1_c3_f2.gif','images/top/OAHeader_r1_c3_f3.gif',1);\" \r\n            title=消息管理 onmouseout=\"MM_nbGroup('out');\" \r\n            onclick=\"javascript:parent.msg.location.href='../message/main.asp';\"><IMG \r\n            id=OAHeader_r1_c3 border=0 name=OAHeader_r1_c3 \r\n            src=\"images/top/OAHeader_r1_c3.gif\"></A></SPAN> &nbsp; <A \r\n            onmouseover=\"MM_nbGroup('over','OAHeader_r1_c5','images/top/OAHeader_r1_c5_f2.gif','images/top/OAHeader_r1_c5_f3.gif',1);\" \r\n            title=刷新页面 onmouseout=\"MM_nbGroup('out');\" \r\n            href=\"vbscript:parent.mainFrame.location.reload\"><IMG border=0 \r\n            name=OAHeader_r1_c5 src=\"images/top/OAHeader_r1_c5.gif\"></A> &nbsp; \r\n            <A onmouseover=\"MM_nbGroup('over','OAHeader_r1_c7','images/top/OAHeader_r1_c7_f2.gif','images/top/OAHeader_r1_c7_f3.gif',1);\" \r\n            title=后退 onmouseout=\"MM_nbGroup('out');\" \r\n            href=\"vbscript:history.back\"><IMG border=0 name=OAHeader_r1_c7 \r\n");
      out.write("            src=\"images/top/OAHeader_r1_c7.gif\"></A> &nbsp; <A \r\n            onmouseover=\"MM_nbGroup('over','OAHeader_r1_c9','images/top/OAHeader_r1_c9_f2.gif','images/top/OAHeader_r1_c9_f3.gif',1);\" \r\n            title=前进 onmouseout=\"MM_nbGroup('out');\" \r\n            href=\"vbscript:history.forward\"><IMG border=0 name=OAHeader_r1_c9 \r\n            src=\"images/top/OAHeader_r1_c9.gif\">\r\n            </A> &nbsp; <A onmouseover=\"MM_nbGroup('over','OAHeader_r1_c11','images/top/OAHeader_r1_c11_f2.gif','images/top/OAHeader_r1_c11_f3.gif',1);\" \r\n            title=退出系统 onmouseout=\"MM_nbGroup('out');\" \r\n            href=\"vbscript:exitsystem()\"><IMG border=0 name=OAHeader_r1_c11 \r\n            src=\"images/top/OAHeader_r1_c11.gif\"></A> &nbsp; \r\n    </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></BODY></HTML>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /pages/top.jsp(183,112) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.MER_USER.chineseName} ", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
