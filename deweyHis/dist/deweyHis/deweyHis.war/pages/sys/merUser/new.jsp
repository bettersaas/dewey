<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="TypeList"    value="${TypeList}"   scope="page"/>
<c:set var="StatusList" value="${StatusList}" scope="page"/>
<c:set var="merUser"   value="${merUser}"  scope="page"/>
<c:set var="merRoleList"   value="${merRoleList}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.loginName))    {
		window.alert("�������¼��!") ;
		form1.loginName.focus(); 
		return;
	}
	if(isEmpty(form1.chineseName))    {
		window.alert("������������!") ;
		form1.chineseName.focus(); 
		return;
	}
	if(isEmpty(form1.type))    {
		window.alert("��ѡ���û�����!") ;
		form1.type.focus(); 
		return;
	}
	if(isEmpty(form1.status))    {
		window.alert("��ѡ���û�״̬!") ;
		form1.status.focus(); 
		return;
	}
	if(getCheckSelectValue("role")[0] == 0) {
		window.alert("��ѡ���û�ӵ�еĽ�ɫ!") ;
		return;
	}
	htmlobj=$.ajax({
		url:"<c:url value="/merUser/checkLoginNameUnique"/>?loginName=" + form1.loginName.value + "&randValue=" + getRandom(),
		type: "GET",
		async:false,  // ͬ������
		processData: true,
		dataType: "html",
		data: {},
		success: function(data) {},
		error:function(e){}
	});
	if (htmlobj.responseText == "false") {
		alert("�õ�¼���ѱ�ʹ�ã��뻻����¼��������");
		return;
	}
	form1.action="${pageContext.request.contextPath}/merUser/create"; 
	form1.target="_self";     // _blank
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merUser/create"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${merUser.mer.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">�������û���</TD>
		    </TR>
				<tr>
					<td class="hcihead">��¼��</td>
					<td class=hcicontent colspan="3"><input type="text" name="loginName"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead" width="12%">������</td>
					<td class=hcicontent colspan="3"><input type="text" name="chineseName"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">�û�����</td>
					<td class=hcicontent colspan="3">
						<select name="type">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${TypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>"><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">��ϵ�绰</td>
					<td class=hcicontent colspan="3"><input type="text" name="telephone"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">�ֻ�</td>
					<td class=hcicontent colspan="3"><input type="text" name="handPhone"  maxlength="13"></td>
				</tr>
				<tr>
					<td class="hcihead">email</td>
					<td class=hcicontent colspan="3"><input type="text" name="email"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">QQ</td>
					<td class=hcicontent colspan="3"><input type="text" name="qq"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">MSN</td>
					<td class=hcicontent colspan="3"><input type="text" name="msn"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">�û�״̬</td>
					<td class=hcicontent colspan="3">
						<select name="status">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${StatusList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>"><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">��ɫ�б�</td>
					<td colspan="3">
								<c:forEach var="rs" items="${merRoleList}" varStatus="vStatus">
										<input type="checkbox" name="role" value="<c:out value="${rs.id}"/>"><c:out value="${rs.roleName}"/><c:if test="${(vStatus.index+1)%3==0}"><br></c:if>
								</c:forEach>
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
 </body>
</html>