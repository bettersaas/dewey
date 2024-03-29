<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="roomType" value="${roomType}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
var oldName = "<c:out value="${roomType.name}"/>";
function formSubmit()
{
	if(isEmpty(form1.name))    {
		window.alert("请输入名称!") ;
		form1.name.focus();
		return;
	}
	// 换了新名称检查重复
	if(trim(form1.name.value) != oldName) {
		// 校验重复性
		htmlobj=$.ajax({
			url:"<c:url value="/roomType/checkMerRoomTypeNameUnique"/>?roomTypeName=" + form1.name.value + "&randValue=" + getRandom(),
			type: "GET",
			async:false,  // 同步请求
			processData: true,
			dataType: "html",
			data: {},
			success: function(data) {},
			error:function(e){}
		});
		if (htmlobj.responseText == "false") {
			alert("该房型名已被使用，请换个房型名修改。");
			return;
		}
	}
	if(isEmpty(form1.roomTypeDesc))  {
		window.alert("请输入描述!") ;
		form1.roomTypeDesc.focus();
		return;
	}
	if(isEmpty(form1.comment))    {
		window.alert("请输入备注!") ;
		form1.comment.focus();
		return;
	}
	if(isEmpty(form1.alldayPrice))    {
		window.alert("请输入挂牌价?") ;
		form1.alldayPrice.focus();
		return;
	}
	if(!isMoney(form1.alldayPrice, "")) {
		return;
	}
	if(!isMoney(form1.alldayPerHourPrice, ""))
		return;
	if(!isMoney(form1.halfdayPrice, ""))
		return;
	if(!isMoney(form1.halfdayPerHourPrice, ""))
		return;
	if(!isEmpty(form1.hourMeasure))   {
			if(!isInt(form1.hourMeasure)) {
				alert("请输入整数!") ;
				return;
			}
	}
	if(!isMoney(form1.hourPrice, ""))
		return;
	if(!isMoney(form1.hourPerHourPrice, ""))
		return;

	//document.form1.action="${pageContext.request.contextPath}/roomType/update"; 
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/roomType/update"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${roomType.mer.id}"/>">
        <input type="hidden" name="id" value="<c:out value="${roomType.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">【修改房型】</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">名称</td>
					<td class=hcicontent colspan="3"><input type="text" name="name"  value="<c:out value="${roomType.name}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">描述</td>
					<td class=hcicontent colspan="3"><input type="text" name="roomTypeDesc"  value="<c:out value="${roomType.roomTypeDesc}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">备注</td>
					<td class=hcicontent colspan="3"><input type="text" name="comment"  value="<c:out value="${roomType.comment}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">挂牌价</td>
					<td class=hcicontent colspan="3"> <input type="text" name="alldayPrice"  value="<c:out value="${roomType.alldayPrice}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">全日房加时价</td>
					<td class=hcicontent colspan="3"><input type="text" name="alldayPerHourPrice"  value="<c:out value="${roomType.alldayPerHourPrice}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">半日房价格</td>
					<td class=hcicontent colspan="3"><input type="text" name="halfdayPrice"  value="<c:out value="${roomType.halfdayPrice}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">半日房加时价</td>
					<td class=hcicontent colspan="3"><input type="text" name="halfdayPerHourPrice"  value="<c:out value="${roomType.halfdayPerHourPrice}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">钟点房起始单位</td>
					<td class=hcicontent colspan="3"><input type="text" name="hourMeasure"  value="<c:out value="${roomType.hourMeasure}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">钟点房起始价格</td>
					<td class=hcicontent colspan="3"><input type="text" name="hourPrice"  value="<c:out value="${roomType.hourPrice}"/>"></td>
				</tr>
				<tr>
					<td class="hcihead">钟点房加时价</td>
					<td class=hcicontent colspan="3"><input type="text" name="hourPerHourPrice"  value="<c:out value="${roomType.hourPerHourPrice}"/>"></td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			         <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="保存" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="返回"/>
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>