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


    @GetMapping("/collections/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addCollectionForm(Model model){
        Collections collection = new Collections();
        model.addAttribute("collections", collection);
        return "add_collection";
    }

    @GetMapping("/collections/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCollectionForm(Model model, @PathVariable("id") Long id){
        Collections collections = collectionsService.findCollection(id);
        model.addAttribute("collection", collections);
        return "update_collection";
    }
    @GetMapping("/collections/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCollection(@PathVariable("id") Long id) {
        collectionsService.deleteCollections(id);
        return "redirect:/collections";
    }

    @PostMapping("/collections/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCollection(@PathVariable("id") Long id, @ModelAttribute("collections") Collections collections){
        Collections mycollection = collectionsService.findCollection(id);
        mycollection = collections;
        collectionsService.saveCollections(mycollection);
        return "redirect:/collections";
    }

    @PostMapping("/collections")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveCollection(@ModelAttribute("collection") Collections collections){
        collectionsService.saveCollections(collections);
        return "redirect:/collections";
    }



}

