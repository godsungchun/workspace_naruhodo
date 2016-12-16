/**
 * Created by Dream on 2016-11-18.
 */
var accountIndex = {
	setEvent: function () {
		
	}
};

var accountRestApi = {
	contextPath: null,
	getParams: function () {
		var self = this;
		
		var gridParams = {
			gridId : '#accountGrid',
			gridPagerId: '#accountGridPageable',
			url : self.contextPath + '/rest/account/findAll',
			colModels : [
				{label: 'ID', name : 'id', index : 'id', align : 'center', width : 120, sortable : false, hidden : true},
				{label: '이름', name : 'name', index : 'name', align : 'center', width : 150, sortable : false, hidden : false},
				{label: '계정', name : 'loginId', index : 'loginId', align : 'center', width : 150, sortable : false},
				{label: '이메일', name : 'email', index : 'enabled', align : 'center', width : 300},
				{label: '생성일', name : 'createdDate', index : 'createdDate', align : 'center', width : 150, formatter: gridFormatter.longToDate},
			],
			postDataParams : {},
			rowNum : 20,
			ondblClickRow : null,
			onSelectRow : function (id) {
				var rowData = $('#accountGrid').getRowData(id);
				accountRestApi.findOne(id);
				
			},
			ondblClickRow : function (ids) {
				
			},
			autowidth : true,
			groupHeaders : null,
			height : 300
		};
		
		return gridParams;
	},
	findAll: function () {
		var self = this;
		jqGridComponent.show(self.getParams());
	},
	findOne: function (id) {
		var self = this;
		
		$.ajax({
			url: self.contextPath + '/rest/account/findOne',
			contentType: 'application/json; charset=utf-8',
			type: 'POST',
			data: JSON.stringify({id: id}),
			dataType: "json",
			success: function (data) {
				var row = data['row'];
				self.editAccount(row);
			},
			error: function (error) {
				console.log(error);
			}
		});
	},
	editAccount: function (row) {
		var self = this;
		
		BootstrapDialog.show({
			message: $('<div></div>').load('/account/popup/edit'),
			onshown: function(){
				$('#hnnAccountId').val(row['id']);
				$('#txtLoginId').val(row['loginId']);
				$('#txtName').val(row['name']);
				$('#txtEmail').val(row['email']);
			},
			buttons: [
				{
					label: 'Save',
					cssClass: 'btn-primary',
					action: function(dialogItself) {
						self.save(dialogItself);
					}
				},
				{
					label: 'Close',
					// no title as it is optional
					action: function(dialogItself){
						dialogItself.close();
					}
				}
			]
		});
	},
	save: function (dialogItself) {
		var params = {
			loginId: $('#txtLoginId').val(),
			email: $('#txtEmail').val(),
			name: $('#txtName').val(),
			createdDate: null,
			createByName: null,
			lastModifiedByName: null,
			lastModifiedDate: null
		}
		
		$.ajax({
			url: self.contextPath + '/rest/account/findOne',
			contentType: 'application/json; charset=utf-8',
			type: 'POST',
			data: JSON.stringify(params),
			dataType: "json",
			success: function (data) {
				dialogItself.close();
			},
			error: function (error) {
				console.log(error);
			}
		});
	}
};