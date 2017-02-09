package com.godsungchun.mongodb.example.services.mongodb.impl;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.constants.Types.*;
import com.godsungchun.mongodb.example.entities.mongodb.BlogContents;
import com.godsungchun.mongodb.example.entities.mongodb.QBlogContents;
import com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents.QApproveProperty;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.repositories.mongodb.BlogContentsRepository;
import com.godsungchun.mongodb.example.services.mongodb.BlogContentsService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-16.
 */
@Service
public class BlogContentsServiceImpl implements BlogContentsService {
	@Autowired
	private BlogContentsRepository blogContentsRepository;
	
	@Override
	public void findAll(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		Page<BlogContents> pages = blogContentsRepository.findAll(whereBuilder(findParams), pageable);
		
		resultMap.put(Type.pages, pages);
	}
	
	@Override
	public void findOne(BlogContents blogContents, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		BlogContents row = blogContentsRepository.findOne(blogContents.getId());
		
		resultMap.put(Type.row, row);
	}
	
	@Override
	public void save(BlogContents blogContents, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		BlogContents row = blogContentsRepository.save(blogContents);
		
		resultMap.put(Type.row, row);
	}
	
	private BooleanBuilder whereBuilder(FindParams findParams) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QBlogContents qBlogContents = QBlogContents.blogContents;
		QApproveProperty qApproveProperty = qBlogContents.approveProperty;
		
		BlogContentsFind blogContentsFindType = findParams.getBlogContentsFind();
		String keyword = findParams.getKeyword();
		
		
		booleanBuilder.and(qBlogContents.createdById.eq(findParams.getCreatedById()));
		
		if (blogContentsFindType.equals(BlogContentsFind.title)) {
			booleanBuilder.and(qBlogContents.title.eq(keyword));
		} else if (blogContentsFindType.equals(BlogContentsFind.subTitle)) {
			booleanBuilder.and(qBlogContents.subTitle.eq(keyword));
		} else if (blogContentsFindType.equals(BlogContentsFind.contents)) {
			booleanBuilder.and(qBlogContents.contents.eq(keyword));
		} else if (blogContentsFindType.equals(BlogContentsFind.tags)) {
			booleanBuilder.and(qBlogContents.tags.any().like(keyword));
		} else if (blogContentsFindType.equals(BlogContentsFind.approved)) {
			booleanBuilder.and(
					qApproveProperty.isNotNull()
							.and(qApproveProperty.approved.isNotNull()
									.and(qApproveProperty.approved.eq(findParams.getApproved())
									)
							)
			);
		} else if (blogContentsFindType.equals(BlogContentsFind.lastApprovedByName)) {
			booleanBuilder.and(
					qApproveProperty.isNotNull()
							.and(qApproveProperty.lastApprovedByName.isNotNull()
									.and(qApproveProperty.lastApprovedByName.eq(findParams.getKeyword())
									)
							)
			);
		}
		
		FindDate findDateType = findParams.getFindDateType();
		Date fromDate = findParams.getFromDate();
		Date toDate = findParams.getToDate();
		
		if (findDateType != null && findParams.getFromDate() != null && findParams.getToDate() != null) {
			if (findDateType == FindDate.created) {
				booleanBuilder.and(qBlogContents.createdDate.between(fromDate, toDate));
			} else {
				booleanBuilder.and(qBlogContents.lastModifiedDate.between(fromDate, toDate));
			}
		}
		
		return booleanBuilder;
	}
}
