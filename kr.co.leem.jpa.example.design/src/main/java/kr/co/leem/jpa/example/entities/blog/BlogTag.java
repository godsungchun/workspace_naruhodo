package kr.co.leem.jpa.example.entities.blog;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-18.
 */
@Entity(name = "blogTag")
@Table(name = "blog_tag")
public class BlogTag implements Serializable {
	private static final long serialVersionUID = -5064676788873895461L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "contentsSeq")
	private Long contentsSeq;

	@Column(name = "tag", length = 100)
	private String tag;

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getContentsSeq() {
		return contentsSeq;
	}

	public void setContentsSeq(Long contentsSeq) {
		this.contentsSeq = contentsSeq;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
