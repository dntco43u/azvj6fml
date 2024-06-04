package com.fhy8vp3u.azvj6fml.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleBoardEntity is a Querydsl query type for SampleBoardEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleBoardEntity extends EntityPathBase<SampleBoardEntity> {

    private static final long serialVersionUID = 234524226L;

    public static final QSampleBoardEntity sampleBoardEntity = new QSampleBoardEntity("sampleBoardEntity");

    public final StringPath author = createString("author");

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath createUser = createString("createUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final StringPath updateUser = createString("updateUser");

    public QSampleBoardEntity(String variable) {
        super(SampleBoardEntity.class, forVariable(variable));
    }

    public QSampleBoardEntity(Path<? extends SampleBoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleBoardEntity(PathMetadata metadata) {
        super(SampleBoardEntity.class, metadata);
    }

}

