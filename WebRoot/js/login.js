
$('form').submit(function(){
		$(this).find('input[data-validate],textarea[data-validate],select[data-validate]').trigger("blur");
		$(this).find('input[placeholder],textarea[placeholder]').each(function(){$hideplaceholder($(this));});
		var numError = $(this).find('.check-error').length;
		if(numError){
			$(this).find('.check-error').first().find('input[data-validate],textarea[data-validate],select[data-validate]').first().focus().select();
			return false;
		}
	});

function judge(){
	var account = document.getElementById("account").value;
	var pwd = document.getElementById("password").value;
	if(account.trim()==" "||pwd.trim()==""){
		alert("用户名和密码不能为空");
		return false;
	}else if(pwd.length<6){
		alert("密码长度不能小于6");
		return false;
	}
}

//自定义验证规则
form.verify({
  title: function(value){
    if(value.length < 5){
      return '标题至少得5个字符啊';
    }
  }
  ,pass: [
    /^[\S]{6,12}$/
    ,'密码必须6到12位，且不能出现空格'
  ]
  ,content: function(value){
    layedit.sync(editIndex);
  }
});


//登陆验证提示
function login(){
	layer.open({
		   title: '网页提示'
		  ,content: '用户名或密码错误'
		});    
}