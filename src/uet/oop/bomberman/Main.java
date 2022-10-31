package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import uet.oop.bomberman.view.ViewManager;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            ViewManager manager = new ViewManager();
            primaryStage = manager.getMainStage();
            primaryStage.setTitle("Bomberman By B.H.H");
            primaryStage.setFullScreen(false);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("textures\\icon.png"));
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
