package kz.narxoz.springpandora2.Controller;

import kz.narxoz.springpandora2.Entity.Earrings;
import kz.narxoz.springpandora2.Service.EarringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EarringsController {
    @Autowired

    private EarringsService earringsService;

    @GetMapping("/earrings")
    public String earrings(Model model){
        model.addAttribute("earrings", earringsService.findAllEarrings());
        return "earrings";
    }


    @GetMapping("/earrings/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addEarringForm(Model model){
        Earrings earring = new Earrings();
        model.addAttribute("earring", earring);
        return "add_earrings";
    }

    @GetMapping("/earrings/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateEarringForm(Model model, @PathVariable("id") Long id){
        Earrings earrings = earringsService.findEarring(id);
        model.addAttribute("earring", earrings);
        return "update_earring";
    }
    @GetMapping("/earrings/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteEarring(@PathVariable("id") Long id) {
        earringsService.deleteEarrings(id);
        return "redirect:/earrings";
    }

    @PostMapping("/earrings/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateEarring(@PathVariable("id") Long id, @ModelAttribute("earrings") Earrings earrings){
        Earrings myearring = earringsService.findEarring(id);
        myearring = earrings;
        earringsService.saveEarrings(myearring);
        return "redirect:/earrings";
    }

    @PostMapping("/earrings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveEarring(@ModelAttribute("earring") Earrings earrings){
        earringsService.saveEarrings(earrings);
        return "redirect:/earrings";
    }



}

