package br.com.resistence.network.repository;

import br.com.resistence.network.entity.Localization;
import br.com.resistence.network.entity.Rebel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {
}
