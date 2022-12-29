package com.fhy8vp3u.auzj6fml.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleBoardDTO {
  private Long id;
  private String title;
  private String contents;
  private String author;
  private String createUser;
  private String createTime;
  private String updateUser;
  private String updateTime;
}
