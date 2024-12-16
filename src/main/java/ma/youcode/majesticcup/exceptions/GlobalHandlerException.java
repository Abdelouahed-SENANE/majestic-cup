package ma.youcode.majesticcup.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import ma.senane.utilities.dtos.ErrorDTO;
import ma.youcode.majesticcup.exceptions.custom.UserAlreadyExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import static ma.senane.utilities.response.Response.error;

@RestControllerAdvice
public class GlobalHandlerException {

    private static final Logger log = LogManager.getLogger(GlobalHandlerException.class);

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDTO> handleUnknownException(Exception e) {
//        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorDTO> handleExpiredJwtException(ExpiredJwtException e) {
        return error(HttpStatus.UNAUTHORIZED.value(), "The JWT token has expired.");
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDTO> handleBadCredentialsException(BadCredentialsException e) {
        return error(HttpStatus.UNAUTHORIZED.value(), "The username or password is incorrect.");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedException(AccessDeniedException e) {
        return error(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return error(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleIUsernameNotFoundException(UsernameNotFoundException e) {
        return error(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
