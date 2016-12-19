package com.godsungchun.spring.commons.constants;

/**
 * Created by Dream on 2016-12-12.
 */
public class Result {
	public enum Code {
		resultCode,
		row,
		rows
	}
	
	public enum Value {
		success,
		fail,
		maximumExceeded,
		invalidIdOrPassword
	}
}
