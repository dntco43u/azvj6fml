package com.fhy8vp3u.auzj6fml.entity;

import static com.fhy8vp3u.auzj6fml.entity.QSampleBoardEntity.sampleBoardEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.fhy8vp3u.auzj6fml.domain.SearchConditionDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SampleBoardRepositoryCustom {
  private final JPAQueryFactory queryFactory;

  public Page<SampleBoardEntity> findAllBySearchCondition(Pageable pageable, SearchConditionDTO reqDTO) {
    JPAQuery<SampleBoardEntity> query = queryFactory.selectFrom(sampleBoardEntity)
    .where(searchKeywords(reqDTO.getSk(), reqDTO.getSv()));
    long total = query.fetchCount() ;
    List<SampleBoardEntity> results = query.where(searchKeywords(reqDTO.getSk(), reqDTO.getSv()))
    .offset(pageable.getOffset())
    .limit(pageable.getPageSize())
    .orderBy(sampleBoardEntity.id.desc())
    .fetch();
    return new PageImpl<>(results, pageable, total);
  }

  private BooleanExpression searchKeywords(String sk, String sv) {
    if ("author".equals(sk) && (StringUtils.hasLength(sv)))
      return sampleBoardEntity.author.contains(sv);
    else if ("title".equals(sk) && (StringUtils.hasLength(sv)))
      return sampleBoardEntity.title.contains(sv);
    else if ("contents".equals(sk) && (StringUtils.hasLength(sv)))
      return sampleBoardEntity.contents.contains(sv);
    else
      return null;
  }
}
