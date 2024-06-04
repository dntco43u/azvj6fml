package com.fhy8vp3u.azvj6fml.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
  private int pageSize; // Maximum number of posts displayed per page
  int page; // current page
  int block; // current block
  int totalListCnt; // total number of posts
  int totalPageCnt; // total number of pages
  int totalBlockCnt; // total number of segments
  int startPage; // start page
  int endPage; // last page
  int prevBlock; // the last page of the previous section
  int nextBlock; // start page for next section
  int startIndex; // index

  public Pagination(Integer totalListCnt, Integer page, Integer pageSize, Integer blockSize) {
    this.pageSize = pageSize;
    this.page = page; // current page
    this.totalListCnt = totalListCnt; // total number of posts
    totalPageCnt = (int) Math.ceil(totalListCnt * 1.0 / this.pageSize); // total number of pages
    totalBlockCnt = (int) Math.ceil(totalPageCnt * 1.0 / blockSize); // total number of blocks
    block = (int) Math.ceil((this.page * 1.0) / blockSize); // current block
    startPage = ((block - 1) * blockSize + 1); // block start page
    endPage = startPage + blockSize - 1; // last page of block
    if (endPage > totalPageCnt) // block last page validation
      endPage = totalPageCnt;
    prevBlock = (block * blockSize) - blockSize; // previous block (when clicked, last page of previous block)
    if (prevBlock < 1) // previous block validation
      prevBlock = 1;
    nextBlock = (block * blockSize + 1); // next block (when clicked, first page of next block)
    if (nextBlock > totalPageCnt) // next block validation
      nextBlock = totalPageCnt;
    startIndex = (this.page - 1) * this.pageSize;
  }
}