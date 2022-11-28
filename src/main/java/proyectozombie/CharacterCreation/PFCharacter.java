package proyectozombie.CharacterCreation;
import java.util.ArrayList;
import java.util.HashMap;

public class PFCharacter {
    private static HashMap<String,CharacterGame> pfCharacters = new HashMap<>();

   
    public static void addPrototype(String name, CharacterGame prototype) {
        pfCharacters.put(name.toUpperCase().strip(), prototype);
    }
    
    public static ArrayList<CharacterGame> getPrototype(String key, int quantity) {
        ArrayList<CharacterGame> newCharacters = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            newCharacters.add((CharacterGame) pfCharacters.get(key.toUpperCase().strip()).clone());
        }
        return newCharacters;
    }
    
    public static ArrayList<CharacterGame> CharacterList(){
        ArrayList<CharacterGame> characterList = new ArrayList<>();
        pfCharacters.entrySet().forEach(entry -> {
            characterList.add(entry.getValue());
        });
        return characterList;
        //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
    }
    
    public static void setLevels(int lvl){

        for (CharacterGame character : pfCharacters.values()) {
            character.setcLevel(lvl);
        }    
    }
    
    
}
