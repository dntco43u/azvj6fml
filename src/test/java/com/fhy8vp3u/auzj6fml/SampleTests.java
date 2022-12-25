package com.fhy8vp3u.auzj6fml;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhy8vp3u.auzj6fml.domain.SampleDTO;
import com.fhy8vp3u.auzj6fml.mapper.SampleMapper;

@SpringBootTest
class SampleTests {
  @Autowired
  private SampleMapper sampleMapper;

  void contextLoads() throws Exception {
  }

  @Test
  void select001() throws Exception {
    List<SampleDTO> resList = sampleMapper.select001();
    Assertions.assertNotNull(resList);
  }

  @Test
  void select002() throws Exception {
    String id = "5";
    SampleDTO resDTO = sampleMapper.select002(id);
    Assertions.assertNotNull(resDTO);
  }

  @Test
  void insert001() throws Exception {
    SampleDTO reqDTO = new SampleDTO();
    reqDTO.setContent("insert-from-spring-boot");
    reqDTO.setCreateUser("spring");
    int resultCnt = sampleMapper.insert001(reqDTO);
    Assertions.assertEquals(1, resultCnt);
  }

  @Test
  void update001() throws Exception {
    SampleDTO reqDTO = new SampleDTO();
    reqDTO.setContent("update-from-spring-boot");
    reqDTO.setUpdateUser("spring");
    reqDTO.setId(8);
    int resultCnt = sampleMapper.update001(reqDTO);
    Assertions.assertEquals(1, resultCnt);
  }

  @Test
  void delete001() throws Exception {
    String id = "5";
    int resultCnt = sampleMapper.delete001(id);
    Assertions.assertEquals(1, resultCnt);
  }
}
