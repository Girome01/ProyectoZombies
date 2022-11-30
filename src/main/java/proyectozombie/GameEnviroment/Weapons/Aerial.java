package proyectozombie.GameEnviroment.Weapons;

import java.io.Serializable;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

import static java.lang.Math.abs;
import proyectozombie.CharacterCreation.iPrototype;

public class Aerial extends Weapon implements Serializable{

    public Aerial(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
    }

    @Override
    public Boolean inRange(ZombieThread zombie, GameThread character) {

        int range = this.cShowGearList().get(0).getgRange();

        int xZombie = zombie.refLabel.getLocation().x;
        int yZombie = zombie.refLabel.getLocation().y;

        int xCharacter = character.refLabel.getLocation().x;
        int yCharacter = character.refLabel.getLocation().y;

        return ((abs(xZombie - xCharacter) <= range) && (abs(yZombie - yCharacter) <= range));
    }
    
    @Override
    public iPrototype clone(){
        Aerial character = new Aerial(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
        character.setcGear(cGear);
        return character;
    }

}
