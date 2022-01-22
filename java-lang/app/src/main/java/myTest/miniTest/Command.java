package myTest.miniTest;

import java.util.ArrayList;

public class Command {

  String name;
  ArrayList params = new ArrayList();

  public Command (String name, String[] values) {
    this.name = name;
    for (String value : values) {
      params.add(value);
    }
  }

  public String getName() {
    return this.name;
  }

  public String getString(int paramIndex) {
    return (String) params.get(paramIndex);
  }

  public int getInt(int paramIndex) {
    return Integer.parseInt((String) params.get(paramIndex));
  }

  public int getParamSize() {
    return params.size();
  }





}
