package br.com.resistence.network.controller;

import br.com.resistence.network.controller.request.InventoryTradeRequest;
import br.com.resistence.network.exception.InvalidTradeException;
import br.com.resistence.network.exception.InventoryNotFoundException;
import br.com.resistence.network.exception.RebelNotFoundException;
import br.com.resistence.network.facade.InventoryFacade;
import br.com.resistence.network.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/inventory")
@RestController
public class InventoryController {

    private final InventoryFacade facade;

    public InventoryController(InventoryFacade facade) {
        this.facade = facade;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void tradeItems(@RequestBody InventoryTradeRequest request) throws InvalidTradeException,
            InventoryNotFoundException, RebelNotFoundException {
        facade.tradeItems(request);
    }
}










