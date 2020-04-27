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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michael
 */
@Service
public class BrewerieService {
   @Autowired
    BrewerieService brewerieService;

       public static List<Breweries> getAllBreweries() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        System.out.println("BreweriesDB Breweries");
        String query = "SELECT b FROM Breweries b";

        TypedQuery<Breweries> typedQuery = em.createQuery(query, Breweries.class);

        List<Breweries> list = null;

        try {
            list = typedQuery.getResultList();
            for (Breweries brewery : list) {
                System.out.println(brewery);

            }

            if (list == null || list.isEmpty()) {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        System.out.println("end");
        return list;
    }
    

    public void addABrewery(Breweries a) { //Insert new agent into DB
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
    @RequestMapping(value="/view")
    public ModelAndView getAllBreweriesModel() {
        List<Breweries> list = BrewerieService.getAllBreweries();
        return new ModelAndView("/Displaybreweries", "breweriesList", list);
    }

      public static List<Breweries> getAllBreweriesPagination(int start,int size) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        System.out.println("BreweriesDB Breweries");
        String query = "SELECT b FROM Breweries b";
        TypedQuery<Breweries> typedQuery = em.createQuery(query, Breweries.class);
        List<Breweries> list = null;

        try {
            list = typedQuery.getResultList();
            for (Breweries brewery : list) {
                System.out.println(brewery); 
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
    
    public Breweries getBreweriesById(int ID) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Breweries> tq = em.createNamedQuery("Breweries.findById", Breweries.class).setParameter("id", ID);

        Breweries a = null;
        try {
            a = tq.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return a;

    }

    public void editBrewery(Breweries a) {
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

public static int deleteBreweries(int id) {
        System.out.println("PropertyDB DeleteProperty " + id);
        EntityManager em = DBUtil.getEmf().createEntityManager();        
        String query = "DELETE FROM Breweries b WHERE b.id = :id";
                
        TypedQuery<Breweries> tq = em.createQuery(query, Breweries.class);
        int result = 0;
        
        try {
            
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            result = tq.setParameter("id", id).executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        
        return result;
    }

    void deleteBrewery(Breweries brewery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    BreweriesGeocode getBeweriesGeocodeByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addBreweryGeocode(BreweriesGeocode breweryGeo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getBreweriesById(Breweries b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
      
     
    
    
    
}
