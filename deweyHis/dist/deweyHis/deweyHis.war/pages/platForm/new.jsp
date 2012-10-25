<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="TypeList"    value="${TypeList}"   scope="page"/>
<c:set var="StatusList" value="${StatusList}" scope="page"/>
<c:set var="merUser"   value="${merUser}"  scope="page"/>
<c:set var="merRoleList"   value="${merRoleList}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.loginName))    {
		window.alert("请输入登录名!") ;
		form1.loginName.focus(); 
		return;
	}
	if(isEmpty(form1.chineseName))    {
		window.alert("请输入中文名!") ;
		form1.chineseName.focus(); 
		return;
	}
	if(isEmpty(form1.type))    {
		window.alert("请选择用户类型!") ;
		form1.type.focus(); 
		return;
	}
	if(isEmpty(form1.status))    {
		window.alert("请选择用户状态!") ;
		form1.status.focus(); 
		return;
	}
	if(getCheckSelectValue("role")[0] == 0) {
		window.alert("请选择用户拥有的角色!") ;
		return;
	}
	htmlobj=$.ajax({
		url:"<c:url value="/merUser/checkLoginNameUnique"/>?loginName=" + form1.loginName.value + "&randValue=" + getRandom(),
		type: "GET",
		async:false,  // 同步请求
		processData: true,
		dataType: "html",
		data: {},
		success: function(data) {},
		error:function(e){}
	});
	if (htmlobj.responseText == "false") {
		alert("该登录名已被使用，请换个登录名新增。");
		return;
	}
	form1.action="${pageContext.request.contextPath}/merUser/create"; 
	form1.target="_self";     // _blank
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merUser/create"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${merUser.mer.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">【新增商户】</TD>
		    </TR>
				<tr>
					<td class="hcihead">杜威号</td>
					<td class=hcicontent colspan="3"><input type="text" name="deweyNo"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead" width="12%">商户名称</td>
					<td class=hcicontent colspan="3"><input type="text" name="fullName"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">客房数</td>
					<td class=hcicontent colspan="3"><input type="text" name="roomNum"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">电话</td>
					<td class=hcicontent colspan="3"><input type="text" name="telephone"  maxlength="13"></td>
				</tr>
				<tr>
					<td class="hcihead">传真</td>
					<td class=hcicontent colspan="3"><input type="text" name="fax"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">联系人</td>
					<td class=hcicontent colspan="3"><input type="text" name="linkmanName"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">联系人手机</td>
					<td class=hcicontent colspan="3"><input type="text" name="mobilephone"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">商户状态</td>
					<td class=hcicontent colspan="3">
						<select name="status">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${StatusList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>"><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
			    <TR>
			      <TD class=hcihead colspan="4">
			        <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="保存" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="返回" />
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>