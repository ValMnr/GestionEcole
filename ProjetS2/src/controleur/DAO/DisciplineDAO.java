/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.DAO;

import modele.*;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin
 */
public class DisciplineDAO extends DAO<Discipline>{
    
    public DisciplineDAO(Connexion conn){
        super(conn);
    }
    
    public int getSize() throws SQLException{
    ArrayList<String> liste = new ArrayList<>();
    liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM discipline");
    int size=Integer.parseInt(liste.get(0));       
    return size;
    }
    
    public boolean create(Discipline obj) {
    Connexion connex = this.getConnex();
    String values = obj.getId()+",'"+obj.getNom()+"'";
    String req ="INSERT INTO discipline VALUES("+values+")";
                System.out.println(req);

    try {         
            connex.executeUpdate(req);
            System.out.println("okk");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  

    public boolean delete(Discipline obj) {
      
    int id_del=obj.getId();
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM discipline where id="+id_del);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
    
    public boolean update(Discipline obj) {      
      
    Connexion connex = this.getConnex();
    
   
    
    String values = "id="+obj.getId()+",nom='"+obj.getNom()+"'";
    String req="UPDATE discipline SET "+values+" WHERE id="+obj.getId();   
       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
  public Discipline find(int id) {
      
    Discipline ann= new Discipline();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
        Connexion connex = this.getConnex();
         
        result = connex.remplirChampsRequete("SELECT * From discipline where id="+id);         
        System.out.println(result);
        String[] res= result.get(0).split(",");
                System.out.println(res[0]+"'"+res[1]);

        ann= new Discipline(Integer.parseInt(res[0]),res[1]);
        
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }


    
    
}
