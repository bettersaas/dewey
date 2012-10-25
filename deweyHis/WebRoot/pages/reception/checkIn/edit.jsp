<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="checkIn"   value="${checkIn}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
</HEAD>
<BODY>
 </BODY>
 		<form name="form1" method=post action="<c:url value="/checkIn/update"/>" target="_self">
 		<input type="hidden" name="id" value="<c:out value="${checkIn.id}"/>">
          <br>
		  <div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		   <THEAD> 
			    <TR class="hcititle"> 
			      <TD colSpan="6">【客人入住登记明细】</TD>
			    </TR>
		     <THEAD> 
		    <TBODY> 
				<tr>
					<td class="hcihead"   width="12%">姓名</td>
					<td class=hcicontent  width="21%"><c:out value="${checkIn.custName}"/></td>
					<td class="hcihead"   width="12%">性别</td>
					<td class=hcicontent  width="21%"><c:out value="${checkIn.sex}"/></td>
					<td class="hcihead"   width="12%">联系电话</td>
					<td class=hcicontent  width="*"><input type="text" name="phone" maxlength="20" value="<c:out value="${checkIn.phone}"/>" ></td>
				</tr>
				<tr>
					<td class="hcihead">证件类型</td>
					<td class=hcicontent ><c:out value="${checkIn.idType}"/></td>
					<td class="hcihead">证件号码</td>
					<td class=hcicontent ><c:out value="${checkIn.idNo}"/></td>
					<td class="hcihead">地址</td>
					<td class=hcicontent ><c:out value="${checkIn.address}"/></td>
				</tr>
				<tr>
					<td class="hcihead">人数</td>
					<td class=hcicontent ><c:out value="${checkIn.peopleNum}"/></td>
					<td class="hcihead">入住日期</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.arrivalDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">预计离店日期</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
				</tr>
				<tr>
					<td class="hcihead">入住天数</td>
					<td class=hcicontent ><c:out value="${checkIn.stayDays}"/></td>
					<td class="hcihead">入住类型</td>
					<td class=hcicontent><c:out value="${checkIn.stayType}"/></td>
					<td class="hcihead">付款方式</td>
					<td class=hcicontent><c:out value="${checkIn.settleMode}"/></td>
				</tr>
				<tr>
					<td class="hcihead">预付押金</td>
					<td class=hcicontent ><fmt:formatNumber value="${checkIn.deposit}" type="currency" pattern="#####0.00"/></td>
					<td class="hcihead">旅客类别</td>
					<td class=hcicontent ><c:out value="${checkIn.custType}"/></td>
					<td class="hcihead">签单挂账单位</td>
					<td class=hcicontent ><c:out value="${checkIn.contractualUnitName}"/></td>
				</tr>
				<tr>
					<td class="hcihead">早餐券</td>
					<td class=hcicontent ><c:out value="${checkIn.breakfastTicket}"/></td>
					<td class="hcihead">房型</td>
					<td class=hcicontent ><c:out value="${checkIn.roomType.name}"/></td>
					<td class=hcicontent  colspan="2"></td>
				</tr>
				<tr>
					<td class="hcihead">备注</td>
					<td class=hcicontent  colspan="5">
						<textarea  rows="5" cols="120" name="remark"  onpropertychange="textCounter(this, 500);" ><c:out value="${checkIn.remark}"/></textarea>
						剩余字数: <input name="strlength" type=text id="strlength" style= "background-color: #D4D0C8; border: 0; color: red " value="<c:out value="${500-fn:length(checkIn.remark)}"/>" size="3" maxlength="3" readonly>
					</td>
				</tr>
				<tr>
					<td class=hcicontent colspan="6">
						<TABLE width="35%">
								<tr>
									<td>房间序号</td>
									<td>房号</td>
									<td>登记价格</td>
					    		</tr>
							<c:forEach var="rs" items="${checkIn.custCheckInRooms}" varStatus="vStatus">
								<tr>
									<td><c:out value="${vStatus.index+1}"/></td>
									<td><c:out value="${rs.roomNo}"/></td>
									<td><c:out value="${rs.registPrice}"/></td>
					    		</tr>
					    	</c:forEach>
						</TABLE>
					</td>
				</tr>
				<TR>
				      <TD class=hcihead colspan="6" style="text-align:center">
				      	<input  type="button" name="saveButton" onclick="javascript:formSubmit();"  value="确认" />&nbsp;&nbsp;
				      	<input  type="reset"  name="resetButton" value="重置" />&nbsp;&nbsp;
				      	<input  type="reset"  name="goBackButton" onclick="javascript:history.back();" value="返回" />
				      </TD>
				</TR>
		    </TBODY>
		  </TABLE>
		</div>
		</form>
<script type="text/javascript">
	function formSubmit()
	{
		form1.action="${pageContext.request.contextPath}/checkIn/update";
		form1.target="_self";
		form1.submit();
	}
	// textarea限制输入字数 if(value.length>500) value=value.substr(0,500);
	function textCounter(field, maxlimit) {
		if (field.value.length > maxlimit){
			field.value = field.value.substring(0, maxlimit);
		}else{
			document.form1.strlength.value = maxlimit - field.value.length;
		}
	}
</script>
 </HTML>