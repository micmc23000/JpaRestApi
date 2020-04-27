/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michael
 */
@RestController
@RequestMapping("/beer")
public class BeerRest {

    @Autowired
    BeerService beerService;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Beers b) {
        beerService.editBeer(b);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError() {
        return new ModelAndView("error");
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        Beers beers = beerService.getBeerByID(id);
        beerService.deleteABeers(id);

    }

    @GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Beers getBeerByID(@PathVariable("id") int id) {
        return beerService.getBeerByID(id);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/hateoas", produces = MediaTypes.HAL_JSON_VALUE)
    public Resources<Beers> getBeersHATEOAS() {

        List<Beers> allBeers = beerService.getBeers();

        for (Beers b : allBeers) {
            int beerId = b.getBeerId();
            Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(beerId).withSelfRel();

            ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getBeerByID(beerId));

            b.add(selfLink);
        }

        Link link = ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();
        Resources<Beers> result = new Resources<Beers>(allBeers, link);

        return result;
    }

    //  Resource<Beers> 1resource = new Resource<Beers>(beerService.getBeerByID(id));
    //    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getBeers());
    //     resource.add(linkTo.withRel("all-beers"));
    //return resource;
    @GetMapping
    public List<Beers> getBeers() {
        return beerService.getBeers();
    }

    private static class resource {

        public resource() {
        }
    }
}
