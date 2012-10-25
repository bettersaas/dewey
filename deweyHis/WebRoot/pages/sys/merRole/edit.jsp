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
	if(isEmpty(form1.remark))    {
		window.alert("�������ɫ����!") ;
		form1.remark.focus(); 
		return;
	}
	var readwriteStr = "" + getChecked();
	if (getIndeterminateChecked().length > 0) {
		readwriteStr +=  ("," + getIndeterminateChecked());
	}
	if (getChecked().length < 1) {
		window.alert("��ѡ���ɫ�����Ĺ���!") ;
		return;
	}
	form1.readwrite.value=readwriteStr;
	
	form1.action="${pageContext.request.contextPath}/merRole/update"; 
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merRole/update"/>" target="_self">
        <input type="hidden" name="id"        value="<c:out value="${merRole.id}"/>">
        <input type="hidden" name="mer.id" value="<c:out value="${merRole.mer.id}"/>">
        <input type="hidden" name="readwrite" value="">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle">
		      <TD colSpan="4">���޸Ľ�ɫ��</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">��ɫ����</td>
					<td class=hcicontent colspan="3"><input type="text" name="roleName" readonly  value="<c:out value="${merRole.roleName}"/>" maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">��ɫ����</td>
					<td class=hcicontent colspan="3"><input type="text" name="remark"  value="<c:out value="${merRole.remark}"/>" maxlength="20"></td>
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
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="����"/>
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
<script type=text/javascript>
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
	/**
	<!-- et var="rsContent"  value=" fn:split(rs, '-') }" scope="page"/ >
	< et var="rsContent0"  value=" rsContent[0] }" scope="page"/ >
	<  et var="rsContent1"  value=" rsContent[1] }" scope="page"/ -->
	**/
	// ��ʼ����Ч��
	<c:set var="readwriteValue"  value=",${merRole.readwrite}," scope="page"/>
	<c:forEach var="rs" items="${fn:split(readwriteValue, ',') }" varStatus="vStatus">
			tree.initChecked('<c:out value="${rs}"/>');
	</c:forEach>
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