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
.roomItemDeleteStyle {
	width:100px;height:50px;line-height:70px;float:left;
}
</style>
<script language="JavaScript" type="text/JavaScript">
// ɾ����λ��Ϣ
function deleteItem(itemIndex)
{
	$('#item_' + itemIndex).hide();
	$('#deletedIndexes').append("<input type='hidden' name='deletedIndexes' value='" + itemIndex + "'");
	var currBedCnt = parseInt($('#currBed').val());
	if(!isNaN(currBedCnt)) {
		$('#currBed').val(currBedCnt - 1);
		if($('#currBed').val() == '0') {
			$('#currBed').val('');
		}
	}
}
function addItem(){
	var itemCnt = parseInt($('#itemCnt').val());
	var newItem = '<tr id="item_' +itemCnt + '">'
			+  '<input type="hidden" name="roomBeds[' +itemCnt + '].hourFlag"  value="1">'
			+  '<td>'
			+  '<DIV class="roomItemStyle">'
			+  '���ţ�&nbsp;&nbsp;<input type="text" name="roomBeds[' +itemCnt + '].bedNo" size="7"   maxlength="5">&nbsp;&nbsp;'
			+ 'ȫ�շ���<input type="text" name="roomBeds[' +itemCnt + '].alldayPrice" size="7"  maxlength="5">'
			+  '���췿��<input type="text" name="roomBeds[' +itemCnt + '].halfdayPrice" size="7"  maxlength="5"><br>'
			+  '�Ƿ��ӵ㷿<input checked type=checkbox name=hourFlagSet' +itemCnt + '  onclick="hourFlagSetFunc(' +itemCnt + ');">'
			+  '�۸�<input type="text" name="roomBeds[' +itemCnt + '].hourMeasure"size="7"  maxlength="5">'
			+  'Сʱ<input type="text" name="roomBeds[' +itemCnt + '].hourPrice" size="7"  maxlength="5">Ԫ'
			+  '</DIV>'
			+  '<a href="javascript:void(0)" onclick="deleteItem(' +itemCnt + ')" >ɾ����Ŀ</a></td></tr>';
	$('#item_' + (itemCnt-1)).after(newItem);
	$('#itemCnt').val(itemCnt + 1);
	
	if($('#currBed').val() == "") {
		$('#currBed').val(1);
	} else {
		var currBedCnt = parseInt($('#currBed').val());
		if(!isNaN(currBedCnt)) {
			$('#currBed').val(currBedCnt + 1);
		}
	}
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
		//alert(strs.length);
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
		var itemCnt = parseInt($('#currBed').val(), 10);
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
			var deletedIndexesBed = document.getElementsByName('deletedIndexes');
			var delFlag = false;
			for(j=0;j<deletedIndexesBed.length;j++) {
				if(deletedIndexesBed[j].value == i) {
					delFlag = true;
					break;
				}
			}
			// ɾ���Ļ�ֱ���˳�
			if(delFlag)  break;			
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
	form1.action="${pageContext.request.contextPath}/merRoom/update"; 
	form1.target="_self";
	form1.submit();
}

</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/merRoom/update"/>" target="_self">
        <input type="hidden" name="id"                    value="<c:out value="${merRoom.id}"/>">
        <input type="hidden" name="state"               value="<c:out value="${merRoom.state}"/>">
        <input type="hidden" name="mer.id"            value="<c:out value="${merRoom.mer.id}"/>">
        <input type="hidden" name="roomType.id" value="<c:out value="${merRoom.roomType.id}"/>">
        
        <input type="hidden" name="roomTypeAlldayPrice">
        <input type="hidden" name="roomTypeHalfdayPrice">
        <input type="hidden" name="roomTypeHourMeasure">
        <input type="hidden" name="roomTypeHourPrice">
        
        <div id="deletedIndexes" style="display:none;"></div>
		<input type="hidden" value="${fn:length(merRoom.roomBeds)}" id="itemCnt"/>
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY>
		    <TR class="hcititle">
		      <TD>���޸Ŀͷ���Ϣ��</TD>
		    </TR>
			<tr>
					<td>
					���ţ�&nbsp;&nbsp;<input type="text" name="roomNo"   value="<c:out value="${merRoom.roomNo}"/>">&nbsp;&nbsp;
					���ͣ�&nbsp;&nbsp;
				    <select name="roomTypeInfos" onchange="setRoomTypeInfo(this.options[this.options.selectedIndex].value)">
				    	<option value="">--��ѡ��--</option>
				    	<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
				    		<option value="<c:out value="${rs.id}-${rs.alldayPrice}-${rs.halfdayPrice}-${rs.hourMeasure}-${rs.hourPrice}"/>"  <c:if test="${merRoom.roomType.id == rs.id}">selected</c:if>  ><c:out value="${rs.name}"/></option>
				    	</c:forEach>
				    </select>&nbsp;&nbsp;
				    ����״̬��<c:out value="${merRoom.stateDesc}"/>
					</td>
				</tr>
				<tr>
					<td>
					����¥�㣺&nbsp;<input type="text" name="floor"        size="5" maxlength="10"   value="<c:out value="${merRoom.floor}"/>">&nbsp;&nbsp;
					����¥����&nbsp;<input type="text" name="building"  size="10" maxlength="12" value="<c:out value="${merRoom.building}"/>">&nbsp;&nbsp;
					�绰�ֻ���&nbsp;<input type="text" name="telExtension"     size="15" maxlength="20" value="<c:out value="${merRoom.telExtension}"/>">&nbsp;&nbsp;
					�绰���ߣ�&nbsp;<input type="text" name="telExteriorLine" size="15" maxlength="20" value="<c:out value="${merRoom.telExteriorLine}"/>">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>
					�ſ���&nbsp;&nbsp;<input type="text" name="doorCard" value="<c:out value="${merRoom.doorCard}"/>">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td><DIV>&nbsp;&nbsp;&nbsp;<input type="radio" name="hireFlag"  value="0" <c:if test="${merRoom.hireFlag == 0}">checked</c:if>>���������&nbsp;&nbsp;<input type="radio" name="hireFlag"  value="1" <c:if test="${merRoom.hireFlag == 1}">checked</c:if>>���㰴��λ����&nbsp;&nbsp;</DIV></td>
				</tr>
				<tr>
					<td>
					<input type="hidden" name="hourFlag"  value="1" value="<c:out value="${merRoom.hourFlag}"/>">
					<DIV class="roomItemStyle">ȫ�շ���<input type="text" name="alldayPrice" size="7"  maxlength="5"  value="<c:out value="${merRoom.alldayPrice}"/>">���췿��<input type="text" name="halfdayPrice" size="7"  maxlength="5" value="<c:out value="${merRoom.halfdayPrice}"/>"><br>
								�Ƿ��ӵ㷿<input checked type=checkbox name=hourFlagSet  onclick="hourFlagSetFunc(-1);"  <c:if test="${merRoom.hourFlag == 1}">checked</c:if>>�۸�<input type="text" name="hourMeasure"size="7"  maxlength="5" value="<c:out value="${merRoom.hourMeasure}"/>">Сʱ<input type="text" name="hourPrice" size="7"  maxlength="5" value="<c:out value="${merRoom.hourPrice}"/>">Ԫ
					</DIV>
					</td>
				</tr>
				<tr>
					<td>
					��λ����&nbsp;&nbsp;<input type="text" id="currBed" name="currBed" size="7" readonly  maxlength="5" value="<c:out value="${merRoom.currBed}"/>">&nbsp;&nbsp;<input type="button" value="��Ӵ�λ��Ŀ" onclick="addItem()"/>
					</td>
				</tr>
				<tr>
					<td>
					<div id="itemsDiv">
					<TABLE>
						<tr id="item_-1""></tr>
						<c:forEach var="rs" items="${merRoom.roomBeds}" varStatus="vStatus">
						<tr id="item_<c:out value="${vStatus.index}"/>">
						<input type="hidden" name="roomBeds[<c:out value="${vStatus.index}"/>].id"  value="<c:out value="${rs.id}"/>">
						<input type="hidden" name="roomBeds[<c:out value="${vStatus.index}"/>].hourFlag"  value="<c:out value="${rs.hourFlag}"/>">
						<td>
							<DIV class="roomItemStyle">���ţ�&nbsp;&nbsp;<input type="text" name="roomBeds[<c:out value="${vStatus.index}"/>].bedNo" value="<c:out value="${rs.bedNo}"/>"  size="7"   maxlength="5">&nbsp;&nbsp;ȫ�շ���<input type="text" name="roomBeds[<c:out value="${vStatus.index}"/>].alldayPrice"  value="<c:out value="${rs.alldayPrice}"/>" size="7"  	maxlength="5">���췿��<input type="text" name="roomBeds[<c:out value="${vStatus.index}"/>].halfdayPrice" value="<c:out value="${rs.halfdayPrice}"/>" size="7" maxlength="5"><br>
							�Ƿ��ӵ㷿<input type=checkbox name=hourFlagSet<c:out value="${vStatus.index}"/> <c:if test="${rs.hourFlag == 1}">checked</c:if>  onclick="hourFlagSetFunc(<c:out value="${vStatus.index}"/>);">	�۸�<input type="text" name="roomBeds[<c:out value="${vStatus.index}"/>].hourMeasure" value="<c:out value="${rs.hourMeasure}"/>" size="7"   maxlength="5">Сʱ<input type="text" name="roomBeds[<c:out value="${vStatus.index}"/>].hourPrice" value="<c:out value="${rs.hourPrice}"/>"  size="7"  maxlength="5">Ԫ
							</DIV><a href="javascript:void(0)" onclick="deleteItem(${vStatus.index})" >ɾ����Ŀ</a>
						</td>
						</tr>
						</c:forEach>
					<TABLE>
					</div>
					</td>
				</tr>
				<tr>
					<td>
					����������&nbsp;<textarea  name="roomDesc"  cols="100" rows="5" ><c:out value="${merRoom.roomDesc}"/></textarea>
					</td>
				</tr>
			    <TR>
			      <TD class=hcihead colspan="4" style="text-align:center">
			         <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="����" />
			         <input  type="button" name="goback" onclick="javascript:history.back();"  value="����"/>
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>