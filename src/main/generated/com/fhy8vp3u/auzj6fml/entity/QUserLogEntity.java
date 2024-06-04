package com.fhy8vp3u.auzj6fml.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserLogEntity is a Querydsl query type for UserLogEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserLogEntity extends EntityPathBase<UserLogEntity> {

    private static final long serialVersionUID = 713551944L;

    public static final QUserLogEntity userLogEntity = new QUserLogEntity("userLogEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath createUser = createString("createUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final StringPath updateUser = createString("updateUser");

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final StringPath userPw = createString("userPw");

    public QUserLogEntity(String variable) {
        super(UserLogEntity.class, forVariable(variable));
    }

    public QUserLogEntity(Path<? extends UserLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserLogEntity(PathMetadata metadata) {
        super(UserLogEntity.class, metadata);
    }

}

