package kr.co.leem.jpa.example.constants;

/**
 * Created by Dream on 2016-06-20.
 */
public class Result {
	public enum ResultType {
		resultCode,
		row,
		rowByJpa,
		rowByJpql,
		rows,
		rowsByMethodName,
		rowsByJpa,
		rowsByPageable,
		rowsByJpql,
		rowsByBasic
	}

	public enum ResultValue {
		success,
		fail
	}
}
