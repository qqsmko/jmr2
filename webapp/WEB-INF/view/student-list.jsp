<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!-- <div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div> -->
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加用户" data-href="student-add.html" onclick="member_edit('添加','student-add.html','4','','510');" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span></span> <!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">学生编号</th>
				<th width="100">学生照片</th>
				<th width="100">学生指纹</th>
				<th width="100">学生姓名</th>
				<th width="40">性别</th>
				<th width="">手机</th>
				<th width="">邮箱</th>
				<th width="">民族</th>
				<th width="">生日</th>
				<th width="50">学历</th>
				<th width="50">参保状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"searching": false,
		"ordering": false,
		"serverSide": true,
		"ajax": {
			"url":"student-list/data-source",
			"type":"POST",
		},
		"columns":[
			{
				"data":"student_id",
				"render":function(data, type, row, meta) {
        			return '<td><input type="checkbox" value="'+data+'" name="items"></td>'
    			}
			},
			{"data":"student_id"},
			{
				"data":"avatar_img",
				"render":function(data, type, row, meta) {
        			return '<img src="img/'+data+'"  alt="未采集" height="130" width="100"/>'
    			}
			},
			{
				"data":"fingerprint_img",
				"render":function(data, type, row, meta) {
        			return '<img src="img/'+data+'"  alt="未采集" height="130" width="100"/>'
    			}
			},
			{"data":"card_name"},
	        {
				"data":"gender",
				"render":function(data, type, row, meta) {
        			if(data == 1){
        				return '<td>男</td>'
        			}else if(data ==2){
        				return '<td>女</td>'
        			}else{
        				return '<td>错误</td>'
        			}
    			}
			},
	        {"data":"telephone"},
	        {"data":"email"},
	        {"data":"nation"},
	        {"data":"birthday"},
	        {
				"data":"education",
				"render":function(data, type, row, meta) {
        			if(data == 1){
        				return '<td>本科</td>'
        			}else if(data ==2){
        				return '<td>硕士</td>'
        			}else if(data ==3){
        				return '<td>博士</td>'
        			}else if(data ==4){
        				return '<td>博士后</td>'
        			}else if(data ==5){
        				return '<td>大专</td>'
        			}else if(data ==6){
        				return '<td>高中及以下</td>'
        			}else{
        				return '<td>错误</td>'
        			}
    			}
			},
			{
				"data":"insured_state",
				"render":function(data, type, row, meta) {
        			if(data == 1){
        				return '<span class="label label-success radius">已参保</span>'
        			}else if(data ==0){
        				return '<span class="label label-danger radius">未参保</span>'
        			}else{
        				return '<td>错误</td>'
        			}
    			}
			},
    		{
    			"data":"student_id",
	        	"render":function(data, type, row, meta) {
        			return '<td class="td-manage"><a title="编辑" href="javascript:;" onclick="member_edit(\'编辑\',\'teacher-update.html?id='+data+'\',\'4\',\'\',\'510\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a><a title="删除" href="javascript:;" onclick="member_del(this,'+data+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'
    			}
    		}
    	]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			data:{
				id:id
			},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,${s.studentid})" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
				$(obj).remove();
				layer.msg('已停用!',{icon: 5,time:1000});
				javascript:location.replace(location.href)
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			data:{
				id:id
			},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,${s.studentid})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!',{icon: 6,time:1000});
				javascript:location.replace(location.href)
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	var urls = window.location.href;
	urls = urls.substring(0,urls.length-5);
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: urls+'/delete',
			data:{
				id:id
			},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/*用户-批量删除*/
function datadel(){
	var text="";  
    $("input[name=items]").each(function() {  
        if ($(this).is(":checked")) {  
            text += $(this).val()+",";  
        }
    });
    if(text==""){
    	alert("请至少选择一项！");
    	return;
    }
    text = text.substring(0,text.length-1);
    data = text.split(',')
    var urls = window.location.href;
	urls = urls.substring(0,urls.length-5);
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: urls+'/deleteall',
			data:{
				ids:data
			},
			dataType: 'json',
			success: function(data){
				layer.msg('已删除!',{icon:1,time:1000});
				location.replace(location.href);
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
</script> 
</body>
</html>