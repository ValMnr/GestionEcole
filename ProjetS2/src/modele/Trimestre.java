/**
	*Classe du Trimestre
	*/
package modele;

public class Trimestre{


	private int id =0;
	private int numero =0;
	private String debut="";
	private String fin="";
	private int anneeId=0;


	/**
		* Constructeur avec tout les paramètres
		*/
        public Trimestre(){};
	public Trimestre(int id, int numero, String debut, String fin, int anneeId){

		this.id=id;
		this.numero=numero;
		this.debut=debut;
		this.fin=fin;
		this.anneeId=anneeId;
	}

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return this.id;
	}
	public void setNumero(int numero){
		this.numero=numero;
	}
	public int getNumero(){
		return this.numero;
	}
	public void setDebut(String debut){
		this.debut=debut;
	}
	public String getDebut(){
		return this.debut;
	}
	public void setFin(String fin){
		this.fin=fin;
	}
	public String getFin(){
		return this.fin;
	}
	public void setAnneeId(int anneeId){
		this.anneeId=anneeId;
	}
	public int getAnneId(){
		return anneeId;
	}



}