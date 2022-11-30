package proyectozombie.GameEnviroment.Weapons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.GameEnviroment.Log;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

import static java.lang.Math.abs;
import javax.swing.JLabel;
import proyectozombie.GameEnviroment.TypeCharacters;
import proyectozombie.GameEnviroment.Zombies.Zombie;

public abstract class Weapon extends CharacterGame implements Serializable{
    private Log log;
    public int camina; // Si camina o no

    public Weapon(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        this.camina = camina;
        this.log = new Log();
    }

    public Log getLog() {
        return log;
    }

    public void setLog(String text){
        log.writeLog(text);
    }

    public int getCamina() {
        return camina;
    }

    public void attackAllInRange(ArrayList<GameThread> zombies, GameThread character, int num, int cercano) {
        ArrayList<CharacterGame> onRange = new ArrayList<CharacterGame>();
        ArrayList<JLabel> zombiesLabel = new ArrayList();
        for (GameThread zombie : zombies) {
            if (inRange(zombie, character, num, cercano)) {
                onRange.add(zombie.guerrero);
                zombiesLabel.add(zombie.refLabel);
                break;
            }
        }
        //override realizado en Impact para autodestruccion y multiattack para varios enemigos
        if (onRange.size() != 0) {
            character.guerrero.cAttack(onRange);
            String atacante = character.guerrero.getcName() +" "+ character.guerrero.getTipo() + " con daño "+
                    character.guerrero.cShowGearList().get(0).getgDamage() + " en posicion x: " +
                    character.refLabel.getLocation().x + " Y:" + character.refLabel.getLocation().y + " ataco a ";
            Zombie zombie = (Zombie)onRange.get(0);
            String atacado = zombie.getcName() + " " + zombie.getTipo() + " con vida " + zombie.getcLife() + 
                    " en posicion x: " + zombiesLabel.get(0).getLocation().x + " y: " + zombiesLabel.get(0).getLocation().y;
            this.setLog(atacante + atacado);
        }
    }

    public Boolean inRange(GameThread zombie, GameThread character, int num, int cercano) {

        int range = this.cShowGearList().get(0).getgRange();
        System.out.println("Range: "+range);

        //override realizado en Aerial para ataque
        if(zombie.guerrero.getTipo() == TypeCharacters.AERIAL) return false;
        //return ((abs(xZombie - xCharacter) <= range) && (abs(yZombie - yCharacter) <= range));
        return cercano/num <= range;
    }
}
