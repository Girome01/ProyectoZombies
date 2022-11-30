package proyectozombie.GameEnviroment.Zombies;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.GameEnviroment.Log;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

import static java.lang.Math.abs;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyectozombie.GameEnviroment.TypeCharacters;
import proyectozombie.GameEnviroment.Weapons.Weapon;


public class Zombie extends CharacterGame implements Serializable{
    private Log log;

    //TODO: inRangeDefense()

    public Zombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        this.log = new Log("No inicio");
    }
    
    public void initLog(){
        String firstLog = "Nombre = " + this.cName + "\tTipo = " + this.getTipo() 
                + "\nDaño y DPS = " + this.cHitPS + "\tRango = " + this.cShowGearList().get(0).getgRange() 
                + "\nVida inicial = " + this.cLife + "\tVida final = " ;
        this.log = new Log(firstLog);
    }

    public Log getLog() {
        return log;
    }

    public void setLog(String text){
        log.writeLog(text);
    }

    public boolean attackAllInRange(ArrayList<GameThread> characters, GameThread zombie, int num, int cercano, JLabel reflabel) {
        ArrayList<CharacterGame> onRange = new ArrayList<>();
        ArrayList<JLabel> charactetLabel = new ArrayList();
        for (GameThread character : characters) {
            if (inRange(character, zombie, num, cercano)) {
                onRange.add(character.guerrero);
                charactetLabel.add(character.refLabel);
                break;
            }
        }
        //override realizado en SmashZombie para autodestruccion y multiattack
        if (onRange.size() != 0) {
            String url = this.getcAppearance(this.getcLevel(),"ATTACK");
            if (url != null) {
                cambiarImagen(url, reflabel);
            }
            zombie.guerrero.cAttack(onRange);
            String atacante = zombie.guerrero.getcName() +" "+ zombie.guerrero.getTipo() +" en posicion x: " +
                    zombie.refLabel.getLocation().x + " Y:" + zombie.refLabel.getLocation().y + " ataco a ";
            Weapon weapon = (Weapon)onRange.get(0);
            String atacado = weapon.getcName() + " " + weapon.getTipo() + " con vida " + weapon.getcLife() + 
                    " en posicion x: " + charactetLabel.get(0).getLocation().x + " y: " + charactetLabel.get(0).getLocation().y;
            this.setLog(atacante + atacado);
            return true;
        }
        return false;
    }

    public Boolean inRange(GameThread character, GameThread zombie, int num, int cercano) {

        int range = this.cShowGearList().get(0).getgRange();

        //override realizado en AerialZombie para ataque
        if(character.guerrero.getTipo() == TypeCharacters.AERIAL) return false;
        return cercano/num <= range;
    }
    
    protected void cambiarImagen(String url, JLabel refLabel){
        ImageIcon imageicon = new ImageIcon(url);
        int ancho=imageicon.getIconWidth();
        int alto=imageicon.getIconHeight();
        Image img = imageicon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        refLabel.setIcon(new ImageIcon(img));
        refLabel.setSize(ancho, alto);
        refLabel.setOpaque(false);
    }
}
