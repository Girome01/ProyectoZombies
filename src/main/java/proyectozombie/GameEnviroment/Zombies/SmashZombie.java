package proyectozombie.GameEnviroment.Zombies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

public class SmashZombie extends Zombie implements Serializable{

    public SmashZombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
    }

    @Override
    public void attackAllInRange(ArrayList<GameThread> characters, ZombieThread zombie) {
        ArrayList<CharacterGame> onRange = new ArrayList<>();
        for (GameThread character : characters) {
            if (inRange(character, zombie)) {
                onRange.add(character.guerrero);
            }

        }
        if (onRange.size() != 0) {
            zombie.zombie.cAttack(onRange);
            zombie.zombie.cDamage(zombie.zombie.getcLife());
        }
    }
    
}
