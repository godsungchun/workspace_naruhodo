package kr.co.leem.jpa.example.entities.account;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Account.
 *
 * Created by Dream on 2016-06-18.
 */
@Entity(name = "account")
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 2608015850428351368L;

	@Id
	@Column(name = "loginId", length = 50, nullable = false)
	private String loginId;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "createdDate")
	private Long createdDate;

	@Column(name = "createdBy", length = 50)
	private String createdBy;

	@Column(name = "lastModifiedDate")
	private Long lastModifiedDate;

	@Column(name = "lastModifiedBy", length = 50)
	private String lastModifiedBy;

	public Account() {

	}

	public Account(String loginId) {
		this.loginId = loginId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String toString() {
		return "";
	}
}
