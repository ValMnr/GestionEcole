/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.ConnexionUI;
import vue.EditInterface;

/**
 *
 * @author Valentin
 */
public class ConnexionInt {
    
    int status=0;
    public ConnexionInt(){
        
       ConnexionUI view = new ConnexionUI();
       view.setVisible(true);
       while (view.getStatus()==0){
           System.out.print("");
       }
       this.setStatus(1);
       
    }
    
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int i){
        this.status=i;
    }
}
