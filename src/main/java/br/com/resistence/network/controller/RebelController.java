package br.com.resistence.network.controller;

import br.com.resistence.network.controller.request.LocalizationRequest;
import br.com.resistence.network.controller.request.RebelRequest;
import br.com.resistence.network.controller.response.LocalizationResponse;
import br.com.resistence.network.controller.response.RebelResponse;
import br.com.resistence.network.entity.Localization;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.exception.RebelNotFoundException;
import br.com.resistence.network.facade.RebelFacade;
import br.com.resistence.network.service.RebelService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rebel")
@RestController
public class RebelController {

    private RebelService service;
    private RebelFacade facade;

    public RebelController(RebelService service, RebelFacade facade) {
        this.service = service;
        this.facade = facade;
    }

    @PostMapping
    public RebelResponse save(@Validated @RequestBody RebelRequest rebel) {
        return service.saveRebel(rebel);
    }

    @PutMapping("/{id}/localization")
    public LocalizationResponse changeLocalization(@PathVariable Long id, @Validated @RequestBody LocalizationRequest localization) throws RebelNotFoundException {
        return facade.changeLocalization(id, localization);
    }

    @PutMapping("/{id}/black-force")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public RebelResponse reportBlackForce(@PathVariable Long id) throws RebelNotFoundException {
        return service.reportBlackForce(id);
    }

}
