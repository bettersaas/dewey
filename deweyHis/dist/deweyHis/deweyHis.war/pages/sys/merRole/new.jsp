<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="ReadwriteList"    value="${ReadwriteList}"   scope="page"/>
<c:set var="SysFunctionJson"    value="${SysFunctionJson}"   scope="page"/>
<c:set var="merRole"             value="${merRole}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<link href="<c:url value="/styles/treePanel.css"/>" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value="/scripts/treePanelCommon.js"/>"></script>
<script type="text/javascript" src="<c:url value="/scripts/treePanel.js"/>"></script>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.roleName))    {
		window.alert("请输入角色名!") ;
		form1.roleName.focus(); 
		return;
	}
	htmlobj=$.ajax({
		url:"<c:url value="/merRole/checkMerRoleNameUnique"/>?roleName=" + form1.roleName.value + "&randValue=" + getRandom(),
		type: "GET",
		async:false,  // 同步请求
		processData: true,
		dataType: "html",
		data: {},
		success: function(data) {},
		error:function(e){}
	});
	if (htmlobj.responseText == "false") {
		alert("该角色名已被使用，请换个角色名新增。");
		return;
	}
	if(isEmpty(form1.remark))    {
		window.alert("请输入角色描述!") ;
		form1.remark.focus(); 
		return;
	}
	/******************
	<!--  var="rs" items=" {ReadwriteList}" varStatus="vStatus" >
		     fn: length( rs.value ) == 5 } ">&nbsp;&nbsp; 
		<input type="checkbox" name="readwrite" value="  out value=" {rs.value}" / >-  out value=" {rs.name}" /> "><  value=" {rs.name}"/ >
		 c : if test = "    not vStatus.last  "><br> 
	//<input type="checkbox" name="readwrite" value="F01-前台接待">前台接待
	//<input type="checkbox" name="readwrite" value="F0101-入住登记">入住登记	
	//if(getCheckSelectValue("readwrite")[0] == 0) {
	//	window.alert("请选择角色包含的功能!") ;
	//	return;
	//}
	******************/
	var readwriteStr = "" + getChecked();
	if (getIndeterminateChecked().length > 0) {
		readwriteStr +=  ("," + getIndeterminateChecked());
	}
	if (getChecked().length < 1) {
		window.alert("请选择角色包含的功能!") ;
		return;
	}
	form1.readwrite.value=readwriteStr;
	//alert(form1.readwrite.value);
	
	form1.action="${pageContext.request.contextPath}/merRole/create";
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form id="form1" name="form1" method=post action="<c:url value="/merRole/create"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${merRole.mer.id}"/>">
        <input type="hidden" name="readwrite" value="">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">【新增角色】</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">角色名称</td>
					<td class=hcicontent colspan="3"><input type="text" name="roleName" maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">角色描述</td>
					<td class=hcicontent colspan="3"><input type="text" name="remark" maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">角色授予的功能：</td>
					<td colspan="3">
								<input type='button' value='展开全部节点'   onclick='expandAll()'><input type='button' value='折叠全部节点'   onclick='collapseAll()'>
								<div id='tree-div'></div>
					<td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			         <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="保存" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="返回" />
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
  <script type=text/javascript>
	/******
	root = {'id':'FM','text':'功能菜单显示树','checked':'0','pid':'-1','children':[
				{
					'id':'FM01','text':'前台接待','checked':'0','pid':'FM','children':[
						{'id':'FM0101','text':'入住登记','checked':'0','pid':'FM01','children':[]},
						{'id':'FM0102','text':'旅客列表','checked':'0','pid':'FM01','children':[]}
					]
				},
				{
					'id':'FM02','text':'前台收银','checked':'0','pid':'999999','children':[
						{'id':'FM0201','text':'合并账单','checked':'0','pid':'FM02','children':[]},
						{'id':'FM0202','text':'拆分账单','checked':'0','pid':'FM02','children':[]}
					]
				},
				{
					'id':'FM09','text':'客户关系管理','checked':'0','pid':'999999','children':[
						{'id':'FM0901','text':'协议单位管理','checked':'0','pid':'FM09','children':[]}
					]
				}
			]
		}
	******/
	root = <c:out value="${SysFunctionJson}" escapeXml="false"/>;
	tree = new TreePanel({
		renderTo:'tree-div',
		'root' : root
	});
	tree.render();
	// 点击链接URL时的效果
	//选择事件
	tree.on(function(node){
		//alert( '你选中的是'+ node.attributes.text + "   " + node.attributes.URL);
		//if(node.attributes.URL){
		//	var elframe1 = parent.document.getElementById('content');
		//	elframe1.src=node.attributes.URL;
		//}
	})
	// 初始化的效果
	//tree.initChecked("999999");
	//tree.initChecked("110100");
	//tree.initChecked("110200");
	//tree.initChecked("110229");
	//tree.initChecked("110116");

	function expandAll(){
		tree.expandAll();
	}
	function collapseAll(){
		tree.collapseAll();
	}
	// 选择的角色
	function getChecked(){
		return  tree.getChecked();
	}
	// 半选的角色
	function getIndeterminateChecked(){
		return  tree.getIndeterminateChecked();
		//alert( tree.getIndeterminateChecked("id"));
		//alert( tree.getIndeterminateChecked("text"));
	}
 </script>
 </body>
</html>