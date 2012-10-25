<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="merRoom"       value="${merRoom}"       scope="page"/>
<c:set var="roomTypeList" value="${roomTypeList}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<style>
.roomItemStyle {
width:650px;height:50px;line-height:70px;float:left;border:1px #c0c0c0 solid;background:lightblue;
}
</style>
<script language="JavaScript" type="text/JavaScript">
/**
* 按房间数新增房间床位信息的设置
**/
function addRoomBeds()
{ 
	var itemCnt = parseInt($('#currBed').val());
	if(isNaN(itemCnt)) {
		$('#currBed').val("");
		$("#itemsDiv").html("");
		return;
	}
	if(itemCnt>8 || itemCnt <1) {
		alert("房间数只能是1-8之间。");
		return;
	}
	var itemDiv = "";
	for(i=0;i<itemCnt;i++) {
		itemDiv = itemDiv 
			+  '<tr id="item_' + i + '"><td>'
			+  '<input type="hidden" name="roomBeds[' + i + '].hourFlag"  value="1">'
			+  '<DIV class="roomItemStyle">'
			+  '床号：&nbsp;&nbsp;<input type="text" name="roomBeds[' + i + '].bedNo"  size="7"  maxlength="5">&nbsp;&nbsp;'
			+ '全日房价<input type="text" name="roomBeds[' + i + '].alldayPrice" size="7"  maxlength="5">'
			+  '半天房价<input type="text" name="roomBeds[' + i + '].halfdayPrice" size="7"  maxlength="5"><br>'
			+  '是否钟点房<input checked type=checkbox name=hourFlagSet' + i + '  onclick="hourFlagSetFunc(' + i + ');">'
			+  '价格：<input type="text" name="roomBeds[' + i + '].hourMeasure"size="7"  maxlength="5">'
			+  '小时<input type="text" name="roomBeds[' + i + '].hourPrice" size="7"  maxlength="5">元'
			+  '</DIV>'
			+ '</td></tr>';
	}
	$("#itemsDiv").html("<TABLE>" + itemDiv +"</TABLE>");
}
/**
* 是否钟点房的信息关联变动
**/
function hourFlagSetFunc(itemIndex)
{
	var hourFlagSet =    itemIndex==-1?form1.hourFlagSet : document.getElementById("hourFlagSet"+itemIndex);
	var hourFlag =          itemIndex==-1?form1.hourFlag : document.getElementById("roomBeds[" + itemIndex + "].hourFlag");
	var hourMeasure =  itemIndex==-1?form1.hourMeasure : document.getElementById("roomBeds[" + itemIndex + "].hourMeasure");
	var hourPrice =        itemIndex==-1?form1.hourPrice : document.getElementById("roomBeds[" + itemIndex + "].hourPrice");
	// 是钟点房
	if(hourFlagSet.checked)
	{
			hourFlag.value='1';
			hourMeasure.disabled=false;
			hourMeasure.style.backgroundColor = "white";
			hourMeasure.value="";
			hourPrice.disabled=false;
			hourPrice.style.backgroundColor = "white";
			hourPrice.value="";
	} else { 
			hourFlag.value='0'; 
			hourMeasure.disabled=true;
			hourMeasure.style.backgroundColor = "#cccccc";
			hourMeasure.value="";
			hourPrice.disabled=true;
			hourPrice.style.backgroundColor = "#cccccc";
			hourPrice.value="";
	}
}
/**
* 选择房型后自动获取房型信息
**/
function setRoomTypeInfo(selectValue) 
{
	// document.all.sel.options[0].selected=true; 
	var a = $.trim(selectValue);
	if (a == "") {
		document.getElementById("roomType.id").value="";
		document.getElementById("roomTypeAlldayPrice").value="";
		document.getElementById("roomTypeHalfdayPrice").value="";
		document.getElementById("roomTypeHourMeasure").value="";
		document.getElementById("roomTypeHourPrice").value="";
	} else {
		var strs= new Array();
		strs=a.split("-");
		document.getElementById("roomType.id").value=strs[0];
		document.getElementById("roomTypeAlldayPrice").value=strs[1];
		document.getElementById("roomTypeHalfdayPrice").value=strs[2];
		document.getElementById("roomTypeHourMeasure").value=strs[3];
		document.getElementById("roomTypeHourPrice").value=strs[4];
	}
	setRoomRP();
	setBedRP();
}
// 设置房间的价格信息
function  setRoomRP()
{
	if(form1.roomTypeInfos.value!="") {
		document.getElementById("alldayPrice").value = document.getElementById("roomTypeAlldayPrice").value;
		document.getElementById("halfdayPrice").value = document.getElementById("roomTypeHalfdayPrice").value;
	}
}
// 设置房间床位的价格信息
function  setBedRP()
{
	if(form1.roomTypeInfos.value!="") {
		var itemCnt = parseInt($('#currBed').val());
		if(isNaN(itemCnt)) {
			$('#currBed').val("");
			$("#itemsDiv").html("");
			return;
		}
		for(i=0;i<itemCnt;i++) {
			document.getElementById("roomBeds[" + i + "].alldayPrice").value = document.getElementById("roomTypeAlldayPrice").value;
			document.getElementById("roomBeds[" + i + "].halfdayPrice").value = document.getElementById("roomTypeHalfdayPrice").value;
		}
	}
}

// form提交
function formSubmit()
{
	if(isEmpty(form1.roomNo))    {
		window.alert("请输入房号!") ;
		form1.roomNo.focus(); 
		return;
	}
	if(isEmpty(form1.roomTypeInfos))    {
		window.alert("请选择房型!") ;
		return;
	}
	if(! (getRadioValue("hireFlag")[0]) ) {
		alert("请选择客房出租类型，是按房间还是按床位出租。!") ;
		return;
	}
	if(isEmpty(form1.alldayPrice)) {
		alert("请输入全日房价");
		return;
	}
	if(!isMoney(form1.alldayPrice)) {
		return;
	}
	if(isEmpty(form1.halfdayPrice)) {
		alert("请输入半天房价");
		return;
	}
	if(!isMoney(form1.halfdayPrice)) {
		return;
	}
	if(form1.hourFlagSet.checked) {
		if(isEmpty(form1.hourMeasure) || !isInt(form1.hourMeasure)) {
			alert("请输入非空的整数型钟点房小时信息！");
			form1.hourMeasure.select();
			return;
		}
		if(isEmpty(form1.hourPrice) || !isMoney(form1.hourPrice)) {
			alert("请输入非空的货币型钟点房价格信息！");
			form1.hourPrice.select();
			return;
		}
	}
	
	if(!isEmpty(form1.currBed)) {
		var itemCnt = parseInt($('#currBed').val());
		if(isNaN(itemCnt)) {
			alert("床位数必须是数字");
			form1.currBed.select();
			return;
		}
		if(itemCnt>8 || itemCnt <1) {
			alert("房间数只能是1-8之间。");
			return;
		}
		for(i=0;i<itemCnt;i++) {
			var bedNo = document.getElementsByName('roomBeds[' + i + '].bedNo')[0];
			var alldayPriceBed = document.getElementsByName('roomBeds[' + i + '].alldayPrice')[0];
			var halfdayPriceBed = document.getElementsByName('roomBeds[' + i + '].halfdayPrice')[0];
			var hourFlagSetBed = document.getElementsByName('hourFlagSet' + i)[0];
			var hourMeasureBed = document.getElementsByName('roomBeds[' + i + '].hourMeasure')[0];
			var hourPriceBed = document.getElementsByName('roomBeds[' + i + '].hourPrice')[0];
			if(isEmpty(bedNo)) {
				alert("请输入床号");
				bedNo.select();
				return;
			}
			if(isEmpty(alldayPriceBed)) {
				alert("请输入全日房价");
				alldayPriceBed.select();
				return;
			}
			if(!isMoney(alldayPriceBed)) {
				alldayPriceBed.select();
				return;
			}
			if(isEmpty(halfdayPriceBed)) {
				alert("请输入半天房价");
				halfdayPriceBed.select();
				return;
			}
			if(!isMoney(halfdayPriceBed)) {
				halfdayPriceBed.select();
				return;
			}
			if(hourFlagSetBed.checked) {
				if(isEmpty(hourMeasureBed) || !isInt(hourMeasureBed)) {
					alert("请输入非空的整数型钟点房小时信息！");
					hourMeasureBed.select();
					return;
				}
				if(isEmpty(hourPriceBed) || !isMoney(hourPriceBed)) {
					alert("请输入非空的货币型钟点房价格信息！");
					hourPriceBed.select();
					return;
				}
			}
		}
	}
	
	form1.action="${pageContext.request.contextPath}/merRoom/create"; 
	form1.target="_self";     // _blank
	form1.submit();
}

</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merRoom/create"/>" target="_self">
        <input type="hidden" name="mer.id"            value="<c:out value="${merRoom.mer.id}"/>">
        <input type="hidden" name="state"            value="<c:out value="${merRoom.state}"/>">
        <input type="hidden" name="roomType.id" value="<c:out value="${param['roomType.id']}"/>">
        
        <input type="hidden" name="roomTypeAlldayPrice">
        <input type="hidden" name="roomTypeHalfdayPrice">
        <input type="hidden" name="roomTypeHourMeasure">
        <input type="hidden" name="roomTypeHourPrice">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY>
		    <TR class="hcititle">
		      <TD>【新增客房】</TD>
		    </TR>
			<tr>
					<td>
					房号：&nbsp;&nbsp;<input type="text" name="roomNo">&nbsp;&nbsp;
					房型：&nbsp;&nbsp;
				    <select name="roomTypeInfos" onchange="setRoomTypeInfo(this.options[this.options.selectedIndex].value)">
				    	<option value="">--请选择--</option>
				    	<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
				    		<option value="<c:out value="${rs.id}-${rs.alldayPrice}-${rs.halfdayPrice}-${rs.hourMeasure}-${rs.hourPrice}"/>"  <c:if test="${param['roomType.id'] == rs.id}">selected</c:if>  ><c:out value="${rs.name}"/></option>
				    	</c:forEach>
				    </select>
					</td>
				</tr>
				<tr>
					<td>
					所属楼层：&nbsp;<input type="text" name="floor"        size="5" maxlength="10">&nbsp;&nbsp;
					所属楼栋：&nbsp;<input type="text" name="building"  size="10" maxlength="12">&nbsp;&nbsp;
					电话分机：&nbsp;<input type="text" name="telExtension"     size="15" maxlength="20">&nbsp;&nbsp;
					电话外线：&nbsp;<input type="text" name="telExteriorLine" size="15" maxlength="20">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>
					门卡：&nbsp;&nbsp;<input type="text" name="doorCard">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td><DIV>&nbsp;&nbsp;&nbsp;<input type="radio" name="hireFlag"  value="0">按房间出租&nbsp;&nbsp;<input type="radio" name="hireFlag"  value="1">拆零按床位出租&nbsp;&nbsp;</DIV></td>
				</tr>
				<tr>
					<td>
					<input type="hidden" name="hourFlag"  value="1">
					<DIV class="roomItemStyle">全日房价<input type="text" name="alldayPrice" size="7"  maxlength="5">半天房价<input type="text" name="halfdayPrice" size="7"  maxlength="5"><br>
								是否钟点房<input checked type=checkbox name=hourFlagSet  onclick="hourFlagSetFunc(-1);">价格：<input type="text" name="hourMeasure"size="7"  maxlength="5">小时<input type="text" name="hourPrice" size="7"  maxlength="5">元
					</DIV>
					</td>
				</tr>
				<tr>
					<td>
					床位数：&nbsp;&nbsp;<input type="text" id="currBed" name="currBed" size="7"  maxlength="5" onblur="addRoomBeds()">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td><div id="itemsDiv"></div></td>
				</tr>
				<tr>
					<td>
					特征描述：&nbsp;<textarea  name="roomDesc"  cols="100" rows="5" ></textarea>
					</td>
				</tr>
			    <TR>
			      <TD class=hcihead colspan="4" style="text-align:center">
			        <a href="javascript:formSubmit();"><img src="<c:url value="/images/button/save.gif"/>" border=0></a> 
			        <a href="javascript:history.back();"><img src="<c:url value="/images/button/return.gif"/>" border=0></a> 
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>