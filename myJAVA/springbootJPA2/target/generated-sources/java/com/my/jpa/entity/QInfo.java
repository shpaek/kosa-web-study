package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInfo is a Querydsl query type for Info
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInfo extends EntityPathBase<Info> {

    private static final long serialVersionUID = 2084507569L;

    public static final QInfo info = new QInfo("info");

    public final DatePath<java.sql.Date> infoDt = createDate("infoDt", java.sql.Date.class);

    public final StringPath infoId = createString("infoId");

    public final NumberPath<Long> infoNo = createNumber("infoNo", Long.class);

    public final ListPath<Line, QLine> lines = this.<Line, QLine>createList("lines", Line.class, QLine.class, PathInits.DIRECT2);

    public QInfo(String variable) {
        super(Info.class, forVariable(variable));
    }

    public QInfo(Path<? extends Info> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInfo(PathMetadata metadata) {
        super(Info.class, metadata);
    }

}

