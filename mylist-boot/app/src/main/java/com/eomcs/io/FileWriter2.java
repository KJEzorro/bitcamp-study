package com.eomcs.io;

import java.io.FileWriter;

public class FileWriter2 {

  FileWriter out;

  public FileWriter2(String filename) throws Exception {
    out = new FileWriter(filename);
  }

  public void println(String str) throws Exception {
    out.write(str + '\n');
  }

  public void close() throws Exception{
    out.close();
  }

}
