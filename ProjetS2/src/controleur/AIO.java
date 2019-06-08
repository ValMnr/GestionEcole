/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import controleur.DAO.*;
import java.sql.SQLException;
import vue.*;
import modele.*;

/**
 *
 * @author Valentin
 */
public class AIO {
    
    public AIO() throws SQLException{
       System.out.println("Lancement vue AIO");
       AllInOne view = new AllInOne();
       view.setVisible(true);
    }
    
}
