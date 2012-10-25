<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page session="true"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=GBK" />
		<title>退出系统</title>
	</head>
	<body>
		<script>
			alert('恭喜您，退出系统成功！');
		   //  window.parent.close();
		   // window.location.href 框架子页面的引导--框架页顶层窗口跳转  window.location.href"、"location.href"是本页面跳转		   
		    window.top.location="index.jsp";
		    //window.top //最顶层窗口   top.location.href"是最外层的页面跳转		    
			//window.self //当前窗口 
			//window.parent //父级窗口  "parent.location.href"是上一层页面跳转
		    //      "menubar=no,status=no,scrollbars=no,toolbar=no,location=no"
		    // window.open("../login.jsp","_blank","scrollbars=no");
		    /********
		    	如果A,B,C,D都是jsp，D是C的iframe，C是B的iframe，B是A的iframe，如果D中js这样写 
				"window.location.href"、"location.href"：D页面跳转
				"parent.location.href"：C页面跳转
				"top.location.href"：A页面跳转
				如果D页面中有form的话,
				<form>: form提交后D页面跳转
				<form target="_blank">: form提交后弹出新页面
				<form target="_parent">: form提交后C页面跳转
				<form target="_top"> : form提交后A页面跳转
				关于页面刷新，D 页面中这样写：
				"parent.location.reload();": C页面刷新 （当然，也可以使用子窗口的 opener 对象来获得父窗口的对象：window.opener.document.location.reload(); ）
				"top.location.reload();": A页面刷新
				
				在使用框架时，经常会对框架子页面进行页面引导的情况，如果只是简单的设置location. href="",会使得整个页面显示在子框架中，导致出现重叠框架。如何解决呢？很简单。只要指定子框架的父级框架页面链接至目标页面即可。如 
				window.top.framename.location.href = url;
				window.parent.location.href=url;
				mainframe.location.href=url;
		    ********/
		</script>
	</body>
</html>
