package com.fhy8vp3u.azvj6fml.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleBoardRepository extends JpaRepository<SampleBoardEntity, Long> {
  Page<SampleBoardEntity> findAllByOrderByIdDesc(Pageable pageable);
}