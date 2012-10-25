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
* ���������������䴲λ��Ϣ������
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
		alert("������ֻ����1-8֮�䡣");
		return;
	}
	var itemDiv = "";
	for(i=0;i<itemCnt;i++) {
		itemDiv = itemDiv 
			+  '<tr id="item_' + i + '"><td>'
			+  '<input type="hidden" name="roomBeds[' + i + '].hourFlag"  value="1">'
			+  '<DIV class="roomItemStyle">'
			+  '���ţ�&nbsp;&nbsp;<input type="text" name="roomBeds[' + i + '].bedNo"  size="7"  maxlength="5">&nbsp;&nbsp;'
			+ 'ȫ�շ���<input type="text" name="roomBeds[' + i + '].alldayPrice" size="7"  maxlength="5">'
			+  '���췿��<input type="text" name="roomBeds[' + i + '].halfdayPrice" size="7"  maxlength="5"><br>'
			+  '�Ƿ��ӵ㷿<input checked type=checkbox name=hourFlagSet' + i + '  onclick="hourFlagSetFunc(' + i + ');">'
			+  '�۸�<input type="text" name="roomBeds[' + i + '].hourMeasure"size="7"  maxlength="5">'
			+  'Сʱ<input type="text" name="roomBeds[' + i + '].hourPrice" size="7"  maxlength="5">Ԫ'
			+  '</DIV>'
			+ '</td></tr>';
	}
	$("#itemsDiv").html("<TABLE>" + itemDiv +"</TABLE>");
}
/**
* �Ƿ��ӵ㷿����Ϣ�����䶯
**/
function hourFlagSetFunc(itemIndex)
{
	var hourFlagSet =    itemIndex==-1?form1.hourFlagSet : document.getElementById("hourFlagSet"+itemIndex);
	var hourFlag =          itemIndex==-1?form1.hourFlag : document.getElementById("roomBeds[" + itemIndex + "].hourFlag");
	var hourMeasure =  itemIndex==-1?form1.hourMeasure : document.getElementById("roomBeds[" + itemIndex + "].hourMeasure");
	var hourPrice =        itemIndex==-1?form1.hourPrice : document.getElementById("roomBeds[" + itemIndex + "].hourPrice");
	// ���ӵ㷿
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
* ѡ���ͺ��Զ���ȡ������Ϣ
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
// ���÷���ļ۸���Ϣ
function  setRoomRP()
{
	if(form1.roomTypeInfos.value!="") {
		document.getElementById("alldayPrice").value = document.getElementById("roomTypeAlldayPrice").value;
		document.getElementById("halfdayPrice").value = document.getElementById("roomTypeHalfdayPrice").value;
	}
}
// ���÷��䴲λ�ļ۸���Ϣ
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

// form�ύ
function formSubmit()
{
	if(isEmpty(form1.roomNo))    {
		window.alert("�����뷿��!") ;
		form1.roomNo.focus(); 
		return;
	}
	if(isEmpty(form1.roomTypeInfos))    {
		window.alert("��ѡ����!") ;
		return;
	}
	if(! (getRadioValue("hireFlag")[0]) ) {
		alert("��ѡ��ͷ��������ͣ��ǰ����仹�ǰ���λ���⡣!") ;
		return;
	}
	if(isEmpty(form1.alldayPrice)) {
		alert("������ȫ�շ���");
		return;
	}
	if(!isMoney(form1.alldayPrice)) {
		return;
	}
	if(isEmpty(form1.halfdayPrice)) {
		alert("��������췿��");
		return;
	}
	if(!isMoney(form1.halfdayPrice)) {
		return;
	}
	if(form1.hourFlagSet.checked) {
		if(isEmpty(form1.hourMeasure) || !isInt(form1.hourMeasure)) {
			alert("������ǿյ��������ӵ㷿Сʱ��Ϣ��");
			form1.hourMeasure.select();
			return;
		}
		if(isEmpty(form1.hourPrice) || !isMoney(form1.hourPrice)) {
			alert("������ǿյĻ������ӵ㷿�۸���Ϣ��");
			form1.hourPrice.select();
			return;
		}
	}
	
	if(!isEmpty(form1.currBed)) {
		var itemCnt = parseInt($('#currBed').val());
		if(isNaN(itemCnt)) {
			alert("��λ������������");
			form1.currBed.select();
			return;
		}
		if(itemCnt>8 || itemCnt <1) {
			alert("������ֻ����1-8֮�䡣");
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
				alert("�����봲��");
				bedNo.select();
				return;
			}
			if(isEmpty(alldayPriceBed)) {
				alert("������ȫ�շ���");
				alldayPriceBed.select();
				return;
			}
			if(!isMoney(alldayPriceBed)) {
				alldayPriceBed.select();
				return;
			}
			if(isEmpty(halfdayPriceBed)) {
				alert("��������췿��");
				halfdayPriceBed.select();
				return;
			}
			if(!isMoney(halfdayPriceBed)) {
				halfdayPriceBed.select();
				return;
			}
			if(hourFlagSetBed.checked) {
				if(isEmpty(hourMeasureBed) || !isInt(hourMeasureBed)) {
					alert("������ǿյ��������ӵ㷿Сʱ��Ϣ��");
					hourMeasureBed.select();
					return;
				}
				if(isEmpty(hourPriceBed) || !isMoney(hourPriceBed)) {
					alert("������ǿյĻ������ӵ㷿�۸���Ϣ��");
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
		      <TD>�������ͷ���</TD>
		    </TR>
			<tr>
					<td>
					���ţ�&nbsp;&nbsp;<input type="text" name="roomNo">&nbsp;&nbsp;
					���ͣ�&nbsp;&nbsp;
				    <select name="roomTypeInfos" onchange="setRoomTypeInfo(this.options[this.options.selectedIndex].value)">
				    	<option value="">--��ѡ��--</option>
				    	<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
				    		<option value="<c:out value="${rs.id}-${rs.alldayPrice}-${rs.halfdayPrice}-${rs.hourMeasure}-${rs.hourPrice}"/>"  <c:if test="${param['roomType.id'] == rs.id}">selected</c:if>  ><c:out value="${rs.name}"/></option>
				    	</c:forEach>
				    </select>
					</td>
				</tr>
				<tr>
					<td>
					����¥�㣺&nbsp;<input type="text" name="floor"        size="5" maxlength="10">&nbsp;&nbsp;
					����¥����&nbsp;<input type="text" name="building"  size="10" maxlength="12">&nbsp;&nbsp;
					�绰�ֻ���&nbsp;<input type="text" name="telExtension"     size="15" maxlength="20">&nbsp;&nbsp;
					�绰���ߣ�&nbsp;<input type="text" name="telExteriorLine" size="15" maxlength="20">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>
					�ſ���&nbsp;&nbsp;<input type="text" name="doorCard">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td><DIV>&nbsp;&nbsp;&nbsp;<input type="radio" name="hireFlag"  value="0">���������&nbsp;&nbsp;<input type="radio" name="hireFlag"  value="1">���㰴��λ����&nbsp;&nbsp;</DIV></td>
				</tr>
				<tr>
					<td>
					<input type="hidden" name="hourFlag"  value="1">
					<DIV class="roomItemStyle">ȫ�շ���<input type="text" name="alldayPrice" size="7"  maxlength="5">���췿��<input type="text" name="halfdayPrice" size="7"  maxlength="5"><br>
								�Ƿ��ӵ㷿<input checked type=checkbox name=hourFlagSet  onclick="hourFlagSetFunc(-1);">�۸�<input type="text" name="hourMeasure"size="7"  maxlength="5">Сʱ<input type="text" name="hourPrice" size="7"  maxlength="5">Ԫ
					</DIV>
					</td>
				</tr>
				<tr>
					<td>
					��λ����&nbsp;&nbsp;<input type="text" id="currBed" name="currBed" size="7"  maxlength="5" onblur="addRoomBeds()">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td><div id="itemsDiv"></div></td>
				</tr>
				<tr>
					<td>
					����������&nbsp;<textarea  name="roomDesc"  cols="100" rows="5" ></textarea>
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