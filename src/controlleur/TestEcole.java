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
            
 		//Trimestre tri1=new Trimestre(1,1,"1/1/19","31/3/19", 2018);
                Connexion connex = new Connexion(namedb,login,password);
                //ArrayList<String> liste = connex1.remplirChampsRequete("SELECT * From trimestre");
                //System.out.println(liste);
                
                Trimestre trimtest= new Trimestre(15,15,"01/01/01","01/01/01",2019);
                
                DAO<Trimestre> trimestreDao = new TrimestreDAO(connex);
                
                trimestreDao.create(trimtest);
                trimestreDao.delete(trimestreDao.find(14));

                
                //System.out.println(trimestreDao.getSize());
               // for(int i=1;i<trimestreDao.getSize();i++){
                //    Trimestre trimi = trimestreDao.find(i);
                //    System.out.println(trimi.getDebut());
               // }
                
              
 	}
 }
