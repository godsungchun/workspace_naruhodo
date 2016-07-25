package kr.co.leem.jpa.example.entities.blog.embedded;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBlogCategoryContentRelationPK is a Querydsl query type for BlogCategoryContentRelationPK
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QBlogCategoryContentRelationPK extends BeanPath<BlogCategoryContentRelationPK> {

    private static final long serialVersionUID = -1683993516L;

    public static final QBlogCategoryContentRelationPK blogCategoryContentRelationPK = new QBlogCategoryContentRelationPK("blogCategoryContentRelationPK");

    public final NumberPath<Long> categorySeq = createNumber("categorySeq", Long.class);

    public final NumberPath<Long> contentsSeq = createNumber("contentsSeq", Long.class);

    public QBlogCategoryContentRelationPK(String variable) {
        super(BlogCategoryContentRelationPK.class, forVariable(variable));
    }

    public QBlogCategoryContentRelationPK(Path<? extends BlogCategoryContentRelationPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogCategoryContentRelationPK(PathMetadata<?> metadata) {
        super(BlogCategoryContentRelationPK.class, metadata);
    }

}

