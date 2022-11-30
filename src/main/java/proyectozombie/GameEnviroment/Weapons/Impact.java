package proyectozombie.GameEnviroment.Weapons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import proyectozombie.CharacterCreation.Appearance;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.CharacterCreation.iPrototype;
import proyectozombie.GameEnviroment.TypeCharacters;
import proyectozombie.Logica.GameThread;

public class Impact extends Weapon implements Serializable{

    public Impact(String cName, HashMap<Integer, Appearance> cAppearance, int cSpawnLevel, int cHitPS, int cLife, int cStorageSpace, double cCost, int cLevel, int camina) {
        super(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
        this.setTipo(TypeCharacters.IMPACT);
    }

    @Override
    public void attackAllInRange(ArrayList<GameThread> zombies, GameThread character, int num, int cercano) {
        ArrayList<CharacterGame> onRange = new ArrayList<CharacterGame>();
        for (GameThread zombie : zombies) {
            if (inRange(zombie, character, num, cercano)) {
                onRange.add(zombie.guerrero);
                String atacante = character.guerrero.getcName() +" "+ character.guerrero.getTipo() + " con daño "+
                    character.guerrero.cShowGearList().get(0).getgDamage() + " en posicion x: " +
                    character.refLabel.getLocation().x + " Y:" + character.refLabel.getLocation().y + " ataco a ";
                String atacado = zombie.guerrero.getcName() + " " + zombie.guerrero.getTipo() + " con vida " + 
                        zombie.guerrero.getcLife() + " en posicion x: " + zombie.refLabel.getLocation().x + 
                        " y: " + zombie.refLabel.getLocation().y;
                this.setLog(atacante + atacado);
            }
        }
        if (onRange.size() != 0) {
            character.guerrero.cAttack(onRange);
            //Si es un guerrero de impacto, es decir una bomba, se autodestruye
            character.guerrero.cDamage(character.guerrero.getcLife());
        }
    }

    @Override
    public iPrototype clone(){
        Impact character = new Impact(cName, cAppearance, cSpawnLevel, cHitPS, cLife, cStorageSpace, cCost, cLevel, camina);
        character.setcGear(cGear);
        return character;
    }
}
