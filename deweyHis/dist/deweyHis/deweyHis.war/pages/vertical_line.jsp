<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<html>
<head>
<style>
	body{
		margin:0px;
		padding:0px;
		width:100%;
		height:100%;
		background: #e1eaf5;
	}
</style>
<meta http-equiv="Content-Type" content="text/html;charset=GBK" />
<%
	String path         = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
</head>
<body>
<img border="0" style="cursor:hand;" onclick="adjustFrame();" src="images/menu_arrow.gif" style="width:4px;height:7px;left:expression((document.body.clientWidth-this.width)/2);top:expression((document.body.clientHeight-this.height)/2);" >
<script>
function adjustFrame(){
	if(top.document.getElementById('menu_frame').cols == "200,5,*"){
		top.document.getElementById('menu_frame').cols = "0,5,*";
	}else{
		top.document.getElementById('menu_frame').cols = "200,5,*";
	}
	setmiddle();
}
function setmiddle(){
		var broswer_height=document.body.clientHeight;	//网页工作区的高 document.body.scrollHeight
		var broswer_width=document.body.clientWidth;		//网页工作区的宽
		var picture=document.getElementsByTagName("img")[0];
		var img_width=picture.width;		//图片高
		var img_height=picture.height;	//图片宽
		position_height=(broswer_height - img_height)/2;	//图像顶边距
		position_width=(broswer_width - img_width)/2;		//图像左边距
		//若图像超过浏览器工作区域大小的判断
		if(position_height<=0)
			position_height=0;
		if(position_width<=0)
			position_width=0;
		picture.style.marginLeft=position_width;
		picture.style.marginTop=position_height;
}
window.onload=function(){
	setmiddle();
}
window.onresize=function(){
	setmiddle();
}
</script>
</body>
</html>