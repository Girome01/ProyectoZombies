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
import proyectozombie.GameEnviroment.Weapons.Weapon;
import proyectozombie.GameEnviroment.Zombies.Zombie;
import proyectozombie.interfaz.campoBatalla_Juego;

/**
 *
 * @author Jennifer
 */
public class GameThread extends Thread implements Serializable{
    protected campoBatalla_Juego refPantalla;
    public JLabel refLabel;
    int numero;
    private boolean running = true;
    private boolean paused = false;
    public CharacterGame guerrero;
    GameThread enemigo ;

    public GameThread(campoBatalla_Juego refPantalla, JLabel refLabel, JLabel refArma, int numero, CharacterGame guerrero) {
        this.refPantalla = refPantalla;
        this.refLabel = refLabel;
        this.numero = numero;
        this.guerrero = guerrero;
    }

    public GameThread(campoBatalla_Juego refPantalla, JLabel refLabel, int numero, CharacterGame guerrero) {
        this.refPantalla = refPantalla;
        this.refLabel = refLabel;
        this.numero = numero;
        this.guerrero = guerrero;
    }


     public void run(){
        
        while(running){ 
            Weapon weapon = null;
            Zombie zombie = null;
            try {
                if (this.guerrero.getcLife() > 0){
                    String url;
                    //Verificar el tipo y ver si camina o no
                    boolean ataco = refPantalla.batalla.getEnemy(this);
                    switch (guerrero.getTipo()) {
                        case BLOCKS: case CONTACTWEAPON: case IMPACT: case MEDIUMRANGE: case MULTIATTACK: case RELIQUIA:
                            sleep(1000);
                            weapon = (Weapon) this.guerrero;
                            break;
                        case AERIALZOMBIE: case CONTACTZOMBIE: case HALFRANGEZOMBIE: case SMASHZOMBIE:
                            zombie = (Zombie)this.guerrero;
                            if(!ataco){
                                url = guerrero.getcAppearance3(guerrero.getcLevel(),"WALKING");
                                if(url != null){
                                    cambiarImagen(url, refLabel);
                                }
                                sleep(1000);
                                refPantalla.moveLabel(refLabel);
                                url = guerrero.getcAppearance3(guerrero.getcLevel(),"STOP");
                                if(url != null){
                                    cambiarImagen(url, refLabel);
                                }
                            }
                            break;
                        case AERIAL: 
                            weapon = (Weapon) this.guerrero;                            
                        default:
                            if(!ataco){
                                url = guerrero.getcAppearance3(guerrero.getcLevel(),"WALKING");
                                if(url != null){
                                    cambiarImagen(url, refLabel);
                                }
                                sleep(1000);
                                refPantalla.moveLabel(refLabel);
                                url = guerrero.getcAppearance3(guerrero.getcLevel(),"STOP");
                                if(url != null){
                                    cambiarImagen(url, refLabel);
                                }
                            }
                            break;
                    }
                    
                    
                    if(weapon != null){
                        String log = weapon.getLog().readLog();
                        if(!"".equals(log)){
                            refPantalla.escribirHilos(log);
                        }
                    }else{
                        System.out.println(guerrero.getTipo());
                        String log = zombie.getLog().readLog();
                        if(!"".equals(log)){
                            refPantalla.escribirHilos(log);
                        }
                    }
                    //refPantalla.escribirHilos("Soy "+this.guerrero.getcName()+" y lucho por mi bando con vida "+this.guerrero.getcLife()+" y ataque "+this.guerrero.getcHitPS());
                }else{
                    enemigo = refPantalla.batalla.getGanador(this);
                    
                    String imagen= guerrero.getcAppearance3(0, "LAPIDA");
                    if(imagen != null)
                        cambiarImagen(imagen, refLabel);
                    this.stopThread();
                    
                }
                sleep(2000);
            } catch (InterruptedException ex) { }

            boolean print = true;
            while(paused){
                if(print){
                    switch (guerrero.getTipo()) {
                        case AERIAL:case BLOCKS: case CONTACTWEAPON: case IMPACT: case MEDIUMRANGE: case MULTIATTACK: case RELIQUIA:
                            weapon = (Weapon) guerrero;
                            break;
                        default:
                            zombie = (Zombie) guerrero;
                    }
                    if(weapon != null){
                        String log = weapon.getLog().readLog();
                        if(!"".equals(log)){
                            refPantalla.escribirHilos(log);
                        }
                    }else{
                        System.out.println(guerrero.getTipo());
                        String log = zombie.getLog().readLog();
                        if(!"".equals(log)){
                            refPantalla.escribirHilos(log);
                        }
                    }
                    print=false;
                }
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
    }
}
