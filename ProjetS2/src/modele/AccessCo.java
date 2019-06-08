/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import controleur.DAO.*;


/**
 *
 * @author Valentin
 */
public class AccessCo {

    public static Connexion con;
    public static AnneeScolaireDAO AnneeScolaireDAO;
    public static BulletinDAO BulletinDAO;
    public static ClasseDAO ClasseDAO;
    public static DetailBulletinDAO DetailBulletinDAO; 
    public static DisciplineDAO DisciplineDAO;
    public static EnseignementDAO EnseignementDAO;
    public static EvaluationDAO EvaluationDAO; 
    public static InscriptionDAO InscriptionDAO;
    public static NiveauDAO NiveauDAO; 
    public static PersonneDAO PersonneDAO;
    public static TrimestreDAO TrimestreDAO;

    public AccessCo(Connexion con){
    this.con=con;
    this.AnneeScolaireDAO=new AnneeScolaireDAO(con);
    this.ClasseDAO=new ClasseDAO(con);
    this.BulletinDAO=new BulletinDAO(con);
    this.DetailBulletinDAO=new DetailBulletinDAO(con);
    this.DisciplineDAO=new DisciplineDAO(con);
    this.EnseignementDAO=new EnseignementDAO(con);
    this.EvaluationDAO=new EvaluationDAO(con);
    this.InscriptionDAO=new InscriptionDAO(con);
    this.NiveauDAO=new NiveauDAO(con);
    this.PersonneDAO=new PersonneDAO(con);
    this.TrimestreDAO=new TrimestreDAO(con);
    

    
    }

    public Connexion getCon(){
      return this.con;
    }


}
