package com.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
класс отвечающий за обработку исключений во множестве контроллеров
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<WorkerIncorrectData> handleException(NoSuchWorkerException e) {
        WorkerIncorrectData workerIncorrectData = new WorkerIncorrectData();
        workerIncorrectData.setInfo(e.getMessage());

        return new ResponseEntity<>(workerIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<WorkerIncorrectData> handleException(Exception e) {
        WorkerIncorrectData workerIncorrectData = new WorkerIncorrectData();
        workerIncorrectData.setInfo(e.getMessage());

        return new ResponseEntity<>(workerIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
