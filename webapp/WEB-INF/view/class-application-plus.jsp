<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 培训机构 <span class="c-gray en">&gt;</span> 培训班级管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量撤回</a> <a class="btn btn-primary radius" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 批量申请</a></div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">id</th>
				<th width="100">所属机构</th>
				<th width="">班级名称</th>
				<th width="80">所属机构</th>
				<th width="80">申请状态</th>
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
		"searching": true,
		"ordering": false,
		"serverSide": true,
		"ajax": {
			"url":"class-application-plus/data-source",
			"type":"POST",
		},
		"columns":[
			{
				"data":"class_id",
				"render":function(data, type, row, meta) {
        			return '<td><input type="checkbox" value="'+data+'" name="items"></td>'
    			}
			},
			{"data":"class_id"},
	        {"data":"institutions_name"},
	        {"data":"class_name"},
	        {"data":"institutions_name"},
	        {
				"data":"state",
				"render":function(data, type, row, meta) {
        			if(data == 0){
        				return '<td class="td-status"><span class="label label-defaunt radius">未申请</span></td>'
        			}else if(data ==1){
        				return '<td class="td-status"><span class="label label-primary radius">待审核</span></td>'
        			}else if(data ==2){
        				return '<td class="td-status"><span class="label label-danger radius">已驳回</span></td>'
        			}else if(data >=3){
        				return '<td class="td-status"><span class="label label-success radius">已通过</span></td>'
        			}else{
        				return '<td>错误</td>'
        			}
    			}
			},
	        {
    			"data":null,
	        	"render":function(data, type, row, meta) {
	        		if(row.state == 1){
        				return '<td class="td-manage"><a title="ti" href="javascript:;" onclick="member_start(this,'+row.class_id+')" class="ml-5" style="text-decoration:none">通过</a></td><td class="td-manage"><a title="ti" href="javascript:;" onclick="member_bad(this,'+row.class_id+')" class="ml-5" style="text-decoration:none">驳回</a></td>'
    				}else{
    					return '<td></td>'	
    				}
    			}
    		},
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
	layer.confirm('确认要撤回吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">未审核</span>');
				$(obj).remove();
				layer.msg('已停用!',{icon: 5,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要通过吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'class-application-plus',
			dataType: 'json',
			data:{
				id:id,
				ok:true
			},
			success: function(data){
				layer.msg('已通过',{icon: 6,time:1000});
				javascript:location.replace(location.href);
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}

/*用户-驳回*/
function member_bad(obj,id){
	layer.confirm('确认要驳回吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'class-application-plus',
			dataType: 'json',
			data:{
				id:id,
				ok:false
			},
			success: function(data){
				layer.msg('已通过',{icon: 6,time:1000});
				javascript:location.replace(location.href);
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
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
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
</script> 
</body>
</html>