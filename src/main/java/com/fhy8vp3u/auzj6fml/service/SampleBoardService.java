package com.fhy8vp3u.auzj6fml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.mapper.SampleBoardMapper;

/**
 * @author a9mbeyx2
 *
 */
@Service
public class SampleBoardService {
  @Autowired
  private SampleBoardMapper sampleBoardMapper;

  public List<SampleBoardDTO> select001() {
    return sampleBoardMapper.select001();
  }

  public SampleBoardDTO select002(String id) {
    return sampleBoardMapper.select002(id);
  }

  public int insert001(SampleBoardDTO sampleDTO) {
    return sampleBoardMapper.insert001(sampleDTO);
  }

  public int update001(SampleBoardDTO sampleDTO) {
    int resultCnt = 0;
    if (sampleBoardMapper.select002(sampleDTO.getId().toString()) != null) {
      resultCnt = sampleBoardMapper.update001(sampleDTO);
    } else {
      throw new IllegalStateException("no data");
    }
    return resultCnt;
  }

  public int delete001(String id) {
    int resultCnt = 0;
    if (sampleBoardMapper.select002(id) != null) {
      resultCnt = sampleBoardMapper.delete001(id);
    } else {
      throw new IllegalStateException("no data");
    }
    return resultCnt;
  }
}