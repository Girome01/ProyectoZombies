package proyectozombie.Logica;

import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;

import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.interfaz.campoBatalla_Juego;

public class Game {
    private campoBatalla_Juego refPantalla;
    private ArrayList<GameThread> defense;
    private ArrayList<ZombieThread> enemies;
    protected ArrayList<CharacterGame> listDefense;
    protected ArrayList<CharacterGame> listEnemies;

    public Game(campoBatalla_Juego refPantalla, ArrayList<CharacterGame> personajes) {
        this.refPantalla = refPantalla;
        this.listDefense = personajes;
        this.defense = new ArrayList();
        this.enemies = new ArrayList();
    }


    public void generateEnemies() {
    }

    public void generateDefense() {
        for (int i = 0; i < listDefense.size(); i++) {
            String nombreArchivo = listDefense.get(i).getcAppearance(listDefense.get(i).getcLevel(), "STOP");
            int[] position = listDefense.get(i).getPosition();
            JLabel labelForThread = refPantalla.generateLabel(nombreArchivo, position[0], position[1]);
            this.defense.add(new GameThread(refPantalla, labelForThread, (i + 1), listDefense.get(i)));
        }
    }

    public void levelUp() {
    }

    public void startArmy() {
        for (int i = 0; i < this.defense.size(); i++) {
            this.defense.get(i).start();
        }
    }

    public void startEnemies() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).start();
        }
    }

    public void pauseGame() {
        for (int i = 0; i < this.defense.size(); i++) {
            this.defense.get(i).setPaused();
        }
        for (int i = 0; i < this.enemies.size(); i++) {
            this.enemies.get(i).setPaused();
        }
    }

    public void stopGame() {
        for (int i = 0; i < this.defense.size(); i++) {
            this.defense.get(i).stopThread();
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).stopThread();
        }
    }

    public Boolean isAvailable(int x, int y) {
        for (int i = 0; i < this.defense.size(); i++) {
            if (x == this.defense.get(i).refLabel.getLocation().x && y == this.defense.get(i).refLabel.getLocation().y)
                return false;
        }
        for (int i = 0; i < enemies.size(); i++) {
            if (x == enemies.get(i).refLabel.getLocation().x && y == enemies.get(i).refLabel.getLocation().y)
                return false;
        }
        return true;
    }

    public GameThread getWinner(GameThread guerrero) {
        String ganador = "";
        boolean esArmy = this.defense.contains(guerrero);
        if (esArmy) {
            for (GameThread gameThread : this.defense) {
                if (gameThread.guerrero.getcLife() > 0)
                    return null;
            }
            ganador = "Enemigos";
            stopGame();

        } else {
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).zombie.getcLife() > 0)
                    return null;
            }
            ganador = "Aliados";
            stopGame();
        }
        refPantalla.mostrarGanador(ganador);
        return null;
    }

    //not sure TODO: review
    public GameThread getEnemy(Thread gameThread) {
        return null;
    }

    public void changeImage(String url, JLabel refLabel) {
        ImageIcon imageicon = new ImageIcon(url);
        int ancho = imageicon.getIconWidth();
        int alto = imageicon.getIconHeight();
        Image img = imageicon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        refLabel.setIcon(new ImageIcon(img));
        refLabel.setSize(ancho, alto);
        refLabel.setOpaque(false);
    }
    
    public GameThread getGanador(Thread guerrero) {
        String ganador = "";
        boolean esArmy = this.defense.contains(guerrero);
        if (esArmy) {
            for (int i = 0; i < this.defense.size(); i++) {
                if (this.defense.get(i).guerrero.getcLife() > 0 && !(this.defense.get(i).guerrero.getcName().equalsIgnoreCase("Defensa")))
                    return null;
            }
            ganador = "Enemigos";
            stopArmy();

        } else {
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).zombie.getcLife() > 0 && !(enemies.get(i).zombie.getcName().equalsIgnoreCase("Defensa")))
                    return null;
            }
            ganador = "Aliados";
            stopArmy();
        }
        refPantalla.mostrarGanador(ganador);
        return null;
    }

    public void stopArmy() {
        for (int i = 0; i < defense.size(); i++) {
            defense.get(i).stopThread();
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).stopThread();
        }
    }
}
