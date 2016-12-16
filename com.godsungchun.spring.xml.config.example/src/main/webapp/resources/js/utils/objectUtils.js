/**
 * Created by Administrator on 2015-03-05.
 */
var objectUtils = {
	isEmpty: function (value) {
		return typeof value == 'undefined' || value == null || value.length < 1 ? true : false;
	},
	isNotEmpty: function (value) {
		return objectUtils.isEmpty(value) == false ? true : false;
	},
	defaultIfEmpty: function (value, defaultValue) {
		defaultValue = objectUtils.isEmpty(defaultValue) ? '' : defaultValue;
		
		return objectUtils.isEmpty(value) ? defaultValue : value
	}
	
};