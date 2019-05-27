package controleur;

import controleur.DAO.TrimestreDAO;
import controleur.DAO.DAO;
import java.sql.SQLException;
import java.io.*;
import java.util.ArrayList;
import modele.*;
import static java.util.stream.IntStream.range;


 public class TestEcole{

 	public static void main(String[] args) throws SQLException, ClassNotFoundException {

                String namedb="Ecole";
                String login="root";
                String password="tiger";

 		//Trimestre tri1=new Trimestre(1,1,"1/1/19","31/3/19", 2018);
                Connexion connex1 = new Connexion(namedb,login,password);
                //ArrayList<String> liste = connex1.remplirChampsRequete("SELECT * From trimestre");
                //System.out.println(liste);


                DAO<Trimestre> trimestreDao = new TrimestreDAO(connex1);
                //System.out.println(trimestreDao.getSize());
                for(int i=1;i<trimestreDao.getSize();i++){
                    Trimestre trimi = trimestreDao.find(i);
                    System.out.println(trimi.getDebut());
                }
 	}
 }
