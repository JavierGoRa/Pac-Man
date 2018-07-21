/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanonline;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Javier
 */
public class PacMan extends Application {

    Pane paneRoot;

    //Tamaño del panel
    double sceneTamX = 600;
    double sceneTamY = 600;

    double posPacManX = sceneTamX/2;
    double posPacManY = sceneTamY/2;
    
    double velPacManX;
    double velPacManY;
    
    boolean vivo = true;
    
    public void start(Stage primaryStage) {

        paneRoot = new Pane();

        //Crear el panel principal
        Scene scene = new Scene(paneRoot, sceneTamX, sceneTamY);

        //Muestra el panel madre donde contendra todo
        primaryStage.setTitle("Pac - Man Online");
        primaryStage.setScene(scene);
        primaryStage.show();

//---------------------   CODIGO DE LA IMAGEN PAC MAN   ------------------------
        Image imagePacMan1 = new Image("pacmanonline/PacManImagen.gif");
        
        ImageView imageView = new ImageView();
        
        
        imageView.setTranslateX(posPacManX);
        imageView.setTranslateY(posPacManY);
        
        imageView.setImage(imagePacMan1);
            paneRoot.getChildren().add(imageView);
//------------------------------------------------------------------------------
        
//------------------------   ANIMACION DEL JUEGO   -----------------------------        
        AnimationTimer animationPacMan;
        animationPacMan = new AnimationTimer(){
            public void handle(long now) {
                posPacManX += velPacManX;
                imageView.setTranslateX(posPacManX);
                posPacManY += velPacManY;
                imageView.setTranslateX(posPacManY);
                
                
                
                
            }
        };
        animationPacMan.start();
//------------------------------------------------------------------------------
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            
            switch(event.getCode()) {
                case UP:
                    velPacManY = 2;
                    velPacManX = 0;
                    
                    System.out.println("velPacManY = " + velPacManY );
                    System.out.println("velPacManX = " + velPacManX );
                    break;
                    
                case DOWN:
                    velPacManY = -2;
                    velPacManX = 0;
                    
                    System.out.println("velPacManY = " + velPacManY );
                    System.out.println("velPacManX = " + velPacManX );
                    break;
                    
                case LEFT:
                    velPacManX = -2;
                    velPacManY = 0;
                    
                    System.out.println("velPacManY = " + velPacManY );
                    System.out.println("velPacManX = " + velPacManX );
                    break;
                    
                case RIGHT:
                    velPacManX = 2;
                    velPacManY = 0;
                    
                    System.out.println("velPacManY = " + velPacManY );
                    System.out.println("velPacManX = " + velPacManX );
                    break;
                     
            }

        });
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
               
            }
        });
        
    }

}
