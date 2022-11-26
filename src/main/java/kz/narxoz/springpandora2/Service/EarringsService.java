package kz.narxoz.springpandora2.Service;
import kz.narxoz.springpandora2.Entity.Earrings;
import kz.narxoz.springpandora2.Entity.Rings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EarringsService")
public interface EarringsService {

    List<Earrings> findAllEarrings();

    Earrings saveEarrings(Earrings earrings);

    Earrings findEarring(Long id);

    void deleteEarrings(Long id);


}
