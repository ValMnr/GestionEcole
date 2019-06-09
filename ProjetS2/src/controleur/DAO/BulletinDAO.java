/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.DAO;;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Bulletin;
import modele.Connexion;

/**
 *
 * @author Valentin
 */
public class BulletinDAO extends DAO<Bulletin>{
 
    public BulletinDAO(Connexion conn){
        super(conn);
        
    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM bulletin");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

  public boolean create(Bulletin obj) {
       Connexion connex = this.getConnex();
       String values = "'"+obj.getId()+"','"+obj.getTrimestreId()+"','"+obj.getInscriptionId()+"','"+obj.getAppreciation()+"'";
        try {         
            connex.executeUpdate("INSERT INTO bulletin VALUES("+values+")");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
      
  }

  public boolean delete(Bulletin obj) {
      
    int id_del=obj.getId();
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM bulletin where id="+id_del);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
   
  public boolean update(Bulletin obj) {
      Connexion connex = this.getConnex();
      int id=obj.getId();
       String values = "id="+obj.getId()+",trimestreId="+obj.getTrimestreId()+",inscriptionId="+obj.getInscriptionId()+",appreciation='"+obj.getAppreciation()+"'";
       String req="UPDATE bulletin SET "+values+" WHERE id="+id;
       
       
       System.out.println(req); 

       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
        
  }
   
  public Bulletin find(int id) {
      
    Bulletin bull= new Bulletin();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
         Connexion connex = this.getConnex();
         result = connex.remplirChampsRequete("SELECT * From bulletin where id="+id);         
         String[] parts = result.get(0).split(",");
         bull= new Bulletin(Integer.parseInt( parts[0]),Integer.parseInt( parts[1]),Integer.parseInt( parts[2]),parts[3]);
         
     }catch (Exception e) {
      .//e.printStackTrace();
    }
     
    return bull;
  }
     
}
