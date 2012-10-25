<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="TypeList"    value="${TypeList}"   scope="page"/>
<c:set var="StatusList" value="${StatusList}" scope="page"/>
<c:set var="merUser"  value="${merUser}" scope="page"/>
<c:set var="merRoleList"   value="${merRoleList}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
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
	form1.action="${pageContext.request.contextPath}/merUser/update"; 
	form1.target="_self";     // _blank
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merUser/update"/>" target="_self">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">���޸��̻���</TD>
		    </TR>
				<tr>
					<td class="hcihead">������</td>
					<td class=hcicontent colspan="3"><input type="text" name="deweyNo"  readonly  value="<c:out value="${mer.deweyNo}"/>"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead" width="12%">�̻�����</td>
					<td class=hcicontent colspan="3"><input type="text" name="fullName" value="<c:out value="${mer.fullName}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">�ͷ���</td>
					<td class=hcicontent colspan="3"><input type="text" name="roomNum" value="<c:out value="${mer.roomNum}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">�绰</td>
					<td class=hcicontent colspan="3"><input type="text" name="telephone" value="<c:out value="${mer.telephone}"/>"  maxlength="13"></td>
				</tr>
				<tr>
					<td class="hcihead">����</td>
					<td class=hcicontent colspan="3"><input type="text" name="fax" value="<c:out value="${mer.fax}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">��ϵ��</td>
					<td class=hcicontent colspan="3"><input type="text" name="linkmanName" value="<c:out value="${mer.linkmanName}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">��ϵ���ֻ�</td>
					<td class=hcicontent colspan="3"><input type="text" name="mobilephone" value="<c:out value="${mer.mobilephone}"/>"   maxlength="20"></td>
				</tr>
				
				<tr>
					<td class="hcihead">�û�״̬</td>
					<td class=hcicontent colspan="3">
					    <select name="status">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${StatusList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" <c:if test="${mer.status == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
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
 </body>
</html>