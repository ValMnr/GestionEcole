import java.sql.SQLException;
import java.io.*;
import java.util.ArrayList;
import modele.*;
import DAO.*;
import java.lang.reflect.Field;
import static java.util.stream.IntStream.range;


 public class TestEcole{

 	public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
 	
                String namedb="ecole";
                String login="root";
                String password="";
            
                Connexion connex = new Connexion(namedb,login,password);
                
                
                   
                   /* TEST Niveau       */
                PersonneDAO ensDao= new PersonneDAO(connex);
                Personne test = new Personne(36,"test","Icule",2);
               // ensDao.create(test);
                test.setNom("ttttt");
                ensDao.update(test);
                System.out.println(ensDao.find(test.getId()).getNom());
                ensDao.delete(test);
            
                
                
                   /* TEST Niveau 
                NiveauDAO ensDao= new NiveauDAO(connex);
                Niveau test = new Niveau(6,"test");
                ensDao.create(test);
                test.setNom("ttttt");
                ensDao.update(test);
                System.out.println(ensDao.find(test.getId()).getNom());
                ensDao.delete(test);
                 */
                
                   /* TEST INSCRIPTION 
                InscriptionDAO ensDao= new InscriptionDAO(connex);
                Inscription test = new Inscription(22,4,4);
                //ensDao.create(test);
                test.setClasseId(3);
                ensDao.update(test);
                System.out.println(ensDao.find(test.getId()).getClasseId());
                ensDao.delete(test);
                */
                
                    /* TEST EVALUATION
                
                EvaluationDAO ensDao= new EvaluationDAO(connex);
                Evaluation test = new Evaluation(200,4,4,"Test");
               // ensDao.create(test);
                test.setAppreciation("bbobobo");
                ensDao.update(test);
                System.out.println(ensDao.find(test.getId()).getAppreciation());
                ensDao.delete(test);
                
                */
                
                
                
                
                
                /* TEST ENSEIGNEMENT
                
                DAO<Enseignement> ensDao= new EnseignementDAO(connex);
                Enseignement test = new Enseignement(77,4,4,4);
                ensDao.create(test);
                test.setPersonneId(12);
                ensDao.update(test);
                System.out.println(ensDao.find(test.getId()).getPersonneId());
                ensDao.delete(test);
                */
                
                
                
                
                /* Test Discipline 
                
                DAO<Discipline> disDao= new DisciplineDAO(connex);
                Discipline distest =new Discipline(10,"Test");
                System.out.println(disDao.getSize());
                disDao.create(distest);
                distest.setNom("reee");
                disDao.update(distest);
                System.out.println(disDao.find(10).getNom());
                disDao.delete(distest);

                */
                
                
                /*  TEST DetailBulletin 
                DAO<DetailBulletin> classeDao = new DetailBulletinDAO(connex); 
                DetailBulletin trimtest = new DetailBulletin(20,1,1,"TEST?TESTTEST");
                System.out.println(classeDao.getSize());
                classeDao.create(trixtest);
                trimtest.setAppreciation("OKKOK");
                classeDao.update(trimtest);
                System.out.println(trimtest.getAppreciation());
                classeDao.delete(trimtest);
                   */         
                         
                      
                
                
                
                /** TEST Classe 
                DAO<Classe> classeDao = new ClasseDAO(connex); 
                Classe trimtest = new Classe(19,"Allo",1,1,1);
                Classe trim2 = classeDao.find(12);
                System.out.println(trim2.getNom());
                //classeDao.create(trimtest);
                trimtest.setNom("LOLLLLL");
                //classeDao.update(trimtest);
                //classeDao.delete(trimtest);
                    */        
                         
                
                /** TEST Trimestre 
                DAO<Trimestre> trimestreDao = new TrimestreDAO(connex); 
                Trimestre trimtest = new Trimestre(25,25,"01/01/22","01/04/22",2022);
                trimestreDao.create(trimtest);
                Trimestre trimtest2 = trimestreDao.find(3);
                System.out.println(trimtest2.getDebut());
                trimtest.setNumero(33);
                trimestreDao.update(trimtest);
                trimestreDao.delete(trimtest);
                    */            
                /*
                 TEST ANNEE SCOLAIRE
                DAO<AnneeScolaire> anneescolaireDao = new AnneeScolaireDAO(connex);
                AnneeScolaire anneetest= new AnneeScolaire(2029);
                anneescolaireDao.create(anneetest);
                anneetest.setId(1);
                anneescolaireDao.update(anneetest);
                anneescolaireDao.delete(anneetest);
                
                 */             
                /* TEST BULLETIN
                DAO<Bulletin> bulletinDao = new BulletinDAO(connex); 
                Bulletin bulltest = new Bulletin(21,1,1,"Lorem");
                //bulletinDao.create(bulltest);
                Bulletin bul = bulletinDao.find(1);
                System.out.println(bul.getId()+","+bul.getAppreciation());
                bulltest.setAppreciation("Test O Test");
                bulletinDao.update(bulltest);
                //bulletinDao.delete(bulltest);
                */
                
                  
         
 	}

   
 }
