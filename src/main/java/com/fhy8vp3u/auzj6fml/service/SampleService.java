package com.fhy8vp3u.auzj6fml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhy8vp3u.auzj6fml.domain.SampleDTO;
import com.fhy8vp3u.auzj6fml.mapper.SampleMapper;

/**
 * @author a9mbeyx2
 *
 */
@Service
public class SampleService {
  @Autowired
  private SampleMapper sampleMapper;

  public List<SampleDTO> select001() {
    return sampleMapper.select001();
  }

  public SampleDTO select002(String id) {
    return sampleMapper.select002(id);
  }

  public int insert001(SampleDTO sampleDTO) {
    return sampleMapper.insert001(sampleDTO);
  }

  public int update001(SampleDTO sampleDTO) {
    int resultCnt = 0;
    if (sampleMapper.select002(sampleDTO.getId().toString()) != null) {
      resultCnt = sampleMapper.update001(sampleDTO);
    } else {
      throw new IllegalStateException("no data");
    }
    return resultCnt;
  }

  public int delete001(String id) {
    int resultCnt = 0;
    if (sampleMapper.select002(id) != null) {
      resultCnt = sampleMapper.delete001(id);
    } else {
      throw new IllegalStateException("no data");
    }
    return resultCnt;
  }
}