package kr.co.leem.jpa.example.entities.blog;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBlogCategoryContentsRelation is a Querydsl query type for BlogCategoryContentsRelation
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlogCategoryContentsRelation extends EntityPathBase<BlogCategoryContentsRelation> {

    private static final long serialVersionUID = 1263138206L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlogCategoryContentsRelation blogCategoryContentsRelation = new QBlogCategoryContentsRelation("blogCategoryContentsRelation");

    public final kr.co.leem.jpa.example.entities.blog.embedded.QBlogCategoryContentRelationPK blogCategoryContentRelationPK;

    public QBlogCategoryContentsRelation(String variable) {
        this(BlogCategoryContentsRelation.class, forVariable(variable), INITS);
    }

    public QBlogCategoryContentsRelation(Path<? extends BlogCategoryContentsRelation> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBlogCategoryContentsRelation(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBlogCategoryContentsRelation(PathMetadata<?> metadata, PathInits inits) {
        this(BlogCategoryContentsRelation.class, metadata, inits);
    }

    public QBlogCategoryContentsRelation(Class<? extends BlogCategoryContentsRelation> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blogCategoryContentRelationPK = inits.isInitialized("blogCategoryContentRelationPK") ? new kr.co.leem.jpa.example.entities.blog.embedded.QBlogCategoryContentRelationPK(forProperty("blogCategoryContentRelationPK")) : null;
    }

}

