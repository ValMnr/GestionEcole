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
public class Modification {
    
    
   
    public Modification(Bulletin obj){
        System.out.println("Lancement modif bulletin");
        ModifBulletin newview = new ModifBulletin(obj);
        newview.setVisible(true);
    
    }
    
    
}
