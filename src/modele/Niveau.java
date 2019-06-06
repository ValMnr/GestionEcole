package modele;
/**
	*Classe du Niveau
	*/
public class Niveau{

	private int id=0;
	private String nom="";

	public Niveau(int id, String nom){
		this.id=id;
		this.nom=nom;
	}

    public Niveau(){}

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


	
}