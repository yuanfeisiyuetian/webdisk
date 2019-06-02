/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
            
          
window.oncontextmenu=function(e){
    if(e.clientX>405 && e.clientY>310)
    {
//取消默认的浏览器自带右键 很重要！！
e.preventDefault();

//获取我们自定义的右键菜单
var menu=document.querySelector("#menu");

//根据事件对象中鼠标点击的位置，进行定位
menu.style.left=e.clientX+'px';
menu.style.top=e.clientY+'px';

//改变自定义菜单的宽，让它显示出来
menu.style.width='125px';
}

//关闭右键菜单，很简单
window.onclick=function(e){

//用户触发click事件就可以关闭了，因为绑定在window上，按事件冒泡处理，不会影响菜单的功能
document.querySelector('#menu').style.width=0;
}

}

function show_userlist()
{
    document.getElementById("userlist").style.display="block";
    document.getElementById("userlist").style.width='125px';
}

function hide_userlist()
{
    document.getElementById("userlist").style.width='0px';
}


function fev_deleted() {
        var popBox = document.getElementById("pop");
        var popLayer = document.getElementById("pop_back");
        popBox.style.display = "block";
        popLayer.style.display = "block";
    };
 
/*点击关闭按钮*/
function closeBox() {
    var popBox = document.getElementById("pop");
    var popLayer = document.getElementById("pop_back");
    popBox.style.display = "none";
    popLayer.style.display = "none";
}

function clear(){
    document.getElementById("text2").value="";
}

function download(){
    var checkson = document.getElementsByName("filelist");
     for(var i = 0; i < checkson.length ;i++){
            if(checkson[i].checked == true){
                var $eleForm = $("<form method='get'></form>");
                $eleForm.attr("action","https://codeload.github.com/douban/douban-client/legacy.zip/master");
                $(document.body).append($eleForm);
                //提交表单，实现下载
                $eleForm.submit();
            }
        }
}

function login(){
    window.location.href='personal.html';
}

function upload()
{
        var popBox = document.getElementById("fileloader");
        var file_back = document.getElementById("file_back");
        popBox.style.display = "block";
        file_back.style.display = "block";
}

function closeFileBox() {
    var popBox = document.getElementById("fileloader");
    var popLayer = document.getElementById("file_back");
    popBox.style.display = "none";
    popLayer.style.display = "none";
}


function fileSelected() {
        var file = document.getElementById('fileToUpload').files[0];
        if(file) {
                var fileSize = 0;
                if(file.size > 1024 * 1024)
                        fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
                else
                        fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
                document.getElementById('fileName').innerHTML = '文件名: ' + file.name;
                document.getElementById('fileSize').innerHTML = '文件大小: ' + fileSize;
        }
}

function uploadFile() {
    var fileObj = document.getElementById("fileToUpload").files[0]; // js 获取文件对象
    var url =  "http://127.0.0.1/8080/var"; // 接收上传文件的后台地址
    var fd = new FormData();
    fd.append("file", fileObj); // 文件对象
    var xhr = new XMLHttpRequest();
    xhr.open("post", url, true); //post方式，url为服务器请求地址，true 该参数规定请求是否异步处理。
            xhr.onload = uploadComplete; //请求完成
            xhr.onerror =  uploadFailed; //请求失败
            xhr.upload.onprogress = progressFunction;//【上传进度调用方法实现】
            xhr.upload.onloadstart = function(){//上传开始执行方法
                ot = new Date().getTime();   //设置上传开始时间
                oloaded = 0;//设置上传开始时，以上传的文件大小为0
            };
 
            xhr.send(fd); //开始上传，发送form数据

}

//上传成功响应
function uploadComplete(evt) {
    //服务断接收完文件返回的结果
    var data = JSON.parse(evt.target.responseText);
    if(data.success) {
        alert("上传成功！");
    }else{
        alert("上传失败！");
    }

}
//上传失败
function uploadFailed(evt) {
    alert("上传失败！");
}
//取消上传
function cancleUploadFile(){
    xhr.abort();
}


//上传进度实现方法，上传过程中会频繁调用该方法
function progressFunction(evt) {
    var progressBar = document.getElementById("progressBar");
    var percentageDiv = document.getElementById("percentage");
    // event.total是需要传输的总字节，event.loaded是已经传输的字节。如果event.lengthComputable不为真，则event.total等于0
    if (evt.lengthComputable) {//
        progressBar.max = evt.total;
        progressBar.value = evt.loaded;
        percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
    }
    var time = document.getElementById("time");
    var nt = new Date().getTime();//获取当前时间
    var pertime = (nt-ot)/1000; //计算出上次调用该方法时到现在的时间差，单位为s
    ot = new Date().getTime(); //重新赋值时间，用于下次计算
    var perload = evt.loaded - oloaded; //计算该分段上传的文件大小，单位b
    oloaded = evt.loaded;//重新赋值已上传文件大小，用以下次计算
    //上传速度计算
    var speed = perload/pertime;//单位b/s
    var bspeed = speed;
    var units = 'b/s';//单位名称
    if(speed/1024>1){
        speed = speed/1024;
        units = 'k/s';
    }
    if(speed/1024>1){
        speed = speed/1024;
        units = 'M/s';
    }
    speed = speed.toFixed(1);
    //剩余时间
    var resttime = ((evt.total-evt.loaded)/bspeed).toFixed(1);
    time.innerHTML = '，速度：'+speed+units+'，剩余时间：'+resttime+'s';
    if(bspeed==0) time.innerHTML = '上传已取消';
    }


function allselect(){
    var checked = document.getElementById("check").checked;
    var checkson = document.getElementsByName("filelist");
    if(checked){
        for(var i = 0; i < checkson.length ;i++){
            checkson[i].checked = true;
        }
    }else{
        for(var i = 0; i < checkson.length ;i++){
            checkson[i].checked = false;
        }
    }
}

function share(){
    var table=document.getElementById('showfile');
    var checkson = document.getElementsByName("filelist");
    for(var i = 0; i<10; i++)
    {
    var tr =document.createElement("tr");
    var td1 =document.createElement("td");
    var td2 =document.createElement("td");
    var td3 =document.createElement("td");
    var td4 =document.createElement("td");
    var td5 =document.createElement("td");
    var checkBox=document.createElement("input");  
    checkBox.setAttribute("type","checkbox");  
    checkBox.setAttribute("value","n");
    checkBox.setAttribute("name","filelist");
    td2.setAttribute("name","fname");
    tr.setAttribute("id","showfile");
        td1.appendChild(checkBox);
        td2.innerHTML=i.toString();
        td3.innerHTML='a'+i.toString();
        td4.innerHTML='b'+i.toString();
        td5.innerHTML='c'+i.toString();
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        table.appendChild(tr);
    }
    document.getElementById("count").innerHTML="已全部加载，共"+checkson.length.toString()+"个文件";
}
function rename(){
     var file_back = document.getElementById("file_back");
     var back=document.getElementById("name");
     back.style.display="block";
    file_back.style.display = "block";
    var table=document.getElementById('ns');
    var checkson = document.getElementsByName("filelist");
    var n = document.getElementsByName("fname");
    var i=0;
    for(i=0;i<checkson.length;i++){
        if(checkson[i].checked == true){
            var tr =document.createElement("tr");
            var td1 =document.createElement("td");
            var td2 =document.createElement("td");
            var td3 =document.createElement("td");
            var td4 =document.createElement("td");
            var td5 =document.createElement("td");
            var inputt=document.createElement("input");
            inputt.setAttribute("type","text");
            inputt.setAttribute("id","nname");
            var ip1=document.createElement("input");
            ip1.setAttribute("type","button");
            ip1.setAttribute("onclick","yes(this)");
            ip1.setAttribute("value","确定");
            var ip2=document.createElement("input");
            ip2.setAttribute("type","button");
            ip2.setAttribute("onclick","no(this)");
            ip2.setAttribute("value","取消");
            td1.innerHTML="原文件名：";
            td2.innerHTML=n[i].innerHTML;
            td3.innerHTML="修改文件名：";
            td4.appendChild(inputt);
            td5.appendChild(ip1);
            td5.appendChild(ip2);
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
            table.appendChild(tr);
        }
    }
   
}

function yes(obj){
    var parentTr=obj.parentNode.parentNode;
    var td=parentTr.getElementsByTagName('td');
    var parentTable = parentTr.parentNode;
    var fname=document.getElementsByName("fname");
    for(i=0;i<fname.length;i++){
        if(fname[i].innerHTML == td[1].innerHTML){
           var txt=td[3].value;
    fname[i].innerHTML=txt;
        }
    }
    parentTable.removeChild(parentTr);
    if(parentTable.rows[0]==null) {
        var file_back = document.getElementById("file_back");
     var back=document.getElementById("name");
     back.style.display="none";
    file_back.style.display = "none";
    }
}

function no(obj){
    var parentTr=obj.parentNode.parentNode;
    var parentTable = parentTr.parentNode;
    parentTable.removeChild(parentTr);
        if(parentTable.rows[0]==null) {
        var file_back = document.getElementById("file_back");
     var back=document.getElementById("name");
     back.style.display="none";
    file_back.style.display = "none";
    }
}

