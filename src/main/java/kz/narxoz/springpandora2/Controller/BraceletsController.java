package kz.narxoz.springpandora2.Controller;
import kz.narxoz.springpandora2.Entity.Bracelets;
import kz.narxoz.springpandora2.Service.BraceletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BraceletsController {
    @Autowired

    private BraceletsService braceletService;

    @GetMapping("/bracelets")
    public String bracelets(Model model){
        model.addAttribute("bracelets", braceletService.findAllBracelets());
        return "bracelets";
    }

    @GetMapping("/adminbracelets")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminbracelets(Model model){
        model.addAttribute("bracelets", braceletService.findAllBracelets());
        return "adminbracelets";
    }


    @GetMapping("/adminbracelets/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addBraceletForm(Model model){
        Bracelets bracelet = new Bracelets();
        model.addAttribute("bracelet", bracelet);
        return "add_bracelet";
    }

    @GetMapping("/adminbracelets/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateBraceletForm(Model model, @PathVariable("id") Long id){
        Bracelets bracelet = braceletService.findBracelet(id);
        model.addAttribute("bracelet", bracelet);
        return "update_bracelet";
    }
    @GetMapping("/adminbracelets/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBracelet(@PathVariable("id") Long id) {
        braceletService.deleteBracelets(id);
        return "redirect:/adminbracelets";
    }

    @PostMapping("/adminbracelets/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateBracelet(@PathVariable("id") Long id, @ModelAttribute("bracelet") Bracelets bracelets){
        Bracelets myBracelet = braceletService.findBracelet(id);
        myBracelet = bracelets;
        braceletService.saveBracelets(myBracelet);
        return "redirect:/adminbracelets";
    }

    @PostMapping("/adminbracelets")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
        public String saveBracelet(@ModelAttribute("bracelet") Bracelets bracelets){
            braceletService.saveBracelets(bracelets);
            return "redirect:/adminbracelets";
        }



}