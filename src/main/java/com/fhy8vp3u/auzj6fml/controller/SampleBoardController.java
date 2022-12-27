package com.fhy8vp3u.auzj6fml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.service.SampleBoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"SampleBoard"})
@RestController
public class SampleBoardController {
  @Autowired
  SampleBoardService sampleBoardService;

  @ApiOperation(value = "SampleBoard SelectList", notes = "")
  @GetMapping("/api/sampleboard/list")
  public List<SampleBoardDTO> select001() {
    return sampleBoardService.select001();
  }

  @ApiOperation(value = "SampleBoard SelectOne", notes = "")
  @GetMapping("/api/sampleboard/{id}")
  public SampleBoardDTO select002(@PathVariable("id") String id) {
    return sampleBoardService.select002(id);
  }

  @ApiOperation(value = "SampleBoard InsertOne", notes = "")
  @PostMapping(value = "/api/sampleboard/create")
  public List<SampleBoardDTO> insertt001(@RequestBody SampleBoardDTO sampleDTO) {
    sampleBoardService.insert001(sampleDTO);
    return sampleBoardService.select001();
  }

  @ApiOperation(value = "SampleBoard UpdateOne", notes = "")
  @PutMapping(value = "/api/sampleboard/update")
  public List<SampleBoardDTO> update001(@RequestBody SampleBoardDTO sampleDTO) {
    sampleBoardService.update001(sampleDTO);
    return sampleBoardService.select001();
  }

  @ApiOperation(value = "SampleBoard DeleteOne", notes = "")
  @DeleteMapping("/api/sampleboard/{id}")
  public List<SampleBoardDTO> delete001(@PathVariable("id") String id) {
    sampleBoardService.delete001(id);
    return sampleBoardService.select001();
  }
}