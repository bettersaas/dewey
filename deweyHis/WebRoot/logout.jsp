<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page session="true"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=GBK" />
		<title>�˳�ϵͳ</title>
	</head>
	<body>
		<script>
			alert('��ϲ�����˳�ϵͳ�ɹ���');
		   //  window.parent.close();
		   // window.location.href �����ҳ�������--���ҳ���㴰����ת  window.location.href"��"location.href"�Ǳ�ҳ����ת		   
		    window.top.location="index.jsp";
		    //window.top //��㴰��   top.location.href"��������ҳ����ת		    
			//window.self //��ǰ���� 
			//window.parent //��������  "parent.location.href"����һ��ҳ����ת
		    //      "menubar=no,status=no,scrollbars=no,toolbar=no,location=no"
		    // window.open("../login.jsp","_blank","scrollbars=no");
		    /********
		    	���A,B,C,D����jsp��D��C��iframe��C��B��iframe��B��A��iframe�����D��js����д 
				"window.location.href"��"location.href"��Dҳ����ת
				"parent.location.href"��Cҳ����ת
				"top.location.href"��Aҳ����ת
				���Dҳ������form�Ļ�,
				<form>: form�ύ��Dҳ����ת
				<form target="_blank">: form�ύ�󵯳���ҳ��
				<form target="_parent">: form�ύ��Cҳ����ת
				<form target="_top"> : form�ύ��Aҳ����ת
				����ҳ��ˢ�£�D ҳ��������д��
				"parent.location.reload();": Cҳ��ˢ�� ����Ȼ��Ҳ����ʹ���Ӵ��ڵ� opener ��������ø����ڵĶ���window.opener.document.location.reload(); ��
				"top.location.reload();": Aҳ��ˢ��
				
				��ʹ�ÿ��ʱ��������Կ����ҳ�����ҳ����������������ֻ�Ǽ򵥵�����location. href="",��ʹ������ҳ����ʾ���ӿ���У����³����ص���ܡ���ν���أ��ܼ򵥡�ֻҪָ���ӿ�ܵĸ������ҳ��������Ŀ��ҳ�漴�ɡ��� 
				window.top.framename.location.href = url;
				window.parent.location.href=url;
				mainframe.location.href=url;
		    ********/
		</script>
	</body>
</html>
