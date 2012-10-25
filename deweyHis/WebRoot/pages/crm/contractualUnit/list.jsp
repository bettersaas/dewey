<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="contractualUnitList"    value="${contractualUnitList}"    scope="page"/>
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
    <td align=left colSpan=6>��Э�鵥λ����</td>
  </tr>
  <c:if test="${contractualUnitList != null}" >
		  <tr class="reshead">
		    <td>���</td>
		    <td>��λ����</td>
		    <td>��ϵ��</td>
		    <td>�绰</td>
		    <td>��ע</td>
			<td>����</td>
		  </tr>
		<c:choose>
			<c:when test="${empty contractualUnitList}">
				<tr>
					<td colspan="6" align="center">��Э�鵥λ��Ϣ�������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${contractualUnitList}" varStatus="vStatus">
				  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose> > 
						<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td><c:out value="${rs.company}"/></td>
						<td><c:out value="${rs.linkman}"/></td>
						<td><c:out value="${rs.telphone}"/></td>
						<td><c:out value="${rs.remark}"/></td>
						<td align="center" ><a href="<c:url value="/contractualUnit/edit/"/><c:out value="${rs.id}"/>">�༭</a>&nbsp;&nbsp;<a href='javascript:deleteContractualUnit(<c:out value="${rs.id}"/>);'>ɾ��</a></td>
				  </tr>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
</c:if>
  <tr>
    <td colspan="6"> 
      <table class="resBottom">
        <tr> 
          <td width="38%">
            <input  type="button" name="save"  onclick="javascript:newContractualUnit();"  value="����" border=0/>
            <input  type="button" name="exp"  onclick="javascript:expContractualUnit();"    value="����EXCEL" border=0/>
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
	function  deleteContractualUnit(id) {
		form1.action='<c:url value="/contractualUnit/delete/"/>' + id;
		form1.submit();
	}
	function  newContractualUnit() {
		form1.target="mainFrame";
		form1.action='<c:url value="/contractualUnit/new"/>';
		form1.submit();
	}
	function expContractualUnit() {
		form1.action='<c:url value="/contractualUnit/listAllExp"/>';
		form1.submit();
	}
</SCRIPT>
</BODY>
</HTML>