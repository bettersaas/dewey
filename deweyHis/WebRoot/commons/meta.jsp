<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path         = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath", basePath);
	// document.form1.action="${pageContext.request.contextPath}/"; 
%>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=GBK" />
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.ico" type="image/x-icon">
	<link  rel="stylesheet"  type="text/css"  href="<c:url value="/styles/txz.css"/>">
	<script src="<c:url value="/scripts/application.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/scripts/jquery/jquery-1.6.1.min.js"/>"  type="text/javascript"></script>