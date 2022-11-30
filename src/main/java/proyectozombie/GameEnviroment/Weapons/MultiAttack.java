package proyectozombie.GameEnviroment.Weapons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.CharacterCreation.iPrototype;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

public class MultiAttack extends Weapon implements Serializable{

    public MultiAttack(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
    }

    @Override
    public void attackAllInRange(ArrayList<ZombieThread> zombies, GameThread character) {
        ArrayList<CharacterGame> onRange = new ArrayList<CharacterGame>();
        for (ZombieThread zombie : zombies) {
            if (inRange(zombie, character)) {
                onRange.add(zombie.zombie);
                this.setLog(character.guerrero.getcName() + " ataco a " + zombie.zombie.getcName() + " en X:" +
                        character.refLabel.getLocation().x + " Y:" + character.refLabel.getLocation().y);
            }
        }
        //override realizado en Impact para autodestruccion
        if (onRange.size() != 0) {
            character.guerrero.cAttack(onRange);
        }
    }
    @Override
    public iPrototype clone(){
        MultiAttack character = new MultiAttack(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
        character.setcGear(cGear);
        return character;
    }
    
}
