package com.godsungchun.mongodb.example.params;

import com.godsungchun.mongodb.example.constants.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static com.godsungchun.mongodb.example.constants.Types.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-15.
 */
public class FindParams extends PageParams implements Serializable {
	private static final long serialVersionUID = -128638117935920230L;
	
	private String keyword;
	
	private List<String> values;
	
	private AccountFind accountFindType;
	
	private BlogSectionCodeFind blogSectionCodeFind;
	
	private BlogContentsFind blogContentsFind;
	
	private Boolean enabled;
	
	private Boolean approved;
	
	private FindDate findDateType;
	
	private Date fromDate;
	
	private Date toDate;
	
	private String createdById;
	
	private Boolean enablePageable;
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public List<String> getValues() {
		return values;
	}
	
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public AccountFind getAccountFindType() {
		return accountFindType;
	}
	
	public void setAccountFindType(AccountFind accountFindType) {
		this.accountFindType = accountFindType;
	}
	
	public BlogSectionCodeFind getBlogSectionCodeFind() {
		return blogSectionCodeFind;
	}
	
	public void setBlogSectionCodeFind(BlogSectionCodeFind blogSectionCodeFind) {
		this.blogSectionCodeFind = blogSectionCodeFind;
	}
	
	public BlogContentsFind getBlogContentsFind() {
		return blogContentsFind;
	}
	
	public void setBlogContentsFind(BlogContentsFind blogContentsFind) {
		this.blogContentsFind = blogContentsFind;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Boolean getApproved() {
		return approved;
	}
	
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	public FindDate getFindDateType() {
		return findDateType;
	}
	
	public void setFindDateType(FindDate findDateType) {
		this.findDateType = findDateType;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public Date getToDate() {
		return toDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public String getCreatedById() {
		return createdById;
	}
	
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	
	public Boolean getEnablePageable() {
		return enablePageable;
	}
	
	public void setEnablePageable(Boolean enablePageable) {
		this.enablePageable = enablePageable;
	}
	
	public PageRequest getPageRequest() throws Exception {
		this.page = this.page - 1;
		this.searchPhrase = this.keyword;
		Sort sort = null;
		
		if (this.sort != null && this.sort.size() > 0) {
			List<String> keys = new ArrayList<>(this.sort.keySet());
			
			String key = keys.get(0);
			String value = this.sort.get(keys.get(0));
			Sort.Direction direction = Sort.Direction.fromString(value);
			
			Sort.Order order = new Sort.Order(direction, key);
					
			sort = new Sort(order);
		}
		
		PageRequest pageRequest = new PageRequest(this.page, this.rows, sort);
		
		return pageRequest;
	}
	
	public void setPages(Page<?> pages, ConcurrentHashMap<Result.Type, Object> resultMap) throws Exception {
		resultMap.put(Result.Type.total, pages.getTotalElements()); // 총 페이지수
		resultMap.put(Result.Type.page, this.page + 1); // 현재 페이지
		resultMap.put(Result.Type.record, this.getRows()); // 총 레코드 수
		resultMap.put(Result.Type.rows, pages.getContent());
	}
}
