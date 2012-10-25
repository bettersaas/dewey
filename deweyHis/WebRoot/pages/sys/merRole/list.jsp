<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="merRoleList"           value="${merRoleList}"            scope="page"/>
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
    <td align=left colSpan=5>【角色维护】</td>
  </tr>
  <c:if test="${merRoleList != null}" >
		  <tr class="reshead">
		    <td>序号</td>
		    <td>角色名称</td>
		    <td>角色描述</td>
			<td>操作</td>
		  </tr>
		<c:choose>
			<c:when test="${empty merRoleList}">
				<tr>
					<td colspan="4" align="center">无角色信息，请添加</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${merRoleList}" varStatus="vStatus">
					<c:set var="readwriteValue"  value="${rs.readwrite}" scope="page"/>
					<c:set var="readwriteValue"  value="${fn:split(readwriteValue, ',')}" scope="page"/>
				  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose> 
				  		title="<c:forEach var="rsRW" items="${readwriteValue}" varStatus="vStatus1"><c:out value="${fn:split(rsRW, '-')[1]}"/>&nbsp;&nbsp;</c:forEach>"  > 
						<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td><c:out value="${rs.roleName}"/></td>
						<td><c:out value="${rs.remark}"/></td>

						<td align="center" ><a href="<c:url value="/merRole/edit/"/><c:out value="${rs.id}"/>">编辑</a>&nbsp;&nbsp;<a href='javascript:deleteMmerRole(<c:out value="${rs.id}"/>);'>删除</a></td>
				  </tr>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
</c:if>
  <tr>
    <td colspan="5"> 
      <table class="resBottom">
        <tr> 
          <td width="38%">
            <input  type="button" name="save"  onclick="javascript:newMmerRole();"  value="增加" border=0/>
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
	function  deleteMmerRole(id) {
		form1.action='<c:url value="/merRole/delete/"/>' + id;
		form1.submit();
	}
	function  newMmerRole() {
		form1.target="mainFrame";
		form1.action='<c:url value="/merRole/new"/>';
		form1.submit();
	}
</SCRIPT>
</BODY>
</HTML>