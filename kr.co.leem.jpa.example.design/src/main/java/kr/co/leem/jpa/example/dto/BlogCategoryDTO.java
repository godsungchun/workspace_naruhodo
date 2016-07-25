package kr.co.leem.jpa.example.dto;

import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.entities.blog.BlogCategory;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Dream on 2016-07-20.
 */
public class BlogCategoryDTO {
	private Long seq;
	private String name;
	private Boolean enabled;
	private Long createdDate;
	private String createdBy;
	private Long lastModifiedDate;
	private String lastModifiedBy;

	public BlogCategory dtoToEntity() throws Exception {
		BlogCategory blogCategory = new BlogCategory();
		BeanUtils.copyProperties(blogCategory, this);

		return blogCategory;
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
