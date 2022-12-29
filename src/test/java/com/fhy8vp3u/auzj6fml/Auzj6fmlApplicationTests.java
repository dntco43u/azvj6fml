package com.fhy8vp3u.auzj6fml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.entity.SampleBoardEntity;
import com.fhy8vp3u.auzj6fml.service.SampleBoardService;

@SpringBootTest
class Auzj6fmlApplicationTests {
  @Autowired
  private SampleBoardService sampleBoardService;

  void contextLoads() throws Exception {
  }

  /*
   * @Test void select001() throws Exception { List<SampleBoardDTO> resList =
   * sampleBoardService.select001(); Assertions.assertNotNull(resList); }
   */
  
  @Test
  void select002() throws Exception {
    Long reqId = 7L;
    SampleBoardDTO resDTO = sampleBoardService.select002(reqId);
    Assertions.assertNotNull(resDTO);
  }
  
  @Test
  void insert001() throws Exception {
    SampleBoardDTO reqDTO = new SampleBoardDTO();
    reqDTO.setTitle("test-title-insert");
    reqDTO.setContents("test-contents-insert");
    reqDTO.setAuthor("test-author");
    reqDTO.setCreateUser("testuser");
    SampleBoardEntity resEntity = sampleBoardService.insert001(reqDTO);
    Assertions.assertNotNull(resEntity);
  }

  @Test
  void update001() throws Exception {
    SampleBoardDTO reqDTO = new SampleBoardDTO();
    reqDTO.setId(7L);
    reqDTO.setTitle("test-title-update");
    reqDTO.setContents("test-contents-update");
    reqDTO.setUpdateUser("testuser");
    SampleBoardEntity resEntity = sampleBoardService.update001(reqDTO);
    Assertions.assertNotNull(resEntity);
  }
  
  @Test
  void delete001() throws Exception {
    Long reqId = 7L;
    sampleBoardService.delete001(reqId);
    Assertions.assertEquals(7L, reqId);
  }
}
