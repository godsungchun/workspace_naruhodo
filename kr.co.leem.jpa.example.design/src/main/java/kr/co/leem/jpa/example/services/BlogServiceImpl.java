package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.dto.BlogDTO;
import kr.co.leem.jpa.example.entities.blog.BlogCategoryContentsRelation;
import kr.co.leem.jpa.example.entities.blog.BlogContents;
import kr.co.leem.jpa.example.entities.blog.BlogTag;
import kr.co.leem.jpa.example.repositories.BlogCategoryContentsRelationRepository;
import kr.co.leem.jpa.example.repositories.BlogContentsRelationRepository;
import kr.co.leem.jpa.example.repositories.BlogContentsRepository;
import kr.co.leem.jpa.example.repositories.BlogTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-22.
 */
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogContentsRepository blogContentsRepository;

	@Autowired
	private BlogContentsRelationRepository blogContentsRelationRepository;

	@Autowired
	private BlogTagRepository blogTagRepository;

	@Autowired
	private BlogCategoryContentsRelationRepository blogCategoryContentsRelationRepository;

	@Override
	public void save(BlogDTO blogDTO, ConcurrentHashMap<String, Object> resultMap) throws Exception {
		if (blogDTO.getBlogContentsSeq() == null/* && blogDTO.getBlogCategorySeq() == null*/) {
			BlogCategoryContentsRelation blogCategoryContentsRelation = blogDTO.dtoToBlogCategoryContentsRelation();
			List<BlogTag> blogTags = blogDTO.dtoToBlogTags();
			BlogContents blogContents = blogDTO.dtoToBlogContents();

			BlogContents resultBlogContents = blogContentsRepository.save(blogContents);
			resultBlogContents.getSeq();

		} else {
			BlogContents blogContents = blogDTO.dtoToBlogContents();
			BlogContents resultBlogContents = blogContentsRepository.save(blogContents);
		}
	}
}
