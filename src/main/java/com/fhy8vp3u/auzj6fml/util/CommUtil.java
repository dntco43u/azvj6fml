package com.fhy8vp3u.auzj6fml.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommUtil {
  
  private CommUtil() {
  }
  
  public static String formatDate(LocalDateTime sqlDate) {
    return sqlDate == null ? null : sqlDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
  }
}
