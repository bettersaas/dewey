package org.apache.jsp.pages.sys.merRoom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
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

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\r\n<HTML>\r\n<HEAD>\r\n");
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
      out.write("\r\n<style>\r\n.roomItemStyle {\r\nwidth:650px;height:50px;line-height:70px;float:left;border:1px #c0c0c0 solid;background:lightblue;\r\n}\r\n</style>\r\n<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n/**\r\n* 按房间数新增房间床位信息的设置\r\n**/\r\nfunction addRoomBeds()\r\n{ \r\n\tvar itemCnt = parseInt($('#currBed').val());\r\n\tif(isNaN(itemCnt)) {\r\n\t\t$('#currBed').val(\"\");\r\n\t\t$(\"#itemsDiv\").html(\"\");\r\n\t\treturn;\r\n\t}\r\n\tif(itemCnt>8 || itemCnt <1) {\r\n\t\talert(\"房间数只能是1-8之间。\");\r\n\t\treturn;\r\n\t}\r\n\tvar itemDiv = \"\";\r\n\tfor(i=0;i<itemCnt;i++) {\r\n\t\titemDiv = itemDiv \r\n\t\t\t+  '<tr id=\"item_' + i + '\"><td>'\r\n\t\t\t+  '<input type=\"hidden\" name=\"roomBeds[' + i + '].hourFlag\"  value=\"1\">'\r\n\t\t\t+  '<DIV class=\"roomItemStyle\">'\r\n\t\t\t+  '床号：&nbsp;&nbsp;<input type=\"text\" name=\"roomBeds[' + i + '].bedNo\"  size=\"7\"  maxlength=\"5\">&nbsp;&nbsp;'\r\n\t\t\t+ '全日房价<input type=\"text\" name=\"roomBeds[' + i + '].alldayPrice\" size=\"7\"  maxlength=\"5\">'\r\n\t\t\t+  '半天房价<input type=\"text\" name=\"roomBeds[' + i + '].halfdayPrice\" size=\"7\"  maxlength=\"5\"><br>'\r\n\t\t\t+  '是否钟点房<input checked type=checkbox name=hourFlagSet' + i + '  onclick=\"hourFlagSetFunc(' + i + ');\">'\r\n");
      out.write("\t\t\t+  '价格：<input type=\"text\" name=\"roomBeds[' + i + '].hourMeasure\"size=\"7\"  maxlength=\"5\">'\r\n\t\t\t+  '小时<input type=\"text\" name=\"roomBeds[' + i + '].hourPrice\" size=\"7\"  maxlength=\"5\">元'\r\n\t\t\t+  '</DIV>'\r\n\t\t\t+ '</td></tr>';\r\n\t}\r\n\t$(\"#itemsDiv\").html(\"<TABLE>\" + itemDiv +\"</TABLE>\");\r\n}\r\n/**\r\n* 是否钟点房的信息关联变动\r\n**/\r\nfunction hourFlagSetFunc(itemIndex)\r\n{\r\n\tvar hourFlagSet =    itemIndex==-1?form1.hourFlagSet : document.getElementById(\"hourFlagSet\"+itemIndex);\r\n\tvar hourFlag =          itemIndex==-1?form1.hourFlag : document.getElementById(\"roomBeds[\" + itemIndex + \"].hourFlag\");\r\n\tvar hourMeasure =  itemIndex==-1?form1.hourMeasure : document.getElementById(\"roomBeds[\" + itemIndex + \"].hourMeasure\");\r\n\tvar hourPrice =        itemIndex==-1?form1.hourPrice : document.getElementById(\"roomBeds[\" + itemIndex + \"].hourPrice\");\r\n\t// 是钟点房\r\n\tif(hourFlagSet.checked)\r\n\t{\r\n\t\t\thourFlag.value='1';\r\n\t\t\thourMeasure.disabled=false;\r\n\t\t\thourMeasure.style.backgroundColor = \"white\";\r\n\t\t\thourMeasure.value=\"\";\r\n\t\t\thourPrice.disabled=false;\r\n");
      out.write("\t\t\thourPrice.style.backgroundColor = \"white\";\r\n\t\t\thourPrice.value=\"\";\r\n\t} else { \r\n\t\t\thourFlag.value='0'; \r\n\t\t\thourMeasure.disabled=true;\r\n\t\t\thourMeasure.style.backgroundColor = \"#cccccc\";\r\n\t\t\thourMeasure.value=\"\";\r\n\t\t\thourPrice.disabled=true;\r\n\t\t\thourPrice.style.backgroundColor = \"#cccccc\";\r\n\t\t\thourPrice.value=\"\";\r\n\t}\r\n}\r\n/**\r\n* 选择房型后自动获取房型信息\r\n**/\r\nfunction setRoomTypeInfo(selectValue) \r\n{\r\n\t// document.all.sel.options[0].selected=true; \r\n\tvar a = $.trim(selectValue);\r\n\tif (a == \"\") {\r\n\t\tdocument.getElementById(\"roomType.id\").value=\"\";\r\n\t\tdocument.getElementById(\"roomTypeAlldayPrice\").value=\"\";\r\n\t\tdocument.getElementById(\"roomTypeHalfdayPrice\").value=\"\";\r\n\t\tdocument.getElementById(\"roomTypeHourMeasure\").value=\"\";\r\n\t\tdocument.getElementById(\"roomTypeHourPrice\").value=\"\";\r\n\t} else {\r\n\t\tvar strs= new Array();\r\n\t\tstrs=a.split(\"-\");\r\n\t\tdocument.getElementById(\"roomType.id\").value=strs[0];\r\n\t\tdocument.getElementById(\"roomTypeAlldayPrice\").value=strs[1];\r\n\t\tdocument.getElementById(\"roomTypeHalfdayPrice\").value=strs[2];\r\n");
      out.write("\t\tdocument.getElementById(\"roomTypeHourMeasure\").value=strs[3];\r\n\t\tdocument.getElementById(\"roomTypeHourPrice\").value=strs[4];\r\n\t}\r\n\tsetRoomRP();\r\n\tsetBedRP();\r\n}\r\n// 设置房间的价格信息\r\nfunction  setRoomRP()\r\n{\r\n\tif(form1.roomTypeInfos.value!=\"\") {\r\n\t\tdocument.getElementById(\"alldayPrice\").value = document.getElementById(\"roomTypeAlldayPrice\").value;\r\n\t\tdocument.getElementById(\"halfdayPrice\").value = document.getElementById(\"roomTypeHalfdayPrice\").value;\r\n\t}\r\n}\r\n// 设置房间床位的价格信息\r\nfunction  setBedRP()\r\n{\r\n\tif(form1.roomTypeInfos.value!=\"\") {\r\n\t\tvar itemCnt = parseInt($('#currBed').val());\r\n\t\tif(isNaN(itemCnt)) {\r\n\t\t\t$('#currBed').val(\"\");\r\n\t\t\t$(\"#itemsDiv\").html(\"\");\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tfor(i=0;i<itemCnt;i++) {\r\n\t\t\tdocument.getElementById(\"roomBeds[\" + i + \"].alldayPrice\").value = document.getElementById(\"roomTypeAlldayPrice\").value;\r\n\t\t\tdocument.getElementById(\"roomBeds[\" + i + \"].halfdayPrice\").value = document.getElementById(\"roomTypeHalfdayPrice\").value;\r\n\t\t}\r\n\t}\r\n}\r\n\r\n// form提交\r\nfunction formSubmit()\r\n{\r\n\tif(isEmpty(form1.roomNo))    {\r\n");
      out.write("\t\twindow.alert(\"请输入房号!\") ;\r\n\t\tform1.roomNo.focus(); \r\n\t\treturn;\r\n\t}\r\n\tif(isEmpty(form1.roomTypeInfos))    {\r\n\t\twindow.alert(\"请选择房型!\") ;\r\n\t\treturn;\r\n\t}\r\n\tif(! (getRadioValue(\"hireFlag\")[0]) ) {\r\n\t\talert(\"请选择客房出租类型，是按房间还是按床位出租。!\") ;\r\n\t\treturn;\r\n\t}\r\n\tif(isEmpty(form1.alldayPrice)) {\r\n\t\talert(\"请输入全日房价\");\r\n\t\treturn;\r\n\t}\r\n\tif(!isMoney(form1.alldayPrice)) {\r\n\t\treturn;\r\n\t}\r\n\tif(isEmpty(form1.halfdayPrice)) {\r\n\t\talert(\"请输入半天房价\");\r\n\t\treturn;\r\n\t}\r\n\tif(!isMoney(form1.halfdayPrice)) {\r\n\t\treturn;\r\n\t}\r\n\tif(form1.hourFlagSet.checked) {\r\n\t\tif(isEmpty(form1.hourMeasure) || !isInt(form1.hourMeasure)) {\r\n\t\t\talert(\"请输入非空的整数型钟点房小时信息！\");\r\n\t\t\tform1.hourMeasure.select();\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tif(isEmpty(form1.hourPrice) || !isMoney(form1.hourPrice)) {\r\n\t\t\talert(\"请输入非空的货币型钟点房价格信息！\");\r\n\t\t\tform1.hourPrice.select();\r\n\t\t\treturn;\r\n\t\t}\r\n\t}\r\n\t\r\n\tif(!isEmpty(form1.currBed)) {\r\n\t\tvar itemCnt = parseInt($('#currBed').val());\r\n\t\tif(isNaN(itemCnt)) {\r\n\t\t\talert(\"床位数必须是数字\");\r\n\t\t\tform1.currBed.select();\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tif(itemCnt>8 || itemCnt <1) {\r\n");
      out.write("\t\t\talert(\"房间数只能是1-8之间。\");\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tfor(i=0;i<itemCnt;i++) {\r\n\t\t\tvar bedNo = document.getElementsByName('roomBeds[' + i + '].bedNo')[0];\r\n\t\t\tvar alldayPriceBed = document.getElementsByName('roomBeds[' + i + '].alldayPrice')[0];\r\n\t\t\tvar halfdayPriceBed = document.getElementsByName('roomBeds[' + i + '].halfdayPrice')[0];\r\n\t\t\tvar hourFlagSetBed = document.getElementsByName('hourFlagSet' + i)[0];\r\n\t\t\tvar hourMeasureBed = document.getElementsByName('roomBeds[' + i + '].hourMeasure')[0];\r\n\t\t\tvar hourPriceBed = document.getElementsByName('roomBeds[' + i + '].hourPrice')[0];\r\n\t\t\tif(isEmpty(bedNo)) {\r\n\t\t\t\talert(\"请输入床号\");\r\n\t\t\t\tbedNo.select();\r\n\t\t\t\treturn;\r\n\t\t\t}\r\n\t\t\tif(isEmpty(alldayPriceBed)) {\r\n\t\t\t\talert(\"请输入全日房价\");\r\n\t\t\t\talldayPriceBed.select();\r\n\t\t\t\treturn;\r\n\t\t\t}\r\n\t\t\tif(!isMoney(alldayPriceBed)) {\r\n\t\t\t\talldayPriceBed.select();\r\n\t\t\t\treturn;\r\n\t\t\t}\r\n\t\t\tif(isEmpty(halfdayPriceBed)) {\r\n\t\t\t\talert(\"请输入半天房价\");\r\n\t\t\t\thalfdayPriceBed.select();\r\n\t\t\t\treturn;\r\n\t\t\t}\r\n\t\t\tif(!isMoney(halfdayPriceBed)) {\r\n\t\t\t\thalfdayPriceBed.select();\r\n");
      out.write("\t\t\t\treturn;\r\n\t\t\t}\r\n\t\t\tif(hourFlagSetBed.checked) {\r\n\t\t\t\tif(isEmpty(hourMeasureBed) || !isInt(hourMeasureBed)) {\r\n\t\t\t\t\talert(\"请输入非空的整数型钟点房小时信息！\");\r\n\t\t\t\t\thourMeasureBed.select();\r\n\t\t\t\t\treturn;\r\n\t\t\t\t}\r\n\t\t\t\tif(isEmpty(hourPriceBed) || !isMoney(hourPriceBed)) {\r\n\t\t\t\t\talert(\"请输入非空的货币型钟点房价格信息！\");\r\n\t\t\t\t\thourPriceBed.select();\r\n\t\t\t\t\treturn;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\t\r\n\tform1.action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/merRoom/create\"; \r\n\tform1.target=\"_self\";     // _blank\r\n\tform1.submit();\r\n}\r\n\r\n</script>\r\n</HEAD>\r\n<BODY>\r\n  <form name=\"form1\" method=post action=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" target=\"_self\">\r\n        <input type=\"hidden\" name=\"mer.id\"            value=\"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"state\"            value=\"");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"roomType.id\" value=\"");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write("\">\r\n        \r\n        <input type=\"hidden\" name=\"roomTypeAlldayPrice\">\r\n        <input type=\"hidden\" name=\"roomTypeHalfdayPrice\">\r\n        <input type=\"hidden\" name=\"roomTypeHourMeasure\">\r\n        <input type=\"hidden\" name=\"roomTypeHourPrice\">\r\n        <br>\r\n\t\t<div align=\"center\">\r\n\t\t  <TABLE class=\"hci\" border=\"1\" bordercolordark=\"#ffffff\" bordercolorlight=\"#eeeeee\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t    <TBODY>\r\n\t\t    <TR class=\"hcititle\">\r\n\t\t      <TD>【新增客房】</TD>\r\n\t\t    </TR>\r\n\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t房号：&nbsp;&nbsp;<input type=\"text\" name=\"roomNo\">&nbsp;&nbsp;\r\n\t\t\t\t\t房型：&nbsp;&nbsp;\r\n\t\t\t\t    <select name=\"roomTypeInfos\" onchange=\"setRoomTypeInfo(this.options[this.options.selectedIndex].value)\">\r\n\t\t\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t    </select>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t所属楼层：&nbsp;<input type=\"text\" name=\"floor\"        size=\"5\" maxlength=\"10\">&nbsp;&nbsp;\r\n\t\t\t\t\t所属楼栋：&nbsp;<input type=\"text\" name=\"building\"  size=\"10\" maxlength=\"12\">&nbsp;&nbsp;\r\n\t\t\t\t\t电话分机：&nbsp;<input type=\"text\" name=\"telExtension\"     size=\"15\" maxlength=\"20\">&nbsp;&nbsp;\r\n\t\t\t\t\t电话外线：&nbsp;<input type=\"text\" name=\"telExteriorLine\" size=\"15\" maxlength=\"20\">&nbsp;&nbsp;\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t门卡：&nbsp;&nbsp;<input type=\"text\" name=\"doorCard\">&nbsp;&nbsp;\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td><DIV>&nbsp;&nbsp;&nbsp;<input type=\"radio\" name=\"hireFlag\"  value=\"0\">按房间出租&nbsp;&nbsp;<input type=\"radio\" name=\"hireFlag\"  value=\"1\">拆零按床位出租&nbsp;&nbsp;</DIV></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t<input type=\"hidden\" name=\"hourFlag\"  value=\"1\">\r\n\t\t\t\t\t<DIV class=\"roomItemStyle\">全日房价<input type=\"text\" name=\"alldayPrice\" size=\"7\"  maxlength=\"5\">半天房价<input type=\"text\" name=\"halfdayPrice\" size=\"7\"  maxlength=\"5\"><br>\r\n\t\t\t\t\t\t\t\t是否钟点房<input checked type=checkbox name=hourFlagSet  onclick=\"hourFlagSetFunc(-1);\">价格：<input type=\"text\" name=\"hourMeasure\"size=\"7\"  maxlength=\"5\">小时<input type=\"text\" name=\"hourPrice\" size=\"7\"  maxlength=\"5\">元\r\n");
      out.write("\t\t\t\t\t</DIV>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t床位数：&nbsp;&nbsp;<input type=\"text\" id=\"currBed\" name=\"currBed\" size=\"7\"  maxlength=\"5\" onblur=\"addRoomBeds()\">&nbsp;&nbsp;\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td><div id=\"itemsDiv\"></div></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t特征描述：&nbsp;<textarea  name=\"roomDesc\"  cols=\"100\" rows=\"5\" ></textarea>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t    <TR>\r\n\t\t\t      <TD class=hcihead colspan=\"4\" style=\"text-align:center\">\r\n\t\t\t        <a href=\"javascript:formSubmit();\"><img src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\" border=0></a> \r\n\t\t\t        <a href=\"javascript:history.back();\"><img src=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\" border=0></a> \r\n\t\t\t      </TD>\r\n\t\t\t    </TR>\r\n\t\t    </TBODY> \r\n\t\t  </TABLE>\r\n\t\t</div>\r\n  </form>\r\n </body>\r\n</html>");
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
    // /pages/sys/merRoom/new.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("merRoom");
    // /pages/sys/merRoom/new.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${merRoom}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/sys/merRoom/new.jsp(3,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setScope("page");
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    // /pages/sys/merRoom/new.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("roomTypeList");
    // /pages/sys/merRoom/new.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roomTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/sys/merRoom/new.jsp(4,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setScope("page");
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f2);
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

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /pages/sys/merRoom/new.jsp(232,41) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/merRoom/create");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
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
    // /pages/sys/merRoom/new.jsp(233,61) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${merRoom.mer.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
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
    // /pages/sys/merRoom/new.jsp(234,60) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${merRoom.state}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent(null);
    // /pages/sys/merRoom/new.jsp(235,55) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param['roomType.id']}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /pages/sys/merRoom/new.jsp(254,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("rs");
    // /pages/sys/merRoom/new.jsp(254,9) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roomTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/sys/merRoom/new.jsp(254,9) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('"');
          out.write(' ');
          out.write(' ');
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write(' ');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</option>\r\n\t\t\t\t    \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /pages/sys/merRoom/new.jsp(255,25) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.id}-${rs.alldayPrice}-${rs.halfdayPrice}-${rs.hourMeasure}-${rs.hourPrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /pages/sys/merRoom/new.jsp(255,124) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param['roomType.id'] == rs.id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /pages/sys/merRoom/new.jsp(255,188) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
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
    // /pages/sys/merRoom/new.jsp(299,56) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/images/button/save.gif");
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
    // /pages/sys/merRoom/new.jsp(300,58) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/images/button/return.gif");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }
}
