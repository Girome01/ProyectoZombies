/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozombie.interfaz;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.Users.User;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import proyectozombie.Logica.*;

/**
 *
 * @author monic
 */
public class campoBatalla_Juego extends javax.swing.JFrame implements Serializable {
    //protected Personajes listaPersonajesUsuario;
    // Si javi agrega la clase personajes descomentar eso y pasarla por referencia en el contructor
    public Game batalla;
    public ArrayList<CharacterGame> listaPersonajesUsuario;
    protected User usuario;

  
   public campoBatalla_Juego(ArrayList<CharacterGame> listaPersonajesUsuario, User usuario) {
       this.listaPersonajesUsuario = listaPersonajesUsuario;
        batalla = new Game(this,listaPersonajesUsuario);
        this.usuario=usuario;
        initComponents();
    }
   public void mostrarGanador(String ganador){
        JOptionPane.showMessageDialog(fondo_Juego,"Ganador: "+ganador,"Resultado de la batalla",JOptionPane.OK_OPTION);
        if(ganador.equalsIgnoreCase("Aliados")){
            usuario.setLevel(usuario.getLevel()+1);
        }
        
        this.setVisible(false);
        escogerPersonajes_Juego frame = new escogerPersonajes_Juego(usuario);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(290, 150);
        frame.setVisible(true);
    } 
   
    public JLabel generateLabel(String imagen, int xUser, int yUser){
        JLabel imageLabel = new JLabel();
        ImageIcon imageicon = new ImageIcon(imagen);
        int ancho=imageicon.getIconWidth();
        int alto=imageicon.getIconHeight();
        Image img = imageicon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setSize(ancho, alto);
        imageLabel.setOpaque(false);
        lbl_FondoBatalla.add(imageLabel);
        
        int x = 23*xUser; //23 por un numero de 1 a 25 para que el usuario escoja la posicion
        x = x-(x%23);
        int y = 30*yUser; //30 por un numero de 1 a 25 para que el usuario escoja la posicion
        y = y-(y%30);
        imageLabel.setLocation(x,y);
       
        return imageLabel;
    
    }
    
    public void moveLabel (JLabel label, JLabel arma){
        int direccion = (new Random()).nextInt(4);
        int x = label.getLocation().x;
        int y = label.getLocation().y;
        
        switch(direccion){
            case 0: // arriba
                if (y-30 >= 0) y = y-30; break;
            case 1: // abajo
                if (y+30 <= 750) y = y+30; break;
            case 2: // izquirda
                if (x+23 <= 575) x = x+23; break;
            default: //derecha
                if (x-23 >= 0) x = x-23; break; 
        }
        if (batalla.isAvailable(x, y)){
            label.setLocation(x, y);
            if(arma != null)
                arma.setLocation(x+22, y);
        }
              
    }
    
    
    public void escribirHilos(String texto){
       txtArea_hilos.append(texto+" \n");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fondo_Juego = new javax.swing.JPanel();
        btn_Start = new javax.swing.JButton();
        btn_Stop = new javax.swing.JButton();
        btn_Pause = new javax.swing.JButton();
        panelEscenario = new javax.swing.JPanel();
        lbl_FondoBatalla = new javax.swing.JLabel();
        btn_Next = new javax.swing.JButton();
        txtArea_hilos = new java.awt.TextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Herencia al trono");

        fondo_Juego.setBackground(new java.awt.Color(102, 0, 102));

        btn_Start.setBackground(new java.awt.Color(0, 0, 0));
        btn_Start.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        btn_Start.setForeground(new java.awt.Color(204, 0, 204));
        btn_Start.setText("Iniciar");
        btn_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartActionPerformed(evt);
            }
        });

        btn_Stop.setBackground(new java.awt.Color(0, 0, 0));
        btn_Stop.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        btn_Stop.setForeground(new java.awt.Color(204, 0, 204));
        btn_Stop.setText("Detener");
        btn_Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StopActionPerformed(evt);
            }
        });

        btn_Pause.setBackground(new java.awt.Color(0, 0, 0));
        btn_Pause.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        btn_Pause.setForeground(new java.awt.Color(204, 0, 204));
        btn_Pause.setText("Pausa");
        btn_Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PauseActionPerformed(evt);
            }
        });

        panelEscenario.setBackground(new java.awt.Color(204, 204, 204));

        lbl_FondoBatalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectozombie/img/fondoBatalla_1.png"))); // NOI18N

        javax.swing.GroupLayout panelEscenarioLayout = new javax.swing.GroupLayout(panelEscenario);
        panelEscenario.setLayout(panelEscenarioLayout);
        panelEscenarioLayout.setHorizontalGroup(
            panelEscenarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_FondoBatalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelEscenarioLayout.setVerticalGroup(
            panelEscenarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_FondoBatalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_Next.setBackground(new java.awt.Color(0, 0, 0));
        btn_Next.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        btn_Next.setForeground(new java.awt.Color(204, 0, 204));
        btn_Next.setText("Next");
        btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondo_JuegoLayout = new javax.swing.GroupLayout(fondo_Juego);
        fondo_Juego.setLayout(fondo_JuegoLayout);
        fondo_JuegoLayout.setHorizontalGroup(
            fondo_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo_JuegoLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(fondo_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelEscenario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondo_JuegoLayout.createSequentialGroup()
                        .addComponent(btn_Start)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Pause, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addComponent(txtArea_hilos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fondo_JuegoLayout.setVerticalGroup(
            fondo_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo_JuegoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(panelEscenario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fondo_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondo_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Pause, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addComponent(txtArea_hilos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo_Juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo_Juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartActionPerformed
        batalla.generateDefense();
        batalla.generateEnemies();
        batalla.startArmy();
        batalla.startEnemies();

    }//GEN-LAST:event_btn_StartActionPerformed

    private void btn_StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StopActionPerformed
        batalla.stopGame();
    }//GEN-LAST:event_btn_StopActionPerformed

    private void btn_PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PauseActionPerformed
        batalla.pauseGame();
    }//GEN-LAST:event_btn_PauseActionPerformed

    private void btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NextActionPerformed
        batalla.stopGame();
        JOptionPane.showMessageDialog(fondo_Juego,"Ganador: Aliados","Resultado de la batalla",JOptionPane.OK_OPTION);
        
        usuario.setLevel(usuario.getLevel()+1);
        
        this.setVisible(false);
        escogerPersonajes_Juego frame = new escogerPersonajes_Juego(usuario);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(290, 150);
        frame.setVisible(true);
    }//GEN-LAST:event_btn_NextActionPerformed
                        
    /**
     * 
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Next;
    private javax.swing.JButton btn_Pause;
    private javax.swing.JButton btn_Start;
    private javax.swing.JButton btn_Stop;
    private javax.swing.JPanel fondo_Juego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_FondoBatalla;
    private javax.swing.JPanel panelEscenario;
    private java.awt.TextArea txtArea_hilos;
    // End of variables declaration//GEN-END:variables
}
