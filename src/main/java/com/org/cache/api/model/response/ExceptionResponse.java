package com.org.cache.api.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A class to be use as DTO for rest service for exception.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse implements Serializable {

  private static final long serialVersionUID = 5776151413510893215L;
  /**
   * HTTP error code.
   */
  private int code;
  /**
   * HTTP error message.
   */
  private String errorMessage;
  /**
   * HTTP error datetime.
   */
  private long timeStamp;

  /**
   * Parameterized constructor.
   * 
   * @param {@link ExceptionResponseBuilder}
   */
  private ExceptionResponse(ExceptionResponseBuilder builder) {
    setCode(builder.code);
    setErrorMessage(builder.errorMessage);
    setTimeStamp(System.currentTimeMillis());
  }

  /**
   * Give {@link ExceptionResponseBuilder} instance.
   * 
   * @return {@link ExceptionResponseBuilder}
   */
  public static ExceptionResponseBuilder builder() {
    return new ExceptionResponseBuilder();
  }

  /**
   * Gives ExceptionResponseBuilder instance using given ExceptionResponse.
   * 
   * @param {@link ExceptionResponse}
   * @return {@link ExceptionResponseBuilder}
   */
  public static ExceptionResponseBuilder builder(ExceptionResponse copy) {
    ExceptionResponseBuilder builder = new ExceptionResponseBuilder();
    builder.errorMessage = copy.errorMessage;
    return builder;
  }

  /**
   * give code property.
   * 
   * @return
   */
  public int getCode() {
    return code;
  }

  /**
   * set code property.
   * 
   * @param code
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * give error message property.
   * 
   * @return error message
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * set error message property.
   * 
   * @param errorMessage
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * give timeStamp property.
   * 
   * @return timeStamp
   */
  public long getTimeStamp() {
    return timeStamp;
  }

  /**
   * set timeStamp property.
   * 
   * @param timeStamp
   */
  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  /**
   * A builder class for ProcessResponse.
   * 
   *
   */
  public static final class ExceptionResponseBuilder {
    /**
     * HTTP response code.
     */
    private int code;
    /**
     * HTTP response message.
     */
    private String errorMessage;

    /**
     * Non-parameterized constructor
     */
    private ExceptionResponseBuilder() {}

    /**
     * set error code to current instance and return same.
     * 
     * @param HTTP error code.
     * @return {@link ExceptionResponseBuilder}
     */
    public ExceptionResponseBuilder withExceptionCode(int val) {
      code = val;
      return this;
    }

    /**
     * set error message to current instance and return same.
     * 
     * @param HTTP error message
     * @return {@link ExceptionResponseBuilder}
     */
    public ExceptionResponseBuilder withErrorMessage(String val) {
      errorMessage = val;
      return this;
    }

    /**
     * return instance of {@link ExceptionResponse} using current instance.
     * 
     * @return {@link ExceptionResponse}
     */
    public ExceptionResponse build() {
      return new ExceptionResponse(this);
    }

  }
}
