/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import controleur.DAO.*;
import java.awt.BorderLayout;
import java.util.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import modele.AccessCo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import vue.Barchart;
import vue.Dashboard;
import vue.PieChart;

/**
 *
 * @author manuelpellequer
 */
/**
 *
 * class to generate dataset for dashboard visualisations
 */

public class Reporting {
  /**
   *
   * Utilisation des connexions ouvertes sur trimestre et annee
   * Méthode de construction du dataset piechart : proportion d'un caractère sur la population
     * @param co
     * @throws java.sql.SQLException
   */
  public Reporting (AccessCo co) throws SQLException{
    // déclaration
    DefaultPieDataset datasetPieChart = new DefaultPieDataset();
    DefaultCategoryDataset datasetBarChart = new DefaultCategoryDataset();


    // Traitements
    datasetPieChart = PieChartDataset(new DefaultPieDataset());
    datasetBarChart = BarchartDataset(new DefaultCategoryDataset());

    Vuegraphique(datasetPieChart,datasetBarChart);

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

  /**
  * Méthode de calcul de la médiane
  *
     * @param listeNote
     * @return
  */
  public double Mediane(ArrayList<Integer> listeNote){
    Collections.sort(listeNote);
    double median;
      median = 0;
    if (listeNote.size() % 2 == 0){
      // double centre = listeNote.get(listeNote.size()/2);
      median = (listeNote.get(listeNote.size()/2) + listeNote.get(listeNote.size()/2 - 1))/2;

    } else {
      median = listeNote.get(listeNote.size()/2);
    }
    return median;
  }

  /**
  * Méthode de genration dataset
  *
     * @param dataset
     * @return
     * @throws java.sql.SQLException
  */
  public DefaultPieDataset PieChartDataset(DefaultPieDataset dataset) throws SQLException{
    // Partie Piechart

    int sommeAnnee = AccessCo.AnneeScolaireDAO.getSize();
    int sommeTri = AccessCo.TrimestreDAO.getSize();

    List<Integer> tier = new ArrayList<Integer>();
    ArrayList<Double> data = new ArrayList<Double>();

    // Requete pour années + Pie Chart

    for (int i= 2015 ; i<2015+sommeAnnee ; i++) {
      // recherche des années et ajout à la liste
      try {
        tier.add(AccessCo.AnneeScolaireDAO.getResult(i));
        tier.forEach((Integer j) -> {
            data.add((j* 1.0/sommeAnnee)*100);
        });
        int j = 2015;
        for (Double d : data) {
          // ajout au dataset du pie chart
          dataset.setValue(String.valueOf(j), d);
          j++;
        }
      } catch(Exception e) {
        System.out.println("Erreur dataset Piechart : "+e);
      }
    }

    return dataset;
  }
  /**
  * Méthode de création d'un dataset pour toutes les matières
  *
     * @param dataset
     * @return dataset
     * @throws java.sql.SQLException
  */
  public DefaultCategoryDataset BarchartDataset(DefaultCategoryDataset dataset) throws SQLException{
    // TODO : create 6 arraylist and générer la moyenne et la médiane pour chaque matière
    // TODO : evaluer le lien entre la base discipline et enseignement
    // TODO : ajouter les valeurs de moyenne et médiane a des arraylist
    // TODO : creer un dataset par itération des arraylist
    // TODO : creer un barchart et l'ajouter au dashboard
      for (int i=1;i<AccessCo.DisciplineDAO.getSize()+1 ;i++ ) {
        try {
          ArrayList<Integer> listeNote = AccessCo.DisciplineDAO.getNoteDiscipline(i);
          double mean = Moyenne(listeNote);
          double med = Mediane(listeNote);
          ArrayList<String> discipline = AccessCo.DisciplineDAO.getNomDiscipline(i);
          // ajout au dataset
          dataset.addValue(mean, "Moyenne",discipline.get(0));
          dataset.addValue(med, "Mediane", discipline.get(0));
        } catch(Exception e) {
          System.out.println("Erreur dans le dataset de barchart pour la matière index : "+i+" erreur :"+ e);
        }
      }
      return dataset;

  }

  public void Vuegraphique(DefaultPieDataset datasetPieChart,DefaultCategoryDataset datasetBarChart){

    Dashboard dash = new Dashboard();
    // dash.setLayout(new BorderLayout());
    PieChart Pie = new PieChart(dash,datasetPieChart);
    // DEBUG : error in BarchartDataset
    Barchart Bar = new Barchart(dash,datasetBarChart);
    // Barchart b = new Barchart();


    // ajout au centre le bar chart
    // dash.container.add(button, BorderLayout.CENTER);
    // ajout à droite du line chart
    // dash.container.add(button, BorderLayout.LINE_END);
    dash.setVisible(true);
  }
}
