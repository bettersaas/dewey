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
	// ���ѹ���
	function custCheckInConsumeList(custCheckInRoomId,checkInId,roomNo) {
		form1.custCheckInRoomId.value=custCheckInRoomId;
		form1.checkInId.value=checkInId;
		form1.roomNo.value=roomNo;
		form1.action='<c:url value="/custCheckInConsume/list/"/>' + custCheckInRoomId;
		form1.target="_self";
		form1.submit();
	}
	// Ѻ�����
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
		    	<td align=left colSpan=8>���ÿͲ�ѯ��</td>
		  </tr>
		  <tr>
		  	<td>����</td>
		  	<td><input type="text" name="custName" size="15" maxlength="20" value="<c:out value="${param.custName}"/>"></td>
		  	<td>֤�����</td>
		  	<td><input type="text" name="idNo" size="15" maxlength="20" value="<c:out value="${param.idNo}"/>"></td>
		  	<td>�Ǽ�ʱ��</td>
		  	<td>
		  		<input type="text" name="lcdStart" size="15" maxlength="19" value="<c:out value="${param.lcdStart}"/>">
		  		<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.lcdStart,null,'yyyy-MM-dd hh:mm',true);" />
		  		 - 
		  		 <input type="text" name="lcdEnd" size="15" maxlength="19" value="<c:out value="${param.lcdEnd}"/>">
		  		 <img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.lcdEnd,null,'yyyy-MM-dd hh:mm',true);" />
		    </td>
		  	<td>״̬</td>
		    <td align=left >
			    <select name="status">
			    	<option value="">--��ѡ��--</option>
			    	<c:forEach var="rs" items="${StatusList}" varStatus="vStatus">
			    		<option value="<c:out value="${rs.value}"/>"   <c:if test="${param['status'] == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
			    	</c:forEach>
			    </select>
			</td>
		  </tr>
		  <tr>
		  	<td>����</td>
		  	<td><input type="text" name="roomNoSearch" size="15" maxlength="10" value="<c:out value="${param.roomNoSearch}"/>"></td>
		  	<td>Э�鵥λ</td>
		  	<td><input type="text" name="contractualUnitName" size="15" maxlength="40" value="<c:out value="${param.contractualUnitName}"/>"></td>
		  	<td>Ԥ�����ʱ��</td>
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
		  		<input  type="button" name="save"  onclick="javascript:query();"  value=" �� ѯ(1) " />&nbsp;&nbsp;
		  		<input  type="button" name="save"  onclick="javascript:query1();"  value=" �� ѯ(2) " />&nbsp;&nbsp;
		  		<input  type="reset"  name="reset"    value=" �� �� " />
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
		    <th width="3%" nowrap>No.</th>
		    <th width="5%" nowrap>����</th>
			<th width="4%" nowrap>�Ա�</th>
			<th width="15%" nowrap>�Ǽ�ʱ��-Ԥ�����ʱ��</th>
			<th width="5%" nowrap>����</th>
			<th width="12%" nowrap>Э�鵥λ</th>
			<th width="4%" nowrap>����</th>
			<th width="7%" nowrap>��ϵ�绰</th>
			<th width="5%" nowrap>��ס����</th>
			<th width="5%" nowrap>״̬</th>
			<th width="*" nowrap>����</th>
			<th width="4%" nowrap>����</th>
			<th width="4%" nowrap>�ۿ�</th>
			<th width="4%" nowrap>�ۿۼ�</th>
			<th width="4%" nowrap>����</th>
			<th width="4%" nowrap>����</th>
			<th width="*">����</th>
		  </tr>
		</thead>
		<tbody id="tbd">
		<c:choose>
			<c:when test="${empty pageList}">
				<tr>
					<td colspan="17" align="center">���ÿ���Ϣ</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${pageList}" varStatus="vStatus">
				  <c:set var="custCheckInRoomsSize"    value="${fn:length(rs.custCheckInRooms)}" />
				  <tr> 
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><c:out value="${vStatus.index+1}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.custName}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.sex}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>" nowrap><fmt:formatDate   value="${rs.lcd}" pattern="yyyy-MM-dd HH:mm" />&nbsp;&nbsp;<fmt:formatDate   value="${rs.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.roomType.name}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.contractualUnitName}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.peopleNum}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.phone}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.stayType}"/></td>
						<td align="center" rowspan="<c:out value="${custCheckInRoomsSize}"/>"><c:out value="${rs.status}"/></td>
						<td align="center" nowrap rowspan="<c:out value="${custCheckInRoomsSize}"/>">
							<input  type="button" onclick="javascript:checkInShow(<c:out value="${rs.id}"/>);"  value="��������" />&nbsp;
							<input  type="button"  <c:if test="${rs.status!='��ס'}">disabled</c:if> onclick="javascript:checkInEdit(<c:out value="${rs.id}"/>);"  value="���˱༭" />
						</td>
						<td align="center" nowrap><c:out value="${rs.custCheckInRooms[0].registPrice}"/></td>
						<td align="center" nowrap><c:out value="${rs.custCheckInRooms[0].discount}"/></td>
						<td align="center" nowrap><c:out value="${rs.custCheckInRooms[0].amount}"/></td>
						<td align="center" nowrap><c:out value="${rs.custCheckInRooms[0].roomNo}"/></td>
						<td align="center" nowrap><c:out value="${rs.custCheckInRooms[0].bedNo}"/></td>
						<td align="center" nowrap>
							<input  type="button" <c:if test="${rs.status!='��ס'}">disabled</c:if> onclick="javascript:custCheckInConsumeList(<c:out value="${rs.custCheckInRooms[0].id}"/>,<c:out value="${rs.id}"/>,'<c:out value="${rs.custCheckInRooms[0].roomNo}"/>');"  value="���Ѽ�¼" />&nbsp;
							<input  type="button" <c:if test="${rs.status!='��ס'}">disabled</c:if> onclick="javascript:foregiftList(<c:out value="${rs.custCheckInRooms[0].id}"/>,<c:out value="${rs.id}"/>,'<c:out value="${rs.custCheckInRooms[0].roomNo}"/>');"  value="Ѻ���¼" />
						</td>
				  </tr>
				  <c:forEach var="rs1" items="${rs.custCheckInRooms}" varStatus="vStatus1">
				  	<c:if test="${not vStatus1.first}">
					  	<tr>
							<td align="center" nowrap><c:out value="${rs1.registPrice}"/></td>
							<td align="center" nowrap><c:out value="${rs1.discount}"/></td>
							<td align="center" nowrap><c:out value="${rs1.amount}"/></td>
							<td align="center" nowrap><c:out value="${rs1.roomNo}"/></td>
							<td align="center" nowrap><c:out value="${rs1.bedNo}"/></td>
							<td align="center" nowrap>
								<input  type="button"  <c:if test="${rs.status!='��ס'}">disabled</c:if>  onclick="javascript:custCheckInConsumeList(<c:out value="${rs1.id}"/>,<c:out value="${rs.id}"/>,'<c:out value="${rs1.roomNo}"/>');"  value="���Ѽ�¼" />&nbsp;
								<input  type="button"  <c:if test="${rs.status!='��ס'}">disabled</c:if>  onclick="javascript:foregiftList(<c:out value="${rs1.id}"/>,<c:out value="${rs.id}"/>,'<c:out value="${rs1.roomNo}"/>');"  value="Ѻ���¼" />
							</td>
					  	</tr>
				  	</c:if>
				  </c:forEach>
			  </c:forEach>
				<tr>
				    <td colspan="17"> 
						<c:import url="/commons/pager1.jsp" charEncoding="GBK">
							<c:param name="submitAction"  value="guestList/list1"/>
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
		            <input  type="button" name="expExcelButton"  onclick="javascript:expExcel();"  value="����EXCEL" border=0/>
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
			// ��ż�в�ͬ��ɫ
			$("#custCheckInRoomListTbl tbody tr:odd").addClass("rescontent_");  // ��������
			$("#custCheckInRoomListTbl tbody tr:even").addClass("rescontent");
			// ����ƶ��б�ɫ
			$("#custCheckInRoomListTbl tbody tr").hover(function(){
			    $(this).addClass("mouseHover");
			},function(){
			    $(this).removeClass("mouseHover");
			});
	});
</SCRIPT>
</BODY>
</HTML>