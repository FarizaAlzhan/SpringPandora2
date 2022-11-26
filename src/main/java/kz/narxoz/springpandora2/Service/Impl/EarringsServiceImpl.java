package kz.narxoz.springpandora2.Service.Impl;

import kz.narxoz.springpandora2.Entity.Earrings;
import kz.narxoz.springpandora2.Repository.EarringsRepository;
import kz.narxoz.springpandora2.Repository.RingsRepository;
import kz.narxoz.springpandora2.Service.EarringsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EarringsService")
public class EarringsServiceImpl implements EarringsService {
    @Autowired
    EarringsRepository earringsRepository;

    @Override
    public List<Earrings> findAllEarrings() {

        return earringsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Earrings saveEarrings(Earrings earrings) {

        return earringsRepository.save(earrings);
    }

    @Override
    public Earrings findEarring(Long id){

        return earringsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEarrings(Long id) {
        earringsRepository.deleteById(id);
    }
}
