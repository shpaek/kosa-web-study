package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLine is a Querydsl query type for Line
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLine extends EntityPathBase<Line> {

    private static final long serialVersionUID = 2084592375L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLine line = new QLine("line");

    public final QLineEmbedded id;

    public final QInfo info;

    public final QP lineP;

    public final NumberPath<Integer> lineQuantity = createNumber("lineQuantity", Integer.class);

    public QLine(String variable) {
        this(Line.class, forVariable(variable), INITS);
    }

    public QLine(Path<? extends Line> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLine(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLine(PathMetadata metadata, PathInits inits) {
        this(Line.class, metadata, inits);
    }

    public QLine(Class<? extends Line> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLineEmbedded(forProperty("id")) : null;
        this.info = inits.isInitialized("info") ? new QInfo(forProperty("info")) : null;
        this.lineP = inits.isInitialized("lineP") ? new QP(forProperty("lineP"), inits.get("lineP")) : null;
    }

}

