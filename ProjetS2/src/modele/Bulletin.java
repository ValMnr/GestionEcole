package modele;

public class Bulletin{

    private int id=0;
    private int trimestreid=0;
    private int inscriptionid=0;
    private String appreciation;

    public Bulletin(){};

    public Bulletin(int id,int trimid,int inscripid,String appreciation){
        this.id=id;
        this.trimestreid=trimid;
        this.inscriptionid=inscripid;
        this.appreciation=appreciation;
    }

 

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }public int getTrimestreId(){
        return this.trimestreid;
    }
    public void setTrimestreId(int id){
        this.trimestreid=id;
    }public int getInscriptionId(){
        return this.inscriptionid;
    }
    public void setInscriptionId(int id){
        this.inscriptionid=id;
    }
    public String getAppreciation(){
        return this.appreciation;
    }
    public void setAppreciation(String app){
        this.appreciation=app;
    }



}
