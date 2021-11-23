package br.com.resistence.network.mapper;

import br.com.resistence.network.controller.request.RebelRequest;
import br.com.resistence.network.controller.response.RebelResponse;
import br.com.resistence.network.entity.Rebel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RebelMapper {

    public abstract Rebel toRebel(RebelRequest rebelRequest);

    public abstract RebelResponse toRebelResponse(Rebel rebel);

}