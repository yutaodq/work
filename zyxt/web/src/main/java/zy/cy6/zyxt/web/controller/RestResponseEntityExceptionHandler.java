package zy.cy6.zyxt.web.controller;
/*
https://github.com/sky233/shared-bike
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import zy.cy6.zyxt.api.exception.DomainException;
import zy.cy6.zyxt.api.help.MessagesHelper;

import static com.google.common.base.Strings.isNullOrEmpty;
import static zy.cy6.zyxt.api.exception.ErrorCode.VIOLATION_CONSTRAINT;
import static zy.cy6.zyxt.api.exception.ErrorMessage.of;
import static zy.cy6.zyxt.api.exception.ErrorMessage.unKnown;

@Slf4j
//@ControllerAdvice(basePackages = "zy.cy6.zyxt")
@ControllerAdvice()

//@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  private final MessagesHelper messagesHelper;

  @Autowired
  public RestResponseEntityExceptionHandler(MessagesHelper messagesHelper) {
    super();
    this.messagesHelper = messagesHelper;
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    final String bodyOfResponse = "HttpMessageNotReadableException";
    log.error(bodyOfResponse, ex);
    return handleExceptionInternal(ex, unKnown(bodyOfResponse), headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    final String bodyOfResponse = getMethodArgumentNotValidMessages(ex);
    log.error(bodyOfResponse, ex);
    return handleExceptionInternal(ex, of(VIOLATION_CONSTRAINT, bodyOfResponse), headers, HttpStatus.BAD_REQUEST, request);
  }

  private String getMethodArgumentNotValidMessages(final MethodArgumentNotValidException ex) {
    StringBuilder sb = new StringBuilder();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      sb.append("[").append(((FieldError) error).getField()).append(error.getDefaultMessage()).append("] ");
    }
    return sb.toString();
  }


  //  //设置此handler处理所有异常
  @ExceptionHandler()
  public ResponseEntity defaultErrorHandler(Exception e) {
    log.info("处理所有的异常");
    return ResponseEntity.badRequest().body("不知道的异常！");
  }

//  @ExceptionHandler(NoHandlerFoundException.class)
//  public ResponseEntity handlerNoFound(NoHandlerFoundException ex) {
//    log.error("找不到-------错误处理器时");
//    return ResponseEntity.badRequest().body("不知道的异常！");
//  }

  @ExceptionHandler(value = DomainException.class)
  public ResponseEntity<Object> handleDomainException(final DomainException ex, final WebRequest request) {
    log.info("处理所有的异常DomainException");
    log.error("Domain execution error", ex);
    String bodyOfResponse = null;
    if (!isNullOrEmpty(ex.getMessageCode())) {
      bodyOfResponse = messagesHelper.get(ex.getMessageCode(), ex.getArgs());
    }
    return ResponseEntity.badRequest().body(of(ex.getCode(), bodyOfResponse));
//    return ResponseEntity.badRequest().body("不知道的异常！");

  }


  @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class})
  public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
    final String bodyOfResponse = "应用程序错误（Internal Error）";
    log.error(bodyOfResponse, ex);
    return handleExceptionInternal(ex, unKnown(bodyOfResponse), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }


}