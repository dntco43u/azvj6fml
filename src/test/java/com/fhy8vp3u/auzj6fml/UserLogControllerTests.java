package com.fhy8vp3u.auzj6fml;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fhy8vp3u.auzj6fml.controller.UserLogController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserLogControllerTests {
  @Autowired
  private UserLogController userLogController;
  private MockMvc mockMvc;

  void contextLoads() throws Exception {
  }

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(userLogController).build();
  }

  @DisplayName("loginFailed")
  @Test
  void loginFailed() throws Exception {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("user_id", "_demo1");
    jsonObject.put("user_pw", "_changeme2");
    ResultActions result = mockMvc
    .perform(post("/api/userlog/login").content(jsonObject.toString()).contentType(MediaType.APPLICATION_JSON));
    MvcResult mvcResult = result.andDo(print()).andExpect(status().isOk()).andReturn();
    log.info("mvcResult.getResponse().getContentAsString()={}", mvcResult.getResponse().getContentAsString());
    Assertions.assertNotNull(mvcResult);
  }

  @DisplayName("loginSucceed")
  @Test
  void loginSucceed() throws Exception {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("user_id", "demo1");
    jsonObject.put("user_pw", "changeme2");
    ResultActions result = mockMvc
    .perform(post("/api/userlog/login").content(jsonObject.toString()).contentType(MediaType.APPLICATION_JSON));
    MvcResult mvcResult = result.andDo(print()).andExpect(status().isOk()).andReturn();
    log.info("mvcResult.getResponse().getContentAsString()={}", mvcResult.getResponse().getContentAsString());
    Assertions.assertNotNull(mvcResult);
  }
}
