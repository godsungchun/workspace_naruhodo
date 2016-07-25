package kr.co.leem.jpa.example.entities.blog;

import kr.co.leem.jpa.example.entities.blog.embedded.BlogContentsRelationPK;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-18.
 */
@Entity(name = "blogContentsRelation")
@Table(name = "blog_contents_relation")
public class BlogContentsRelation implements Serializable {
	private static final long serialVersionUID = -4334993599236712482L;

	@EmbeddedId
	private BlogContentsRelationPK blogContentsRelationPK;

	public BlogContentsRelationPK getBlogContentsRelationPK() {
		return blogContentsRelationPK;
	}

	public void setBlogContentsRelationPK(BlogContentsRelationPK blogContentsRelationPK) {
		this.blogContentsRelationPK = blogContentsRelationPK;
	}
}
