package com.fhy8vp3u.auzj6fml.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USER_LOG", schema = "CQA7WTJG")
@Entity
public class UserLogEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userId;
  private String userPw;
  private String userName;
  private String createUser;
  private LocalDateTime createTime;
  private String updateUser;
  private LocalDateTime updateTime;
}
