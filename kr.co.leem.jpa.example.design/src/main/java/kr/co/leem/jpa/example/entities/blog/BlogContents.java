package kr.co.leem.jpa.example.entities.blog;

import kr.co.leem.jpa.example.entities.account.Account;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dream on 2016-07-18.
 */
@Entity(name = "blogContents")
@Table(name = "blog_contents")
public class BlogContents implements Serializable {
	private static final long serialVersionUID = -2323558038664844837L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "subTitle", length = 500)
	private String subTitle;

	@Lob
	@Column(name = "contents", nullable = false)
	private String contents;

	@BatchSize(size = 10)
	@Fetch(value = FetchMode.SELECT)
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "contentsSeq", fetch = FetchType.LAZY)
	private List<BlogTag> blogTag;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<BlogTag> getBlogTag() {
		return blogTag;
	}

	public void setBlogTag(List<BlogTag> blogTag) {
		this.blogTag = blogTag;
	}
}
