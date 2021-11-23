package br.com.resistence.network.repository;

import br.com.resistence.network.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("select i from Rebel r left join r.inventories i where r.id = ?1")
    List<Inventory> findAllByRebelId(Long id);

}