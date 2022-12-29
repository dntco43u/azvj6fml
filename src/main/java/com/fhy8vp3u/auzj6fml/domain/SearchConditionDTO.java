package com.fhy8vp3u.auzj6fml.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchConditionDTO {
  private String sk;
  private String sv;
}
