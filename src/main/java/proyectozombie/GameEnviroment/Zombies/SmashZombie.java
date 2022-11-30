package proyectozombie.GameEnviroment.Zombies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.CharacterCreation.iPrototype;
import proyectozombie.GameEnviroment.TypeCharacters;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

public class SmashZombie extends Zombie implements Serializable{

    public SmashZombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        this.setTipo(TypeCharacters.SMASHZOMBIE);
    }

    @Override
    public void attackAllInRange(ArrayList<GameThread> characters, GameThread zombie) {
        ArrayList<CharacterGame> onRange = new ArrayList<>();
        for (GameThread character : characters) {
            if (inRange(character, zombie)) {
                onRange.add(character.guerrero);
                this.setLog(zombie.guerrero.getcName() + " ataco a " + character.guerrero.getcName() + " en X:" +
                        zombie.refLabel.getLocation().x + " Y:" + zombie.refLabel.getLocation().y);
            }

        }
        if (onRange.size() != 0) {
            zombie.guerrero.cAttack(onRange);
            zombie.guerrero.cDamage(zombie.guerrero.getcLife());
        }
    }
    
    @Override
    public iPrototype clone(){
        SmashZombie character = new SmashZombie(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        character.setcGear(cGear);
        return character;
    }
    
}
