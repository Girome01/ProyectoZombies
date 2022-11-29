/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package proyectozombie;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import proyectozombie.interfaz.inicioSesion_Juego;

/**
 *
 * @author Usuario
 */
public class ProyectoZombie {

    public static void main(String[] args) {
        inicioSesion_Juego frame = new inicioSesion_Juego();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(290, 150);
        frame.setVisible(true);
    }
}
