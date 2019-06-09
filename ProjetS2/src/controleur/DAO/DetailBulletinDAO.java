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
public class DetailBulletinDAO extends DAO<DetailBulletin>{
    
    public DetailBulletinDAO(Connexion conn){
        super(conn);
    }
    
    @Override
    public int getSize() throws SQLException{
    ArrayList<String> liste = new ArrayList<>();
    liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM detailbulletin");
    int size=Integer.parseInt(liste.get(0));       
    return size;
    }
    
    @Override
    public boolean create(DetailBulletin obj) {
    Connexion connex = this.getConnex();
    String values = obj.getId()+",'"+obj.getBulletinId()+"',"+obj.getEnseignementId()+",'"+obj.getAppreciation()+"'";
    String req ="INSERT INTO detailbulletin VALUES("+values+")";
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

  

    @Override
    public boolean delete(DetailBulletin obj) {
      
    int id_del=obj.getId();
    Connexion connex = this.getConnex();
        try {         
            connex.executeUpdate("DELETE FROM detailbulletin where id="+id_del);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }
    
    @Override
    public boolean update(DetailBulletin obj) {      
      
    Connexion connex = this.getConnex();
    
   
    
    String values = "id="+obj.getId()+",bulletinId='"+obj.getBulletinId()+"',enseignementId="+obj.getEnseignementId()+",appreciation='"+obj.getAppreciation()+"'";
    String req="UPDATE detailbulletin SET "+values+" WHERE id="+obj.getId();   
       try {         
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;  
  }
   
    @Override
  public DetailBulletin find(int id) {
      
    DetailBulletin ann= new DetailBulletin();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
        Connexion connex = this.getConnex();
         
        result = connex.remplirChampsRequete("SELECT * From detailbulletin where id="+id);         
        String[] res= result.get(0).split(",");
        ann= new DetailBulletin(Integer.parseInt(res[0]),Integer.parseInt(res[1]),Integer.parseInt(res[2]),res[3]);
        
         
     }catch (Exception e) {
      //e.printStackTrace();
    }
     
    //return ann;
    return ann ;
  }


    
    
}
