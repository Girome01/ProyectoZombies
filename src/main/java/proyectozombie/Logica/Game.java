package proyectozombie.Logica;

import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;
import proyectozombie.CharacterCreation.CharacterGame;
import proyectozombie.CharacterCreation.PFCharacter;
import proyectozombie.GameEnviroment.TypeCharacters;
import proyectozombie.GameEnviroment.Weapons.Weapon;
import proyectozombie.GameEnviroment.Zombies.*;
import proyectozombie.Users.User;
import proyectozombie.interfaz.campoBatalla_Juego;

public class Game {
    private campoBatalla_Juego refPantalla;
    private ArrayList<GameThread> defense;
    private ArrayList<GameThread> enemies;
    protected ArrayList<CharacterGame> listDefense;
    protected ArrayList<CharacterGame> listEnemies;

    public Game(campoBatalla_Juego refPantalla, ArrayList<CharacterGame> personajes) {
        this.refPantalla = refPantalla;
        this.listDefense = personajes;
        this.defense = new ArrayList();
        this.enemies = new ArrayList();
        this.listEnemies = new ArrayList();
        this.listDefense = new ArrayList();
    }

    public void generateEnemies(ArrayList<Zombie> zombies, User usuario) {
        int cantidad = usuario.getCampos()-3; //5-3=2
        ArrayList<Zombie> enemies = new ArrayList<>();

        for (int i = 0; i < zombies.size(); i++) {
            if (zombies.get(i).getcLevel() <= usuario.getLevel()) {
                enemies.add(zombies.get(i));
            }
        }
        
        int i = 0;
        while (cantidad > 0) {
            if (i >= enemies.size()) i = 0;
            Zombie pfZom = (Zombie)PFCharacter.getPrototype(enemies.get(i).getcName(), 1).get(0);
            pfZom.initLog();
            listEnemies.add( (CharacterGame) pfZom);
            int y = (int)(Math.random()*5+1);
            String nombreArchivo = listEnemies.get(i).getcAppearance(listEnemies.get(i).getcLevel(), "STOP");
            JLabel labelForThread = refPantalla.generateLabel(nombreArchivo, 1, y);
            this.enemies.add(new GameThread(refPantalla, labelForThread, (i+1), listEnemies.get(i)));
            cantidad--;
            i++;
        }
    }

    public void generateDefense(ArrayList<CharacterGame> listaEsco) {
        this.listDefense = listaEsco;
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
                if (enemies.get(i).guerrero.getcLife() > 0)
                    return null;
            }
            ganador = "Aliados";
            stopGame();
        }
        refPantalla.mostrarGanador(ganador);
        return null;
    }

    //not sure TODO: review
    public boolean getEnemy(GameThread gameThread) throws InterruptedException {
        int cercano = 800;
        int xGuerrero = gameThread.refLabel.getLocation().x;
        int yGuerrero = gameThread.refLabel.getLocation().y;
        int distanciax;
        int distanciay;
        int xEnemigo=0;
        int yEnemigo=0;
        int menor;
        int num = 0;
        String coordenada = "";
        boolean esArmy = defense.contains(gameThread);
         
        if (esArmy){
            for (int i = 0; i < enemies.size(); i++) {
                if (xGuerrero > enemies.get(i).refLabel.getLocation().x) {
                    distanciax = xGuerrero - enemies.get(i).refLabel.getLocation().x;}
                else {
                    distanciax = enemies.get(i).refLabel.getLocation().x - xGuerrero;
                }
                if (yGuerrero > enemies.get(i).refLabel.getLocation().y) {
                    distanciay = yGuerrero - enemies.get(i).refLabel.getLocation().y;
                }
                else {
                    distanciay = enemies.get(i).refLabel.getLocation().y - yGuerrero;
                }
                menor =  (int) Math.sqrt(Math.pow(distanciax, 2) + Math.pow(distanciay, 2));
                if (menor < cercano){
                    cercano = menor;
                    xEnemigo=enemies.get(i).refLabel.getLocation().x;
                    yEnemigo=enemies.get(i).refLabel.getLocation().y;
                }
                if (distanciax == 0)
                    num = 30;
                else if(distanciay ==0){
                    num = 23;
                }
                else{
                    num = (int) Math.sqrt(Math.pow(23, 2) + Math.pow(30, 2));
                }
            }
            ArrayList<GameThread> enemy = new ArrayList<>();
            for (int i = 0; i < enemies.size(); i++){
                if (enemies.get(i).refLabel.getLocation().x == xEnemigo && enemies.get(i).refLabel.getLocation().y == yEnemigo ){
                    if (enemies.get(i).guerrero.getcLife() > 0){
                        System.out.println("Comprobar vida");
                        System.out.println(enemies.get(i).guerrero.getcLife()+" "+enemies.get(i).guerrero.getcName());
                        enemy.add(enemies.get(i));
                    }
                }
            }
            Weapon weapon = (Weapon) gameThread.guerrero;
            Boolean ataco = weapon.attackAllInRange(enemy, gameThread, num, cercano, gameThread.refLabel);
            gameThread.sleep(1000);
            String url = gameThread.guerrero.getcAppearance3(gameThread.guerrero.getcLevel(),"STOP");
            if (url != null) {
                cambiarImagen(url, gameThread.refLabel);
            }
            return ataco;
        }
        
        else {
            for (int i = 0; i < defense.size(); i++) {
                if (xGuerrero > defense.get(i).refLabel.getLocation().x) {
                    distanciax = xGuerrero - defense.get(i).refLabel.getLocation().x;
                }
                else {
                    distanciax = defense.get(i).refLabel.getLocation().x - xGuerrero;
                }
                if (yGuerrero > defense.get(i).refLabel.getLocation().y) {
                    distanciay = yGuerrero - defense.get(i).refLabel.getLocation().y;
                }
                else{
                    distanciay = defense.get(i).refLabel.getLocation().y - yGuerrero;
                }
                menor =  (int) Math.sqrt(Math.pow(distanciax, 2) + Math.pow(distanciay, 2));
                
                if (menor < cercano) {
                    cercano = menor;
                    xEnemigo = defense.get(i).refLabel.getLocation().x;
                    yEnemigo = defense.get(i).refLabel.getLocation().y;
                }
                if (distanciax == 0)
                    num=30;
                else if(distanciay ==0){
                    num=23;
                }
                else{
                    num = (int) Math.sqrt(Math.pow(23, 2) + Math.pow(30, 2));
                }
            }
            ArrayList<GameThread> enemy = new ArrayList<>();
            for (int i = 0; i < defense.size(); i++){
                if (defense.get(i).refLabel.getLocation().x == xEnemigo && defense.get(i).refLabel.getLocation().y == yEnemigo ){
                    if (defense.get(i).guerrero.getcLife() > 0){
                        enemy.add(defense.get(i));
                    }
                }
            }    
            Zombie zombie = (Zombie) gameThread.guerrero;
            Boolean ataco = zombie.attackAllInRange(enemy, gameThread, num, cercano, gameThread.refLabel);
            gameThread.sleep(1000);
            String url = gameThread.guerrero.getcAppearance3(gameThread.guerrero.getcLevel(),"STOP");
            if (url != null) {
                cambiarImagen(url, gameThread.refLabel);
            }
            return ataco;
        }
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

    public GameThread getGanador(GameThread guerrero) {
        String ganador = "";
        boolean esArmy = this.defense.contains(guerrero);
        if (esArmy) {
            for (int i = 0; i < this.defense.size(); i++) {
                if (this.defense.get(i).guerrero.getcLife() < 0 && (this.defense.get(i).guerrero.getTipo() == TypeCharacters.RELIQUIA))
                    ganador = "Enemigos";
                else
                    return null;
            }
            ganador = "Enemigos";
            stopArmy();

        } else {
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).guerrero.getcLife() > 0)
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
    
    private void cambiarImagen(String url, JLabel refLabel){
        ImageIcon imageicon = new ImageIcon(url);
        int ancho=imageicon.getIconWidth();
        int alto=imageicon.getIconHeight();
        Image img = imageicon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        refLabel.setIcon(new ImageIcon(img));
        refLabel.setSize(ancho, alto);
        refLabel.setOpaque(false);
    }
    
    public void mostrarLog(){
        for (GameThread gameThread : defense) {
            Weapon weapon = (Weapon)gameThread.guerrero;
            String log = weapon.getLog().readAllLog(weapon.getcLife());
            gameThread.refPantalla.escribirHilos(log);
        }
        for (GameThread gameThread : enemies) {
            Zombie zombie = (Zombie)gameThread.guerrero;
            String log = zombie.getLog().readAllLog(zombie.getcLife());
            gameThread.refPantalla.escribirHilos(log);
        }
    }
}
