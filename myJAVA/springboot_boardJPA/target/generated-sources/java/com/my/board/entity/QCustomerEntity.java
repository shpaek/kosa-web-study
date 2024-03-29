package com.my.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerEntity is a Querydsl query type for CustomerEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerEntity extends EntityPathBase<CustomerEntity> {

    private static final long serialVersionUID = -55613777L;

    public static final QCustomerEntity customerEntity = new QCustomerEntity("customerEntity");

    public final ListPath<BoardEntity, QBoardEntity> b = this.<BoardEntity, QBoardEntity>createList("b", BoardEntity.class, QBoardEntity.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath pwd = createString("pwd");

    public final ListPath<ReplyEntity, QReplyEntity> r = this.<ReplyEntity, QReplyEntity>createList("r", ReplyEntity.class, QReplyEntity.class, PathInits.DIRECT2);

    public QCustomerEntity(String variable) {
        super(CustomerEntity.class, forVariable(variable));
    }

    public QCustomerEntity(Path<? extends CustomerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerEntity(PathMetadata metadata) {
        super(CustomerEntity.class, metadata);
    }

}

