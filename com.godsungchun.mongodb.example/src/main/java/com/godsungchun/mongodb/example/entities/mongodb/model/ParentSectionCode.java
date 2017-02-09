package com.godsungchun.mongodb.example.entities.mongodb.model;

import java.util.List;

/**
 * Created by Dream on 2017-01-24.
 */
public class ParentSectionCode {
	private String key;
	private String title;
	private String code;
	private String code1;
	private String code2;
	private String parentCode;
	private Boolean enabled;
	private List<ChildSectionCode> children;
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode1() {
		return code1;
	}
	
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	
	public String getCode2() {
		return code2;
	}
	
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	public String getParentCode() {
		return parentCode;
	}
	
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<ChildSectionCode> getChildren() {
		return children;
	}
	
	public void setChildren(List<ChildSectionCode> children) {
		this.children = children;
	}
}
