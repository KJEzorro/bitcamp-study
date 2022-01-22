package myTest.miniTest;

public class MiniTest1 {



  public static void main(String[] args) {

    Console console = new Console();
    CommandHandler commandHandler = new CommandHandler();


    while(true) {

      Command command = console.prompt();

      if (command.getName().equals("quit") || command.getName().equals("exit")) {
        break;

      } else if (command.getName().equals("")) {
        continue;

      } else if (command.getName().equals("help")) {
        commandHandler.doHelp();

      } else if (command.getName().equals("add")) {
        commandHandler.doAdd(command);

      } else if (command.getName().equals("minus")) {
        commandHandler.doMinus(command);

      } else {
        System.out.println("다시 입력하세요.");
      }
    }
    console.close();
  }














}







