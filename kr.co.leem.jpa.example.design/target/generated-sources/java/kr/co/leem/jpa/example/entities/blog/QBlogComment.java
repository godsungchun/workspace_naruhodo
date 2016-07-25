package kr.co.leem.jpa.example.entities.blog;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBlogComment is a Querydsl query type for BlogComment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlogComment extends EntityPathBase<BlogComment> {

    private static final long serialVersionUID = 719362005L;

    public static final QBlogComment blogComment = new QBlogComment("blogComment");

    public final StringPath comment = createString("comment");

    public final NumberPath<Long> contentsSeq = createNumber("contentsSeq", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final NumberPath<Long> createdDate = createNumber("createdDate", Long.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final NumberPath<Long> lastModifiedDate = createNumber("lastModifiedDate", Long.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QBlogComment(String variable) {
        super(BlogComment.class, forVariable(variable));
    }

    public QBlogComment(Path<? extends BlogComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogComment(PathMetadata<?> metadata) {
        super(BlogComment.class, metadata);
    }

}

