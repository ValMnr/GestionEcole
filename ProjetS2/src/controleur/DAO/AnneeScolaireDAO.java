package controleur.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;
/**
 *
 * @author Valentin
 */
public class AnneeScolaireDAO extends DAO<AnneeScolaire> {
    public AnneeScolaireDAO(Connexion conn){
        super(conn);

    }
    @Override
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM anneescolaire");
        int size=Integer.parseInt(liste.get(0));
        return size;

    }

    @Override
  public boolean create(AnneeScolaire obj) {
       Connexion connex = this.getConnex();
       String values = "'"+obj.getId()+"'";
        try {
            connex.executeUpdate("INSERT INTO anneescolaire VALUES("+values+")");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

    @Override
  public boolean delete(AnneeScolaire obj) {

    int id_del=obj.getId();
    Connexion connex = this.getConnex();
        try {
            connex.executeUpdate("DELETE FROM anneescolaire where id="+id_del);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AnneeScolaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public boolean update(AnneeScolaire obj) {



    Connexion connex = this.getConnex();
    String values = "id="+obj.getId();
    String req="UPDATE anneescolaire SET "+values+" WHERE id="+obj.getId();
    System.out.println(req);

       try {
            connex.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public AnneeScolaire find(int id) {

    AnneeScolaire ann= new AnneeScolaire();
    ArrayList<String> result = new ArrayList<String>();


     try{

         Connexion connex = this.getConnex();
         result = connex.remplirChampsRequete("SELECT * From anneescolaire where id="+id);

        String annscol = result.get(0);
        ann= new AnneeScolaire(Integer.parseInt(annscol));


     }catch (Exception e) {
      e.printStackTrace();
    }

    //return ann;
    return ann ;
  }
  public int getResult(int id) {

    AnneeScolaire ann= new AnneeScolaire();
    ArrayList<String> result = new ArrayList<String>();


     try{

         Connexion connex = this.getConnex();
         result = connex.remplirChampsRequete("SELECT * From anneescolaire where id="+id);

     }catch (Exception e) {
     }

    //return ann;
    return result.size();
  }

}
