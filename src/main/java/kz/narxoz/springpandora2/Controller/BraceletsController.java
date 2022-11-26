package kz.narxoz.springpandora2.Controller;
import kz.narxoz.springpandora2.Entity.Bracelets;
import kz.narxoz.springpandora2.Service.BraceletsService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/bracelets/new")
    public String addBraceletForm(Model model){
        Bracelets bracelet = new Bracelets();
        model.addAttribute("bracelet", bracelet);
        return "add_bracelet";
    }

    @GetMapping("/bracelets/update/{id}")
    public String updateBraceletForm(Model model, @PathVariable("id") Long id){
        Bracelets bracelet = braceletService.findBracelet(id);
        model.addAttribute("bracelet", bracelet);
        return "update_bracelet";
    }
    @GetMapping("/bracelets/delete/{id}")
    public String deleteBracelet(@PathVariable("id") Long id) {
        braceletService.deleteBracelets(id);
        return "redirect:/bracelets";
    }

    @PostMapping("/bracelets/update/{id}")
    public String updateBracelet(@PathVariable("id") Long id, @ModelAttribute("bracelet") Bracelets bracelets){
        Bracelets myBracelet = braceletService.findBracelet(id);
        myBracelet = bracelets;
        braceletService.saveBracelets(myBracelet);
        return "redirect:/bracelets";
    }

    @PostMapping("/bracelets")
    public String saveBracelet(@ModelAttribute("bracelet") Bracelets bracelets){
        braceletService.saveBracelets(bracelets);
        return "redirect:/bracelets";
    }



}

