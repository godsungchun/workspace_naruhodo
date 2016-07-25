package kr.co.leem.jpa.example.entities.account;

import kr.co.leem.jpa.example.entities.account.embedded.AccountDataPK;

import javax.persistence.*;
import java.io.Serializable;

/**
 * AccountData.
 *
 * Created by Dream on 2016-06-20.
 */
@Entity(name = "accountData")
@Table(name = "account_data")
public class AccountData implements Serializable {
	private static final long serialVersionUID = 3437416076711154881L;

	@EmbeddedId
	private AccountDataPK accountDataPK;

	@Lob
	@Column(name = "value", nullable = false)
	private String value;

	public AccountDataPK getAccountDataPK() {
		return accountDataPK;
	}

	public void setAccountDataPK(AccountDataPK accountDataPK) {
		this.accountDataPK = accountDataPK;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
