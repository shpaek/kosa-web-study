package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QR is a Querydsl query type for R
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QR extends EntityPathBase<R> {

    private static final long serialVersionUID = -1897206705L;

    public static final QR r = new QR("r");

    public final NumberPath<Long> bNo = createNumber("bNo", Long.class);

    public final StringPath rContent = createString("rContent");

    public final NumberPath<Long> rNo = createNumber("rNo", Long.class);

    public QR(String variable) {
        super(R.class, forVariable(variable));
    }

    public QR(Path<? extends R> path) {
        super(path.getType(), path.getMetadata());
    }

    public QR(PathMetadata metadata) {
        super(R.class, metadata);
    }

}

