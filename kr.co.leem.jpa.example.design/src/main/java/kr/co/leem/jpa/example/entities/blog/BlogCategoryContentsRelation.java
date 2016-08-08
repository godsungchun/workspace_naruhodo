package kr.co.leem.jpa.example.entities.blog;

import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.entities.blog.embedded.BlogCategoryContentRelationPK;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-12.
 */
@Entity(name = "blogCategoryContentsRelation")
@Table(name = "blog_category_contents_relation")
public class BlogCategoryContentsRelation implements Serializable {
	private static final long serialVersionUID = 8065044994639138870L;

	@EmbeddedId
	private BlogCategoryContentRelationPK blogCategoryContentRelationPK;

	@ManyToOne(targetEntity = BlogCategory.class)
	@MapKey(name = "categorySeq")
	private BlogCategory blogCategory;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "subTitle", length = 500)
	private String subTitle;

	@ManyToOne(targetEntity = BlogCategory.class)
	@MapKey(name = "contentsSeq")
	private BlogContents blogContents;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "released")
	private Boolean released;

	@Column(name = "releasedDate")
	private Long releasedDate;

	@Column(name = "views")
	private Long views;

	@Column(name = "createdDate", nullable = false)
	private Long createdDate;

	@Column(name = "createdBy", length = 50, nullable = false)
	private String createdBy;

	@Column(name = "lastModifiedDate")
	private Long lastModifiedDate;

	@Column(name = "lastModifiedBy", length = 50)
	private String lastModifiedBy;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public BlogCategoryContentRelationPK getBlogCategoryContentRelationPK() {
		return blogCategoryContentRelationPK;
	}

	public void setBlogCategoryContentRelationPK(BlogCategoryContentRelationPK blogCategoryContentRelationPK) {
		this.blogCategoryContentRelationPK = blogCategoryContentRelationPK;
	}

	public BlogCategory getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
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

	public BlogContents getBlogContents() {
		return blogContents;
	}

	public void setBlogContents(BlogContents blogContents) {
		this.blogContents = blogContents;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getReleased() {
		return released;
	}

	public void setReleased(Boolean released) {
		this.released = released;
	}

	public Long getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Long releasedDate) {
		this.releasedDate = releasedDate;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
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
}
