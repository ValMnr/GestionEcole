import java.sql.SQLException;
import java.io.*;
import java.util.ArrayList;
import modele.*;
import DAO.*;
import static java.util.stream.IntStream.range;


 public class TestEcole{

 	public static void main(String[] args) throws SQLException, ClassNotFoundException {
 	
                String namedb="ecole";
                String login="root";
                String password="";
            
                Connexion connex = new Connexion(namedb,login,password);

                
              
                
                           // /** TEST Trimestre
                DAO<Trimestre> trimestreDao = new TrimestreDAO(connex); 
                Trimestre trimtest = new Trimestre(25,25,"01/01/22","01/04/22",2022);
                //trimestreDao.create(trimtest);
                trimtest.setNumero(33);
                trimestreDao.update(trimtest);
                //trimestreDao.delete(trimtest);
                
               // */
                
                
                /** TEST ANNEE SCOLAIRE

                DAO<AnneeScolaire> anneescolaireDao = new AnneeScolaireDAO(connex);
                AnneeScolaire anneetest= new AnneeScolaire(2029);
                anneescolaireDao.create(anneetest);
                anneetest.setId(1);
                anneescolaireDao.update(anneetest);
                anneescolaireDao.delete(anneetest);
                * /
                
                
                
                DAO<Trimestre> trimestreDao = new TrimestreDAO(connex);
                
                /** TEST BULLETIN
                DAO<Bulletin> bulletinDao = new BulletinDAO(connex); 
                Bulletin bulltest = new Bulletin(21,1,1,"Lorem");
                bulletinDao.create(bulltest);
                bulltest.setAppreciation("Test O Test");
                bulletinDao.update(bulltest);
                bulletinDao.delete(bulltest);
                
                */
                
                  
                
                /**
                bulletinDao.delete(bulltest);
                bulletinDao.delete(bulltest2);
                anneescolaireDao.delete(anneetest);
                trimestreDao.delete(trimtest);
                 */
              
 	}
 }
