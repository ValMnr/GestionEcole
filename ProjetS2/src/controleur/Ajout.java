/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import controleur.DAO.*;
import vue.*;
import modele.*;

/**
 *
 * @author Valentin
 */
public class Ajout {
    
    
    private int sizeCat=0;
    
    public Ajout(Personne obj){
        System.out.println("Lancement graphique eleve");
        AjoutEleve  newview = new AjoutEleve(obj);
        newview.setVisible(true);
    
    }
        
    public Ajout(Evaluation obj){
        System.out.println("Lancement graphique evaluation");
        AjoutEvaluation newview = new AjoutEvaluation(obj);
        newview.setVisible(true);
    
    }
    
    public Ajout(Bulletin obj){
        System.out.println("Lancement graphique evaluation");
        AjoutBulletin newview = new AjoutBulletin(obj);
        newview.setVisible(true);
    
    }
    
    
    
    
    
    public void AjoutElv(){
        
            

    }
    
    
    
    
    
}
