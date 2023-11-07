package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QA is a Querydsl query type for A
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QA extends EntityPathBase<A> {

    private static final long serialVersionUID = -1897206722L;

    public static final QA a = new QA("a");

    public final StringPath a4 = createString("a4");

    public final StringPath a_1 = createString("a_1");

    public final NumberPath<java.math.BigDecimal> a_2 = createNumber("a_2", java.math.BigDecimal.class);

    public final DatePath<java.sql.Date> a_3 = createDate("a_3", java.sql.Date.class);

    public QA(String variable) {
        super(A.class, forVariable(variable));
    }

    public QA(Path<? extends A> path) {
        super(path.getType(), path.getMetadata());
    }

    public QA(PathMetadata metadata) {
        super(A.class, metadata);
    }

}

