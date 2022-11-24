package proyectozombie.GameEnviroment.Weapons;

import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.GameEnviroment.Log;

public class Weapon extends CharacterGame{
    private Log log;
    
    private int camina; // Si camina o no

    public Weapon(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        this.camina = camina;
        this.log = new Log();
    }

    public Log getLog() {
        return log;
    }

    public int getCamina() {
        return camina;
    }
    
    
}
