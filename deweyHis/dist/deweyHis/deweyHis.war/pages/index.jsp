<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html;charset=GBK" />
<TITLE>杜威酒店SAAS管理系统</TITLE>
<base target="_top">
</HEAD>
<FRAMESET frameSpacing=0 border=0 noresize frameBorder=0 rows="58,*" framespacing="0">
	 <FRAME marginHeight=0 noresize src="<c:url value="/pages/top.jsp"/>" frameBorder=NO name=top marginWidth=0  scrolling=no>
	 <FRAMESET id=menu_frame frameSpacing=0 name=menu_frame border=0 cols="200,5,*" frameBorder=0>
		 <FRAME noresize name=left src="<c:url value="/leftmenu"/>" style="border-bottom: #aeaeae 1px solid; border-left: #aeaeae 1px solid;border-top:#aeaeae 1px solid;z-index: 2;visibility: inherit;height:100%;" marginHeight=0 frameBorder=0 marginWidth=0 scrolling="yes" onchange="">
		 <FRAME noresize src="<c:url value="/pages/vertical_line.jsp"/>" frameBorder=0 >
		 <FRAMESET id=content_frame frameSpacing=0 name=content_frame border=0 rows="*,18"  frameBorder=0>
		 	<FRAME noresize id=mainFrame  name=mainFrame style="border-bottom: #aeaeae 1px solid; border-left: #aeaeae 1px solid; border-top: #aeaeae 1px solid; border-right: #aeaeae 1px solid;" src="<c:url value="/pages/main_index.jsp"/>" frameBorder=no scrolling="auto">
		 	<FRAME noresize id=bottom          name=bottom         style="border-bottom: #aeaeae 1px solid; border-left: #aeaeae 1px solid; border-right: #aeaeae 1px solid;" marginHeight=0 src="<c:url value="/pages/bottom.jsp"/>" frameBorder=no marginWidth=0 scrolling="no">
		 </FRAMESET>
	</FRAMESET>
</FRAMESET>
<NOFRAMES>
	<body>
		<p>更适合在支持<b>框架</b>的浏览器中使用。</p>
	</body>
</NOFRAMES>
</HTML>