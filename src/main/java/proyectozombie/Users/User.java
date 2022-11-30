package proyectozombie.Users;

import java.io.Serializable;
import java.util.ArrayList;
import proyectozombie.CharacterCreation.CharacterGame;

public class User implements Serializable{

    private String name;
    private ArrayList<CharacterGame> warriors;
    private int level;
    private int campos;

    public User(String name, int level, int campos) {
        this.name = name;
        this.level = level;
        this.campos = campos;
    }

    public void setCampos(int campo){
        this.campos = campo;
    }

    public int getCampos(){
        return this.campos;
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
    
    public void subirLevel(){
        this.level += 1;
        this.campos += 10;
    }

    public ArrayList<CharacterGame> getWarriors() {
        return warriors;
    }

    public void setWarriors(ArrayList<CharacterGame> warriors) {
        this.warriors = warriors;
    }
    
    public void agregarColeccion(ArrayList<CharacterGame> personajes){
        this.warriors=personajes;
    }
    
    public boolean sumatoriaCampos(){
        int sumatoria=0;
        for(int i=0;i<warriors.size();i++){
                sumatoria+=warriors.get(i).getcStorageSpace();
        }
        if(this.campos>=sumatoria){
            return true;     
        }
        return false;
    }
}
