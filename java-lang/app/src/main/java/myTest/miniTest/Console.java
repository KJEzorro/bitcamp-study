package myTest.miniTest;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

  Scanner in = new Scanner(System.in);

  Command prompt() {
    System.out.print("> ");
    String[] values = in.nextLine().split(" ");
    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  void close() {
    in.close();
  }
}
