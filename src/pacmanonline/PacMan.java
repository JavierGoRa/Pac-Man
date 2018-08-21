/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 * Autor : Javier González Ramírez
 * Email : javigora97@gmail.com
 * Proyecto de Practicas
 *
*/

/*
 * El tamaño del campo es 28x32 (casillas)
 * 560 x 640 (campo)
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
    double posPacManY = sceneTamY/1.5;
    
    //Velocidad del pacman
    double velPacManX;
    double velPacManY;
    
    boolean vivo = true;
    
    int score;
    
    Bola bola;
    
    boolean colisionVaciaPacManCaja;
    
    
    public void start(Stage primaryStage) {

        paneRoot = new Pane();
        
        bola = new Bola(paneRoot);
        
        //Crear el panel principal
        Scene scene = new Scene(paneRoot, sceneTamX, sceneTamY);

        //Muestra el panel madre donde contendra todo
        primaryStage.setTitle("Pac - Man Online");
        primaryStage.setScene(scene);
        primaryStage.show();

//--------------------------   DESEÑO DEL NIVEL   ------------------------------
    
        Polygon caja1 = new Polygon();
        caja1.setFill(Color.RED);
        caja1.getPoints().addAll(new Double []{
            0.0, 0.0,
            560.0, 0.0,
            560.0, 280.0,
            440.0, 280.0,
            440.0, 180.0,
            540.0, 180.0,
            540.0, 20.0,
            300.0, 20.0,
            300.0, 100.0,
            260.0, 100.0,
            260.0, 20.0,
            20.0, 20.0,
            20.0, 180.0,
            120.0, 180.0,
            120.0, 280.0,
            0.0, 280.0,
        });
        paneRoot.getChildren().add(caja1);
        
        Polygon caja2 = new Polygon();
        caja2.setFill(Color.RED);
        caja2.getPoints().addAll(new Double []{
            0.0, 0.0,
            560.0, 0.0,
            560.0, 280.0,
            440.0, 280.0,
            440.0, 180.0,
            540.0, 180.0,
            540.0, 20.0,
            20.0, 20.0,
            20.0, 180.0,
            120.0, 180.0,
            120.0, 280.0,
            0.0, 280.0,
        });
        caja2.setRotate(180);
        caja2.setTranslateY(300);
        paneRoot.getChildren().add(caja2);
        
        Polygon caja3 = new Polygon();
        caja3.setFill(Color.RED);
        caja3.getPoints().addAll(new Double []{
            0.0, 0.0,
            80.0, 0.0,
            80.0, 60.0,
            0.0, 60.0,
        });
        caja3.setRotate(180);
        caja3.setTranslateX(40);
        caja3.setTranslateY(40);
        paneRoot.getChildren().add(caja3);
        
        Polygon caja4 = new Polygon();
        caja4.setFill(Color.RED);
        caja4.getPoints().addAll(new Double []{
            0.0, 0.0,
            100.0, 0.0,
            100.0, 60.0,
            0.0, 60.0,
        });
        caja4.setRotate(180);
        caja4.setTranslateX(140);
        caja4.setTranslateY(40);
        paneRoot.getChildren().add(caja4);

        Polygon caja5 = new Polygon();
        caja5.setFill(Color.RED);
        caja5.getPoints().addAll(new Double []{
            0.0, 0.0,
            100.0, 0.0,
            100.0, 60.0,
            0.0, 60.0,
        });
        caja5.setRotate(180);
        caja5.setTranslateX(320);
        caja5.setTranslateY(40);
        paneRoot.getChildren().add(caja5);
        
        Polygon caja6 = new Polygon();
        caja6.setFill(Color.RED);
        caja6.getPoints().addAll(new Double []{
            0.0, 0.0,
            80.0, 0.0,
            80.0, 60.0,
            0.0, 60.0,
        });
        caja6.setRotate(180);
        caja6.setTranslateX(440);
        caja6.setTranslateY(40);
        paneRoot.getChildren().add(caja6);
        
        Polygon caja7 = new Polygon();
        caja7.setFill(Color.RED);
        caja7.getPoints().addAll(new Double []{
            0.0, 0.0,
            80.0, 0.0,
            80.0, 40.0,
            0.0, 40.0,
        });
        caja7.setRotate(180);
        caja7.setTranslateX(40);
        caja7.setTranslateY(120);
        paneRoot.getChildren().add(caja7);

        Polygon caja8 = new Polygon();
        caja8.setFill(Color.RED);
        caja8.getPoints().addAll(new Double []{
            0.0, 0.0,
            40.0, 0.0,
            40.0, 60.0,
            100.0, 60.0,
            100.0, 100.0,
            40.0, 100.0,
            40.0, 160.0,
            0.0, 160.0,
        });
        caja8.setTranslateX(140);
        caja8.setTranslateY(120);
        paneRoot.getChildren().add(caja8);
        
        Polygon caja9 = new Polygon();
        caja9.setFill(Color.RED);
        caja9.getPoints().addAll(new Double []{
            0.0, 0.0,
            160.0, 0.0,
            160.0, 40.0,
            100.0, 40.0,
            100.0, 100.0,
            60.0, 100.0,
            60.0, 40.0,
            0.0, 40.0,
        });
        caja9.setTranslateX(200);
        caja9.setTranslateY(120);
        paneRoot.getChildren().add(caja9);
        
        Polygon caja10 = new Polygon();
        caja10.setFill(Color.RED);
        caja10.getPoints().addAll(new Double []{
            0.0, 0.0,
            40.0, 0.0,
            40.0, 60.0,
            100.0, 60.0,
            100.0, 100.0,
            40.0, 100.0,
            40.0, 160.0,
            0.0, 160.0,
        });
        caja10.setRotate(180);
        caja10.setTranslateX(320);
        caja10.setTranslateY(120);
        paneRoot.getChildren().add(caja10);
        
        Polygon caja11 = new Polygon();
        caja11.setFill(Color.RED);
        caja11.getPoints().addAll(new Double []{
            0.0, 0.0,
            80.0, 0.0,
            80.0, 40.0,
            0.0, 40.0,
        });
        caja11.setRotate(180);
        caja11.setTranslateX(440);
        caja11.setTranslateY(120);
        paneRoot.getChildren().add(caja11);
        
        Polygon caja12 = new Polygon();
        caja12.setFill(Color.RED);
        caja12.getPoints().addAll(new Double []{
            0.0, 0.0,
            160.0, 0.0,
            160.0, 100.0,
            0.0, 100.0,
        });
        caja12.setTranslateX(200);
        caja12.setTranslateY(240);
        paneRoot.getChildren().add(caja12);

        Polygon caja13 = new Polygon();
        caja13.setFill(Color.RED);
        caja13.getPoints().addAll(new Double []{
            0.0, 0.0,
            40.0, 0.0,
            40.0, 100.0,
            0.0, 100.0,
        });
        caja13.setTranslateX(140);
        caja13.setTranslateY(300);
        paneRoot.getChildren().add(caja13);
        
        Polygon caja14 = new Polygon();
        caja14.setFill(Color.RED);
        caja14.getPoints().addAll(new Double []{
            0.0, 0.0,
            160.0, 0.0,
            160.0, 40.0,
            100.0, 40.0,
            100.0, 80.0,
            60.0, 80.0,
            60.0, 40.0,
            0.0, 40.0,
        });
        caja14.setTranslateX(200);
        caja14.setTranslateY(360);
        paneRoot.getChildren().add(caja14);
        
        Polygon caja15 = new Polygon();
        caja15.setFill(Color.RED);
        caja15.getPoints().addAll(new Double []{
            0.0, 0.0,
            40.0, 0.0,
            40.0, 100.0,
            0.0, 100.0,
        });
        caja15.setTranslateX(380);
        caja15.setTranslateY(300);
        paneRoot.getChildren().add(caja15);
        
        Polygon caja21 = new Polygon();
        caja21.setFill(Color.RED);
        caja21.getPoints().addAll(new Double []{
            0.0, 0.0,
            160.0, 0.0,
            160.0, 40.0,
            100.0, 40.0,
            100.0, 80.0,
            60.0, 80.0,
            60.0, 40.0,
            0.0, 40.0,
        });
        caja21.setTranslateX(200);
        caja21.setTranslateY(460);
        paneRoot.getChildren().add(caja21);
//------------------------------------------------------------------------------
        
        
//-------------------   CAJA DE CONTACTO DE PAC MAN   --------------------------        
        Polygon pacMan = new Polygon();
        pacMan.setFill(Color.WHITE);
        pacMan.getPoints().addAll(new Double []{
            0.0, 0.0,
            18.0, 0.0,
            18.0, 18.0,
            0.0, 18.0
        });
        paneRoot.getChildren().add(pacMan);
//------------------------------------------------------------------------------        
        
//---------------------   CODIGO DE LA IMAGEN PAC MAN   ------------------------
        Image imagePacMan1 = new Image("pacmanonline/PacManImagen.gif");
        
        ImageView imageView = new ImageView();
        imageView.setScaleX(0.91);
        imageView.setScaleY(0.91);
        imageView.setImage(imagePacMan1);
        
        paneRoot.getChildren().add(imageView);
//------------------------------------------------------------------------------

//--------------------------   LISTA DE BOLAS   --------------------------------
        ArrayList <Bola> listaBola = new ArrayList();
        for (int i = 0; i < 10; i++){
            bola = new Bola(paneRoot);
            paneRoot.getChildren().add(bola.circleBola); 
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
                imageView.setTranslateX(posPacManX - 0.9);
                posPacManY += velPacManY;
                imageView.setTranslateY(posPacManY - 0.9);
                
                
                pacMan.setTranslateX(posPacManX);
                pacMan.setTranslateY(posPacManY);
                
                for(int i = 0 ; i < listaBola.size() ; i++){
                    bola = listaBola.get(i);
                    Shape shapeBolaPacMan = Shape.intersect(bola.getBola(), pacMan);
                    boolean colisionVaciaPacManBola = shapeBolaPacMan.getBoundsInLocal().isEmpty();
                    if (colisionVaciaPacManBola == false) {
                        listaBola.remove(bola);
                        paneRoot.getChildren().remove(bola.getBola());
                        score++;
                        textScore.setText(String.valueOf(score));
                    }
                }
                Shape shapeCajaPacMan = Shape.intersect(caja1, pacMan);
                colisionVaciaPacManCaja = shapeCajaPacMan.getBoundsInLocal().isEmpty();
                if (colisionVaciaPacManCaja == false) {
                    System.out.println("FEO");
                    velPacManY = 0;
                    velPacManX = 0;
                }
            }
        };
        animationPacMan.start();
//------------------------------------------------------------------------------
        
//-------------------------   CONTROLES Y EVENTOS   ----------------------------
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
