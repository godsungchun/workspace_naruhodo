package com.godsungchun.mongodb.example.constants;

/**
 * Created by Dream on 2016-11-15.
 */
public class Types {
	public enum FindDate {
		created,
		lastModified
	}
	
	public enum AccountFind {
		created,
		lastModified,
		loginId,
		email
	}
	
	public enum BlogSectionCodeFind {
		created,
		lastModified,
		code,
		code1,
		codes,
		name
	}
	
	public enum BlogContentsFind {
		title,
		subTitle,
		contents,
		tags,
		approved,
		lastApprovedByName
	}
	
	public enum SectionCodeTreeFind {
		enabled
	}
}
