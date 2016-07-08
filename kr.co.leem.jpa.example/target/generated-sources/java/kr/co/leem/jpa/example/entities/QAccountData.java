package kr.co.leem.jpa.example.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAccountData is a Querydsl query type for AccountData
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccountData extends EntityPathBase<AccountData> {

    private static final long serialVersionUID = 1118030067L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountData accountData = new QAccountData("accountData");

    public final kr.co.leem.jpa.example.entities.embedded.QAccountDataPK accountDataPK;

    public final StringPath value = createString("value");

    public QAccountData(String variable) {
        this(AccountData.class, forVariable(variable), INITS);
    }

    public QAccountData(Path<? extends AccountData> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccountData(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccountData(PathMetadata<?> metadata, PathInits inits) {
        this(AccountData.class, metadata, inits);
    }

    public QAccountData(Class<? extends AccountData> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountDataPK = inits.isInitialized("accountDataPK") ? new kr.co.leem.jpa.example.entities.embedded.QAccountDataPK(forProperty("accountDataPK")) : null;
    }

}

