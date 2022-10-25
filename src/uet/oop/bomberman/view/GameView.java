package uet.oop.bomberman.view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uet.oop.bomberman.graphics.Sprite;


public class GameView {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private static final int GAME_WIDTH = 1000;
    private static final int GAME_HEIGHT = 650;
    private Stage menuStage;

    private ImageView bomber;
    public GameView(){
    initialize();

    }
    private void createKeyListeners(){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.LEFT){

                }else if(keyEvent.getCode()== KeyCode.RIGHT){

                }
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.LEFT){

                }else if(keyEvent.getCode()== KeyCode.RIGHT){

                }
            }
        });
    }
    private  void initialize(){
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);


    }
    public void createNewGame(Stage menuStage){
        this.menuStage = menuStage;
        this.menuStage.hide();
        createBomber();
        gameStage.show();

    }

    private void createBomber(){
        Image img = Sprite.player_left.getFxImage();
        bomber = new ImageView();
        bomber.setImage(img);
        bomber.setLayoutX(1);
        bomber.setLayoutY(1);
        gamePane.getChildren().add(bomber);
    }

}
