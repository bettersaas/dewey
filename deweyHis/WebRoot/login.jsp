<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="message" value="${message}" scope="page"/>
<html>
<head>
	<title>��½</title>
	<%@ include file="/commons/meta.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<meta http-equiv="keywords" content="deweyHis,��¼">
	<meta http-equiv="description" content="��¼��ҳ">
	<script language="javascript">
	<!--
			//������������ie4+��ns6+
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
			
			// ��ʼ��ҳ�����ʾ����
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
			
			//����F1����
			function window.onhelp(){
				return false
			}
			
			//���μ������м�
			function document.onkeydown(){
				event.keyCode = 0;
				event.returnvalue = false;
			}
		
			//��������Ҽ���Ctrl+n��shift+F10��F5ˢ�¡��˸��
			document.onkeydown=function(){
				var event = arguments[0]||window.event; 
				var currentKey = event.charCode||event.keyCode;
				//alert(currentKey);
				//alert("ASCII�����ǣ�"+event.keyCode);
				if ((window.event.altKey)&&
				((window.event.keyCode==37)|| //���� Alt+ ����� ��
				(window.event.keyCode==39))){ //���� Alt+ ����� ��
					alert("��׼��ʹ��ALT+�����ǰ���������ҳ��");
					event.returnValue=false;
				}
			
				if ((event.keyCode == 8) && 
				(event.srcElement.type != "text" && 
				event.srcElement.type != "textarea" && 
				event.srcElement.type != "password") || //�����˸�ɾ����
				(event.keyCode==116)||    //���� F5 ˢ�¼�
				(event.keyCode==112)||    //���� F1 ˢ�¼�
				(event.keyCode==122)||    //����F11 ���
				(event.ctrlKey && event.keyCode==82)){ //Ctrl + R
					event.keyCode=0;
					event.cancelBubble=true;
					event.returnValue=false;
				}
			
				if ((event.ctrlKey)&&(event.keyCode==78)) //���� Ctrl+n
					event.returnValue=false;
			
				if ((event.shiftKey)&&(event.keyCode==121)) //���� shift+F10
					event.returnValue=false;
			
				if ((event.altKey)&&(event.keyCode==115)){ //����Alt+F4
					window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");
					return false;
				}
			
				if (window.event.srcElement.tagName.toUpperCase() == "A" && window.event.shiftKey)
					window.event.returnValue = false; //���� shift ���������¿�һ��ҳ
			}
			
			//��ֹ�Ҽ������˵�,���滹��һ��ˢ��.. 
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
				window.alert("�����������!") ;
				form1.deweyNo.focus();
				return false;
			}
			if(isEmpty(form1.loginName)) {
				window.alert("����д�û���!") ;  
				form1.loginName.focus(); 
				return false;
			}
			if(isEmpty(form1.password)) {
				window.alert("����д����!") ;  
				form1.password.focus(); 
				return false;
			}
			if(isEmpty(form1.checkCode)) {
				window.alert("����д��֤��!") ;  
				form1.checkCode.focus(); 
				return false;
			}

			document.form1.action="${pageContext.request.contextPath}/login"; 
			document.form1.target="_self";     // _blank
			return true;
		}
		
		//  ��ͬ��document.forms[0].reset();
		function resetNameAndPassword() 
		{ 
			document.form1.loginName.value=""; 
			document.form1.password.value=""; 
			document.form1.checkCode.value=""; 
			document.form1.loginName.focus(); 
			return false; 
		} 
		
		// ж��ҳ��-�������ڹرմ���֮��ִ�� ҳ��رա�ˢ�¡�ת����ҳ�� ʱ������
		function window.onunload(){
		}
		
		/*��֤����ˢ�� */
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
<DIV class=txt2><A  onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('#');return false;"  href="javascript:;" target=_self>��Ϊ��ҳ</A> | <A href="login.htm">SAASϵͳ</A> | <A href="#">��ϵ����</A> | <A  href="#">����֧��</A> | <A href="#">��������</A></DIV></DIV>
<DIV class=lglf>
<DIV id=conlf2>
<DIV id=line2></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG style="MARGIN-TOP: 5px" src="${pageContext.request.contextPath}/images/pic01.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold" href="#">���ڶ���</A><BR>���ڶ������ڶ������ڶ������ڶ������ڶ������ڶ������ڶ������ڶ������ڶ������ڶ������ڶ���... &raquo;</DIV></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG src="${pageContext.request.contextPath}/images/pic02.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold" href="#">�������SAAS</A><BR>�������SAAS�������SAAS�������SAAS�������SAAS�������SAAS�������SAAS�������SAAS... &raquo;</DIV></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG src="${pageContext.request.contextPath}/images/pic03.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold"  href="#">����������ѯ</A><BR>����������ѯ����������ѯ����������ѯ����������ѯ����������ѯ����������ѯ����������ѯ����������ѯ����������ѯ... &raquo;</DIV></DIV>
<DIV id=box22>
<DIV class=boxpic2><IMG src="${pageContext.request.contextPath}/images/pic04.gif"></DIV>
<DIV class=boxtxt2><A style="COLOR: #000000; FONT-SIZE: 14px; FONT-WEIGHT: bold" href="#">����saas�ĵ�����</A><BR>����saas�ĵ����ض���saas�ĵ����ض���saas�ĵ����ض���saas�ĵ����ض���saas�ĵ�����...&raquo;</DIV></DIV></DIV>
<DIV id=conrt2>
<DIV id=rt2tp></DIV>
<FORM id="form1" name="form1" action="login" method="post" onsubmit="return  formSubmit();"  target="_self">
<DIV id=rt2mid>
<DIV id=mdcion>
<DIV class=lf><IMG src="${pageContext.request.contextPath}/images/down.gif"></DIV>
<DIV class=tx>�������¼�ʺ�</DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>������</DIV>
<DIV class=tx><INPUT id=deweyNo class=input2 type=text name=deweyNo value="<c:out value="${param.deweyNo}" />"  tabIndex=1> </DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>�û���</DIV>
<DIV class=tx><INPUT id=loginName class=input2 type=text name=loginName  tabIndex=2> </DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>��&nbsp;&nbsp;&nbsp;&nbsp;��</DIV>
<DIV class=tx><INPUT id=password class=input2 type=password name=password  tabIndex=3> </DIV></DIV>
<DIV id=mdcion2>
<DIV class=lf>��֤��</DIV>
<DIV style="WIDTH: auto" class=tx><INPUT style="WIDTH: 70px; FLOAT: left" class=input2 type=text name="checkCode" minlength="4" maxlength="4"  tabIndex=4>&nbsp; </DIV>
<DIV class=yzm><img name="checkCodeImg" id= "checkCodeImg" src="checkCode.gif"  alt="��֤ͼƬ" onclick="return chkImage();" width="60" height="20" border="0" align="absmiddle"></DIV></DIV>
<DIV style="MARGIN-TOP: 5px; WIDTH: 50%" id=mdcion2>
<DIV class=lf><INPUT value=checkbox CHECKED type=checkbox name=state><INPUT value=submit type=hidden name=Action> ��ס�ҵĵ�¼״̬ </DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="MARGIN-TOP: 5px; WIDTH: 50%" id=mdcion2>
<DIV class=lf><INPUT src="${pageContext.request.contextPath}/images/btnd.gif" width=88 height=30 type=image></DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="WIDTH: 50%" id=mdcion2>
<DIV style="FONT-SIZE: 12px; FONT-WEIGHT: bold" class=lf>����û���ʺţ��Ͻ�ע���</DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="WIDTH: 50%" id=mdcion2>
<DIV class=lf><A href="#"><IMG border=0 src="${pageContext.request.contextPath}/images/btnd2.gif"></A></DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV>
<DIV style="WIDTH: 50%" id=mdcion2>
<DIV class=lf><A href="#" target=_blank>��������&gt;&gt;</A></DIV>
<DIV style="WIDTH: auto" class=tx></DIV>
<DIV class=yzm></DIV></DIV></DIV></FORM>
<DIV id=rt2btm></DIV></DIV></DIV>
<DIV style="BORDER-TOP: #dfdfdf 1px solid" id=footer>
��Ȩ���У������Ƶ����ϵͳ
</DIV></DIV>
</body>
<script language="javascript">
		// װ��ҳ��
		function window.onload(){
			// ������ʾ����
			var retMsg = document.getElementById("retMsg").value;
			if(retMsg != ""){
				alert(retMsg);
			}
		}
</script>
</html>