/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import controleur.DAO.AnneeScolaireDAO;
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
  public Reporting (AnneeScolaireDAO AnnD,TrimestreDAO TriD) throws SQLException{
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


  }
  /**
   *
   * récuperation de la liste des notes avec en paramètres un enseignement
     * @return
   */
  // public ArrayList<Double> getNoteEnseignement(){
  //     ArrayList<Double> listeNote = null;
  //
  //      try{
  //
  //         Connexion connex = this.getConnex();
  //         result = connex.remplirChampsRequete("SELECT * From anneescolaire where id="+id);
  //
  //         String annscol = result.get(0);
  //         ann= new AnneeScolaire(Integer.parseInt(annscol));
  //
  //
  //      }catch (Exception e) {
  //       e.printStackTrace();
  //     }
  //
  //   return listeNote;
  // }


}