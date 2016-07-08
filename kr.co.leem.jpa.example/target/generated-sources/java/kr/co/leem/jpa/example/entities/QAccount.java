package kr.co.leem.jpa.example.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 961438121L;

    public static final QAccount account = new QAccount("account");

    public final ListPath<AccountData, QAccountData> accountData = this.<AccountData, QAccountData>createList("accountData", AccountData.class, QAccountData.class, PathInits.DIRECT2);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath email = createString("email");

    public final StringPath loginId = createString("loginId");

    public final StringPath name = createString("name");

    public final StringPath regBy = createString("regBy");

    public final NumberPath<Long> regDate = createNumber("regDate", Long.class);

    public final StringPath updBy = createString("updBy");

    public final NumberPath<Long> updDate = createNumber("updDate", Long.class);

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata<?> metadata) {
        super(Account.class, metadata);
    }

}

