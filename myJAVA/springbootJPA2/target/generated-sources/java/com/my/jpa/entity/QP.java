package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QP is a Querydsl query type for P
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QP extends EntityPathBase<P> {

    private static final long serialVersionUID = -1897206707L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QP p = new QP("p");

    public final QPD pd;

    public final StringPath pName = createString("pName");

    public final StringPath pNo = createString("pNo");

    public QP(String variable) {
        this(P.class, forVariable(variable), INITS);
    }

    public QP(Path<? extends P> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QP(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QP(PathMetadata metadata, PathInits inits) {
        this(P.class, metadata, inits);
    }

    public QP(Class<? extends P> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pd = inits.isInitialized("pd") ? new QPD(forProperty("pd"), inits.get("pd")) : null;
    }

}

