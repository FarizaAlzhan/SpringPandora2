package kz.narxoz.springpandora2.Controller;

import kz.narxoz.springpandora2.Entity.Collections;
import kz.narxoz.springpandora2.Entity.Rings;
import kz.narxoz.springpandora2.Service.CollectionsService;
import kz.narxoz.springpandora2.Service.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CollectionsController {
    @Autowired

    private CollectionsService collectionsService;

    @GetMapping("/collections")
    public String collections(Model model){
        model.addAttribute("collections", collectionsService.findAllCollections());
        return "collections";
    }
    @GetMapping("/admincollections")

    public String admincollections(Model model){
        model.addAttribute("collections", collectionsService.findAllCollections());
        return "admincollections";
    }


    @GetMapping("/admincollections/new")

    public String addCollectionForm(Model model){
        Collections collection = new Collections();
        model.addAttribute("collections", collection);
        return "add_collection";
    }

    @GetMapping("/admincollections/update/{id}")

    public String updateCollectionForm(Model model, @PathVariable("id") Long id){
        Collections collections = collectionsService.findCollection(id);
        model.addAttribute("collection", collections);
        return "update_collection";
    }
    @GetMapping("/admincollections/delete/{id}")

    public String deleteCollection(@PathVariable("id") Long id) {
        collectionsService.deleteCollections(id);
        return "redirect:/admincollections";
    }

    @PostMapping("/admincollections/update/{id}")

    public String updateCollection(@PathVariable("id") Long id, @ModelAttribute("collections") Collections collections){
        Collections mycollection = collectionsService.findCollection(id);
        mycollection = collections;
        collectionsService.saveCollections(mycollection);
        return "redirect:/admincollections";
    }

    @PostMapping("/admincollections")

    public String saveCollection(@ModelAttribute("collection") Collections collections){
        collectionsService.saveCollections(collections);
        return "redirect:/admincollections";
    }



}

