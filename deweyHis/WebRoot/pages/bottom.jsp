<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html;charset=GBK" />
<style type="text/css">
<!--
.nav{
       width:500;
       height:12;
       align:center;
       color:#000000;
       filter:DropShadow(Color=#ffffe1, OffX=1, OffY=1, Positive=2);
       font-family: "����"; 
       font-size: 12px; 
       text-decoration: none;
       text-align:center;
}
.nav span{
	width:240px;
	height:12px;
	float:left;
}
#emailDiv{
	width:50px;
	height:12px;
	float:left
}
#sessionCountDiv{
	width:200px;
	height:12px;
	float:left
}
-->
</style>
<script language="javascript" type="text/javascript">
function sendEmail(){
	sendmail.action="mailto:";
	sendmail.submit();
}
function init(){
	document.getElementById("emailDiv").onclick=function(){
		sendEmail();
	}
}
</script>
<TITLE>�����Ƶ�����SAAS����ϵͳ</TITLE>
<BODY style="background-color:#a9c7d2;text-align:center;"  onLoad="init();">
<form name="sendmail" action="mailto:<c:out value="${applicationScope.email}" escapeXml="false"/>">
<input name="to"     title="������" type="hidden" value="<c:out value="${applicationScope.email}" escapeXml="false"/>">
<input name="subject"  title="����"   type="hidden" value="����������">
<input name="cc"     title="����"   type="hidden" value="">
<input name="bcc"    title="������" type="hidden" value="">
<input name="body"   title="����"   type="hidden" value="�������������...">
</form>
<center>
<div class="nav"><span>������Ϣ�Ƽ����޹�˾&nbsp;&copy;&nbsp;��Ȩ����&nbsp;V2011</span><div id="emailDiv">�ʼ���ϵ</div><div id="sessionCountDiv">��ǰ����������<c:out value="${sessionCounter.currentSessionCount}" /></div></div>
</center>
</BODY>
</HTML>