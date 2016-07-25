package kr.co.leem.jpa.example.entities.blog.embedded;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBlogContentsRelationPK is a Querydsl query type for BlogContentsRelationPK
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QBlogContentsRelationPK extends BeanPath<BlogContentsRelationPK> {

    private static final long serialVersionUID = 222515855L;

    public static final QBlogContentsRelationPK blogContentsRelationPK = new QBlogContentsRelationPK("blogContentsRelationPK");

    public final NumberPath<Long> sourceContentsSeq = createNumber("sourceContentsSeq", Long.class);

    public final NumberPath<Long> targetContentsSeq = createNumber("targetContentsSeq", Long.class);

    public QBlogContentsRelationPK(String variable) {
        super(BlogContentsRelationPK.class, forVariable(variable));
    }

    public QBlogContentsRelationPK(Path<? extends BlogContentsRelationPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogContentsRelationPK(PathMetadata<?> metadata) {
        super(BlogContentsRelationPK.class, metadata);
    }

}

