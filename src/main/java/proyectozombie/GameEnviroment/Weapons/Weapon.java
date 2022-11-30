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

    public void attackAllInRange(ArrayList<ZombieThread> zombies, GameThread character) {
        ArrayList<CharacterGame> onRange = new ArrayList<CharacterGame>();
        for (ZombieThread zombie : zombies) {
            if (inRange(zombie, character)) {
                onRange.add(zombie.zombie);
                break;
            }
        }
        //override realizado en Impact para autodestruccion y multiattack para varios enemigos
        if (onRange.size() != 0) {
            character.guerrero.cAttack(onRange);
            this.setLog(character.guerrero.getcName() + " ataco a " + onRange.get(0).getcName() + " en X:" +
                    character.refLabel.getLocation().x + " Y:" + character.refLabel.getLocation().y);
        }
    }

    public Boolean inRange(ZombieThread zombie, GameThread character) {

        int range = this.cShowGearList().get(0).getgRange();

        int xZombie = zombie.refLabel.getLocation().x;
        int yZombie = zombie.refLabel.getLocation().y;

        int xCharacter = character.refLabel.getLocation().x;
        int yCharacter = character.refLabel.getLocation().y;

        //override realizado en Aerial para ataque
        if(zombie.zombie.getcName().equals("Zombie Aereo")) return false;
        return ((abs(xZombie - xCharacter) <= range) && (abs(yZombie - yCharacter) <= range));
    }
}
