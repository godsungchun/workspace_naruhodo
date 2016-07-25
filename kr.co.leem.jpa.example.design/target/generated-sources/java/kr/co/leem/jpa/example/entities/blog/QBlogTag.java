package kr.co.leem.jpa.example.entities.blog;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBlogTag is a Querydsl query type for BlogTag
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlogTag extends EntityPathBase<BlogTag> {

    private static final long serialVersionUID = 717722640L;

    public static final QBlogTag blogTag = new QBlogTag("blogTag");

    public final NumberPath<Long> contentsSeq = createNumber("contentsSeq", Long.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath tag = createString("tag");

    public QBlogTag(String variable) {
        super(BlogTag.class, forVariable(variable));
    }

    public QBlogTag(Path<? extends BlogTag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogTag(PathMetadata<?> metadata) {
        super(BlogTag.class, metadata);
    }

}

