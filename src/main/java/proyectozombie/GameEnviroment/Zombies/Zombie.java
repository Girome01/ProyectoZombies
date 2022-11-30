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

    public void setLog(String text){
        log.writeLog(text);
    }

    public void attackAllInRange(ArrayList<GameThread> characters, GameThread zombie) {
        ArrayList<CharacterGame> onRange = new ArrayList<>();
        for (GameThread character : characters) {
            if (inRange(character, zombie)) {
                onRange.add(character.guerrero);
                break;
            }
        }
        //override realizado en SmashZombie para autodestruccion y multiattack
        if (onRange.size() != 0) {
            zombie.guerrero.cAttack(onRange);
            this.setLog(zombie.guerrero.getcName() + " ataco a " + onRange.get(0).getcName() + " en X:" +
                    zombie.refLabel.getLocation().x + " Y:" + zombie.refLabel.getLocation().y);
        }
    }

    public Boolean inRange(GameThread character, GameThread zombie) {

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
