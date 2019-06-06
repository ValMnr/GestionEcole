package modele;

public class Classe{
    
    private int id;
    private String nom;
    private int ecoleId;
    private int niveauId;
    private int anneescolaireId;
    
    public Classe(){};
    
    public Classe(int id, String nom, int ecoleID, int niveauId, int anneescolaireId){
        this.id=id;
        this.nom=nom;
        this.ecoleId=ecoleID;
        this.niveauId=niveauId;
        this.anneescolaireId=anneescolaireId;
    }
    
     public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public int getEcoleId(){
        return this.ecoleId;
    }
    public void setEcoleId(int id){
        this.ecoleId=id;
    }
    public int getNiveauId(){
        return this.niveauId;
    }
    public void setNiveauId(int id){
        this.niveauId=id;
    }
    public int getAnneeScolaireId(){
        return this.anneescolaireId;
    }
    public void setAnneeScolaireId(int id){
        this.anneescolaireId=id;
    }
    
    



	
}