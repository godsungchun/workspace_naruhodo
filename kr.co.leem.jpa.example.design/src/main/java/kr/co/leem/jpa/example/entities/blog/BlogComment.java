package kr.co.leem.jpa.example.entities.blog;

import kr.co.leem.jpa.example.entities.account.Account;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-18.
 */
@Entity(name = "blogComment")
@Table(name = "blog_comment")
public class BlogComment implements Serializable {
	private static final long serialVersionUID = -8134481642056335040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "contentsSeq")
	private Long contentsSeq;

	@Lob
	@Column(name = "comment")
	private String comment;

	@Column(name = "createdDate", nullable = false)
	private Long createdDate;

	@ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.JOIN)
	@JoinColumn(name = "createdBy", referencedColumnName = "loginId")
	private Account createdBy;

	@Column(name = "lastModifiedDate")
	private Long lastModifiedDate;

	@ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.JOIN)
	@JoinColumn(name = "lastModifiedBy", referencedColumnName = "loginId")
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

	public Long getContentsSeq() {
		return contentsSeq;
	}

	public void setContentsSeq(Long contentsSeq) {
		this.contentsSeq = contentsSeq;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
