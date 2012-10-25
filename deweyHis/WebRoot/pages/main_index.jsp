<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<HTML>
<HEAD>
<TITLE>个人桌面</TITLE>
<%@ include file="/commons/meta.jsp" %>
<LINK rel=stylesheet  href="styles/putong_1t.css">
<STYLE TYPE="text/css">
<!--
td.grzmRow
{
	padding:0px 4px 0px 4px;	  
}
td.grzmList
{
	padding:0px 4px 0px 0px;	  
}
body
{
	background-color:#EBF1FA;
}
-->
</style>
<title>个人桌面</title>
</HEAD>
<BODY>
<div id="proc" name="proc">		
			<table width="300" height="40" align="center" cellpadding="10" class="tableframe">
			<tr align="center" class="listtitle"><td valign="center" class="listcelltitle">
			正在装载桌面信息，请稍候.... ...
			</td></tr>
			</table>			
</div>	
<div class="TitleBar">
我的桌面
</div>
<div align="center"> 
  <table border="0" cellpadding="0" cellspacing="0" width="98%" style="margin:0px 0px 0px 0px">
    <tr> 
      <td width="73%" height="423"> 
        <table border="0" cellpadding="0" cellspacing="0" width="100%" style="margin:0px 0px 0px 0px">
          <tr> 
            <td width="23" align="left" class="grzmList"><img src="images/list_wdgz.gif" width="16" height="16"></td>
            <td width="669" align="left"><div class="TableTitleText"><nobr>待办事宜</nobr></div></td>
            <td width="78" align="right"><nobr><a href="../lkcrm/gsjj/gongsijianjie_dlh.asp">更多...</a></nobr></td>
          </tr>
          <tr> 
            <td colspan="3"> <div align="left"> 
                <table border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px" width="100%" class="tabletoolbar">
                  <tr> 
                    <td></td>
                  </tr>
                </table>
                <table border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px" width="100%">
                  <tr> 
                    <td width="100%"  height="120" class="grzmRow"> 此处添加待办连接 </td>
                  </tr>
                </table>
              </div></td>
          </tr>
        </table>
        <table border="0" cellpadding="0" cellspacing="0" width="100%" style="margin:0px 0px 0px 0px">
          <tr> 
            <td width="22" align="left" class="grzmList"> <img src="images/list_srtx.gif" width="16" height="16"> 
            </td>
            <td width="678" align="left"> <div class="TableTitleText"><nobr>最新通知</nobr></div></td>
            <td width="70"><div align="right"><a href="../lkcrm/gsjj/gongsijianjie_dlh.asp">更多...</a></div></td>
          </tr>
          <tr> 
            <td colspan="3"> <div align="left"> 
                <table border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px" width="100%" class="tabletoolbar">
                  <tr> 
                    <td></td>
                  </tr>
                </table>
                <table border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px" width="100%">
                  <tr> 
                    <td width="100%"  height="120" class="grzmRow"> 此处添加通知连接 </td>
                  </tr>
                </table>
              </div></td>
          </tr>
        </table>
        <table border="0" cellpadding="0" cellspacing="0" width="100%" style="margin:0px 0px 0px 0px">
          <tr> 
            <td width="21" align="left" class="grzmList"> <img src="images/list_zxxx.gif" width="16" height="16"> 
            </td>
            <td align="left" width="679"> <div class="TableTitleText"><nobr>最新房态</nobr></div></td>
            <td align="right" width="70"><nobr><a href="../lkcrm/gsjj/xsdzzzlb_dlh.asp">更多...</a></nobr></td>
          </tr>
          <tr> 
            <td colspan="3"> <div align="left"> 
                <table border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px" width="100%" class="tabletoolbar">
                  <tr> 
                    <td></td>
                  </tr>
                </table>
                <table border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px" width="100%">
                  <tr> 
                    <td width="100%"  height="120" class="grzmRow"> 邮件链接</td>
                  </tr>
                </table>
              </div></td>
          </tr>
        </table></td>
      <td width="25%" valign="top"> 
        <div align="right">
          <table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0">
            <tr> 
              <td colspan="2"><img src="images/list_srtx.gif" width="16" height="16"></td>
              <td width="87%"> <div class="TableTitleText"> <nobr>天气预报</nobr> 
                </div>
                <div align="right"></div></td>
            </tr>
            <tr> 
              <td height="150" colspan="3"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px"  class="tableFrame">
                  <tr>
                    <td>&nbsp;<iframe name="weather_inc" src="http://tianqi.xixik.com/cframe/2" width="290" height="70" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe></td>
                  </tr>
                </table></td>
            </tr>
            <tr> 
              <td colspan="3"><div align="right"><a href="#">更多&gt;&gt;</a></div></td>
            </tr>
            <tr> 
              <td width="12%"><img src="images/list_cylj.gif" width="16" height="16"></td>
              <td colspan="2"><div class="TableTitleText"> <nobr>常用链接</nobr> </div></td>
            </tr>
            <tr> 
              <td height="201" colspan="3"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="margin:0px 0px 0px 0px"  class="tableFrame">
                  <tr>
                    <td>&nbsp;火车票查询</td>
                  </tr>
				   <tr>
                    <td>&nbsp;航班查询</td>
                  </tr>
				   <tr>
                    <td>&nbsp;星火旅行社</td>
                  </tr>
				   <tr>
                    <td>&nbsp;星火酒店用品网</td>
                  </tr>
                </table></td>
            </tr>
            <tr>
              <td height="18" colspan="3"><div align="right"><a href="#">更多&gt;&gt;</a></div></td>
            </tr>
          </table>
        </div></td>
    </tr>
  </table>
</div>
<script language="vbscript">
	document.getElementById("proc").style.display = "none"
</script>
</BODY>
</HTML>