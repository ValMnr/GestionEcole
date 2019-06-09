package controleur;

import controleur.DAO.*;
import java.sql.SQLException;
import java.util.Scanner;
import modele.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import vue.*;


 public class TestEcole{

 	public static void main(String[] args) throws SQLException, ClassNotFoundException {

                String namedb="ecole";
                String login="root";
                String password="tiger";

<<<<<<< HEAD
                Connexion connex1 = new Connexion(namedb,login,password);
                AccessCo co = new AccessCo(connex1);            
                
                
=======
                //Connexion connex1 = new Connexion(namedb,login,password);
                //AccessCo co = new AccessCo(connex1);


>>>>>>> be603168d398b9fa1b60bba3cbae8feef8b55d71
//                DAO<Evaluation> bulDAO = new EvaluationDAO(connex1);
                //Bulletin tst = bulDAO.find(4);
                //Bulletin tst = new Bulletin();
                //Evaluation tst = bulDAO.find(2);
                //Ajout mod = new Ajout(tst);


                //Modification mod = new Modification(tst);
<<<<<<< HEAD
               /* 
=======

>>>>>>> be603168d398b9fa1b60bba3cbae8feef8b55d71
                ConnexionInt con = new ConnexionInt();
                while(con.getStatus()==0){
                    System.out.print("");
                }
<<<<<<< HEAD
                ConnexionUI inter = new ConnexionUI();
                */
                AIO viewaio = new AIO();
                //Reporting R = new Reporting(co);
                
                
               
=======
               // ConnexionUI inter = new ConnexionUI();

                AIO viewaio = new AIO();
>>>>>>> be603168d398b9fa1b60bba3cbae8feef8b55d71





                 // AIO viewaio = new AIO();

/*
                // DAO<Trimestre> trimestreDao = new TrimestreDAO(connex1);
                TrimestreDAO trimestreDao = new TrimestreDAO(connex1);
                AnneeScolaireDAO anneescolaireDAO = new AnneeScolaireDAO(connex1);
                EnseignementDAO enseignementDAO = new EnseignementDAO(connex1);
                //ArrayList<String> liste = connex1.remplirChampsRequete("SELECT * From trimestre");
                //System.out.println(liste);
                Menu menu = new Menu();

                menu.afficher();

                String choice = null;
                Scanner scan = new Scanner(System.in);
                do {
                  choice = scan.nextLine();
                  switch (choice) {
                    case "1":
                    System.out.println("Trimestre DAO");
                    //System.out.println(trimestreDao.getSize());
                    for(int i=1;i<trimestreDao.getSize();i++){
                      Trimestre trimi = trimestreDao.find(i);
                      System.out.println(trimi.getDebut());
                    }
                    menu.afficher();
                    break;
                    case "2":
                    System.out.println("AnneeScolaire DAO");
                    for(int i=2015;i<anneescolaireDAO.getSize();i++){
                      AnneeScolaire ann = anneescolaireDAO.find(i);
                      System.out.println(ann.getId());
                    }
                    menu.afficher();
                    break;
                    case "3" :
                    System.out.println("Reporting");
                    // creates the Reporting
                    Reporting R = new Reporting(co);
                    menu.afficher();
                    break;

                    default :

                  } // end of switch
                } while (!choice.equals("q")); // end of loop
                // if end of the while loop
                System.exit(0); */
 	 } // end of the main
 } // end of the class
