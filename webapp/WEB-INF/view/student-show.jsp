<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<!--_meta 作为公共模版分离出去-->
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
<!--/meta 作为公共模版分离出去-->

<title>学生信息</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">户口性质：</label>
			<div class="formControls col-xs-8 col-sm-4">
				<input type="text" maxlength="20" class="input-text" value="${stu.cardId}" placeholder="" id="courseName" name="courseName" readonly="true">
			</div>
			<label class="form-label col-xs-4 col-sm-2">户口所在区域：</label>
			<div class="formControls col-xs-8 col-sm-4">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">银行户名：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" maxlength="20" class="input-text" value="${classes.hangyeType}" placeholder="" id="courseName" name="courseName">
			</div>
			<label class="form-label col-xs-4 col-sm-2">开户银行：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" maxlength="20" class="input-text" value="${classes.trainingMode}" placeholder="" id="majorName" name="majorName">
			</div>
			<label class="form-label col-xs-4 col-sm-2">银行账号：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" maxlength="20" class="input-text" value="${classes.trainingMode}" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">培训专业名称：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">培训工种名称：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">班期开始时间：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="${classes.startTime}" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">班期结束时间：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="${classes.endTime}" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">收费金额：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="${classes.fee}" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">是否申请职业培训补贴：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="${classes.isSubsidy}" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">补贴标准：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="${classes.subsidyNumber}" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">培训课时：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">理论课时：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">实操课时：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">培训人数：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">培训类别：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="${classes.trainingType}" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">证书类型：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="certificate" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">培训等级：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">鉴定标准：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">机构负责人：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">机构联系电话：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="courseName" name="courseName">
			</div>
		<!-- </div>
		<div class="row cl"> -->
			<label class="form-label col-xs-4 col-sm-2">就业意向：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="majorName" name="majorName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">培训地点：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="teacheringBook" name="teacheringBook">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="teacheringBook" name="teacheringBook">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(function(){
	$.fn.serializeObject = function()    
	{    
	   var o = {};    
	   var a = this.serializeArray();    
	   $.each(a, function() {    
	       if (o[this.name]) {    
	           if (!o[this.name].push) {    
	               o[this.name] = [o[this.name]];    
	           }    
	           o[this.name].push(this.value || '');    
	       } else {
	       	   if (this.value != ""){    
	           		o[this.name] = this.value || '';    
	       	   }
	       }    
	   });    
	   return o;    
	};


	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	//表单验证
	$("#form-article-add").validate({
		rules:{
			classname:{
				required:true,
			},
			applynumber:{
				required:true,
				number:true,
			},
			startdate:{
				required:true,
				date:true,
			},
			enddate:{
				required:true,
				date:true,
			},	
			remark:{
				required:true,
			},
			applyperson:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		// submitHandler:function(form){
		//   	var options = {  
  //               type: 'GET',//提交方式  
  //               url:  'class-add/submit',
  //               contentType:'application/json;charset=UTF-8',
  //               success: function() {
  //               	var index = parent.layer.getFrameIndex(window.name);
		// 			parent.location.replace(parent.location.href)
		// 			parent.layer.close(index);
		// 			removeIframe();
  //               }   
  //           };
		// 	$(form).ajaxSubmit(options);
		// }
	});

	
});

function article_save_submit(){
	var data = $("#form-article-add").serializeObject(); //自动将form表单封装成json 
	data.classId = ${classes.classId};
    alert(JSON.stringify(data));
    $.ajax({
        type: "POST",   //访问WebService使用Post方式请求
        contentType: "application/json", //WebService 会返回Json类型
        url: "class-update/submit", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
        data: JSON.stringify(data),         //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到      
        dataType: 'json',
       	success: function (result) {     //回调函数，result，返回值
            layer.msg('已修改成功!',{icon: 6,time:1000});
			var index = parent.layer.getFrameIndex(window.name);
			parent.location.replace(parent.location.href)
        }
    }); 
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>