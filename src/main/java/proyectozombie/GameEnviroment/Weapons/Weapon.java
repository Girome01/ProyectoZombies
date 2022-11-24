package proyectozombie.GameEnviroment.Weapons;

import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.GameEnviroment.Log;

import java.util.HashMap;

public class Weapon extends CharacterGame{
    private Log log;
    //TODO: inRangeDefense()

    public Weapon(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife,
                  int cStorageSpace, double cCost, int cLevel) {
        super(cName,cAppearance,cSpawnLevel,cHitPS,cLife,cStorageSpace,cCost,cLevel);
        this.log = new Log();
    }
}
