package com.eomcs.mylist.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultMap {
  private String status;
  private Object data;

}
