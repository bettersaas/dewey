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
	font: 13px '����'��Arial, Helvetica, sans-serif;
}
body {
	margin:0;
	padding:0;
}
.bg1{
	background-color: #ffffff;
}
/****************��ݲ˵�************************/
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
// <a onmouseover="javascript:onMenuOverOut('�˻�����');" onmouseout="javascript:onMenuOverOut('�˻�����');" />
function onMenuOverOut(prm) {
	window.status=prm;
	return true;
}
function goto1(url){
	document.menuForm.action=url;
	document.menuForm.target="mainFrame";
	document.menuForm.submit();
}
/** ��ݷ�ʽ������ **/
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
/** һ�㷽ʽ������ **/
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
/** չ���Ӳ˵� **/
var LastLeftID = "";  /***�µ�MENU***/
function DoMenu1(emid) {
	// emidΪҪչ����ul��id
	var obj = document.getElementById(emid);
	if (obj.className.toLowerCase() == "expanded") { // ��չ������ر�
		obj.className = "collapsed";
	} else {	// �ǹرյ���չ��
		obj.className = "expanded";
	}
	// �ر���һ��Menu
	if((LastLeftID!="")&&(emid!=LastLeftID)) {
		document.getElementById(LastLeftID).className = "collapsed"; // �ر�
	}
	LastLeftID = emid;
}
var count=0;					//��������
var limit=new Array();	//���ڼ�¼��ǰ��ʾ���ļ����˵�
var countlimit=2;			//ͬʱ�򿪲˵���Ŀ�����Զ���
function doMenu(emid) {
	var obj = document.getElementById(emid);
	if (obj.className.toLowerCase() == "expanded") { // ��չ������ر�
		obj.className = "collapsed";
		var j;
		for (i=0;i<limit.length;i++) {
			//��ȡ��ǰ����Ĳ˵���limit�����е�λ��
			if(limit[i]==emid) {
				j=i;
				// j�Ժ������ȫ����ǰŲһλ
				for (i=j;i<limit.length-1;i++) {
					limit[i]=limit[i+1];
				}
				limit[limit.length-1]=null;//ɾ���������һλ
				count--;
				break;
			}
		}
	} else {	// �ǹرյ���չ��
		obj.className = "expanded";
		// �������Ƶĸ���ʱ
		if (count<countlimit) {
			limit[count]=emid;	//¼������
			count++;
		} else { // �Ѵﵽ���Ƹ���ʱ
			document.getElementById(limit[0]).className = "collapsed"; // �ر����ȵ��Ǹ�
			for (i=0;i<limit.length-1;i++) {  // �������ǰŲһλ
				limit[i]=limit[i+1];
			}
			limit[limit.length-1]=emid; // ����ȥ��ͷһλ
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
				<TD class=listcelltitle vAlign=center>װ�ز˵�... </TD>
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
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('<c:url value="/checkIn/new"/>');" >��ס�Ǽ�</a></li>
						<li onclick ="quickmenuToggle(this); "><a onFocus="blur();"class="quickmenu" href="javascript:goto1('<c:url value="/guestList/query"/>');" >�ÿ��б�</a></li>
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
							<a  onclick="doMenu('menu1');" href="javascript:void(0)">ǰ̨�Ӵ�*</a> 
							<ul id="menu1" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/checkIn/new"/>');" >��ס�Ǽ�*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/guestList/query"/>');" >�ÿ��б�*</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu2');" href="javascript:void(0)">ǰ̨����</a> 
							<ul id="menu2" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�ϲ��˵�</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >����˵�</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�����˷�</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu3');" href="javascript:void(0)">Ԥ������</a> 
							<ul id="menu3" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >����Ԥ��</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >Ԥ���б�</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu4');" href="javascript:void(0)">�ͷ�����</a> 
							<ul id="menu4" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >��̬չʾ</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�ͷ��б�</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu5');" href="javascript:void(0)">�ֽ����</a> 
							<ul id="menu5" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >����</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >������ʷ</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�ؿ�ƻ�</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu6');" href="javascript:void(0)">��ѯ</a> 
							<ul id="menu6" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�տ����</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�������</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�ʻ���ѯ</a></li> 
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu7');" href="javascript:void(0)">�ͻ���ϵ����*</a> 
							<ul id="menu7" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/contractualUnit/list"/>');" >Э�鵥λ����*</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu8');" href="javascript:void(0)">��������</a> 
							<ul id="menu8" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >Ӫҵ�ձ�</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >Ӫҵ����</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >Ӫҵ�±�</a></li> 
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu9');" href="javascript:void(0)">�ӿڹ���</a> 
							<ul id="menu9" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >�绰�Ʒѹ���</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >������������</a></li> 
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu10');" href="javascript:void(0)">����ά��*</a> 
							<ul id="menu10" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/roomType/list"/>');" >��������*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/hotelInfoSetting/edit"/>');" >�Ƶ���Ϣ����*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/chargeRuleSetting/edit"/>');" >�Ʒ�����*</a></li>
							</ul>
						</li>
						<li>
							<a  onclick="doMenu('menu11');" href="javascript:void(0)">ϵͳ����*</a> 
							<ul id="menu11" class="collapsed">
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merRoom/query"/>');" >����ά��*</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merServices/query"/>');" >������Ŀά��*</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merUser/list"/>');" >�û�ά��*</a></li>
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('<c:url value="/merRole/list"/>');" >��ɫά��*</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >ע����Ϣά��</a></li> 
								<li onclick ="menuToggle(this);"><a href="javascript:goto1('/per/main?');" >��־��ѯ</a></li>
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
				<a href="/per/main?transName=logout" target="_parent"  onclick="hint();"><img src="images/menu_title03.jpg" title="��ȫ�˳�ϵͳ" width="180" height="27" border="0"></a>
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