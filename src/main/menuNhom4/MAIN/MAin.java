package MAIN;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;

public class MAin extends Application {

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
