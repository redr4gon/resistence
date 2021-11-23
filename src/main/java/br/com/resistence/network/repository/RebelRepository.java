package br.com.resistence.network.repository;

import br.com.resistence.network.entity.Rebel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebelRepository extends JpaRepository<Rebel, Long> {

    @Query("select r from Rebel r where r.blackForceReport >= 3")
    List<Rebel> findAllByBlackForceReport();

    @Query("select r from Rebel r where r.blackForceReport < 3")
    List<Rebel> findAllNotByBlackForceReport();

}
