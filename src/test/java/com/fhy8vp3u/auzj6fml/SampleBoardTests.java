package com.fhy8vp3u.auzj6fml;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.mapper.SampleBoardMapper;

@SpringBootTest
class SampleBoardTests {
  @Autowired
  private SampleBoardMapper sampleBoardMapper;

  void contextLoads() throws Exception {
  }

  @Test
  void select001() throws Exception {
    List<SampleBoardDTO> resList = sampleBoardMapper.select001();
    Assertions.assertNotNull(resList);
  }

  @Test
  void select002() throws Exception {
    String id = "7";
    SampleBoardDTO resDTO = sampleBoardMapper.select002(id);
    Assertions.assertNotNull(resDTO);
  }

  @Test
  void insert001() throws Exception {
    SampleBoardDTO reqDTO = new SampleBoardDTO();
    reqDTO.setTitle("test-title-insert");
    reqDTO.setContents("test-contents-insert");
    reqDTO.setAuthor("test-author");
    reqDTO.setCreateUser("testuser");
    int resultCnt = sampleBoardMapper.insert001(reqDTO);
    Assertions.assertEquals(1, resultCnt);
  }

  @Test
  void update001() throws Exception {
    SampleBoardDTO reqDTO = new SampleBoardDTO();
    reqDTO.setTitle("test-title-update");
    reqDTO.setContents("test-contents-update");
    reqDTO.setUpdateUser("testuser");
    reqDTO.setId(6);
    int resultCnt = sampleBoardMapper.update001(reqDTO);
    Assertions.assertEquals(1, resultCnt);
  }

  @Test
  void delete001() throws Exception {
    String id = "6";
    int resultCnt = sampleBoardMapper.delete001(id);
    Assertions.assertEquals(1, resultCnt);
  }
}
