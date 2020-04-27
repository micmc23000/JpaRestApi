/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.eclipse.persistence.internal.sessions.DirectCollectionChangeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michael
 */






@RestController
@RequestMapping("/beer")
public class BeerService {
   @Autowired
    BeerService beerService;
 @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Beers> getBeers() {
        return beerService.getBeers();

    } @GetMapping("/{BeersID}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Beers getBeers(@PathVariable("BeersID")int beersID){        
      
       return beerService.getBeers(beersID);
    }
////////////////////////////////     ADD
       
       
@RequestMapping(value="/add")
    public void addABeer(Beers a) { //Insert new agent into DB
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
    
    
    
    @RequestMapping(value="1")
    public ModelAndView getAllBeersModel() {
        List<Beers> list = beerService.getBeers();
        return new ModelAndView("/allBeers", "beersList", list);
    }
 public static List<Beers> getAllBeersPages(int start,int size) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
      
        String query = "SELECT b FROM Beers b";
        TypedQuery<Beers> typedQuery = em.createQuery(query, Beers.class);
        List<Beers> list = null;

        try {
            list = typedQuery.getResultList();
            for (Beers beer : list) {
                System.out.println(beer); 
            }

            if (start + size > list.size()) {
                return list;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        System.out.println("end");
        return null;
    } 

    
 
  
 //   public ModelAndView getPageBeers(int page) {
   
//int itemOnPage =(page*5)-1;
//int nextPage=(page*5);
 //   List<Beers>Allbeers = beerService.getBeers();
 //List<Beers>lessBeer=null;
//for(int i=itemOnPage; itemOnPage<nextPage; itemOnPage++){

  //  lessBeer.add(Allbeers.get(itemOnPage));
    
//}
//        return new ModelAndView("/allBeers", "beersList", lessBeer);
//    }


    public static Beers getBeersById(int ID) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Beers> tq = em.createNamedQuery("Beers.findById", Beers.class).setParameter("id", ID);

        Beers a = null;
        try {
            a = tq.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return a;
    }

    public void editBeer(Beers a) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public void deleteABeers(int id) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            Beers item = getBeersById(id);
            transaction.begin();
            em.remove(em.merge(item));
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
   
    
    public ModelAndView findBeersModel() {
        List<Beers> list = beerService.getBeers();
        return new ModelAndView("/allBeers", "beersList", list);
    }

   
  public static List<Beers> getBeersByName(String name) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
     
       String wildcard='$'+name+'$';
      
      TypedQuery<Beers> tq = em.createNamedQuery("Beers.findByName", Beers.class).setParameter("name", wildcard);

        Beers a = null;
        List<Beers> list=null;
        try {
             list = tq.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return list;
    }
    
   @GetMapping("/price")
    public ModelAndView modifypriceFrorm() {
        return new ModelAndView("/salePrice");
    }   
    // @PostMapping("/increase")
   // public ModelAndView priceup(@QueryParam("price") double price) {
    
     

        
        
  
    //}
    
    
    
    
    
  
  
  
   @GetMapping("/find")
    public ModelAndView findbeerFrorm() {
        return new ModelAndView("/findbeer");
    }
    
    
    @GetMapping("/beers")
     public ModelAndView BeerModel(@QueryParam("id")int id ) {
      Beers a=  new Beers();
      a=  BeerService.getBeersById(id);
      
        return new ModelAndView("/beer", "beersList", a);
    }
     @PostMapping("/findbeerpart")
    public ModelAndView findBeer(@QueryParam("name") String name) {
     name= name;
     List<Beers> list  =beerService.getBeersByName(name);
     if (list.isEmpty()==true){
     return new ModelAndView("/fail");
     }else{
        return new ModelAndView("/allBeers", "beersList", list);
    }}
   @PostMapping("/findbeer")
    public ModelAndView findaBeer(@QueryParam("name") String name) {
     List<Beers> list  =beerService.getBeersByName(name);
     if (list.isEmpty()==true){
     return new ModelAndView("/fail");
     }else
     return new ModelAndView("/allBeers", "beersList", list);
    }

    Beers findById(int beersID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Beers getBeerByID(int beersID) {
EntityManager em =DBUtil.getEmf().createEntityManager();       Beers beer = null;
        try {
           
            beer = em.find(Beers.class, beersID);
            System.out.println("list" + beersID);
            
            if (beer == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            
            em.close();
        }
          System.out.println("list1" + beersID);
        return beer;
                   
    }
 
    
    
        public void updateBeers(int id, Beers b){
       EntityManager em = DBUtil.getEmf().createEntityManager();
       try{
       EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.merge(b);
        em.merge(id);        
        tx.commit();

       }catch (Exception ex) {
           ex.printStackTrace();
            System.out.println(ex);
        } finally {
            em.close();
        }
       
    } 

    }

  


