<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
    <TITLE>�޸�����ҳ��</TITLE>
	<%@ include file="/commons/meta.jsp" %>
	<meta http-equiv="keywords" content="�޸�����">
	<meta http-equiv="description" content="�޸�����">
</head>
<body  oncontextmenu="event.returnValue=false">
<br>
<form name="form1" action="chgPwd" method="post" >
		<table  width="100%" >
			<tr height="25px">
				<td align="right" width="40%"  nowrap>�û�����</td>
				<td align="left"  width="*">
					<input type="text" id="loginName"  name="loginName"  value="<c:out value="${sessionScope.MER_USER.loginName}" />" readOnly  tabIndex=1/>
				</td>
			</tr>
			<tr>
				<td align="right" nowrap>ԭ�����룺</td>
				<td align="left" >
					<input type="password" name="oldPassword" id="oldPassword" maxlength="25" tabIndex=2/>
				</td>
			</tr>
			<tr>
				<td align="right"  nowrap>�����룺</td>
				<td align="left"  >
					<input type="password" name="newPassword1"  id="newPassword1" maxlength="25"  tabIndex=3/>
				</td>
			</tr>
			<tr>
				<td align="right"  nowrap>ȷ���������룺</td>
				<td align="left"  >
					<input type="password" name="newPassword2" id="newPassword2"  maxlength="25"  tabIndex=4/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" style="width:90px;" name="bt3" value="�޸�����" onClick="javascript:return chaPwd();">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" vAlign=top><div align="center"><a href="javascript:window.close()"><br>���رմ��ڡ�</a></div></td>
			</tr>
		</table>
</form>
<script language="javaScript">
    // onsubmit="javascript: return chaPwd();"
	function chaPwd()
	{
		var oldPassword = document.getElementById("oldPassword").value;
		var newPassword1 = document.getElementsByName("newPassword1")[0].value;
		var newPassword2 = form1.newPassword2.value;
		
		if(isEmpty(form1.oldPassword))       {
			window.alert("����������룡") ;
			form1.oldPassword.focus(); 
			return false;
		}
		if(isEmpty(form1.newPassword1))       {
			window.alert("�����������룡") ;
			form1.newPassword1.focus(); 
			return false;
		}
		if(isEmpty(form1.newPassword2))       {
			window.alert("�������ظ������룡") ;
			form1.newPassword2.focus(); 
			return false;
		}
		
		if(textFiledTrimIsEmpty(document.form1.oldPassword, "����������룡"))     
			return false;
		if(textFiledTrimIsEmpty(document.form1.newPassword1, "�����������룡"))     
			return false;
		if(textFiledTrimIsEmpty(document.form1.newPassword2, "�������ظ������룡"))     
			return false;

		if (newPassword1 != newPassword2) {
			alert("���������벻һ�£�");
			form1.newPassword2.select();
			return false;
		}
		
		form1.target = "";
		form1.action = "./chgPwd";
		return true;
	 }
</script>
</body>
</html>