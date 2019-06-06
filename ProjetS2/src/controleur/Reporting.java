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
        System.out.println("VALEUR DE TIER : " + i);
        data.add((i* 1.0/sommeAnnee)*100);
      });
    data.forEach((i) -> {
        System.out.println("VALEUR DE DATA : " + i);
      });

      

  }
}
