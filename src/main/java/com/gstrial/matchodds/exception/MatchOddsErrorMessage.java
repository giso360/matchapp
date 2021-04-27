package com.gstrial.matchodds.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchOddsErrorMessage {

    private String message;
    private ErrorType errorType;

}
