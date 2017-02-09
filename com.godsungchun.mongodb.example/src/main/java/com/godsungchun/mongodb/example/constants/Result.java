package com.godsungchun.mongodb.example.constants;

/**
 * Created by Dream on 2016-06-20.
 */
public class Result {
	public enum Type {
		resultCode,
		row,
		rows,
		page,
		pages,
		total,
		current,
		record,
		isDuplicated
	}

	public enum Value {
		success,
		fail,
		emptySession
	}
}
