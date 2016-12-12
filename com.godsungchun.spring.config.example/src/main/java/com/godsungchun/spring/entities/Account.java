package com.godsungchun.spring.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-12-12.
 */
@Entity(name = "account")
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = -3247591380173008413L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@Column(length = 25)
	private String name;
	
	@Column
	private String pwd;
	
	@Column
	private String email;
	
	@Column(length = 50)
	private String signInId;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public Long getSeq() {
		return seq;
	}
	
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSignInId() {
		return signInId;
	}
	
	public void setSignInId(String signInId) {
		this.signInId = signInId;
	}
}
