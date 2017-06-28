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

		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
		 <a class="btn btn-primary radius" data-title="添加机构" data-href="hanvondev-add.html" onclick="Hui_admin_tab(this)" href="javascript:;">
		 <i class="Hui-iconfont">&#xe600;</i> 添加人脸设备</a></span></span> <!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> </div>
		<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="">设备编码</th>
					<th width="">所属机构</th>
					<th width="">所在教室</th>
					<th width="">设备IP</th>
					<th width="">子俺码</th>
					<th width="">网关地址</th>					
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			 <c:forEach items="${sl}" var="s" varStatus="st">
					<tr class="text-c">
						<td><input type="checkbox" value="${s.institutHao}" name="items"></td>
						<td>${s.sn}</td>
						<td>
						<c:forEach items="${s2}" var="s2" varStatus="st2">
						<c:if test="${s.institutHao==s2.institutionsId}">
						${s2.institutionsName}
						</c:if>
						</c:forEach>
						</td>
						<td>${s.classId}</td>
						<td>${s.ip}</td>
						<td>${s.subnetmask}</td>
						<td>${s.gateip}</td>
						
						
						
					</tr>
				</c:forEach>		
				</tbody>
		</table>
		</div>
	</div>

	<jsp:include page="foot_.jsp" />

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
	<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	
	</body>
	</html>