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
    String values = obj.getNom()+"'";
    String req ="INSERT INTO discipline (nom) VALUES("+values+")";
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
        String[] res= result.get(0).split(",");
        ann= new Discipline(Integer.parseInt(res[0]),res[1]);       
         
     }catch (Exception e) {
     // e.printStackTrace();
    }

    //return ann;
    return ann ;
  }

  /**
   *
   * récuperation de la liste des notes avec en paramètres un enseignement
     * @param idMatiere
     * @return
   */
  public ArrayList<Integer> getNoteDiscipline(int idMatiere){
      ArrayList<Integer> listeNote = new ArrayList<Integer>();
      ArrayList<String> result = new ArrayList<String>();

       try{

          Connexion connex = this.getConnex();
          result = connex.remplirChampsRequete("SELECT note FROM evaluation INNER JOIN detailbulletin ON detailbulletinId = detailbulletin.id INNER JOIN enseignement ON EnseignementId = enseignement.id INNER JOIN discipline ON disciplineId ="+idMatiere);

          for (String s : result) {
            listeNote.add(Integer.parseInt(s));
          }

       }catch (NumberFormatException | SQLException e) {
        System.out.println(e);
      }

    return listeNote;
  }

  /**
   *
   * récuperation de la liste des notes avec en paramètres un enseignement
     * @param idMatiere
     * @return
   */
  public ArrayList<String> getNomDiscipline(int idMatiere){
      ArrayList<String> result = new ArrayList<String>();
       try{

          Connexion connex = this.getConnex();
          result = connex.remplirChampsRequete("SELECT nom FROM discipline WHERE id ="+idMatiere);

       }catch (NumberFormatException | SQLException e) {
        System.out.println(e);
      }

    return result;
  }




}
