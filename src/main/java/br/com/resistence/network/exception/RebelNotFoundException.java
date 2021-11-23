package br.com.resistence.network.exception;

public class RebelNotFoundException extends Exception {

    public RebelNotFoundException() {
        super("O rebelde informado não foi encontrado!");
    }
}
