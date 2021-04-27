package com.gstrial.matchodds.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MatchOddsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MatchOddsGeneralException.class, MatchNotFoundException.class})
    public ResponseEntity<Object> handleExceptions(Exception e) {
        MatchOddsErrorMessage matchOddsErrorMessage;
        if (e instanceof MatchOddsGeneralException) {
            matchOddsErrorMessage = new MatchOddsErrorMessage(e.getMessage(),
                ErrorType.GENERAL_ISSUE);
        } else {
            matchOddsErrorMessage = new MatchOddsErrorMessage(e.getMessage(),
                ErrorType.MATCH_NOT_FOUND);
        }
        return ResponseEntity.ok(matchOddsErrorMessage);
    }


}
