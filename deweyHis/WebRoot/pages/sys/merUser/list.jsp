<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="merUserList" value="${merUserList}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
</HEAD>
<BODY>
<br>
<form name="form1" method="get" action="#">
<table align="center" class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
  <tbody>
  <tr class="hcititle">
    <td align=left colSpan=11>���û�ά����</td>
  </tr>
  <c:if test="${merUserList != null}" >
		  <tr class="reshead">
		    <td>���</td>
		    <td>������</td>
		    <td>��¼��</td>
			<td>�û�����</td>
			<td>��ϵ�绰</td>
			<td>�ֻ�</td>
			<td>email</td>
			<td>QQ</td>
			<td>MSN</td>
			<td>�û�״̬</td>
			<td>����</td>
		  </tr>
		<c:choose>
			<c:when test="${empty merUserList}">
				<tr>
					<td colspan="11" align="center">���û���Ϣ�������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${merUserList}" varStatus="vStatus">
				  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose>  > 
						<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td><c:out value="${rs.chineseName}"/></td>
						<td><c:out value="${rs.loginName}"/></td>
						<td><c:out value="${rs.type}"/></td>
						<td><c:out value="${rs.telephone}"/></td>
						<td><c:out value="${rs.handPhone}"/></td>
						<td><c:out value="${rs.email}"/></td>
						<td><c:out value="${rs.qq}"/></td>
						<td><c:out value="${rs.msn}"/></td>
						<td><c:out value="${rs.status}"/></td>
						<td align="center" ><a href="<c:url value="/merUser/edit/"/><c:out value="${rs.id}"/>">�༭</a>&nbsp;&nbsp;<a href='javascript:deleteMmerUser(<c:out value="${rs.id}"/>);'>ɾ��</a></td>
				  </tr>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
</c:if>
  <tr>
    <td colspan="17"> 
      <table class="resBottom">
        <tr> 
          <td width="38%">
            <input  type="button" name="save"  onclick="javascript:newMerUser();"  value="����" border=0/>
          </td>
          <td width="26%"> 
            <div align="right"> </div>
          </td>
          <td width="36%">
		    <div align="right"> </div>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  </tbody> 
</table>
</form>
<SCRIPT language="javascript">
	function  deleteMmerUser(id) {
		form1.action='<c:url value="/merUser/delete/"/>' + id;
		form1.submit();
	}
	function  query() {
		form1.action='<c:url value="/merUser/list"/>';
		form1.submit();
	}
	function  newMerUser() {
		form1.action='<c:url value="/merUser/new"/>';
		form1.submit();
	}
</SCRIPT>
</BODY>
</HTML>