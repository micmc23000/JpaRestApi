/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michael
 */
@RestController
@RequestMapping("/breweries")
public class main {

    @Autowired
    BrewerieService service;

    @RequestMapping(value="/view")
    public ModelAndView getAllBreweriesModel() {
        List<Breweries> list = BrewerieService.getAllBreweries();
        return new ModelAndView("/allBreweries", "breweriesList", list);
    }
    
    
    
    @GetMapping("/add")
    public ModelAndView displayBreweryAddForm() {
        return new ModelAndView("/addBrewery", "brewery", new Breweries());
    }

    @PostMapping("/addBrewery")
    public ModelAndView addABrewery(@Valid @ModelAttribute("Brewery") Breweries brewery, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("/addBrewery");
        }
        service.addABrewery(brewery);
        return new ModelAndView("redirect:/home/View");
    }
//   
    
    
    @RequestMapping("/edit")
    public ModelAndView editbreweryForm(@QueryParam("id") int id) {
        return new ModelAndView("/editBrewery", "brewery", service.getBreweriesById(id));
    }
    
    @PostMapping("/editBrewery")
    public ModelAndView editBrewery(@Valid @ModelAttribute("brewery") Breweries breweryedit, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("/editBrewery");
        }
      service.editBrewery(breweryedit);
        return new ModelAndView("redirect:/home/View");
    }

    
//    @GetMapping("/delete")
 //   public ModelAndView deleteABreweries(@QueryParam("id") int id) {
  //    service.deleteABreweries(id);
   //     return new ModelAndView("redirect:/home/View");
 // }
 

  
}
