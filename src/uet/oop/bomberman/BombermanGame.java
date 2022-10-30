package uet.oop.bomberman;

import javafx.animation.Timeline;
import uet.oop.bomberman.Levels.Level1;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.*;

import uet.oop.bomberman.entities.object.Portal;
import uet.oop.bomberman.graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.view.PauseMenu;
import uet.oop.bomberman.view.ViewManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.Levels.NextLevel.*;
import static uet.oop.bomberman.entities.Bomber.dem;
import static uet.oop.bomberman.entities.Bomber.newStage;
import static uet.oop.bomberman.entities.object.Portal.is_portal;
import static uet.oop.bomberman.view.ViewManager.gameStage;


public class BombermanGame {

    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;
    //
    public static int width = 0;

    //
    public static int height = 0;
    //
    public static int[][] id_objects;
    //
    public static int[][] list_kill;
    //
    public static String[][] string_list_kill;
    //
    public static String[][] string_id_objects;
    public static boolean running;
    //
    public static int level = 1;
    private Timeline timeline;

    private Scene mainScene;
    public static Entity bomberman;
    private GraphicsContext gc;
    private Canvas canvas;
    public static ImageView img;
    public static final List<Entity> entities = new ArrayList<>();
    public static final List<Entity> stillObjects = new ArrayList<>();
    public static Group root = new Group();

    public Scene getMainScene() {
        return mainScene;
    }

    private Timeline t;
    private PauseMenu pause = new PauseMenu();

    public void createGame(Stage stage) {
        if (dem != 0) {

            new Level1();
            running = true;
        }
        else{

        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();


        // Tao root container

        root.getChildren().add(canvas);

        // Tao mainScene
        mainScene = new Scene(root);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setNode(root);
        fade.play();
        FadeTransition fadeTransition = new FadeTransition();
        try {
            Image logo = new Image(new FileInputStream("res\\Trans\\Level1.png"));
            img = new ImageView();
            img.setImage(logo);
            img.setLayoutX(0);
            img.setLayoutY(0);
            root.getChildren().add(img);

            fadeTransition.setDuration(Duration.millis(4000));
            fadeTransition.setFromValue(10);

            fadeTransition.setToValue(0);
            fadeTransition.setNode(img);
            fadeTransition.play();
        } catch (FileNotFoundException e) {
        }

        // Add mainScene vao stage
        stage.setScene(mainScene);
        stage.setTitle("Bomberman");
        stage.show();

        // Tao bomber
        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        bomberman.setLife(true);

        // Testing enemy
//        Entity enemy1 = new Oneal(4, 4, Sprite.oneal_left2.getFxImage());
//        entities.add(enemy1);

        // Tao map
        createMap();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (running) {
                    render();
                    update();
                }
            }
        };
        timer.start();
    }

}

    public void createMap() {
        new Level1();

        running = true;

    }

    // moves the bomberman.
    private void updatePlayerInput() {
        // KeyPsed
        mainScene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();

            if (key == KeyCode.A || key == KeyCode.LEFT) {
                // bomberman.setVelX(-5);
                ComponentMovement.left(bomberman);
            } else if (key == KeyCode.D || key == KeyCode.RIGHT) {
                // bomberman.setVelX(5);
                ComponentMovement.right(bomberman);
            } else if (key == KeyCode.W || key == KeyCode.UP) {
                // bomberman.setVelY(-5);
                ComponentMovement.up(bomberman);
            } else if (key == KeyCode.S || key == KeyCode.DOWN) {
                // bomberman.setVelY(5);
                ComponentMovement.down(bomberman);

            } else if (key == KeyCode.SPACE) {
                Bomb.putBomb();


//                System.out.println(bomberman.getX() + " " + bomberman.getY());
            } else if (key == KeyCode.ESCAPE) {
                running = false;

                pause.showPause();


            }
        });
    }

    public void update() {
        updatePlayerInput();

        for (int i = 0; i < entities.size(); ++i) {
            entities.get(i).update();
        }

        bomberman.update();

        for (int i = 0; i < stillObjects.size(); ++i) {
            stillObjects.get(i).update();
        }

        bomberman.setCountToRun(bomberman.getCountToRun() + 1);
        if (bomberman.getCountToRun() == 4) {
            ComponentMovement.checkRun(bomberman);
            bomberman.setCountToRun(0);
        }

        for (Entity a : entities) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 8) {
                ComponentMovement.checkRun(a);
                a.setCountToRun(0);
            }
        }
        if (entities.size() == 0 && !is_portal && !wait) {
            Entity portal = new Portal(1, 3, Sprite.portal.getFxImage());
            stillObjects.add(portal);
            if (bomberman.getX() / 32 == portal.getX() / 32 && bomberman.getY() / 32 == portal.getY() / 32) {
                wait = true;
                waiting_time = System.currentTimeMillis();
            }
        }
        waitToLevelUp(ViewManager.getMainStage());
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
