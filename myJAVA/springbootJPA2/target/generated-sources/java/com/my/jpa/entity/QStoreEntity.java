package com.my.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStoreEntity is a Querydsl query type for StoreEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreEntity extends EntityPathBase<StoreEntity> {

    private static final long serialVersionUID = 1723684801L;

    public static final QStoreEntity storeEntity = new QStoreEntity("storeEntity");

    public final StringPath corNo = createString("corNo");

    public final DatePath<java.sql.Date> dt = createDate("dt", java.sql.Date.class);

    public final StringPath name = createString("name");

    public QStoreEntity(String variable) {
        super(StoreEntity.class, forVariable(variable));
    }

    public QStoreEntity(Path<? extends StoreEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreEntity(PathMetadata metadata) {
        super(StoreEntity.class, metadata);
    }

}

