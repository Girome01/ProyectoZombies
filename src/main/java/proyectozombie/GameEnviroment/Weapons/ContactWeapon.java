package proyectozombie.GameEnviroment.Weapons;

import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;

public class ContactWeapon extends Weapon{

    public ContactWeapon(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
    }

    
}
