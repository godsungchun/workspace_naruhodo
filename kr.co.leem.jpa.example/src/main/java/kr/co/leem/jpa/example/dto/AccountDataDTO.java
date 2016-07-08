package kr.co.leem.jpa.example.dto;

import kr.co.leem.jpa.example.constants.AccountDataType;
import kr.co.leem.jpa.example.entities.Account;
import kr.co.leem.jpa.example.entities.AccountData;
import kr.co.leem.jpa.example.entities.embedded.AccountDataPK;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;

/**
 * AccountDataDTO
 *
 * Created by Dream on 2016-06-20.
 */
public class AccountDataDTO implements Serializable{
	private static final long serialVersionUID = -4212181095957419728L;

	private String loginId;
	private AccountDataType accountDataType;
	private String value;

	private AccountData accountData;

	public AccountDataDTO() {

	}

	public AccountData dtoToEntity() throws Exception {
		AccountData accountData = new AccountData();

		AccountDataPK accountDataPK = new AccountDataPK();

		accountDataPK.setLoginId(this.getLoginId());
		accountDataPK.setAccountDataType(this.accountDataType);

		accountData.setAccountDataPK(accountDataPK);

		BeanUtils.copyProperties(accountData, this);

		return accountData;
	}

	public AccountDataDTO(String loginId, AccountDataType accountDataType, String value) throws Exception {
		AccountDataPK pk = new AccountDataPK();
		pk.setLoginId(loginId);
		pk.setAccountDataType(accountDataType);

		this.accountData.setAccountDataPK(pk);
		this.accountData.setValue(value);
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AccountData getAccountData() {
		return accountData;
	}

	public void setAccountData(AccountData accountData) {
		this.accountData = accountData;
	}
}
