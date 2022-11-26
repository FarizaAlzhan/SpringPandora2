package kz.narxoz.springpandora2.Service.Impl;

import kz.narxoz.springpandora2.Entity.Collections;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Repository.CollectionsRepository;
import kz.narxoz.springpandora2.Repository.RingsRepository;
import kz.narxoz.springpandora2.Service.CollectionsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CollectionsService")
public class CollectionsServiceImpl implements CollectionsService {
    @Autowired
    CollectionsRepository collectionsRepository;

    @Override
    public List<Collections> findAllCollections() {

        return collectionsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Collections saveCollections(Collections collections) {

        return collectionsRepository.save(collections);
    }

    @Override
    public Collections findCollection(Long id){

        return collectionsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCollections(Long id) {
        collectionsRepository.deleteById(id);
    }
}
