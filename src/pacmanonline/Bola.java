/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanonline;

import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Javier
 */
public class Bola {
    //------------------------   BOLA DE PUNTUACION   --------------------------
        Circle circleBola;    
    
        double posBolaX;
        double posBolaY;
        
        public Bola( Pane root){
            circleBola = new Circle();
            circleBola.setFill(Color.RED);
            circleBola.setRadius(3);
            circleBola.setRadius(6);
            Random randomAsteroidePos = new Random();
            posBolaX = randomAsteroidePos.nextInt(600);
            posBolaY = randomAsteroidePos.nextInt(600);
            circleBola.setTranslateX(posBolaX);
            circleBola.setTranslateY(posBolaY);
        }
        public Circle getBola(){
            return circleBola;
        }
    //--------------------------------------------------------------------------
}