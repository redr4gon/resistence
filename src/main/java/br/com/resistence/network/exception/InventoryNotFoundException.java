package br.com.resistence.network.exception;

public class InventoryNotFoundException extends Exception {

    public InventoryNotFoundException() {
        super("O inventário informado não foi encontrado!");
    }
}
