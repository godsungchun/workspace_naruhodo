package kr.co.leem.jpa.example.dto;

import kr.co.leem.jpa.example.entities.Account;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;

/**
 * AccountDTO
 *
 * Created by Dream on 2016-06-20.
 */
public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 3721740362047749686L;

	private String loginId;
	private String name;
	private Integer age;
	private String email;
	private String accountDataKey;
	private Long regDate;
	private String regBy;
	private Long updDate;
	private String updBy;

	private Long fromDate;
	private Long toDate;

	public AccountDTO() {

	}

	public Account dtoToEntity() throws Exception {
		Account account = new Account();
		BeanUtils.copyProperties(account, this);

		return account;
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

	public Long getRegDate() {
		return regDate;
	}

	public void setRegDate(Long regDate) {
		this.regDate = regDate;
	}

	public String getRegBy() {
		return regBy;
	}

	public void setRegBy(String regBy) {
		this.regBy = regBy;
	}

	public Long getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Long updDate) {
		this.updDate = updDate;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
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
