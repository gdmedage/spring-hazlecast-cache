package com.org.cache.api.exception;

/**
 * The Class IIAWException.
 */
public class MyException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new IIAW exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public MyException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new IIAW exception.
   *
   * @param message the message
   */
  public MyException(String message) {
    super(message);
  }

  /**
   * Instantiates a new IIAW exception.
   *
   * @param cause the cause
   */
  public MyException(Throwable cause) {
    super(cause);
  }

}
