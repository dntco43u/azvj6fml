package com.fhy8vp3u.auzj6fml.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fhy8vp3u.auzj6fml.domain.SampleBoardDTO;
import com.fhy8vp3u.auzj6fml.domain.SearchConditionDTO;
import com.fhy8vp3u.auzj6fml.entity.SampleBoardEntity;
import com.fhy8vp3u.auzj6fml.entity.SampleBoardRepository;
import com.fhy8vp3u.auzj6fml.entity.SampleBoardRepositoryCustom;
import com.fhy8vp3u.auzj6fml.model.Header;
import com.fhy8vp3u.auzj6fml.model.Pagination;
import com.fhy8vp3u.auzj6fml.util.CommUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleBoardService {
  private final SampleBoardRepository sampleBoardRepository;
  private final SampleBoardRepositoryCustom sampleBoardRepositoryCustom;

  public Header<List<SampleBoardDTO>> select001(Pageable pageable, SearchConditionDTO reqDTO) {
    Page<SampleBoardEntity> sampleBoardEntity = sampleBoardRepositoryCustom.findAllBySearchCondition(pageable, reqDTO);
    List<SampleBoardDTO> resList = new ArrayList<>();
    for (SampleBoardEntity entity : sampleBoardEntity) {
      SampleBoardDTO dto = SampleBoardDTO.builder()
      .id(entity.getId())
      .author(entity.getAuthor())
      .title(entity.getTitle())
      .contents(entity.getContents())
      .createUser(entity.getCreateUser())
      .createTime(CommUtil.formatDate(entity.getCreateTime()))
      .updateUser(entity.getUpdateUser())
      .updateTime(CommUtil.formatDate(entity.getUpdateTime()))
      .build();
      resList.add(dto);
    }
    log.info("resList={}", resList);
    Pagination pagination = new Pagination((int) sampleBoardEntity.getTotalElements(), pageable.getPageNumber() + 1,
    pageable.getPageSize(), 10);
    return Header.setResultOK(resList, pagination);
  }

  public SampleBoardDTO select002(Long reqId) {
    log.info("reqId={}", reqId);
    SampleBoardEntity sampleBoardEntity = sampleBoardRepository.findById(reqId)
    .orElseThrow(() -> new RuntimeException("select002 no data"));
    SampleBoardDTO resDto = SampleBoardDTO.builder()
    .id(sampleBoardEntity.getId())
    .author(sampleBoardEntity.getAuthor())
    .title(sampleBoardEntity.getTitle())
    .contents(sampleBoardEntity.getContents())
    .createUser(sampleBoardEntity.getCreateUser())
    .createTime(CommUtil.formatDate(sampleBoardEntity.getCreateTime()))
    .updateUser(sampleBoardEntity.getUpdateUser())
    .updateTime(CommUtil.formatDate(sampleBoardEntity.getUpdateTime()))
    .build();
    log.info("resDto={}", resDto);
    return resDto;
  }
  
  public SampleBoardEntity insert001(SampleBoardDTO reqDTO) {
    log.info("reqDTO={}", reqDTO);
    SampleBoardEntity resEntity = SampleBoardEntity.builder()
    .author(reqDTO.getAuthor())
    .title(reqDTO.getTitle())
    .contents(reqDTO.getContents())
    .createUser(reqDTO.getCreateUser())
    .createTime(LocalDateTime.now())
    .build();
    return sampleBoardRepository.save(resEntity);
  }
  
  public SampleBoardEntity update001(SampleBoardDTO reqDTO) {
    SampleBoardEntity resEntity = sampleBoardRepository.findById(reqDTO.getId())
    .orElseThrow(() -> new RuntimeException("update001 no data"));
    resEntity.setTitle(reqDTO.getTitle());
    resEntity.setContents(reqDTO.getContents());
    resEntity.setUpdateUser(reqDTO.getCreateUser());
    resEntity.setUpdateTime(LocalDateTime.now());
    return sampleBoardRepository.save(resEntity);
  }
  
  public void delete001(Long reqId) {
    log.info("id={}", reqId);
    SampleBoardEntity sampleBoardEntity = sampleBoardRepository.findById(reqId)
    .orElseThrow(() -> new RuntimeException("delete001 no data"));
    sampleBoardRepository.delete(sampleBoardEntity);
  } 
}
