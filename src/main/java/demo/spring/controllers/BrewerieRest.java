/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/breweries")
public class BrewerieRest{

    @Autowired
    BrewerieService brewerieService;

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateBrewery(@PathVariable("id") int id, @RequestBody Breweries b, BreweriesGeocode g) {
     //   brewerieService.(id, b, g); not implemented
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError() {
        return new ModelAndView("/error", "message", "Awful");
    }

    @PostMapping("/brewery/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBrewery(@RequestBody Breweries brewery) {
        brewerieService.addABrewery(brewery);
    }

    @PostMapping("/geocodes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBreweryGeocode(@RequestBody BreweriesGeocode breweryGeo) {
        brewerieService.addBreweryGeocode(breweryGeo);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        Breweries brewery = brewerieService.getBreweriesById(id);
        BreweriesGeocode bg = brewerieService.getBeweriesGeocodeByID(id);
        brewerieService.deleteBrewery(brewery);
        //brewerieGeocodeService.deleteBreweryGeocode(bg);
    }

    @GetMapping("/{id}")
    public Breweries getBreweryByID(@PathVariable("id") int id) {
        return brewerieService.getBreweriesById(id);
    }

    @GetMapping(value = "/hateoas", produces = MediaTypes.HAL_JSON_VALUE)
    public Resources<Breweries> getBreweryHATEOAS() {

        List<Breweries> allBreweries = brewerieService.getAllBreweries();

        for (Breweries b : allBreweries) {
            int breweryId =brewerieService.getBreweriesById(b) ;//getBreweryByID();
            Link selfLink = linkTo(this.getClass()).slash(breweryId).withSelfRel();
            linkTo(methodOn(this.getClass()).getBreweryByID(breweryId));
            b.add(selfLink);
        }

        Link link = linkTo(this.getClass()).withSelfRel();
        Resources<Breweries> result = new Resources<Breweries>(allBreweries, link);

        return result;
    }

    @GetMapping(value = "/hateoas/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public Resource<Breweries> retrieveBrewery(@PathVariable("id") int id) {

        Resource<Breweries> resource = new Resource<Breweries>(brewerieService.getBreweriesById(id));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getBreweries());
        resource.add(linkTo.withRel("all-breweries"));
        return resource;
    }

    @GetMapping(value = "/hateoas/mapsJson/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public Link getJsonFromID(@PathVariable("id") int id) {

        Breweries brewery = brewerieService.getBreweriesById(id);

        if (brewery != null) {

            String title = brewery.getName();
            String _lat = Float.toString(brewery.getLatitude());
            String _long = Float.toString(brewery.getLongitude());

           // newLink.withTitle(title);

           // return newLink;
            ///attempt to call map
            return null;

        } else {
            return null;
        }
    }
    
    
    

    @GetMapping(value = "/hateoas/maps/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ModelAndView getMapFromID(@PathVariable("id") int id) throws MalformedURLException, IOException {

        Breweries brewery = brewerieService.getBreweriesById(id);

        if (brewery != null) {

            String title = brewery.getName();
            String _lat = Float.toString(brewery.getLatitude());
            String _long = Float.toString(brewery.getLongitude());

            Map<String, String> vars = new HashMap<String, String>();
            vars.put("title", title);
           // vars.put("link", newLink.toString());
            //newLink.openStream();

            if (_lat != null && _long != null || _lat != "" && _long != "") {
                
                vars.put("_lat", _lat);
                vars.put("_long", _long);
                
                return new ModelAndView("/maps", "geocodesURL", vars);
            } else {
                return new ModelAndView("/error", "message", "Error!!");
            }

        } else {
            return new ModelAndView("/error", "message", "Error!!");
        }
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Breweries> getBreweries() {
        return brewerieService.getAllBreweries();
    }

    private void brewerieService(int id, Breweries b, BreweriesGeocode g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



