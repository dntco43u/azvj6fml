package com.fhy8vp3u.auzj6fml;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.mapper.SampleBoardMapper;

@SpringBootTest
class Auzj6fmlApplicationTests {
  @Autowired
  private SampleBoardMapper sampleBoardMapper;

  void contextLoads() throws Exception {
  }

  @Test
  void select001() throws Exception {
    List<SampleBoardDTO> resList = sampleBoardMapper.select001();
    Assertions.assertNotNull(resList);
  }
}
