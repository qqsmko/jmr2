<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  

<!DOCTYPE HTML>
<html>

	<jsp:include page="head_.jsp">
		<jsp:param name="title_name" value="展示页面" />
	</jsp:include>

	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理机构 <span class="c-gray en">&gt;</span> 培训机构管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	
	<div class="page-container">

		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量驳回</a> <!-- <a class="btn btn-primary radius" data-title="添加机构" data-href="student-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 批量审批</a> --></span></span> <!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> </div>
		<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="">机构编码</th>
					<th width="">机构名称</th>
					<!-- <th width="">所属区县</th> -->
					<th width="">机构负责人</th>
					<th width="">机构地址</th>
					<th width="">教职工人数</th>
					<th width="">申请时间</th>
					<th width="">批准时间</th>
					<th width="">申请人邮箱</th>
					<th width="">审批状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
		</table>
		</div>
	</div>

	<jsp:include page="foot_.jsp" />

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
	<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	$(function(){
		$('.table-sort').dataTable({
			"bStateSave": true,//状态保存
			"searching": false,
			"ordering": false,
			"serverSide": true,
			"ajax": {
				"url":"institutions-new-list/data-source",
				"type":"POST",
			},
			"columns":[
				{
					"data":"institutionsId",
					"render":function(data, type, row, meta) {
            			return '<td><input type="checkbox" value="'+data+'" name="items"></td>'
        			}
				},
		        {"data":"institutionsId"},
		        {"data":"institutionsName"},
		        // {"data":"regionid"},
		        {"data":"responsible"},
		        {"data":"address"},
		        {"data":"employeeCount"},
		        {"data":"applyDate"},
		        {"data":"approvalDate"},
		        {"data":"applyEmail"},
		        // {
		        // 	"render":function(data, type, row, meta) {
          //   			return '荆门市人社局'
        		// 	}
        		// },
        		{
        			"data":"applyState",
		        	"render":function(data, type, row, meta) {
            			if(data == 1){
            				return '<span class="label label-success radius">审核通过</span>'
            			}else if(data == 2){
            				return '<span class="label label-success radius">已驳回</span>'
            			}
            			else{
            				return '<span class="label label-primary radius">待审核</span>'
            			}
        			}
        		},
        		{
        			"data":"institutionsId",
		        	"render":function(data, type, row, meta) {
            			return '<a onClick="member_stop(this,'+data+')">审核</a><a title="驳回" href="javascript:;" onclick="member_del(this,'+data+')" class="ml-5" style="text-decoration:none">驳回</a>';
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
		layer.confirm('确认要审核吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				data:{
					id:id
				},
				dataType: 'json',
				success: function(data){
					layer.msg('已审核!',{icon: 5,time:1000});
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
				type: 'DELETE',
				url: '',
				data:{
					id:id
				},
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,${s.institutionsid})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
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
		layer.confirm('确认要驳回吗？',function(index){
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
		layer.confirm('确认要驳回吗？',function(index){
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