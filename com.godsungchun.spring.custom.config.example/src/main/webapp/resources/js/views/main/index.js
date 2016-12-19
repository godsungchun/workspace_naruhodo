/**
 * Created by Dream on 2016-12-16.
 */

var mainIndex = {
	contextPath: null,
	isRest: false,
	setEvent: function () {
		var self = this;
		
		$('#btnLogout').click(function () {
			if (self.isRest == false) {
				$('#frmLogout').submit();
			} else {
				logoutRestApi.proc();
			}
			
		});
	}
};

var logoutRestApi = {
	contextPath: null,
	proc: function () {
		var self = this;
		
		$("#frmLogout").ajaxSubmit({
			url: self.contextPath + '/rest/auth/logout',
			type: 'post',
			beforeSubmit: function (arr, $form, options) {
				
			},
			success: function (data) {
				if (data['resultCode'] == 'success') {
					location.href = '/login';
				}
			},
			error: function (error) {
				alert('서버와의 통신중에 오류가 발생했습니다.');
			}
		});
	}
};

