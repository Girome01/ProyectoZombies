package proyectozombie.GameEnviroment.Zombies;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.GameEnviroment.Log;
import proyectozombie.Logica.GameThread;
import proyectozombie.Logica.ZombieThread;

import static java.lang.Math.abs;


public class Zombie extends CharacterGame implements Serializable{
    private Log log;

    //TODO: inRangeDefense()

    public Zombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        this.log = new Log();
    }

    public Log getLog() {
        return log;
    }

    public void attackAllInRange(ArrayList<GameThread> characters, ZombieThread zombie) {
        ArrayList<CharacterGame> onRange = new ArrayList<>();
        for (GameThread character : characters) {
            if (inRange(character, zombie)) {
                onRange.add(character.guerrero);
            }

        }
        //override realizado en SmashZombie para autodestruccion
        if (onRange.size() != 0) {
            zombie.zombie.cAttack(onRange);
        }
    }

    public Boolean inRange(GameThread character, ZombieThread zombie) {

        int range = this.cShowGearList().get(0).getgRange();

        int xZombie = zombie.refLabel.getLocation().x;
        int yZombie = zombie.refLabel.getLocation().y;

        int xCharacter = character.refLabel.getLocation().x;
        int yCharacter = character.refLabel.getLocation().y;

        //override realizado en AerialZombie para ataque
        if(character.guerrero.getcName().equals("Guerrero Aereo")) return false;
        return ((abs(xZombie - xCharacter) <= range) && (abs(yZombie - yCharacter) <= range));
    }
}
