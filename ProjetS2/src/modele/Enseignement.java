package modele;


public class Enseignement{
    
    private int id=0;
    private int classeid=0;
    private int disciplineid=0;
    private int personneid=0;
    
    public Enseignement(){};
    
    public Enseignement(int id, int cid, int did,int pid){
        this.id=id;
        this.classeid=cid;
        this.disciplineid=did;
        this.personneid=id;
    }

  
    
    public int getId(){
		return this.id;
    }   
    public void setId(int id){
            this.id=id;
    }
    public int getClasseId(){
        return this.classeid;
    }
    public void setClasseId(int id){
        this.classeid=id;
    }
    public int getDisciplineId(){
        return this.disciplineid;
    }
    public void setDisciplineId(int id){
        this.disciplineid=id;
    }
    public int getPersonneId(){
        return this.personneid;
    }
    public void setPersonneId(int id){
        this.personneid=id;
    }
    



}
