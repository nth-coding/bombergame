package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import uet.oop.bomberman.components.Component;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.Levels.NextLevel.waitToLevelUp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BombermanGame extends Application {

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
    //
    public static int level;

    private Scene mainScene;
    public static Entity bomberman;
    private GraphicsContext gc;
    private Canvas canvas;

    public static final List<Entity> entities = new ArrayList<>();
    public static final List<Entity> stillObjects = new ArrayList<>();

    public Scene getMainScene() {
        return mainScene;
    }

    // void ne
    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();


        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao mainScene
        mainScene = new Scene(root);

        mainScene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();

            if (key == KeyCode.A || key == KeyCode.LEFT) {
                // bomberman.setVelX(-5);
                Component.left(bomberman);
            } else if (key == KeyCode.D || key == KeyCode.RIGHT) {
                // bomberman.setVelX(5);
                Component.right(bomberman);
            } else if (key == KeyCode.W || key == KeyCode.UP) {
                // bomberman.setVelY(-5);
                Component.up(bomberman);
            } else if (key == KeyCode.S || key == KeyCode.DOWN) {
                // bomberman.setVelY(5);
                Component.down(bomberman);
            }
            //
            else if (key == KeyCode.SPACE) {
                Bomb.putBomb();
            }
        });

        // mainScene.setOnKeyReleased(event -> {
        //     KeyCode key = event.getCode();

        //     if (key == KeyCode.A || key == KeyCode.LEFT) {
        //         bomberman.setVelX(0);
        //         Component.left(bomberman);
        //     } else if (key == KeyCode.D || key == KeyCode.RIGHT) {
        //         bomberman.setVelX(0);
        //         Component.right(bomberman);
        //     } else if (key == KeyCode.W || key == KeyCode.UP) {
        //         bomberman.setVelY(0);
        //         Component.up(bomberman);
        //     } else if (key == KeyCode.S || key == KeyCode.DOWN) {
        //         bomberman.setVelY(0);
        //         Component.down(bomberman);
        //     }
        // });

        // Add mainScene vao stage
        stage.setScene(mainScene);
        stage.setTitle("Bomberman");
        stage.show();

        // Tao map
        createMap();

        // Tao bomber
        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                } else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
        //Create map
        waitToLevelUp();
    }

    // moves the bomberman.
    public void position() {
        // bomberman.setX(bomberman.getX() + Entity.getVelX());
        // bomberman.setY(bomberman.getY() + Entity.getVelY());
    }

    private void updatePlayerInput() {
        // KeyPressed
        // getMainScene().setOnKeyPressed(Bomber::move);

        // getMainScene().setOnKeyReleased(Bomber::stop);

        position();
    }

    public void update() {
        updatePlayerInput();

        bomberman.setCountToRun(bomberman.getCountToRun() + 1);
        if (bomberman.getCountToRun() == 4) {
            Component.checkRun(bomberman);
            bomberman.setCountToRun(0);
        }
        entities.forEach(Entity::update);
        bomberman.update();
        stillObjects.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
