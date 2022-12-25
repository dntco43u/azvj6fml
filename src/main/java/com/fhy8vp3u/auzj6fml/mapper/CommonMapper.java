package com.fhy8vp3u.auzj6fml.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
  public List<Map<String, Object>> select001();

  public List<Map<String, Object>> select002();
}
