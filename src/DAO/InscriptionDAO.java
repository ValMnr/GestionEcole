/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Connexion;
import modele.Inscription;

/**
 *
 * @author Valentin
 */
public class InscriptionDAO extends DAO<Inscription>{
 
    public InscriptionDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM inscription");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Inscription obj) {
       Connexion connex = this.getConnex();
       String values = "'"+obj.getId()+"','"+obj.getClasseId()+"','"+obj.getPersonneId()+"'";
        try {         
            connex.executeUpdate("INSERT INTO inscription VALUES("+values+")");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
      
  }

  public boolean delete(Inscription obj) {
      
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM inscription where id="+obj.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Inscription obj) {
      Connexion connex = this.getConnex();
       String values = "id="+obj.getId()+",classeId="+obj.getClasseId()+",personneId="+obj.getPersonneId();
       String req="UPDATE inscription SET "+values+" WHERE id="+obj.getId();
       System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
        
  }
   
  public Inscription find(int id) {
      
    Inscription bull= new Inscription();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
         Connexion connex = this.getConnex();
         result = connex.remplirChampsRequete("SELECT * From inscription where id="+id);         
         String[] parts = result.get(0).split(",");
         bull= new Inscription(Integer.parseInt( parts[0]),Integer.parseInt( parts[1]),Integer.parseInt( parts[2]));
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    return bull;
  }
     
}






