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

<title>新增教师</title>
</head>
<body>
<article class="page-container">
	
	<form class="form form-horizontal" id="form-article-add">
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第一步：插入Ukey</span></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">标识码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="name" name="name" readonly="ture">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="removeIframe();" class="btn btn-primary radius" type="button">&nbsp;&nbsp;读取&nbsp;&nbsp;</button>
			</div>
		</div>

		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第二步：绑定账号</span></div>
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"></th>
					<th width="40">ID</th>
					<th width="100">用户名</th>
					<th width="80">申请邮箱</th>
					<th width="80">申请机构名</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td><input type="radio" value="1" name="items" /></td>
					<td>1</td>
					<td>qqsmko</td>
					<td>qqsmko@sina.com</td>
					<td>测试教育机构</td>			
				</tr>
				<tr class="text-c">
					<td><input type="radio" value="1" name="items" /></td>
					<td>2</td>
					<td>asdf</td>
					<td>asdf@sina.com</td>
					<td>ASDF教育</td>			
				</tr>
			</tbody>
		</table>

		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第三步：分配权限</span></div>
		<input type="checkbox" checked="true"> 身份证读取
		<input type="checkbox" checked="true"> 身份证修改
		<input type="checkbox" checked="true"> 学生读取
		<input type="checkbox" checked="true"> 学生登记
		<input type="checkbox" checked="true"> 学生编辑
		<input type="checkbox" checked="true"> 学生删除
		<input type="checkbox" checked="true"> 考勤打卡
		<input type="checkbox" checked="true"> 教师读取
		<input type="checkbox" checked="true"> 教师登记
		<input type="checkbox" checked="true"> 教师编辑
		<input type="checkbox" checked="true"> 教师删除
		<br>
		<input type="checkbox" checked="true"> 课程读取
		<input type="checkbox" checked="true"> 课程登记
		<input type="checkbox" checked="true"> 课程编辑
		<input type="checkbox" checked="true"> 课程删除
		<input type="checkbox" checked="true"> 班次读取
		<input type="checkbox" checked="true"> 班次登记
		<input type="checkbox" checked="true"> 班次编辑
		<input type="checkbox" checked="true"> 班次删除
		<input type="checkbox" checked="true"> 班级读取
		<input type="checkbox" checked="true"> 班级登记
		<input type="checkbox" checked="true"> 班级编辑
		<br>
		<input type="checkbox" checked="true"> 班级删除
		<input type="checkbox" checked="true"> 班级提交审核
		<input type="checkbox" checked="true"> 考勤查看
		<input type="checkbox" checked="true"> 结业查看
		<input type="checkbox" checked="true"> 结业确认
		<input type="checkbox" checked="true"> 台账查看
		<input type="checkbox" checked="true"> 台账编辑
		<input type="checkbox" checked="true"> 台账删除
		<input type="checkbox" checked="true"> 台账提交审核
		<input type="checkbox" checked="true"> ukey签字
		<br>
		<br>
		<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
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
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	//表单验证
	$("#form-article-add").validate({
		rules:{
			name:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
		  	var options = {  
                type: 'GET',//提交方式  
                url:  'teacher-add/submit',
                contentType:'application/json;charset=UTF-8',
                success: function() {
                	var index = parent.layer.getFrameIndex(window.name);
					parent.location.replace(parent.location.href)
					parent.layer.close(index);
					removeIframe();
                }   
            };
			$(form).ajaxSubmit(options);
		}
	});
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;

	var uploader = WebUploader.create({
		auto: true,
		swf: 'lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: 'fileupload.php',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#filePicker',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}
	});
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="pic-box"><img></div>'+
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传...</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}
	
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress-box').fadeOut();
	});
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
	
	var ue = UE.getEditor('editor');
	
});

/*function article_save_submit(){
	alert(${add});
	removeIframe();
}*/

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>