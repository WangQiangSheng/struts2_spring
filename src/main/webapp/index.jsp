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

<script type="text/javascript">
	$(function(){
		var pathName=window.document.location.pathname;
		var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);

		

		//var item2 = ${pageContext.request.contextPath};
		//var item2 = ${pageContext.request.contextPath};
		//$('#index_registerForm').submit();
		$('#index_registerForm').form({
		    url:projectName+'/userAction!register.action',
		    data:{
		    	name:$('#index_registerForm input[name=name]').val(),
		    	pwd:$('#index_registerForm input[name=pwd1]').val()
		    },
		    success:function(data){
		    	var obj = jQuery.parseJSON(data);
		    	if(obj.success == true){
		    		$.messager.show({
		    			title:'提示：',
		    			msg:'注册成功！',
		    		});
		    	}else{
		    		$.messager.show({
		    			title:'提示：',
		    			msg:'注册失败！！！',
		    		});
		    	}
		    	console.info(data);
		    }
		});
	});

</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:150px"></div>
	<div data-options="region:'south',split:true" style="height:100px;"></div>
	<div data-options="region:'east',split:true" title="East" style="width:200px;"></div>
	<div data-options="region:'west',split:true" style="width:200px;">
		<div class="easyui-panel" data-options="title:'测试-西',border:false,fit:true"></div>
	</div>
	<div data-options="region:'center',title:'Center'"></div>

	

	<div id="index_registerDialog" class="easyui-dialog" style="widtd:250px;" data-options="modal:true,closed:true,closable:false,title:'注册',buttons:[{
				text:'注册',
				//可以设置LOGO
				iconCls:'icon-edit',
				handler:function(){
					$('#index_registerForm').submit();
				}
			}]">
		<form id="index_registerForm" method="post">
			<table>
				<tr>
					<th>请输入账号：</th>
					<td><input name="name" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'账号为必填项'" /></td>
				</tr>
				<tr>
					<th>请输入密码：</th>
					<td><input name="pwd1" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码为必填项'" /></td>
				</tr>
				<tr>
					<th>请再输密码：</th>
					<td><input name="pwd2" type="password" class="easyui-validatebox" data-options="required:true,validType:'equalsPwd[\'#index_registerForm input[name=pwd1]\']',missingMessage:'密码为必填项'" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
