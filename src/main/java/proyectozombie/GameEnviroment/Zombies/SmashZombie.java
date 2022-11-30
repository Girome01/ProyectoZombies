package proyectozombie.GameEnviroment.Zombies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.CharacterCreation.iPrototype;
import proyectozombie.GameEnviroment.TypeCharacters;
import proyectozombie.Logica.GameThread;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyectozombie.GameEnviroment.TypeCharacters;

public class SmashZombie extends Zombie implements Serializable{

    public SmashZombie(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        this.setTipo(TypeCharacters.SMASHZOMBIE);
    }

    @Override
    public boolean attackAllInRange(ArrayList<GameThread> characters, GameThread zombie, int num, int cercano, JLabel refLabel) {
        ArrayList<CharacterGame> onRange = new ArrayList<>();
        for (GameThread character : characters) {
            if (inRange(character, zombie, num, cercano)) {
                onRange.add(character.guerrero);
                
                String atacante = zombie.guerrero.getcName() +" "+ zombie.guerrero.getTipo() + " con daño "+
                    zombie.guerrero.cShowGearList().get(0).getgDamage() + " en posicion x: " +
                    zombie.refLabel.getLocation().x + " Y:" + zombie.refLabel.getLocation().y + " ataco a ";
                String atacado = character.guerrero.getcName() + " " + character.guerrero.getTipo() + " con vida " + 
                        character.guerrero.getcLife() + " en posicion x: " + character.refLabel.getLocation().x + 
                        " y: " + character.refLabel.getLocation().y;
                this.setLog(atacante + atacado);
            }

        }
        if (onRange.size() != 0) {
            String url = this.getcAppearance(this.getcLevel(),"ATTACK");
            if (url != null) {
                cambiarImagen(url, refLabel);
            }
            zombie.guerrero.cAttack(onRange);
            zombie.guerrero.cDamage(zombie.guerrero.getcLife());
            return true;
        }
        return false;
    }
    
    @Override
    public iPrototype clone(){
        SmashZombie character = new SmashZombie(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel);
        character.setcGear(cGear);
        return character;
    }
    
}
