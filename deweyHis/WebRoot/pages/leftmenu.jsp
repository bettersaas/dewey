<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="menu" value="${menu}" scope="page"/>
<c:set var="quickMenu" value="${quickMenu}" scope="page"/>
<HTML>
<HEAD>
<%
	String path         = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html;charset=GBK" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<link rel="stylesheet" rev="stylesheet" href="<c:url value="/styles/leftmenu.css"/>" media="screen" type="text/css" />
<script src="<c:url value="/scripts/application.js"/>" type="text/javascript"></script>
<script src="<c:url value="/scripts/jquery/jquery-1.6.1.min.js"/>"  type="text/javascript"></script>
<script language="javascript" type="text/javascript">
// <a onmouseover="javascript:onMenuOverOut('ss');" onmouseout="javascript:onMenuOverOut('ss');" />
function onMenuOverOut(prm) {
	window.status=prm;
	return true;
}
function goto1(url){
	document.menuForm.action=url;
	document.menuForm.target="mainFrame";
	document.menuForm.submit();
}
/** 快捷方式的连接 **/
function quickmenuToggle(obj){
	var i;
	var smsum;
	var elementID=obj.id;
	var obj2 = document.getElementById("subquickmenutitle").getElementsByTagName("li");
	for (var i=0; i<obj2.length; i++) {
		 obj2[i].getElementsByTagName("a")[0].className="quickmenu";
	}
	var obj1 = document.getElementById("nav").getElementsByTagName("li");
	for (var i=0; i<obj1.length; i++) {
		obj1[i].getElementsByTagName("a")[0].className="nomal";
	}
	obj.getElementsByTagName("a")[0].className="chang";
}
/** 一般方式的连接 **/
function menuToggle(obj){
	var i;
	var smsum;
	var elementID=obj.id;
	var obj1 = document.getElementById("nav").getElementsByTagName("li");
	for (var i=0; i<obj1.length; i++) {
		obj1[i].getElementsByTagName("a")[0].className="nomal";
	}
	var obj2 = document.getElementById("subquickmenutitle").getElementsByTagName("li");
	for (var i=0; i<obj2.length; i++) {
		obj2[i].getElementsByTagName("a")[0].className="quickmenu";
	}
	obj.getElementsByTagName("a")[0].className="ag";
}
/** 展开子菜单 **/
var LastLeftID = "";  /***新的MENU***/
function DoMenu1(emid) {
	// emid为要展开的ul的id
	var obj = document.getElementById(emid);
	if (obj.className.toLowerCase() == "expanded") { // 是展开的则关闭
		obj.className = "collapsed";
	} else {	// 是关闭的则展开
		obj.className = "expanded";
	}
	// 关闭上一个Menu
	if((LastLeftID!="")&&(emid!=LastLeftID)) {
		document.getElementById(LastLeftID).className = "collapsed"; // 关闭
	}
	LastLeftID = emid;
}
var count=0;					//做计数器
var limit=new Array();	//用于记录当前显示的哪几个菜单
var countlimit=2;			//同时打开菜单数目，可自定义
function doMenu(emid) {
	var obj = document.getElementById(emid);
	if (obj.className.toLowerCase() == "expanded") { // 是展开的则关闭
		obj.className = "collapsed";
		var j;
		for (i=0;i<limit.length;i++) {
			//获取当前点击的菜单在limit数组中的位置
			if(limit[i]==emid) {
				j=i;
				// j以后的数组全部往前挪一位
				for (i=j;i<limit.length-1;i++) {
					limit[i]=limit[i+1];
				}
				limit[limit.length-1]=null;//删除数组最后一位
				count--;
				break;
			}
		}
	} else {	// 是关闭的则展开
		obj.className = "expanded";
		// 少于限制的个数时
		if (count<countlimit) {
			limit[count]=emid;	//录入数组
			count++;
		} else { // 已达到限制个数时
			document.getElementById(limit[0]).className = "collapsed"; // 关闭最先的那个
			for (i=0;i<limit.length-1;i++) {  // 后面的往前挪一位
				limit[i]=limit[i+1];
			}
			limit[limit.length-1]=emid; // 数组去掉头一位
		}
	}
}
</script>
</HEAD>
<BODY style="SCROLLBAR-FACE-COLOR: #C1D3FB;  SCROLLBAR-HIGHLIGHT-COLOR: #C1D3FB; SCROLLBAR-SHADOW-COLOR: #ffffff; SCROLLBAR-3DLIGHT-COLOR:#C1D3FB; SCROLLBAR-ARROW-COLOR: #4D6185; SCROLLBAR-TRACK-COLOR: #F5F5F5; SCROLLBAR-DARKSHADOW-COLOR: #C1D3FB;">
<DIV id=proc name="proc">
	<TABLE class=tableframe cellPadding=10 width="100%" align=center height=40>
		<TBODY>
			<TR class=listtitle align=middle>
				<TD class=listcelltitle vAlign=center>装载菜单... </TD>
			</TR>
		</TBODY>
	</TABLE>
	<BR>
</DIV>
<form name="menuForm" action="/per/main">
	<input  type="hidden" name="transName"/>
</form>
<TABLE WIDTH="100%" HEIGHT="100%" BORDER="0" cellpadding="0" cellspacing="0" ALT="">
	<c:if test="${not empty quickMenu}">
	<TR>
		<TD valign="top">
			<div id="menu">
				<div id="quickmenu">
					<div class="menutitle"><IMG SRC="./images/menu_title01.jpg" WIDTH="180" HEIGHT="30" BORDER="0" ALT=""></div>
					<ul id="subquickmenutitle" class="triangle_mark">
						<c:forEach var="rs" items="${quickMenu}" varStatus="vStatus">
							<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('<c:url value="${rs.url}"/>');" ><c:out value="${rs.text}"/></a></li>
						</c:forEach>
					</ul>
					<div><IMG SRC="./images/menu_bottom01.jpg" WIDTH="180" HEIGHT="12" BORDER="0" ALT=""></div> 
				</div>
				<div id="totalmenu">
					<div class="menutitle"><IMG SRC="./images/menu_title02.jpg" WIDTH="180" HEIGHT="27" BORDER="0" ALT=""></div>
					<ul id="nav">
					</ul>
				</div>
			</div>
		</TD>
	</TR>
	</c:if>
	<c:if test="${not empty menu}">
	<TR height="30px" >
		<TD valign="bottom">
			<div style="margin-bottom=5px;">
				<a href="<c:url value="/logout"/>" target="_parent"  onclick="hint();"><img src="images/menu_title03.jpg" title="安全退出系统" width="180" height="27" border="0"></a>
			</div>
		</TD>
	</TR>
	</c:if>
</TABLE>
<SCRIPT language=javascript>
	document.onselectstart = CancelSelect;
	function CancelSelect() {
		event.cancelBubble = true;
		return false;
	}
	
	/*
	 * 系统使用的
	*/
	var jsonSysLoader =function(json,li){
		if(!json ||li==undefined){
			alert('json error!');
			return;
		}
		if (json.length) {
			for(var i = 0; i < json.length; i++) {
				li=jsonSysLoader(json[i],li);
			}
		}
		// 如果有有id属性，即节点
		if (json.id) {
			var href = json.url;
			if (href != undefined && href.length>0) {
				href = ' href="javascript:goto1(\'${pageContext.request.contextPath}' + href + '\')"';
			} else {
				href = ' href="javascript:void(0)" ';
			}
			var aOnclickStr="";
			var liOnclickStr="";
			// 有孩子分支需要有链接单击
			if (json.children != undefined && json.children.length>0)
			{
				aOnclickStr = ' onclick="doMenu(\'' + json.id + '\');" ';
			} else {
				liOnclickStr = ' onclick="menuToggle(this);" ';
			}
			li+='<li ' + liOnclickStr + '><a ' + aOnclickStr + href + '>'+json.text+'</a>';
		}
		// 有孩子分支
		if (json.children != undefined && json.children.length>0)
		{
			li+='<ul id="' + json.id + '" class="collapsed" >';
			var children1 = json.children;
			for(var i = 0; i < children1.length; i++) {
				li=jsonSysLoader(children1[i],li);
			}
			li+='</ul>';
		}
		// 如果有有id属性，即节点
		if (json.id) {
			li+='</li>';
		}
		return li;
	}
	
	/**********************************
	*     装载功能菜单          *
	**********************************/
	var json = <c:out value="${menu}" escapeXml="false"/>;
	if (json.id) {
			if (json.id == "FM") {
				var li="";
				var root = jsonSysLoader(json.children,li);
				$('#nav').html(root);
				document.getElementById("proc").style.display = "none";
			}
	}
</SCRIPT>
</BODY>
</HTML>