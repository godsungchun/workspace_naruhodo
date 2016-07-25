package kr.co.leem.jpa.example.entities.blog;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBlogContentsRelation is a Querydsl query type for BlogContentsRelation
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlogContentsRelation extends EntityPathBase<BlogContentsRelation> {

    private static final long serialVersionUID = -1997301120L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlogContentsRelation blogContentsRelation = new QBlogContentsRelation("blogContentsRelation");

    public final kr.co.leem.jpa.example.entities.blog.embedded.QBlogContentsRelationPK blogContentsRelationPK;

    public QBlogContentsRelation(String variable) {
        this(BlogContentsRelation.class, forVariable(variable), INITS);
    }

    public QBlogContentsRelation(Path<? extends BlogContentsRelation> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBlogContentsRelation(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBlogContentsRelation(PathMetadata<?> metadata, PathInits inits) {
        this(BlogContentsRelation.class, metadata, inits);
    }

    public QBlogContentsRelation(Class<? extends BlogContentsRelation> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blogContentsRelationPK = inits.isInitialized("blogContentsRelationPK") ? new kr.co.leem.jpa.example.entities.blog.embedded.QBlogContentsRelationPK(forProperty("blogContentsRelationPK")) : null;
    }

}

