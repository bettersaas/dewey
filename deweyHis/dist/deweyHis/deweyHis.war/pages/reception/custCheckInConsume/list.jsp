<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="custCheckInConsumeList"    value="${custCheckInConsumeList}"    scope="page"/>
<c:set var="custCheckInRoomId"    value="${custCheckInRoomId}"    scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
</HEAD>
<BODY>
<br>
<form name="form1" method="get" action="#">
<input type="hidden" name="custCheckInRoomId" value="<c:out value="${custCheckInRoomId}"/>">
<input type="hidden" name="roomNo" value="<c:out value="${param.roomNo}"/>">
<table align="center" id="custCheckInConsumeListTbl"  class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
  <thead>
	  <tr class="hcititle">
	    <td align=left colSpan=7>【在店消费账单-房号<c:out value="${param.roomNo}"/>】&nbsp;&nbsp;&nbsp;&nbsp;<input  type="button" name="save"  onclick="javascript:newCustCheckInConsume(<c:out value="${custCheckInRoomId}"/>);"  value="添加" border=0/></td>
	  </tr>
  </thead>
  <tbody>
  <c:if test="${custCheckInConsumeList != null}" >
		  <tr class="reshead">
		    <td align="center">序号</td>
		    <td align="center">项目名称</td>
		    <td align="center">单价</td>
		    <td align="center">数量</td>
		    <td align="center">单位</td>
		    <td align="center">金额</td>
			<td align="center">操作</td>
		  </tr>
		<c:choose>
			<c:when test="${empty custCheckInConsumeList}">
				<tr>
					<td colspan="7" align="center">无消费信息</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${custCheckInConsumeList}" varStatus="vStatus">
				  <tr> 
						<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td align="center"><c:out value="${rs.merServices.name}"/></td>
						<td align="center"><c:out value="${rs.merServices.price}"/></td>
						<td align="center"><c:out value="${rs.scalar}"/></td>
						<td align="center"><c:out value="${rs.merServices.consumeUnit}"/></td>
						<td align="center"><c:out value="${rs.total}"/></td>
						<td align="center" ><a href='javascript:editCustCheckInConsume(<c:out value="${rs.id}"/>);'>编辑</a>&nbsp;&nbsp;<a href='javascript:deleteCustCheckInConsume(<c:out value="${rs.id}"/>, <c:out value="${custCheckInRoomId}"/>);'>删除</a></td>
				  </tr>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
</c:if>
  </tbody>
</table>
</form>
<SCRIPT language="javascript">
	function  newCustCheckInConsume(id) {
		form1.action='<c:url value="/custCheckInConsume/new/"/>' + id;
		form1.submit();
	}
	function  deleteCustCheckInConsume(id,custCheckInRoomId) {
		form1.action='<c:url value="/custCheckInConsume/delete/"/>' + id +"/" + custCheckInRoomId;
		form1.submit();
	}
	function editCustCheckInConsume(id) {
		form1.action='<c:url value="/custCheckInConsume/edit/"/>' + id;
		form1.submit();
	}
	$(document).ready(function(){
			// 奇偶行不同颜色
			$("#custCheckInConsumeListTbl tbody tr:odd").addClass("rescontent_");  // 索引奇数
			$("#custCheckInConsumeListTbl tbody tr:even").addClass("rescontent");
			// 鼠标移动行变色
			$("#custCheckInConsumeListTbl tbody tr").hover(function(){
			    $(this).addClass("mouseHover");
			},function(){
			    $(this).removeClass("mouseHover");
			});
	});
</SCRIPT>
<br>
</BODY>
</HTML>