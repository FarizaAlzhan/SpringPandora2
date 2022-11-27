package kz.narxoz.springpandora2.Service.Impl;

import kz.narxoz.springpandora2.Entity.Pendants;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Repository.PendantsRepository;
import kz.narxoz.springpandora2.Repository.RingsRepository;
import kz.narxoz.springpandora2.Service.PendantsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PendantsService")
public class PendantsServiceImpl implements PendantsService {
    @Autowired
    PendantsRepository pendantsRepository;

    @Override
    public List<Pendants> findAllPendants() {

        return pendantsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Pendants savePendants(Pendants pendants) {

        return pendantsRepository.save(pendants);
    }

    @Override
    public Pendants findPendant(Long id){

        return pendantsRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePendants(Long id) {
        pendantsRepository.deleteById(id);
    }
}
