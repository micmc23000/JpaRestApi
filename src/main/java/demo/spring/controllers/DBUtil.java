/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author michael
 */
  public class DBUtil {
     
    private static final EntityManagerFactory EMF = 
            Persistence.createEntityManagerFactory("taste");
     
    public static EntityManagerFactory getEmf() { 
        return EMF;
    }

    
}
  