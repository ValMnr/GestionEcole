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
public class EnseignementDAO extends DAO<Enseignement> {
      public EnseignementDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM enseignement");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Enseignement obj) {
       Connexion connex = this.getConnex();
    String values = obj.getId()+","+obj.getClasseId()+","+obj.getDisciplineId()+","+obj.getPersonneId();
    String req ="INSERT INTO enseignement VALUES("+values+")";
                System.out.println(req);

    try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public boolean delete(Enseignement obj) {
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM enseignement where id="+obj.getId();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Enseignement obj) {
      
      
      
    Connexion connex = this.getConnex();
    String values = "id="+obj.getId()+",classeId='"+obj.getClasseId()+"',disciplineId="+obj.getDisciplineId()+",personneId="+obj.getPersonneId();
    String req="UPDATE enseignement SET "+values+" WHERE id="+obj.getId();   
    System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
  public Enseignement find(int id) {
      
    Enseignement ann= new Enseignement();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
        Connexion connex = this.getConnex();
         
        result = connex.remplirChampsRequete("SELECT * From enseignement where id="+id);         
        String[] res= result.get(0).split(",");
        ann= new Enseignement( Integer.parseInt(res[0]) , Integer.parseInt(res[1]),Integer.parseInt(res[2]),Integer.parseInt(res[3]));
        
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }
}
