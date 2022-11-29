/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozombie.interfaz;
import proyectozombie.CharacterCreation.PFCharacter;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.Logica.FileManager;
import proyectozombie.Users.User;
import java.awt.Component;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import proyectozombie.GameEnviroment.Presets;

/**
 *
 * @author monic
 */
public class escogerPersonajes_Juego extends javax.swing.JFrame {
    protected ArrayList<CharacterGame> listaPersonajesUsuario;
    ArrayList<CharacterGame> personajes;
    PFCharacter characterFP = new PFCharacter();
    protected User usuario;
    Presets preset;
    
    private String path = "C:\\Users\\Usuario\\Desktop\\TEC\\VI_semestre\\Diseno Software\\Proyecto 3\\git\\ProyectoZombies\\src\\main\\java\\proyectozombie";
    
    /**
     * Creates new form escogerPersonajes_Juego
     * @param user     
     */
    public escogerPersonajes_Juego(User user) {
        initComponents();
        this.usuario = user;
        this.preset = new Presets();
        Object valor = FileManager.readObject(path+"\\ArchivosSerializados\\personajes.juego");
        if(valor != null){
            preset = (Presets) FileManager.readObject(path+"\\ArchivosSerializados\\personajes.juego");
        }
        preset.agregarPFCharacter(characterFP);
        mostrarNivel();
        subirNivel(user);
        generarTabla();
        
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
    
    public void generarTabla(){
       Object valor=(ArrayList<CharacterGame>) FileManager.readObject("src/main/java/CreacionPersonajes/Archivos/personajes.juego");   
       if(valor!=null){
            personajes=(ArrayList<CharacterGame>) FileManager.readObject("src/main/java/CreacionPersonajes/Archivos/personajes.juego");  
       }else{
           personajes=new ArrayList<>();
       }
       DefaultTableModel model;
        model = (DefaultTableModel) table_Personajes.getModel();
        table_Personajes.getColumn("Imagen").setCellRenderer(new CellRenderer());
        for(int i=0;i<personajes.size();i++){
            String nombre = personajes.get(i).getcName();
            int nivel = personajes.get(i).getcLevel();
            int aparicion = personajes.get(i).getcSpawnLevel();
            int vida = personajes.get(i).getcLife();
            int ataque = personajes.get(i).getcHitPS();
            int campos = personajes.get(i).getcStorageSpace();
            double costo = personajes.get(i).getcCost();
            String imageUrl=personajes.get(i).getcAppearance3(aparicion, "WALKING");
            characterFP.addPrototype(nombre, personajes.get(i));
         
            JLabel imageLabel = new JLabel();
            ImageIcon imageicon = new ImageIcon(imageUrl);
            Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            if(personajes.get(i).getcLevel() <= usuario.getLevel())          
                model.addRow(new Object[]{nombre,imageLabel,ataque,vida,costo,campos,0,false});

        }   
     }
        
    public void subirNivel(User user){
        PFCharacter.setLevels(user.getLevel());
    }
    
    public void mostrarNivel(){
        lbl_userLevel.setText("Nivel de "+usuario.getName()+": "+usuario.getLevel());
    }
         
    public boolean getValues(){
        listaPersonajesUsuario = new ArrayList<>();
        
        for(int i=0;i<table_Personajes.getModel().getRowCount();i++){
            if ((Boolean) table_Personajes.getModel().getValueAt(i,7)){
              String nombre=table_Personajes.getModel().getValueAt(i, 0).toString();
              System.out.println(nombre);
              int cantidad = (int) table_Personajes.getModel().getValueAt(i,6);
              ArrayList<CharacterGame> guerreros = PFCharacter.getPrototype(nombre,cantidad);
              if(guerreros!=null){
                  for (int j = 0; j < guerreros.size(); j++) {
                      listaPersonajesUsuario.add((CharacterGame)guerreros.get(j).clone());
                  }
                  
                  //Comprobar si las campos son correctos, campos referente a la cantidad de espacios que tiene el usuario
                  //disponible para poder crear tropas.
                  this.usuario.agregarColeccion(listaPersonajesUsuario);
                  if(!this.usuario.sumatoriaCampos()){ //nuevo da error
                      return false;
                  }
              }
              
            } 
        }
        return true;
    }
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */ 
        
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Fondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Personajes = new javax.swing.JTable();
        btn_Escoger = new javax.swing.JButton();
        lbl_userLevel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escoger personajes para jugar");
        setMinimumSize(new java.awt.Dimension(755, 456));
        setResizable(false);
        setSize(new java.awt.Dimension(755, 456));

        panel_Fondo.setBackground(new java.awt.Color(102, 0, 102));
        panel_Fondo.setLayout(null);

        table_Personajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Imagen", "Ataque", "Vida", "Costo", "Campos", "Cantidad", "Escogido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_Personajes);

        panel_Fondo.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 740, 330);

        btn_Escoger.setBackground(new java.awt.Color(0, 0, 0));
        btn_Escoger.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        btn_Escoger.setForeground(new java.awt.Color(204, 0, 204));
        btn_Escoger.setText("Escoger personajes");
        btn_Escoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EscogerActionPerformed(evt);
            }
        });
        panel_Fondo.add(btn_Escoger);
        btn_Escoger.setBounds(250, 390, 260, 40);

        lbl_userLevel.setBackground(new java.awt.Color(0, 0, 0));
        lbl_userLevel.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_userLevel.setForeground(new java.awt.Color(204, 0, 204));
        lbl_userLevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));
        lbl_userLevel.setOpaque(true);
        panel_Fondo.add(lbl_userLevel);
        lbl_userLevel.setBounds(580, 10, 160, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EscogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EscogerActionPerformed
        getValues();
        this.usuario.setWarriors(listaPersonajesUsuario);
        System.out.println(listaPersonajesUsuario);
        
        this.setVisible(false);


        asignarPosicion frame = new asignarPosicion(listaPersonajesUsuario, usuario);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(290, 50);
        frame.setVisible(true);
                
    }//GEN-LAST:event_btn_EscogerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Escoger;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_userLevel;
    private javax.swing.JPanel panel_Fondo;
    private javax.swing.JTable table_Personajes;
    // End of variables declaration//GEN-END:variables
}
