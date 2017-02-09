/**
 * Created by Dream on 2016-11-18.
 */
var jqGridComponent = {
	show: function (gridParams) {
		console.log(gridParams.gridId)
		$(gridParams.gridId).jqGrid({
			url: gridParams.url,
			datatype: objectUtils.isEmpty(gridParams.url) ? "local" : "json",
			data: objectUtils.isNotEmpty(gridParams.localData) ? gridParams.localData : undefined,
			postData: gridParams.postDataParams,
			colModel: gridParams.colModels,
			onSelectRow: gridParams.onSelectRow,
			ondblClickRow: gridParams.ondblClickRow,
			gridComplete: gridParams.gridComplete,
			rowNum: gridParams.rowNum,
			pager: gridParams.gridPagerId,
			autowidth: gridParams.autowidth,
			height: gridParams.height,
			viewrecords: false,
			loadonce: objectUtils.isEmpty(gridParams.url) ? true : false,
			jsonReader: gridParams.jsonReader,
			recordpos: 'left',
			rownumbers: false,
			rownumWidth: gridParams.rownumWidth,
			caption: gridParams.caption,
			styleUI : 'Bootstrap'
		}).navGrid(gridParams.gridPagerId, {view: false,edit: false,add: false,del: false,search: false, refresh: false});
		
		if (gridParams.groupHeaders != null) {
			$(gridParams.gridId).jqGrid('setGroupHeaders', {
				useColSpanStyle: true,
				groupHeaders: gridParams.groupHeaders
			});
		}
	}
};
