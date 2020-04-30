package com.org.cache.api.aspect;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.org.cache.api.exception.MyException;
import com.org.cache.api.exception.NotFoundException;
import com.org.cache.api.exception.UserNotFoundException;
import com.org.cache.api.exception.ValidationException;
import com.org.cache.api.model.response.ExceptionResponse;


/**
 * Controller Advice for Exception Handling.
 * 
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

  /**
   * {@link ValidationException} handler.
   *
   * @param ex {@link ValidationException}
   * @return ResponseEntity with message and 422 error code.
   */
  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ExceptionResponse> validationExceptionHandler(ValidationException ex) {
    LOG.error("Validation Exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.UNPROCESSABLE_ENTITY.value()).build();

    return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(NotFoundException ex) {
    LOG.error("NotFoundException Exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.NOT_FOUND.value()).build();

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ExceptionResponse> userFoundExceptionHandler(UserNotFoundException ex) {
    LOG.error("UserNotFoundException Exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.NOT_FOUND.value()).build();

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MyException.class)
  public ResponseEntity<ExceptionResponse> iiawExceptionHandler(MyException ex) {
    LOG.error("IIAWException Exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }



  /**
   * Exception handler for {@link MultipartException}.
   * 
   * @param ex {@link MultipartException}
   * @return ResponseEntity with message and 500 error code.
   */
  @ExceptionHandler(MultipartException.class)
  public ResponseEntity<ExceptionResponse> uploadedAFileTooLarge(MultipartException ex) {
    LOG.error("Mutlipart exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }



  /**
   * Customize the response for MethodArgumentNotValidException.
   * <p>
   * This method delegates to {@link #handleExceptionInternal}.
   * 
   * @param ex the exception
   * @param headers the headers to be written to the response
   * @param status the selected response status
   * @param request the current request
   * @return a {@code ResponseEntity} instance
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    List<String> errors = new ArrayList<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      errors.add(error.getDefaultMessage());
    });
    LOG.error("Form Validation failed due to following errors: {}", errors);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(errors.get(0))
        .withExceptionCode(HttpStatus.UNPROCESSABLE_ENTITY.value()).build();
    return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
