<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="chargeRuleSetting" value="${chargeRuleSetting}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.column1))    {
			window.alert("请输入名称!") ; 
			form1.column1.focus();
			return;
	}

	form1.target="_self";     // _blank
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/chargeRuleSetting/update"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${chargeRuleSetting.mer.id}"/>">
        <input type="hidden" name="id" value="<c:out value="${chargeRuleSetting.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">【计费设置表单】</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">column1</td>
					<td class=hcicontent colspan="3"><input type="text" name="column1"  value="<c:out value="${chargeRuleSetting.column1}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column2</td>
					<td class=hcicontent colspan="3"><input type="text" name="column2"  value="<c:out value="${chargeRuleSetting.column2}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column3</td>
					<td class=hcicontent colspan="3"><input type="text" name="column3"  value="<c:out value="${chargeRuleSetting.column3}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column4</td>
					<td class=hcicontent colspan="3"><input type="text" name="column4"  value="<c:out value="${chargeRuleSetting.column4}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column5</td>
					<td class=hcicontent colspan="3"><input type="text" name="column5"  value="<c:out value="${chargeRuleSetting.column5}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column6</td>
					<td class=hcicontent colspan="3"><input type="text" name="column6"  value="<c:out value="${chargeRuleSetting.column6}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column7</td>
					<td class=hcicontent colspan="3"><input type="text" name="column7"  value="<c:out value="${chargeRuleSetting.column7}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column8</td>
					<td class=hcicontent colspan="3"><input type="text" name="column8"  value="<c:out value="${chargeRuleSetting.column8}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">column9</td>
					<td class=hcicontent colspan="3"><input type="text" name="column9"  value="<c:out value="${chargeRuleSetting.column9}"/>"></td>
				</tr>
								<tr>
					<td class="hcihead">column10</td>
					<td class=hcicontent colspan="3"><input type="text" name="column10"  value="<c:out value="${chargeRuleSetting.column10}"/>"></td>
				</tr>
								<tr>
					<td class="hcihead">column11</td>
					<td class=hcicontent colspan="3"><input type="text" name="column11"  value="<c:out value="${chargeRuleSetting.column11}"/>"></td>
				</tr>
								<tr>
					<td class="hcihead">column12</td>
					<td class=hcicontent colspan="3"><input type="text" name="column12"  value="<c:out value="${chargeRuleSetting.column12}"/>"></td>
				</tr>
								<tr>
					<td class="hcihead">column13</td>
					<td class=hcicontent colspan="3"><input type="text" name="column13"  value="<c:out value="${chargeRuleSetting.column13}"/>"></td>
				</tr>
								<tr>
					<td class="hcihead">column14</td>
					<td class=hcicontent colspan="3"><input type="text" name="column14"  value="<c:out value="${chargeRuleSetting.column14}"/>"></td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			        <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="保存" />
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>