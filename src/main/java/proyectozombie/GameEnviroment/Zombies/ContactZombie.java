package proyectozombie.GameEnviroment.Zombies;

import java.io.Serializable;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;

public class ContactZombie extends Zombie implements Serializable{

    public ContactZombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
    }
    
}
