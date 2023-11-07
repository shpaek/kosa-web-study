package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLineEmbedded is a Querydsl query type for LineEmbedded
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLineEmbedded extends BeanPath<LineEmbedded> {

    private static final long serialVersionUID = -1946226015L;

    public static final QLineEmbedded lineEmbedded = new QLineEmbedded("lineEmbedded");

    public final NumberPath<Long> lineNo = createNumber("lineNo", Long.class);

    public final StringPath pNo = createString("pNo");

    public QLineEmbedded(String variable) {
        super(LineEmbedded.class, forVariable(variable));
    }

    public QLineEmbedded(Path<? extends LineEmbedded> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLineEmbedded(PathMetadata metadata) {
        super(LineEmbedded.class, metadata);
    }

}

