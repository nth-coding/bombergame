package uet.oop.bomberman;

import javafx.application.Application;
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
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
