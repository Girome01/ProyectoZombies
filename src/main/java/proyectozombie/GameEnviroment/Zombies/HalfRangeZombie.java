package proyectozombie.GameEnviroment.Zombies;

import java.io.Serializable;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.iPrototype;

public class HalfRangeZombie extends Zombie implements Serializable{

    public HalfRangeZombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
    }
    
    @Override
    public iPrototype clone(){
        HalfRangeZombie character = new HalfRangeZombie(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        character.setcGear(cGear);
        return character;
    }
    
}
