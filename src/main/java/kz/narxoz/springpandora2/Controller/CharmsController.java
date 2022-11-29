package kz.narxoz.springpandora2.Controller;

import kz.narxoz.springpandora2.Entity.Charms;
import kz.narxoz.springpandora2.Service.CharmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CharmsController {
    @Autowired

    private CharmsService charmsService;

    @GetMapping("/charms")
    public String charms(Model model){
        model.addAttribute("charms", charmsService.findAllCharms());
        return "charms";
    }


    @GetMapping("/charms/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addCharmForm(Model model){
        Charms charm = new Charms();
        model.addAttribute("charms", charm);
        return "add_charm";
    }

    @GetMapping("/charms/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCharmForm(Model model, @PathVariable("id") Long id){
        Charms charms = charmsService.findCharm(id);
        model.addAttribute("charm", charms);
        return "update_charm";
    }
    @GetMapping("/charms/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCharm(@PathVariable("id") Long id) {
        charmsService.deleteCharms(id);
        return "redirect:/charms";
    }

    @PostMapping("/charms/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCharm(@PathVariable("id") Long id, @ModelAttribute("charms") Charms charms){
        Charms mycharm = charmsService.findCharm(id);
        mycharm = charms;
        charmsService.saveCharms(mycharm);
        return "redirect:/charms";
    }

    @PostMapping("/charms")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveCharm(@ModelAttribute("charms") Charms charms){
        charmsService.saveCharms(charms);
        return "redirect:/charms";
    }



}

