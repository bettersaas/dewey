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
    <td align=left colSpan=11>���̻�ά����</td>
  </tr>
  <c:if test="${merList != null}" >
		  <tr class="reshead">
		    <td>���</td>
		    <td>������</td>
		    <td>�̻�����</td>
			<td>�ͷ���</td>
			<td>�绰</td>
			<td>����</td>
			<td>��ϵ��</td>
			<td>��ϵ���ֻ�</td>
			<td>״̬</td>
			<td>����</td>
		  </tr>
		<c:choose>
			<c:when test="${empty merList}">
				<tr>
					<td colspan="11" align="center">���̻���Ϣ�������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${merList}" varStatus="vStatus">
				  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose>  > 
						<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td><c:out value="${rs.deweyNo}"/></td>
						<td><c:out value="${rs.fullName}"/></td>
						<td><c:out value="${rs.roomNum}"/></td>
						<td><c:out value="${rs.telephone}"/></td>
						<td><c:out value="${rs.fax}"/></td>
						<td><c:out value="${rs.linkmanName}"/></td>
						<td><c:out value="${rs.mobilephone}"/></td>
						<td><c:out value="${rs.status}"/></td>
						<td align="center" ><a href="<c:url value="/mer/edit/"/><c:out value="${rs.id}"/>">�༭</a>&nbsp;&nbsp;<a href='javascript:deleteMmer(<c:out value="${rs.id}"/>);'>ɾ��</a></td>
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
            <input  type="button" name="save"  onclick="javascript:newMer();"  value="�����̻�" border=0/>
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
	function  deleteMer(id) {
		form1.action='<c:url value="/platForm/delete/"/>' + id;
		form1.submit();
	}
	function  query() {
		form1.action='<c:url value="/platForm/list"/>';
		form1.submit();
	}
	function  newMer() {
		form1.action='<c:url value="/platForm/new"/>';
		form1.submit();
	}
</SCRIPT>
</BODY>
</HTML>