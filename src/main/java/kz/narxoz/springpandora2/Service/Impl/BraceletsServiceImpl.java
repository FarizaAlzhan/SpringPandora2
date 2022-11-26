package kz.narxoz.springpandora2.Service.Impl;

import kz.narxoz.springpandora2.Entity.Bracelets;
import kz.narxoz.springpandora2.Repository.BraceletsRepository;
import kz.narxoz.springpandora2.Service.BraceletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("BraceletsService")
public class BraceletsServiceImpl implements BraceletsService {
    @Autowired
    BraceletsRepository braceletsRepository;

    @Override
    public List<Bracelets> findAllBracelets() {

        return braceletsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Bracelets saveBracelets(Bracelets bracelets) {

        return braceletsRepository.save(bracelets);
    }

    @Override
    public Bracelets findBracelet(Long id){

        return braceletsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBracelets(Long id) {
        braceletsRepository.deleteById(id);
    }
}
