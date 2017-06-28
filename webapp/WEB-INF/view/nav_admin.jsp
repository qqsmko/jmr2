<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml"><%=request.getParameter("nav_name")%><a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs"><%=request.getParameter("nav_version")%></span> 
				<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
				<nav class="nav navbar-nav">
					<ul class="cl">
						<!-- <li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a></li>
								<li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>
								<li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>
								<li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
						</ul> -->
						<% 
							String str = request.getParameter("page");
							String ans = "null";
							if(str.equals("page1")){
								ans = "<li class=\"current\"><a href=\"?page=page1\">监管机构管理</a></li><li><a href=\"?page=page2\">系统维护</a></li>";
							}else if(str.equals("page2")){
								ans = "<li><a href=\"?page=page1\">监管机构管理</a></li><li class=\"current\"><a href=\"?page=page2\">系统维护</a></li>";
							}
						%>
						<%=ans%>
						<!-- <li class="current"><a href="?page=page1">培训机构管理</a></li>
						<li><a href="?page=page2">监管机构管理</a></li>
						<li><a href="?page=page3">系统维护</a></li> -->
					</li>
				</ul>
			</nav>
				<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
						<li><%=request.getParameter("nav_type")%></li>
						<li class="dropDown dropDown_hover">
							<a href="#" class="dropDown_A"><%=request.getParameter("nav_id")%> <i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
	<!-- 							<li><a href="#">切换账户</a></li> -->
								<li><a href="#">退出</a></li>
						</ul>
				</ul>
			</nav>
		</div>
	</div>
</header>