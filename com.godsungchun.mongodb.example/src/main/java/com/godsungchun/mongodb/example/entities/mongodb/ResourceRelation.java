package com.godsungchun.mongodb.example.entities.mongodb;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Dream on 2016-11-15.
 */
@QueryEntity
@Document
public class ResourceRelation implements Serializable {
	private static final long serialVersionUID = 3852728229006127439L;
	
	@Id
	private String id;
	
	@Indexed
	private String sourceId;
	
	@DBRef
	private BlogContents sourceContents;
	
	@Indexed
	private String targetId;
	
	@DBRef
	private BlogContents targetContents;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSourceId() {
		return sourceId;
	}
	
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	
	public BlogContents getSourceContents() {
		return sourceContents;
	}
	
	public void setSourceContents(BlogContents sourceContents) {
		this.sourceContents = sourceContents;
	}
	
	public String getTargetId() {
		return targetId;
	}
	
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	public BlogContents getTargetContents() {
		return targetContents;
	}
	
	public void setTargetContents(BlogContents targetContents) {
		this.targetContents = targetContents;
	}
}
