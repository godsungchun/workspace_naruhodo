package com.godsungchun.mongodb.example.params;

import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Map;

public class PageParams implements Serializable {
	private static final long serialVersionUID = -1961010065673490413L;
	
	protected int page;
	protected Integer rows = 20;
	protected String searchPhrase;
	protected Map<String, String> sort;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public Integer getRows() {
		return rows;
	}
	
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public String getSearchPhrase() {
		return searchPhrase;
	}
	
	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}
	
	public Map<String, String> getSort() {
		return sort;
	}
	
	public void setSort(Map<String, String> sort) {
		this.sort = sort;
	}
}