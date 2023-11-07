package com.my.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReplyEntity is a Querydsl query type for ReplyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReplyEntity extends EntityPathBase<ReplyEntity> {

    private static final long serialVersionUID = -334149409L;

    public static final QReplyEntity replyEntity = new QReplyEntity("replyEntity");

    public final NumberPath<Integer> replyBoardNo = createNumber("replyBoardNo", Integer.class);

    public final StringPath replyContent = createString("replyContent");

    public final DatePath<java.sql.Date> replyDt = createDate("replyDt", java.sql.Date.class);

    public final StringPath replyId = createString("replyId");

    public final ListPath<ReplyEntity, QReplyEntity> replyList = this.<ReplyEntity, QReplyEntity>createList("replyList", ReplyEntity.class, QReplyEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> replyNo = createNumber("replyNo", Integer.class);

    public final NumberPath<Integer> replyParentNo = createNumber("replyParentNo", Integer.class);

    public QReplyEntity(String variable) {
        super(ReplyEntity.class, forVariable(variable));
    }

    public QReplyEntity(Path<? extends ReplyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReplyEntity(PathMetadata metadata) {
        super(ReplyEntity.class, metadata);
    }

}

