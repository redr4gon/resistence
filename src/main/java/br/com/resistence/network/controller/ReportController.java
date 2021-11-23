package br.com.resistence.network.controller;

import br.com.resistence.network.controller.response.ReportInventoryResponse;
import br.com.resistence.network.controller.response.ReportMessageResponse;
import br.com.resistence.network.facade.ReportFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/report")
@RestController
public class ReportController {

    private final ReportFacade facade;

    public ReportController(ReportFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/black-force")
    public ReportMessageResponse totalRebelBlackForce() {
        return facade.totalRebelBlackForce();
    }

    @GetMapping("/rebels")
    public ReportMessageResponse totalRebel() {
        return facade.totalRebel();
    }

    @GetMapping("/inventory")
    public ReportInventoryResponse totalInventory() {
        return facade.totalInventory();
    }

    @GetMapping("/points")
    public ReportMessageResponse totalRebelBlackForcePoints() {
        return facade.totalRebelBlackForcePoints();
    }
}
