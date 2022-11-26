package kz.narxoz.springpandora2.Service;
import kz.narxoz.springpandora2.Entity.Rings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RingsService")
public interface RingsService {

    List<Rings> findAllRings();

    Rings saveRings(Rings rings);

    Rings findRing(Long id);

    void deleteRings(Long id);


}
