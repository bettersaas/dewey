// 获得随机数
function getRandom() {
	return Math.random();
}

function rand(){
	var n = Math.round(Math.random() * 10000);
	return n;
}

// 弹出窗口
function openWin(url, w, h) {
  window.open(url,'ss','width='+w+',height='+h+',scrollbars=yes,resizable=no,status=no,toolbar=no,menubar=no,location=no').focus();
}

//判断cookie是否开启
var cookieEnabled=(navigator.cookieEnabled)? true : false;

// 设置cookie
function setCookie(name, value, isForever) {
	document.cookie = name + "=" + encodeURIComponent(value) + (isForever?";expires="+(new Date(2099,12,31)).toGMTString():"");
}
// 根据name获取cookie值
function getCookie(name) {
   var search = name + "="
   if(document.cookie.length > 0) {
      offset = document.cookie.indexOf(search);
      if(offset != -1) {
         offset += search.length;
         end = document.cookie.indexOf(";", offset);
         if(end == -1) end = document.cookie.length;
         return unescape(document.cookie.substring(offset, end));
      } else {
       return ""
      }
   }
}
// 为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
function delCookie(name){
   var date = new Date();
   date.setTime(date.getTime() - 10000);
   document.cookie = name + "=a; expires=" + date.toGMTString();
}

//删除字符串左边的空格  in use
function ltrim(str) { 
	if(str.length==0)
		return(str);
	else {
		var idx=0;
		while(str.charAt(idx).search(/\s/)==0)
			idx++;
		return(str.substr(idx));
	}
}

//删除字符串右边的空格  in use
function rtrim(str) { 
	if(str.length==0)
		return(str);
	else {
		var idx=str.length-1;
		while(str.charAt(idx).search(/\s/)==0)
			idx--;
		return(str.substring(0,idx+1));
	}
}

//删除字符串左右两边的空格 in use
function trim(str) { 
	return(rtrim(ltrim(str)));
	// return str.replace(/(^\s*)|(\s*$)/g, "");
}

// 检测文本框是否为空  trim要看标志   in use 
function isEmpty(obj,trimFlag) {
    if(obj == null || obj.value.length == 0)  {
    	return true;
    }
    // 默认trim
    if (trimFlag == null || trimFlag) {
    	obj.value = trim(obj.value);
    }
	if(obj.value=="")  {
	    //if(obj.disabled==false && obj.readOnly==false) {
        //    obj.focus();
        //}
        return true;
    } else {
    	return false;
    }
}

/*
用途：检查输入字符串是否是数字格式,可以带小数可以是负数
输入：
	s：字符串  "^[-]{0,1}[0-9]+[\.]{0,1}[0-9]+$";
返回：
	如果通过验证返回true,否则返回false	
*/
function isDecimal( s ){   
	var regu =/^((-?|\+?)\d+)(\.\d+)?$/;
	var re = new RegExp(regu);
	if (re.test(s)) {
	   return true;
	} else {
	   return false;
	}
}

/*
用途：检查输入字符串是否是带小数,可以是负数
输入：
	s：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function isFloat( s ){   
	var regu = "^[-]{0,1}[0-9]+[\.][0-9]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
	   return true;
	} else {
	   return false;
	}
}

/**
系统定义的数值
判断输入的是不是金额(大于0,要求是数字,可以没有小数,也可以有;如果有小数,小数必须是2位)    in use
*/
function isMoney(objVar,defaultValue)
{
	objVar.value=trim(objVar.value);
	// 值为空时返回默认值
	if (objVar.value=='')
	{
		if(defaultValue != null)
			objVar.value = defaultValue;
		else
			objVar.value = 0.00;
		return true;
	}
	var re=/^\d*(\d|(\d+\.[0-9]{0,2}))$/;
	if(!re.test(objVar.value)) 
	{
		alert('请输入正确金额数（非负数，可带有两位小数点）！');
		objVar.select();
		return false;
	}
	// 整数部分
	var floatFront = "";
	// 小数部分
	var floatBack = "";
	// 只有整数部分时
	if (objVar.value.indexOf('.') == -1) {
		floatFront = objVar.value;
	} else {
		floatFront = objVar.value.substring(0, objVar.value.indexOf("."));
		floatBack  = objVar.value.substring(objVar.value.indexOf(".")+1, objVar.value.length);
	}
	// 整数部分时位数不能超过8位
	if (floatFront.length>8) {
		alert("数值过大，整数部分有效数字位不能超过8位！");
		objVar.select();
		return false;
	}
	// 小数部分时不能超过2位
	if (floatBack.length > 2) {
		alert("小数部分有效数字位不能超过2位！");
		objVar.select();
		return false;
	}
	return true;
}

// 判断是否是整数     in use
function isInt(obj) {
   objValue = obj.value;
   if (trim(objValue) == "")
		return true;
	var regu = "^[1-9]*[0-9]+$";
	var re = new RegExp(regu);
	if (re.test(objValue)) {
	   if(!isNaN(objValue)) {
	   		return true;
	   } else {
	   		return false;
	   }
	} else {
	   return false;
	}
}

/*
	函数名称: isNumber()
	函数功能: 判断是否数字
*/
function isNumber(value){
	if(!isNaN(value))
	{
		 return true;
  }
	else{
	   return false;
	}
}
 
function disableSubmit(finalResult,submitButtonId) {
	if(finalResult) {
		document.getElementById(submitButtonId).disabled = true;
		return finalResult;
	}else {
		return finalResult;
	}
}

function batchDelete(action,checkboxName,form){
    if (!hasOneChecked(checkboxName)){
            alert('请选择要操作的对象!');
            return;
    }
    if (confirm('确定执行[删除]操作?')){
        form.action = action;
        form.submit();
    }
}

function hasOneChecked(name){
    var items = document.getElementsByName(name);
    if (items.length > 0) {
        for (var i = 0; i < items.length; i++){
            if (items[i].checked == true){
                return true;
            }
        }
    } else {
        if (items.checked == true) {
            return true;
        }
    }
    return false;
}

function setAllCheckboxState(name,state) {
	var elms = document.getElementsByName(name);
	for(var i = 0; i < elms.length; i++) {
		elms[i].checked = state;
	}
}

function getReferenceForm(elm) {
	while(elm && elm.tagName != 'BODY') {
		if(elm.tagName == 'FORM') return elm;
		elm = elm.parentNode;
	}
	return null;
}

/*
	函数名称：isMail()
	函数功能：判断是否正确的E-mail格式
*/
function isMail(mail){
	if(mail == "" || mail == null)
		return false;
	if( mail.match(/^\w{1,}@\w{1,}\.\w{1,}\.{0,1}\w{1,}$/g)==null)
	{
		alert("你输入的 "+mail+ " 不是一个有效的E-mail，请重新输入！\n\n正确格式：① xxxx@xxx.xxx\n          ② xxxx@xxx.xxx.xx");
		return false;
	}
	return true;
}

/*
用途：检查输入的Email信箱格式是否正确
输入：
	strEmail：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function checkEmail(strEmail) { 
	var emailReg = /^[_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/; 
	if( emailReg.test(strEmail) ){
		return true; 
	}else{
		return false; 
	}
}

/*
	函数名称：isChinaID()
	函数功能：检查身份证号码的正确性，不为空，只接受15位或是18位，允许18位号码的末尾有"X"和"x".
			正确则返回：当前的号码，
			否则返回：FALSE
*/
function isChinaID(strItem)
{
	if (strItem == "" || strItem==null){
		return false;
	}
	if (typeof(strItem)!='string'){
		return false;
	}
	if (strItem.length == 15) {
	      return this.isLegalString(strItem,"0123456789");
	} else if (strItem.length == 18) {
	      var lastchar = strItem.substring(17,18);
	      return ( this.isLegalString(strItem.substring(0,17),"0123456789") && (this.isLegalString(lastchar,"0123456789Xx")) );
	} else {
		return false;
	}
}

function isLegalString(str, part) {
	var intIndex;
	var intCharCount;
	for(intIndex = 0; intIndex < str.length; intIndex++){
		if (part.indexOf(str.charAt(intIndex)) == -1) {
			return false;
		}
	}
	return true;
}

/*
	函数名称：isPhone()
	函数功能: 判断是否电话号码形式
*/
function isPhone(str){
	var intIndex;
	var intCharCount;
	for(intIndex = 0; intIndex < str.length; intIndex++){
		if(str.charCodeAt(intIndex) < 32)
			return false;
		if(str.charCodeAt(intIndex) == 34)
			return false;
		if(str.charCodeAt(intIndex) == 39)
			return false;
		if(str.charCodeAt(intIndex) > 126)
			return false;
	}
	return true;
}

/*
用途：检查输入的电话号码格式是否正确
输入：
	strPhone：字符串
返回：
	如果通过验证返回true,否则返回false	
*/
function checkPhone( strPhone ) { 
	var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/; 
	var phoneRegWithArea2 = /^[0][1-9]{2,3}-[0-9]{5,10}-[0-9]{2,6}$/; 
	var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}-[0-9]{2,6}$/; 
	var phoneRegNoArea2 = /^[1-9]{1}[0-9]{5,8}$/; 
	var prompt = "您输入的电话号码不正确，格式应该改为：区号-电话号码-分机号!"
	if( phoneRegWithArea.test(strPhone) ||
		phoneRegWithArea2.test(strPhone) ||
		phoneRegNoArea.test(strPhone) ||
		phoneRegNoArea2.test(strPhone)
		 ){
		return true; 
	}else{
		alert( prompt );
		return false; 
	}	
}

/*
	函数名称：compDate()
	函数功能：2个日期比较大小，endDate不大于startDate, 则返回true,否则返回false。
*/
function compDate(startDate,endDate)
{	
	if(startDate.substring(0,4) > endDate.substring(0,4)){
		return false;
	}
	else if(startDate.substring(0,4) == endDate.substring(0,4)){
		if(startDate.substring(5,7) > endDate.substring(5,7)){
			return false;
		}
		else if(startDate.substring(5,7) == endDate.substring(5,7)){
			if(startDate.substring(8,startDate.length) > endDate.substring(8,startDate.length)){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return true;
		}
	}
	else{
		return true;
	}
}

/*
	函数名称：trim
	函数功能: 去除字符串头部和尾部的空格
	传入参数：字符串变量
	传出结果：处理后的子串
*/
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

/*
	函数名称：autoResize()
	函数功能：实现iframe动态增长
*/
function autoResize(target)
{
	if(target == null || target == "")
		target = "IFRAME_SELCET";
	try
	{
		document.all[target].style.height=eval(target+".document.body.scrollHeight");
	}
	catch(e){}
}

/*
	函数名称：showDate()
	函数功能：将数据库中YYYYMMDD转换为YYYY-MM-DD
*/
function showDate(data)
{
	var newdate = "";
	if(data == "")
		newdate = "";
	else
	{
		newdate = data.substring(0,4) + "-" + data.substring(4,6) + "-" + data.substring(6,data.length);
	}
	return newdate;
}

//四舍五入到num后面的n位
function getRoundNumber(num,n){ 				
	return Math.round(num*Math.pow(10,n))/Math.pow(10,n); 
} 

//截取n位
function getTruncNumber(num,n){ 
	return num.toString().replace(new RegExp("^(\\-?\\d*\\.?\\d{0,"+n+"})(\\d*)$"),"$1")+0; 
} 

 // 获得最终提交的金额
function getSubmitMoney(objStr)
{
	objStr.value=trim(objStr.value);
	if (objStr.value=='')
	{
		return '0';
	}
	return objStr.value;
}

function writeSubString(str,len){
 	if (str.length > len) {
 		document.writeln(str.substring(0,len)+'...');
 	} else {
 		document.writeln(str);
     }
 }

/*
用途：检查单选钮
输入：
	radioName：字符串
返回：
	返回该单选钮中被选中的  [0]:true或者false标识是否选择	 [1]:值
*/	
function getRadioValue(radioName)
{
	var radioObj = document.getElementsByName(radioName);
	var rtnValue= new Array();
	rtnValue[0] = false;
	for (i=0;i < radioObj.length;i++ )
	{
		if (radioObj[i].checked)
		{
			rtnValue[0] = true;
			rtnValue[1] = radioObj[i].value;
			break;
		}
	}
	return rtnValue;
}

/*
用途：检查复选框
输入：
	checkboxID：字符串
返回：
	返回该复选框中被选中的  [0]:数目	 [1]:以逗号分割的值
*/	
function getCheckSelectValue(checkboxID) {
	var check = 0;
	var value = "";
	var rtnValue= new Array();
	if (document.all(checkboxID) == null) {
		rtnValue[0] = check;
		rtnValue[1] = value;
		return rtnValue;
	}
	if(document.all(checkboxID).length > 0) { 
		for(var i=0; i<document.all(checkboxID).length; i++) {
			if( document.all(checkboxID).item(i).checked  ) {
				value = value + document.all(checkboxID).item(i).value +",";
				check += 1;
			}				
		}
		if (check>0) {
			value = value.substring(0,value.length-1);
		}
	}else{
		if( document.all(checkboxID).checked) {
			value = document.all(checkboxID).value;
			check = 1;
		}
	}
	rtnValue[0] = check;
	rtnValue[1] = value;
	return rtnValue;
}

// 获得字符串的字节数
function getTotalBytes(varField) {
	if(varField == null)
		return -1;	
	var totalCount = 0;
	for (i = 0; i< varField.value.length; i++) {
		if (varField.value.charCodeAt(i) > 127) 
			totalCount += 2;
		else
			totalCount++ ;
	}
	return totalCount;
}

//+---------------------------------------------------
//| 获得如下格式日期字符串
//| 格式为：YYYYMMDDHHMMSS
//| 当天  
//| d = new Date()
//| 指定某天 
//| var t = "2010-08-09 13:12:07".split(/[- :]/);
//| var d = new Date(t[0], t[1]-1, t[2], t[3], t[4], t[5]);
//+---------------------------------------------------
function getYYYYMMddHHmmss(myDate)
{
	var year = myDate.getYear(); //获取当前年份(2位)
	var fullyear = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
	var month = myDate.getMonth()+1; //获取当前月份(0-11,0代表1月)
	if(month < 10) month = "0" + month;
	var day = myDate.getDate(); //获取当前日(1-31)
	if(day <10) day = "0" + day;
	var timeNum = myDate.getTime(); //获取当前时间(从1970.1.1开始的毫秒数)
	var hour = myDate.getHours(); //获取当前小时数(0-23)
	if(hour <10) hour = "0" + hour;
	var minutes = myDate.getMinutes(); //获取当前分钟数(0-59)
	if(minutes <10) minutes = "0" + minutes;
	var seconds = myDate.getSeconds(); //获取当前秒数(0-59)
	if(seconds <10) seconds = "0" + seconds;
	return "" + fullyear + month + day + hour + minutes + seconds;
}
//+---------------------------------------------------
//| 日期时间检查
//| 格式为：YYYY-MM-DD HH:MM:SS
//| 格式为：YYYY-MM-DD HH:MM
//| 格式为：YYYY-MM-DD
//+---------------------------------------------------
function CheckDateTime(str)
{
	if(str.length == 19) {
		// 格式为：YYYY-MM-DD HH:MM:SS
		var reg = /^(\d{1,4})-(\d{1,2})-(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
		var r = str.match(reg);
		// r[0]:str  r[1]:YYYY  r[2]:MM  r[3]:DD  r[4]:HH  r[5]:MM  r[6]:SS
		if(r==null)return false;
		r[2]=r[2]-1;
		var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);
		if(d.getFullYear()!=r[1])return false;
		if(d.getMonth()!=r[2])return false;
		if(d.getDate()!=r[3])return false;
		if(d.getHours()!=r[4])return false;
		if(d.getMinutes()!=r[5])return false;
		if(d.getSeconds()!=r[6])return false;
		return true;
	}
	if(str.length == 16) {
		// 格式为：YYYY-MM-DD HH:MM
		var reg = /^(\d{1,4})-(\d{1,2})-(\d{1,2}) (\d{1,2}):(\d{1,2})$/;
		var r = str.match(reg);
		// r[0]:str  r[1]:YYYY  r[2]:MM  r[3]:DD  r[4]:HH  r[5]:MM
		if(r==null)return false;
		r[2]=r[2]-1;
		var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);
		if(d.getFullYear()!=r[1])return false;
		if(d.getMonth()!=r[2])return false;
		if(d.getDate()!=r[3])return false;
		if(d.getHours()!=r[4])return false;
		if(d.getMinutes()!=r[5])return false;
		return true;
	}
	if(str.length == 10) {
		// 格式为：YYYY-MM-DD
		var reg = /^(\d{1,4})-(\d{1,2})-(\d{1,2})$/;
		var r = str.match(reg);
		// r[0]:str  r[1]:YYYY  r[2]:MM  r[3]:DD
		if(r==null)return false;
		r[2]=r[2]-1;
		var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);
		if(d.getFullYear()!=r[1])return false;
		if(d.getMonth()!=r[2])return false;
		if(d.getDate()!=r[3])return false;
		return true;
	}
}

//+---------------------------------------------------
//| 根据checkbox的名字获取选取的个数
//+---------------------------------------------------
function getCheckBoxLength(checkBoxName) {
	var count = 0;
	var ids =document.getElementsByName(checkBoxName);
	if(ids == undefined)
		return count;
	// 没有选择时：undefined -》 false
	if(ids.checked)
		return ++count;
	if (ids.length != undefined) {
		//多条记录 挨个遍历
		for (var i=0;i<ids.length;i++) {
			if (ids[i].checked) {
				count++;
			}
		}
	}
	//单条记录
	return count;
}