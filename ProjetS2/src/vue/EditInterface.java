/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.AccessCo;
import modele.*;
import modele.Personne;
import java.io.Serializable;


/**
 *
 * @author Valentin
 */
public class EditInterface extends javax.swing.JFrame {

    private int step;
    /**
     * Creates new form Test
     */
    public EditInterface() throws SQLException {
        initComponents();
        int step=0;
    }
    public int getStep(){
        return this.step;
    }
    public void setStep(int a){
        this.step=a;
    }
        
    public void display_error(){
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
    }

    
    public String[] get_liste_personne(int type) throws SQLException{
        List<String> list = new ArrayList<String>();
        String crt;
        Personne p = new Personne();
        ArrayList size_str = AccessCo.con.remplirChampsRequete("select id from personne ORDER BY id DESC LIMIT 1");
        int size = Integer.parseInt((String) size_str.get(0));
        for(int i=1;i<=size;i++){
           // System.out.print("ok");
            try{
               p=AccessCo.PersonneDAO.find(i);
              }catch(IndexOutOfBoundsException e){
                }
            if(p.getType()==type){
            crt = AccessCo.PersonneDAO.find(i).getPrenom()+" "+AccessCo.PersonneDAO.find(i).getNom();
            list.add(crt);
            }
        }
        return list.toArray(new String[0]);
    }
    
    public String[] get_liste_enseignement() throws SQLException{
        List<String> list = new ArrayList<String>();
        String crt, discipline,classe;
        Enseignement p = new Enseignement();
        ArrayList size_str = AccessCo.con.remplirChampsRequete("select id from enseignement ORDER BY id DESC LIMIT 1");
        int size = Integer.parseInt((String) size_str.get(0));
        
        for(int i=1;i<=size;i++){
            try{
               p=AccessCo.EnseignementDAO.find(i);
              }catch(IndexOutOfBoundsException e){
                }
            if (p.getId()!=0 && p.getClasseId()!=0 && p.getDisciplineId()!=0 && p.getPersonneId()!=0 ){
               crt=AccessCo.ClasseDAO.find( p.getClasseId()).getNom()+" - "+AccessCo.DisciplineDAO.find( p.getDisciplineId()).getNom()+" - "+AccessCo.PersonneDAO.find(p.getPersonneId()).getNom()+" "+AccessCo.PersonneDAO.find(p.getPersonneId()).getPrenom();
               list.add(crt);
            
            }
                
    }
                return list.toArray(new String[0]);
    }
    
    public String[] get_liste_classe() throws SQLException{
        List<String> list = new ArrayList<String>();
        String crt, discipline,classe;
        Classe p = new Classe();
        
        for(int i=1;i<=AccessCo.ClasseDAO.getSize();i++){
            try{
               p=AccessCo.ClasseDAO.find(i);
              }catch(IndexOutOfBoundsException e){
                }
            if (p.getId()!=0){
                crt =p.getNom()+"-"+p.getAnneeScolaireId();
               list.add(crt);           
            }
        }
                return list.toArray(new String[0]);
    }
   
    public String[] get_liste_matiere() throws SQLException{
        List<String> list = new ArrayList<String>();
        String crt, discipline,classe;
        Discipline p = new Discipline();
        
        for(int i=1;i<=AccessCo.DisciplineDAO.getSize();i++){
            try{
               p=AccessCo.DisciplineDAO.find(i);
              }catch(IndexOutOfBoundsException e){
                }
            if (p.getId()!=0){
                crt =p.getNom();
               list.add(crt);           
            }
        }
                return list.toArray(new String[0]);
    }
    
       public String[] get_liste_trimestre() throws SQLException{
        List<String> list = new ArrayList<String>();
        String crt, discipline,classe;
        Trimestre p = new Trimestre();
        
        for(int i=1;i<=AccessCo.TrimestreDAO.getSize();i++){
            try{
               p=AccessCo.TrimestreDAO.find(i);
              }catch(IndexOutOfBoundsException e){
                }
            if (p.getId()!=0){
                crt =p.getDebut()+" - "+p.getFin();
               list.add(crt);           
            }
        }
                return list.toArray(new String[0]);
    }
       
       
      public String get_appreciation(){   
        return null;
      }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws SQLException {

        jScrollPane5 = new javax.swing.JScrollPane();
        elv_tab = new javax.swing.JTabbedPane();
        elv_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            elv_list =(javax.swing.JList)java.beans.Beans.instantiate(getClass().getClassLoader(), "vue.Test_jList1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        elv_btn_sup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        elv_btn_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        elv_txt_prenom = new javax.swing.JTextField();
        elv_txt_nom = new javax.swing.JTextField();
        elv_txt_classe = new javax.swing.JTextField();
        prof_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prof_list = new javax.swing.JList<>();
        prof_btn_sup = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prof_btn_add = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        prof_txt_prenom = new javax.swing.JTextField();
        prof_txt_nom = new javax.swing.JTextField();
        ens_panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ens_list = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ens_btn_sup = new javax.swing.JButton();
        ens_com_classe = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ens_com_matiere = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        ens_com_prof = new javax.swing.JComboBox<>();
        ens_btn_add = new javax.swing.JButton();
        bul_panel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bul_btn_mod = new javax.swing.JButton();
        bul_btn_sup = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        bul_txtarea_app = new javax.swing.JTextArea();
        bul_com_trimestre = new javax.swing.JComboBox<>();
        bul_com_eleve = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        elv_list.setFont(new java.awt.Font("Nimbus", 0, 18)); // NOI18N
        elv_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = get_liste_personne(1);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jScrollPane1.setViewportView(elv_list);

        elv_btn_sup.setText("Supprimer");
        elv_btn_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    elv_btn_supActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Listes des élèves :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nom :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Classe :");

        elv_btn_add.setText("Ajouter");
        elv_btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    elv_btn_addActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Prenom :");

        elv_txt_prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elv_txt_prenomActionPerformed(evt);
            }
        });

        elv_txt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elv_txt_nomActionPerformed(evt);
            }
        });

        elv_txt_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elv_txt_classeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout elv_panelLayout = new javax.swing.GroupLayout(elv_panel);
        elv_panel.setLayout(elv_panelLayout);
        elv_panelLayout.setHorizontalGroup(
            elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(elv_panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(elv_panelLayout.createSequentialGroup()
                        .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elv_btn_sup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(elv_panelLayout.createSequentialGroup()
                                    .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(34, 34, 34)
                                    .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(elv_txt_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(elv_txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(elv_panelLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(elv_txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(elv_btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        elv_panelLayout.setVerticalGroup(
            elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(elv_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(elv_panelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elv_txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elv_txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elv_txt_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(elv_panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(elv_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(elv_panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(elv_btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(elv_panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(elv_btn_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        elv_tab.addTab("Elèves", elv_panel);

        prof_list.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prof_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = get_liste_personne(2);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(prof_list);

        prof_btn_sup.setText("Supprimer");
        prof_btn_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    prof_btn_supActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Listes des professeurs :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nom :");

        prof_btn_add.setText("Ajouter");
        prof_btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    prof_btn_addActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Prenom :");

        prof_txt_prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_txt_prenomActionPerformed(evt);
            }
        });

        prof_txt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_txt_nomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout prof_panelLayout = new javax.swing.GroupLayout(prof_panel);
        prof_panel.setLayout(prof_panelLayout);
        prof_panelLayout.setHorizontalGroup(
            prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prof_panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(prof_panelLayout.createSequentialGroup()
                        .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prof_btn_sup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(prof_panelLayout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(prof_txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(prof_panelLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prof_txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(prof_btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        prof_panelLayout.setVerticalGroup(
            prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prof_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prof_panelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prof_txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(prof_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prof_txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(prof_btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prof_panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(prof_btn_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        elv_tab.addTab("Professeurs", prof_panel);

        ens_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = get_liste_enseignement();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(ens_list);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Listes des enseignements :");

        ens_btn_sup.setText("Supprimer");
        ens_btn_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ens_btn_supActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ens_com_classe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ens_com_classe.setModel(new javax.swing.DefaultComboBoxModel<>(get_liste_classe()));
        ens_com_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ens_com_classeActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Professeur :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Matière :");

        ens_com_matiere.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ens_com_matiere.setModel(new javax.swing.DefaultComboBoxModel<>(get_liste_matiere()));
        ens_com_matiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ens_com_matiereActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Classe :");

        ens_com_prof.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ens_com_prof.setModel(new javax.swing.DefaultComboBoxModel<>(get_liste_personne(2)));
        ens_com_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ens_com_profActionPerformed(evt);
            }
        });

        ens_btn_add.setText("Ajouter");
        ens_btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ens_btn_addActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout ens_panelLayout = new javax.swing.GroupLayout(ens_panel);
        ens_panel.setLayout(ens_panelLayout);
        ens_panelLayout.setHorizontalGroup(
            ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ens_panelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ens_panelLayout.createSequentialGroup()
                        .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ens_panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ens_panelLayout.createSequentialGroup()
                                .addGap(0, 37, Short.MAX_VALUE)
                                .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ens_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(ens_com_prof, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(ens_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ens_com_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ens_com_matiere, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(76, 76, 76)))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ens_panelLayout.createSequentialGroup()
                        .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ens_panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ens_btn_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ens_panelLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(146, 146, 146))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ens_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ens_btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        ens_panelLayout.setVerticalGroup(
            ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ens_panelLayout.createSequentialGroup()
                .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ens_panelLayout.createSequentialGroup()
                        .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ens_panelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9))
                            .addGroup(ens_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ens_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ens_btn_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGap(40, 40, 40)
                .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ens_com_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(ens_com_matiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(ens_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ens_com_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(ens_btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        elv_tab.addTab("Enseignement", ens_panel);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Appreciation :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Trimestre :");

        bul_btn_mod.setText("Modifier");
        bul_btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bul_btn_modActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        bul_btn_sup.setText("Supprimer");
        bul_btn_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bul_btn_supActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EditInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Elève :");

        bul_txtarea_app.setColumns(20);
        bul_txtarea_app.setRows(5);
        jScrollPane7.setViewportView(bul_txtarea_app);

        bul_com_trimestre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bul_com_trimestre.setModel(new javax.swing.DefaultComboBoxModel<>(get_liste_trimestre()));
        bul_com_trimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bul_com_trimestreActionPerformed(evt);
            }
        });

        bul_com_eleve.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bul_com_eleve.setModel(new javax.swing.DefaultComboBoxModel<>(get_liste_personne(1)));
        bul_com_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bul_com_eleveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bul_panelLayout = new javax.swing.GroupLayout(bul_panel);
        bul_panel.setLayout(bul_panelLayout);
        bul_panelLayout.setHorizontalGroup(
            bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bul_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bul_panelLayout.createSequentialGroup()
                        .addComponent(bul_com_trimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bul_com_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bul_panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bul_btn_sup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bul_btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))))
        );
        bul_panelLayout.setVerticalGroup(
            bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bul_panelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bul_com_trimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bul_com_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bul_panelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bul_panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(bul_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bul_panelLayout.createSequentialGroup()
                                .addComponent(bul_btn_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bul_btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112))))
        );

        elv_tab.addTab("Bulletin", bul_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(elv_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(elv_tab)
        );

        pack();
    }// </editor-fold>                        

    private void prof_txt_nomActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void prof_txt_prenomActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void prof_btn_addActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                             
        // TODO add your handling code here:
         if(prof_txt_nom.getText().equals("")||prof_txt_prenom.getText().equals("")){
            display_error();
        }
        else{
            Personne p = new Personne(0,prof_txt_nom.getText(),prof_txt_prenom.getText(),2);
         
            AccessCo.PersonneDAO.create(p);
            prof_list.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = get_liste_personne(2);
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
                });   

        }
    }                                            

    private void prof_btn_supActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                             
        // TODO add your handling code here:
        String selectedText = (String)prof_list.getSelectedValue(); 
        String[] splited = selectedText.split(" ");       
        AccessCo.con.executeUpdate("Delete from personne where nom='"+splited[0]+"' AND prenom='"+splited[1]+"'");
        prof_list.setModel(new javax.swing.AbstractListModel<String>() {
        String[] strings = get_liste_personne(2);
        public int getSize() { return strings.length; }
        public String getElementAt(int i) { return strings[i]; }
        });  
    }                                            

    private void elv_txt_classeActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void elv_txt_nomActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void elv_txt_prenomActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void elv_btn_addActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                            
        // TODO add your handling code here:
        if(elv_txt_nom.getText().equals("")||elv_txt_prenom.getText().equals("")||elv_txt_classe.getText().equals("")){
            display_error();
        }
        else{
            Personne p = new Personne((AccessCo.PersonneDAO.getSize()+1),elv_txt_nom.getText(),elv_txt_prenom.getText(),1);
            AccessCo.PersonneDAO.create(p);
            System.out.println("Eleve ajouté");
            elv_list.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = get_liste_personne(1);
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
                });   

        }
    }                                           

    private void elv_btn_supActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                            
        // TODO add your handling code here:

        String selectedText = (String)elv_list.getSelectedValue(); 
        String[] splited = selectedText.split(" ");       
        AccessCo.con.executeUpdate("Delete from personne where nom='"+splited[0]+"' AND prenom='"+splited[1]+"'");
        elv_list.setModel(new javax.swing.AbstractListModel<String>() {
        String[] strings = get_liste_personne(1);
        public int getSize() { return strings.length; }
        public String getElementAt(int i) { return strings[i]; }
        }); 
        
        
    }                                           

    private void ens_btn_supActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                            
        // TODO add your handling code here:
        int id=ens_list.getSelectedIndex()+1;
        AccessCo.con.executeUpdate("Delete from enseignement where id="+id);
         ens_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = get_liste_enseignement();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
            });  

    }                                           

    private void ens_com_classeActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void ens_com_matiereActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void ens_com_profActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void ens_btn_addActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                            
        // TODO add your handling code here
        
        String selectedText = (String)ens_com_prof.getSelectedItem().toString(); // it works
        String[] splited = selectedText.split(" ");   
        ArrayList res = AccessCo.con.remplirChampsRequete("Select id from personne where nom='"+splited[0]+"' AND prenom='"+splited[1]+"'");
        System.out.println(res+"id personne");
        String prof_id = (String) res.get(0);
                System.out.println(prof_id);
        int pid= Integer.parseInt((String) res.get(0));
        String req="Insert into enseignement (classeId,disciplineId,personneId) VALUES ("+(ens_com_classe.getSelectedIndex()+1)+","+(ens_com_matiere.getSelectedIndex()+1)+","+prof_id+")";
        System.out.println(req);

       
       ens_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = get_liste_enseignement();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
            });  
       

       
       
       
        
    }                                           

    private void bul_btn_modActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                            
        // TODO add your handling code here:
        
                  String selectedText = (String)bul_com_eleve.getSelectedItem().toString(); // it works
        String[] splited = selectedText.split(" ");   

        ArrayList res = AccessCo.con.remplirChampsRequete("Select id from personne where nom='"+splited[0]+"' AND prenom='"+splited[1]+"'");
        int ii=Integer.parseInt((String) res.get(0));      
        ArrayList res2 = AccessCo.con.remplirChampsRequete("Select id from inscription where personneid="+ii);
        int inscr_id=Integer.parseInt((String) res2.get(0));
          ArrayList last_rep=  AccessCo.con.remplirChampsRequete("Select appreciation from bulletin where trimestreId="+bul_com_trimestre.getSelectedIndex()+1+" and inscriptionid="+inscr_id);  

        if (this.getStep()==0){
   
            String str = "TESt";
            
            str = (String) last_rep.get(0);
            
            bul_txtarea_app.setText(str);
            this.setStep(1);
        }
        else {
            ArrayList last_rep2=  AccessCo.con.remplirChampsRequete("Select id from bulletin where trimestreId="+bul_com_trimestre.getSelectedIndex()+1+" and inscriptionid="+inscr_id);            
            AccessCo.con.executeUpdate("Update bulletin set appreciation='"+bul_txtarea_app.getText()+"' Where trimestreId="+bul_com_trimestre.getSelectedIndex()+1+" and inscriptionid="+inscr_id);
            bul_txtarea_app.setText("");
            this.setStep(0);
        }
        
        

    }                                           

    private void bul_btn_supActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                            
        // TODO add your handling code here:
        String selectedText = (String)bul_com_eleve.getSelectedItem().toString(); // it works
        String[] splited = selectedText.split(" ");   

        ArrayList res = AccessCo.con.remplirChampsRequete("Select id from personne where nom='"+splited[0]+"' AND prenom='"+splited[1]+"'");
        int ii=Integer.parseInt((String) res.get(0));      
        ArrayList res2 = AccessCo.con.remplirChampsRequete("Select id from inscription where personneid="+ii);
        int inscr_id=Integer.parseInt((String) res2.get(0));
        AccessCo.con.executeUpdate("Delete from bulletin where trimestreId="+bul_com_trimestre.getSelectedIndex()+1+" and inscriptionid="+inscr_id);  

    }                                           

    private void bul_com_trimestreActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void bul_com_eleveActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bul_btn_mod;
    private javax.swing.JButton bul_btn_sup;
    private javax.swing.JComboBox<String> bul_com_eleve;
    private javax.swing.JComboBox<String> bul_com_trimestre;
    private javax.swing.JPanel bul_panel;
    private javax.swing.JTextArea bul_txtarea_app;
    private javax.swing.JButton elv_btn_add;
    private javax.swing.JButton elv_btn_sup;
    private javax.swing.JList<String> elv_list;
    private javax.swing.JPanel elv_panel;
    private javax.swing.JTabbedPane elv_tab;
    private javax.swing.JTextField elv_txt_classe;
    private javax.swing.JTextField elv_txt_nom;
    private javax.swing.JTextField elv_txt_prenom;
    private javax.swing.JButton ens_btn_add;
    private javax.swing.JButton ens_btn_sup;
    private javax.swing.JComboBox<String> ens_com_classe;
    private javax.swing.JComboBox<String> ens_com_matiere;
    private javax.swing.JComboBox<String> ens_com_prof;
    private javax.swing.JList<String> ens_list;
    private javax.swing.JPanel ens_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton prof_btn_add;
    private javax.swing.JButton prof_btn_sup;
    private javax.swing.JList<String> prof_list;
    private javax.swing.JPanel prof_panel;
    private javax.swing.JTextField prof_txt_nom;
    private javax.swing.JTextField prof_txt_prenom;
    // End of variables declaration                   

}
