package com.org.cache.api.exception;

/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends NotFoundException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new user not found exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public UserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new user not found exception.
   *
   * @param message the message
   */
  public UserNotFoundException(String message) {
    super(message);
  }

  /**
   * Instantiates a new user not found exception.
   *
   * @param cause the cause
   */
  public UserNotFoundException(Throwable cause) {
    super(cause);
  }

}
