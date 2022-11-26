package kz.narxoz.springpandora2.Service;
import kz.narxoz.springpandora2.Entity.Charms;
import kz.narxoz.springpandora2.Entity.Rings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CharmsService")
public interface CharmsService {

    List<Charms> findAllCharms();

    Charms saveCharms(Charms charms);

    Charms findCharm(Long id);

    void deleteCharms(Long id);


}
