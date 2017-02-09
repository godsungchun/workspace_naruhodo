package com.godsungchun.mongodb.example.entities.mongodb;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Dream on 2016-08-24.
 */
@QueryEntity
@Document
public class Comment implements Serializable {
	private static final long serialVersionUID = 3193944761041216838L;

	@Id
	private String id;
	private String contents;
	private Date createDate;
	private String createByName;
	private Date lastModifiedDate;
	private String lastModifiedByName;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
}
