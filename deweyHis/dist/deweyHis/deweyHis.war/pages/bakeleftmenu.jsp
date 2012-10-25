<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="/commons/taglibs.jsp" %>
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
<!-- link rel="stylesheet" rev="stylesheet" href="<c:url value="/styles/leftmenu.css"/>" type="text/css" media="screen" / -->
<script src="<c:url value="/scripts/jquery/jquery-1.6.1.min.js"/>"  type="text/javascript"></script>
<style>
* {
	font: 13px '宋体'，Arial, Helvetica, sans-serif;
}
body {
	margin:0;
	padding:0;
}
.bg1{
	background-color: #ffffff;
}
/****************快捷菜单************************/
a#quickmenutitle{
width:180px;
padding:4px 0;
text-decoration:none;
display:block;
}
.quickmenu{
	padding-left:27px;
}
a.quickmenu {
text-decoration:none;
color:#174179;
background:inherit;
}
a.quickmenu:hover {
color:red;
background:inherit;
}
.chang{
padding-left:27px;
text-decoration:none;
color:red;
background:none;
line-height:22px;
}
ul{
margin:0;
padding:0;
}
.triangle_mark{
width:180px;
padding-left:1px;
}
.triangle_mark li{
width:177px;
line-height:22px;
background-image:url(images/menu_arrow.gif);
background-position: 15px center;
background-repeat:no-repeat;
background-color:#fff;
text-decoration:none;
color:#174179 !important;
border-left:solid 1px #9accff;
border-right:solid 1px #9accff;
border-bottom:solid 1px #CCCCCC;
display:block;
overflow:hidden;
}
#nav {
 width:180px;
 padding-top:4px;
 padding-bottom:3px;
 list-style-type: none;
 text-align:left;
 margin-top:-3px;
}
#nav a {
 padding-left:25px;
 width:180px;
 display: block;
 padding-top:4px;
 padding-bottom:3px;
}
#nav li {
background:url(images/menu01.gif) no-repeat;
width:180px;
 float:left;
}
#nav li a:hover{
padding-top:4px;
padding-bottom:3px;
background:url(images/menu01.gif) no-repeat;
float:left;
}
#nav a:link  {
 color:#000; text-decoration:none;
}
#nav a:visited  {
 color:#000; text-decoration:none;
}
#nav a:hover  {
 color:#000; text-decoration:none;
}
#nav li ul {
list-style:none;
text-align:left;
width:180px;
padding:0 0 0 1px;
}
#nav li ul li{
width:177px;
border-left:solid 1px #9accff;
border-right:solid 1px #9accff;
border-bottom:solid 1px #E0E4FE;
}
#nav li ul li a{
width:177px;
background-image:url(images/menu_arrow.gif);
background-position: 15px center;
background-repeat:no-repeat;
background-color:#ffeede;
text-decoration:none;
color:#174179 !important;
display:block;
}
#nav li ul li a:hover{
width:177px;
background-image:url(images/menu_arrow.gif);
background-position: 15px center;
background-repeat:no-repeat;
background-color:#fff;
text-decoration:none;
color:#174179;
display:block;
}
#nav li ul a.ag{
width:177px;
background-image:url(images/menu_arrow.gif);
background-position: 15px center;
background-repeat:no-repeat;
background-color:#fff;
text-decoration:none;
color:#174179;
display:block;
}
#nav li:hover ul {
 left: auto;
}
#nav li.sfhover ul {
 left: auto;
}
#nav ul.collapsed {
 display: none;
}
</style>
<script language="javascript" type="text/javascript">
// <a onmouseover="javascript:onMenuOverOut('账户管理');" onmouseout="javascript:onMenuOverOut('账户管理');" />
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
	<TR>
		<TD valign="top">
			<div id="menu">
				<div id="quickmenu">
					<div class="menutitle"><IMG SRC="./images/menu_title01.jpg" WIDTH="180" HEIGHT="30" BORDER="0" ALT=""></div>
					<ul id="subquickmenutitle" class="triangle_mark">
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('<c:url value="/checkIn/new"/>');" >入住登记</a></li>
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('<c:url value="/guestList/query"/>');" >旅客列表</a></li>
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('/per/main?');" >AAAAA</a></li>
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('/per/main?');" >AAAAA</a></li>
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('/per/main?');" >AAAAA</a></li>
					</ul> 
					<div><IMG SRC="./images/menu_bottom01.jpg" WIDTH="180" HEIGHT="12" BORDER="0" ALT=""></div> 
				</div>
				<div id="totalmenu">
					<div class="menutitle"><IMG SRC="./images/menu_title02.jpg" WIDTH="180" HEIGHT="27" BORDER="0" ALT=""></div>
					<ul id="nav">
						<li>
							<a  onclick="doMenu('menu1');" href="javascript:void(0)">前台接待*</a> 
							<ul id="menu1" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/checkIn/new"/>');" >入住登记*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/guestList/query"/>');" >旅客列表*</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu2');" href="javascript:void(0)">前台收银</a> 
							<ul id="menu2" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >合并账单</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >拆分账单</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >结账退房</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu3');" href="javascript:void(0)">预订管理</a> 
							<ul id="menu3" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >房间预订</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >预订列表</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu4');" href="javascript:void(0)">客房管理</a> 
							<ul id="menu4" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >房态展示</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >客房列表</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu5');" href="javascript:void(0)">现金管理</a> 
							<ul id="menu5" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >交班</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >交班历史</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >回款计划</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu6');" href="javascript:void(0)">查询</a> 
							<ul id="menu6" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >收款管理</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >付款管理</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >帐户查询</a></li> 
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu7');" href="javascript:void(0)">客户关系管理*</a> 
							<ul id="menu7" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/contractualUnit/list"/>');" >协议单位管理*</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu8');" href="javascript:void(0)">报表中心</a> 
							<ul id="menu8" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >营业日报</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >营业汇总</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >营业月报</a></li> 
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu9');" href="javascript:void(0)">接口管理</a> 
							<ul id="menu9" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >电话计费管理</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >电子门锁管理</a></li> 
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu10');" href="javascript:void(0)">参数维护*</a> 
							<ul id="menu10" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/roomType/list"/>');" >房型设置*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/hotelInfoSetting/edit"/>');" >酒店信息设置*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/chargeRuleSetting/edit"/>');" >计费设置*</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu11');" href="javascript:void(0)">系统管理*</a> 
							<ul id="menu11" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merRoom/query"/>');" >房间维护*</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merServices/query"/>');" >消费项目维护*</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merUser/list"/>');" >用户维护*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merRole/list"/>');" >角色维护*</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >注册信息维护</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >日志查询</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</TD>
	</TR> 
	<TR height="30px" >
		<TD valign="bottom">
			<div style="margin-bottom=5px;">
				<a href="/per/main?transName=logout" target="_parent"  onclick="hint();"><img src="images/menu_title03.jpg" title="安全退出系统" width="180" height="27" border="0"></a>
			</div>
		</TD>
	</TR>
</TABLE>
<SCRIPT language=javascript>
	document.onselectstart = CancelSelect;
	function CancelSelect()
	{
		event.cancelBubble = true;
		return false;
	}
	document.getElementById("proc").style.display = "none"
</SCRIPT>
</BODY>
</HTML>