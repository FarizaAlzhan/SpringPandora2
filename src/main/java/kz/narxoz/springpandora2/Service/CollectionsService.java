package kz.narxoz.springpandora2.Service;
import kz.narxoz.springpandora2.Entity.Collections;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CollectionsService")
public interface CollectionsService {

    List<Collections> findAllCollections();

    Collections saveCollections(Collections collections);

    Collections findCollection(Long id);

    void deleteCollections(Long id);


}
