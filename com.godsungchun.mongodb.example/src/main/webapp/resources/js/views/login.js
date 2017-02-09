/**
 * Created by Dream on 2016-11-16.
 */
var login = {
	setEvent: function () {
		var self = this;
		
		$('#btnLogin').on("click", function(){
			loginRestApi.proc();
		});
		
		$('#pwd').on('keypress', function (e) {
			if (e.which == 13) {
				$('#btnLogin').click();
			}
		});
		
		$('#loginId').on('keypress', function (e) {
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
				console.log(arr);
				console.log($form);
			},
			success: function (data) {
				if (data['resultCode'] == 'success') {
					location.href = self.contextPath + '/admin/dashboard/index';
				} else {
					alert("아이디 또는 비밀번호가 올바르지 않습니다.");
				}
			},
			error: function (error) {
				console.log(error)
				alert('서버와의 통신중에 오류가 발생했습니다.');
			}
		});
	}
};