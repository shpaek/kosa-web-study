package com.my.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardEntity is a Querydsl query type for BoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardEntity extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = -1861601317L;

    public static final QBoardEntity boardEntity = new QBoardEntity("boardEntity");

    public final StringPath boardContent = createString("boardContent");

    public final DatePath<java.sql.Date> boardDt = createDate("boardDt", java.sql.Date.class);

    public final StringPath boardId = createString("boardId");

    public final NumberPath<Integer> boardNo = createNumber("boardNo", Integer.class);

    public final StringPath boardTitle = createString("boardTitle");

    public final ListPath<ReplyEntity, QReplyEntity> replies = this.<ReplyEntity, QReplyEntity>createList("replies", ReplyEntity.class, QReplyEntity.class, PathInits.DIRECT2);

    public QBoardEntity(String variable) {
        super(BoardEntity.class, forVariable(variable));
    }

    public QBoardEntity(Path<? extends BoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardEntity(PathMetadata metadata) {
        super(BoardEntity.class, metadata);
    }

}
