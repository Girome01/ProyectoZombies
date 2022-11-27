package proyectozombie.GameEnviroment.Zombies;

import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

import static java.lang.Math.abs;

public class AerialZombie extends Zombie{

    public AerialZombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
    }

    @Override
    public Boolean inRange(GameThread character, ZombieThread zombie) {

        int range = this.cShowGearList().get(0).getgRange();

        int xZombie = zombie.refLabel.getLocation().x;
        int yZombie = zombie.refLabel.getLocation().y;

        int xCharacter = character.refLabel.getLocation().x;
        int yCharacter = character.refLabel.getLocation().y;

        return ((abs(xZombie - xCharacter) <= range) && (abs(yZombie - yCharacter) <= range));
    }
    
}
