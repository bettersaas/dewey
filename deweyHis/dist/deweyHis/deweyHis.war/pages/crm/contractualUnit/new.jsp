<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="contractualUnit"       value="${contractualUnit}"       scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
// form提交
function formSubmit()
{
	if(isEmpty(form1.company))    {
		window.alert("请输入单位名称!") ;
		form1.company.focus(); 
		return;
	}
	if(isEmpty(form1.linkman))    {
		window.alert("请输入联系人!") ;
		form1.linkman.focus(); 
		return;
	}
	if(isEmpty(form1.address)) {
		alert("请输入联系地址");
		form1.address.focus(); 
		return;
	}
	if(isEmpty(form1.telphone)) {
		alert("请输入联系电话");
		form1.telphone.focus(); 
		return;
	}
	if(isEmpty(form1.fax)) {
		alert("请输入传真");
		form1.fax.focus(); 
		return;
	}
	if(isEmpty(form1.remark)) {
		alert("请输入备注");
		form1.remark.focus(); 
		return;
	}
	var itemCnt = parseInt($('#itemCnt').val());
	if(!isNaN(itemCnt)) {
		for(i=0;i<itemCnt;i++) {
			var contractualPrice = document.getElementsByName('merContractualRelations[' + i + '].contractualPrice')[0];
			if(isEmpty(contractualPrice)) {
				alert("请输入协议房价");
				contractualPrice.select();
				return;
			}
			if(!isMoney(contractualPrice)) {
				contractualPrice.select();
				return;
			}
		}
	}
	
	form1.action="${pageContext.request.contextPath}/contractualUnit/create";
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/contractualUnit/create"/>" target="_self">
        <input type="hidden" name="mer.id"  value="<c:out value="${contractualUnit.mer.id}"/>">
        <input type="hidden" value="${fn:length(contractualUnit.merContractualRelations)}" id="itemCnt"/>
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY>
		    <TR class="hcititle">
		      <TD colSpan="4">【新增协议单位】</TD>
		    </TR>
			<tr>
				<td class="hcihead">单位名称</td>
				<td class=hcicontent colspan="3"><input type="text" name="company"   maxlength="40"></td>
			</tr>
			<tr>
				<td class="hcihead">联系人</td>
				<td class=hcicontent colspan="3"><input type="text" name="linkman"   maxlength="40"></td>
			</tr>
			<tr>
				<td class="hcihead">联系地址</td>
				<td class=hcicontent colspan="3"><input type="text" name="address"   maxlength="120"></td>
			</tr>
			<tr>
				<td class="hcihead">联系电话</td>
				<td class=hcicontent colspan="3"><input type="text" name="telphone"   maxlength="50"></td>
			</tr>
			<tr>
				<td class="hcihead">传真</td>
				<td class=hcicontent colspan="3"><input type="text" name="fax"   maxlength="20"></td>
			</tr>
			<tr>
				<td class="hcihead">备注</td>
				<td class=hcicontent colspan="3"><textarea   name="remark"  cols="80"   rows="5"></textarea></td>
			</tr>
			<tr>
				<td class=hcicontent colspan="4">
					<table  width="35%">
						<tr>
							<td width="40%">房型</td>
							<td width="30%">原价</td>
							<td width="30%">协议价</td>
						</tr>
						<c:forEach var="rs" items="${contractualUnit.merContractualRelations}" varStatus="vStatus">
							<tr>
								<input type="hidden" name="merContractualRelations[<c:out value="${vStatus.index}"/>].roomType.id"  value="<c:out value="${rs.roomType.id}"/>">
								<td><c:out value="${rs.roomType.name}"/></td>
								<td><c:out value="${rs.roomType.alldayPrice}"/></td>
								<td><input type="text" name="merContractualRelations[<c:out value="${vStatus.index}"/>].contractualPrice" value="<c:out value="${rs.roomType.alldayPrice}"/>"/></td>
							</tr>
						</c:forEach>
					</table>
				</td>
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
 </body>
</html>