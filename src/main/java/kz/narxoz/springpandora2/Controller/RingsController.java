package kz.narxoz.springpandora2.Controller;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class RingsController {
    @Autowired

    private RingsService ringsService;

    @GetMapping("/rings")
    public String rings(Model model){
        model.addAttribute("rings", ringsService.findAllRings());
        return "rings";
    }

    @GetMapping("/adminrings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminrings(Model model){
        model.addAttribute("rings", ringsService.findAllRings());
        return "adminrings";
    }


    @GetMapping("/adminrings/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addRingForm(Model model){
        Rings ring = new Rings();
        model.addAttribute("rings", ring);
        return "add_rings";
    }

    @GetMapping("/adminrings/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRingForm(Model model, @PathVariable("id") Long id){
        Rings rings = ringsService.findRing(id);
        model.addAttribute("ring", rings);
        return "update_ring";
    }
    @GetMapping("/adminrings/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteRing(@PathVariable("id") Long id) {
        ringsService.deleteRings(id);
        return "redirect:/adminrings";
    }

    @PostMapping("/adminrings/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRing(@PathVariable("id") Long id, @ModelAttribute("rings") Rings rings){
        Rings myring = ringsService.findRing(id);
        myring = rings;
        ringsService.saveRings(myring);
        return "redirect:/adminrings";
    }

    @PostMapping("/adminrings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveRing(@ModelAttribute("ring") Rings rings){
        ringsService.saveRings(rings);
        return "redirect:/adminrings";
    }



}

