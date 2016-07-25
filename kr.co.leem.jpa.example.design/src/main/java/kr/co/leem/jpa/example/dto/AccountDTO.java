package kr.co.leem.jpa.example.dto;

import kr.co.leem.jpa.example.entities.account.Account;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.Column;

/**
 * Created by Dream on 2016-07-19.
 */
public class AccountDTO {
	private static final long serialVersionUID = 3721740362047749686L;

	private String loginId;
	private String name;
	private Integer age;
	private String email;
	private String accountDataKey;
	private Long createdDate;
	private String createdBy;
	private Long lastModifiedDate;
	private String lastModifiedBy;

	private Long fromDate;
	private Long toDate;

	public Account dtoToEntity() throws Exception {
		Account account = new Account();
		BeanUtils.copyProperties(account, this);

		return account;
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

	public String getAccountDataKey() {
		return accountDataKey;
	}

	public void setAccountDataKey(String accountDataKey) {
		this.accountDataKey = accountDataKey;
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

	public Long getFromDate() {
		return fromDate;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public Long getToDate() {
		return toDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}
}
