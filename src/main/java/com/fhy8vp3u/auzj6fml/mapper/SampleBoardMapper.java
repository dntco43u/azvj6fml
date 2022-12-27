package com.fhy8vp3u.auzj6fml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;

@Mapper
public interface SampleBoardMapper {
  public List<SampleBoardDTO> select001();

  public SampleBoardDTO select002(String id);

  public int insert001(SampleBoardDTO reqDTO);

  public int update001(SampleBoardDTO reqDTO);

  public int delete001(String id);
}
