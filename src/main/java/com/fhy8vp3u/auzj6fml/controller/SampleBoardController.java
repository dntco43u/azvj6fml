package com.fhy8vp3u.auzj6fml.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.domain.SearchConditionDTO;
import com.fhy8vp3u.auzj6fml.entity.SampleBoardEntity;
import com.fhy8vp3u.auzj6fml.model.Header;
import com.fhy8vp3u.auzj6fml.service.SampleBoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = { "SampleBoard" })
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SampleBoardController {
  private final SampleBoardService sampleBoardService;

  @ApiOperation(value = "SampleBoard SelectList", notes = "")
  @GetMapping("/api/sampleboard/list")
  public Header<List<SampleBoardDTO>> select001(@PageableDefault(sort = {"id"}) Pageable pageable, SearchConditionDTO reqDTO)  {
    return sampleBoardService.select001(pageable, reqDTO);
  }

  @ApiOperation(value = "SampleBoard SelectOne", notes = "")
  @GetMapping("/api/sampleboard/{id}")
  public SampleBoardDTO select002(@PathVariable("id") Long reqId) {
    return sampleBoardService.select002(reqId);
  }

  @ApiOperation(value = "SampleBoard InsertOne", notes = "")
  @PostMapping(value = "/api/sampleboard")
  public SampleBoardEntity insert001(@RequestBody SampleBoardDTO reqDTO) {
    return sampleBoardService.insert001(reqDTO);
  }

  @ApiOperation(value = "SampleBoard UpdateOne", notes = "")
  @PatchMapping(value = "/api/sampleboard")
  public SampleBoardEntity update001(@RequestBody SampleBoardDTO reqDTO) {
    return sampleBoardService.update001(reqDTO);
  }

  @ApiOperation(value = "SampleBoard DeleteOne", notes = "")
  @DeleteMapping("/api/sampleboard/{id}")
  public void delete001(@PathVariable("id") Long reqId) {
    sampleBoardService.delete001(reqId);
  }
}