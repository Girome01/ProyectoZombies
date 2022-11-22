package proyectozombie.Logica;

import javax.swing.*;
import java.util.ArrayList;

public class Game {

    private ArrayList<WeaponThread> defense;
    private ArrayList<ZombieThread> enemies;

    public void generateEnemies(){}
    public void generateDefense(){}
    public void levelUp(){}
    public void startArmy(){}
    public void startEnemies(){}
    public void pauseArmy(){}
    public void stopArmy(){}

    public Boolean isAvailable(int a, int b){
        return null;
    }
    public GameThread getWinner(int a, int b){
        return null;
    }
    public Boolean inRangeDefense(GameThread gameThread,int a, int b){
        return null;
    }
    public GameThread getEnemy(GameThread gameThread){
        return null;
    }
    public void changeImage(String img, JLabel imgLabel){}

}
