package kz.narxoz.springpandora2.Service;
import kz.narxoz.springpandora2.Entity.Pendants;
import kz.narxoz.springpandora2.Entity.Rings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PendantsService")
public interface PendantsService {

    List<Pendants> findAllPendants();

    Pendants savePendants(Pendants pendants);

    Pendants findPendant(Long id);

    void deletePendants(Long id);


}
