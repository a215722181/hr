<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>左侧导航</title>
		<link rel="stylesheet" href="js/bootstrap/css/bootstrap.css" />
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			body {
				background: #333;
			}
			/*头像区*/
			
			.touxiang {
				width: 150px;
				height: 150px;
				border-radius: 50%;
				overflow: hidden;
				margin: 20px auto;
				border: 5px solid #fff;
			}
			
			/*导航链接*/
			.list-group-item {
				padding: 0;
				background: transparent;
				border: none;
				border-radius: 0 !important;
				text-align: center;
				color: #eee !important;
				font-size: 16px;
				line-height: 40px;
				letter-spacing: 1px;
				border-top: 1px solid #444;
			}
			
			.list-group-item:hover {
				color: #000 !important;
			}
			
			/*折叠菜单*/
			.panel {
				background: transparent !important;
				color: #eee !important;
				text-align: center;
			}
			
			.panel a {
				display: block;
				color: #EEEEEE;
				text-decoration: none;
				line-height: 30px;
			}
			
			.panel-body {
				padding: 0;
				border: 0 !important;
			}
			
			.panel-group {
				margin: 0 !important;
			}
		</style>
	</head>

	<body>

		<div class="container-fluid">

			<!--头像区开始-->
			<div class="row touxiang">
				<a href="UpdateHead.html" title="点击修改用户头像" target="content">
					<img id="empPic" src="images/default_head.jpg" class="img-responsive" />
				</a>
			</div>
			<!--头像区结束-->

			<p class="text-center" style="color: #eee;">
				欢迎您，${sessionScope.empLoginName}
			</p>

			<!--导航链接开始-->
			<div class="row">
				<div class="list-group">
					
					<!--折叠菜单-->
					<div class="panel-group" id="accordion">
						<!--面板1-->
						<div class="panel">
							<!--面板标题-->
							<div class="panel-heading">
								<h4 class="panel-title">
									
			                    	<a href="#one" data-toggle="collapse">
			                    		<span class="glyphicon glyphicon-bed"></span>
			                    		实用工具
			                    	</a>
			                    </h4>
							</div>
							<!--面板内容-->
							<div id="one" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#" target="content">天气查询</a>
									<a href="Cons.html" target="content">星座运势</a>
									<a href="#" target="content">手机号码归属地</a>
									<a href="#" target="content">IP查询</a>
								</div>
							</div>
						</div>
					</div>
					
					<a href="QueryDept.html" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-send"></span>
						部门管理
					</a>

					<a href="QueryJob.html" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-leaf"></span> 
						职务管理
					</a>
					
					<a href="QueryEmp.html" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-user"></span> 
						员工管理
					</a>
					
					<a href="Analyze.html" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-signal"></span> 
						数据分析
					</a>
					
					<a href="UpdateEmpPwd.html" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-wrench"></span> 
						修改密码
					</a>
					
					<a href="" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-search"></span> 
						数据检索
					</a>
					
					<a href="QueryPic.html" class="list-group-item" target="content">
						<span class="glyphicon glyphicon-picture"></span> 
						公司图库
					</a>
					
					<a href="logout.jsp" class="list-group-item" target="_top">
						<span class="glyphicon glyphicon-log-out"></span> 
						退出登录
					</a>
				</div>
			</div>
			<!--导航链接结束-->

		</div>

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/global.js"></script>
		<script type="text/javascript" src="js/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="js/layer/layer.js"></script>
		
		<script>
			$(function() {
				
				//用户如果有头像数据，显示用户头像
				$.get(baseUrl + '/GetEmpPicServlet',function(data) {
					
					if (data && data != 'null') {
						$('#empPic').attr('src',data);
					}
					
				})
				.error(function() {
					layer.msg('请求头像数据失败');
				});
				
			});
		</script>
	</body>

</html>