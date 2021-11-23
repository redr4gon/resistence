package br.com.resistence.network.service;

import br.com.resistence.network.controller.request.RebelRequest;
import br.com.resistence.network.controller.response.RebelResponse;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.exception.RebelNotFoundException;
import br.com.resistence.network.mapper.RebelMapper;
import br.com.resistence.network.repository.RebelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebelService {

    private RebelRepository repository;
    private RebelMapper rebelMapper;

    public RebelService(RebelRepository repository, RebelMapper rebelMapper) {
        this.repository = repository;
        this.rebelMapper = rebelMapper;
    }

    public RebelResponse saveRebel(RebelRequest rebel) {
        return rebelMapper.toRebelResponse(repository.save(rebelMapper.toRebel(rebel)));
    }

    public Rebel findOne(Long id) throws RebelNotFoundException {
        return repository.findById(id).orElseThrow(RebelNotFoundException::new);
    }

    public RebelResponse reportBlackForce(Long id) throws RebelNotFoundException {
        Rebel rebel = repository.findById(id).orElseThrow(RebelNotFoundException::new);
        rebel.reportBlackForce();
        return rebelMapper.toRebelResponse(repository.save(rebel));
    }

    public List<Rebel> findAll() {
        return repository.findAll();
    }

    public List<Rebel> findAllBlackForce() {
        return repository.findAllByBlackForceReport();
    }

    public List<Rebel> findAllNotBlackForce() {
        return repository.findAllNotByBlackForceReport();
    }

}
