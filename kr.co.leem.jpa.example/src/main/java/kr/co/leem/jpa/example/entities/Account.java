package kr.co.leem.jpa.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
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

	@Column(name = "regDate", nullable = false)
	private Long regDate;

	@Column(name = "regBy", length = 50)
	private String regBy;

	@Column(name = "updDate")
	private Long updDate;

	@Column(name = "updBy", length = 50)
	private String updBy;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "loginId")
	private List<AccountData> accountData;

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

	public List<AccountData> getAccountData() {
		return accountData;
	}

	public void setAccountData(List<AccountData> accountData) {
		this.accountData = accountData;
	}
}
