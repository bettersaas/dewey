<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="SexList"               value="${SexList}"              scope="page"/>
<c:set var="IdTypeList"          value="${IdTypeList}"         scope="page"/>
<c:set var="StayTypeList"     value="${StayTypeList}"     scope="page"/>
<c:set var="SettleModeList" value="${SettleModeList}" scope="page"/>
<c:set var="CustTypeList"     value="${CustTypeList}"    scope="page"/>
<c:set var="StatusList"          value="${StatusList}"         scope="page"/>
<c:set var="roomTypeList"            value="${roomTypeList}"          scope="page"/>
<c:set var="contractualUnitList"   value="${contractualUnitList}"  scope="page"/>
<c:set var="checkIn"   value="${checkIn}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<style>
#traveller{
	float:left;
	width: 30%;
	border-right: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
	padding-right: 10px;
}
#content{
  float: right;
  width: 69%;
  margin: 0px;
	padding: 0px;
	background-color: #eeeeee;
	border-left: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
}
#siteInfo{
	clear: both;
	border: 1px solid #cccccc;
	font-size: 75%;
	color: #cccccc;
	padding: 10px 10px 10px 10px;
}
.inputTextNoBorder{
   BORDER-RIGHT: medium none;
   BORDER-TOP: medium none;
   BORDER-LEFT: medium none;
   BORDER-BOTTOM:medium none;
   FONT-SIZE:9pt;
   WIDTH: 110; 
   TEXT-DECORATION: none ;
  }
.inputTextBorder{
   BORDER-RIGHT: 1px solid ;
   BORDER-TOP: 1px solid ;
   BORDER-LEFT: 1px solid ;
   BORDER-BOTTOM:1px solid;
   FONT-SIZE:9pt;
   WIDTH: 110;
   TEXT-DECORATION: none;
  }
.mouseHover{
	color: blue;
  }
</style>
<script src="<c:url value="/scripts/calendar.js"/>" type="text/javascript"></script>
<script language="JavaScript" type="text/JavaScript">
//+---------------------------------------------------
//| 房型查询空静房间
//+---------------------------------------------------
function searchByRroomTypeId()
{
		var searchRroomTypeId = document.getElementById("searchRroomTypeId");
		// 入住类型不能为空
		var stayType = form1.stayType.value;
		if(stayType=="") {
			window.alert("入住类型不能为空!") ;
			form1.stayType.focus();
			searchRroomTypeId.selectedIndex=0;
			return;
		}
		// 房型的选择
		if(searchRroomTypeId.value == "") {
			searchRroomTypeId.focus();
			return;
		}
		searchEmptyCleanRoom("",searchRroomTypeId.value);
}
//+---------------------------------------------------
//| 房号查询空静房间
//+---------------------------------------------------
function searchByRoomNo()
{
	// 入住类型不能为空
	var stayType = form1.stayType.value;
	if(stayType=="") {
		window.alert("入住类型不能为空!") ;
		form1.stayType.focus();
		return;
	}
	var roomSearchNum = $.trim($("#roomSearchNum").val());
	// 如果房号为空查询
	if(roomSearchNum == ""  || roomSearchNum == "请输入房号") {
		// 房型的查询
		var searchRroomTypeId = document.getElementById("searchRroomTypeId");
		if(searchRroomTypeId.value == "") {
			alert("请输入房号查找或者选择房型查找！");
			$("#roomSearchNum").val("请输入房号");
			$("#roomSearchNum").select();
			roomSearchNum = "";
		} else {
			// 房型查询
			searchEmptyCleanRoom("",searchRroomTypeId.value);
		}
		return;
	}
	searchEmptyCleanRoom(roomSearchNum,"");
}
//+---------------------------------------------------
//| 通过ajax获取空净房信息
//+---------------------------------------------------
function searchEmptyCleanRoom(roomSearchNum,searchRroomTypeId)
{
	var merId = document.getElementById("mer.id").value;
	var contractualUnitId = document.getElementById("contractualUnitId").value;
	htmlobj=$.ajax({
	    url: encodeURI("<c:url value="/checkIn/searchRoom"/>?randValue=" + getRandom()),
	    data: "roomSearchNum="+roomSearchNum+"&searchRroomTypeId="+searchRroomTypeId+"&mer.id="+ merId +"&contractualUnitId="+contractualUnitId,
		type: "POST",
		dataType : "json",
		async:false,  // 同步请求
		timeout: 1000,
		error:function(xhr,error,exception) {
		    //解析JSON异常时或者ajax出错
			alert(exception.toString());
		},
		success:function(data, status, xhr){
			var roomTrStr='';
			// 删除tobody中的所有行
			$("#tbd tr").remove();
			// 报错误信息
			if(data.message != "") {
				// 页面显示查无空净房的提示信息  弹出提示信息alert(data.message);
				$("#tbd").append('<tr class="rescontent"><td colspan="9" align="center">' + data.message + '<br></td></tr>');
			} else {
				// 获取json中的客房信息
				var jsonData = data.merRooms;
				var roomTrStr = "";
				// 遍历每个房间信息，生成每行客房记录html字符串，并加入到空净客房的尾部
				for(var i=0;i<jsonData.length;i++){
					roomTrStr = '<tr>';
					roomTrStr += '<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><input type="checkbox" name="ids" onclick="selectCheckInRoom(this,' + i + ')" value="'+ i + ';' + jsonData[i]["roomId"] + ';' + jsonData[i]["roomNo"] + ';' + jsonData[i]["bedId"] + ';' + jsonData[i]["bedNo"] + '">' + (i+1)  + '</td>';
					roomTrStr += '<input type="hidden" name="hireFlag' + i + '"  id="hireFlag' + i + '"  value="' + jsonData[i]["hireFlag"] + '">';
					roomTrStr += '<td align="center">' + jsonData[i]["roomTypeName"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["roomNo"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["bedNo"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["alldayPrice"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["halfdayPrice"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["hourPrice"] + '/'+ jsonData[i]["hourMeasure"]  + '小时</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["roomDesc"] + '</td>';
					roomTrStr += '<td align="center"><input type="text" disabled name="discount' + i + '" id="discount' + i + '" onblur="discountInput(' + i + ');"  size="8" maxlength="5" class="inputTextNoBorder"></td>';
					roomTrStr += '<td align="center"><input type="text" disabled name="amount' + i + '"  id="amount' + i + '"  onblur="amountInput(' + i + ');" " size="8" maxlength="7" class="inputTextNoBorder"></td>';
					roomTrStr += '</tr>';
					$("#tbd").append(roomTrStr);
					// 查询后设置入住房型
					document.getElementsByName("roomType.id")[0].value=jsonData[i]["roomTypeId"];
					// 设置入住类型相对应的房间价格
					selectCheckInType();
				}
				// 奇偶行不同颜色
				$("#emptyRoom tbody tr:odd").addClass("rescontent_");  // 索引奇数
				$("#emptyRoom tbody tr:even").addClass("rescontent");
				// 鼠标移动行变色
				$("#emptyRoom tbody tr").hover(function(){
				    $(this).addClass("mouseHover");
				},function(){
				    $(this).removeClass("mouseHover");
				});
			}
		}
	});
}
//+---------------------------------------------------
//| 选择入住房间
//| obj.checked      id:roomId
//+---------------------------------------------------
function selectCheckInRoom(obj,index)
{
	// 选择的房间
	if(obj.checked) {
		$("#discount" + index).removeClass();
		$("#amount" + index).removeClass();
		$("#discount" + index).addClass("inputTextBorder");
		$("#amount" + index).addClass("inputTextBorder");
		$("#discount" + index).val("").removeAttr("disabled");
		$("#amount" + index).val("").removeAttr("disabled");
	} else {
		$("#discount" + index).removeClass();
		$("#amount" + index).removeClass();
		$("#discount" + index).addClass("inputTextNoBorder");
		$("#amount" + index).addClass("inputTextNoBorder");
		$("#discount" + index).val("").attr("disabled","disabled");
		$("#amount" + index).val("").attr("disabled","disabled");
	}
}
//+---------------------------------------------------
//| 入住类型的选择
//+---------------------------------------------------
function selectCheckInType()
{
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	// 根据不同的选择，只显示当前选择的入住类型价格
	switch(stayTypeValue){
		// 半天房
		case "1" :
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});   // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});   // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).show()}); // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).show()});  // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // 钟点房
			break;
		// 全日房
		case '2':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // 钟点房
			break;
		// 钟点房
		case '3':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});   // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});    // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});    // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});    // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).show()});  // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).show()});   // 钟点房
			break;
		// 长包房
		case '4':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // 钟点房
			break;
		// 默认为空
		default : 
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});  // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});  // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});  // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});  // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});  // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});  // 钟点房
	}
	// 清空先前的折扣率和折扣价
	$("#emptyRoom tbody tr").each(function(index){
		$("#discount" + index).val("");
		$("#amount" + index).val("");
	});
}
//+---------------------------------------------------
//| 折扣的输入计算折扣价
//+---------------------------------------------------
function discountInput(index)
{
	$("#discount" + index).val($.trim($("#discount" + index).val()));
	var discount = $("#discount" + index).val();
	if (discount == "") {
		return;
	}
	if (!isDecimal(discount)) {
		alert("请输入正确的折扣率。");
		$("#discount" + index).select();
		return;
	}
	if (parseFloat(discount)>10 || parseFloat(discount)<0) {
		alert("请输入正确的折扣率。折扣率在0到10之间。");
		$("#discount" + index).select();
		return;
	}
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	var basePrice = "";
	// 根据不同的选择，选择需要打折扣的价格
	switch(stayTypeValue){
		// 半天房
		case "1" :
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
			break;
		// 全日房
		case '2':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 钟点房
		case '3':
			basePrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
			break;
		// 长包房
		case '4':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 默认为空
		default : 
			return;
	}
	$("#amount" + index).val(getRoundNumber(eval(basePrice + "*" + discount + "/10"),2));
}
//+---------------------------------------------------
//| 由折扣价格计算相应的折扣率进行回显
//+---------------------------------------------------
function amountInput(index)
{
	$("#amount" + index).val($.trim($("#amount" + index).val()));
	var amount = $("#amount" + index).val();
	if (amount == "") {
		return;
	}
	if (!isDecimal(amount)) {
		alert("请输入正确的折扣价。");
		$("#amount" + index).select();
		return;
	}
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	var basePrice = "";
	// 根据不同的选择，选择需要打折扣的价格
	switch(stayTypeValue){
		// 半天房
		case "1" :
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
			break;
		// 全日房
		case '2':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 钟点房
		case '3':
			basePrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
			break;
		// 长包房
		case '4':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 默认为空
		default : 
			return;
	}
	$("#discount" + index).val(getRoundNumber(eval(amount + "*10/" + basePrice),2));
}
</script>
</HEAD>
<BODY>
        <div style="height:3px;"></div>
		<div align="center" id="traveller">
		<form name="form1" method=post action="<c:url value="/checkIn/create"/>" target="_self">
		<input type="hidden" name="mer.id" value="<c:out value="${checkIn.mer.id}"/>">
		 <input type="hidden" name="roomType.id" >
		 <input type="hidden" name="contractualUnitName" >
		 <div id="selectCheckInRooms" style="display:none;"></div>
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="2">【旅客预订登记信息】</TD>
		    </TR>
				<tr>
					<td class="hcihead">入住类型</td>
					<td class=hcicontent>
					    <select name="stayType" onchange="selectCheckInType();">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${StayTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select><font color="red">*</font>
					</td>
				</tr>
		
				<tr>
					<td class="hcihead">姓名</td>
					<td class=hcicontent ><input type="text" name="custName"></td>
				</tr>
				<tr>
					<td class="hcihead">性别</td>
					<td class=hcicontent >
						<c:forEach var="rs" items="${SexList}" varStatus="vStatus">
							<input type="radio" name="sex"  value="<c:out value="${rs.value}"/>"><c:out value="${rs.name}"/>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="hcihead">联系电话</td>
					<td class=hcicontent ><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td class="hcihead">证件类型</td>
					<td class=hcicontent >
					    <select name="idType">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${IdTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">证件号码</td>
					<td class=hcicontent ><input type="text" name="idNo"></td>
				</tr>
				<tr>
					<td class="hcihead">地址</td>
					<td class=hcicontent ><input type="text" name="address"></td>
				</tr>
				<tr>
					<td class="hcihead">人数</td>
					<td class=hcicontent > <input type="text" name="peopleNum"></td>
				</tr>
				<tr>
					<td class="hcihead">预计入住日期</td>
					<td class=hcicontent >
					<input type="text" name="arrivalDate" id="arrivalDate" size="20" maxlength="19" readonly="readonly">
					<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.arrivalDate,null,'yyyy-MM-dd hh:mm',true);" />
					</td>
				</tr>
				<tr>
					<td class="hcihead">预计离店日期</td>
					<td class=hcicontent >
					<input type="text" name="planDepartureDate" id="planDepartureDate" size="20" maxlength="19" readonly="readonly">
					<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.planDepartureDate,null,'yyyy-MM-dd hh:mm',true);" />
					</td>
				</tr>
				<tr>
					<td class="hcihead">预计入住天数</td>
					<td class=hcicontent ><input type="text" name="stayDays" size="6" maxlength="3" readOnly class="inputTextNoBorder"></td>
				</tr>
				<tr>
					<td class="hcihead">付款方式</td>
					<td class=hcicontent>
					    <select name="settleMode">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${SettleModeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
						<tr>
					<td class="hcihead">签单挂账单位</td>
					<td class=hcicontent >
					    <select name="contractualUnitId" id="contractualUnitId">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${contractualUnitList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.id}"/>" ><c:out value="${rs.company}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">预付押金</td>
					<td class=hcicontent ><input type="text" name="deposit"></td>
				</tr>
				<tr>
					<td class="hcihead">旅客类别</td>
					<td class=hcicontent >
					    <select name="custType">
					    	<option value="">--请选择--</option>
					    	<c:forEach var="rs" items="${CustTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">早餐券</td>
					<td class=hcicontent ><input type="text" name="breakfastTicket" size="5"  maxlength="3" style="ime-mode:disabled" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">&nbsp;张</td>
				</tr>
				<tr>
					<td class="hcihead">备注</td>
					<td class=hcicontent ><textarea  rows="2" cols="30" name="remark"></textarea></td>
				</tr>
		    </TBODY>
		  </TABLE>
		</div>
		<div id="content" >
		    <div id="sectionLinks" style="width:100%;height:430px; overflow:scroll; border:1px solid;">
		    <div id="search">
		      【空净房】
		       &nbsp;&nbsp;
		      房型:<select name="searchRroomTypeId" id="searchRroomTypeId" onchange="searchByRroomTypeId();">
		    	<option value="">--请选择--</option>
		    	<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
		    		<option value="<c:out value="${rs.id}"/>" ><c:out value="${rs.name}"/></option>
		    	</c:forEach>
		     </select>
		     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     房号:<input name="roomSearchNum" type="text" size="10" id="roomSearchNum"   value="请输入房号 " onFocus="if (value =='请输入房号 '){value =''}" onBlur="if (value ==''){value='请输入房号 '}"/>
		      <input name="goButton" type="button"  onclick="javascript:searchByRoomNo();"  value="搜索" />
		    </div>
		    </form>
		    <form name="form2" method=post action="#" target="_self">
		    <table  id="emptyRoom" width="100%" border="1" cellspacing="0" cellpadding="0" summary="方法 " style="border-collapse:collapse;">
		   		<thead>
			    <tr class="reshead" id="merRoomTitle">
				    <th scope="col">序号</th>
				    <th scope="col">房型</th>
				    <th scope="col">房号</th>
				    <th scope="col">床号</th>
				    <th scope="col">全日房价</th>
				    <th scope="col">半日房价</th>
				    <th scope="col">钟点房价</th>
				    <th scope="col" width="30%">房间说明</th>
				    <th scope="col">折扣比例(/折)</th>
				    <th scope="col">折扣价格</th>
			    </tr>
			    </thead>
			    <tbody id="tbd">
						<tr  class="rescontent">
							<td colspan="10" align="center">请查询相应入住房型的空净房间。<br></td>
						</tr>
				</tbody>
		    </table>
		    </form>
		   </div>
		   <!-- end 空净房 -->
		</div>
		<div id="siteInfo" align="center"> 
			<input  type="button" name="save"  onclick="javascript:readIdentity();"  value="读二代证" />&nbsp;&nbsp;
			<input  type="button" name="save"  onclick="javascript:readMemberCard();"  value="会员房价" />&nbsp;&nbsp;
			<input  type="button" name="save"  onclick="javascript:operatorDiscount();"  value="操作员折扣" />&nbsp;&nbsp;
			<input  type="button" name="save"  onclick="javascript:formSubmit();"  value="提交预订" />&nbsp;&nbsp;
		</div>
		<br />
 </BODY>
 <script language="JavaScript" type="text/JavaScript">
//+---------------------------------------------------
//| 订房制卡
//+---------------------------------------------------
function formSubmit()
{
	// 协议单位赋值
	var contractualUnitId = form1.contractualUnitId.value;
	if(contractualUnitId!="") {
		var obj=document.getElementById("contractualUnitId");
		for(i=0; obj.length; i++){
			if(obj[i].selected==true){
				form1.contractualUnitName.value = obj[i].innerText;
				break;
			}
		}
	}
	
	// 早餐券不为空时判断其是否是整数
	if(!isEmpty(form1.breakfastTicket))    {
		cntBft = parseInt(form1.breakfastTicket.value,10);
		if(isNaN(cntBft)) {
			window.alert("早餐券的数量必须是整数!") ;
			form1.breakfastTicket.select();
			return;
		}
	}
	
	var arrivalDate =  form1.arrivalDate.value;
	// 入住日期不能为空
	if(isEmpty(form1.arrivalDate)) {
		window.alert("入住日期不能为空!") ;
		form1.arrivalDate.select();
		return;
	}
	// 检查入住日期不能小于当前时间
	//var now = new Date();
	//var truncMinuteNowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes());
	//var time1 = truncMinuteNowDate.getTime();       // 当前日期
	var arrivalDateSplit = arrivalDate.split(/[- :]/);
	var time2 = new Date(arrivalDateSplit[0], arrivalDateSplit[1]-1, arrivalDateSplit[2], arrivalDateSplit[3], arrivalDateSplit[4]).getTime();
	//if(time1 > time2) {   // 入住时间比当前时间晚
	//	window.alert("入住时间比当前时间还早，请设定当前以后的时间!") ;
	//	form1.arrivalDate.select();
	//	return;
	//}
	var planDepartureDate =  form1.planDepartureDate.value;
	// 预计离店日期
	if(isEmpty(form1.planDepartureDate)) {
		window.alert("预计离店日期不能为空!") ;
		form1.planDepartureDate.select();
		return;
	}
	// 检查入住日期必须比预计离店日期早
	var planDepartureDateSplit = planDepartureDate.split(/[- :]/);
	var time3 = new Date(planDepartureDateSplit[0], planDepartureDateSplit[1]-1, planDepartureDateSplit[2], planDepartureDateSplit[3], planDepartureDateSplit[4]).getTime();
	if(time2 >= time3) {   // 入住时间必须比预计离店日期早
		window.alert("入住时间必须比预计离店日期早，请修改!") ;
		form1.planDepartureDate.select();
		return;
	}
	// 设定入住天数
	var cha=(time3-time2)/(1000*60*60*24);
	form1.stayDays.value=getRoundNumber(Math.abs(cha),2);
	
	// 入住类型不能为空
	var stayType = form1.stayType.value;
	if(stayType=="") {
		window.alert("入住类型不能为空!") ;
		form1.stayType.focus();
		return;
	}

	// 清空已选客房信息
	$('#selectCheckInRooms').html("");
	// 已选择的进行顺序编号
	var selectInt = -1;
    $("input[name='ids']").each(function(){
    	// 选择
    	if (this.checked) {
    		selectInt += 1;
    		var arr = this.value.split(";");
    		var index = arr[0];        // tr中的索引
    		var roomId = arr[1];     // 房间ID
    		var roomNo = arr[2];   // 房号
    		var bedId = arr[3];       // 床位ID
    		var bedNo = arr[4];     // 床号
    		var discount = $("#discount" + index).val();          // 折扣比例
    		var amount =   $("#amount" + index).val();            // 折扣价格
    		var checkInType = $("#hireFlag" + index).val();    // 租房方式
			// 原价格
   			var amountPrice;
   			switch(stayType) {
				// 半天房
				case "1" :
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
					break;
				// 全日房
				case '2':
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
					break;
				// 钟点房
				case '3':
					amountPrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
					break;
				// 长包房
				case '4':
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
					break;
   			}
   			// 没有折扣时，默认10折全价
    		if (amount == "") {
    			discount = 10;
    			amount = amountPrice;
    		}
    		$('#selectCheckInRooms').append(
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].roomId' value='" +roomId + "' >" + 
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].roomNo' value='" + roomNo + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].bedId' value='" +bedId + "' >" + 
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].bedNo' value='" + bedNo + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].discount' value='" + discount + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].amount' value='" + amount + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].checkInType' value='" + checkInType + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].merId' value='<c:out value="${checkIn.mer.id}"/>' >" +
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].registPrice' value='" + amountPrice + "' >");    //alert($('#selectCheckInRooms').html());
    	}
	});
	if(selectInt == -1) {
		alert("没有选择入住客房！");
		return;
	}
	form1.action="${pageContext.request.contextPath}/checkIn/create";
	form1.target="_self";
	form1.submit();
}

//+---------------------------------------------------
//| 选择入住日期/预计离店日期后自动设置入住天数
//+---------------------------------------------------
// propertychange在IE7是异步响应
function setStayDays() {
	var arrivalDate =  form1.arrivalDate.value;
	// 入住日期不能为空
	if(isEmpty(form1.arrivalDate)) {
		return;
	}
	// 检查入住日期不能小于当前时间
	var now = new Date();
	//var truncMinuteNowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes());
	//var time1 = truncMinuteNowDate.getTime();       // 当前日期
	var arrivalDateSplit = arrivalDate.split(/[- :]/);
	var time2 = new Date(arrivalDateSplit[0], arrivalDateSplit[1]-1, arrivalDateSplit[2], arrivalDateSplit[3], arrivalDateSplit[4]).getTime();
	//if(time1 > time2) {   // 入住时间比当前时间还早
	//	window.alert("入住时间比当前时间还早，请设定当前以后的时间!") ;
	//	form1.arrivalDate.select();
	//	return;
	//}
	var planDepartureDate =  form1.planDepartureDate.value;
	// 预计离店日期为空
	if(isEmpty(form1.planDepartureDate)) {
		return;
	}
	// 检查入住日期必须比预计离店日期早
	var planDepartureDateSplit = planDepartureDate.split(/[- :]/);
	var time3 = new Date(planDepartureDateSplit[0], planDepartureDateSplit[1]-1, planDepartureDateSplit[2], planDepartureDateSplit[3], planDepartureDateSplit[4]).getTime();
	if(time2 >= time3) {   // 入住时间必须比预计离店日期早
		window.alert("入住时间必须比预计离店日期早，请修改!") ;
		form1.planDepartureDate.select();
		return;
	}
	// 设定入住天数
	var cha=(time3-time2)/(1000*60*60*24);
	form1.stayDays.value=getRoundNumber(Math.abs(cha),2);
}

/********************************************************
 js更改文本框的值后不触发onChange事件问题 
********************************************************/
//IE  $.browser.msie   navigator.userAgent.indexOf("MSIE")>0
if($.browser.msie){
	// .unbind("propertychange")
	// document.getElementById('arrivalDate').attachEvent("onpropertychange",setStayDays);
	$('#arrivalDate').bind('propertychange', function(event) {
	        if($.syncProcessSign) return ;
	        $.syncProcessSign = true;
	        setStayDays();
	        $.syncProcessSign = false;
	});
    // document.getElementById('planDepartureDate').attachEvent("onpropertychange",setStayDays);
    $('#planDepartureDate').bind('propertychange', function(event) {
	        if($.syncProcessSign1) return ;
	        $.syncProcessSign1 = true;
	        setStayDays();
	        $.syncProcessSign1 = false;
	});
//FF
}else if(navigator.userAgent.indexOf("Firefox")>0){
    document.getElementById('arrivalDate').addEventListener("input",setStayDays,false);
    document.getElementById('planDepartureDate').addEventListener("input",setStayDays,false);
}
 </script>
</HTML>