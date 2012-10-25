<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="merServicesList"             value="${merServicesList}"             scope="page"/>
<c:set var="custCheckInConsume"   value="${custCheckInConsume}"    scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
/**
* 选择服务项目自动获取服务信息
**/
function setMerServicesInfo(selectValue) 
{
	var a = $.trim(selectValue);
	if (a == "") {
		document.getElementById("merServices.id").value="";
		document.getElementById("merServicesPrice").value="";
		document.getElementById("merServicesConsumeUnit").value="";
	} else {
		var strs= new Array();
		strs=a.split("-");
		document.getElementById("merServices.id").value=strs[0];
		document.getElementById("merServicesPrice").value=strs[1];
		document.getElementById("merServicesConsumeUnit").value=strs[2];
	}
}
// form提交
function formSubmit()
{
	if(form1.merServicesId.value == "") {
		window.alert("请选择消费项目!");
		form1.merServicesId.focus(); 
		return;
	}
	if(isEmpty(form1.scalar)) {
		window.alert("请输入数量!");
		form1.scalar.focus();
		return;
	}
	if(!isInt(form1.scalar)) {
		alert("请输入整数!");
		form1.scalar.focus();
		return;
	}
	form1.total.value = parseFloat(form1.merServicesPrice.value) * parseInt(form1.scalar.value);
	form1.action="${pageContext.request.contextPath}/custCheckInConsume/create";
	form1.target="_self";
	form1.submit();
}
function setTotal()
{
	if(isEmpty(form1.scalar))    {
		return;
	}
	if(!isInt(form1.scalar)) {
		alert("请输入整数!");
		form1.scalar.focus();
		return;
	}
	form1.total.value = parseFloat(form1.merServicesPrice.value) * parseInt(form1.scalar.value,10);
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/custCheckInConsume/create"/>" target="_self">
        <input type="hidden" name="merId"                            value="<c:out value="${custCheckInConsume.merId}"/>">
        <input type="hidden" name="custCheckInRoom.id"  value="<c:out value="${custCheckInConsume.custCheckInRoom.id}"/>">
        <input type="hidden" name="roomNo"                        value="<c:out value="${param.roomNo}"/>">
        <input type="hidden" name="merServices.id">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY>
		    <TR class="hcititle">
		      <TD colSpan="4">【新增消费】</TD>
		    </TR>
			<tr>
				<td class="hcihead">项目名称</td>
				<td class=hcicontent colspan="3">
				    <select name="merServicesId" onchange="setMerServicesInfo(this.options[this.options.selectedIndex].value)">
				    	<option value="">--请选择--</option>
				    	<c:forEach var="rs" items="${merServicesList}" varStatus="vStatus">
				    		<option value="<c:out value="${rs.id}-${rs.price}-${rs.consumeUnit}"/>"><c:out value="${rs.name}"/></option>
				    	</c:forEach>
				    </select>
				</td>
			</tr>
			<tr>
				<td class="hcihead">单价</td>
				<td class=hcicontent colspan="3"><input type="text" name="merServicesPrice" disabled></td>
			</tr>
			<tr>
				<td class="hcihead">数量</td>
				<td class=hcicontent colspan="3"><input type="text" name="scalar"   maxlength="10" onblur="setTotal();"></td>
			</tr>
			<tr>
				<td class="hcihead">单位</td>
				<td class=hcicontent colspan="3"><input type="text" name="merServicesConsumeUnit" disabled></td>
			</tr>
			<tr>
				<td class="hcihead">金额</td>
				<td class=hcicontent colspan="3"><input type="text" name="total"   maxlength="10" onblur="setTotal();"></td>
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