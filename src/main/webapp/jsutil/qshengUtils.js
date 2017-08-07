/**
 * 
 */
$.extend($.fn.validatebox.defaults.rules, {
    equalsPwd: {
		validator: function(value,param){
			return value == $(param[0]).val();
		},
		message: '您两次输入的密码不一致'
    }
});

