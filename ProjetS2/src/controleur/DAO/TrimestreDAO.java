package controleur.DAO;
import controleur.DAO.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.*;
// package com.sdz.dao.implement;



/**
 *
 * @author Valentin
 */
public class TrimestreDAO extends DAO<Trimestre> {
    public TrimestreDAO(Connexion conn){
        super(conn);
        
    }
    @Override
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM Trimestre");
        int size=Integer.parseInt(liste.get(0));       
        return size;
         
    }

    @Override
  public boolean create(Trimestre obj) {
    return false;
  }

    @Override
  public boolean delete(Trimestre obj) {
    return false;
  }
   
    @Override
  public boolean update(Trimestre obj) {
    return false;
  }
   
    @Override
  public Trimestre find(int id) {
      
     Trimestre trim= new Trimestre();
    ArrayList<String> result = new ArrayList<String>();

     
     try{
         
         Connexion connex = this.getConnex();
         result = connex.remplirChampsRequete("SELECT * From trimestre where id="+id);         
         String[] parts = result.get(0).split(",");
         trim= new Trimestre(Integer.parseInt( parts[0]),Integer.parseInt( parts[1]),parts[2],parts[3],Integer.parseInt( parts[4]));


//trim = new Trimestre(id,result.getInt("numero"));
         
         
     }catch (Exception e) {
      e.printStackTrace();
    }
     
     
     
      
    return trim;
  }

}

