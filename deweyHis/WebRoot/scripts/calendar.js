<!--
   //使用demo：
   //无时间:<input type="text" name="d" style="width:180px;" ondblclick="calendar.show(this,null,'yyyyMMdd');"> 
   //有时间:<input type="text" name="d2" style="width:180px;" onclick="calendar.show(this,null,'yyyy-MM-dd hh:mm:ss',true);" > <br>
/**   
 * Calendar   
 * @param   beginYear           1990   
 * @param   endYear             2020   
 * @param   language            0(zh_cn)|1(en_us)|2(en_en)|3(zh_tw)|4(jp)   
 * @param   patternDelimiter    "-"   
 * @param   date2StringPattern  "yyyy-MM-dd"   
 * @param   string2DatePattern  "ymd"   
 * @version V20060401   
 * @version V20061217   
 * @version V20080809 add to google project   
 * @version V20081226 add language support for japanese    
 * @version V20090104 add fix some bugs in help.html   
                      use style.display replace the style.visibility   
                      some enhancements and changes   
 * @author  KimSoft (jinqinghua [at] gmail.com)   
 * NOTE!    you can use it free, but keep the copyright please   
 * IMPORTANT:you must include this script file inner html body elment    
 * @see http://code.google.com/p/kimsoft-jscalendar/   
 */   
function Calendar(beginYear, endYear, language, patternDelimiter, date2StringPattern, string2DatePattern,showTime) {    
    this.showTime=showTime;    
    this.beginYear = beginYear || 1990;    
    this.endYear   = endYear   || 2020;    
    this.language  = language  || 0;    
    this.patternDelimiter = patternDelimiter || "-";
    this.date2StringPattern = date2StringPattern || Calendar.language["date2StringPattern"][this.language].replace(/\-/g, this.patternDelimiter);    
    this.string2DatePattern = string2DatePattern || Calendar.language["string2DatePattern"][this.language];    
        
    this.dateControl = null;    
    this.panel  = this.getElementById("__calendarPanel");    
    this.iframe = window.frames["__calendarIframe"];    
    this.form   = null;    
        
    this.date = new Date();    
    this.year = this.date.getFullYear();    
    this.month = this.date.getMonth();    
    this.house = this.date.getHours();    
    this.min = this.date.getMinutes();    
    this.second=this.date.getSeconds();    
   
    this.colors = {"bg_cur_day":"#00CC33","bg_over":"#EFEFEF","bg_out":"#FFCC00"}    
};

Calendar.language = {
    "year"   : ["\u5e74", "", "", "\u5e74","\u5e74"],
    "months" : [
                ["\u4e00\u6708","\u4e8c\u6708","\u4e09\u6708","\u56db\u6708","\u4e94\u6708","\u516d\u6708","\u4e03\u6708","\u516b\u6708","\u4e5d\u6708","\u5341\u6708","\u5341\u4e00\u6708","\u5341\u4e8c\u6708"],    
                ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"],    
                ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"],    
                ["\u4e00\u6708","\u4e8c\u6708","\u4e09\u6708","\u56db\u6708","\u4e94\u6708","\u516d\u6708","\u4e03\u6708","\u516b\u6708","\u4e5d\u6708","\u5341\u6708","\u5341\u4e00\u6708","\u5341\u4e8c\u6708"],    
                ["\u4e00\u6708","\u4e8c\u6708","\u4e09\u6708","\u56db\u6708","\u4e94\u6708","\u516d\u6708","\u4e03\u6708","\u516b\u6708","\u4e5d\u6708","\u5341\u6708","\u5341\u4e00\u6708","\u5341\u4e8c\u6708"]                   
                ],
    "weeks"  : [["\u65e5","\u4e00","\u4e8c","\u4e09","\u56db","\u4e94","\u516d"],    
                ["Sun","Mon","Tur","Wed","Thu","Fri","Sat"],    
                ["Sun","Mon","Tur","Wed","Thu","Fri","Sat"],    
                ["\u65e5","\u4e00","\u4e8c","\u4e09","\u56db","\u4e94","\u516d"],    
                ["\u65e5","\u6708","\u706b","\u6c34","\u6728","\u91d1","\u571f"],    
            ],    
    "clear"  : ["\u6e05\u7a7a", "Clear", "Clear", "\u6e05\u7a7a", "\u524a\u9664"],    
    "today"  : ["\u4eca\u5929", "Today", "Today", "\u4eca\u5929", "\u4eca\u65e5"],    
    "close"  : ["\u5173\u95ed", "Close", "Close", "\u95dc\u9589", "\u623b\u308b"],    
    "date2StringPattern" : ["yyyy-MM-dd", "yyyy-MM-dd", "yyyy-MM-dd", "yyyy-MM-dd", "yyyy-MM-dd"],    
    "string2DatePattern" : ["ymd","ymd", "ymd", "ymd", "ymd"]    
};    
   
Calendar.prototype.draw = function() {    
    calendar = this;    
        
    var _cs = [];    
    _cs[_cs.length] = '<form id="__calendarForm" name="__calendarForm" method="post">';    
    _cs[_cs.length] = '<table id="__calendarTable" width="100%" border="0" cellpadding="3" cellspacing="1" align="center">';    
    _cs[_cs.length] = ' <tr>';    
    _cs[_cs.length] = '  <th><input class="l" name="goPrevMonthButton" type="button" id="goPrevMonthButton" value="<" \/><\/th>';    
    _cs[_cs.length] = '  <th colspan="5"><select class="year" name="yearSelect" id="yearSelect"><\/select><select class="month" name="monthSelect" id="monthSelect"><\/select><\/th>';    
    _cs[_cs.length] = '  <th><input class="r" name="goNextMonthButton" type="button" id="goNextMonthButton" value=">" \/><\/th>';    
    _cs[_cs.length] = ' <\/tr>';    
    _cs[_cs.length] = ' <tr>';    
    for(var i = 0; i < 7; i++) {    
        _cs[_cs.length] = '<th class="theader">';    
        _cs[_cs.length] = Calendar.language["weeks"][this.language][i];    
        _cs[_cs.length] = '<\/th>';     
    }    
    _cs[_cs.length] = '<\/tr>';    
    for(var i = 0; i < 6; i++){    
        _cs[_cs.length] = '<tr align="center">';
        for(var j = 0; j < 7; j++) {
            switch (j) {    
                case 0: _cs[_cs.length] = '<td class="sun"> <\/td>'; break;    
                case 6: _cs[_cs.length] = '<td class="sat"> <\/td>'; break;    
                default:_cs[_cs.length] = '<td class="normal"> <\/td>'; break;    
            }    
        }    
        _cs[_cs.length] = '<\/tr>';    
    }    
    _cs[_cs.length] = ' <tr id="trTime"><td colspan="5">';    
    _cs[_cs.length] = ' <select  id=ddlyear name=ddlhouse></select>:<select id=ddlmin name=ddlmin></select>:<select id=ddlsec name=ddlsec></select>';    
    _cs[_cs.length] = ' <\/td><td colspan="2"><input type="button" class="b" name="okButton" id="okButton" value="确定" \/></\td>';    
    _cs[_cs.length] = ' <\/td><\/tr>';    
    _cs[_cs.length] = ' <tr>';    
    _cs[_cs.length] = '  <th colspan="2"><input type="button" class="b" name="clearButton" id="clearButton" \/><\/th>';    
    _cs[_cs.length] = '  <th colspan="3"><input type="button" class="b" name="selectTodayButton" id="selectTodayButton" \/><\/th>';    
    _cs[_cs.length] = '  <th colspan="2"><input type="button" class="b" name="closeButton" id="closeButton" \/><\/th>';    
    _cs[_cs.length] = ' <\/tr>';    
    _cs[_cs.length] = '<\/table>';    
    _cs[_cs.length] = '<\/form>';    
        
    this.iframe.document.body.innerHTML = _cs.join("");    
    this.form = this.iframe.document.forms["__calendarForm"];    
    for(var i=0;i<=23;i++){    
        var n=(i<10)?"0"+i:i;    
        this.form.ddlhouse.options[this.form.ddlhouse.length] = new Option(n, i);    
    }    
    for(var i=0;i<=59;i++){    
        var n=(i<10)?"0"+i:i;    
        this.form.ddlmin.options[this.form.ddlmin.length] = new Option(n,i );    
        this.form.ddlsec.options[this.form.ddlsec.length] = new Option(n,i );    
    }    
    this.form.ddlsec.onchange=this.form.ddlhouse.onchange=this.form.ddlmin.onchange=function(){    
        calendar.updateDate(calendar.date.getDate());    
    };    
        
    this.form.clearButton.value = Calendar.language["clear"][this.language];    
    this.form.selectTodayButton.value = Calendar.language["today"][this.language];    
    this.form.closeButton.value = Calendar.language["close"][this.language];    
        
    this.form.goPrevMonthButton.onclick = function () {calendar.goPrevMonth(this);}    
    this.form.goNextMonthButton.onclick = function () {calendar.goNextMonth(this);}    
    this.form.yearSelect.onchange = function () {calendar.update(this);}    
    this.form.monthSelect.onchange = function () {calendar.update(this);}    
        
    this.form.clearButton.onclick = function () {calendar.dateControl.value = "";calendar.hide();}
    this.form.okButton.onclick=function(){ calendar.dateControl.value = calendar.date.format(calendar.date2StringPattern);calendar.hide();}
    this.form.closeButton.onclick = function () {calendar.hide();}
    this.form.selectTodayButton.onclick = function () {
        var today = new Date();
        calendar.date = today;
        calendar.year = today.getFullYear();
        calendar.month = today.getMonth();
        calendar.house = today.getHours();
        calendar.min = today.getMinutes();
        calendar.second=today.getSeconds();
        calendar.dateControl.value = today.format(calendar.date2StringPattern);
        calendar.hide();
    }
};

Calendar.prototype.bindYear = function() {
    var ys = this.form.yearSelect;
    ys.length = 0;
    for (var i = this.beginYear; i <= this.endYear; i++){
        ys.options[ys.length] = new Option(i + Calendar.language["year"][this.language], i);
    }
};

Calendar.prototype.bindMonth = function() {
    var ms = this.form.monthSelect;
    ms.length = 0;
    for (var i = 0; i < 12; i++){
        ms.options[ms.length] = new Option(Calendar.language["months"][this.language][i], i);
    }
};

Calendar.prototype.goPrevMonth = function(e){
    if (this.year == this.beginYear && this.month == 0){return;}
    this.month--;
    if (this.month == -1) {
        this.year--;
        this.month = 11;
    }
    this.updateDate();
    this.changeSelect();
    this.bindData();
};

Calendar.prototype.goNextMonth = function(e){
    if (this.year == this.endYear && this.month == 11){return;}
    this.month++;
    if (this.month == 12) {
        this.year++;
        this.month = 0;
    }
    this.updateDate();
    this.changeSelect();
    this.bindData();
};

Calendar.prototype.changeSelect = function() {
    var ys = this.form.yearSelect;
    var ms = this.form.monthSelect;
    for (var i= 0; i < ys.length; i++){
        if (ys.options[i].value == this.date.getFullYear()){
            ys[i].selected = true;
            break;
        }
    }
    for (var i= 0; i < ms.length; i++){
        if (ms.options[i].value == this.date.getMonth()){
            ms[i].selected = true;
            break;    
        }
    }
};

Calendar.prototype.updateDate = function (n){
    if(!n)
        n=1;
    if(this.showTime){
        var h=this.form.ddlhouse;
        this.houre=h.options[h.selectedIndex].value;
        h=this.form.ddlmin;
        this.min=h.options[h.selectedIndex].value;
        h=this.form.ddlsec;
        this.second=h.options[h.selectedIndex].value;
        this.date = new Date(this.year, this.month, n,this.house,this.min,this.second);
    }
    else
        this.date = new Date(this.year, this.month, 1);
};    
Calendar.prototype.update = function (e){
    this.year  = e.form.yearSelect.options[e.form.yearSelect.selectedIndex].value;
    this.month = e.form.monthSelect.options[e.form.monthSelect.selectedIndex].value;
    this.updateDate();
    this.changeSelect();
    this.bindData();
};
Calendar.prototype.bindData = function () {
    var calendar = this;
    var dateArray = this.getMonthViewDateArray(this.date.getFullYear(), this.date.getMonth());
    var tds = this.getElementsByTagName("td", this.getElementById("__calendarTable", this.iframe.document));
    var trs = this.getElementsByTagName("tr", this.getElementById("__calendarTable", this.iframe.document));
    var panel=this.getElementById("__calendarPanel");
    if(this.showTime){
        panel.style.height="236px";
    }
    else{
        panel.style.height="216px";
        trs[8].style.display="none";
    }
    this.form.ddlhouse.selectedIndex=this.house-1;
    this.form.ddlmin.selectedIndex=this.min-1;
    this.form.ddlsec.selectedIndex=this.sec-1;
    for(var i = 0; i < tds.length-2; i++) {
        tds[i].style.backgroundColor = calendar.colors["bg_over"];
        tds[i].onclick = null;
        tds[i].onmouseover = null;
        tds[i].onmouseout = null;
        tds[i].innerHTML = dateArray[i] || " ";
        if (i > dateArray.length - 1) continue;
        if (dateArray[i]){
            tds[i].onclick = function () {
                if (calendar.dateControl){
                    var date=new Date(calendar.date.getFullYear(),
                                        calendar.date.getMonth(),
                                        this.innerHTML,
                                        calendar.date.getHours(),calendar.date.getMinutes(),
                                        calendar.date.getSeconds());
                    calendar.dateControl.value = date.format(calendar.date2StringPattern);
                }
                calendar.hide();
            }
            tds[i].onmouseover = function () {this.style.backgroundColor = calendar.colors["bg_out"];}
            tds[i].onmouseout  = function () {this.style.backgroundColor = calendar.colors["bg_over"];}
            var today = new Date();
            if (today.getFullYear() == calendar.date.getFullYear()) {
                if (today.getMonth() == calendar.date.getMonth()) {
                    if (today.getDate() == dateArray[i]) {
                        tds[i].style.backgroundColor = calendar.colors["bg_cur_day"];
                        tds[i].onmouseover = function () {this.style.backgroundColor = calendar.colors["bg_out"];}
                        tds[i].onmouseout  = function () {this.style.backgroundColor = calendar.colors["bg_cur_day"];}
                    }
                }
            }
        }//end if
    }//end for
};
   
Calendar.prototype.getMonthViewDateArray = function (y, m) {
    var dateArray = new Array(42);
    var dayOfFirstDate = new Date(y, m, 1).getDay();
    var dateCountOfMonth = new Date(y, m + 1, 0).getDate();
    for (var i = 0; i < dateCountOfMonth; i++) {
        dateArray[i + dayOfFirstDate] = i + 1;
    }
    return dateArray;
};

Calendar.prototype.show = function (dateControl, popuControl, showPattern, showTime) {
    this.showTime=(showTime);
	// 日期+时间
    if(this.showTime){
        this.date2StringPattern=showPattern||"yyyy-MM-dd hh:mm:ss";
        this.string2DatePattern="ymdhms";
    }
    else{
         this.date2StringPattern=showPattern||"yyyy-MM-dd";
    }
    if (this.panel.style.display == "block") {
        this.panel.style.display = "none";
    }
    if (!dateControl){
        throw new Error("arguments[0] is necessary!")
    }
    this.dateControl = dateControl;
    popuControl = popuControl || dateControl;

    this.draw();
    this.bindYear();
    this.bindMonth();
    if (dateControl.value.length > 0){
        this.date  = new Date(dateControl.value.toDate(this.patternDelimiter, this.string2DatePattern));
        this.year  = this.date.getFullYear();
        this.month = this.date.getMonth();
        this.house = this.date.getHours();
        this.min = this.date.getMinutes();
        this.second = this.date.getSeconds();
    }
    this.changeSelect();
    this.bindData();

    var xy = this.getAbsPoint(popuControl);
    this.panel.style.left = xy.x + "px";
    this.panel.style.top = (xy.y + dateControl.offsetHeight) + "px";
    this.panel.style.display = "block";
};    
   
Calendar.prototype.hide = function() {
    this.panel.style.display = "none";
};    
   
Calendar.prototype.getElementById = function(id, object){
    object = object || document;
    return document.getElementById ? object.getElementById(id) : document.all(id);
};

Calendar.prototype.getElementsByTagName = function(tagName, object){
    object = object || document;    
    return document.getElementsByTagName ? object.getElementsByTagName(tagName) : document.all.tags(tagName);
};

Calendar.prototype.getAbsPoint = function (e){
    var x = e.offsetLeft;
    var y = e.offsetTop;
    while(e = e.offsetParent){
        x += e.offsetLeft;
        y += e.offsetTop;
    }
    return {"x": x, "y": y};
};

/**   
 * @param   d the delimiter   
 * @param   p the pattern of your date   
 * @author  meizz   
 * @author  kimsoft add w+ pattern   
 */   
Date.prototype.format = function(style) {    
    var o = {    
        "M+" : this.getMonth() + 1, //month    
        "d+" : this.getDate(),      //day    
        "h+" : this.getHours(),     //hour    
        "m+" : this.getMinutes(),   //minute    
        "s+" : this.getSeconds(),   //second    
        "w+" : "\u65e5\u4e00\u4e8c\u4e09\u56db\u4e94\u516d".charAt(this.getDay()),   //week    
        "q+" : Math.floor((this.getMonth() + 3) / 3),  //quarter    
        "S"  : this.getMilliseconds() //millisecond    
    }    
    if (/(y+)/.test(style)) {    
        style = style.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));    
    }    
    for(var k in o){    
        if (new RegExp("("+ k +")").test(style)){    
            style = style.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));    
        }    
    }    
    return style;    
};    
   
/**   
 * @param d the delimiter   
 * @param p the pattern of your date   
 * @rebuilder kimsoft   
 * @version build 2006.12.15   
 */   
String.prototype.toDate = function(delimiter, pattern) {    
    delimiter = delimiter || "-";    
    pattern = pattern || "ymd";    
    if(pattern=="ymd"){    
        var a = this.split(delimiter);    
        var y = parseInt(a[pattern.indexOf("y")], 10);    
        if(y.toString().length <= 2) y += 2000;    
        if(isNaN(y)) y = new Date().getFullYear();    
        var m = parseInt(a[pattern.indexOf("m")], 10) - 1;    
        var d = parseInt(a[pattern.indexOf("d")], 10);    
        if(isNaN(d)) d = 1;    
        return new Date(y, m, d);    
    }    
    //2001-01-01 01:02:03    
    var y=this.substr(0,4);    
    var m=this.substr(5,2);    
    var d=this.substr(8,2);    
    var h=this.substr(11,2);    
    var mm=this.substr(14,2);    
    var s=this.substr(17,2);    
    var date=new Date(y,m-1,d,h,mm,s);    
    return date;    
};    
   
var divs = [];    
divs[divs.length] = '<div id="__calendarPanel" style="position:absolute;display:none;background-color:#FFFFFF;border:1px solid #666666;width:200px;height:236px;">';    
divs[divs.length] = '<iframe name="__calendarIframe" id="__calendarIframe" width="100%" height="100%" scrolling="no" frameborder="0" style="margin:0px;"><\/iframe>';    
divs[divs.length] = '<\/div>';    
document.write(divs.join(""));    
   
var __ci = window.frames['__calendarIframe'];    
var cis = [];    
cis[cis.length] ='<!DOCTYPE html PUBLIC "-\/\/W3C\/\/DTD XHTML 1.0 Transitional\/\/EN" "http:\/\/www.w3.org\/TR\/xhtml1\/DTD\/xhtml1-transitional.dtd">';    
cis[cis.length] ='<html xmlns="http:\/\/www.w3.org\/1999\/xhtml">';    
cis[cis.length] ='<head>';    
cis[cis.length] ='<meta http-equiv="Content-Type" content="text\/html; charset=utf-8" \/>';    
cis[cis.length] ='<title>Web Calendar(UTF-8) Written By KimSoft<\/title>';    
cis[cis.length] ='<style type="text\/css">';    
cis[cis.length] ='<!--';    
cis[cis.length] ='body {font-size:12px;margin:0px;text-align:center;}';    
cis[cis.length] ='form {margin:0px;}';    
cis[cis.length] ='select {font-size:12px;background-color:#EFEFEF;}';    
cis[cis.length] ='table {border:0px solid #CCCCCC;background-color:#FFFFFF}';    
cis[cis.length] ='th {font-size:12px;font-weight:normal;background-color:#FFFFFF;}';    
cis[cis.length] ='th.theader {font-weight:normal;background-color:#666666;color:#FFFFFF;width:24px;}';    
cis[cis.length] ='select.year {width:64px;}';    
cis[cis.length] ='select.month {width:60px;}';    
cis[cis.length] ='td {font-size:12px;text-align:center;}';    
cis[cis.length] ='td.sat {color:#0000FF;background-color:#EFEFEF;}';    
cis[cis.length] ='td.sun {color:#FF0000;background-color:#EFEFEF;}';    
cis[cis.length] ='td.normal {background-color:#EFEFEF;}';    
cis[cis.length] ='input.l {border: 1px solid #CCCCCC;background-color:#EFEFEF;width:20px;height:20px;}';    
cis[cis.length] ='input.r {border: 1px solid #CCCCCC;background-color:#EFEFEF;width:20px;height:20px;}';    
cis[cis.length] ='input.b {border: 1px solid #CCCCCC;background-color:#EFEFEF;width:100%;height:20px;}';    
cis[cis.length] ='-->';    
cis[cis.length] ='<\/style>';    
cis[cis.length] ='<\/head>';    
cis[cis.length] ='<body>';    
cis[cis.length] ='<\/body>';    
cis[cis.length] ='<\/html>';
__ci.document.writeln(cis.join(""));
__ci.document.close();
var calendar = new Calendar();    
//-->