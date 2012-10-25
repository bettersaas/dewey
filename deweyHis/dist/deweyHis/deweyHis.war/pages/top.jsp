<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<HTML><HEAD>
<%@ include file="/commons/meta.jsp" %>
<META name=VI60_defaultClientScript content=VBScript>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<script type="text/javascript">
//URL的跳转
function gotourl(url,sname,swidth,sheight,sreplace,sclose)
{
	var objNewWin;				
	if (swidth=="") swidth = "790";
	if (sheight=="") sheight = "480";
	if (sreplace=="") sreplace = false;
	if (sclose=="") sclose = false;
	objNewWin = window.open(url,sname,"fullscreen=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=" + swidth + ",height=" + sheight + ",top=200,left=200",sreplace);	
	if (sclose) window.close();
		objNewWin.focus();	
}

function popdialog(url,swidth,sheight){
	if (swidth=="") swidth = "280";
	if (sheight=="") swidth = "180";
	var sValue = showModalDialog(url,"","dialogWidth:" + swidth + ";status:no;dialogHeight:" + sheight);
	return sValue;
}
</script>
<STYLE type=text/css>
.top {
	FONT-FAMILY: "宋体"; FONT-SIZE: 9pt; VERTICAL-ALIGN: bottom; PADDING-TOP: 0px; 006600: 
}
BODY {
	LINE-HEIGHT: 150%; BACKGROUND-COLOR: #ffffff; MARGIN-TOP: 0px; FONT-FAMILY: "宋体"; COLOR: #ffffff; MARGIN-LEFT: 0px; FONT-SIZE: 9pt; MARGIN-RIGHT: 0px
}
TD {
	LINE-HEIGHT: 150%; FONT-FAMILY: 宋体; COLOR: #ffffff; FONT-SIZE: 9pt
}
TD.top {
	PADDING-BOTTOM: 0px; PADDING-LEFT: 4px; PADDING-RIGHT: 4px; PADDING-TOP: 0px
}
A:link {
	COLOR: #ffffff; TEXT-DECORATION: none
}
A:visited {
	COLOR: #ffffff; TEXT-DECORATION: none
}
A:hover {
	COLOR: #cebef7; TEXT-DECORATION: none
}
</STYLE>
<SCRIPT language=javascript type=text/javascript  src="scripts/fun_Script.js"></SCRIPT>
<SCRIPT language=JavaScript>
<!--
function Show_Hide_Menu(){
if(window.parent.oamenu_frame.cols=="0,*,0,0,0"){
document.getElementById("menuICON").src="images/top/hidemenu.gif";
document.getElementById("menuICON").alt="隐藏菜单"
window.parent.oamenu_frame.cols="120,*,0,0,0";
}
else{
document.getElementById("menuICON").src="images/top/showmenu.gif";
document.getElementById("menuICON").alt="显示菜单"
window.parent.oamenu_frame.cols="0,*,0,0,0";}
}

function MM_findObj(n, d) { //v3.0
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); return x;
}
function MM_nbGroup(event, grpName) { //v3.0
  var i,img,nbArr,args=MM_nbGroup.arguments;
  if (event == "init" && args.length > 2) {
    if ((img = MM_findObj(args[2])) != null && !img.MM_init) {
      img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;
      if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();
      nbArr[nbArr.length] = img;
      for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
        if (!img.MM_up) img.MM_up = img.src;
        img.src = img.MM_dn = args[i+1];
        nbArr[nbArr.length] = img;
    } }
  } else if (event == "over") {
    document.MM_nbOver = nbArr = new Array();
    for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = (img.MM_dn && args[i+2]) ? args[i+2] : args[i+1];
      nbArr[nbArr.length] = img;
    }
  } else if (event == "out" ) {
    for (i=0; i < document.MM_nbOver.length; i++) {
      img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }
  } else if (event == "down") {
    if ((nbArr = document[grpName]) != null)
      for (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }
    document[grpName] = nbArr = new Array();
    for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = img.MM_dn = args[i+1];
      nbArr[nbArr.length] = img;
  } }
}

function MM_preloadImages() { //v3.0
 var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
   var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
   if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

//-->
</SCRIPT>

<SCRIPT language=vbscript>
	dim msgflag
	msgflag = "old"
	function getmsgflag()
		getmsgflag = msgflag
	end function
  sub showzxrs(x)
    document.getElementById("zxrs").innertext=x
  end sub
  sub changemsgimg(x,id)
    dim s1,s2   
    s1="<a style='cursor:hand' onclick=""javascript:parent.msg.location.href='../message/main.asp';"" " _
        & " onMouseOut=""MM_nbGroup('out');""  " _
        & "onMouseOver=""MM_nbGroup('over','OAHeader_r1_c3','images/top/OAHeader_r1_c3_f2.gif','images/top/OAHeader_r1_c3_f3.gif',1);""" _
        & "  title='短消息管理'>" _
        & "<img id='OAHeader_r1_c3' name='OAHeader_r1_c3' src='images/top/OAHeader_r1_c3.gif' border='0'></a>"
    s2="<a style='cursor:hand' onclick='vbscript:doview(""" & id & """)'" _
        & " onMouseOut=""MM_nbGroup('out');""  " _
        & "onMouseOver=""MM_nbGroup('over','OAHeader_r1_c3','images/top/OAHeader_r1_c3_new.gif','images/top/OAHeader_r1_c3_new.gif',1);""" _
        & "  title='查看新消息'>" _
        & "<img id='OAHeader_r1_c3' name='OAHeader_r1_c3' src='images/top/OAHeader_r1_c3_new.gif'border='0'></a>"
    if x="new" then
			if msgflag="old" then
				'msgbox "new"
				document.getElementById("msg").innerHTML=s2
				document.getElementById("OAHeader_r1_c3").src="images/top/OAHeader_r1_c3_new.gif"
				msgflag = "new"				
      end if
    else
			if msgflag="new" then
				'msgbox "old"
				document.getElementById("msg").innerHTML=s1
				document.getElementById("OAHeader_r1_c3").src="images/top/OAHeader_r1_c3.gif"
				msgflag = "old"
      end if
    end if
    
  end sub
  function doview(id)  
		changemsgimg "old",""
		'msgbox msgflag
    openchromeless "../message/msg_view.asp?xxxh=" & id,"MessageView",360,160,(screen.availWidth-400)/2,(screen.availHeight-200)/2,"../message/title.gif","../message/btnclose_1.gif","../message/btnclose_2.gif","../message/btnclose_1.gif","../message/btnmin_2.gif","../message/btnmin_1.gif","../message/btnmin_2.gif","","","Message_View","#009c24","black","",""    
  end function
</SCRIPT>

<SCRIPT language=vbscript>
function exitsystem
	if msgbox ("您确定要退出系统吗？",vbYesNo+vbQuestion,"退出确定")=vbYes then				
		window.parent.close 
	end if
end function
</SCRIPT>

<META name=GENERATOR content="MSHTML 8.00.7600.16722"></HEAD>
<BODY  onload="MM_preloadImages('images/top/OAHeader_r1_c3_f2.gif','images/top/OAHeader_r1_c3_f3.gif','images/top/OAHeader_r1_c5_f2.gif','images/top/OAHeader_r1_c5_f3.gif','images/top/OAHeader_r1_c7_f2.gif','images/top/OAHeader_r1_c7_f3.gif','images/top/OAHeader_r1_c9_f2.gif','images/top/OAHeader_r1_c9_f3.gif','images/top/OAHeader_r1_c11_f2.gif','images/top/OAHeader_r1_c11_f3.gif');" 
bgColor=#ffffff>
<TABLE style="MARGIN: 0px" border=0 cellSpacing=0 cellPadding=0 width="100%" 
bgColor=#6386de valign="top">
  <TBODY>
  <TR vAlign=top>
    <TD vAlign=center width=350>
      <TABLE style="MARGIN: 0px" border=0 cellSpacing=0 cellPadding=0  bgColor=#6386de height="100%">
	        <TBODY>
		        <TR>
		          <TD colSpan=2><IMG border=0 src="images/top/deweylog.gif"></TD>
		         </TR>
		        <TR height=18 vAlign=top>
		          <TD width=18><IMG style="CURSOR: hand" id=menuICON  onclick=javascript:Show_Hide_Menu(); alt=隐藏菜单 src="images/top/hidemenu.gif"></TD>
		          <TD class=top width="95%">
		          	<NOBR>| 当前用户：<A title=点击可修改密码 href="javascript:gotourl('chgPwd.jsp','','380px','190px','',false);"><c:out value="${sessionScope.MER_USER.chineseName} " /></A></NOBR>
		          </TD>
		          </TR>
	          </TBODY>
          </TABLE>
    </TD>
    <TD width="100%">
      <TABLE style="MARGIN: 0px" border=0 cellSpacing=0 cellPadding=0 bgColor=#6386de height="100%">
        <TBODY></TBODY></TABLE></TD>
    <TD width=300 align=right>
      <TABLE style="MARGIN: 0px" border=0 cellSpacing=0 cellPadding=0 bgColor=#6386de height="100%">
        <TBODY>
        <TR height=20 vAlign=bottom>
          <TD width=18><IMG border=0 src="images/top/top_toolbar.gif"></TD>
          <TD class=top bgColor=#000000><NOBR>酒店名称-假日酒店 | 当前日期-2005年04月25日&nbsp;&nbsp; </NOBR></TD></TR>
        <TR height=38>
          <TD></TD>
          <TD vAlign=center align=right><A onmouseover="MM_nbGroup('over','OAHeader_r1_c0','images/top/OAHeader_r1_c0_f2.gif','images/top/OAHeader_r1_c0_f3.gif',1);" 
            title=我的桌面 onmouseout="MM_nbGroup('out');"   href="http://lkoa4.lkpower.com/dlh/lkoa_grzm_index.asp"  target=middle><IMG border=0 name=OAHeader_r1_c0 
            src="images/top/OAHeader_r1_c0.gif"></A> &nbsp; <SPAN id=msg  name="msg">
            <A style="CURSOR: hand" onmouseover="MM_nbGroup('over','OAHeader_r1_c3','images/top/OAHeader_r1_c3_f2.gif','images/top/OAHeader_r1_c3_f3.gif',1);" 
            title=消息管理 onmouseout="MM_nbGroup('out');" 
            onclick="javascript:parent.msg.location.href='../message/main.asp';"><IMG 
            id=OAHeader_r1_c3 border=0 name=OAHeader_r1_c3 
            src="images/top/OAHeader_r1_c3.gif"></A></SPAN> &nbsp; <A 
            onmouseover="MM_nbGroup('over','OAHeader_r1_c5','images/top/OAHeader_r1_c5_f2.gif','images/top/OAHeader_r1_c5_f3.gif',1);" 
            title=刷新页面 onmouseout="MM_nbGroup('out');" 
            href="vbscript:parent.mainFrame.location.reload"><IMG border=0 
            name=OAHeader_r1_c5 src="images/top/OAHeader_r1_c5.gif"></A> &nbsp; 
            <A onmouseover="MM_nbGroup('over','OAHeader_r1_c7','images/top/OAHeader_r1_c7_f2.gif','images/top/OAHeader_r1_c7_f3.gif',1);" 
            title=后退 onmouseout="MM_nbGroup('out');" 
            href="vbscript:history.back"><IMG border=0 name=OAHeader_r1_c7 
            src="images/top/OAHeader_r1_c7.gif"></A> &nbsp; <A 
            onmouseover="MM_nbGroup('over','OAHeader_r1_c9','images/top/OAHeader_r1_c9_f2.gif','images/top/OAHeader_r1_c9_f3.gif',1);" 
            title=前进 onmouseout="MM_nbGroup('out');" 
            href="vbscript:history.forward"><IMG border=0 name=OAHeader_r1_c9 
            src="images/top/OAHeader_r1_c9.gif">
            </A> &nbsp; <A onmouseover="MM_nbGroup('over','OAHeader_r1_c11','images/top/OAHeader_r1_c11_f2.gif','images/top/OAHeader_r1_c11_f3.gif',1);" 
            title=退出系统 onmouseout="MM_nbGroup('out');" 
            href="vbscript:exitsystem()"><IMG border=0 name=OAHeader_r1_c11 
            src="images/top/OAHeader_r1_c11.gif"></A> &nbsp; 
    </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></BODY></HTML>
