package kr.co.leem.jpa.example.entities.blog.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Dream on 2016-07-18.
 */
@Embeddable
public class BlogContentsRelationPK implements Serializable {
	private static final long serialVersionUID = 3426196816422991350L;

	@Column(name = "sourceContentsSeq")
	private Long sourceContentsSeq;

	@Column(name = "targetContentsSeq")
	private Long targetContentsSeq;

	public BlogContentsRelationPK() {

	}

	public BlogContentsRelationPK(Long sourceContentsSeq, Long targetContentsSeq) {
		this.sourceContentsSeq = sourceContentsSeq;
		this.targetContentsSeq = targetContentsSeq;
	}

	public Long getSourceContentsSeq() {
		return sourceContentsSeq;
	}

	public void setSourceContentsSeq(Long sourceContentsSeq) {
		this.sourceContentsSeq = sourceContentsSeq;
	}

	public Long getTargetContentsSeq() {
		return targetContentsSeq;
	}

	public void setTargetContentsSeq(Long targetContentsSeq) {
		this.targetContentsSeq = targetContentsSeq;
	}
}
