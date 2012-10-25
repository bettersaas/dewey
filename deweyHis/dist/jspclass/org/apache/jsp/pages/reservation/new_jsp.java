package org.apache.jsp.pages.reservation;

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
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.release();
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
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f7(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f8(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f9(_jspx_page_context))
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
      out.write("\r\n<style>\r\n#traveller{\r\n\tfloat:left;\r\n\twidth: 30%;\r\n\tborder-right: 1px solid #cccccc;\r\n\tborder-bottom: 1px solid #cccccc;\r\n\tpadding-right: 10px;\r\n}\r\n#content{\r\n  float: right;\r\n  width: 69%;\r\n  margin: 0px;\r\n\tpadding: 0px;\r\n\tbackground-color: #eeeeee;\r\n\tborder-left: 1px solid #cccccc;\r\n\tborder-bottom: 1px solid #cccccc;\r\n}\r\n#siteInfo{\r\n\tclear: both;\r\n\tborder: 1px solid #cccccc;\r\n\tfont-size: 75%;\r\n\tcolor: #cccccc;\r\n\tpadding: 10px 10px 10px 10px;\r\n}\r\n.inputTextNoBorder{\r\n   BORDER-RIGHT: medium none;\r\n   BORDER-TOP: medium none;\r\n   BORDER-LEFT: medium none;\r\n   BORDER-BOTTOM:medium none;\r\n   FONT-SIZE:9pt;\r\n   WIDTH: 110; \r\n   TEXT-DECORATION: none ;\r\n  }\r\n.inputTextBorder{\r\n   BORDER-RIGHT: 1px solid ;\r\n   BORDER-TOP: 1px solid ;\r\n   BORDER-LEFT: 1px solid ;\r\n   BORDER-BOTTOM:1px solid;\r\n   FONT-SIZE:9pt;\r\n   WIDTH: 110;\r\n   TEXT-DECORATION: none;\r\n  }\r\n.mouseHover{\r\n\tcolor: blue;\r\n  }\r\n</style>\r\n<script src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" type=\"text/javascript\"></script>\r\n<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n//+---------------------------------------------------\r\n//| 房型查询空静房间\r\n//+---------------------------------------------------\r\nfunction searchByRroomTypeId()\r\n{\r\n\t\tvar searchRroomTypeId = document.getElementById(\"searchRroomTypeId\");\r\n\t\t// 入住类型不能为空\r\n\t\tvar stayType = form1.stayType.value;\r\n\t\tif(stayType==\"\") {\r\n\t\t\twindow.alert(\"入住类型不能为空!\") ;\r\n\t\t\tform1.stayType.focus();\r\n\t\t\tsearchRroomTypeId.selectedIndex=0;\r\n\t\t\treturn;\r\n\t\t}\r\n\t\t// 房型的选择\r\n\t\tif(searchRroomTypeId.value == \"\") {\r\n\t\t\tsearchRroomTypeId.focus();\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tsearchEmptyCleanRoom(\"\",searchRroomTypeId.value);\r\n}\r\n//+---------------------------------------------------\r\n//| 房号查询空静房间\r\n//+---------------------------------------------------\r\nfunction searchByRoomNo()\r\n{\r\n\t// 入住类型不能为空\r\n\tvar stayType = form1.stayType.value;\r\n\tif(stayType==\"\") {\r\n\t\twindow.alert(\"入住类型不能为空!\") ;\r\n\t\tform1.stayType.focus();\r\n\t\treturn;\r\n\t}\r\n\tvar roomSearchNum = $.trim($(\"#roomSearchNum\").val());\r\n");
      out.write("\t// 如果房号为空查询\r\n\tif(roomSearchNum == \"\"  || roomSearchNum == \"请输入房号\") {\r\n\t\t// 房型的查询\r\n\t\tvar searchRroomTypeId = document.getElementById(\"searchRroomTypeId\");\r\n\t\tif(searchRroomTypeId.value == \"\") {\r\n\t\t\talert(\"请输入房号查找或者选择房型查找！\");\r\n\t\t\t$(\"#roomSearchNum\").val(\"请输入房号\");\r\n\t\t\t$(\"#roomSearchNum\").select();\r\n\t\t\troomSearchNum = \"\";\r\n\t\t} else {\r\n\t\t\t// 房型查询\r\n\t\t\tsearchEmptyCleanRoom(\"\",searchRroomTypeId.value);\r\n\t\t}\r\n\t\treturn;\r\n\t}\r\n\tsearchEmptyCleanRoom(roomSearchNum,\"\");\r\n}\r\n//+---------------------------------------------------\r\n//| 通过ajax获取空净房信息\r\n//+---------------------------------------------------\r\nfunction searchEmptyCleanRoom(roomSearchNum,searchRroomTypeId)\r\n{\r\n\tvar merId = document.getElementById(\"mer.id\").value;\r\n\tvar contractualUnitId = document.getElementById(\"contractualUnitId\").value;\r\n\thtmlobj=$.ajax({\r\n\t    url: encodeURI(\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("?randValue=\" + getRandom()),\r\n\t    data: \"roomSearchNum=\"+roomSearchNum+\"&searchRroomTypeId=\"+searchRroomTypeId+\"&mer.id=\"+ merId +\"&contractualUnitId=\"+contractualUnitId,\r\n\t\ttype: \"POST\",\r\n\t\tdataType : \"json\",\r\n\t\tasync:false,  // 同步请求\r\n\t\ttimeout: 1000,\r\n\t\terror:function(xhr,error,exception) {\r\n\t\t    //解析JSON异常时或者ajax出错\r\n\t\t\talert(exception.toString());\r\n\t\t},\r\n\t\tsuccess:function(data, status, xhr){\r\n\t\t\tvar roomTrStr='';\r\n\t\t\t// 删除tobody中的所有行\r\n\t\t\t$(\"#tbd tr\").remove();\r\n\t\t\t// 报错误信息\r\n\t\t\tif(data.message != \"\") {\r\n\t\t\t\t// 页面显示查无空净房的提示信息  弹出提示信息alert(data.message);\r\n\t\t\t\t$(\"#tbd\").append('<tr class=\"rescontent\"><td colspan=\"9\" align=\"center\">' + data.message + '<br></td></tr>');\r\n\t\t\t} else {\r\n\t\t\t\t// 获取json中的客房信息\r\n\t\t\t\tvar jsonData = data.merRooms;\r\n\t\t\t\tvar roomTrStr = \"\";\r\n\t\t\t\t// 遍历每个房间信息，生成每行客房记录html字符串，并加入到空净客房的尾部\r\n\t\t\t\tfor(var i=0;i<jsonData.length;i++){\r\n\t\t\t\t\troomTrStr = '<tr>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\" style=\"border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;\"><input type=\"checkbox\" name=\"ids\" onclick=\"selectCheckInRoom(this,' + i + ')\" value=\"'+ i + ';' + jsonData[i][\"roomId\"] + ';' + jsonData[i][\"roomNo\"] + ';' + jsonData[i][\"bedId\"] + ';' + jsonData[i][\"bedNo\"] + '\">' + (i+1)  + '</td>';\r\n");
      out.write("\t\t\t\t\troomTrStr += '<input type=\"hidden\" name=\"hireFlag' + i + '\"  id=\"hireFlag' + i + '\"  value=\"' + jsonData[i][\"hireFlag\"] + '\">';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"roomTypeName\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"roomNo\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"bedNo\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"alldayPrice\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"halfdayPrice\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"hourPrice\"] + '/'+ jsonData[i][\"hourMeasure\"]  + '小时</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"roomDesc\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\"><input type=\"text\" disabled name=\"discount' + i + '\" id=\"discount' + i + '\" onblur=\"discountInput(' + i + ');\"  size=\"8\" maxlength=\"5\" class=\"inputTextNoBorder\"></td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\"><input type=\"text\" disabled name=\"amount' + i + '\"  id=\"amount' + i + '\"  onblur=\"amountInput(' + i + ');\" \" size=\"8\" maxlength=\"7\" class=\"inputTextNoBorder\"></td>';\r\n");
      out.write("\t\t\t\t\troomTrStr += '</tr>';\r\n\t\t\t\t\t$(\"#tbd\").append(roomTrStr);\r\n\t\t\t\t\t// 查询后设置入住房型\r\n\t\t\t\t\tdocument.getElementsByName(\"roomType.id\")[0].value=jsonData[i][\"roomTypeId\"];\r\n\t\t\t\t\t// 设置入住类型相对应的房间价格\r\n\t\t\t\t\tselectCheckInType();\r\n\t\t\t\t}\r\n\t\t\t\t// 奇偶行不同颜色\r\n\t\t\t\t$(\"#emptyRoom tbody tr:odd\").addClass(\"rescontent_\");  // 索引奇数\r\n\t\t\t\t$(\"#emptyRoom tbody tr:even\").addClass(\"rescontent\");\r\n\t\t\t\t// 鼠标移动行变色\r\n\t\t\t\t$(\"#emptyRoom tbody tr\").hover(function(){\r\n\t\t\t\t    $(this).addClass(\"mouseHover\");\r\n\t\t\t\t},function(){\r\n\t\t\t\t    $(this).removeClass(\"mouseHover\");\r\n\t\t\t\t});\r\n\t\t\t}\r\n\t\t}\r\n\t});\r\n}\r\n//+---------------------------------------------------\r\n//| 选择入住房间\r\n//| obj.checked      id:roomId\r\n//+---------------------------------------------------\r\nfunction selectCheckInRoom(obj,index)\r\n{\r\n\t// 选择的房间\r\n\tif(obj.checked) {\r\n\t\t$(\"#discount\" + index).removeClass();\r\n\t\t$(\"#amount\" + index).removeClass();\r\n\t\t$(\"#discount\" + index).addClass(\"inputTextBorder\");\r\n\t\t$(\"#amount\" + index).addClass(\"inputTextBorder\");\r\n\t\t$(\"#discount\" + index).val(\"\").removeAttr(\"disabled\");\r\n");
      out.write("\t\t$(\"#amount\" + index).val(\"\").removeAttr(\"disabled\");\r\n\t} else {\r\n\t\t$(\"#discount\" + index).removeClass();\r\n\t\t$(\"#amount\" + index).removeClass();\r\n\t\t$(\"#discount\" + index).addClass(\"inputTextNoBorder\");\r\n\t\t$(\"#amount\" + index).addClass(\"inputTextNoBorder\");\r\n\t\t$(\"#discount\" + index).val(\"\").attr(\"disabled\",\"disabled\");\r\n\t\t$(\"#amount\" + index).val(\"\").attr(\"disabled\",\"disabled\");\r\n\t}\r\n}\r\n//+---------------------------------------------------\r\n//| 入住类型的选择\r\n//+---------------------------------------------------\r\nfunction selectCheckInType()\r\n{\r\n\tvar stayTypeValue = document.getElementsByName(\"stayType\")[0].value;\r\n\t// 根据不同的选择，只显示当前选择的入住类型价格\r\n\tswitch(stayTypeValue){\r\n\t\t// 半天房\r\n\t\tcase \"1\" :\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).hide()});   // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).hide()});   // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).show()}); // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).show()});  // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});   // 钟点房\r\n");
      out.write("\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 全日房\r\n\t\tcase '2':\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 钟点房\r\n\t\tcase '3':\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).hide()});   // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).hide()});    // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});    // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});    // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).show()});  // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).show()});   // 钟点房\r\n");
      out.write("\t\t\tbreak;\r\n\t\t// 长包房\r\n\t\tcase '4':\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 默认为空\r\n\t\tdefault : \r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).hide()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).hide()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});  // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});  // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});  // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});  // 钟点房\r\n\t}\r\n\t// 清空先前的折扣率和折扣价\r\n\t$(\"#emptyRoom tbody tr\").each(function(index){\r\n");
      out.write("\t\t$(\"#discount\" + index).val(\"\");\r\n\t\t$(\"#amount\" + index).val(\"\");\r\n\t});\r\n}\r\n//+---------------------------------------------------\r\n//| 折扣的输入计算折扣价\r\n//+---------------------------------------------------\r\nfunction discountInput(index)\r\n{\r\n\t$(\"#discount\" + index).val($.trim($(\"#discount\" + index).val()));\r\n\tvar discount = $(\"#discount\" + index).val();\r\n\tif (discount == \"\") {\r\n\t\treturn;\r\n\t}\r\n\tif (!isDecimal(discount)) {\r\n\t\talert(\"请输入正确的折扣率。\");\r\n\t\t$(\"#discount\" + index).select();\r\n\t\treturn;\r\n\t}\r\n\tif (parseFloat(discount)>10 || parseFloat(discount)<0) {\r\n\t\talert(\"请输入正确的折扣率。折扣率在0到10之间。\");\r\n\t\t$(\"#discount\" + index).select();\r\n\t\treturn;\r\n\t}\r\n\tvar stayTypeValue = document.getElementsByName(\"stayType\")[0].value;\r\n\tvar basePrice = \"\";\r\n\t// 根据不同的选择，选择需要打折扣的价格\r\n\tswitch(stayTypeValue){\r\n\t\t// 半天房\r\n\t\tcase \"1\" :\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(5)\").text();\r\n\t\t\tbreak;\r\n\t\t// 全日房\r\n\t\tcase '2':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 钟点房\r\n\t\tcase '3':\r\n");
      out.write("\t\t\tbasePrice = ($(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(6)\").text().split(\"/\"))[0];\r\n\t\t\tbreak;\r\n\t\t// 长包房\r\n\t\tcase '4':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 默认为空\r\n\t\tdefault : \r\n\t\t\treturn;\r\n\t}\r\n\t$(\"#amount\" + index).val(getRoundNumber(eval(basePrice + \"*\" + discount + \"/10\"),2));\r\n}\r\n//+---------------------------------------------------\r\n//| 由折扣价格计算相应的折扣率进行回显\r\n//+---------------------------------------------------\r\nfunction amountInput(index)\r\n{\r\n\t$(\"#amount\" + index).val($.trim($(\"#amount\" + index).val()));\r\n\tvar amount = $(\"#amount\" + index).val();\r\n\tif (amount == \"\") {\r\n\t\treturn;\r\n\t}\r\n\tif (!isDecimal(amount)) {\r\n\t\talert(\"请输入正确的折扣价。\");\r\n\t\t$(\"#amount\" + index).select();\r\n\t\treturn;\r\n\t}\r\n\tvar stayTypeValue = document.getElementsByName(\"stayType\")[0].value;\r\n\tvar basePrice = \"\";\r\n\t// 根据不同的选择，选择需要打折扣的价格\r\n\tswitch(stayTypeValue){\r\n\t\t// 半天房\r\n\t\tcase \"1\" :\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(5)\").text();\r\n\t\t\tbreak;\r\n\t\t// 全日房\r\n\t\tcase '2':\r\n");
      out.write("\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 钟点房\r\n\t\tcase '3':\r\n\t\t\tbasePrice = ($(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(6)\").text().split(\"/\"))[0];\r\n\t\t\tbreak;\r\n\t\t// 长包房\r\n\t\tcase '4':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 默认为空\r\n\t\tdefault : \r\n\t\t\treturn;\r\n\t}\r\n\t$(\"#discount\" + index).val(getRoundNumber(eval(amount + \"*10/\" + basePrice),2));\r\n}\r\n</script>\r\n</HEAD>\r\n<BODY>\r\n        <div style=\"height:3px;\"></div>\r\n\t\t<div align=\"center\" id=\"traveller\">\r\n\t\t<form name=\"form1\" method=post action=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\" target=\"_self\">\r\n\t\t<input type=\"hidden\" name=\"mer.id\" value=\"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n\t\t <input type=\"hidden\" name=\"roomType.id\" >\r\n\t\t <input type=\"hidden\" name=\"contractualUnitName\" >\r\n\t\t <div id=\"selectCheckInRooms\" style=\"display:none;\"></div>\r\n\t\t  <TABLE class=\"hci\" border=\"1\" bordercolordark=\"#ffffff\" bordercolorlight=\"#eeeeee\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t    <TBODY> \r\n\t\t    <TR class=\"hcititle\"> \r\n\t\t      <TD colSpan=\"2\">【旅客预订登记信息】</TD>\r\n\t\t    </TR>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">入住类型</td>\r\n\t\t\t\t\t<td class=hcicontent>\r\n\t\t\t\t\t    <select name=\"stayType\" onchange=\"selectCheckInType();\">\r\n\t\t\t\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t\t\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t\t    </select><font color=\"red\">*</font>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">姓名</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"custName\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">性别</td>\r\n\t\t\t\t\t<td class=hcicontent >\r\n\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">联系电话</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"phone\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">证件类型</td>\r\n\t\t\t\t\t<td class=hcicontent >\r\n\t\t\t\t\t    <select name=\"idType\">\r\n\t\t\t\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t\t\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t\t    </select>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">证件号码</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"idNo\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">地址</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"address\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">人数</td>\r\n\t\t\t\t\t<td class=hcicontent > <input type=\"text\" name=\"peopleNum\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">预计入住日期</td>\r\n\t\t\t\t\t<td class=hcicontent >\r\n\t\t\t\t\t<input type=\"text\" name=\"arrivalDate\" id=\"arrivalDate\" size=\"20\" maxlength=\"19\" readonly=\"readonly\">\r\n\t\t\t\t\t<img  src='images/calen_pic.gif'  width=\"17\" height=\"18\" align=\"absmiddle\" onclick=\"new Calendar(2000, 2050, 0).show(form1.arrivalDate,null,'yyyy-MM-dd hh:mm',true);\" />\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">预计离店日期</td>\r\n\t\t\t\t\t<td class=hcicontent >\r\n\t\t\t\t\t<input type=\"text\" name=\"planDepartureDate\" id=\"planDepartureDate\" size=\"20\" maxlength=\"19\" readonly=\"readonly\">\r\n\t\t\t\t\t<img  src='images/calen_pic.gif'  width=\"17\" height=\"18\" align=\"absmiddle\" onclick=\"new Calendar(2000, 2050, 0).show(form1.planDepartureDate,null,'yyyy-MM-dd hh:mm',true);\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">预计入住天数</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"stayDays\" size=\"6\" maxlength=\"3\" readOnly class=\"inputTextNoBorder\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">付款方式</td>\r\n\t\t\t\t\t<td class=hcicontent>\r\n\t\t\t\t\t    <select name=\"settleMode\">\r\n\t\t\t\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t\t\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t\t    </select>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">签单挂账单位</td>\r\n\t\t\t\t\t<td class=hcicontent >\r\n\t\t\t\t\t    <select name=\"contractualUnitId\" id=\"contractualUnitId\">\r\n\t\t\t\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t\t\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f4(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t\t    </select>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">预付押金</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"deposit\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">旅客类别</td>\r\n\t\t\t\t\t<td class=hcicontent >\r\n\t\t\t\t\t    <select name=\"custType\">\r\n\t\t\t\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t\t\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f5(_jspx_page_context))
        return;
      out.write("\r\n\t\t\t\t\t    </select>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">早餐券</td>\r\n\t\t\t\t\t<td class=hcicontent ><input type=\"text\" name=\"breakfastTicket\" size=\"5\"  maxlength=\"3\" style=\"ime-mode:disabled\" onkeyup=\"value=value.replace(/[^\\d]/g,'') \"onbeforepaste=\"clipboardData.setData('text',clipboardData.getData('text').replace(/[^\\d]/g,''))\">&nbsp;张</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\"hcihead\">备注</td>\r\n\t\t\t\t\t<td class=hcicontent ><textarea  rows=\"2\" cols=\"30\" name=\"remark\"></textarea></td>\r\n\t\t\t\t</tr>\r\n\t\t    </TBODY>\r\n\t\t  </TABLE>\r\n\t\t</div>\r\n\t\t<div id=\"content\" >\r\n\t\t    <div id=\"sectionLinks\" style=\"width:100%;height:430px; overflow:scroll; border:1px solid;\">\r\n\t\t    <div id=\"search\">\r\n\t\t      【空净房】\r\n\t\t       &nbsp;&nbsp;\r\n\t\t      房型:<select name=\"searchRroomTypeId\" id=\"searchRroomTypeId\" onchange=\"searchByRroomTypeId();\">\r\n\t\t    \t<option value=\"\">--请选择--</option>\r\n\t\t    \t");
      if (_jspx_meth_c_005fforEach_005f6(_jspx_page_context))
        return;
      out.write("\r\n\t\t     </select>\r\n\t\t     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t     房号:<input name=\"roomSearchNum\" type=\"text\" size=\"10\" id=\"roomSearchNum\"   value=\"请输入房号 \" onFocus=\"if (value =='请输入房号 '){value =''}\" onBlur=\"if (value ==''){value='请输入房号 '}\"/>\r\n\t\t      <input name=\"goButton\" type=\"button\"  onclick=\"javascript:searchByRoomNo();\"  value=\"搜索\" />\r\n\t\t    </div>\r\n\t\t    </form>\r\n\t\t    <form name=\"form2\" method=post action=\"#\" target=\"_self\">\r\n\t\t    <table  id=\"emptyRoom\" width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" summary=\"方法 \" style=\"border-collapse:collapse;\">\r\n\t\t   \t\t<thead>\r\n\t\t\t    <tr class=\"reshead\" id=\"merRoomTitle\">\r\n\t\t\t\t    <th scope=\"col\">序号</th>\r\n\t\t\t\t    <th scope=\"col\">房型</th>\r\n\t\t\t\t    <th scope=\"col\">房号</th>\r\n\t\t\t\t    <th scope=\"col\">床号</th>\r\n\t\t\t\t    <th scope=\"col\">全日房价</th>\r\n\t\t\t\t    <th scope=\"col\">半日房价</th>\r\n\t\t\t\t    <th scope=\"col\">钟点房价</th>\r\n\t\t\t\t    <th scope=\"col\" width=\"30%\">房间说明</th>\r\n\t\t\t\t    <th scope=\"col\">折扣比例(/折)</th>\r\n\t\t\t\t    <th scope=\"col\">折扣价格</th>\r\n\t\t\t    </tr>\r\n\t\t\t    </thead>\r\n");
      out.write("\t\t\t    <tbody id=\"tbd\">\r\n\t\t\t\t\t\t<tr  class=\"rescontent\">\r\n\t\t\t\t\t\t\t<td colspan=\"10\" align=\"center\">请查询相应入住房型的空净房间。<br></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t</tbody>\r\n\t\t    </table>\r\n\t\t    </form>\r\n\t\t   </div>\r\n\t\t   <!-- end 空净房 -->\r\n\t\t</div>\r\n\t\t<div id=\"siteInfo\" align=\"center\"> \r\n\t\t\t<input  type=\"button\" name=\"save\"  onclick=\"javascript:readIdentity();\"  value=\"读二代证\" />&nbsp;&nbsp;\r\n\t\t\t<input  type=\"button\" name=\"save\"  onclick=\"javascript:readMemberCard();\"  value=\"会员房价\" />&nbsp;&nbsp;\r\n\t\t\t<input  type=\"button\" name=\"save\"  onclick=\"javascript:operatorDiscount();\"  value=\"操作员折扣\" />&nbsp;&nbsp;\r\n\t\t\t<input  type=\"button\" name=\"save\"  onclick=\"javascript:formSubmit();\"  value=\"提交预订\" />&nbsp;&nbsp;\r\n\t\t</div>\r\n\t\t<br />\r\n </BODY>\r\n <script language=\"JavaScript\" type=\"text/JavaScript\">\r\n//+---------------------------------------------------\r\n//| 订房制卡\r\n//+---------------------------------------------------\r\nfunction formSubmit()\r\n{\r\n\t// 协议单位赋值\r\n\tvar contractualUnitId = form1.contractualUnitId.value;\r\n\tif(contractualUnitId!=\"\") {\r\n\t\tvar obj=document.getElementById(\"contractualUnitId\");\r\n");
      out.write("\t\tfor(i=0; obj.length; i++){\r\n\t\t\tif(obj[i].selected==true){\r\n\t\t\t\tform1.contractualUnitName.value = obj[i].innerText;\r\n\t\t\t\tbreak;\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\t\r\n\t// 早餐券不为空时判断其是否是整数\r\n\tif(!isEmpty(form1.breakfastTicket))    {\r\n\t\tcntBft = parseInt(form1.breakfastTicket.value,10);\r\n\t\tif(isNaN(cntBft)) {\r\n\t\t\twindow.alert(\"早餐券的数量必须是整数!\") ;\r\n\t\t\tform1.breakfastTicket.select();\r\n\t\t\treturn;\r\n\t\t}\r\n\t}\r\n\t\r\n\tvar arrivalDate =  form1.arrivalDate.value;\r\n\t// 入住日期不能为空\r\n\tif(isEmpty(form1.arrivalDate)) {\r\n\t\twindow.alert(\"入住日期不能为空!\") ;\r\n\t\tform1.arrivalDate.select();\r\n\t\treturn;\r\n\t}\r\n\t// 检查入住日期不能小于当前时间\r\n\t//var now = new Date();\r\n\t//var truncMinuteNowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes());\r\n\t//var time1 = truncMinuteNowDate.getTime();       // 当前日期\r\n\tvar arrivalDateSplit = arrivalDate.split(/[- :]/);\r\n\tvar time2 = new Date(arrivalDateSplit[0], arrivalDateSplit[1]-1, arrivalDateSplit[2], arrivalDateSplit[3], arrivalDateSplit[4]).getTime();\r\n\t//if(time1 > time2) {   // 入住时间比当前时间晚\r\n\t//\twindow.alert(\"入住时间比当前时间还早，请设定当前以后的时间!\") ;\r\n");
      out.write("\t//\tform1.arrivalDate.select();\r\n\t//\treturn;\r\n\t//}\r\n\tvar planDepartureDate =  form1.planDepartureDate.value;\r\n\t// 预计离店日期\r\n\tif(isEmpty(form1.planDepartureDate)) {\r\n\t\twindow.alert(\"预计离店日期不能为空!\") ;\r\n\t\tform1.planDepartureDate.select();\r\n\t\treturn;\r\n\t}\r\n\t// 检查入住日期必须比预计离店日期早\r\n\tvar planDepartureDateSplit = planDepartureDate.split(/[- :]/);\r\n\tvar time3 = new Date(planDepartureDateSplit[0], planDepartureDateSplit[1]-1, planDepartureDateSplit[2], planDepartureDateSplit[3], planDepartureDateSplit[4]).getTime();\r\n\tif(time2 >= time3) {   // 入住时间必须比预计离店日期早\r\n\t\twindow.alert(\"入住时间必须比预计离店日期早，请修改!\") ;\r\n\t\tform1.planDepartureDate.select();\r\n\t\treturn;\r\n\t}\r\n\t// 设定入住天数\r\n\tvar cha=(time3-time2)/(1000*60*60*24);\r\n\tform1.stayDays.value=getRoundNumber(Math.abs(cha),2);\r\n\t\r\n\t// 入住类型不能为空\r\n\tvar stayType = form1.stayType.value;\r\n\tif(stayType==\"\") {\r\n\t\twindow.alert(\"入住类型不能为空!\") ;\r\n\t\tform1.stayType.focus();\r\n\t\treturn;\r\n\t}\r\n\r\n\t// 清空已选客房信息\r\n\t$('#selectCheckInRooms').html(\"\");\r\n\t// 已选择的进行顺序编号\r\n\tvar selectInt = -1;\r\n    $(\"input[name='ids']\").each(function(){\r\n");
      out.write("    \t// 选择\r\n    \tif (this.checked) {\r\n    \t\tselectInt += 1;\r\n    \t\tvar arr = this.value.split(\";\");\r\n    \t\tvar index = arr[0];        // tr中的索引\r\n    \t\tvar roomId = arr[1];     // 房间ID\r\n    \t\tvar roomNo = arr[2];   // 房号\r\n    \t\tvar bedId = arr[3];       // 床位ID\r\n    \t\tvar bedNo = arr[4];     // 床号\r\n    \t\tvar discount = $(\"#discount\" + index).val();          // 折扣比例\r\n    \t\tvar amount =   $(\"#amount\" + index).val();            // 折扣价格\r\n    \t\tvar checkInType = $(\"#hireFlag\" + index).val();    // 租房方式\r\n\t\t\t// 原价格\r\n   \t\t\tvar amountPrice;\r\n   \t\t\tswitch(stayType) {\r\n\t\t\t\t// 半天房\r\n\t\t\t\tcase \"1\" :\r\n\t\t\t\t\tamountPrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(5)\").text();\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t// 全日房\r\n\t\t\t\tcase '2':\r\n\t\t\t\t\tamountPrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t// 钟点房\r\n\t\t\t\tcase '3':\r\n\t\t\t\t\tamountPrice = ($(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(6)\").text().split(\"/\"))[0];\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t// 长包房\r\n\t\t\t\tcase '4':\r\n\t\t\t\t\tamountPrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n");
      out.write("\t\t\t\t\tbreak;\r\n   \t\t\t}\r\n   \t\t\t// 没有折扣时，默认10折全价\r\n    \t\tif (amount == \"\") {\r\n    \t\t\tdiscount = 10;\r\n    \t\t\tamount = amountPrice;\r\n    \t\t}\r\n    \t\t$('#selectCheckInRooms').append(\r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].roomId' value='\" +roomId + \"' >\" + \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].roomNo' value='\" + roomNo + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].bedId' value='\" +bedId + \"' >\" + \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].bedNo' value='\" + bedNo + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].discount' value='\" + discount + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].amount' value='\" + amount + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].checkInType' value='\" + checkInType + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].merId' value='");
      if (_jspx_meth_c_005fout_005f15(_jspx_page_context))
        return;
      out.write("' >\" +\r\n    \t\t\"<input type='hidden' name='custCheckInRooms[\" + selectInt  + \"].registPrice' value='\" + amountPrice + \"' >\");    //alert($('#selectCheckInRooms').html());\r\n    \t}\r\n\t});\r\n\tif(selectInt == -1) {\r\n\t\talert(\"没有选择入住客房！\");\r\n\t\treturn;\r\n\t}\r\n\tform1.action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/checkIn/create\";\r\n\tform1.target=\"_self\";\r\n\tform1.submit();\r\n}\r\n\r\n//+---------------------------------------------------\r\n//| 选择入住日期/预计离店日期后自动设置入住天数\r\n//+---------------------------------------------------\r\n// propertychange在IE7是异步响应\r\nfunction setStayDays() {\r\n\tvar arrivalDate =  form1.arrivalDate.value;\r\n\t// 入住日期不能为空\r\n\tif(isEmpty(form1.arrivalDate)) {\r\n\t\treturn;\r\n\t}\r\n\t// 检查入住日期不能小于当前时间\r\n\tvar now = new Date();\r\n\t//var truncMinuteNowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes());\r\n\t//var time1 = truncMinuteNowDate.getTime();       // 当前日期\r\n\tvar arrivalDateSplit = arrivalDate.split(/[- :]/);\r\n\tvar time2 = new Date(arrivalDateSplit[0], arrivalDateSplit[1]-1, arrivalDateSplit[2], arrivalDateSplit[3], arrivalDateSplit[4]).getTime();\r\n\t//if(time1 > time2) {   // 入住时间比当前时间还早\r\n\t//\twindow.alert(\"入住时间比当前时间还早，请设定当前以后的时间!\") ;\r\n\t//\tform1.arrivalDate.select();\r\n\t//\treturn;\r\n\t//}\r\n\tvar planDepartureDate =  form1.planDepartureDate.value;\r\n\t// 预计离店日期为空\r\n\tif(isEmpty(form1.planDepartureDate)) {\r\n");
      out.write("\t\treturn;\r\n\t}\r\n\t// 检查入住日期必须比预计离店日期早\r\n\tvar planDepartureDateSplit = planDepartureDate.split(/[- :]/);\r\n\tvar time3 = new Date(planDepartureDateSplit[0], planDepartureDateSplit[1]-1, planDepartureDateSplit[2], planDepartureDateSplit[3], planDepartureDateSplit[4]).getTime();\r\n\tif(time2 >= time3) {   // 入住时间必须比预计离店日期早\r\n\t\twindow.alert(\"入住时间必须比预计离店日期早，请修改!\") ;\r\n\t\tform1.planDepartureDate.select();\r\n\t\treturn;\r\n\t}\r\n\t// 设定入住天数\r\n\tvar cha=(time3-time2)/(1000*60*60*24);\r\n\tform1.stayDays.value=getRoundNumber(Math.abs(cha),2);\r\n}\r\n\r\n/********************************************************\r\n js更改文本框的值后不触发onChange事件问题 \r\n********************************************************/\r\n//IE  $.browser.msie   navigator.userAgent.indexOf(\"MSIE\")>0\r\nif($.browser.msie){\r\n\t// .unbind(\"propertychange\")\r\n\t// document.getElementById('arrivalDate').attachEvent(\"onpropertychange\",setStayDays);\r\n\t$('#arrivalDate').bind('propertychange', function(event) {\r\n\t        if($.syncProcessSign) return ;\r\n\t        $.syncProcessSign = true;\r\n\t        setStayDays();\r\n");
      out.write("\t        $.syncProcessSign = false;\r\n\t});\r\n    // document.getElementById('planDepartureDate').attachEvent(\"onpropertychange\",setStayDays);\r\n    $('#planDepartureDate').bind('propertychange', function(event) {\r\n\t        if($.syncProcessSign1) return ;\r\n\t        $.syncProcessSign1 = true;\r\n\t        setStayDays();\r\n\t        $.syncProcessSign1 = false;\r\n\t});\r\n//FF\r\n}else if(navigator.userAgent.indexOf(\"Firefox\")>0){\r\n    document.getElementById('arrivalDate').addEventListener(\"input\",setStayDays,false);\r\n    document.getElementById('planDepartureDate').addEventListener(\"input\",setStayDays,false);\r\n}\r\n </script>\r\n</HTML>");
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
    // /pages/reservation/new.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("SexList");
    // /pages/reservation/new.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SexList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(3,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /pages/reservation/new.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("IdTypeList");
    // /pages/reservation/new.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IdTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(4,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setScope("page");
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent(null);
    // /pages/reservation/new.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("StayTypeList");
    // /pages/reservation/new.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${StayTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(5,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setScope("page");
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f4.setParent(null);
    // /pages/reservation/new.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setVar("SettleModeList");
    // /pages/reservation/new.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SettleModeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(6,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setScope("page");
    int _jspx_eval_c_005fset_005f4 = _jspx_th_c_005fset_005f4.doStartTag();
    if (_jspx_th_c_005fset_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f5.setParent(null);
    // /pages/reservation/new.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setVar("CustTypeList");
    // /pages/reservation/new.jsp(7,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${CustTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(7,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setScope("page");
    int _jspx_eval_c_005fset_005f5 = _jspx_th_c_005fset_005f5.doStartTag();
    if (_jspx_th_c_005fset_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f6 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f6.setParent(null);
    // /pages/reservation/new.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setVar("StatusList");
    // /pages/reservation/new.jsp(8,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${StatusList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(8,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setScope("page");
    int _jspx_eval_c_005fset_005f6 = _jspx_th_c_005fset_005f6.doStartTag();
    if (_jspx_th_c_005fset_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f7 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f7.setParent(null);
    // /pages/reservation/new.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setVar("roomTypeList");
    // /pages/reservation/new.jsp(9,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roomTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(9,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setScope("page");
    int _jspx_eval_c_005fset_005f7 = _jspx_th_c_005fset_005f7.doStartTag();
    if (_jspx_th_c_005fset_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f8 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f8.setParent(null);
    // /pages/reservation/new.jsp(10,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setVar("contractualUnitList");
    // /pages/reservation/new.jsp(10,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contractualUnitList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(10,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setScope("page");
    int _jspx_eval_c_005fset_005f8 = _jspx_th_c_005fset_005f8.doStartTag();
    if (_jspx_th_c_005fset_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f9 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f9.setParent(null);
    // /pages/reservation/new.jsp(11,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setVar("checkIn");
    // /pages/reservation/new.jsp(11,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(11,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setScope("page");
    int _jspx_eval_c_005fset_005f9 = _jspx_th_c_005fset_005f9.doStartTag();
    if (_jspx_th_c_005fset_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f9);
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
    // /pages/reservation/new.jsp(61,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/scripts/calendar.js");
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
    // /pages/reservation/new.jsp(122,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/checkIn/searchRoom");
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
    // /pages/reservation/new.jsp(352,41) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/checkIn/create");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
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
    // /pages/reservation/new.jsp(353,44) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.mer.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
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
    // /pages/reservation/new.jsp(367,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("rs");
    // /pages/reservation/new.jsp(367,10) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${StayTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(367,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('"');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</option>\r\n\t\t\t\t\t    \t");
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

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /pages/reservation/new.jsp(368,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /pages/reservation/new.jsp(368,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /pages/reservation/new.jsp(381,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("rs");
    // /pages/reservation/new.jsp(381,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SexList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(381,6) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t\t\t\t<input type=\"radio\" name=\"sex\"  value=\"");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("\r\n\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /pages/reservation/new.jsp(382,46) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /pages/reservation/new.jsp(382,76) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /pages/reservation/new.jsp(395,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("rs");
    // /pages/reservation/new.jsp(395,10) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IdTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(395,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          out.write('"');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          out.write("</option>\r\n\t\t\t\t\t    \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /pages/reservation/new.jsp(396,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /pages/reservation/new.jsp(396,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f3.setParent(null);
    // /pages/reservation/new.jsp(436,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setVar("rs");
    // /pages/reservation/new.jsp(436,10) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SettleModeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(436,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
      if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f7(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
            return true;
          out.write('"');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f8(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
            return true;
          out.write("</option>\r\n\t\t\t\t\t    \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /pages/reservation/new.jsp(437,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /pages/reservation/new.jsp(437,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent(null);
    // /pages/reservation/new.jsp(447,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVar("rs");
    // /pages/reservation/new.jsp(447,10) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contractualUnitList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(447,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f9(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write('"');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f10(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("</option>\r\n\t\t\t\t\t    \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /pages/reservation/new.jsp(448,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f9 = _jspx_th_c_005fout_005f9.doStartTag();
    if (_jspx_th_c_005fout_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /pages/reservation/new.jsp(448,54) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.company}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f10 = _jspx_th_c_005fout_005f10.doStartTag();
    if (_jspx_th_c_005fout_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f5.setParent(null);
    // /pages/reservation/new.jsp(462,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setVar("rs");
    // /pages/reservation/new.jsp(462,10) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${CustTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(462,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f5 = _jspx_th_c_005fforEach_005f5.doStartTag();
      if (_jspx_eval_c_005fforEach_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f11(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write('"');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f12(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write("</option>\r\n\t\t\t\t\t    \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f5.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /pages/reservation/new.jsp(463,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f11 = _jspx_th_c_005fout_005f11.doStartTag();
    if (_jspx_th_c_005fout_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f12 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /pages/reservation/new.jsp(463,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f12.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f12 = _jspx_th_c_005fout_005f12.doStartTag();
    if (_jspx_th_c_005fout_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f6 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f6.setParent(null);
    // /pages/reservation/new.jsp(486,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setVar("rs");
    // /pages/reservation/new.jsp(486,7) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roomTypeList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reservation/new.jsp(486,7) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setVarStatus("vStatus");
    int[] _jspx_push_body_count_c_005fforEach_005f6 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f6 = _jspx_th_c_005fforEach_005f6.doStartTag();
      if (_jspx_eval_c_005fforEach_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t    \t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f13(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
            return true;
          out.write('"');
          out.write(' ');
          out.write('>');
          if (_jspx_meth_c_005fout_005f14(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
            return true;
          out.write("</option>\r\n\t\t    \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f6.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f6);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f13 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /pages/reservation/new.jsp(487,23) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f13.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f13 = _jspx_th_c_005fout_005f13.doStartTag();
    if (_jspx_th_c_005fout_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f14 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /pages/reservation/new.jsp(487,51) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f14.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rs.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f14 = _jspx_th_c_005fout_005f14.doStartTag();
    if (_jspx_th_c_005fout_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f15 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f15.setParent(null);
    // /pages/reservation/new.jsp(652,85) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f15.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.mer.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f15 = _jspx_th_c_005fout_005f15.doStartTag();
    if (_jspx_th_c_005fout_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f15);
    return false;
  }
}
