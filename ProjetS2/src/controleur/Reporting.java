/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import controleur.DAO.AnneeScolaireDAO;
import controleur.DAO.EnseignementDAO;
import controleur.DAO.TrimestreDAO;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author manuelpellequer
 */
/**
 *
 * class to generate dataset for dashboard visualisations
 */

public class Reporting {
  DefaultPieDataset datasetPieChart = new DefaultPieDataset();
  /**
   *
   * Utilisation des connexions ouvertes sur trimestre et annee
   * Méthode de construction du dataset piechart : proportion d'un caractère sur la population
     * @param AnnD
     * @param TriD
     * @throws java.sql.SQLException
   */
  public Reporting (AnneeScolaireDAO AnnD,TrimestreDAO TriD, EnseignementDAO EnsD) throws SQLException{


    int sommeAnnee = AnnD.getSize();
    int sommeTri = TriD.getSize();

    List<Integer> tier = new ArrayList<Integer>();
    ArrayList<Double> data = new ArrayList<Double>();

    for (int i= 2015 ; i<2015+sommeAnnee ; i++) {
      // recherche des années et ajout à la liste
      tier.add(AnnD.getResult(i));
    }

    tier.forEach((Integer i) -> {
        data.add((i* 1.0/sommeAnnee)*100);
      });
    int j = 2015;
    for (Double d : data) {
      // ajout au dataset du pie chart
      System.out.println("KEY : " + String.valueOf(j) + " VALUES : "+d);
      datasetPieChart.setValue(String.valueOf(j), d);
      j++;

    }

    // affichage du pie chart après construction
    // create a chart...
    JFreeChart chart = ChartFactory.createPieChart(
    "Sample Pie Chart",
    datasetPieChart,
    true, // legend?
    true, // tooltips?
    false // URLs?
    );
    // create and display a frame...
    ChartFrame frame = new ChartFrame("First", chart);
    frame.pack();
    frame.setVisible(true);

    ArrayList<Integer> listeNote = EnsD.getNoteEnseignement(18);


    // récupération des notes fonctionnelle
    for (Integer i : listeNote) {
      System.out.println("Note : "+i);
    }

    double mean = Moyenne(listeNote);
    System.out.println("Moyenne matière 18 : "+ mean);

  } // fin du constructeur par défaut
  /**
  * Méthode de calcul de la moyenne
  *
  */
  public double Moyenne(ArrayList<Integer> listeNote){
    int total = 0;
    for (Integer i : listeNote ) {
      total+= i;
    }
    double moyenne = total * 1.0 / listeNote.size();
    return moyenne;
  }

}
