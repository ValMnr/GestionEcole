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
public class ClasseDAO extends DAO<Classe>{
     public ClasseDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM classe");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Classe obj) {
       Connexion connex = this.getConnex();
    String values = obj.getId()+",'"+obj.getNom()+"',"+obj.getEcoleId()+","+obj.getNiveauId()+","+obj.getAnneeScolaireId();
    String req ="INSERT INTO classe VALUES("+values+")";
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

  public boolean delete(Classe obj) {
      
    int id_del=obj.getId();
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM classe where id="+id_del);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Classe obj) {
      
      
      
    Connexion connex = this.getConnex();
    String values = "id="+obj.getId()+",nom='"+obj.getNom()+"',ecoleId="+obj.getEcoleId()+",niveauId="+obj.getNiveauId()+",anneescolaireId="+obj.getAnneeScolaireId();
    String req="UPDATE classe SET "+values+" WHERE id="+obj.getId();   
    System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
  public Classe find(int id) {
      
    Classe ann= new Classe();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
        Connexion connex = this.getConnex();
         
        result = connex.remplirChampsRequete("SELECT * From classe where id="+id);         
        String[] res= result.get(0).split(",");
        ann= new Classe(Integer.parseInt(res[0]),res[1],Integer.parseInt(res[2]),Integer.parseInt(res[3]),Integer.parseInt(res[4]));
        
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }
}
