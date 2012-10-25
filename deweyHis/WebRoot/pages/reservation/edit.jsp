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
			      <TD colSpan="6">��������ס�Ǽ���ϸ��</TD>
			    </TR>
		     <THEAD> 
		    <TBODY> 
				<tr>
					<td class="hcihead"   width="12%">����</td>
					<td class=hcicontent  width="21%"><c:out value="${checkIn.custName}"/></td>
					<td class="hcihead"   width="12%">�Ա�</td>
					<td class=hcicontent  width="21%"><c:out value="${checkIn.sex}"/></td>
					<td class="hcihead"   width="12%">��ϵ�绰</td>
					<td class=hcicontent  width="*"><input type="text" name="phone" maxlength="20" value="<c:out value="${checkIn.phone}"/>" ></td>
				</tr>
				<tr>
					<td class="hcihead">֤������</td>
					<td class=hcicontent ><c:out value="${checkIn.idType}"/></td>
					<td class="hcihead">֤������</td>
					<td class=hcicontent ><c:out value="${checkIn.idNo}"/></td>
					<td class="hcihead">��ַ</td>
					<td class=hcicontent ><c:out value="${checkIn.address}"/></td>
				</tr>
				<tr>
					<td class="hcihead">����</td>
					<td class=hcicontent ><c:out value="${checkIn.peopleNum}"/></td>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.arrivalDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">Ԥ���������</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
				</tr>
				<tr>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent ><c:out value="${checkIn.stayDays}"/></td>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent><c:out value="${checkIn.stayType}"/></td>
					<td class="hcihead">���ʽ</td>
					<td class=hcicontent><c:out value="${checkIn.settleMode}"/></td>
				</tr>
				<tr>
					<td class="hcihead">Ԥ��Ѻ��</td>
					<td class=hcicontent ><fmt:formatNumber value="${checkIn.deposit}" type="currency" pattern="#####0.00"/></td>
					<td class="hcihead">�ÿ����</td>
					<td class=hcicontent ><c:out value="${checkIn.custType}"/></td>
					<td class="hcihead">ǩ�����˵�λ</td>
					<td class=hcicontent ><c:out value="${checkIn.contractualUnitName}"/></td>
				</tr>
				<tr>
					<td class="hcihead">���ȯ</td>
					<td class=hcicontent ><c:out value="${checkIn.breakfastTicket}"/></td>
					<td class="hcihead">����</td>
					<td class=hcicontent ><c:out value="${checkIn.roomType.name}"/></td>
					<td class=hcicontent  colspan="2"></td>
				</tr>
				<tr>
					<td class="hcihead">��ע</td>
					<td class=hcicontent  colspan="5">
						<textarea  rows="5" cols="120" name="remark"  onpropertychange="textCounter(this, 500);" ><c:out value="${checkIn.remark}"/></textarea>
						ʣ������: <input name="strlength" type=text id="strlength" style= "background-color: #D4D0C8; border: 0; color: red " value="<c:out value="${500-fn:length(checkIn.remark)}"/>" size="3" maxlength="3" readonly>
					</td>
				</tr>
				<tr>
					<td class=hcicontent colspan="6">
						<TABLE width="35%">
								<tr>
									<td>�������</td>
									<td>����</td>
									<td>�ǼǼ۸�</td>
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
				      	<input  type="button" name="saveButton" onclick="javascript:formSubmit();"  value="ȷ��" />&nbsp;&nbsp;
				      	<input  type="reset"  name="resetButton" value="����" />&nbsp;&nbsp;
				      	<input  type="reset"  name="goBackButton" onclick="javascript:history.back();" value="����" />
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
	// textarea������������ if(value.length>500) value=value.substr(0,500);
	function textCounter(field, maxlimit) {
		if (field.value.length > maxlimit){
			field.value = field.value.substring(0, maxlimit);
		}else{
			document.form1.strlength.value = maxlimit - field.value.length;
		}
	}
</script>
 </HTML>