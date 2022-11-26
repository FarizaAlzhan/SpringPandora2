package kz.narxoz.springpandora2.Controller;
import kz.narxoz.springpandora2.Entity.Bracelets;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Service.BraceletsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


    @GetMapping("/rings/new")
    public String addBraceletForm(Model model){
        Rings ring = new Rings();
        model.addAttribute("rings", ring);
        return "add_rings";
    }

    @GetMapping("/rings/update/{id}")
    public String updateRingForm(Model model, @PathVariable("id") Long id){
        Rings rings = ringsService.findRing(id);
        model.addAttribute("bracelet", rings);
        return "update_ring";
    }
    @GetMapping("/rings/delete/{id}")
    public String deleteRing(@PathVariable("id") Long id) {
        ringsService.deleteRings(id);
        return "redirect:/rings";
    }

    @PostMapping("/rings/update/{id}")
    public String updateRing(@PathVariable("id") Long id, @ModelAttribute("rings") Rings rings){
        Rings myring = ringsService.findRing(id);
        myring = rings;
        ringsService.saveRings(myring);
        return "redirect:/rings";
    }

    @PostMapping("/rings")
    public String saveRing(@ModelAttribute("ring") Rings rings){
        ringsService.saveRings(rings);
        return "redirect:/rings";
    }



}

