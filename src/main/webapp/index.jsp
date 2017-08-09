<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>浮生若梦亦如烟Demo</title>

<!-- 引入Easy UI依赖的 JQuery 文件 -->
<script type="text/javascript" src="jslib/jquery-easyui-1.5.2/jquery.min.js"></script>
<!-- 引入Easy UI 文件 -->
<script type="text/javascript" src="jslib/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<!-- 引入Easy UI 的国际化文件 -->
<script type="text/javascript" src="jslib/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src='jsutil/qshengUtils.js'></script>
<!-- 引入EasyUI 的 CSS 样式文件 -->
<link rel="stylesheet" href="jslib/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"></link>
<!-- 引入Easy UI 的图标文件 -->
<link rel="stylesheet" href="jslib/jquery-easyui-1.5.2/themes/icon.css" type="text/css"></link>

</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:150px"></div>
	<div data-options="region:'south',split:true" style="height:100px;"></div>
	<div data-options="region:'east',split:true" title="East" style="width:200px;"></div>
	<div data-options="region:'west',split:true" style="width:200px;">
		<div class="easyui-panel" data-options="title:'测试-西',border:false,fit:true"></div>
	</div>
	<div data-options="region:'center',title:'Center'"></div>

	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/register.jsp"></jsp:include>
	
</body>
</html>
