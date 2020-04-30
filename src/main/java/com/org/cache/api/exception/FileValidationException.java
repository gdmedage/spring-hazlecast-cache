package com.org.cache.api.exception;

/**
 * The Class FileValidationException.
 */
public class FileValidationException extends ValidationException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new file validation exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public FileValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new file validation exception.
   *
   * @param message the message
   */
  public FileValidationException(String message) {
    super(message);
  }

  /**
   * Instantiates a new file validation exception.
   *
   * @param cause the cause
   */
  public FileValidationException(Throwable cause) {
    super(cause);
  }

}
