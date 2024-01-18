package ru.itis.controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itis.exception.ServiceException;

/**
 * Обработчик возникающих ошибок.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<ExceptionMessage> handleServiceException(ServiceException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(ExceptionMessage.builder()
                        .exceptionName(exception.getClass().getSimpleName())
                        .message(exception.getMessage())
                        .build()
                );
    }

    /**
     * Формирует ответ на основе всех исключений {@link Exception}.
     *
     * @param exception исключение
     * @return сформированный на основе исключения ответ
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ExceptionMessage onAllExceptions(Exception exception) {
        return ExceptionMessage.builder()
                .message(exception.getMessage())
                .exceptionName(exception.getClass().getSimpleName())
                .build();
    }
}
