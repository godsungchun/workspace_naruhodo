package kr.co.leem.jpa.example.entities.blog;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBlogCategory is a Querydsl query type for BlogCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlogCategory extends EntityPathBase<BlogCategory> {

    private static final long serialVersionUID = 1478312520L;

    public static final QBlogCategory blogCategory = new QBlogCategory("blogCategory");

    public final StringPath createdBy = createString("createdBy");

    public final NumberPath<Long> createdDate = createNumber("createdDate", Long.class);

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final NumberPath<Long> lastModifiedDate = createNumber("lastModifiedDate", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QBlogCategory(String variable) {
        super(BlogCategory.class, forVariable(variable));
    }

    public QBlogCategory(Path<? extends BlogCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogCategory(PathMetadata<?> metadata) {
        super(BlogCategory.class, metadata);
    }

}

