<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="roomType" value="${roomType}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.name))    {
		window.alert("����������!") ;
		form1.name.focus(); 
		return;
	}
	
	// У���ظ���
	htmlobj=$.ajax({
		url:"<c:url value="/roomType/checkMerRoomTypeNameUnique"/>?roomTypeName=" + form1.name.value + "&randValue=" + getRandom(),
		type: "GET",
		async:false,  // ͬ������
		processData: true,
		dataType: "html",
		data: {},
		success: function(data) {},
		error:function(e){}
	});
	if (htmlobj.responseText == "false") {
		alert("�÷������ѱ�ʹ�ã��뻻��������������");
		return;
	}
	
	if(isEmpty(form1.roomTypeDesc))    {
		window.alert("����������!") ;
		form1.roomTypeDesc.focus(); 
		return;
	}
	if(isEmpty(form1.comment))    {
		window.alert("�����뱸ע!") ;
		form1.comment.focus(); 
		return;
	}
	if(isEmpty(form1.alldayPrice))    {
		window.alert("��������Ƽ�?") ;
		form1.alldayPrice.focus();
		return;
	}
	if(!isMoney(form1.alldayPrice, ""))
		return;
	
	if(!isMoney(form1.alldayPerHourPrice, ""))  
		return;
	if(!isMoney(form1.halfdayPrice, ""))
		return;
	if(!isMoney(form1.halfdayPerHourPrice, "")) 
		return;
	if(!isEmpty(form1.hourMeasure))   {
			if(!isInt(form1.hourMeasure)) {
				alert("����������!") ;
				return;
			}
	}
	if(!isMoney(form1.hourPrice, "")) 
		return;
	if(!isMoney(form1.hourPerHourPrice, ""))
		return;

	form1.action="${pageContext.request.contextPath}/roomType/create"; 
	form1.target="_self"; 
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/roomType/create"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${roomType.mer.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">���������͡�</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">����</td>
					<td class=hcicontent colspan="3"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td class="hcihead">����</td>
					<td class=hcicontent colspan="3"><input type="text" name="roomTypeDesc"></td>
				</tr>
				<tr>
					<td class="hcihead">��ע</td>
					<td class=hcicontent colspan="3"><input type="text" name="comment"></td>
				</tr>
				<tr>
					<td class="hcihead">���Ƽ�</td>
					<td class=hcicontent colspan="3"> <input type="text" name="alldayPrice"></td>
				</tr>
				<tr>
					<td class="hcihead">ȫ�շ���ʱ��</td>
					<td class=hcicontent colspan="3"><input type="text" name="alldayPerHourPrice"></td>
				</tr>
				<tr>
					<td class="hcihead">���շ��۸�</td>
					<td class=hcicontent colspan="3"><input type="text" name="halfdayPrice"></td>
				</tr>
				<tr>
					<td class="hcihead">���շ���ʱ��</td>
					<td class=hcicontent colspan="3"><input type="text" name="halfdayPerHourPrice"></td>
				</tr>
				<tr>
					<td class="hcihead">�ӵ㷿��ʼ��λ</td>
					<td class=hcicontent colspan="3"><input type="text" name="hourMeasure"></td>
				</tr>
				<tr>
					<td class="hcihead">�ӵ㷿��ʼ�۸�</td>
					<td class=hcicontent colspan="3"><input type="text" name="hourPrice"></td>
				</tr>
				<tr>
					<td class="hcihead">�ӵ㷿��ʱ��</td>
					<td class=hcicontent colspan="3"><input type="text" name="hourPerHourPrice"></td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			         <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="����" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="����" />
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>