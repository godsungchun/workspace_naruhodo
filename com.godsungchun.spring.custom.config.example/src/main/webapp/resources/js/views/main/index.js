/**
 * Created by Dream on 2016-12-16.
 */

var main = {
	contextPath: null,
	setEvent: function () {
		$('#btnLogout').click(function () {
			$('#frmLogout').submit();
		})
	}
};

var loginRestApi = {
	contextPath: null,
	proc: function () {
		var self = this;
		
		$("#loginForm").ajaxSubmit({
			url: self.contextPath + '/rest/auth/login',
			type: 'post',
			beforeSubmit: function (arr, $form, options) {
				
			},
			success: function (data) {
				if (data['resultCode'] == 'success') {
					location.href = '/user/getUserView';
				} else if (data['resultCode'] == 'maximumExceeded') {
					alert("이미 로그인한 사용자가 있습니다.");
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

