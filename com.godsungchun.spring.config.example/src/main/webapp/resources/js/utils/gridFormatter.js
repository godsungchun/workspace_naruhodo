/**
 * Created by Dream on 2016-11-25.
 */
var gridFormatter = {
	longToDate: function (cellValue, options, rowObject) {
		if (objectUtils.isEmpty(cellValue)) {
			return '';
		}
		
		var date = new Date(cellValue);
		var defaultDateFormat = 'yyyy-MM-dd hh:mm:ss';
		
		if (objectUtils.isNotEmpty(options.colModel.formatoptions) && objectUtils.isNotEmpty(options.colModel.formatoptions.dateFormat)) {
			defaultDateFormat = options.colModel.formatoptions.dateFormat;
		}
		
		return $.format.date(date, defaultDateFormat);
	}
};