<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="ConsumeTypeList" value="${ConsumeTypeList}" scope="page"/>
<c:set var="merServices"                 value="${merServices}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.price))    {
		window.alert("请输入单价!") ;
		form1.price.focus(); 
		return;
	}
	if(!isMoney(form1.price))    {
		window.alert("请输入正确的单价!") ;
		form1.price.focus(); 
		return;
	}
	if(isEmpty(form1.consumeType))    {
		window.alert("请选择类别!") ;
		return;
	}
	if(isEmpty(form1.consumeUnit))    {
		window.alert("请输入单位!") ;
		form1.consumeUnit.focus(); 
		return;
	}
	if(isEmpty(form1.servicesDesc))    {
		window.alert("请输入描述!") ;
		form1.servicesDesc.focus(); 
		return;
	}
	form1.action="${pageContext.request.contextPath}/merServices/update"; 
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merServices/update"/>" target="_self">
        <input type="hidden" name="id"        value="<c:out value="${merServices.id}"/>">
        <input type="hidden" name="merId" value="<c:out value="${merServices.merId}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">【修改消费项目】</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">名称</td>
					<td class=hcicontent colspan="3"><input type="text" name="name" readonly value="<c:out value="${merServices.name}"/>" maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">单价</td>
					<td class=hcicontent colspan="3"><input type="text" name="price"  value="<c:out value="${merServices.price}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">类别</td>
					<td class=hcicontent colspan="3">
					    <select name="consumeType">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${ConsumeTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" <c:if test="${merServices.consumeType == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">单位</td>
					<td class=hcicontent colspan="3"> <input type="text" name="consumeUnit" value="<c:out value="${merServices.consumeUnit}"/>"  maxlength="10"></td>
				</tr>
				<tr>
					<td class="hcihead">描述</td>
					<td class=hcicontent colspan="3"><input type="text" name="servicesDesc" value="<c:out value="${merServices.servicesDesc}"/>"  maxlength="50"></td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			        <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="保存" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="返回"/>
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>