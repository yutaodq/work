//package zy.cy6.zyxt.web.errors;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import zy.cy6.zyxt.api.product.product.ProductNameNotUniqueException;
//
///**
// * Controller advice to translate the server side exceptions to client-friendly json structures.
// * The error response follows RFC7807 - Problem Details for HTTP APIs (https://tools.ietf.org/html/rfc7807)
// */
//@Slf4j
//@ControllerAdvice
////public class ExceptionTranslator implements ProblemHandling {
//public class ExceptionTranslator {
//
//  /**
//   * Post-process Problem payload to add the message key for front-end if needed
//   */
////  @Override
////  public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {
////    if (entity == null || entity.getBody() == null) {
////      return entity;
////    }
////    Problem problem = entity.getBody();
////    if (!(problem instanceof ConstraintViolationProblem || problem instanceof DefaultProblem)) {
////      return entity;
////    }
////    ProblemBuilder builder = Problem.builder().withType(Problem.DEFAULT_TYPE.equals(problem.getType()) ? ErrorConstants.DEFAULT_TYPE : problem.getType()).withStatus(problem.getStatus()).withTitle(problem.getTitle()).with("path", request.getNativeRequest(HttpServletRequest.class).getRequestURI());
////
////    if (problem instanceof ConstraintViolationProblem) {
////      builder.with("violations", ((ConstraintViolationProblem) problem).getViolations()).with("message", ErrorConstants.ERR_VALIDATION);
////      return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
////    } else {
////      builder.withCause(((DefaultProblem) problem).getCause()).withDetail(problem.getDetail()).withInstance(problem.getInstance());
////      problem.getParameters().forEach(builder::with);
////      if (!problem.getParameters().containsKey("message") && problem.getStatus() != null) {
////        builder.with("message", "error.http." + problem.getStatus().getStatusCode());
////      }
////      return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
////    }
////  }
//
////  @Override
////  public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @Nonnull NativeWebRequest request) {
////    BindingResult result = ex.getBindingResult();
////    List<FieldErrorVM> fieldErrors = result.getFieldErrors().stream().map(f -> new FieldErrorVM(f.getObjectName(), f.getField(), f.getCode())).collect(Collectors.toList());
////
////    Problem problem = Problem.builder().withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE).withTitle("Method argument not valid").withStatus(defaultConstraintViolationStatus()).with("message", ErrorConstants.ERR_VALIDATION).with("fieldErrors", fieldErrors).build();
////    return create(ex, problem, request);
////  }
//  @ExceptionHandler(NullPointerException.class)
//  public ResponseEntity nullPointerException() {
//    return ResponseEntity.badRequest().body("工具名称输入的不正确！");
//  }
//
//  @ExceptionHandler(ProductNameNotUniqueException.class)
//  public ResponseEntity ProductNameNotUniqueException() {
//    log.info("ProductNameNotUniqueExceptionProductNameNotUniqueExceptionProductNameNotUniqueException");
//    return ResponseEntity.badRequest().body("ProductNameNotUniqueExceptionProductNameNotUniqueException！");
//  }
//
////  public ResponseEntity<Problem> handleNoSuchElementException(NullPointerException ex, NativeWebRequest request) {
////    Problem problem = Problem.builder().withStatus(Status.NOT_FOUND).with("message", ErrorConstants.ENTITY_NOT_FOUND_TYPE).build();
////    return create(ex, problem, request);
////  }
//
////  @ExceptionHandler(NoSuchElementException.class)
////  public ResponseEntity<Problem> handleNoSuchElementException(NoSuchElementException ex, NativeWebRequest request) {
////    Problem problem = Problem.builder().withStatus(Status.NOT_FOUND).with("message", ErrorConstants.ENTITY_NOT_FOUND_TYPE).build();
////    return create(ex, problem, request);
////  }
////
////  @ExceptionHandler(BadRequestAlertException.class)
////  public ResponseEntity<Problem> handleBadRequestAlertException(BadRequestAlertException ex, NativeWebRequest request) {
////    return create(ex, request, HeaderUtil.createFailureAlert(ex.getEntityName(), ex.getErrorKey(), ex.getMessage()));
////  }
////
////  @ExceptionHandler(ConcurrencyFailureException.class)
////  public ResponseEntity<Problem> handleConcurrencyFailure(ConcurrencyFailureException ex, NativeWebRequest request) {
////    Problem problem = Problem.builder().withStatus(Status.CONFLICT).with("message", ErrorConstants.ERR_CONCURRENCY_FAILURE).build();
////    return create(ex, problem, request);
////  }
//}
