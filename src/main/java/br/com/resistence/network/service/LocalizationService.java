package br.com.resistence.network.service;

import br.com.resistence.network.entity.Localization;
import br.com.resistence.network.repository.LocalizationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalizationService {

    private LocalizationRepository repository;

    public LocalizationService(LocalizationRepository repository) {
        this.repository = repository;
    }

    public Localization save(Localization localization) {
        return repository.save(localization);
    }

}
