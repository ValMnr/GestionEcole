/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.SQLException;
import java.util.*;
import modele.*;
import DAO.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin
 */
public class NiveauDAO extends DAO<Niveau> {
    public NiveauDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM niveau");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Niveau obj) {
       Connexion connex = this.getConnex();
    String values = obj.getId()+",'"+obj.getNom()+"'";
    String req ="INSERT INTO niveau VALUES("+values+")";
                System.out.println(req);

    try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public boolean delete(Niveau obj) {
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM niveau where id="+obj.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Niveau obj) {
      
      
      
    Connexion connex = this.getConnex();
 
    String values = "id="+obj.getId()+",nom='"+obj.getNom()+"'";
    String req="UPDATE niveau SET "+values+" WHERE id="+obj.getId();   
    System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
  public Niveau find(int id) {
      
    Niveau ann= new Niveau();
     
     try{
         
        Connexion connex = this.getConnex();
         
        ArrayList<String> result = connex.remplirChampsRequete("SELECT * From niveau where id="+id);         
        String[] res= result.get(0).split(",");
        ann= new Niveau( Integer.parseInt(res[0]) , res[1]);
        
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }
}
