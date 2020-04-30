package com.org.cache.api.exception;

/**
 * The Class ValidationException.
 */
public class ValidationException extends RuntimeException {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new validation exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public ValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new validation exception.
   *
   * @param message the message
   */
  public ValidationException(String message) {
    super(message);
  }

  /**
   * Instantiates a new validation exception.
   *
   * @param cause the cause
   */
  public ValidationException(Throwable cause) {
    super(cause);
  }
}
