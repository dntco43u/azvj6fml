package com.fhy8vp3u.auzj6fml;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhy8vp3u.auzj6fml.domain.SampleDTO;
import com.fhy8vp3u.auzj6fml.mapper.SampleMapper;

@SpringBootTest
class Auzj6fmlApplicationTests {
  @Autowired
  private SampleMapper sampleMapper;

  void contextLoads() throws Exception {
  }

  @Test
  void select001() throws Exception {
    List<SampleDTO> resList = sampleMapper.select001();
    Assertions.assertNotNull(resList);
  }
}
