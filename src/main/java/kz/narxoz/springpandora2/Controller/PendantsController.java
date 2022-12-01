package kz.narxoz.springpandora2.Controller;

import kz.narxoz.springpandora2.Entity.Pendants;
import kz.narxoz.springpandora2.Service.PendantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PendantsController {
    @Autowired

    private PendantsService pendantsService;

    @GetMapping("/pendants")
    public String pendants(Model model){
        model.addAttribute("pendants", pendantsService.findAllPendants());
        return "pendants";
    }
    @GetMapping("/adminpendants")
    public String adminpendants(Model model){
        model.addAttribute("pendants", pendantsService.findAllPendants());
        return "adminpendants";
    }


    @GetMapping("/pendants/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addPendantsForm(Model model){
        Pendants pendants = new Pendants();
        model.addAttribute("pendant", pendants);
        return "pendants";
    }

    @GetMapping("/pendants/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updatePendantsForm(Model model, @PathVariable("id") Long id){
        Pendants pendant = pendantsService.findPendant(id);
        model.addAttribute("pendant", pendant);
        return "update_pendant";
    }
    @GetMapping("/pendants/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePendant(@PathVariable("id") Long id) {
        pendantsService.deletePendants(id);
        return "redirect:/pendants";
    }

    @PostMapping("/pendants/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updatePendant(@PathVariable("id") Long id, @ModelAttribute("pendant") Pendants pendants){
        Pendants myPendants = pendantsService.findPendant(id);
        myPendants = pendants;
        pendantsService.savePendants(myPendants);
        return "redirect:/pendants";
    }

    @PostMapping("/pendants")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String savePendants(@ModelAttribute("pendant") Pendants pendants){
        pendantsService.savePendants(pendants);
        return "redirect:/pendants";
    }



}

