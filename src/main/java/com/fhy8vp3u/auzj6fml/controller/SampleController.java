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

import com.fhy8vp3u.auzj6fml.domain.SampleDTO;
import com.fhy8vp3u.auzj6fml.service.SampleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Sample"})
@RestController
public class SampleController {
  @Autowired
  SampleService sampleService;

  @ApiOperation(value = "Sample 리스트 조회", notes = "")
  @GetMapping("/sample")
  public List<SampleDTO> select001() {
    return sampleService.select001();
  }

  @ApiOperation(value = "Sample 단건 조회", notes = "")
  @GetMapping("/sample/{id}")
  public SampleDTO select002(@PathVariable("id") String id) {
    return sampleService.select002(id);
  }

  @ApiOperation(value = "Sample 단건 삽입", notes = "")
  @PostMapping(value = "/sample/create")
  public List<SampleDTO> insertt001(@RequestBody SampleDTO sampleDTO) {
    sampleService.insert001(sampleDTO);
    return sampleService.select001();
  }

  @ApiOperation(value = "Sample 단건 수정", notes = "")
  @PutMapping(value = "/sample/update")
  public List<SampleDTO> update001(@RequestBody SampleDTO sampleDTO) {
    sampleService.update001(sampleDTO);
    return sampleService.select001();
  }

  @ApiOperation(value = "Sample 단건 삭제", notes = "")
  @DeleteMapping("/sample/{id}")
  public List<SampleDTO> delete001(@PathVariable("id") String id) {
    sampleService.delete001(id);
    return sampleService.select001();
  }
}