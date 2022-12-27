package com.fhy8vp3u.auzj6fml.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SampleBoardDTO {
  private Integer id;
  private String title;
  private String contents;
  private String author;
  private String createUser;
  private String createTime;
  private String updateUser;
  private String updateTime;
}
