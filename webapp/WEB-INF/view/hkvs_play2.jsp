<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>   
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
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>新增摄像头</title>

</head>
<body>
<div class="left">
	<div id="divPlugin" class="plugin"></div>

	<fieldset class="login">
		<legend>选择摄像头</legend>
		<table cellpadding="0" cellspacing="3" border="0">
			<tr>
				<td class="tt">摄像机描述</td>
				<td><select id="loginip"  class="sel2" onchange="Login_vs();" >
				<option value="10000">请选择</option> 
				    <c:forEach items="${sl}" var="decc" varStatus="status">
				     <option value="${status.index + 1}">${decc.devScipt}</option> 
				    </c:forEach>
				     </select>
				</td>
	

			</tr>

			<tr>
				<td>
					窗口分割数&nbsp;
					<select class="sel2" onchange="changeWndNum(this.value);">
						<option value="1">1x1</option>
						<option value="2" selected>2x2</option>
						<option value="3">3x3</option>
						<option value="4">4x4</option>
					</select>
				</td>
			</tr>


		</table>
	</fieldset>
</div>
<div class="left">
	<fieldset class="preview">
		<legend>操作设备</legend>
		<table cellpadding="0" cellspacing="3" border="0">
			<tr>
				
				<td>
					<input type="button" class="btn" value="开始预览" onclick="StartRealPlay_vs();" />
					<input type="button" class="btn" value="停止预览" onclick="clickStopRealPlay();" />
				</td>
			</tr>

			<tr>
				<td colspan="3">
					<input type="button" class="btn" value="抓图" onclick="clickCapturePic();" />
					<input type="button" class="btn" value="开始录像" onclick="clickStartRecord();" />
					<input type="button" class="btn" value="停止录像" onclick="clickStopRecord();" />
				</td>
			</tr>

		</table>
	</fieldset>
	<fieldset class="ptz">
		<legend>云台控制</legend>
		<table cellpadding="0" cellspacing="3" border="0" class="left">
			<tr>
				<td>
					<input type="button" class="btn" value="左上" onmousedown="mouseDownPTZControl(5);" onmouseup="mouseUpPTZControl();" />
					<input type="button" class="btn" value="上" onmousedown="mouseDownPTZControl(1);" onmouseup="mouseUpPTZControl();" />
					<input type="button" class="btn" value="右上" onmousedown="mouseDownPTZControl(7);" onmouseup="mouseUpPTZControl();" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="btn" value="左" onmousedown="mouseDownPTZControl(3);" onmouseup="mouseUpPTZControl();" />
					<input type="button" class="btn" value="自动" onclick="mouseDownPTZControl(9);" />
					<input type="button" class="btn" value="右" onmousedown="mouseDownPTZControl(4);" onmouseup="mouseUpPTZControl();" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="btn" value="左下" onmousedown="mouseDownPTZControl(6);" onmouseup="mouseUpPTZControl();" />
					<input type="button" class="btn" value="下" onmousedown="mouseDownPTZControl(2);" onmouseup="mouseUpPTZControl();" />
					<input type="button" class="btn" value="右下" onmousedown="mouseDownPTZControl(8);" onmouseup="mouseUpPTZControl();" />
				</td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="3" border="0" class="left">
			<tr>
				<td class="tt">云台速度</td>
				<td>
					<select id="ptzspeed" class="sel">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option selected>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
					</select>
				</td>
			</tr>
			
		
		</table>
        <table cellpadding="0" cellspacing="3" border="0" class="left">
            <tr>
                <td class="tt"><input type="button" class="btn2" value="变倍+" onmousedown="PTZZoomIn()" onmouseup="PTZZoomStop()"></td>
                <td><input type="button" class="btn2" value="变倍-" onmousedown="PTZZoomout()" onmouseup="PTZZoomStop()"></td>
            </tr>
            <tr>
                <td class="tt"><input type="button" class="btn2" value="变焦+" onmousedown="PTZFocusIn()" onmouseup="PTZFoucusStop()"></td>
                <td><input type="button" class="btn2" value="变焦-" onmousedown="PTZFoucusOut()" onmouseup="PTZFoucusStop()"></td>
            </tr>
            <tr>
                <td class="tt"><input type="button" class="btn2" value="光圈+" onmousedown="PTZIrisIn()" onmouseup="PTZIrisStop()"></td>
                <td><input type="button" class="btn2" value="光圈-" onmousedown="PTZIrisOut()" onmouseup="PTZIrisStop()"></td>
            </tr>
        </table>
	</fieldset>
	<fieldset class="playback">
		<legend>回放</legend>
		<table width="100%" cellpadding="0" cellspacing="3" border="0">
			<tr>
				<td class="tt">开始时间</td>
				<td>
					<input id="starttime" type="text" class="txt" value="2017-05-10 00:00:00" />（时间格式：2017-05-10 12:34:56）
				</td>
			</tr>
			<tr>
				<td class="tt">结束时间</td>
				<td>
					<input id="endtime" type="text" class="txt" value="2013-12-11 23:59:59" />
					<input type="button" class="btn" value="搜索" onclick="clickRecordSearch(0);" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="searchdiv">
						<table id="searchlist" class="searchlist" cellpadding="0" cellspacing="0" border="0"></table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" class="btn2" value="开始回放" onclick="clickStartPlayback();" />
					<input type="button" class="btn2" value="停止回放" onclick="clickStopPlayback();" />
					<input type="button" class="btn" value="倒放" onclick="clickReversePlayback();" />
					<input type="button" class="btn" value="单帧" onclick="clickFrame();" />
					<input id="transstream" type="checkbox" class="vtop" />&nbsp;启用转码码流
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" class="btn" value="暂停" onclick="clickPause();" />
					<input type="button" class="btn" value="恢复" onclick="clickResume();" />
					<input type="button" class="btn" value="慢放" onclick="clickPlaySlow();" />
					<input type="button" class="btn" value="快放" onclick="clickPlayFast();" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" class="btn" value="抓图" onclick="clickCapturePic();" />
					<input type="button" class="btn2" value="开始剪辑" onclick="clickStartRecord();" />
					<input type="button" class="btn2" value="停止剪辑" onclick="clickStopRecord();" />
					<input type="button" class="btn2" value="OSD时间" onclick="clickGetOSDTime();" />&nbsp;<input id="osdtime" type="text" class="txt" readonly />
				</td>
			</tr>
		</table>
	</fieldset>

	<fieldset class="operate">
		<legend>操作信息</legend>
		<div id="opinfo" class="opinfo"></div>
	</fieldset>

</div>
</body>

</html>