package controleur.DAO;;
import controleur.DAO.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;
/**
 *
 * @author Valentin
 */
public class TrimestreDAO extends DAO<Trimestre> {
    public TrimestreDAO(Connexion conn){
        super(conn);

    }
    public int getSize() throws SQLException{
        ArrayList<String> liste = new ArrayList<>();
        liste= connect.remplirChampsRequete("SELECT COUNT(*) FROM trimestre");
        int size=Integer.parseInt(liste.get(0));
        return size;

    }

    @Override
  public boolean create(Trimestre obj) {
       Connexion connex = this.getConnex();
       String values = "'"+obj.getId()+"','"+obj.getNumero()+"','"+obj.getDebut()+"','"+obj.getFin()+"','"+obj.getAnneId()+"'";
        try {
            connex.executeUpdate("INSERT INTO trimestre VALUES("+values+")");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TrimestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;

  }

  public boolean delete(Trimestre obj) {

    int id_del=obj.getId();
    Connexion connex = this.getConnex();
        try {
            connex.executeUpdate("DELETE FROM trimestre where id="+id_del);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TrimestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  }

  public boolean update(Trimestre obj) {

    return false;
  }

  public Trimestre find(int id) {

     Trimestre trim= new Trimestre();
     ArrayList<String> result = new ArrayList<String>();


     try{

         Connexion connex = this.getConnex();
         result = connex.remplirChampsRequete("SELECT * From trimestre where id="+id);
         String[] parts = result.get(0).split(",");
         trim= new Trimestre(Integer.parseInt( parts[0]),Integer.parseInt( parts[1]),parts[2],parts[3],Integer.parseInt( parts[4]));

     }catch (Exception e) {
      e.printStackTrace();
    }

    return trim;
  }
}
