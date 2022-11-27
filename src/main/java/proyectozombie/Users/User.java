package proyectozombie.Users;

import java.util.ArrayList;
import proyectozombie.CharacterCreation.CharacterGame;

public class User {

    private String name;
    private ArrayList<CharacterGame> warriors;
    private int level;

    public User(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
