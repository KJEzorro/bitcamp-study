package com.eomcs.mylist.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultMap {

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";

  private String status;
  private Object data;
}
