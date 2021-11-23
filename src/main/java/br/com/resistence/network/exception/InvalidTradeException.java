package br.com.resistence.network.exception;

public class InvalidTradeException extends Exception {

    public InvalidTradeException() {
        super("A troca é inválida! Ela deve obedecer a pontuação de inventários!");
    }

    public InvalidTradeException(String message) {
        super(message);
    }
}
