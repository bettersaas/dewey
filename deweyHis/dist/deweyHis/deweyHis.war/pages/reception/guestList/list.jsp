<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="pageList"    value="${pageList}"    scope="page"/>
<c:set var="pager"         value="${pager}"         scope="page"/>
<c:set var="StatusList"  value="${StatusList}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script src="<c:url value="/scripts/calendar.js"/>" type="text/javascript"></script>
<style>
.mouseHover{
	color: blue;
  }
</style>
<SCRIPT language="javascript">
	function query() {
		form1.action='<c:url value="/guestList/list"/>';
		form1.submit();
	}
	function query1() {
		form1.action='<c:url value="/guestList/list1"/>';
		form1.submit();
	}
	function expExcel() {
		form1.action='<c:url value="/guestList/listExp"/>';
		form1.submit();
	}
	function checkInShow(checkInId) {
		form1.action='<c:url value="/checkIn/show/"/>' + checkInId;
		form1.submit();
	}
	function checkInEdit(checkInId) {
		form1.action='<c:url value="/checkIn/edit/"/>' + checkInId;
		form1.submit();
	}
	// 消费管理
	function custCheckInConsumeList(custCheckInRoomId,checkInId,roomNo) {
		form1.custCheckInRoomId.value=custCheckInRoomId;
		form1.checkInId.value=checkInId;
		form1.roomNo.value=roomNo;
		form1.action='<c:url value="/custCheckInConsume/list/"/>' + custCheckInRoomId;
		form1.target="_self";
		form1.submit();
	}
	// 押金管理
	function foregiftList(custCheckInRoomId,checkInId,roomNo) {
		form1.custCheckInRoomId.value=custCheckInRoomId;
		form1.checkInId.value=checkInId;
		form1.roomNo.value=roomNo;
		form1.action='<c:url value="/foregift/list/"/>' + custCheckInRoomId;
		form1.target="_self";
		form1.submit();
	}
</SCRIPT>
</HEAD>
<BODY>
<br>
<form name="form1" method="get" action="#">
<input type="hidden" name="pageNo"    value="1">
<input type="hidden" name="pageSize" value="15">
<input type="hidden" name="custCheckInRoomId">
<input type="hidden" name="checkInId">
<input type="hidden" name="roomNo">
<table align="center" class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
	  <tbody>
		  <tr class="hcititle">
		    	<td align=left colSpan=8>【旅客查询】</td>
		  </tr>
		  <tr>
		  	<td>姓名</td>
		  	<td><input type="text" name="custName" size="15" maxlength="20" value="<c:out value="${param.custName}"/>"></td>
		  	<td>证件编号</td>
		  	<td><input type="text" name="idNo" size="15" maxlength="20" value="<c:out value="${param.idNo}"/>"></td>
		  	<td>登记时间</td>
		  	<td>
		  		<input type="text" name="lcdStart" size="15" maxlength="19" value="<c:out value="${param.lcdStart}"/>">
		  		<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.lcdStart,null,'yyyy-MM-dd hh:mm',true);" />
		  		 - 
		  		 <input type="text" name="lcdEnd" size="15" maxlength="19" value="<c:out value="${param.lcdEnd}"/>">
		  		 <img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.lcdEnd,null,'yyyy-MM-dd hh:mm',true);" />
		    </td>
		  	<td>状态</td>
		    <td align=left >
			    <select name="status">
			    	<option value="">--请选择--</option>
			    	<c:forEach var="rs" items="${StatusList}" varStatus="vStatus">
			    		<option value="<c:out value="${rs.value}"/>"   <c:if test="${param['status'] == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
			    	</c:forEach>
			    </select>
			</td>
		  </tr>
		  <tr>
		  	<td>房号</td>
		  	<td><input type="text" name="roomNoSearch" size="15" maxlength="10" value="<c:out value="${param.roomNoSearch}"/>"></td>
		  	<td>协议单位</td>
		  	<td><input type="text" name="contractualUnitName" size="15" maxlength="40" value="<c:out value="${param.contractualUnitName}"/>"></td>
		  	<td>预计离店时间</td>
		  	<td>
		  		<input type="text" name="planDepartureDateStart" size="15" maxlength="19" value="<c:out value="${param.planDepartureDateStart}"/>">
		  		<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.planDepartureDateStart,null,'yyyy-MM-dd hh:mm',true);" />
		  		 - 
		  		 <input type="text" name="planDepartureDateEnd" size="15" maxlength="19" value="<c:out value="${param.planDepartureDateEnd}"/>">
		  		 <img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.planDepartureDateEnd,null,'yyyy-MM-dd hh:mm',true);" />
		  	</td>
		  	<td></td>
		    <td></td>
		  </tr>
		  <tr>
		  	<td align="center" colSpan=8>
		  		<input  type="button" name="search"  onclick="javascript:query();"      value=" 查 询(1) " />&nbsp;&nbsp;
		  		<input  type="button" name="search1"  onclick="javascript:query1();"  value=" 查 询(2) " />&nbsp;&nbsp;
		  		<input  type="reset"  name="reset"    value=" 重 置 " />
		  	</td>
		  </tr>
	  </tbody>
  </table>
  </form>
  <br>
  <table align="center" id="custCheckInRoomListTbl" class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
  <c:if test="${pageList != null}" >
  	<thead>
		  <tr class="reshead">
		    <th nowrap>序号</th>
		    <th nowrap>姓名</th>
			<th nowrap>性别</th>
			<th nowrap>登记时间</th>
			<th nowrap>预计离店时间</th>
			<th nowrap>房型</th>
			<th nowrap>人数</th>
			<th nowrap>协议单位</th>
			<th nowrap>联系电话</th>
			<th nowrap>入住类型</th>
			<th nowrap>状态</th>
			<th nowrap>房价</th>
			<th nowrap>折扣</th>
			<th nowrap>折扣价</th>
			<th nowrap>房号</th>
			<th nowrap>床号</th>
			<th nowrap>操作</th>
		  </tr>
		</thead>
		<tbody id="tbd">
		<c:choose>
			<c:when test="${empty pageList}">
				<tr>
					<td colspan="17" align="center">无旅客信息</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${pageList}" varStatus="vStatus">
				  <tr> 
						<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td align="center"><c:out value="${rs.checkIn.custName}"/></td>
						<td align="center"><c:out value="${rs.checkIn.sex}"/></td>
						<td align="center"><fmt:formatDate   value="${rs.checkIn.lcd}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td align="center"><fmt:formatDate   value="${rs.checkIn.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td align="center"><c:out value="${rs.checkIn.roomType.name}"/></td>
						<td align="center"><c:out value="${rs.checkIn.peopleNum}"/></td>
						<td align="center"><c:out value="${rs.checkIn.contractualUnitName}"/></td>
						<td align="center"><c:out value="${rs.checkIn.phone}"/></td>
						<td align="center"><c:out value="${rs.checkIn.stayType}"/></td>
						<td align="center"><c:out value="${rs.checkIn.status}"/></td>
						<td align="center"><c:out value="${rs.registPrice}"/></td>
						<td align="center"><c:out value="${rs.discount}"/></td>
						<td align="center"><c:out value="${rs.amount}"/></td>
						<td align="center"><c:out value="${rs.roomNo}"/></td>
						<td align="center"><c:out value="${rs.bedNo}"/></td>
						<td align="center" >
							<input  type="button" onclick="javascript:checkInShow(<c:out value="${rs.checkIn.id}"/>);"  value="客人资料" />&nbsp;
							<input  type="button" <c:if test="${rs.checkIn.status!='在住'}">disabled</c:if> onclick="javascript:checkInEdit(<c:out value="${rs.checkIn.id}"/>);"  value="客人编辑" />&nbsp;
							<input  type="button" <c:if test="${rs.checkIn.status!='在住'}">disabled</c:if> onclick="javascript:custCheckInConsumeList(<c:out value="${rs.id}"/>,<c:out value="${rs.checkIn.id}"/>,'<c:out value="${rs.roomNo}"/>');"  value="消费记录" />&nbsp;
							<input  type="button" <c:if test="${rs.checkIn.status!='在住'}">disabled</c:if> onclick="javascript:foregiftList(<c:out value="${rs.id}"/>,<c:out value="${rs.checkIn.id}"/>,'<c:out value="${rs.roomNo}"/>');"  value="押金记录" />
						</td>
				  </tr>
			  </c:forEach>
				<tr>
				    <td colspan="17"> 
						<c:import url="/commons/pager1.jsp" charEncoding="GBK">
							<c:param name="submitAction"  value="guestList/list"/>
							<c:param name="countAll" 	         value="${pager.countAll}"/>
							<c:param name="pageCount" 	 value="${pager.pageCount}"/>
						</c:import>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
</c:if>
		   <tr>
		    <td colspan="17"> 
		      <table class="resBottom">
		        <tr> 
		          <td width="38%">
		            <input  type="button" name="expExcelButton"  onclick="javascript:expExcel();"  value="导出EXCEL" border=0/>
		          </td>
		          <td width="26%"> 
		            <div align="right"> </div>
		          </td>
		          <td width="36%">
				    <div align="right"> </div>
		          </td>
		        </tr>
		        </tbody>
		      </table>
		    </td>
		  </tr>
 	 </tbody> 
</table>
<SCRIPT language="javascript">
	$(document).ready(function(){ 
			// 奇偶行不同颜色
			$("#custCheckInRoomListTbl tbody tr:odd").addClass("rescontent_");  // 索引奇数
			$("#custCheckInRoomListTbl tbody tr:even").addClass("rescontent");
			// 鼠标移动行变色
			$("#custCheckInRoomListTbl tbody tr").hover(function(){
			    $(this).addClass("mouseHover");
			},function(){
			    $(this).removeClass("mouseHover");
			});
	});
</SCRIPT>
</BODY>
</HTML>