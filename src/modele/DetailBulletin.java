package modele;


public class DetailBulletin{

    private int id=0;
    private int bulletinid=0;
    private int enseignementid=0;
    private String appreciation="";
    
    public DetailBulletin(){};
    
    public DetailBulletin(int id, int bulid, int ensid, String appr){
        this.id=id;
        this.bulletinid=bulid;
        this.enseignementid=ensid;
        this.appreciation=appr;
    }
    
    public int getId(){
        return this.id;
    }
    public int setId(int id){
        this.id=id;
    }
    
    public int getBulletinId(){
        return this.bulletinid;
    }
    public void setBulletinId(int id){
        this.bulletinid=id;
    }
    
    public int getEnseignementId(){
        return this.enseignementid;
    }
    public void setEnseignementId(int idd){
        this.enseignementid=idd;
    }
    public String getAppreciation(){
        return this.appreciation;
    }
    public void setAppreciation(String app){
        this.appreciation=app;
    }

	
}