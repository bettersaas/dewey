<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="foregift"   value="${foregift}"    scope="page"/>
<c:set var="PayTypeList"   value="${PayTypeList}"    scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
// form提交
function formSubmit()
{
	if(form1.payType.value == "") {
		window.alert("请选择付款方式!");
		form1.payType.focus(); 
		return;
	}
	if(isEmpty(form1.payAmount)) {
		window.alert("请输入金额!");
		form1.payAmount.focus();
		return;
	}
	if(!isMoney(form1.payAmount)) {
		alert("请输入正确金额!");
		form1.payAmount.focus();
		return;
	}
	form1.action="${pageContext.request.contextPath}/foregift/update";
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/foregift/update"/>" target="_self">
  		<input type="hidden" name="id"         value="<c:out value="${foregift.id}"/>">
        <input type="hidden" name="merId"  value="<c:out value="${foregift.merId}"/>">
        <input type="hidden" name="custCheckInRoom.id"  value="<c:out value="${foregift.custCheckInRoom.id}"/>">
        <input type="hidden" name="roomNo" value="<c:out value="${foregift.roomNo}"/>">
        <input type="hidden" name="billNo" value="<c:out value="${foregift.billNo}"/>">
        <input type="hidden" name="payNo" value="<c:out value="${foregift.payNo}"/>">
        <input type="hidden" name="extendDays" value="<c:out value="${foregift.extendDays}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY>
		    <TR class="hcititle">
		      <TD colSpan="4">【编辑押金】</TD>
		    </TR>
			<tr>
				<td class="hcihead">付款方式</td>
				<td class=hcicontent >
				    <select name="payType">
				    	<option value="">--请选择--</option>
				    	<c:forEach var="rs" items="${PayTypeList}" varStatus="vStatus">
				    		<option value="<c:out value="${rs.value}"/>" <c:if test="${foregift.payType == rs.value}">selected</c:if> ><c:out value="${rs.name}"/></option>
				    	</c:forEach>
				    </select>
				</td>
			</tr>
			<tr>
				<td class="hcihead">金额</td>
				<td class=hcicontent colspan="3"><input type="text" name="payAmount" value="<c:out value="${foregift.payAmount}"/>"></td>
			</tr>
			<tr>
				<td class="hcihead">备注</td>
				<td class=hcicontent colspan="3"><textarea name="remark" cols="60" rows="2" onblur="if(this.value.length>100){alert('字数不能超过100个字符，请缩减字符数！');this.select();return false;}return true;"><c:out value="${foregift.remark}"/></textarea></td>
			</tr>
			<TR>
			      <TD class=hcihead colspan="4" style="text-align:center">
			        <a href="javascript:formSubmit();"><img src="<c:url value="/images/button/save.gif"/>" border=0></a>
			        <a href="javascript:history.back();"><img src="<c:url value="/images/button/return.gif"/>" border=0></a>
			      </TD>
			</TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
  <br>
 </body>
</html>