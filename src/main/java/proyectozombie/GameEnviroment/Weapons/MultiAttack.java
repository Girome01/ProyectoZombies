package proyectozombie.GameEnviroment.Weapons;

import java.io.Serializable;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.iPrototype;

public class MultiAttack extends Weapon implements Serializable{

    public MultiAttack(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
    }

    @Override
    public iPrototype clone(){
        MultiAttack character = new MultiAttack(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
        character.setcGear(cGear);
        return character;
    }
    
}
