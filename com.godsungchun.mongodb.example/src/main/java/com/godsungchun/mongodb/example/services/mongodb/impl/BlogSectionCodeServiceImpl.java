package com.godsungchun.mongodb.example.services.mongodb.impl;

import com.godsungchun.mongodb.example.commons.persistences.mongodb.SimpleAggregationOperation;
import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.constants.Types.*;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import com.godsungchun.mongodb.example.entities.mongodb.QBlogSectionCode;
import com.godsungchun.mongodb.example.entities.mongodb.model.ChildSectionCode;
import com.godsungchun.mongodb.example.entities.mongodb.model.ParentSectionCode;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.repositories.mongodb.BlogSectionCodeRepository;
import com.godsungchun.mongodb.example.services.mongodb.BlogSectionCodeService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-15.
 */
@Service
public class BlogSectionCodeServiceImpl implements BlogSectionCodeService {
	@Autowired
	private BlogSectionCodeRepository blogSectionCodeRepository;
	
	@Autowired
	private SimpleAggregationOperation<BlogSectionCode> simpleAggregationOperation;
	
	@Override
	public void findAll(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		if (findParams.getEnablePageable() == true) {
			this.findAllByPageable(findParams, pageable, resultMap);
		} else {
			this.findAll(findParams, resultMap);
		}
	}
	
	private Page<BlogSectionCode> findAllByPageable(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		Page<BlogSectionCode> pages = blogSectionCodeRepository.findAll(whereBuilder(findParams), pageable);
		
		resultMap.put(Type.pages, pages);
		
		return pages;
	}
	
	private Iterable<BlogSectionCode> findAll(FindParams findParams, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		Iterable<BlogSectionCode> rows = blogSectionCodeRepository.findAll(whereBuilder(findParams));
		
		resultMap.put(Type.rows, rows);
		
		return rows;
	}
	
	@Override
	public void findOne(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QBlogSectionCode qBlogSectionCode = QBlogSectionCode.blogSectionCode;
		
		if (StringUtils.isNotEmpty(blogSectionCode.getId())) {
			booleanBuilder.and(qBlogSectionCode.id.eq(blogSectionCode.getId()));
		} else if (StringUtils.isNotEmpty(blogSectionCode.getCode())) {
			booleanBuilder.and(qBlogSectionCode.code.eq(blogSectionCode.getCode()));
		}
			
		BlogSectionCode row = blogSectionCodeRepository.findOne(blogSectionCode.getId());
		
		resultMap.put(Type.pages, row);
	}
	
	@Override
	public void save(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		String code = blogSectionCode.getCode();
		
		BlogSectionCode sectionCode = blogSectionCodeRepository.findOne(QBlogSectionCode.blogSectionCode.code.eq(code));
		
		BlogSectionCode row = blogSectionCodeRepository.save(blogSectionCode);
		
		resultMap.put(Type.row, row);
	}
	
	@Override
	public void save(List<BlogSectionCode> blogSectionCodes, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		List<BlogSectionCode> rows = blogSectionCodeRepository.save(blogSectionCodes);
		
		resultMap.put(Type.rows, rows);
	}
	
	private BooleanBuilder whereBuilder(FindParams findParams) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		BlogSectionCodeFind blogSectionCodeFind = findParams.getBlogSectionCodeFind();
		String keyword = findParams.getKeyword();
		List<String> values = findParams.getValues();
		
		QBlogSectionCode qBlogSectionCode = QBlogSectionCode.blogSectionCode;
		
		if (findParams.getBlogSectionCodeFind() != null) {
			if (blogSectionCodeFind == BlogSectionCodeFind.code) {
				booleanBuilder.and(qBlogSectionCode.code.eq(keyword));
			} else if (blogSectionCodeFind == BlogSectionCodeFind.code1) {
				booleanBuilder.and(qBlogSectionCode.code1.eq(keyword));
			} else if (blogSectionCodeFind == BlogSectionCodeFind.codes) {
				booleanBuilder.and(qBlogSectionCode.code.in(values).or(qBlogSectionCode.code1.in(values)));
			} else if (blogSectionCodeFind == BlogSectionCodeFind.name) {
				booleanBuilder.and(qBlogSectionCode.name.like(keyword));
			} else if (blogSectionCodeFind == BlogSectionCodeFind.created) {
				booleanBuilder.and(qBlogSectionCode.createByName.like(keyword));
			} else {
				booleanBuilder.and(qBlogSectionCode.lastModifiedByName.like(keyword));
			}
		}
		
		FindDate findDateType = findParams.getFindDateType();
		Date fromDate = findParams.getFromDate();
		Date toDate = findParams.getToDate();
		
		if (findDateType != null && fromDate != null && toDate != null) {
			if (findDateType == FindDate.created) {
				booleanBuilder.and(qBlogSectionCode.createdDate.between(fromDate, toDate));
			} else {
				booleanBuilder.and(qBlogSectionCode.lastModifiedDate.between(fromDate, toDate));
			}
		}
		
		return booleanBuilder;
	}
	
	@Override
	public void getParentCodes(ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		Iterable<BlogSectionCode> rows = blogSectionCodeRepository.findAll(QBlogSectionCode.blogSectionCode.parentCode.isEmpty().and(QBlogSectionCode.blogSectionCode.enabled.eq(true)));
		
		resultMap.put(Type.resultCode, rows);
	}
	
	@Override
	public void checkDuplicatedSectionCode(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		QBlogSectionCode qBlogSectionCode = QBlogSectionCode.blogSectionCode;
		String parentCode = blogSectionCode.getParentCode();
		String name = blogSectionCode.getName();
		
		BlogSectionCode row = null;
		
		if (StringUtils.isEmpty(parentCode)) {
			row = blogSectionCodeRepository.findOne(qBlogSectionCode.parentCode.isEmpty().and(qBlogSectionCode.name.eq(name)));
		} else {
			row = blogSectionCodeRepository.findOne(qBlogSectionCode.parentCode.eq(parentCode).and(qBlogSectionCode.name.eq(name)));
		}
		
		if (row != null) {
			resultMap.put(Type.isDuplicated, true);
		} else {
			resultMap.put(Type.isDuplicated, false);
		}
	}
	
	@Override
	public void generateSectionCode(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		QBlogSectionCode qBlogSectionCode = QBlogSectionCode.blogSectionCode;
		String parentCode = blogSectionCode.getParentCode();
		String name = blogSectionCode.getName();
		
		if (StringUtils.isEmpty(parentCode)) {
			BlogSectionCode blogSectionCodeRow = simpleAggregationOperation.minMax(Sort.Direction.DESC, BlogSectionCode.class, BlogSectionCode.class, "code1", "code1");
			
			if (blogSectionCodeRow != null) {
				String maxCode = blogSectionCodeRow.getCode1();
				
			}
		} else {
			
		}
	}
	
	public void findAllTreeData(FindParams findParams, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		if (findParams != null && findParams.getEnabled() != null) {
			booleanBuilder.and(QBlogSectionCode.blogSectionCode.enabled.eq(findParams.getEnabled()));
		} else {
			booleanBuilder.and(QBlogSectionCode.blogSectionCode.enabled.eq(true));
		}
		
		Iterable<BlogSectionCode> blogSectionCodeRows = blogSectionCodeRepository.findAll(booleanBuilder, QBlogSectionCode.blogSectionCode.code.asc());
		
		List<BlogSectionCode> parentSectionCodeRows = new ArrayList<>();
		List<BlogSectionCode> childSectionCodeRows = new ArrayList<>();
		
		if (blogSectionCodeRows != null) {
			for (BlogSectionCode blogSectionCode : blogSectionCodeRows) {
				if (StringUtils.isEmpty(blogSectionCode.getParentCode())) {
					parentSectionCodeRows.add(blogSectionCode);
				} else {
					childSectionCodeRows.add(blogSectionCode);
				}
			}
		}
		
		List<ParentSectionCode> rows = new ArrayList<>();
		
		for (BlogSectionCode parentRow : parentSectionCodeRows) {
			ParentSectionCode parentSectionCode = new ParentSectionCode();
			BeanUtils.copyProperties(parentRow, parentSectionCode);
			parentSectionCode.setKey(parentRow.getId());
			parentSectionCode.setTitle(parentRow.getName());
			
			for (BlogSectionCode childRow : childSectionCodeRows) {
				if (StringUtils.equalsIgnoreCase(parentRow.getCode(), childRow.getParentCode())) {
					ChildSectionCode childSectionCode = new ChildSectionCode();
					BeanUtils.copyProperties(childRow, childSectionCode);
					
					childSectionCode.setKey(childRow.getId());
					childSectionCode.setTitle(childRow.getName());
					
					if (parentSectionCode.getChildren() == null) {
						parentSectionCode.setChildren(new ArrayList());
					}
					
					parentSectionCode.getChildren().add(childSectionCode);
				}
			}
			
			rows.add(parentSectionCode);
		}
		
		resultMap.put(Type.rows, rows);
	}
}
