package proyectozombie.GameEnviroment;

import java.io.Serializable;
import proyectozombie.GameEnviroment.Weapons.Weapon;
import proyectozombie.GameEnviroment.Zombies.Zombie;

import java.util.ArrayList;
import proyectozombie.CharacterCreation.PFCharacter;

public class Presets implements Serializable{
    
    private ArrayList<Weapon> weapon = new ArrayList();
    private ArrayList<Zombie> zombie = new ArrayList();

    public void addWeapon(Weapon weapon){
        this.weapon.add(weapon);
    }
    public void deleteWeapon(Weapon weapon){
        this.weapon.remove(weapon);
    }
    public ArrayList<Weapon> getWeapon(){
        return weapon;
    }
    public Weapon searchWeapon(String name, ArrayList<Weapon> weapons){
        for (Weapon weapon1 : weapons) {
            if(weapon1.getcName().equals(name)){
                return weapon1;
            }
        }
        return null;
    }
    public void addZombie(Zombie zombie){
        this.zombie.add(zombie);
    }
    public void deleteZombie(Zombie zombie){
        this.zombie.remove(zombie);
    }
    public ArrayList<Zombie> getZombie(){
        return this.zombie;
    }
    public Zombie searchZombie(String name, ArrayList<Zombie> zombies){
        for (Zombie zomby : zombies) {
            if(zomby.getcName().equals(name)){
                return zomby;
            }
        }
        return null;
    }
    
    public void agregarPFCharacter(PFCharacter pfCharacter){
        for (Weapon weapon1 : weapon) {
            pfCharacter.addPrototype(weapon1.getcName(), weapon1);
        }
        
        for (Zombie zomby : zombie) {
            pfCharacter.addPrototype(zomby.getcName(), zomby);
        }
    }
}
