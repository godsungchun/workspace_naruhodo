package kr.co.leem.jpa.example.entities.embedded;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAccountDataPK is a Querydsl query type for AccountDataPK
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QAccountDataPK extends BeanPath<AccountDataPK> {

    private static final long serialVersionUID = 212891666L;

    public static final QAccountDataPK accountDataPK = new QAccountDataPK("accountDataPK");

    public final EnumPath<kr.co.leem.jpa.example.constants.AccountDataType> accountDataType = createEnum("accountDataType", kr.co.leem.jpa.example.constants.AccountDataType.class);

    public final StringPath loginId = createString("loginId");

    public QAccountDataPK(String variable) {
        super(AccountDataPK.class, forVariable(variable));
    }

    public QAccountDataPK(Path<? extends AccountDataPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountDataPK(PathMetadata<?> metadata) {
        super(AccountDataPK.class, metadata);
    }

}

