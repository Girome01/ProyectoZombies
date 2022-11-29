package proyectozombie.GameEnviroment.Weapons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

public class Impact extends Weapon implements Serializable{

    public Impact(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
    }

    @Override
    public void attackAllInRange(ArrayList<ZombieThread> zombies, GameThread character) {
        ArrayList<CharacterGame> onRange = new ArrayList<CharacterGame>();
        for (ZombieThread zombie : zombies) {
            if (inRange(zombie, character)) {
                onRange.add(zombie.zombie);
            }
        }
        if (onRange.size() != 0) {
            character.guerrero.cAttack(onRange);
            //Si es un guerrero de impacto, es decir una bomba, se autodestruye
            character.guerrero.cDamage(character.guerrero.getcLife());
        }
    }

    
}
