package modele;



public class Evaluation{

    private int id=0;
    private int detailbulletinid=0;
    private int note=0;
    private String appreciation="";
    
    
    public Evaluation(){}
    
    public Evaluation(int id, int bulid, int note, String app){
        this.id=id;
        this.detailbulletinid=bulid;
        this.note=note;
        this.appreciation=app;
    }
    

    public int getId(){
		return this.id;
    }   
    public void setId(int id){
            this.id=id;
    }
    public int getDetailBulletinId(){
        return this.detailbulletinid;
    }
    public void setDetailBulletinId(int id){
        this.detailbulletinid=id;
    }
    public int getNote(){
        return this.note;
    }
    public void setNote(int note){
        this.note=note;
    }
    public String getAppreciation(){
        return this.appreciation;
    }
    public void setAppreciation(String app){
        this.appreciation=app;
    }
    
    
    public List<Evaluation>(Enseignement ens){
        
    }
     
    public List<Evaluation>(Classe cla){
        
    }
  
    
	
}