<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="TypeList"    value="${TypeList}"   scope="page"/>
<c:set var="StatusList" value="${StatusList}" scope="page"/>
<c:set var="merUser"  value="${merUser}" scope="page"/>
<c:set var="merRoleList"   value="${merRoleList}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
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
	form1.action="${pageContext.request.contextPath}/merUser/update"; 
	form1.target="_self";     // _blank
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merUser/update"/>" target="_self">
        <input type="hidden" name="id"        value="<c:out value="${merUser.id}"/>">
        <input type="hidden" name="mer.id" value="<c:out value="${merUser.mer.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">【修改用户】</TD>
		    </TR>
				<tr>
					<td class="hcihead">登录名</td>
					<td class=hcicontent colspan="3"><input type="text" name="loginName"  readonly  value="<c:out value="${merUser.loginName}"/>"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead" width="12%">中文名</td>
					<td class=hcicontent colspan="3"><input type="text" name="chineseName" value="<c:out value="${merUser.chineseName}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">用户类型</td>
					<td class=hcicontent colspan="3">
					    <select name="type">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${TypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" <c:if test="${merUser.type == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">联系电话</td>
					<td class=hcicontent colspan="3"><input type="text" name="telephone" value="<c:out value="${merUser.telephone}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">手机</td>
					<td class=hcicontent colspan="3"><input type="text" name="handPhone" value="<c:out value="${merUser.handPhone}"/>"  maxlength="13"></td>
				</tr>
				<tr>
					<td class="hcihead">email</td>
					<td class=hcicontent colspan="3"><input type="text" name="email" value="<c:out value="${merUser.email}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">QQ</td>
					<td class=hcicontent colspan="3"><input type="text" name="qq" value="<c:out value="${merUser.qq}"/>"  maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">MSN</td>
					<td class=hcicontent colspan="3"><input type="text" name="msn" value="<c:out value="${merUser.msn}"/>"   maxlength="20"></td>
				</tr>
				<tr>
					<td class="hcihead">用户状态</td>
					<td class=hcicontent colspan="3">
					    <select name="status">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${StatusList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" <c:if test="${merUser.status == rs.value}">selected</c:if>  ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">角色列表：</td>
					<td colspan="3">
								<c:set var="role"  value=",${merUser.role}," scope="page"/>
								<c:forEach var="rs" items="${merRoleList}" varStatus="vStatus">
										<c:set var="rsId"  value=",${rs.id}," scope="page"/>
										<input type="checkbox" name="role" value="<c:out value="${rs.id}"/>" <c:if test="${fn:contains(role, rsId)}">checked</c:if>><c:out value="${rs.roleName}"/>
										<c:if test="${(vStatus.index+1)%3==0}"><br></c:if>
								</c:forEach>
					<td>
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