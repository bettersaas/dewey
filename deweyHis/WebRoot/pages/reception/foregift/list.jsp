<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="foregiftList"    value="${foregiftList}"    scope="page"/>
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
<table align="center" id="foregiftListTbl"  class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
  <thead>
	  <tr class="hcititle">
	    <td align=left colSpan=7>【在店押金-房号<c:out value="${param.roomNo}"/>】&nbsp;&nbsp;&nbsp;&nbsp;<input  type="button" name="save"  onclick="javascript:newForegift(<c:out value="${custCheckInRoomId}"/>);"  value="增收押金" border=0/>&nbsp;&nbsp;&nbsp;&nbsp;<input  type="button" name="save"  onclick="javascript:newForegift(<c:out value="${custCheckInRoomId}"/>);"  value="退还押金" border=0/></td>
	  </tr>
  </thead>
  <tbody>
  <c:if test="${foregiftList != null}" >
		  <tr class="reshead">
		    <td align="center">序号</td>
		    <td align="center">房号</td>
		    <td align="center">金额</td>
		    <td align="center">支付方式</td>
		    <td align="center">支付日期</td>
		    <td align="center">收银员</td>
			<td align="center">操作</td>
		  </tr>
		<c:choose>
			<c:when test="${empty foregiftList}">
				<tr>
					<td colspan="7" align="center">无押金信息</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${foregiftList}" varStatus="vStatus">
				  <tr> 
						<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td align="center"><c:out value="${rs.roomNo}"/></td>
						<td align="center"><c:out value="${rs.payAmount}"/></td>
						<td align="center"><c:out value="${rs.payType}"/></td>
						<td align="center"><fmt:formatDate   value="${rs.lcd}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td align="center"><c:out value="${rs.merUserName}"/></td>
						<td align="center" ><a href='javascript:editForegift(<c:out value="${rs.id}"/>);'>查看</a></td>
				  </tr>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
</c:if>
  </tbody>
</table>
</form>
<SCRIPT language="javascript">
	function  newForegift(id) {
		form1.action='<c:url value="/foregift/new/"/>' + id;
		form1.submit();
	}
	function  deleteForegift(id,custCheckInRoomId) {
		form1.action='<c:url value="/foregift/delete/"/>' + id +"/" + custCheckInRoomId;
		form1.submit();
	}
	function editForegift(id) {
		form1.action='<c:url value="/foregift/edit/"/>' + id;
		form1.submit();
	}
	$(document).ready(function(){
			// 奇偶行不同颜色
			$("#foregiftListTbl tbody tr:odd").addClass("rescontent_");  // 索引奇数
			$("#foregiftListTbl tbody tr:even").addClass("rescontent");
			// 鼠标移动行变色
			$("#foregiftListTbl tbody tr").hover(function(){
			    $(this).addClass("mouseHover");
			},function(){
			    $(this).removeClass("mouseHover");
			});
	});
</SCRIPT>
<br>
</BODY>
</HTML>