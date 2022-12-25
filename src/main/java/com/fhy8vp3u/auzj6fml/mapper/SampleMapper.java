package com.fhy8vp3u.auzj6fml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fhy8vp3u.auzj6fml.domain.SampleDTO;

@Mapper
public interface SampleMapper {
  public List<SampleDTO> select001();

  public SampleDTO select002(String id);

  public int insert001(SampleDTO reqDTO);

  public int update001(SampleDTO reqDTO);

  public int delete001(String id);
}
