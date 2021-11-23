package br.com.resistence.network.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidTradeException.class)
    public ExceptionObject invalidTradeException(InvalidTradeException invalidTradeException) {
        return new ExceptionObject(InvalidTradeException.class.getSimpleName(), invalidTradeException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InventoryNotFoundException.class)
    public ExceptionObject inventoryNotFoundException(InventoryNotFoundException inventoryNotFoundException) {
        return new ExceptionObject(InventoryNotFoundException.class.getSimpleName(), inventoryNotFoundException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RebelNotFoundException.class)
    public ExceptionObject rebelNotFoundException(RebelNotFoundException rebelNotFoundException) {
        return new ExceptionObject(RebelNotFoundException.class.getSimpleName(), rebelNotFoundException.getMessage());
    }
}
