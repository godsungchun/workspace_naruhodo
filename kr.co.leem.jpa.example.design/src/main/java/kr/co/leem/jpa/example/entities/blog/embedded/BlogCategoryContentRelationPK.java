package kr.co.leem.jpa.example.entities.blog.embedded;

import kr.co.leem.jpa.example.entities.blog.BlogCategory;
import kr.co.leem.jpa.example.entities.blog.BlogContents;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-12.
 */
@Embeddable
public class BlogCategoryContentRelationPK implements Serializable {
	private static final long serialVersionUID = 5332352516688326312L;

	@Column(name = "categorySeq")
	private Long categorySeq;


	@Column(name = "contentsSeq")
	private Long contentsSeq;

	public BlogCategoryContentRelationPK() {

	}

	public BlogCategoryContentRelationPK(Long categorySeq, Long contentsSeq) {
		this.categorySeq = categorySeq;
		this.contentsSeq = contentsSeq;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCategorySeq() {
		return categorySeq;
	}

	public void setCategorySeq(Long categorySeq) {
		this.categorySeq = categorySeq;
	}

	public Long getContentsSeq() {
		return contentsSeq;
	}

	public void setContentsSeq(Long contentsSeq) {
		this.contentsSeq = contentsSeq;
	}
}
