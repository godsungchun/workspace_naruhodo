package com.godsungchun.mongodb.example.entities.mongodb;

import com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents.ApproveProperty;
import com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents.SectionCodeProperty;
import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Dream on 2016-08-24.
 */
@QueryEntity
@Document
@CompoundIndexes({
		@CompoundIndex(name = "blogContentsCodeIdx", def = "{'sectionCodeProperties.code': 1}"),
		@CompoundIndex(name = "blogContentsCode1Idx", def = "{'sectionCodeProperties.code1': 1}"),
		@CompoundIndex(name = "blogContentsCode2Idx", def = "{'sectionCodeProperties.code2': 1}")
})
public class BlogContents implements Serializable {
	private static final long serialVersionUID = -4887747832014624669L;
	
	@Id
	private String id;
	
	@TextIndexed
	private String title;
	
	@TextIndexed
	private String subTitle;
	
	@TextIndexed
	private String contents;
	
	private List<String> tags;
	
	@Indexed
	private Date createdDate;
	
	@Indexed
	private String createdById;
	
	@Indexed
	private String createByName;
	
	@Indexed
	private Date lastModifiedDate;
	
	@Indexed
	private String lastModifiedById;
	
	@Indexed
	private String lastModifiedByName;
	
	private List<SectionCodeProperty> sectionCodeProperties;
	
	private ApproveProperty approveProperty;
	
	@DBRef(lazy = true)
	private List<BlogSectionCode> blogContentsSectionsCodesRefs;
	
	private Boolean enabled;
	
	private Long viewCount;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getCreatedById() {
		return createdById;
	}
	
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	
	public String getCreateByName() {
		return createByName;
	}
	
	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}
	
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public String getLastModifiedById() {
		return lastModifiedById;
	}
	
	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	
	public String getLastModifiedByName() {
		return lastModifiedByName;
	}
	
	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
	}
	
	public List<SectionCodeProperty> getSectionCodeProperties() {
		return sectionCodeProperties;
	}
	
	public void setSectionCodeProperties(List<SectionCodeProperty> sectionCodeProperties) {
		this.sectionCodeProperties = sectionCodeProperties;
	}
	
	public ApproveProperty getApproveProperty() {
		return approveProperty;
	}
	
	public void setApproveProperty(ApproveProperty approveProperty) {
		this.approveProperty = approveProperty;
	}
	
	public List<BlogSectionCode> getBlogContentsSectionsCodesRefs() {
		return blogContentsSectionsCodesRefs;
	}
	
	public void setBlogContentsSectionsCodesRefs(List<BlogSectionCode> blogContentsSectionsCodesRefs) {
		this.blogContentsSectionsCodesRefs = blogContentsSectionsCodesRefs;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Long getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}
}
