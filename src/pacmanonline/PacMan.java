/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanonline;

import java.awt.event.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    boolean vivo = true;
    
    @Override
    public void start(Stage primaryStage) {

        paneRoot = new Pane();

        //Crear el panel principal
        Scene scenePrincipal = new Scene(paneRoot, sceneTamX, sceneTamY);

        //Muestra el panel madre donde contendra todo
        primaryStage.setTitle("Pac - Man Online");
        primaryStage.setScene(scenePrincipal);
        primaryStage.show();

//---------------------   CODIGO DE LA IMAGEN PAC MAN   ------------------------
        Image imagePacMan1 = new Image("pacmanonline/PacManImagen1.png");
        ImageView imageView = new ImageView();
        imageView.setImage(imagePacMan1);
        
        imageView.setTranslateX(posPacManX);
        imageView.setTranslateY(posPacManY);
        
        paneRoot.getChildren().add(imageView);
        
        while(vivo = true){
            
        };
        
//------------------------------------------------------------------------------
        
        
//----------------------   ANIMACION DEL JUEGO   -------------------------------        
        AnimationTimer animationPacMan;
        animationPacMan = new AnimationTimer(){
            @Override
            public void handle(long now) {
                posPacManX ++;
                imageView.setTranslateX(posPacManX);
            }
        };
        animationPacMan.start();
//------------------------------------------------------------------------------
        
//        scenePrincipal.setOnKeyPressed((KeyEvent event)-> {
//            switch(event.getCode()) {
//                
//            }
//
//        });
//        
//        scene.setOnKeyReleased((KeyEvent event) -> {
//            switch(event.getCode()){
//               
//            }
//        });
        
    }

}
