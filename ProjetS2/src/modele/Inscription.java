package modele;

public class Inscription{
    
    private int id=0;
    private int classeid=0;
    private int personneid=0;
    
    public Inscription(){};
    public Inscription(int id, int cid, int pid){
        this.id=id;
        this.classeid=cid;
        this.personneid=pid;
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
    public void setClasseId(int cid){
        this.classeid=cid;
    }
    public int getPersonneId(){
        return this.personneid;
    }
    public void setPersonneId(int pid){
        this.personneid=pid;
    }
    


	
}