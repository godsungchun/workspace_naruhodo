package com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents;

import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dream on 2016-12-30.
 */
public class ApproveProperty implements Serializable {
	private static final long serialVersionUID = 7611227956344152589L;
	
	@Indexed
	private Boolean approved = false;
	
	@Indexed
	private Date lastApprovedDate;
	
	@Indexed
	private String lastApprovedById;
	
	@Indexed
	private String lastApprovedByName;
	
	public Boolean getApproved() {
		return approved;
	}
	
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	public Date getLastApprovedDate() {
		return lastApprovedDate;
	}
	
	public void setLastApprovedDate(Date lastApprovedDate) {
		this.lastApprovedDate = lastApprovedDate;
	}
	
	public String getLastApprovedById() {
		return lastApprovedById;
	}
	
	public void setLastApprovedById(String lastApprovedById) {
		this.lastApprovedById = lastApprovedById;
	}
	
	public String getLastApprovedByName() {
		return lastApprovedByName;
	}
	
	public void setLastApprovedByName(String lastApprovedByName) {
		this.lastApprovedByName = lastApprovedByName;
	}
}
