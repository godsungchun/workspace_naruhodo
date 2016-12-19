/**
 * Created by Dream on 2016-11-16.
 */
var login = {
	isRest: false,
	setEvent: function () {
		var self = this;
		
		$('#btnLogin').on("click", function(){
			// loginRestApi.proc();
			// loginRestApi.proc();
			alert(0)
			if (self.isRest == true) {
				alert(1)
				loginRestApi.proc();
			} else {
				alert(2)
				$('#frmLogin').submit();
			}
			
		});
		
		$('#txtSignInId').on('keypress', function (e) {
			if (e.which == 13) {
				$('#btnLogin').click();
			}
		});
		
		$('#txtPwd').on('keypress', function (e) {
			if (e.which == 13) {
				$('#btnLogin').click();
			}
		});
	}
};

var loginRestApi = {
	contextPath: null,
	proc: function () {
		var self = this;
		
		$("#frmLogin").ajaxSubmit({
			url: self.contextPath + '/rest/auth/login',
			type: 'post',
			beforeSubmit: function (arr, $form, options) {
				
			},
			success: function (data) {
				if (data['resultCode'] == 'success') {
					location.href = self.contextPath + '/main/index';
				} else {
					alert("아이디 또는 비밀번호가 올바르지 않습니다.");
				}
			},
			error: function (error) {
				alert('서버와의 통신중에 오류가 발생했습니다.');
			}
		});
	}
};