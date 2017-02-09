package com.godsungchun.mongodb.example.entities.mongodb;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dream on 2016-08-26.
 */
@QueryEntity
@Document
public class BlogSectionCode implements Serializable {
	private static final long serialVersionUID = -6537870649693364504L;
	
	@Id
	private String id;
	
	@TextIndexed
	private String name;
	
	@Indexed
	private String code;
	
	@Indexed
	private String code1;
	
	@Indexed
	private String code2;
	
	@Indexed
	private String parentCode;
	
	private Date createdDate;
	
	private String createByName;
	
	private Date lastModifiedDate;
	
	private String lastModifiedByName;
	
	private Boolean enabled;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getCreateByName() {
		return createByName;
	}
	
	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}
	
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public String getLastModifiedByName() {
		return lastModifiedByName;
	}
	
	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
