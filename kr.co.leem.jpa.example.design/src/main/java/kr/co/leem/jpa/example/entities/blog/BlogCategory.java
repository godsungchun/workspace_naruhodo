package kr.co.leem.jpa.example.entities.blog;

import kr.co.leem.jpa.example.entities.account.Account;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-12.
 */
@Entity(name = "blogCategory")
@Table(name = "blog_category")
public class BlogCategory implements Serializable {
	private static final long serialVersionUID = -3561894369585967430L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "name", length = 50, unique = true)
	private String name;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "createdDate", nullable = false)
	private Long createdDate;

	@ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
	@Fetch(value= FetchMode.JOIN)
	@JoinColumn(name="createdBy", referencedColumnName = "loginId")
	private Account createdBy;

	@Column(name = "lastModifiedDate")
	private Long lastModifiedDate;

	@ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
	@Fetch(value= FetchMode.JOIN)
	@JoinColumn(name="lastModifiedBy", referencedColumnName = "loginId")
	private Account lastModifiedBy;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Account getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Account getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Account lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
}
