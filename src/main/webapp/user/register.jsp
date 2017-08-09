<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		var pathName = window.document.location.pathname;
		var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		$('#user_register_registerForm').form({
			url : projectName + '/userAction!register.action',
			data : {
				name : $('#user_register_registerForm input[name=name]').val(),
				pwd : $('#user_register_registerForm input[name=pwd1]').val()
			},
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if (obj.success == true) {
					$.messager.show({
						title : '提示：',
						msg : '注册成功！',
					});
					$('#user_register_registerDialog').dialog('close');
					$('#user_login_loginDiv').dialog('open');
				} else {
					$.messager.show({
						title : '提示：',
						msg : '注册失败！！！',
					});
				}
				console.info(data);
			}
		});
	});
</script>







<div id="user_register_registerDialog" class="easyui-dialog" style="widtd: 250px;" data-options="modal:true,closed:true,closable:false,title:'注册',buttons:[{
				text:'注册',
				//可以设置LOGO
				iconCls:'icon-edit',
				handler:function(){
					$('#user_register_registerForm').submit();
				}
			}]">
	<form id="user_register_registerForm" method="post">
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
				<td><input name="pwd2" type="password" class="easyui-validatebox" data-options="required:true,validType:'equalsPwd[\'#user_register_registerForm input[name=pwd1]\']',missingMessage:'密码为必填项'" /></td>
			</tr>
		</table>
	</form>
</div>
