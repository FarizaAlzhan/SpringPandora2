package kz.narxoz.springpandora2.Service.Impl;

import kz.narxoz.springpandora2.Entity.Bracelets;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Repository.BraceletsRepository;
import kz.narxoz.springpandora2.Repository.RingsRepository;
import kz.narxoz.springpandora2.Service.BraceletsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RingsService")
public class RingsServiceImpl implements RingsService {
    @Autowired
    RingsRepository ringsRepository;

    @Override
    public List<Rings> findAllRings() {

        return ringsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Rings saveRings(Rings rings) {

        return ringsRepository.save(rings);
    }

    @Override
    public Rings findRing(Long id){

        return ringsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRings(Long id) {
        ringsRepository.deleteById(id);
    }
}
