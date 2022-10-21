package view;


import components.Component;
import entities.*;
import graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static Levels.NextLevel.waitToLevelUp;

public class BombermanGame  {
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;
    //
    public static int width = 0;
    private int frame =1;
    private long last_time;
    public static Stage main_stage = null;
    //
    private int count =0;
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
    private Entity bomberman;
    private Entity balloom;
    public static Text time;
    public static int time_number = 120;
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Animal> enemy = new ArrayList<>();           // Contains enemy entities

    public static final List<Entity> entities = new ArrayList<>();
    public static final List<Entity> stillObjects = new ArrayList<>();

    public Scene getMainScene() {
        return mainScene;
    }

    // void ne



    public void createGame(Stage stage) {
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
        balloom = new Ballom(WIDTH- 2, HEIGHT -2 , Sprite.balloom_left1.getFxImage());
        entities.add(balloom);
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
        balloom.update();

        bomberman.setCountToRun(bomberman.getCountToRun() + 1);
        if (bomberman.getCountToRun() == 4) {
            Component.checkRun(bomberman);
            bomberman.setCountToRun(0);
        }



        balloom.setCountToRun(balloom.getCountToRun() + 1);
        if (balloom.getCountToRun() == 12  ) {
            Component.checkRun(balloom);
            balloom.setCountToRun(0);
        }
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
