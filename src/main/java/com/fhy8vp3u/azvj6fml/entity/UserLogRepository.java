package com.fhy8vp3u.azvj6fml.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLogEntity, Long> {
  Optional<UserLogEntity> findByUserId(String userId);
}