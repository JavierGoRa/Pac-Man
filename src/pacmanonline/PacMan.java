/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 * Autor : Javier González Ramírez
 * Email : javigora97@gmail.com
 *
*/

package pacmanonline;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

    //Posicion del pacman
    double posPacManX = sceneTamX/2;
    double posPacManY = sceneTamY/2;
    
    //Velocidad del pacman
    double velPacManX;
    double velPacManY;
    
    boolean vivo = true;
    
    int score;
    
    Bola bola;
    
    
    
    public void start(Stage primaryStage) {

        paneRoot = new Pane();
        
        bola = new Bola(paneRoot);
        
        //Crear el panel principal
        Scene scene = new Scene(paneRoot, sceneTamX, sceneTamY);

        //Muestra el panel madre donde contendra todo
        primaryStage.setTitle("Pac - Man Online");
        primaryStage.setScene(scene);
        primaryStage.show();

//-------------------   CAJA DE CONTACTO DE PAC MAN   --------------------------        
        Polygon pacMan = new Polygon();
        pacMan.setFill(Color.WHITE);
        pacMan.getPoints().addAll(new Double []{
            0.0, 0.0,
            20.0, 0.0,
            20.0, 20.0,
            0.0, 20.0
        });
        paneRoot.getChildren().add(pacMan);
//------------------------------------------------------------------------------        
        
//---------------------   CODIGO DE LA IMAGEN PAC MAN   ------------------------
        Image imagePacMan1 = new Image("pacmanonline/PacManImagen.gif");
        
        ImageView imageView = new ImageView();
        imageView.setImage(imagePacMan1);
        
        paneRoot.getChildren().add(imageView);
//------------------------------------------------------------------------------

//--------------------------   LISTA DE BOLAS   --------------------------------
        ArrayList <Bola> listaBola = new ArrayList();
        for (int i = 0; i < 5; i++){
            bola = new Bola(paneRoot);
            listaBola.add(bola);
        }
//------------------------------------------------------------------------------

//-------------------   PANEL  DE LAS VIDAS Y PUNTUACION   ---------------------
        HBox hBoxprincipal = new HBox();
        hBoxprincipal.setTranslateY(20);
        hBoxprincipal.setMinWidth(sceneTamX);
        hBoxprincipal.setAlignment(Pos.TOP_LEFT);
        hBoxprincipal.setSpacing(sceneTamX / 2);
        paneRoot.getChildren().add(hBoxprincipal);

        HBox hBoxPuntuacion = new HBox();
        hBoxPuntuacion.setSpacing(10);
        hBoxPuntuacion.setTranslateX(20);
        hBoxprincipal.getChildren().add(hBoxPuntuacion);

        HBox hBoxVidas = new HBox();
        hBoxVidas.setSpacing(10);
        hBoxVidas.setTranslateX(100);
        hBoxprincipal.getChildren().add(hBoxVidas);

        Text textTituloScore = new Text("Score:");
        textTituloScore.setFont(Font.font(20));
        textTituloScore.setFill(Color.BLACK);

        Text textScore = new Text("0");
        textScore.setFont(Font.font(20));
        textScore.setFill(Color.BLACK);

        Text textTituloScore1 = new Text("Score:");
        textTituloScore1.setFont(Font.font(20));
        textTituloScore1.setFill(Color.BLACK);

        hBoxPuntuacion.getChildren().add(textTituloScore);
        hBoxPuntuacion.getChildren().add(textScore);
        hBoxVidas.getChildren().add(textTituloScore1);
//------------------------------------------------------------------------------

//------------------------   ANIMACION DEL JUEGO   -----------------------------        
        AnimationTimer animationPacMan;
        animationPacMan = new AnimationTimer(){
            public void handle(long now) {
                posPacManX += velPacManX;
                imageView.setTranslateX(posPacManX);
                posPacManY += velPacManY;
                imageView.setTranslateY(posPacManY);
                
                
                pacMan.setTranslateX(posPacManX);
                pacMan.setTranslateY(posPacManY);
                
                for(int i = 0 ; i < listaBola.size() ; i++){
                    bola = listaBola.get(i);
                    Shape shapeBolaPacMan = Shape.intersect(bola.getBola(), pacMan);
                    boolean colisionVaciaNA = shapeBolaPacMan.getBoundsInLocal().isEmpty();
                    if (colisionVaciaNA == false) {
                        paneRoot.getChildren().remove(bola.getBola());
                        score++;
                        textScore.setText(String.valueOf(score));
                    }
                }
            }
        };
        animationPacMan.start();
//------------------------------------------------------------------------------
        
//-----------------------   EVENTOS EN LOS CONTROLES   -------------------------
        scene.setOnKeyPressed((KeyEvent event) -> {
            
            switch(event.getCode()) {
                case UP:
                    velPacManY = -2;
                    velPacManX = 0;
                    
                    imageView.setRotate(270);
                    
                    break;
                    
                case DOWN:
                    velPacManY = 2;
                    velPacManX = 0;
                    
                    imageView.setRotate(90);
                    
                    break;
                    
                case LEFT:
                    velPacManX = -2;
                    velPacManY = 0;
                    
                    imageView.setRotate(180);
                    
                    break;
                    
                case RIGHT:
                    velPacManX = 2;
                    velPacManY = 0;
                    
                    imageView.setRotate(0);
                    
                    break;
            }
        });
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
               
            }
        });
//------------------------------------------------------------------------------
 
    }
}
