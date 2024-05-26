package CodeIt.Ytrip.common.exception;

import CodeIt.Ytrip.common.reponse.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> UserExceptionHandler(UserException e) {

        log.error("User Exception = {}, {}", e.getMessage(), e.getStatus());
        if (e.getStatus().equals(StatusCode.USER_NOT_FOUND.getCode())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getStatus(), e.getMessage()));
        }

        if (e.getStatus().equals(StatusCode.DUPLICATE_EMAIL.getCode())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.of(e.getStatus(), e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorResponse.of(e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<?> TokenExceptionHandler(TokenException e) {
        log.error("Token Exception = {}, {}", e.getMessage(), e.getStatus());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getStatus(), e.getMessage()));
    }


}
