package com.fhy8vp3u.azvj6fml.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
  private LocalDateTime transactionTime;
  private String resultCode;
  private String description;
  private T data;
  private Pagination pagination;

  @SuppressWarnings("unchecked")
  public static <T> Header<T> setResultOK() {
    return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK").build();
  }

  @SuppressWarnings("unchecked")
  public static <T> Header<T> setResultOK(T data) {
    return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK")
    .data(data).build();
  }

  @SuppressWarnings("unchecked")
  public static <T> Header<T> setResultOK(T data, Pagination pagination) {
    return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK")
    .data(data).pagination(pagination).build();
  }

  @SuppressWarnings("unchecked")
  public static <T> Header<T> setResultError(String description) {
    return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("ERROR")
    .description(description).build();
  }
}
