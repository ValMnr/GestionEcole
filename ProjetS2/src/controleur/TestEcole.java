package controleur;

import controleur.DAO.TrimestreDAO;
import controleur.DAO.DAO;
import java.sql.SQLException;
import java.util.Scanner;
import modele.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import vue.Menu;


 public class TestEcole{

 	public static void main(String[] args) throws SQLException, ClassNotFoundException {

                String namedb="ecole";
                String login="root";
                String password="tiger";

 		//Trimestre tri1=new Trimestre(1,1,"1/1/19","31/3/19", 2018);
                Connexion connex1 = new Connexion(namedb,login,password);
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
                    DAO<Trimestre> trimestreDao = new TrimestreDAO(connex1);
                    //System.out.println(trimestreDao.getSize());
                    for(int i=1;i<trimestreDao.getSize();i++){
                      Trimestre trimi = trimestreDao.find(i);
                      System.out.println(trimi.getDebut());
                    }
                    menu.afficher();
                    break;
                    case "2" :
                    System.out.println("Reporting");
                    // create a dataset...
                    DefaultPieDataset dataset = new DefaultPieDataset();
                    dataset.setValue("Category 1", 43.2);
                    dataset.setValue("Category 2", 27.9);
                    dataset.setValue("Category 3", 79.5);
                    // create a chart...
                    JFreeChart chart = ChartFactory.createPieChart(
                    "Sample Pie Chart",
                    dataset,
                    true, // legend?
                    true, // tooltips?
                    false // URLs?
                    );
                    // create and display a frame...
                    ChartFrame frame = new ChartFrame("First", chart);
                    frame.pack();
                    frame.setVisible(true);

                    // TODO : tester la creation d'objets avec les data sets depuis le main
                    menu.afficher();
                    break;
                    default :

                  } // end of switch
                } while (!choice.equals("q")); // end of loop
                // if end of the while loop
                System.exit(0);
 	 } // end of the main
 } // end of the class
