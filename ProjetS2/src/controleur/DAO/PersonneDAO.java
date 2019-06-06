/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.DAO;


import java.sql.SQLException;
import java.util.*;
import modele.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin
 */
public class PersonneDAO extends DAO<Personne> {
    public PersonneDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM personne");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Personne obj) {
       Connexion connex = this.getConnex();
    String values = obj.getId()+",'"+obj.getNom()+"','"+obj.getPrenom()+"',"+obj.getType();
    String req ="INSERT INTO personne VALUES("+values+")";
                System.out.println(req);

    try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public boolean delete(Personne obj) {
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM personne where id="+obj.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Personne obj) {
      
      
      
    Connexion connex = this.getConnex();
 
    String values = "id="+obj.getId()+",nom='"+obj.getNom()+"',prenom='"+obj.getPrenom()+"',type="+obj.getType();
    String req="UPDATE personne SET "+values+" WHERE id="+obj.getId();   
    System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
  public Personne find(int id) {
      
     Personne ann= new Personne();
     
     try{
         
        Connexion connex = this.getConnex();
         
        ArrayList<String> result = connex.remplirChampsRequete("SELECT * From personne where id="+id);         
        String[] res= result.get(0).split(",");
        ann= new Personne( Integer.parseInt(res[0]) , res[1], res[2],Integer.parseInt(res[0]));
        
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }
}
