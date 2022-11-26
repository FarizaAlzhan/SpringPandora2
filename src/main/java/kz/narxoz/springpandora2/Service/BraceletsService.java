package kz.narxoz.springpandora2.Service;

import kz.narxoz.springpandora2.Entity.Bracelets;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("BraceletsService")
public interface BraceletsService {

    List<Bracelets> findAllBracelets();

    Bracelets saveBracelets(Bracelets bracelets);

    Bracelets findBracelet(Long id);

    void deleteBracelets(Long id);


}
