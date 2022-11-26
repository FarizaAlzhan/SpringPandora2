package kz.narxoz.springpandora2.Service.Impl;

import kz.narxoz.springpandora2.Entity.Charms;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Repository.CharmsRepository;
import kz.narxoz.springpandora2.Repository.RingsRepository;
import kz.narxoz.springpandora2.Service.CharmsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CharmsService")
public class CharmsServiceImpl implements CharmsService {
    @Autowired
    CharmsRepository charmsRepository;

    @Override
    public List<Charms> findAllCharms() {

        return charmsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Charms saveCharms(Charms charms) {

        return charmsRepository.save(charms);
    }

    @Override
    public Charms findCharm(Long id){

        return charmsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCharms(Long id) {
        charmsRepository.deleteById(id);
    }
}
