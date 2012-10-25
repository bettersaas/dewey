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
		window.alert("�������ɫ��!") ;
		form1.roleName.focus(); 
		return;
	}
	htmlobj=$.ajax({
		url:"<c:url value="/merRole/checkMerRoleNameUnique"/>?roleName=" + form1.roleName.value + "&randValue=" + getRandom(),
		type: "GET",
		async:false,  // ͬ������
		processData: true,
		dataType: "html",
		data: {},
		success: function(data) {},
		error:function(e){}
	});
	if (htmlobj.responseText == "false") {
		alert("�ý�ɫ���ѱ�ʹ�ã��뻻����ɫ��������");
		return;
	}
	if(isEmpty(form1.remark))    {
		window.alert("�������ɫ����!") ;
		form1.remark.focus(); 
		return;
	}
	/******************
	<!--  var="rs" items=" {ReadwriteList}" varStatus="vStatus" >
		     fn: length( rs.value ) == 5 } ">&nbsp;&nbsp; 
		<input type="checkbox" name="readwrite" value="  out value=" {rs.value}" / >-  out value=" {rs.name}" /> "><  value=" {rs.name}"/ >
		 c : if test = "    not vStatus.last  "><br> 
	//<input type="checkbox" name="readwrite" value="F01-ǰ̨�Ӵ�">ǰ̨�Ӵ�
	//<input type="checkbox" name="readwrite" value="F0101-��ס�Ǽ�">��ס�Ǽ�	
	//if(getCheckSelectValue("readwrite")[0] == 0) {
	//	window.alert("��ѡ���ɫ�����Ĺ���!") ;
	//	return;
	//}
	******************/
	var readwriteStr = "" + getChecked();
	if (getIndeterminateChecked().length > 0) {
		readwriteStr +=  ("," + getIndeterminateChecked());
	}
	if (getChecked().length < 1) {
		window.alert("��ѡ���ɫ�����Ĺ���!") ;
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
		      <TD colSpan="4">��������ɫ��</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">��ɫ����</td>
					<td class=hcicontent colspan="3"><input type="text" name="roleName" maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">��ɫ����</td>
					<td class=hcicontent colspan="3"><input type="text" name="remark" maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">��ɫ����Ĺ��ܣ�</td>
					<td colspan="3">
								<input type='button' value='չ��ȫ���ڵ�'   onclick='expandAll()'><input type='button' value='�۵�ȫ���ڵ�'   onclick='collapseAll()'>
								<div id='tree-div'></div>
					<td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			         <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="����" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="����" />
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
  <script type=text/javascript>
	/******
	root = {'id':'FM','text':'���ܲ˵���ʾ��','checked':'0','pid':'-1','children':[
				{
					'id':'FM01','text':'ǰ̨�Ӵ�','checked':'0','pid':'FM','children':[
						{'id':'FM0101','text':'��ס�Ǽ�','checked':'0','pid':'FM01','children':[]},
						{'id':'FM0102','text':'�ÿ��б�','checked':'0','pid':'FM01','children':[]}
					]
				},
				{
					'id':'FM02','text':'ǰ̨����','checked':'0','pid':'999999','children':[
						{'id':'FM0201','text':'�ϲ��˵�','checked':'0','pid':'FM02','children':[]},
						{'id':'FM0202','text':'����˵�','checked':'0','pid':'FM02','children':[]}
					]
				},
				{
					'id':'FM09','text':'�ͻ���ϵ����','checked':'0','pid':'999999','children':[
						{'id':'FM0901','text':'Э�鵥λ����','checked':'0','pid':'FM09','children':[]}
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
	// �������URLʱ��Ч��
	//ѡ���¼�
	tree.on(function(node){
		//alert( '��ѡ�е���'+ node.attributes.text + "   " + node.attributes.URL);
		//if(node.attributes.URL){
		//	var elframe1 = parent.document.getElementById('content');
		//	elframe1.src=node.attributes.URL;
		//}
	})
	// ��ʼ����Ч��
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
	// ѡ��Ľ�ɫ
	function getChecked(){
		return  tree.getChecked();
	}
	// ��ѡ�Ľ�ɫ
	function getIndeterminateChecked(){
		return  tree.getIndeterminateChecked();
		//alert( tree.getIndeterminateChecked("id"));
		//alert( tree.getIndeterminateChecked("text"));
	}
 </script>
 </body>
</html>