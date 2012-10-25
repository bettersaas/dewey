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
       font-family: "宋体"; 
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
<TITLE>杜威酒店在线SAAS管理系统</TITLE>
<BODY style="background-color:#a9c7d2;text-align:center;"  onLoad="init();">
<form name="sendmail" action="mailto:<c:out value="${applicationScope.email}" escapeXml="false"/>">
<input name="to"     title="收信人" type="hidden" value="<c:out value="${applicationScope.email}" escapeXml="false"/>">
<input name="subject"  title="主题"   type="hidden" value="尊驾意见主题">
<input name="cc"     title="抄送"   type="hidden" value="">
<input name="bcc"    title="暗抄送" type="hidden" value="">
<input name="body"   title="内容"   type="hidden" value="请输入您的意见...">
</form>
<center>
<div class="nav"><span>杜威信息科技有限公司&nbsp;&copy;&nbsp;版权所有&nbsp;V2011</span><div id="emailDiv">邮件联系</div><div id="sessionCountDiv">当前访问人数：<c:out value="${sessionCounter.currentSessionCount}" /></div></div>
</center>
</BODY>
</HTML>