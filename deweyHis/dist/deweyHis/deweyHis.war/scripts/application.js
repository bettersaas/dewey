// ��������
function getRandom() {
	return Math.random();
}

function rand(){
	var n = Math.round(Math.random() * 10000);
	return n;
}

// ��������
function openWin(url, w, h) {
  window.open(url,'ss','width='+w+',height='+h+',scrollbars=yes,resizable=no,status=no,toolbar=no,menubar=no,location=no').focus();
}

//�ж�cookie�Ƿ���
var cookieEnabled=(navigator.cookieEnabled)? true : false;

// ����cookie
function setCookie(name, value, isForever) {
	document.cookie = name + "=" + encodeURIComponent(value) + (isForever?";expires="+(new Date(2099,12,31)).toGMTString():"");
}
// ����name��ȡcookieֵ
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
// Ϊ��ɾ��ָ�����Ƶ�cookie�����Խ������ʱ���趨Ϊһ����ȥ��ʱ��
function delCookie(name){
   var date = new Date();
   date.setTime(date.getTime() - 10000);
   document.cookie = name + "=a; expires=" + date.toGMTString();
}

//ɾ���ַ�����ߵĿո�  in use
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

//ɾ���ַ����ұߵĿո�  in use
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

//ɾ���ַ����������ߵĿո� in use
function trim(str) { 
	return(rtrim(ltrim(str)));
	// return str.replace(/(^\s*)|(\s*$)/g, "");
}

// ����ı����Ƿ�Ϊ��  trimҪ����־   in use 
function isEmpty(obj,trimFlag) {
    if(obj == null || obj.value.length == 0)  {
    	return true;
    }
    // Ĭ��trim
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
��;����������ַ����Ƿ������ָ�ʽ,���Դ�С�������Ǹ���
���룺
	s���ַ���  "^[-]{0,1}[0-9]+[\.]{0,1}[0-9]+$";
���أ�
	���ͨ����֤����true,���򷵻�false	
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
��;����������ַ����Ƿ��Ǵ�С��,�����Ǹ���
���룺
	s���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
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
ϵͳ�������ֵ
�ж�������ǲ��ǽ��(����0,Ҫ��������,����û��С��,Ҳ������;�����С��,С��������2λ)    in use
*/
function isMoney(objVar,defaultValue)
{
	objVar.value=trim(objVar.value);
	// ֵΪ��ʱ����Ĭ��ֵ
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
		alert('��������ȷ��������Ǹ������ɴ�����λС���㣩��');
		objVar.select();
		return false;
	}
	// ��������
	var floatFront = "";
	// С������
	var floatBack = "";
	// ֻ����������ʱ
	if (objVar.value.indexOf('.') == -1) {
		floatFront = objVar.value;
	} else {
		floatFront = objVar.value.substring(0, objVar.value.indexOf("."));
		floatBack  = objVar.value.substring(objVar.value.indexOf(".")+1, objVar.value.length);
	}
	// ��������ʱλ�����ܳ���8λ
	if (floatFront.length>8) {
		alert("��ֵ��������������Ч����λ���ܳ���8λ��");
		objVar.select();
		return false;
	}
	// С������ʱ���ܳ���2λ
	if (floatBack.length > 2) {
		alert("С��������Ч����λ���ܳ���2λ��");
		objVar.select();
		return false;
	}
	return true;
}

// �ж��Ƿ�������     in use
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
	��������: isNumber()
	��������: �ж��Ƿ�����
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
            alert('��ѡ��Ҫ�����Ķ���!');
            return;
    }
    if (confirm('ȷ��ִ��[ɾ��]����?')){
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
	�������ƣ�isMail()
	�������ܣ��ж��Ƿ���ȷ��E-mail��ʽ
*/
function isMail(mail){
	if(mail == "" || mail == null)
		return false;
	if( mail.match(/^\w{1,}@\w{1,}\.\w{1,}\.{0,1}\w{1,}$/g)==null)
	{
		alert("������� "+mail+ " ����һ����Ч��E-mail�����������룡\n\n��ȷ��ʽ���� xxxx@xxx.xxx\n          �� xxxx@xxx.xxx.xx");
		return false;
	}
	return true;
}

/*
��;����������Email�����ʽ�Ƿ���ȷ
���룺
	strEmail���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
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
	�������ƣ�isChinaID()
	�������ܣ�������֤�������ȷ�ԣ���Ϊ�գ�ֻ����15λ����18λ������18λ�����ĩβ��"X"��"x".
			��ȷ�򷵻أ���ǰ�ĺ��룬
			���򷵻أ�FALSE
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
	�������ƣ�isPhone()
	��������: �ж��Ƿ�绰������ʽ
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
��;���������ĵ绰�����ʽ�Ƿ���ȷ
���룺
	strPhone���ַ���
���أ�
	���ͨ����֤����true,���򷵻�false	
*/
function checkPhone( strPhone ) { 
	var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/; 
	var phoneRegWithArea2 = /^[0][1-9]{2,3}-[0-9]{5,10}-[0-9]{2,6}$/; 
	var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}-[0-9]{2,6}$/; 
	var phoneRegNoArea2 = /^[1-9]{1}[0-9]{5,8}$/; 
	var prompt = "������ĵ绰���벻��ȷ����ʽӦ�ø�Ϊ������-�绰����-�ֻ���!"
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
	�������ƣ�compDate()
	�������ܣ�2�����ڱȽϴ�С��endDate������startDate, �򷵻�true,���򷵻�false��
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
	�������ƣ�trim
	��������: ȥ���ַ���ͷ����β���Ŀո�
	����������ַ�������
	����������������Ӵ�
*/
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

/*
	�������ƣ�autoResize()
	�������ܣ�ʵ��iframe��̬����
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
	�������ƣ�showDate()
	�������ܣ������ݿ���YYYYMMDDת��ΪYYYY-MM-DD
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

//�������뵽num�����nλ
function getRoundNumber(num,n){ 				
	return Math.round(num*Math.pow(10,n))/Math.pow(10,n); 
} 

//��ȡnλ
function getTruncNumber(num,n){ 
	return num.toString().replace(new RegExp("^(\\-?\\d*\\.?\\d{0,"+n+"})(\\d*)$"),"$1")+0; 
} 

 // ��������ύ�Ľ��
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
��;����鵥ѡť
���룺
	radioName���ַ���
���أ�
	���ظõ�ѡť�б�ѡ�е�  [0]:true����false��ʶ�Ƿ�ѡ��	 [1]:ֵ
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
��;����鸴ѡ��
���룺
	checkboxID���ַ���
���أ�
	���ظø�ѡ���б�ѡ�е�  [0]:��Ŀ	 [1]:�Զ��ŷָ��ֵ
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

// ����ַ������ֽ���
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
//| ������¸�ʽ�����ַ���
//| ��ʽΪ��YYYYMMDDHHMMSS
//| ����  
//| d = new Date()
//| ָ��ĳ�� 
//| var t = "2010-08-09 13:12:07".split(/[- :]/);
//| var d = new Date(t[0], t[1]-1, t[2], t[3], t[4], t[5]);
//+---------------------------------------------------
function getYYYYMMddHHmmss(myDate)
{
	var year = myDate.getYear(); //��ȡ��ǰ���(2λ)
	var fullyear = myDate.getFullYear(); //��ȡ���������(4λ,1970-????)
	var month = myDate.getMonth()+1; //��ȡ��ǰ�·�(0-11,0����1��)
	if(month < 10) month = "0" + month;
	var day = myDate.getDate(); //��ȡ��ǰ��(1-31)
	if(day <10) day = "0" + day;
	var timeNum = myDate.getTime(); //��ȡ��ǰʱ��(��1970.1.1��ʼ�ĺ�����)
	var hour = myDate.getHours(); //��ȡ��ǰСʱ��(0-23)
	if(hour <10) hour = "0" + hour;
	var minutes = myDate.getMinutes(); //��ȡ��ǰ������(0-59)
	if(minutes <10) minutes = "0" + minutes;
	var seconds = myDate.getSeconds(); //��ȡ��ǰ����(0-59)
	if(seconds <10) seconds = "0" + seconds;
	return "" + fullyear + month + day + hour + minutes + seconds;
}
//+---------------------------------------------------
//| ����ʱ����
//| ��ʽΪ��YYYY-MM-DD HH:MM:SS
//| ��ʽΪ��YYYY-MM-DD HH:MM
//| ��ʽΪ��YYYY-MM-DD
//+---------------------------------------------------
function CheckDateTime(str)
{
	if(str.length == 19) {
		// ��ʽΪ��YYYY-MM-DD HH:MM:SS
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
		// ��ʽΪ��YYYY-MM-DD HH:MM
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
		// ��ʽΪ��YYYY-MM-DD
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
//| ����checkbox�����ֻ�ȡѡȡ�ĸ���
//+---------------------------------------------------
function getCheckBoxLength(checkBoxName) {
	var count = 0;
	var ids =document.getElementsByName(checkBoxName);
	if(ids == undefined)
		return count;
	// û��ѡ��ʱ��undefined -�� false
	if(ids.checked)
		return ++count;
	if (ids.length != undefined) {
		//������¼ ��������
		for (var i=0;i<ids.length;i++) {
			if (ids[i].checked) {
				count++;
			}
		}
	}
	//������¼
	return count;
}