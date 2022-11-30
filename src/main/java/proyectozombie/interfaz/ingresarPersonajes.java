package proyectozombie.interfaz;

import proyectozombie.CharacterCreation.*;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import proyectozombie.GameEnviroment.Presets;
import proyectozombie.GameEnviroment.Weapons.*;
import proyectozombie.GameEnviroment.Zombies.*;
import proyectozombie.Logica.FileManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monic
 */
public class ingresarPersonajes extends javax.swing.JFrame {
    private Presets personajes;
    private String path = "C:\\Users\\Usuario\\Desktop\\TEC\\VI_semestre\\Diseno_Software\\Proyecto_3\\git\\ProyectoZombies\\src\\main\\java\\proyectozombie";
    //private String path = "C:\\Users\\anagu\\OneDrive\\Documentos\\TEC\\SemestreII2022\\DiseñoAlgoritmos\\ProyectoZombies\\src\\main\\java\\proyectozombie";
    private ArrayList<CharacterGame> ingresados = new ArrayList();
    
    public ingresarPersonajes() {
       initComponents();
       addTableHeader();
       Object valor = (Presets) FileManager.readObject(path+"\\ArchivosSerializados\\personajes.juego"); 
       if(valor!=null){
           System.out.println("EXISTE ARCHIVO");
           personajes = (Presets) FileManager.readObject(path+"\\ArchivosSerializados\\personajes.juego");  
           System.out.println("Weapons: "+personajes.getWeapon().size());
           System.out.println("Zombies: "+personajes.getZombie().size());
       }else{
           personajes = new Presets();
       }
        
        generarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Fondo = new javax.swing.JPanel();
        lbl_Titulo0 = new javax.swing.JLabel();
        txt_Campos = new javax.swing.JTextField();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_Campos = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_Aparicion = new javax.swing.JLabel();
        txt_Aparicion = new javax.swing.JTextField();
        lbl_Vida = new javax.swing.JLabel();
        txt_Vida = new javax.swing.JTextField();
        lbl_Nivel = new javax.swing.JLabel();
        txt_Nivel = new javax.swing.JTextField();
        combo_Tipos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Personajes = new javax.swing.JTable();
        lbl_Ataque = new javax.swing.JLabel();
        txt_Ataque = new javax.swing.JTextField();
        lbl_Rango = new javax.swing.JLabel();
        txt_Rango = new javax.swing.JTextField();
        btn_Ingresar = new javax.swing.JButton();
        btn_Apariencia = new javax.swing.JButton();
        lbl_Costo = new javax.swing.JLabel();
        txt_Costo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar personajes");
        setResizable(false);
        setSize(new java.awt.Dimension(755, 456));

        panel_Fondo.setMaximumSize(new java.awt.Dimension(755, 456));
        panel_Fondo.setMinimumSize(new java.awt.Dimension(755, 456));
        panel_Fondo.setLayout(null);

        lbl_Titulo0.setBackground(new java.awt.Color(0, 0, 0));
        lbl_Titulo0.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lbl_Titulo0.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Titulo0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Titulo0.setText("Ingresar personajes");
        lbl_Titulo0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Titulo0.setOpaque(true);
        panel_Fondo.add(lbl_Titulo0);
        lbl_Titulo0.setBounds(130, 10, 500, 50);

        txt_Campos.setBackground(new java.awt.Color(102, 0, 102));
        txt_Campos.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        panel_Fondo.add(txt_Campos);
        txt_Campos.setBounds(550, 70, 170, 30);

        lbl_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Usuario.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Usuario.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Usuario.setText("Nombre:");
        lbl_Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Usuario.setOpaque(true);
        panel_Fondo.add(lbl_Usuario);
        lbl_Usuario.setBounds(30, 70, 140, 30);

        lbl_Campos.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Campos.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Campos.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Campos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Campos.setText("Campos:");
        lbl_Campos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Campos.setOpaque(true);
        panel_Fondo.add(lbl_Campos);
        lbl_Campos.setBounds(390, 70, 140, 30);

        txt_Nombre.setBackground(new java.awt.Color(102, 0, 102));
        txt_Nombre.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });
        panel_Fondo.add(txt_Nombre);
        txt_Nombre.setBounds(190, 70, 170, 30);

        lbl_Aparicion.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Aparicion.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Aparicion.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Aparicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Aparicion.setText("Aparición:");
        lbl_Aparicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Aparicion.setOpaque(true);
        panel_Fondo.add(lbl_Aparicion);
        lbl_Aparicion.setBounds(390, 110, 140, 30);

        txt_Aparicion.setBackground(new java.awt.Color(102, 0, 102));
        txt_Aparicion.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        txt_Aparicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AparicionActionPerformed(evt);
            }
        });
        panel_Fondo.add(txt_Aparicion);
        txt_Aparicion.setBounds(550, 110, 170, 30);

        lbl_Vida.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Vida.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Vida.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Vida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Vida.setText("Vida:");
        lbl_Vida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Vida.setOpaque(true);
        panel_Fondo.add(lbl_Vida);
        lbl_Vida.setBounds(30, 110, 140, 30);

        txt_Vida.setBackground(new java.awt.Color(102, 0, 102));
        txt_Vida.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        txt_Vida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_VidaActionPerformed(evt);
            }
        });
        panel_Fondo.add(txt_Vida);
        txt_Vida.setBounds(190, 110, 170, 30);

        lbl_Nivel.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Nivel.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Nivel.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Nivel.setText("Nivel:");
        lbl_Nivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Nivel.setOpaque(true);
        panel_Fondo.add(lbl_Nivel);
        lbl_Nivel.setBounds(390, 190, 140, 30);

        txt_Nivel.setBackground(new java.awt.Color(102, 0, 102));
        txt_Nivel.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        panel_Fondo.add(txt_Nivel);
        txt_Nivel.setBounds(550, 190, 170, 30);

        combo_Tipos.setBackground(new java.awt.Color(0, 0, 0));
        combo_Tipos.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        combo_Tipos.setForeground(new java.awt.Color(102, 0, 102));
        combo_Tipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Armas: De contacto", "Armas: Mediano alcance", "Armas: Aéreos", "Armas: Impacto", "Armas: Ataque multiple", "Armas: Bloques", "Zombie: De contacto", "Zombie: Aéreo", "Zombie: Mediano alcance", "Zombie: Choque" }));
        combo_Tipos.setToolTipText("Tipo guerrero");
        combo_Tipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_TiposActionPerformed(evt);
            }
        });
        panel_Fondo.add(combo_Tipos);
        combo_Tipos.setBounds(390, 150, 330, 30);

        table_Personajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_Personajes.setGridColor(new java.awt.Color(102, 0, 102));
        jScrollPane2.setViewportView(table_Personajes);

        panel_Fondo.add(jScrollPane2);
        jScrollPane2.setBounds(30, 340, 720, 130);

        lbl_Ataque.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Ataque.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Ataque.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Ataque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Ataque.setText("Ataque:");
        lbl_Ataque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Ataque.setOpaque(true);
        panel_Fondo.add(lbl_Ataque);
        lbl_Ataque.setBounds(30, 150, 140, 30);

        txt_Ataque.setBackground(new java.awt.Color(102, 0, 102));
        txt_Ataque.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        panel_Fondo.add(txt_Ataque);
        txt_Ataque.setBounds(190, 150, 170, 30);

        lbl_Rango.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Rango.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Rango.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Rango.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Rango.setText("Rango: ");
        lbl_Rango.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Rango.setOpaque(true);
        panel_Fondo.add(lbl_Rango);
        lbl_Rango.setBounds(30, 230, 140, 30);

        txt_Rango.setBackground(new java.awt.Color(102, 0, 102));
        txt_Rango.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        panel_Fondo.add(txt_Rango);
        txt_Rango.setBounds(190, 230, 170, 30);

        btn_Ingresar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Ingresar.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btn_Ingresar.setForeground(new java.awt.Color(102, 0, 102));
        btn_Ingresar.setText("Ingresar");
        btn_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresarActionPerformed(evt);
            }
        });
        panel_Fondo.add(btn_Ingresar);
        btn_Ingresar.setBounds(220, 270, 150, 40);

        btn_Apariencia.setBackground(new java.awt.Color(0, 0, 0));
        btn_Apariencia.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btn_Apariencia.setForeground(new java.awt.Color(102, 0, 102));
        btn_Apariencia.setText("Apariencia");
        btn_Apariencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AparienciaActionPerformed(evt);
            }
        });
        panel_Fondo.add(btn_Apariencia);
        btn_Apariencia.setBounds(400, 270, 150, 40);

        lbl_Costo.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Costo.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Costo.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Costo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Costo.setText("Costo:");
        lbl_Costo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Costo.setOpaque(true);
        panel_Fondo.add(lbl_Costo);
        lbl_Costo.setBounds(30, 190, 140, 30);

        txt_Costo.setBackground(new java.awt.Color(102, 0, 102));
        txt_Costo.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        panel_Fondo.add(txt_Costo);
        txt_Costo.setBounds(190, 190, 170, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("Ingresar personajes al juego (ADMIN)");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void txt_AparicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AparicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AparicionActionPerformed

    private void txt_VidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_VidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_VidaActionPerformed

    private void combo_TiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_TiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_TiposActionPerformed

    private void btn_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresarActionPerformed
        // TODO add your handling code here:
        
        
        String nombre = txt_Nombre.getText();
        String vidaStr = txt_Vida.getText();
        String ataqueStr = txt_Ataque.getText();
        String costoStr = txt_Rango.getText();
        String camposStr = txt_Campos.getText();
        String aparicionStr = txt_Aparicion.getText();
        String nivelStr = txt_Nivel.getText();
        String rangoStr = txt_Rango.getText();
        int guerreroEscogido= combo_Tipos.getSelectedIndex();
        String guerreroEscogidoStr= combo_Tipos.getItemAt(guerreroEscogido);
        

        if(!nombre.isBlank() && !vidaStr.isBlank() && !ataqueStr.isBlank() && !camposStr.isBlank() &&
            !costoStr.isBlank() && !aparicionStr.isBlank() && !guerreroEscogidoStr.isBlank() && 
                !nivelStr.isBlank() && !rangoStr.isBlank()){
            int vida = Integer.parseInt(vidaStr);
            int ataque = Integer.parseInt(ataqueStr);
            int campos = Integer.parseInt(camposStr);
            int aparicion = Integer.parseInt(aparicionStr);
            int nivel = Integer.parseInt(nivelStr);
            int rango = Integer.parseInt(rangoStr);
            double costo = Double.parseDouble(costoStr);
            
            //Definir las apariencias default
            Appearance defaultAppearance = new Appearance();
            defaultAppearance.addAppearance("lapida", path+"\\img\\lapida.png");
            //defaultAppearance.addAppearance("STOP", imageDir+"rojoD.png");
            
            HashMap<Integer, Appearance> defaultAppearanceHM = new HashMap<>();
            defaultAppearanceHM.put(0, defaultAppearance);
            
            Gear gearItem = null;
            
            switch (guerreroEscogido) {
                case 0:
                    ContactWeapon contactWeapon = (ContactWeapon) new ContactWeapon(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel, 0);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/

                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    contactWeapon.cAddGear("Gear", gearItem);
                    
                    personajes.addWeapon(contactWeapon);
                    ingresados.add(contactWeapon);
                    break;
                case 1:
                    MediumRange mediumRange = (MediumRange) new MediumRange(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel, 0);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    mediumRange.cAddGear("Gear", gearItem);
                    
                    personajes.addWeapon(mediumRange);
                    ingresados.add(mediumRange);
                    break;
                case 2:
                    Aerial aerial = new Aerial(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel, 1);
                            /*CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    aerial.cAddGear("Gear", gearItem);
                                    
                    personajes.addWeapon(aerial);
                    ingresados.add(aerial);
                    break;
                case 3:
                    Impact impacto = (Impact) new Impact(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel, 0);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    impacto.cAddGear("Gear", gearItem);
                    
                    personajes.addWeapon(impacto);
                    ingresados.add(impacto);
                    break;
                case 4:
                    MultiAttack multiAttack = (MultiAttack) new MultiAttack(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel, 0);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    multiAttack.cAddGear("Gear", gearItem);
                    
                    personajes.addWeapon(multiAttack);
                    ingresados.add(multiAttack);
                    break;
                case 5:
                    Blocks block = (Blocks) new Blocks(nombre, 
                            defaultAppearanceHM, aparicion, 0, vida, campos, costo, nivel, 0);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    block.cAddGear("Gear", gearItem);
                    
                    personajes.addWeapon(block);
                    ingresados.add(block);
                    break;
                case 6:
                    ContactZombie contactZ = (ContactZombie) new ContactZombie(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    contactZ.cAddGear("Gear", gearItem);
                    
                    personajes.addZombie(contactZ);
                    ingresados.add(contactZ);
                    break;
                case 7:
                    AerialZombie aerialZ = (AerialZombie) new AerialZombie(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    aerialZ.cAddGear("Gear", gearItem);
                    
                    personajes.addZombie(aerialZ);
                    ingresados.add(aerialZ);
                    break;
                case 8:
                    HalfRangeZombie halfRangeZ = (HalfRangeZombie) new HalfRangeZombie(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    halfRangeZ.cAddGear("Gear", gearItem);
                    
                    personajes.addZombie(halfRangeZ);
                    ingresados.add(halfRangeZ);
                    break;
                case 9:
                    SmashZombie smashZ = (SmashZombie) new SmashZombie(nombre, 
                            defaultAppearanceHM, aparicion, ataque, vida, campos, costo, nivel);
                            /*.CharacterBuilder()
                            .setcName(nombre)
                            .setcLife(vida)
                            .setcHitPS(ataque)
                            .setcCost(costo)
                            .setcStorageSpace(campos)
                            .setcSpawnLevel(nivel)
                            .setcAppearance(defaultAppearanceHM)
                            .setcLevel(nivel).build();*/
                    
                    gearItem = new Gear("Gear", rango, ataque, nivel, 1, null, true);
                    smashZ.cAddGear("Gear", gearItem);
                    
                    personajes.addZombie(smashZ);
                    ingresados.add(smashZ);
                    break;
                default:
                    JOptionPane.showMessageDialog(panel_Fondo,"Esa arma o zombie no es valido.","Atención",JOptionPane.WARNING_MESSAGE);
                    break;
            }
            FileManager.writeObject(personajes, this.path+"\\ArchivosSerializados\\personajes.juego");
         
            
            //JLabel imageLabel = new JLabel();
            //ImageIcon imageicon = new ImageIcon(lbl_rutaA.getText());
            //Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            //imageLabel.setIcon(new ImageIcon(img));
            model.addRow(new Object[]{nombre,nivel, aparicion, vida, ataque, campos, costo});
            limpiarFields();
        }else{
            JOptionPane.showMessageDialog(panel_Fondo,"Los campos están vacíos.","Atención",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_IngresarActionPerformed

    private void btn_AparienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AparienciaActionPerformed
        // TODO add your handling code here:
            ingresarPersonajes window = this;
            window.setVisible(false);
            ingresarApariencia frame = new ingresarApariencia(ingresados, personajes);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocation(290, 50);
            frame.setVisible(true);
            
    }//GEN-LAST:event_btn_AparienciaActionPerformed
DefaultTableModel model;
    
//    byte imageJtable = new Byte(1024);
 
//Adding table headers
    public void addTableHeader() {
        model = (DefaultTableModel) table_Personajes.getModel();
        Object[] newIdentifiers = new Object[]{"Nombre","Nivel", "Aparicion","Vida", "Ataque", "Campo","Costo"};
        model.setColumnIdentifiers(newIdentifiers);
        //table_Personajes.setFillsViewportHeight(true);
        //table_Personajes.getColumn("Imagen").setCellRenderer(new CellRenderer());
 
    }

 
    class CellRenderer implements TableCellRenderer {
 
        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
 
            TableColumn tb = table_Personajes.getColumn("Imagen");
            tb.setMaxWidth(60);
            tb.setMinWidth(60);
 
            table_Personajes.setRowHeight(60);
 
            return (Component) value;
        }
 
    }
    private void generarTabla(){
        for(int i = 0; i < ingresados.size(); i++){
            String nombre = ingresados.get(i).getcName();
            int nivel = ingresados.get(i).getcLevel();
            int aparicion = ingresados.get(i).getcSpawnLevel();
            int vida = ingresados.get(i).getcLife();
            int ataque = ingresados.get(i).getcHitPS();
            int campos = ingresados.get(i).getcStorageSpace();
            double costo = ingresados.get(i).getcCost();

            model.addRow(new Object[]{nombre, nivel, aparicion, vida, ataque, campos, costo});
        }
  }
 
    private void limpiarFields() {
        txt_Nombre.setText("");
        txt_Vida.setText("");
        txt_Nivel.setText("");
        txt_Nombre.setText("");
        txt_Campos.setText("");
        txt_Aparicion.setText("");
        txt_Rango.setText("");
        txt_Ataque.setText("");
        txt_Nivel.setText("");
        txt_Rango.setText("");
        combo_Tipos.setSelectedIndex(-1);
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
            java.util.logging.Logger.getLogger(ingresarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ingresarPersonajes frame = new ingresarPersonajes();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(290, 50);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Apariencia;
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JComboBox<String> combo_Tipos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Aparicion;
    private javax.swing.JLabel lbl_Ataque;
    private javax.swing.JLabel lbl_Campos;
    private javax.swing.JLabel lbl_Costo;
    private javax.swing.JLabel lbl_Nivel;
    private javax.swing.JLabel lbl_Rango;
    private javax.swing.JLabel lbl_Titulo0;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel lbl_Vida;
    private javax.swing.JPanel panel_Fondo;
    private javax.swing.JTable table_Personajes;
    private javax.swing.JTextField txt_Aparicion;
    private javax.swing.JTextField txt_Ataque;
    private javax.swing.JTextField txt_Campos;
    private javax.swing.JTextField txt_Costo;
    private javax.swing.JTextField txt_Nivel;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Rango;
    private javax.swing.JTextField txt_Vida;
    // End of variables declaration//GEN-END:variables
}
