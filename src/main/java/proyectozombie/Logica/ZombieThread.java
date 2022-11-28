package proyectozombie.Logica;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.GameEnviroment.Zombies.Zombie;
import proyectozombie.interfaz.campoBatalla_Juego;

/**
 *
 * @author Jennifer
 */
public class ZombieThread extends Thread implements Serializable{
    private campoBatalla_Juego refPantalla;
    public JLabel refLabel;
    public JLabel refArma;
    int numero;
    private boolean running = true;
    private boolean paused = false;
    public Zombie zombie;
    GameThread enemigo ;
/*
    public ZombieThread(campoBatalla_Juego refPantalla, JLabel refLabel, int numero, CharacterGame guerrero) {
        this.refPantalla = refPantalla;
        this.refLabel = refLabel;
        this.refArma = refArma;
        this.numero = numero;
        this.guerrero = guerrero;
    }

     public void run(){
        
        while(running){            
            try {
                if (this.guerrero.getcLife() > 0){
                    // Si se agrega el tipo de guerre en la clase cambiar los if
                    //if(this.guerrero.tipoGuerrero.equalsIgnoreCase("Guerrero aéreo"){
                    if(this.guerrero.getcName().equalsIgnoreCase("Guerrero aéreo")){
                      
                    }else{
                        
                        String url = guerrero.getcAppearance(guerrero.getcLevel(),"WALKING");
                        if(url != null){
                            cambiarImagen(url, refLabel);
                        }
                        sleep(1000);
                        refPantalla.moveLabel(refLabel, refArma);
                        url = guerrero.getcAppearance(guerrero.getcLevel(),"STOP");
                        if(url != null){
                            cambiarImagen(url, refLabel);
                        }
                    }
                    enemigo = refPantalla.batalla.getEnemy(this);
                    refPantalla.escribirHilos("Soy "+this.guerrero.getcName()+" y lucho por mi bando con vida "+this.guerrero.getcLife()+" y ataque "+this.guerrero.getcHitPS());
                }else{
                    enemigo = refPantalla.batalla.getGanador(this);
                    
                    String imagen= guerrero.getcAppearance(0, "LAPIDA");
                    if(imagen != null)
                        cambiarImagen(imagen, refLabel);
                    
                }
                sleep(2000);
            } catch (InterruptedException ex) { } catch (IOException ex) {
                Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            while(paused){
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    
                }
            }
        }
     }
     public void stopThread(){
        this.running = false;
    }
    
    public void setPaused(){
        paused = !paused;
    }
    
    private void cambiarImagen(String url, JLabel refLabel){
        ImageIcon imageicon = new ImageIcon(url);
        int ancho=imageicon.getIconWidth();
        int alto=imageicon.getIconHeight();
        Image img = imageicon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        refLabel.setIcon(new ImageIcon(img));
        refLabel.setSize(ancho, alto);
        refLabel.setOpaque(false);
    }*/
}
