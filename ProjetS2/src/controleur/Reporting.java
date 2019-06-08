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
import modele.AccessCo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
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
    // dao
    TrimestreDAO TriD = new TrimestreDAO(co.getCon());
    AnneeScolaireDAO AnnD = new AnneeScolaireDAO(co.getCon());
    EnseignementDAO EnsD = new EnseignementDAO(co.getCon());

    DefaultPieDataset datasetPieChart = new DefaultPieDataset();

    int sommeAnnee = AnnD.getSize();
    int sommeTri = TriD.getSize();

    List<Integer> tier = new ArrayList<Integer>();
    ArrayList<Double> data = new ArrayList<Double>();

    // Requete pour années + Pie Chart

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

    // Génération de moyenne + médiane

    ArrayList<Integer> listeNote = EnsD.getNoteEnseignement(18);


    // récupération des notes fonctionnelle
    for (Integer i : listeNote) {
      System.out.println("Note : "+i);
    }

    double mean = Moyenne(listeNote);
    double med = Mediane(listeNote);
    System.out.println("Moyenne matière 18 : "+ mean);
    System.out.println("Mediane matière 18 : "+ med);

    Vuegraphique(datasetPieChart);

    // TODO : create 6 arraylist and générer la moyenne et la médiane pour chaque matière
    // TODO : evaluer le lien entre la base discipline et enseignement
    // TODO : ajouter les valeurs de moyenne et médiane a des arraylist
    // TODO : creer un dataset par itération des arraylist
    // TODO : creer un barchart et l'ajouter au dashboard

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

  public double Mediane(ArrayList<Integer> listeNote){
    Collections.sort(listeNote);
    double median =0.0;
    if (listeNote.size() % 2 == 0){
      // double centre = listeNote.get(listeNote.size()/2);
      median = (listeNote.get(listeNote.size()/2) + listeNote.get(listeNote.size()/2 - 1))/2;

    } else {
      median = listeNote.get(listeNote.size()/2);
    }
    return median;
  }

  public void Vuegraphique(DefaultPieDataset datasetPieChart){

    Dashboard dash = new Dashboard();
    dash.setLayout(new BorderLayout());
    PieChart Pie = new PieChart(dash,datasetPieChart);

    // ajout au centre le bar chart
    // dash.container.add(button, BorderLayout.CENTER);
    // ajout à droite du line chart
    // dash.container.add(button, BorderLayout.LINE_END);



    dash.setVisible(true);
  }
}
