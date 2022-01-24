package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test02 {

  public static void main(String[] args) throws Exception {
    String jsonStr = "["
        + "{\"name\" : \"소보루\", \"maker\" : \"안데르센\"},"
        + "{\"name\" : \"단팥빵\", \"maker\" : \"안데르센\"},"
        + "{\"name\" : \"크림빵\", \"maker\" : \"안데르센\"}"
        + "]";

    System.out.println(jsonStr);

    ObjectMapper mapper = new ObjectMapper();

    Bread[] breads = mapper.readValue(jsonStr, Bread[].class);

    for (Bread bread : breads) {
      System.out.println(bread);

    }

  }

}
