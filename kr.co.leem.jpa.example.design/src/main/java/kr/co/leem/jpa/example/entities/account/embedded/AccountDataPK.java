package kr.co.leem.jpa.example.entities.account.embedded;

import kr.co.leem.jpa.example.constants.AccountDataType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * AccountDataPK.
 *
 * Created by Dream on 2016-06-20.
 */
@Embeddable
public class AccountDataPK implements Serializable {
	private static final long serialVersionUID = 7262204439361258422L;

	@Column(name = "loginId", length = 50)
	private String loginId;

	@Column(name = "accountDataType", length = 50)
	private AccountDataType accountDataType;

	public AccountDataPK() {

	}

	public AccountDataPK(String loginId, AccountDataType accountDataType) {
		this.loginId = loginId;
		this.accountDataType = accountDataType;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public AccountDataType getAccountDataType() {
		return accountDataType;
	}

	public void setAccountDataType(AccountDataType accountDataType) {
		this.accountDataType = accountDataType;
	}
}