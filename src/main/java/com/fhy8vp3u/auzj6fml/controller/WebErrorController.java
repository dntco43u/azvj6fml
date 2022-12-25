package com.fhy8vp3u.auzj6fml.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebErrorController implements ErrorController {
  static final String INDEX_PAGE = "/index.html";
  static final String ERROR_PAGE = "/error";

  @GetMapping("/error")
  public String redirctRoot() {
    return INDEX_PAGE;
  }

  public String getErrorPath() {
    return ERROR_PAGE;
  }
}