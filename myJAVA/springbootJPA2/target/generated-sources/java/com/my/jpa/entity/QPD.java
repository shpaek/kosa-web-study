package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPD is a Querydsl query type for PD
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPD extends EntityPathBase<PD> {

    private static final long serialVersionUID = 1316134295L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPD pD = new QPD("pD");

    public final NumberPath<Integer> cal = createNumber("cal", Integer.class);

    public final NumberPath<Integer> na = createNumber("na", Integer.class);

    public final QP p;

    public final StringPath pdNo = createString("pdNo");

    public QPD(String variable) {
        this(PD.class, forVariable(variable), INITS);
    }

    public QPD(Path<? extends PD> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPD(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPD(PathMetadata metadata, PathInits inits) {
        this(PD.class, metadata, inits);
    }

    public QPD(Class<? extends PD> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.p = inits.isInitialized("p") ? new QP(forProperty("p"), inits.get("p")) : null;
    }

}

