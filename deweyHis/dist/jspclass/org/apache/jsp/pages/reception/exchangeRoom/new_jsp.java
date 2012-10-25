package org.apache.jsp.pages.reception.exchangeRoom;

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
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.release();
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
      out.write("\r\n<style>\r\n.inputTextNoBorder{\r\n   BORDER-RIGHT: medium none;\r\n   BORDER-TOP: medium none;\r\n   BORDER-LEFT: medium none;\r\n   BORDER-BOTTOM:medium none;\r\n   FONT-SIZE:9pt;\r\n   WIDTH: 110; \r\n   TEXT-DECORATION: none ;\r\n  }\r\n.inputTextBorder{\r\n   BORDER-RIGHT: 1px solid ;\r\n   BORDER-TOP: 1px solid ;\r\n   BORDER-LEFT: 1px solid ;\r\n   BORDER-BOTTOM:1px solid;\r\n   FONT-SIZE:9pt;\r\n   WIDTH: 110;\r\n   TEXT-DECORATION: none;\r\n  }\r\n</style>\r\n<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n// form提交\r\nfunction formSubmit()\r\n{\r\n\t//<tr>\r\n\t//\t<td height=\"30px\" class=hcicontent colspan=\"6\"><input type=\"radio\" name=\"changeType\"  value=\"0\">换房后房价执行原房价&nbsp;&nbsp;<input type=\"radio\" name=\"changeType\"  value=\"1\">换房后房价不一致</td>\r\n\t//</tr>\r\n\t//if(! (getRadioValue(\"changeType\")[0]) ) {\r\n\t//\talert(\"请选择换房后的价格取向。\") ;\r\n\t//\treturn false;\r\n\t//}\r\n\t\r\n\tvar stayType = form1.stayType.value;\r\n\t\r\n\t// 清空已选客房信息\r\n\t$('#selectCheckInRooms').html(\"\");\r\n\t// 已选择的进行顺序编号\r\n\tvar selectInt = -1;\r\n    $(\"input[name='ids']\").each(function(){\r\n    \t// 选择\r\n    \tif (this.checked) {\r\n");
      out.write("    \t\tselectInt += 1;\r\n    \t\tvar arr = this.value.split(\";\");\r\n    \t\tvar index = arr[0];        // tr中的索引\r\n    \t\tvar roomId = arr[1];     // 房间ID\r\n    \t\tvar roomNo = arr[2];   // 房号\r\n    \t\tvar bedId = arr[3];       // 床位ID\r\n    \t\tvar bedNo = arr[4];     // 床号\r\n    \t\tvar discount = $(\"#discount\" + index).val();          // 折扣比例\r\n    \t\tvar amount =   $(\"#amount\" + index).val();            // 折扣价格\r\n    \t\tvar checkInType = $(\"#hireFlag\" + index).val();    // 租房方式\r\n\t\t\t// 原价格\r\n   \t\t\tvar amountPrice;\r\n   \t\t\tswitch(stayType) {\r\n\t\t\t\t// 半天房\r\n\t\t\t\tcase \"1\" :\r\n\t\t\t\t\tamountPrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(5)\").text();\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t// 全日房\r\n\t\t\t\tcase '2':\r\n\t\t\t\t\tamountPrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t// 钟点房\r\n\t\t\t\tcase '3':\r\n\t\t\t\t\tamountPrice = ($(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(6)\").text().split(\"/\"))[0];\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t// 长包房\r\n\t\t\t\tcase '4':\r\n\t\t\t\t\tamountPrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\t\t\tbreak;\r\n   \t\t\t}\r\n");
      out.write("   \t\t\t// 没有折扣时，默认10折全价\r\n    \t\tif (amount == \"\") {\r\n    \t\t\tdiscount = 10;\r\n    \t\t\tamount = amountPrice;\r\n    \t\t}\r\n    \t\t$('#selectCheckInRooms').append(\r\n    \t\t\"<input type='hidden' name='roomId' value='\" +roomId + \"' >\" + \r\n    \t\t\"<input type='hidden' name='roomNo' value='\" + roomNo + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='bedId' value='\" +bedId + \"' >\" + \r\n    \t\t\"<input type='hidden' name='bedNo' value='\" + bedNo + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='discount' value='\" + discount + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='amount' value='\" + amount + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='roomNoPrice' value='\" + amount + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='checkInType' value='\" + checkInType + \"' >\" +  \r\n    \t\t\"<input type='hidden' name='merId' value='");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("' >\" +\r\n    \t\t\"<input type='hidden' name='registPrice' value='\" + amountPrice + \"' >\");\r\n    \t}\r\n\t});\r\n\tform1.action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/exchangeRoom/create\";\r\n\tform1.target=\"_parent\"; //   _self\r\n\tform1.submit();\r\n}\r\n</script>\r\n</HEAD>\r\n<BODY>\r\n  <form name=\"form1\" method=post action=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" target=\"_self\">\r\n        <input type=\"hidden\" name=\"checkInId\"                         value=\"");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"custCheckInRoomId\"      value=\"");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"checkIn.id\"      value=\"");
      if (_jspx_meth_c_005fout_005f3(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"mer.id\"      value=\"");
      if (_jspx_meth_c_005fout_005f4(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"stayType\"      value=\"");
      if (_jspx_meth_c_005fout_005f5(_jspx_page_context))
        return;
      out.write("\">\r\n        <input type=\"hidden\" name=\"contractualUnitId\"      value=\"");
      if (_jspx_meth_c_005fout_005f6(_jspx_page_context))
        return;
      out.write("\">\r\n        <div id=\"selectCheckInRooms\" style=\"display:none;\"></div>\r\n        <br>\r\n\t\t<div align=\"center\">\r\n\t\t  <TABLE class=\"hci\" border=\"1\" bordercolordark=\"#ffffff\" bordercolorlight=\"#eeeeee\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t    <TBODY>\r\n\t\t\t<TR class=\"hcititle\"> \r\n\t\t\t      <TD colSpan=\"6\">【换房】</TD>\r\n\t\t\t</TR>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"hcihead\">原客房</td>\r\n\t\t\t\t<td class=hcicontent colspan=\"5\"><input type=\"text\" name=\"oldRoomNo\" readOnly value=\"");
      if (_jspx_meth_c_005fout_005f7(_jspx_page_context))
        return;
      out.write("\" class=\"inputTextNoBorder\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"hcihead\" width=\"12%\">客人姓名</td>\r\n\t\t\t\t<td class=hcicontent width=\"21%\"><input type=\"text\" name=\"travler\" readOnly value=\"");
      if (_jspx_meth_c_005fout_005f8(_jspx_page_context))
        return;
      out.write("\" class=\"inputTextNoBorder\"></td>\r\n\t\t\t\t<td class=\"hcihead\" width=\"12%\">金额</td>\r\n\t\t\t\t<td class=hcicontent width=\"21%\"><input type=\"text\" name=\"oldRoomNoPrice\" readOnly value=\"");
      if (_jspx_meth_c_005fout_005f9(_jspx_page_context))
        return;
      out.write("\" class=\"inputTextNoBorder\"></td>\r\n\t\t\t\t<td class=\"hcihead\" width=\"12%\">牌价</td>\r\n\t\t\t\t<td class=hcicontent width=\"21%\"><input type=\"text\" name=\"oldRoomNoRegPrice\" readOnly value=\"");
      if (_jspx_meth_c_005fout_005f10(_jspx_page_context))
        return;
      out.write("\" class=\"inputTextNoBorder\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td height=\"30px\" class=hcicontent colspan=\"6\">\r\n\t\t\t\t房号:<input name=\"roomSearchNum\" type=\"text\" size=\"10\" id=\"roomSearchNum\" />&nbsp;<input name=\"goButton\" type=\"button\"  onclick=\"javascript:searchByRoomNo();\"  value=\"搜索\" />\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td height=\"30px\" class=hcicontent colspan=\"6\">\r\n\t\t\t\t    <table  id=\"emptyRoom\" width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" summary=\"方法 \" style=\"border-collapse:collapse;\">\r\n\t\t\t\t   \t\t<thead>\r\n\t\t\t\t\t    <tr class=\"reshead\" id=\"merRoomTitle\">\r\n\t\t\t\t\t\t    <th scope=\"col\">No.</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">房型</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">房号</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">床号</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">全日房价</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">半日房价</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">钟点房价</th>\r\n\t\t\t\t\t\t    <th scope=\"col\" width=\"30%\">房间说明</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">折扣比例(/折)</th>\r\n\t\t\t\t\t\t    <th scope=\"col\">折扣价格</th>\r\n\t\t\t\t\t    </tr>\r\n\t\t\t\t\t    </thead>\r\n\t\t\t\t\t    <tbody id=\"tbd\">\r\n\t\t\t\t\t\t\t\t<tr  class=\"rescontent\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td colspan=\"10\" align=\"center\">请查询相应入住房型的空净房间。<br></td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</tbody>\r\n\t\t\t\t    </table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<TR>\r\n\t\t\t      <TD class=hcihead colspan=\"6\" style=\"text-align:center\">\r\n\t\t\t        <input type=\"button\" value=\" 保 存 \" onclick=\"javascript:formSubmit();\">\r\n\t\t\t        <input type=\"button\" value=\" 取 消 \" onclick=\"javascript:cancle();\">\r\n\t\t\t      </TD>\r\n\t\t\t</TR>\r\n\t\t    </TBODY> \r\n\t\t  </TABLE>\r\n\t\t</div>\r\n  </form>\r\n <br>\r\n <br>\r\n <br>\r\n<script type=\"text/javascript\">\r\nfunction cancle()\r\n{\r\n\twindow.location.href=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\";\r\n}\r\n//+---------------------------------------------------\r\n//| 选择入住房间\r\n//| obj.checked      id:roomId\r\n//+---------------------------------------------------\r\nfunction selectCheckInRoom(obj,index)\r\n{\r\n\t// 选择的房间\r\n\tif(obj.checked) {\r\n\t\t$(\"#discount\" + index).removeClass();\r\n\t\t$(\"#amount\" + index).removeClass();\r\n\t\t$(\"#discount\" + index).addClass(\"inputTextBorder\");\r\n\t\t$(\"#amount\" + index).addClass(\"inputTextBorder\");\r\n\t\t$(\"#discount\" + index).val(\"\").removeAttr(\"disabled\");\r\n\t\t$(\"#amount\" + index).val(\"\").removeAttr(\"disabled\");\r\n\t} else {\r\n\t\t$(\"#discount\" + index).removeClass();\r\n\t\t$(\"#amount\" + index).removeClass();\r\n\t\t$(\"#discount\" + index).addClass(\"inputTextNoBorder\");\r\n\t\t$(\"#amount\" + index).addClass(\"inputTextNoBorder\");\r\n\t\t$(\"#discount\" + index).val(\"\").attr(\"disabled\",\"disabled\");\r\n\t\t$(\"#amount\" + index).val(\"\").attr(\"disabled\",\"disabled\");\r\n\t}\r\n}\r\n//+---------------------------------------------------\r\n//| 房号查询空静房间\r\n//+---------------------------------------------------\r\nfunction searchByRoomNo()\r\n");
      out.write("{\r\n\t// 入住类型不能为空\r\n\tvar stayType = form1.stayType.value;\r\n\tif(stayType==\"\") {\r\n\t\twindow.alert(\"入住类型不能为空!\") ;\r\n\t\tform1.stayType.focus();\r\n\t\treturn;\r\n\t}\r\n\tvar roomSearchNum = $.trim($(\"#roomSearchNum\").val());\r\n\tif(roomSearchNum == \"\" ) {\r\n\t\talert(\"请输入房号\");\r\n\t\tform1.roomSearchNum.select();\r\n\t\treturn;\r\n\t}\r\n\tsearchEmptyCleanRoom(roomSearchNum);\r\n}\r\n//+---------------------------------------------------\r\n//| 通过ajax获取空净房信息\r\n//+---------------------------------------------------\r\nfunction searchEmptyCleanRoom(roomSearchNum)\r\n{\r\n\tvar merId = document.getElementById(\"mer.id\").value;\r\n\tvar contractualUnitId = document.getElementById(\"contractualUnitId\").value;\r\n\thtmlobj=$.ajax({\r\n\t    url: encodeURI(\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("?randValue=\" + getRandom()),\r\n\t    data: \"roomSearchNum=\"+roomSearchNum+\"&mer.id=\"+ merId +\"&contractualUnitId=\"+contractualUnitId,\r\n\t\ttype: \"POST\",\r\n\t\tdataType : \"json\",\r\n\t\tasync:false,  // 同步请求\r\n\t\ttimeout: 1000,\r\n\t\terror:function(xhr,error,exception) {\r\n\t\t    //解析JSON异常时或者ajax出错\r\n\t\t\talert(exception.toString());\r\n\t\t},\r\n\t\tsuccess:function(data, status, xhr){\r\n\t\t\tvar roomTrStr='';\r\n\t\t\t// 删除tobody中的所有行\r\n\t\t\t$(\"#tbd tr\").remove();\r\n\t\t\t// 报错误信息\r\n\t\t\tif(data.message != \"\") {\r\n\t\t\t\t// 页面显示查无空净房的提示信息  弹出提示信息alert(data.message);\r\n\t\t\t\t$(\"#tbd\").append('<tr class=\"rescontent\"><td colspan=\"9\" align=\"center\">' + data.message + '<br></td></tr>');\r\n\t\t\t} else {\r\n\t\t\t\t// 获取json中的客房信息\r\n\t\t\t\tvar jsonData = data.merRooms;\r\n\t\t\t\tvar roomTrStr = \"\";\r\n\t\t\t\t// 遍历每个房间信息，生成每行客房记录html字符串，并加入到空净客房的尾部\r\n\t\t\t\tfor(var i=0;i<jsonData.length;i++){\r\n\t\t\t\t\troomTrStr = '<tr>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\" style=\"border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;\"><input type=\"radio\" name=\"ids\" onclick=\"selectCheckInRoom(this,' + i + ')\" value=\"'+ i + ';' + jsonData[i][\"roomId\"] + ';' + jsonData[i][\"roomNo\"] + ';' + jsonData[i][\"bedId\"] + ';' + jsonData[i][\"bedNo\"] + '\">' + (i+1)  + '</td>';\r\n");
      out.write("\t\t\t\t\troomTrStr += '<input type=\"hidden\" name=\"hireFlag' + i + '\"  id=\"hireFlag' + i + '\"  value=\"' + jsonData[i][\"hireFlag\"] + '\">';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"roomTypeName\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"roomNo\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"bedNo\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"alldayPrice\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"halfdayPrice\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"hourPrice\"] + '/'+ jsonData[i][\"hourMeasure\"]  + '小时</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\">' + jsonData[i][\"roomDesc\"] + '</td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\"><input type=\"text\" disabled name=\"discount' + i + '\" id=\"discount' + i + '\" onblur=\"discountInput(' + i + ');\"  size=\"8\" maxlength=\"5\" class=\"inputTextNoBorder\"></td>';\r\n\t\t\t\t\troomTrStr += '<td align=\"center\"><input type=\"text\" disabled name=\"amount' + i + '\"  id=\"amount' + i + '\"  onblur=\"amountInput(' + i + ');\" \" size=\"8\" maxlength=\"7\" class=\"inputTextNoBorder\"></td>';\r\n");
      out.write("\t\t\t\t\troomTrStr += '</tr>';\r\n\t\t\t\t\t$(\"#tbd\").append(roomTrStr);\r\n\t\t\t\t\t// 设置入住类型相对应的房间价格\r\n\t\t\t\t\tselectCheckInType();\r\n\t\t\t\t}\r\n\t\t\t\t// 奇偶行不同颜色\r\n\t\t\t\t$(\"#emptyRoom tbody tr:odd\").addClass(\"rescontent_\");  // 索引奇数\r\n\t\t\t\t$(\"#emptyRoom tbody tr:even\").addClass(\"rescontent\");\r\n\t\t\t\t// 鼠标移动行变色\r\n\t\t\t\t$(\"#emptyRoom tbody tr\").hover(function(){\r\n\t\t\t\t    $(this).addClass(\"mouseHover\");\r\n\t\t\t\t},function(){\r\n\t\t\t\t    $(this).removeClass(\"mouseHover\");\r\n\t\t\t\t});\r\n\t\t\t}\r\n\t\t}\r\n\t});\r\n}\r\n//+---------------------------------------------------\r\n//| 入住类型的选择\r\n//+---------------------------------------------------\r\nfunction selectCheckInType()\r\n{\r\n\tvar stayTypeValue = document.getElementsByName(\"stayType\")[0].value;\r\n\t// 根据不同的选择，只显示当前选择的入住类型价格\r\n\tswitch(stayTypeValue){\r\n\t\t// 半天房\r\n\t\tcase \"1\" :\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).hide()});   // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).hide()});   // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).show()}); // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).show()});  // 半日房\r\n");
      out.write("\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 全日房\r\n\t\tcase '2':\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 钟点房\r\n\t\tcase '3':\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).hide()});   // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).hide()});    // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});    // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});    // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).show()});  // 钟点房\r\n");
      out.write("\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).show()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 长包房\r\n\t\tcase '4':\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).show()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});   // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});   // 钟点房\r\n\t\t\tbreak;\r\n\t\t// 默认为空\r\n\t\tdefault : \r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(4)\",this).hide()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(4)\",this).hide()});  // 全日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(5)\",this).hide()});  // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(5)\",this).hide()});  // 半日房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"td:eq(6)\",this).hide()});  // 钟点房\r\n\t\t\t$(\"#emptyRoom tr\").each(function(){$(\"th:eq(6)\",this).hide()});  // 钟点房\r\n");
      out.write("\t}\r\n\t// 清空先前的折扣率和折扣价\r\n\t$(\"#emptyRoom tbody tr\").each(function(index){\r\n\t\t$(\"#discount\" + index).val(\"\");\r\n\t\t$(\"#amount\" + index).val(\"\");\r\n\t});\r\n}\r\n//+---------------------------------------------------\r\n//| 折扣的输入计算折扣价\r\n//+---------------------------------------------------\r\nfunction discountInput(index)\r\n{\r\n\t$(\"#discount\" + index).val($.trim($(\"#discount\" + index).val()));\r\n\tvar discount = $(\"#discount\" + index).val();\r\n\tif (discount == \"\") {\r\n\t\treturn;\r\n\t}\r\n\tif (!isDecimal(discount)) {\r\n\t\talert(\"请输入正确的折扣率。\");\r\n\t\t$(\"#discount\" + index).select();\r\n\t\treturn;\r\n\t}\r\n\tif (parseFloat(discount)>10 || parseFloat(discount)<0) {\r\n\t\talert(\"请输入正确的折扣率。折扣率在0到10之间。\");\r\n\t\t$(\"#discount\" + index).select();\r\n\t\treturn;\r\n\t}\r\n\tvar stayTypeValue = document.getElementsByName(\"stayType\")[0].value;\r\n\tvar basePrice = \"\";\r\n\t// 根据不同的选择，选择需要打折扣的价格\r\n\tswitch(stayTypeValue){\r\n\t\t// 半天房\r\n\t\tcase \"1\" :\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(5)\").text();\r\n\t\t\tbreak;\r\n\t\t// 全日房\r\n\t\tcase '2':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n");
      out.write("\t\t\tbreak;\r\n\t\t// 钟点房\r\n\t\tcase '3':\r\n\t\t\tbasePrice = ($(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(6)\").text().split(\"/\"))[0];\r\n\t\t\tbreak;\r\n\t\t// 长包房\r\n\t\tcase '4':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 默认为空\r\n\t\tdefault : \r\n\t\t\treturn;\r\n\t}\r\n\t$(\"#amount\" + index).val(getRoundNumber(eval(basePrice + \"*\" + discount + \"/10\"),2));\r\n}\r\n//+---------------------------------------------------\r\n//| 由折扣价格计算相应的折扣率进行回显\r\n//+---------------------------------------------------\r\nfunction amountInput(index)\r\n{\r\n\t$(\"#amount\" + index).val($.trim($(\"#amount\" + index).val()));\r\n\tvar amount = $(\"#amount\" + index).val();\r\n\tif (amount == \"\") {\r\n\t\treturn;\r\n\t}\r\n\tif (!isDecimal(amount)) {\r\n\t\talert(\"请输入正确的折扣价。\");\r\n\t\t$(\"#amount\" + index).select();\r\n\t\treturn;\r\n\t}\r\n\tvar stayTypeValue = document.getElementsByName(\"stayType\")[0].value;\r\n\tvar basePrice = \"\";\r\n\t// 根据不同的选择，选择需要打折扣的价格\r\n\tswitch(stayTypeValue){\r\n\t\t// 半天房\r\n\t\tcase \"1\" :\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(5)\").text();\r\n");
      out.write("\t\t\tbreak;\r\n\t\t// 全日房\r\n\t\tcase '2':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 钟点房\r\n\t\tcase '3':\r\n\t\t\tbasePrice = ($(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(6)\").text().split(\"/\"))[0];\r\n\t\t\tbreak;\r\n\t\t// 长包房\r\n\t\tcase '4':\r\n\t\t\tbasePrice = $(\"#emptyRoom tbody tr:eq(\" + index + \") td:eq(4)\").text();\r\n\t\t\tbreak;\r\n\t\t// 默认为空\r\n\t\tdefault : \r\n\t\t\treturn;\r\n\t}\r\n\t$(\"#discount\" + index).val(getRoundNumber(eval(amount + \"*10/\" + basePrice),2));\r\n}\r\n</script>\r\n </body>\r\n</html>");
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
    // /pages/reception/exchangeRoom/new.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("checkIn");
    // /pages/reception/exchangeRoom/new.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reception/exchangeRoom/new.jsp(3,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /pages/reception/exchangeRoom/new.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("custCheckInRoom");
    // /pages/reception/exchangeRoom/new.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custCheckInRoom}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /pages/reception/exchangeRoom/new.jsp(4,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(93,48) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.mer.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
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
    // /pages/reception/exchangeRoom/new.jsp(104,41) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/exchangeRoom/create");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
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
    // /pages/reception/exchangeRoom/new.jsp(105,77) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /pages/reception/exchangeRoom/new.jsp(106,66) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custCheckInRoom.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(107,59) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(108,55) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.mer.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(109,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.stayType}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(110,66) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.contractualUnitId}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(121,89) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custCheckInRoom.roomNo}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(125,87) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checkIn.custName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f9.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(127,94) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custCheckInRoom.amount}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f9 = _jspx_th_c_005fout_005f9.doStartTag();
    if (_jspx_th_c_005fout_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f10.setParent(null);
    // /pages/reception/exchangeRoom/new.jsp(129,97) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custCheckInRoom.registPrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f10 = _jspx_th_c_005fout_005f10.doStartTag();
    if (_jspx_th_c_005fout_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
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
    // /pages/reception/exchangeRoom/new.jsp(177,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/commons/newBlank.jsp");
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
    // /pages/reception/exchangeRoom/new.jsp(230,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/checkIn/searchRoom");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }
}
