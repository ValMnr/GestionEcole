package modele;

public class Personne{

    private int id=0;
    private String prenom="";
    private String nom="";
    private int type=0;
    
    public Personne(){}
    
    public Personne(int id, String pr,String nom, int type){
        this.id=id;
        this.nom=nom;
        this.prenom=pr;
        this.type=type;
    }
    public void setId(int id){
            this.id=id;
    }
    public int getId(){
            return this.id;
    }
    public void setNom(String nom){
            this.nom=nom;
    }
    public String getNom(){
            return this.nom;
    }
    public void setPrenom(String nom){
            this.prenom=nom;
    }
    public String getPrenom(){
            return this.prenom;
    }
    public int getType(){
        return this.type;
    }
    public int setType(int typ){
        this.type=typ;
    }
}