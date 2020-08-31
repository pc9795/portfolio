package com.prashantchaubey.exceptions;

import com.prashantchaubey.utils.Constants;
import com.prashantchaubey.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

  @ExceptionHandler(NoHandlerFoundException.class)
  public void handleNoHandlerFound(Exception e, HttpServletResponse response) {
    Utils.updateErrorInResponse(
        HttpServletResponse.SC_NOT_FOUND,
        String.format(Constants.ErrorMsg.NOT_FOUND, e.getMessage()),
        response);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public void handleResourceNotFound(Exception e, HttpServletResponse response) {
    Utils.updateErrorInResponse(
        HttpServletResponse.SC_NOT_FOUND,
        String.format(Constants.ErrorMsg.NOT_FOUND, e.getMessage()),
        response);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public void handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exc, HttpServletResponse response) {
    Map<String, String> errors = new HashMap<>();
    exc.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              errors.put(fieldName, errorMessage);
            });
    Utils.updateErrorInResponse(HttpServletResponse.SC_BAD_REQUEST, errors.toString(), response);
  }

  @ExceptionHandler({
    HttpMessageNotReadableException.class,
    HttpMediaTypeNotSupportedException.class,
    MethodArgumentTypeMismatchException.class
  })
  public void handleInvalidClientRequests(HttpServletResponse response) {
    Utils.updateErrorInResponse(
        HttpServletResponse.SC_BAD_REQUEST, Constants.ErrorMsg.BAD_REQUEST, response);
  }

  @ExceptionHandler({
    BadDataException.class,
    MissingServletRequestParameterException.class,
    HttpRequestMethodNotSupportedException.class,
    ServletException.class
  })
  public void handleInvalidClientRequestsWithExcMessages(
      Exception e, HttpServletResponse response) {
    Utils.updateErrorInResponse(HttpServletResponse.SC_BAD_REQUEST, e.getMessage(), response);
  }

  @ExceptionHandler({BadCredentialsException.class})
  public void handleBadCredentialsException(HttpServletResponse response) {
    Utils.updateErrorInResponse(
        HttpServletResponse.SC_UNAUTHORIZED, Constants.ErrorMsg.BAD_CREDENTIALS, response);
  }

  @ExceptionHandler(Exception.class)
  public void handleAll(Exception e, HttpServletResponse response) {
    LOGGER.error(String.format("Something bad happened:%s", e.getMessage()), e);
    Utils.updateErrorInResponse(
        HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
        Constants.ErrorMsg.INTERNAL_SERVER_ERROR,
        response);
  }
}
