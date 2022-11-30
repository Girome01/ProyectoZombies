/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozombie.interfaz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectozombie.Users.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import proyectozombie.Logica.FileManager;

/**
 *
 * @author monic
 */
public class inicioSesion_Juego extends javax.swing.JFrame {
    protected UserDataBase listaUsuarios;
    private String path = "C:\\Users\\Usuario\\Desktop\\TEC\\VI_semestre\\Diseno_Software\\Proyecto_3\\git\\ProyectoZombies\\src\\main\\java\\proyectozombie";
    //private String path = "C:\\Users\\anagu\\OneDrive\\Documentos\\TEC\\SemestreII2022\\DiseñoAlgoritmos\\ProyectoZombies\\src\\main\\java\\proyectozombie";
    /**
     * Creates new form idk
     */
    public inicioSesion_Juego() {
        listaUsuarios = new UserDataBase();
        /*AdminUser admin = new AdminUser("ADMIN", 0, "ADMIN");
        listaUsuarios.agregarUsuario(admin);
        FileManager.writeObject(listaUsuarios, path+"\\ArchivosSerializados\\usuarios.juego");*/
        Object valor=(UserDataBase) FileManager.readObject(path+"\\ArchivosSerializados\\usuarios.juego");
        if(valor != null){
            listaUsuarios = (UserDataBase) FileManager.readObject(path+"\\ArchivosSerializados\\usuarios.juego");
            System.out.println(path+"\\ArchivosSerializados\\usuarios.juego");
        }  
        System.out.println(listaUsuarios.getListaUsuarios().size());
        initComponents();
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
        lbl_Contrasenna = new javax.swing.JLabel();
        lbl_Titulo0 = new javax.swing.JLabel();
        lbl_Titulo1 = new javax.swing.JLabel();
        txt_Usuario = new javax.swing.JTextField();
        lbl_Usuario = new javax.swing.JLabel();
        btn_Ingresar = new javax.swing.JButton();
        txt_Contrasenna = new javax.swing.JPasswordField();
        lbl_Titulo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel_Fondo.setMaximumSize(new java.awt.Dimension(755, 456));
        panel_Fondo.setMinimumSize(new java.awt.Dimension(755, 456));
        panel_Fondo.setLayout(null);

        lbl_Contrasenna.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Contrasenna.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Contrasenna.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Contrasenna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Contrasenna.setText("Contraseña:");
        lbl_Contrasenna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Contrasenna.setOpaque(true);
        panel_Fondo.add(lbl_Contrasenna);
        lbl_Contrasenna.setBounds(200, 330, 170, 27);

        lbl_Titulo0.setBackground(new java.awt.Color(0, 0, 0));
        lbl_Titulo0.setFont(new java.awt.Font("VCR OSD Mono", 0, 48)); // NOI18N
        lbl_Titulo0.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Titulo0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Titulo0.setText("Herencia al trono");
        lbl_Titulo0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Titulo0.setOpaque(true);
        panel_Fondo.add(lbl_Titulo0);
        lbl_Titulo0.setBounds(130, 20, 500, 110);

        lbl_Titulo1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Titulo1.setFont(new java.awt.Font("VCR OSD Mono", 0, 24)); // NOI18N
        lbl_Titulo1.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Titulo1.setText("Inicio de sesión");
        lbl_Titulo1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));
        lbl_Titulo1.setOpaque(true);
        panel_Fondo.add(lbl_Titulo1);
        lbl_Titulo1.setBounds(270, 140, 240, 60);

        txt_Usuario.setBackground(new java.awt.Color(102, 0, 102));
        txt_Usuario.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        panel_Fondo.add(txt_Usuario);
        txt_Usuario.setBounds(400, 220, 310, 30);

        lbl_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Usuario.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Usuario.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Usuario.setText("Usuario:");
        lbl_Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Usuario.setOpaque(true);
        panel_Fondo.add(lbl_Usuario);
        lbl_Usuario.setBounds(200, 220, 180, 30);

        btn_Ingresar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Ingresar.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        btn_Ingresar.setForeground(new java.awt.Color(102, 0, 102));
        btn_Ingresar.setText("Ingresar");
        btn_Ingresar.setName("Inicio sesión"); // NOI18N
        btn_Ingresar.setOpaque(false);
        btn_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresarActionPerformed(evt);
            }
        });
        panel_Fondo.add(btn_Ingresar);
        btn_Ingresar.setBounds(370, 390, 150, 40);

        txt_Contrasenna.setBackground(new java.awt.Color(102, 0, 102));
        panel_Fondo.add(txt_Contrasenna);
        txt_Contrasenna.setBounds(390, 330, 310, 30);

        lbl_Titulo2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Titulo2.setFont(new java.awt.Font("VCR OSD Mono", 0, 18)); // NOI18N
        lbl_Titulo2.setForeground(new java.awt.Color(102, 0, 102));
        lbl_Titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Titulo2.setText("Solo para administradores");
        lbl_Titulo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        lbl_Titulo2.setOpaque(true);
        panel_Fondo.add(lbl_Titulo2);
        lbl_Titulo2.setBounds(200, 270, 500, 30);



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

        getAccessibleContext().setAccessibleName("Inicio sesión");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresarActionPerformed
        // TODO add your handling code here:
        String usuario = txt_Usuario.getText().trim().toUpperCase();
        String contrasenna = String.valueOf(txt_Contrasenna.getPassword()).trim().toUpperCase();
        ArrayList<User> lista = listaUsuarios.getListaUsuarios();
        User nuevo = new User(usuario, 1, 5); //nombre, lvl, campos
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Hay usuarios");
            if(!usuario.isBlank()){
                if(usuario.equals(lista.get(i).getName())){
                    if( !contrasenna.isBlank()){
                            try{
                                AdminUser admin = (AdminUser) lista.get(i);                     
                                if(usuario.equals(admin.getName()) &&
                                        contrasenna.equals(admin.getPassword())){
                                    System.out.println("Admin: "+admin.getName()+"  "+"Contrasenna: "+admin.getPassword());
                                    this.setVisible(false);
                                    ingresarPersonajes frame = new ingresarPersonajes();
                                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    frame.pack();
                                    frame.setLocation(290, 150);
                                    frame.setVisible(true);
                                    return;
                                }
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(panel_Fondo,"El usuario no tiene derechos de admin","Precaución Usuario",JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                    }
                    
                    nuevo = lista.get(i);
                    System.out.println("User: "+nuevo.getName());
                    this.setVisible(false);
                    escogerPartida_Juego frame = new escogerPartida_Juego(nuevo);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setLocation(290, 150);
                    frame.setVisible(true);
                    return;
                }
            
            }else{
                JOptionPane.showMessageDialog(panel_Fondo,"Los campos están vacíos.","Precaución guerrero",JOptionPane.WARNING_MESSAGE);
            }
        }
        listaUsuarios.agregarUsuario(nuevo);
        FileManager.writeObject(listaUsuarios, path+"\\ArchivosSerializados\\usuarios.juego");
        System.out.println("Nuevo Usuario: "+nuevo.getName());
        this.setVisible(false);
        escogerPersonajes_Juego frame = new escogerPersonajes_Juego(nuevo);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(290, 150);
        frame.setVisible(true);        
    }//GEN-LAST:event_btn_IngresarActionPerformed

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
            java.util.logging.Logger.getLogger(inicioSesion_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicioSesion_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicioSesion_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicioSesion_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                inicioSesion_Juego frame = new inicioSesion_Juego();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(290, 150);
                frame.setVisible(true);
            }
    });
}              

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JLabel lbl_Contrasenna;
    private javax.swing.JLabel lbl_Titulo0;
    private javax.swing.JLabel lbl_Titulo1;
    private javax.swing.JLabel lbl_Titulo2;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JPanel panel_Fondo;
    private javax.swing.JPasswordField txt_Contrasenna;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables
}
