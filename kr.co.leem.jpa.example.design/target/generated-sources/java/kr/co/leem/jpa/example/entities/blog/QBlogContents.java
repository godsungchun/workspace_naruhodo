package kr.co.leem.jpa.example.entities.blog;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBlogContents is a Querydsl query type for BlogContents
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlogContents extends EntityPathBase<BlogContents> {

    private static final long serialVersionUID = 860479588L;

    public static final QBlogContents blogContents = new QBlogContents("blogContents");

    public final StringPath contents = createString("contents");

    public final StringPath createdBy = createString("createdBy");

    public final NumberPath<Long> createdDate = createNumber("createdDate", Long.class);

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final NumberPath<Long> lastModifiedDate = createNumber("lastModifiedDate", Long.class);

    public final BooleanPath released = createBoolean("released");

    public final NumberPath<Long> releasedDate = createNumber("releasedDate", Long.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath subTitle = createString("subTitle");

    public final StringPath title = createString("title");

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public QBlogContents(String variable) {
        super(BlogContents.class, forVariable(variable));
    }

    public QBlogContents(Path<? extends BlogContents> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogContents(PathMetadata<?> metadata) {
        super(BlogContents.class, metadata);
    }

}

