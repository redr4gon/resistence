package br.com.resistence.network.facade;

import br.com.resistence.network.controller.request.LocalizationRequest;
import br.com.resistence.network.controller.response.LocalizationResponse;
import br.com.resistence.network.entity.Localization;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.exception.RebelNotFoundException;
import br.com.resistence.network.mapper.LocalizationMapper;
import br.com.resistence.network.service.LocalizationService;
import br.com.resistence.network.service.RebelService;
import org.springframework.stereotype.Component;

@Component
public class RebelFacade {

    private LocalizationService localizationService;
    private RebelService rebelService;
    private LocalizationMapper mapper;

    public RebelFacade(LocalizationService localizationService, RebelService rebelService, LocalizationMapper mapper) {
        this.localizationService = localizationService;
        this.rebelService = rebelService;
        this.mapper = mapper;
    }

    public LocalizationResponse changeLocalization(Long id, LocalizationRequest localization) throws RebelNotFoundException {

        Rebel rebel = rebelService.findOne(id);

        Localization local = rebel.getLocalization();
        local.setGalaxyName(localization.getGalaxyName());
        local.setLatitude(localization.getLatitude());
        local.setLongitude(localization.getLongitude());

        localizationService.save(local);

        return mapper.toLocalizationResponse(local);
    }
}
