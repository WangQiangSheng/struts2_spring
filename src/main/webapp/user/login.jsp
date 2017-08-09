<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		var pathName = window.document.location.pathname;
		var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		$('#user_login_loginForm').form({
			url : projectName + '/userAction!login.action',
			data : {
				name : $('#user_login_loginForm input[name=name]').val(),
				pwd : $('#user_login_loginForm input[name=pwd1]').val()
			},
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if (obj.success == true) {
					$.messager.show({
						title : '提示：',
						msg : '登录成功！',
					});
				} else {
					$.messager.show({
						title : '提示：',
						msg : '登录失败！！！',
					});
				}
				console.info(data);
			}
		});
	});
</script>



<div id="user_login_loginDiv" class="easyui-dialog" data-options="modal:true,closable:false,title:'登录',buttons:[{
				text:'注册',
				handler:function(){
					$('#user_register_registerDialog').dialog('open');
					$('#user_login_loginDiv').dialog('close');
				}
			},{
				text:'登录',
				handler:function(){
					$('#user_login_loginForm').submit();
				}
			}]">
	<form id="user_login_loginForm" method="post">
		<table>
			<tr>
				<th>账号：</th>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<th>密码：</th>
				<td><input name="pwd1" /></td>
			</tr>
		</table>
	</form>
</div>
