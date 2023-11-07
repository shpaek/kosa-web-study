package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QC is a Querydsl query type for C
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QC extends EntityPathBase<C> {

    private static final long serialVersionUID = -1897206720L;

    public static final QC c = new QC("c");

    public final ListPath<B, QB> bs = this.<B, QB>createList("bs", B.class, QB.class, PathInits.DIRECT2);

    public final StringPath cId = createString("cId");

    public final StringPath cName = createString("cName");

    public QC(String variable) {
        super(C.class, forVariable(variable));
    }

    public QC(Path<? extends C> path) {
        super(path.getType(), path.getMetadata());
    }

    public QC(PathMetadata metadata) {
        super(C.class, metadata);
    }

}

