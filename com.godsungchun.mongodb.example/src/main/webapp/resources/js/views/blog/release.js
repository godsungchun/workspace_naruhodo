/**
 * Created by Dream on 2017-01-26.
 */
var blogRelease = {
	contextPath: null,
	getParams: function () {
		var self = this;
		
		var gridParams = {
			gridId : '#accountGrid',
			gridPagerId: '#accountGridPager',
			url : self.contextPath + '/rest/account/findAll',
			colModels : [
				{label: 'ID', name : 'id', index : 'id', align : 'center', width : 120, sortable : false, hidden : true},
				{label: '제목', name : 'name', index : 'name', align : 'center', width : 150, sortable : false, hidden : false},
				{label: '계정', name : 'loginId', index : 'loginId', align : 'center', width : 150, sortable : false},
				{label: '작성일', name : 'createdDate', index : 'createdDate', align : 'center', width : 150, formatter: gridFormatter.longToDate},
			],
			postDataParams : {},
			rowNum : 20,
			onSelectRow : function (id) {
			},
			ondblClickRow : function (id) {
				var rowData = $('#accountGrid').getRowData(id);
				accountRestApi.findOne(id);
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
	init : function () {
		blogReleaseRestApi.initTree();
	}
};

var blogReleaseRestApi = {
	contextPath: null,
	glyph_opts: {
		map: {
			doc: "glyphicon glyphicon-file",
			docOpen: "glyphicon glyphicon-file",
			checkbox: "glyphicon glyphicon-unchecked",
			checkboxSelected: "glyphicon glyphicon-check",
			checkboxUnknown: "glyphicon glyphicon-share",
			dragHelper: "glyphicon glyphicon-play",
			dropMarker: "glyphicon glyphicon-arrow-right",
			error: "glyphicon glyphicon-warning-sign",
			expanderClosed: "glyphicon glyphicon-menu-right",
			expanderLazy: "glyphicon glyphicon-menu-right",  // glyphicon-plus-sign
			expanderOpen: "glyphicon glyphicon-menu-down",  // glyphicon-collapse-down
			folder: "glyphicon glyphicon-folder-close",
			folderOpen: "glyphicon glyphicon-folder-open",
			loading: "glyphicon glyphicon-refresh glyphicon-spin"
		}
	},
	initTree: function () {
		var self = this;
		
		$.ajax({
			url: '/rest/blogSection/findAllTreeData',
			contentType: 'application/json; charset=utf-8',
			type: 'POST',
			dataType: "json",
			success: function (data) {
				var rows = data['rows'];
				
				$("#leftSectionCodeTree").fancytree({
					extensions: ["edit", "glyph", "wide"],
					checkbox: false,
					glyph: self.glyph_opts,
					selectMode: 2,
					source: rows,
					/*toggleEffect: { effect: "drop", options: {direction: "left"}, duration: 400 },*/
					wide: {
						iconWidth: "1em",     // Adjust this if @fancy-icon-width != "16px"
						iconSpacing: "0.5em", // Adjust this if @fancy-icon-spacing != "3px"
						levelOfs: "1.5em"     // Adjust this if ul padding != "16px"
					},
					activate: function (event, data) {
						alert('activate');
						console.log(data);
					}
				});
			},
			error: function (error) {
				console.log(error);
			}
		});
		
	}
};