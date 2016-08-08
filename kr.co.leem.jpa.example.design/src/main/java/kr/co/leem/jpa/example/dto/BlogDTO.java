package kr.co.leem.jpa.example.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kr.co.leem.jpa.example.entities.blog.BlogCategoryContentsRelation;
import kr.co.leem.jpa.example.entities.blog.BlogContents;
import kr.co.leem.jpa.example.entities.blog.BlogTag;
import kr.co.leem.jpa.example.entities.blog.embedded.BlogCategoryContentRelationPK;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dream on 2016-07-22.
 */
@JsonDeserialize
public class BlogDTO {
	private Long blogContentsSeq;
	private Long blogCategorySeq;
	private String title;
	private String subTitle;
	private List<String> blogTags;
	private String contents;
	private Boolean enabled;
	private Boolean released;
	private Boolean releasedDate;
	private Long createdDate;
	private Long lastModifiedDate;

	public BlogCategoryContentsRelation dtoToBlogCategoryContentsRelation() throws Exception {
		BlogCategoryContentsRelation blogCategoryContentsRelation = new BlogCategoryContentsRelation();

		BeanUtils.copyProperties(blogCategoryContentsRelation, this);

		BlogCategoryContentRelationPK blogCategoryContentRelationPK = new BlogCategoryContentRelationPK(this.blogCategorySeq, this.blogContentsSeq);

		blogCategoryContentsRelation.setBlogCategoryContentRelationPK(blogCategoryContentRelationPK);

		return blogCategoryContentsRelation;
	}

	public BlogContents dtoToBlogContents() throws Exception {
		BlogContents blogContents = new BlogContents();

		blogContents.setSeq(this.blogContentsSeq);
		blogContents.setContents(this.contents);
		blogContents.setTitle(this.title);
		blogContents.setSubTitle(this.subTitle);

		return blogContents;
	}

	public List<BlogTag> dtoToBlogTags(Long blogContentsSeq) throws Exception {
		List<BlogTag> blogTags = null;

		if (blogTags != null && blogTags.size() > 0) {
			blogTags = new ArrayList<>();

			for (int i = 0; i < this.blogTags.size(); i++) {
				BlogTag blogTag = new BlogTag();

				blogTag.setContentsSeq(blogContentsSeq);
				blogTag.setTag(this.blogTags.get(i));
				blogTags.add(blogTag);
			}
		}

		return blogTags;
	}

	public List<BlogTag> dtoToBlogTags() throws Exception {
		List<BlogTag> blogTags = null;

		if (blogTags != null && blogTags.size() > 0) {
			blogTags = new ArrayList<>();

			for (int i = 0; i < this.blogTags.size(); i++) {
				BlogTag blogTag = new BlogTag();

				blogTag.setContentsSeq(this.blogContentsSeq);
				blogTag.setTag(this.blogTags.get(i));
				blogTags.add(blogTag);
			}
		}

		return blogTags;
	}

	public Long getBlogContentsSeq() {
		return blogContentsSeq;
	}

	public void setBlogContentsSeq(Long blogContentsSeq) {
		this.blogContentsSeq = blogContentsSeq;
	}

	public Long getBlogCategorySeq() {
		return blogCategorySeq;
	}

	public void setBlogCategorySeq(Long blogCategorySeq) {
		this.blogCategorySeq = blogCategorySeq;
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

	public List<String> getBlogTags() {
		return blogTags;
	}

	public void setBlogTags(List<String> blogTags) {
		this.blogTags = blogTags;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public Boolean getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Boolean releasedDate) {
		this.releasedDate = releasedDate;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
