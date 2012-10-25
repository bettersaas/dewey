<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="ConsumeTypeList" value="${ConsumeTypeList}" scope="page"/>
<c:set var="merServicesList"           value="${merServicesList}"            scope="page"/>
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
    <td align=left colSpan=17>【消费项目维护】</td>
  </tr>
  <tr class="hcititle">
    <td align=left colSpan=17>&nbsp;消费项目类别：&nbsp;&nbsp;
    <select name="merServices.consumeType">
    	<option value="">--请选择--</option>
    	<c:forEach var="rs" items="${ConsumeTypeList}" varStatus="vStatus">
    		<option value="<c:out value="${rs.value}"/>"  <c:if test="${param['merServices.consumeType'] == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
    	</c:forEach>
    </select>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:query();" target="mainFrame"><img src="<c:url value="/images/button/query.gif"/>" border="0"></a>
    </td>
  </tr>
  <c:if test="${merServicesList != null}" >
		  <tr class="reshead">
		    <td>序号</td>
		    <td>名称</td>
		    <td>单价</td>
			<td>类别</td>
			<td>单位</td>
			<td>描述</td>
			<td>操作</td>
		  </tr>
		<c:choose>
			<c:when test="${empty merServicesList}">
				<tr>
					<td colspan="17" align="center">无消费项目信息，请添加</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${merServicesList}" varStatus="vStatus">
				  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose>  > 
						<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td><c:out value="${rs.name}"/></td>
						<td><c:out value="${rs.price}"/></td>
						<td><c:out value="${rs.consumeType}"/></td>
						<td><c:out value="${rs.consumeUnit}"/></td>
						<td><c:out value="${rs.servicesDesc}"/></td>
						<td align="center" ><a href="<c:url value="/merServices/edit/"/><c:out value="${rs.id}"/>">编辑</a>&nbsp;&nbsp;<a href='javascript:deleteMmerServices(<c:out value="${rs.id}"/>);'>删除</a></td>
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
            <input  type="button" name="save"  onclick="javascript:newMmerServices();"  value="增加" border=0/>
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
	function  deleteMmerServices(id) {
		form1.action='<c:url value="/merServices/delete/"/>' + id;
		form1.submit();
	}
	function  query() {
		form1.action='<c:url value="/merServices/list"/>';
		form1.submit();
	}
	function  newMmerServices() {
		form1.action='<c:url value="/merServices/new"/>';
		form1.submit();
	}
</SCRIPT>
</BODY>
</HTML>