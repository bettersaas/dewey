<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="checkIn"   value="${checkIn}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
		<style type=text/css>
			.sec1{
						background-color:#FFFFFF;
						cursor:hand;
						color:#000000;
						border-left:1px solid #FFFFFF;
						border-top:1px solid #FFFFFF;
						border-right:1px solid gray;
						border-bottom:1px solid #FFFFFF
					 }
			.sec2{
						background-color:#799ae1;
						cursor:hand;
						color:#000000;
						border-left:1px solid #FFFFFF;
						border-top:1px solid #FFFFFF;
						border-right:1px solid gray;
						border-weight:bold;
					 }
		</style>
		<script language="JavaScript" type="text/JavaScript">
            <!--
			function writeSubString(str,len){
		    	if (str.length > len) {
		    		document.writeln(str.substring(0,len)+'...');
		    	} else {
		    		document.writeln(str);
		        }
		    }
            function initTable() {
            	var tableIndex;
            		if(form2.custCheckInRoomIndex.value == null || form2.custCheckInRoomIndex.value == "") {
            			tableIndex = 0;
            		} else {
            			tableIndex = form2.custCheckInRoomIndex.value;
            		}
            	secBoard(tableIndex);
            }
			function secBoard(n){
				var nadd1 = parseInt(n)+1;
				var custCheckInRoomListObj = document.all("custCheckInRoomList");
				for(i=1;i<custCheckInRoomListObj.rows.length;i++){
					if (i==nadd1) {
						custCheckInRoomListObj.rows[i].className="sec2";
					} else {
						custCheckInRoomListObj.rows[i].className="sec1";
					}
				}
				var custCheckInRoomObj = document.all("custCheckInRoom");
				for(i=0;i<custCheckInRoomObj.tBodies.length;i++){
					custCheckInRoomObj.tBodies[i].style.display="none";
				}
				custCheckInRoomObj.tBodies[n].style.display="block";
			}
			function window.onload(){
				initTable();
			}
			// ����ס�Ŀͷ�������ס��ע��Ϣ
			function updateCustCheckInRoomRemark(tableIndex){
				form2.custCheckInRoomIndex.value = tableIndex;
				var remark = document.getElementsByName("remark"+tableIndex)[0].value;
				var id = document.getElementsByName("id"+tableIndex)[0].value;
				if (remark.length>50) {
					alert('�������ܳ���50���ַ����������ַ�����');
					document.getElementsByName("remark"+tableIndex)[0].select();
					return false;
				}
				form2.custCheckInRoomId.value = id;
				form2.custCheckInRoomRemark.value = remark;
				form2.action="${pageContext.request.contextPath}/custCheckInRoom/updateRemark";
				form2.target="_self";
				form2.submit();
			}
			// ������ס�Ǽ���Ϣ
			function checkInEdit(checkInId) {
				form1.action='<c:url value="/checkIn/edit/"/>' + checkInId;
				form1.target="_self";
				form1.submit();
			}
			// ����
			function changeRoom(custCheckInRoomId,checkInId,roomNo,registPrice,amount) {
				form1.custCheckInRoomId.value=custCheckInRoomId;
				form1.checkInId.value=checkInId;
				form1.roomNo.value=roomNo;
				form1.registPrice.value=registPrice;
				form1.amount.value=amount;
				form1.action='<c:url value="/exchangeRoom/new"/>';
				form1.target="IFEAME1";
				form1.submit();
			}
			// ���ѹ���
			function custCheckInConsumeList(custCheckInRoomId,checkInId,roomNo) {
				form1.custCheckInRoomId.value=custCheckInRoomId;
				form1.checkInId.value=checkInId;
				form1.roomNo.value=roomNo;
				form1.action='<c:url value="/custCheckInConsume/list/"/>' + custCheckInRoomId;
				form1.target="IFEAME1"; // _self
				form1.submit();
			}
			// Ѻ�����
			function foregiftList(custCheckInRoomId,checkInId,roomNo) {
				form1.custCheckInRoomId.value=custCheckInRoomId;
				form1.checkInId.value=checkInId;
				form1.roomNo.value=roomNo;
				form1.action='<c:url value="/foregift/list/"/>' + custCheckInRoomId;
				form1.target="IFEAME1";
				form1.submit();
			}
			//-->
		</script>
</HEAD>
<BODY>
          <br>
		  <div align="center">
		  <form name="form1" method=post action="<c:url value="/checkIn/create"/>" target="_self">
		  <input type="hidden" name="merId" value="<c:out value="${checkIn.mer.id}"/>">
		  <input type="hidden" name="roomTypeId">
		  <input type="hidden" name="custCheckInRoomId">
		  <input type="hidden" name="checkInId">
		  <input type="hidden" name="roomNo">
		  <input type="hidden" name="registPrice">
		  <input type="hidden" name="amount">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		   <THEAD> 
			    <TR class="hcititle"> 
			      <TD colSpan="8">��������ס�Ǽ���ϸ��</TD>
			    </TR>
		     <THEAD> 
		    <TBODY> 
				<tr>
					<td colspan="8"><p>�Ǽ��ÿ���Ϣ:	</p>	</td>
				</tr>
				<tr>
					<td class="hcihead"   width="8%">����</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.custName}"/></td>
					<td class="hcihead"   width="8%">�Ա�</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.sex}"/></td>
					<td class="hcihead"   width="8%">��ϵ�绰</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.phone}"/></td>
					<td class="hcihead"   width="8%">��ַ</td>
					<td class=hcicontent  width="17%"  title="<c:out value="${checkIn.address}"/>"><script language="javascript">writeSubString('<c:out value="${checkIn.address}"/>',15)</script></td>
				</tr>
				<tr>
					<td class="hcihead">֤������</td>
					<td class=hcicontent><c:out value="${checkIn.idType}"/></td>
					<td class="hcihead">֤������</td>
					<td class=hcicontent ><c:out value="${checkIn.idNo}"/></td>
					<td class="hcihead">����</td>
					<td class=hcicontent ><c:out value="${checkIn.peopleNum}"/></td>
					<td class="hcihead">���ȯ</td>
					<td class=hcicontent ><c:out value="${checkIn.breakfastTicket}"/></td>
				</tr>
				<tr>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.arrivalDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">Ԥ���������</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent ><c:out value="${checkIn.stayDays}"/></td>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent><c:out value="${checkIn.stayType}"/></td>
				</tr>
				<tr>
					<td class="hcihead">���ʽ</td>
					<td class=hcicontent><c:out value="${checkIn.settleMode}"/></td>
					<td class="hcihead">Ԥ��Ѻ��</td>
					<td class=hcicontent ><fmt:formatNumber value="${checkIn.deposit}" type="currency" pattern="#####0.00"/></td>
					<td class="hcihead">�ÿ����</td>
					<td class=hcicontent ><c:out value="${checkIn.custType}"/></td>
					<td class="hcihead">ǩ�����˵�λ</td>
					<td class=hcicontent   title="<c:out value="${checkIn.contractualUnitName}"/>" ><script language="javascript">writeSubString('<c:out value="${checkIn.contractualUnitName}"/>',15)</script></td>
				</tr>
				<tr>
					<td class="hcihead">��ע</td>
					<td class=hcicontent  colspan="7">
						<pre><c:out value="${checkIn.remark}"/></pre>
					</td>
				</tr>
				<tr>
				      <td height="28" class=hcihead colspan="8" style="text-align:center">
				      	<input  type="button" name="update"  onclick="javascript:checkInEdit(<c:out value="${checkIn.id}"/>);"  value="�޸��ÿ���Ϣ" />&nbsp;&nbsp;
				      	<input  type="button" name="newReg"   onclick="javascript:newCheckIn();"  value="  ��  ��  �� " />&nbsp;&nbsp;
				      	<input  type="button" name="newGuest"   onclick="javascript:guestListQuery();"  value="  �ÿ��б� " />
				      </td>
				</tr>
				<c:if test="${not empty checkIn.exchangeRooms}">
				<tr>
					<td colspan="8"><p>������ʷ��Ϣ:</p></td>
				</tr>
				<tr>
					<td colspan="8">
						<table width="100%"  style="border-collapse:collapse;"  border="1" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="25" width="8%" align="center">No.</td>
								<td height="25" width="10%" align="center">ԭ����</td>
								<td height="25" width="10%" align="center">ԭ����</td>
								<td height="25" width="10%" align="center">�·���</td>
								<td height="25" width="10%" align="center">�·���</td>
								<td height="25" width="15%" align="center">����ʱ��</td>
								<td height="25" width="*" align="center">�ÿ�����</td>
				    		</tr>
							<c:forEach var="rs" items="${checkIn.exchangeRooms}" varStatus="vStatus">
								<tr>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${vStatus.index+1}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.oldRoomNo}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.oldRoomNoPrice}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.roomNo}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.roomNoPrice}"/></td>
									<td height="24" align="center" valign="middle" nowrap><fmt:formatDate value="${rs.exchangeTime}" pattern="yyyy-MM-dd HH:mm" /></td>
									<td height="24" align="left" valign="middle"><c:out value="${rs.travler}"/></td>
					    		</tr>
					    	</c:forEach>
						</table>
					</td>
				</tr>
				</c:if>
				<tr>
					<td colspan="8"><p>��ס�����б���Ϣ:</p></td>
				</tr>
				<tr>
					<td colspan="8">
						<table  id="custCheckInRoomList"  width="100%"  style="border-collapse:collapse;"  border="1" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="25" width="4%" align="center">No.</td>
								<td height="25" width="6%" align="center">����</td>
								<td height="25" width="6%" align="center">����</td>
								<td height="25" width="6%" align="center">����</td>
								<td height="25" width="6%" align="center">�ۿ�(��)</td>
								<td height="25" width="6%" align="center">�ۿۼ�</td>
								<td height="25" width="*" align="center">��ע</td>
								<td height="25" width="15%" align="center">&nbsp;</td>
				    		</tr>
							<c:forEach var="rs" items="${checkIn.custCheckInRooms}" varStatus="vStatus">
								<tr onclick="secBoard(<c:out value="${vStatus.index}"/>)" >
									<td height="24" align="center" valign="middle" nowrap><c:out value="${vStatus.index+1}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.roomNo}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.bedNo}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.registPrice}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.discount}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.amount}"/></td>
									<td height="24" align="left" valign="middle"><c:out value="${rs.remark}"/></td>
									<td height="24" align="center" valign="middle" nowrap>
										<input type="button" value=" �� �� " name="changeRoomBtn"                         onclick="javascript:changeRoom(<c:out value="${rs.id}"/>,<c:out value="${checkIn.id}"/>,'<c:out value="${rs.roomNo}"/>',<c:out value="${rs.registPrice}"/>,<c:out value="${rs.amount}"/>);">&nbsp;&nbsp;
										<input type="button" value="���ѹ���" name="custCheckInConsumeListBtn" onclick="javascript:custCheckInConsumeList(<c:out value="${rs.id}"/>,<c:out value="${checkIn.id}"/>,'<c:out value="${rs.roomNo}"/>');">&nbsp;&nbsp;
										<input type="button" value="Ѻ�����" name="foregiftListBtn"                           onclick="javascript:foregiftList(<c:out value="${rs.id}"/>,<c:out value="${checkIn.id}"/>,'<c:out value="${rs.roomNo}"/>');"   />
									</td>
					    		</tr>
					    	</c:forEach>
						</table>
					</td>
				</tr>
		    </TBODY>
		  </TABLE>
		  </form>
		  
		  <form name="form2" method="post" action="" target="_self">
				<input type="hidden" name="checkInId" value="<c:out value="${checkIn.id}"/>" >
				<input type="hidden" name="merId"       value="<c:out value="${checkIn.mer.id}"/>">
				<input type="hidden" name="custCheckInRoomIndex"    value="<c:out value="${param.custCheckInRoomIndex}"/>">
				<input type="hidden" name="custCheckInRoomId">
				<input type="hidden" name="custCheckInRoomRemark">
				<!-- ��ʾÿ����ס�ͷ�����ϸ��Ϣ -->
				<table id=custCheckInRoom class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" width=100% height=100 style="border-collapse:collapse;">
				<thead>
					<td colspan="8"><p>��ס�ͷ���ϸ��Ϣ:</p></td>
				</thead>
				<c:forEach var="rs" items="${checkIn.custCheckInRooms}" varStatus="vStatus">
				<tbody  <c:choose><c:when  test="${vStatus.first}">style="display:block;"</c:when><c:otherwise>style="display:none;"</c:otherwise></c:choose>   >
					<input type="hidden" name="id<c:out value="${vStatus.index}"/>" value="<c:out value="${rs.id}"/>">
					<tr>
						<td colspan="8">
							<p>��ע&nbsp;</p>
							<p>
								<textarea name="remark<c:out value="${vStatus.index}"/>" cols="60" rows="2" onblur="if(this.value.length>50){alert('�������ܳ���50���ַ����������ַ�����');this.select();return false;}return true;"><c:out value="${rs.remark}"/></textarea>
								&nbsp;&nbsp;<input type="button" value=" �� �� " onclick="updateCustCheckInRoomRemark(<c:out value="${vStatus.index}"/>);">
							</p>
						</td>
					</tr>
				</tbody>
				</c:forEach>
			</table>
			<iframe name="IFEAME1" src="<c:url value="/commons/newBlank.jsp"/>"  ID="showTradeDetail" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" width=100% height="0" style="height:expression(1); aho:expression(autoResize('IFEAME1'))"> 
			</iframe>
		  </form>
		</div>
		<br>
		<script type="text/javascript">
			function newCheckIn()
			{
				window.location.href="<c:url value="/checkIn/new"/>";
			}
			function guestListQuery()
			{
				window.location.href="<c:url value="/guestList/query"/>";
			}
		</script>
 </BODY>
 </HTML>