<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="message" value="${message}" scope="page"/>
<html>
<head>
	<title>登陆</title>
	<%@ include file="/commons/meta.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<meta http-equiv="keywords" content="deweyHis,登录">
	<meta http-equiv="description" content="登录首页">
	<script language="javascript">
	<!--
			//如果浏览器不是ie4+或ns6+
			if (typeof navigator.cookieEnabled=="undefined" && !cookieEnabled){ 
				document.cookie="testcookie";
				cookieEnabled=(document.cookie=="testcookie")? true : false;
				document.cookie="";
			}
			if(cookieEnabled) {
				setCookie("test","test");
				if(getCookie("test") != "test") {
					cookieEnabled=false;
				} 
				delCookie("test");
			}
			
			// 初始化页面的显示数据
			function initUserInfo() {
				var userNotRember = getCookie("user_noremember");
				if (userNotRember == "true") {
					window.document.form1.remUser.checked = false;
					window.document.form1.loginName.autocomplete="off";
				} else {
					window.document.form1.loginName.autocomplete="on";
					window.document.form1.loginName.value= getCookie("loginName");
				}
			}
			///////////////////////////////////////////////////////////////////////////
			
			//屏蔽F1帮助
			function window.onhelp(){
				return false
			}
			
			//屏蔽键盘所有键
			function document.onkeydown(){
				event.keyCode = 0;
				event.returnvalue = false;
			}
		
			//屏蔽鼠标右键、Ctrl+n、shift+F10、F5刷新、退格键
			document.onkeydown=function(){
				var event = arguments[0]||window.event; 
				var currentKey = event.charCode||event.keyCode;
				//alert(currentKey);
				//alert("ASCII代码是："+event.keyCode);
				if ((window.event.altKey)&&
				((window.event.keyCode==37)|| //屏蔽 Alt+ 方向键 ←
				(window.event.keyCode==39))){ //屏蔽 Alt+ 方向键 →
					alert("不准你使用ALT+方向键前进或后退网页！");
					event.returnValue=false;
				}
			
				if ((event.keyCode == 8) && 
				(event.srcElement.type != "text" && 
				event.srcElement.type != "textarea" && 
				event.srcElement.type != "password") || //屏蔽退格删除键
				(event.keyCode==116)||    //屏蔽 F5 刷新键
				(event.keyCode==112)||    //屏蔽 F1 刷新键
				(event.keyCode==122)||    //屏蔽F11 最大化
				(event.ctrlKey && event.keyCode==82)){ //Ctrl + R
					event.keyCode=0;
					event.cancelBubble=true;
					event.returnValue=false;
				}
			
				if ((event.ctrlKey)&&(event.keyCode==78)) //屏蔽 Ctrl+n
					event.returnValue=false;
			
				if ((event.shiftKey)&&(event.keyCode==121)) //屏蔽 shift+F10
					event.returnValue=false;
			
				if ((event.altKey)&&(event.keyCode==115)){ //屏蔽Alt+F4
					window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");
					return false;
				}
			
				if (window.event.srcElement.tagName.toUpperCase() == "A" && window.event.shiftKey)
					window.event.returnValue = false; //屏蔽 shift 加鼠标左键新开一网页
			}
			
			//禁止右键弹出菜单,里面还有一个刷新.. 
			function document.oncontextmenu()   
			{
				event.cancelBubble = true;
				event.returnValue = false; 
				return false; 
			}
	//-->
	</SCRIPT>
	<script language="JavaScript" type="text/JavaScript"> 
	<!--
		function formSubmit()
		{
			if(isEmpty(form1.deweyNo)) {
				window.alert("请输入杜威号!") ;
				form1.deweyNo.focus();
				return false;
			}
			if(isEmpty(form1.loginName)) {
				window.alert("请填写用户名!") ;  
				form1.loginName.focus(); 
				return false;
			}
			if(isEmpty(form1.password)) {
				window.alert("请填写密码!") ;  
				form1.password.focus(); 
				return false;
			}
			if(isEmpty(form1.checkCode)) {
				window.alert("请填写验证码!") ;  
				form1.checkCode.focus(); 
				return false;
			}

			document.form1.action="${pageContext.request.contextPath}/login"; 
			document.form1.target="_self";     // _blank
			return true;
		}
		
		//  等同于document.forms[0].reset();
		function resetNameAndPassword() 
		{ 
			document.form1.loginName.value=""; 
			document.form1.password.value=""; 
			document.form1.checkCode.value=""; 
			document.form1.loginName.focus(); 
			return false; 
		} 
		
		// 卸载页面-方法是在关闭窗口之后执行 页面关闭、刷新、转向新页面 时都触发
		function window.onunload(){
		}
		
		/*验证码上刷新 */
		function chkImage(){
		     var img = document.getElementById("checkCodeImg");
		     img.src = "checkCode.gif?" + getRandom();
		}
		//-->
	</script>
	
	<style type="text/css"> 

	</style>
</head>
<body>
<input type="hidden"  id="retMsg"  name="retMsg" value="<c:out value="${message}"  escapeXml="false"/>" >
<DIV class=main2>
<DIV id=blk></DIV>
<DIV id=top2>
<DIV class=logo2><IMG src="${pageContext.request.contextPath}/images/txzlogo2.gif"></DIV>
<DIV class=txt2><A  onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('#');return false;"  href="javascript:;" target=_self>设为首页</A> | <A href="login.htm">SAAS系统</A> | <A href="#">联系我们</A> | <A  href="#">技术支持</A> | <A href="#">帮助中心</A></DIV></DIV>
<DIV class=lglf>
<DIV id=conlf2>
<DIV id=line2></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG style="MARGIN-TOP: 5px" src="${pageContext.request.contextPath}/images/pic01.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold" href="#">关于杜威</A><BR>关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威关于杜威... &raquo;</DIV></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG src="${pageContext.request.contextPath}/images/pic02.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold" href="#">加入杜威SAAS</A><BR>加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS加入杜威SAAS... &raquo;</DIV></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG src="${pageContext.request.contextPath}/images/pic03.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold"  href="#">杜威在线咨询</A><BR>杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询杜威在线咨询... &raquo;</DIV></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG src="${pageContext.request.contextPath}/images/pic04.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold" href="#">杜威saas文档下载</A><BR>杜威saas文档下载杜威saas文档下载杜威saas文档下载杜威saas文档下载杜威saas文档下载...&raquo;</DIV></DIV></DIV>
<DIV id=conrt2>
<DIV id=rt2tp></DIV>
<FORM id="form1" name="form1" action="login" method="post" onsubmit="return  formSubmit();"  target="_self">
<DIV id=rt2mid>
<DIV id=mdcion>
<DIV class=lf><IMG src="${pageContext.request.contextPath}/images/down.gif"></DIV>
<DIV class=tx>请输入登录帐号</DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>杜威号</DIV>
<DIV class=tx><INPUT id=deweyNo class=input2 type=text name=deweyNo value="<c:out value="${param.deweyNo}" />"  tabIndex=1> </DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>用户名</DIV>
<DIV class=tx><INPUT id=loginName class=input2 type=text name=loginName  tabIndex=2> </DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>密&nbsp;&nbsp;&nbsp;&nbsp;码</DIV>
<DIV class=tx><INPUT id=password class=input2 type=password name=password  tabIndex=3> </DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>验证码</DIV>
<DIV style="WIDTH: auto" class=tx><INPUT style="WIDTH: 70px; FLOAT: left" class=input2 type=text name="checkCode" minlength="4" maxlength="4"  tabIndex=4>&nbsp; </DIV>
<DIV class=yzm><img name="checkCodeImg" id= "checkCodeImg" src="checkCode.gif"  alt="验证图片" onclick="return chkImage();" width="60" height="20" border="0" align="absmiddle"></DIV></DIV>
<DIV style="MARGIN-TOP: 5px; WIDTH: 50%" id=mdcion2>
<DIV class=lf><INPUT value=checkbox CHECKED type=checkbox name=state><INPUT value=submit type=hidden name=Action> 记住我的登录状态 </DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="MARGIN-TOP: 5px; WIDTH: 50%" id=mdcion2>
<DIV class=lf><INPUT src="${pageContext.request.contextPath}/images/btnd.gif" width=88 height=30 type=image></DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="WIDTH: 50%" id=mdcion2>
<DIV style="FONT-SIZE: 12px; FONT-WEIGHT: bold" class=lf>您还没有帐号，赶紧注册吧</DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="WIDTH: 50%" id=mdcion2>
<DIV class=lf><A href="#"><IMG border=0 src="${pageContext.request.contextPath}/images/btnd2.gif"></A></DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="WIDTH: 50%" id=mdcion2>
<DIV class=lf><A href="#" target=_blank>忘记密码&gt;&gt;</A></DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV></DIV></FORM>
<DIV id=rt2btm></DIV></DIV></DIV>
<DIV style="BORDER-TOP: #dfdfdf 1px solid" id=footer>
版权所有：杜威酒店管理系统
</DIV></DIV>
</body>
<script language="javascript">
		// 装载页面
		function window.onload(){
			// 弹出提示窗口
			var retMsg = document.getElementById("retMsg").value;
			if(retMsg != ""){
				alert(retMsg);
			}
		}
</script>
</html>