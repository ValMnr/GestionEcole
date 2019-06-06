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
public class EvaluationDAO extends DAO<Evaluation> {
      public EvaluationDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM evaluation");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Evaluation obj) {
       Connexion connex = this.getConnex();
    String values = obj.getId()+","+obj.getDetailBulletinId()+","+obj.getNote()+",'"+obj.getAppreciation()+"'";
    String req ="INSERT INTO evaluation VALUES("+values+")";
                System.out.println(req);

    try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public boolean delete(Evaluation obj) {
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM evaluation where id="+obj.getId());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Evaluation obj) {
      
      
      
    Connexion connex = this.getConnex();
 
    String values = "id="+obj.getId()+",detailbulletinId="+obj.getDetailBulletinId() +",note="+obj.getNote()+",appreciation='"+obj.getAppreciation()+"'";
    String req="UPDATE evaluation SET "+values+" WHERE id="+obj.getId();   
    System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
  public Evaluation find(int id) {
      
    Evaluation ann= new Evaluation();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
        Connexion connex = this.getConnex();
         
        result = connex.remplirChampsRequete("SELECT * From evaluation where id="+id);         
        String[] res= result.get(0).split(",");
        ann= new Evaluation( Integer.parseInt(res[0]) , Integer.parseInt(res[1]),Integer.parseInt(res[2]),res[3]);
        
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }
}
