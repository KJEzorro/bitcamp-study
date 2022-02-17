package com.eomcs.app2.net;


// 서버의 ScoreTable을 다루다가 예외가 발생했을 때
// 그 상황을 직관적으로 알 수 있도록
// 별도의 서브 클래스를 정의하였다.
// => 즉 예외가 발생했을 때 예외 클래스 이름만으로도 
//    어떤 상황에서 발생된 예외인지 바로 알 수 있도록 하기 위함이다. 
public class ScoreTableException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ScoreTableException() {
    super();
  }

  public ScoreTableException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ScoreTableException(String message, Throwable cause) {
    super(message, cause);
  }

  public ScoreTableException(String message) {
    super(message);
  }

  public ScoreTableException(Throwable cause) {
    super(cause);
  }



}
