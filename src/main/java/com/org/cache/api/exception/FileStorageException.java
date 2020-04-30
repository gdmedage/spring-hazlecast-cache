package com.org.cache.api.exception;

/**
 * The Class FileStorageException.
 */
public class FileStorageException extends MyException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new file storage exception.
   *
   * @param message the message
   */
  public FileStorageException(String message) {
    super(message);
  }

  /**
   * Instantiates a new file storage exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public FileStorageException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new file storage exception.
   *
   * @param cause the cause
   */
  public FileStorageException(Throwable cause) {
    super(cause);
  }


}
