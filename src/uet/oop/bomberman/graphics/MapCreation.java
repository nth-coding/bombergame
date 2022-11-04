package uet.oop.bomberman.graphics;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.entities.items.FlameItem;
import uet.oop.bomberman.entities.items.SpeedItem;
import uet.oop.bomberman.entities.items.WallPassItem;
import uet.oop.bomberman.entities.object.Grass;
import uet.oop.bomberman.entities.object.Brick;
import uet.oop.bomberman.entities.object.Portal;
import uet.oop.bomberman.entities.object.Wall;

import static uet.oop.bomberman.BombermanGame.*;

// Import library
import java.io.File;
import java.io.FileReader;
import java.io.IOException; // IOException is the base class for exceptions thrown while accessing information using streams, files and directories.
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer; // The java.util.StringTokenizer class allows you to split a string into its token elements.

public class MapCreation {
    // Constructor MapCreation with parameter "level" in string data type.
    public MapCreation(String level) {
        System.out.println(System.getProperty("user.dir"));
        File fileName = new File("res/levels/"+ level);                      // Create object fileName from class File in File library imported.
        try (FileReader inputFile = new FileReader(fileName)) {     // Try to create new object from class FileReader.
            Scanner ip = new Scanner(inputFile);                    // Create object ip from class Scanner.
            String line = ip.nextLine();                            // Input variable line in string data type.
            //System.out.println("1");
            //StringTokenizer
            StringTokenizer tokens = new StringTokenizer(line);
            BombermanGame.level = Integer.parseInt(tokens.nextToken());
            // Create object tokens from class StringTokenizer in library imported.
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());
            //System.out.println("2");
            while (ip.hasNextLine()) {
                //System.out.println("2.1");
                id_objects = new int[width][height];                 // Create new object id_object from main file.
                //string_id_objects = new String[width][height];                 // Create new object id_object from main file.
                list_kill = new int[width][height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                //string_list_kill = new String[width][height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                //System.out.println("2.2");
                for (int i = 0; i < height; ++i) {
                    //System.out.println("2.3");
                    String lineTile = ip.nextLine();               // Input variable lineTile in string data type.
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);      // Create object tokenTile from class StringTokenizer in library imported.
                    //System.out.println("3");
                    for (int j = 0; j < width; j++) {
                        int token = Integer.parseInt(tokenTile.nextToken());
                        Entity entity;                              // Create object entity from class Entity.

                        // This switch statement running, and we got a full map for a game.
                        // Through the program, in the for-loop statement, we can get the map according to each loop it passed.
                        switch (token) {
                            case 1:
                                entity = new Portal(j, i, Sprite.portal.getFxImage());       // In case 1, set entity object equal to object portal with scaled size.
                                token = 0;
                                break;
                            case 2:
                                if (BombermanGame.level == 1) {
                                    entity = new Wall(j, i, Sprite.wall1.getFxImage());          // In case 2, set entity object equal to object wall with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new Wall(j, i, Sprite.wall2.getFxImage());
                                } else {
                                    entity = new Wall(j, i, Sprite.wall3.getFxImage());
                                }
                                break;
                            case 3:
                                if (BombermanGame.level == 1) {
                                    entity = new Brick(j, i, Sprite.brick1.getFxImage());        // In case 3, set entity object equal to object brick with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new Brick(j, i, Sprite.brick2.getFxImage());
                                } else {
                                    entity = new Brick(j, i, Sprite.brick3.getFxImage());
                                }
                                break;
                            case 6:
                                if (BombermanGame.level == 1) {
                                    entity = new SpeedItem(j, i, Sprite.brick1.getFxImage());       // In case 3, set entity object equal to object brick with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new SpeedItem(j, i, Sprite.brick2.getFxImage());
                                } else {
                                    entity = new SpeedItem(j, i, Sprite.brick3.getFxImage());
                                }
                                break;
                            case 7:
                                if (BombermanGame.level == 1) {
                                    entity = new FlameItem(j, i, Sprite.brick1.getFxImage());       // In case 3, set entity object equal to object brick with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new FlameItem(j, i, Sprite.brick2.getFxImage());
                                } else {
                                    entity = new FlameItem(j, i, Sprite.brick3.getFxImage());
                                }
                                break;
                            case 8:
                                if (BombermanGame.level == 1) {
                                    entity = new BombItem(j, i, Sprite.brick1.getFxImage());       // In case 3, set entity object equal to object brick with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new BombItem(j, i, Sprite.brick2.getFxImage());
                                } else {
                                    entity = new BombItem(j, i, Sprite.brick3.getFxImage());
                                }
                                break;
                            case 9:
                                if (BombermanGame.level == 1) {
                                    entity = new Grass(j, i, Sprite.grass_shadow1.getFxImage());       // In case 3, set entity object equal to object brick with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new Grass(j, i, Sprite.grass_shadow.getFxImage());
                                } else {
                                    entity = new Grass(j, i, Sprite.grass_shadow2.getFxImage());
                                }
                                break;
                            case 10:
                                if (BombermanGame.level == 1) {
                                    entity = new WallPassItem(j, i, Sprite.brick1.getFxImage());       // In case 3, set entity object equal to object brick with scaled size.
                                } else if (BombermanGame.level == 2) {
                                    entity = new WallPassItem(j, i, Sprite.brick2.getFxImage());
                                } else {
                                    entity = new WallPassItem(j, i, Sprite.brick3.getFxImage());
                                }
                                break;
                            case 11:
                                entity = new Wall(j, i, Sprite.wall_topleft.getFxImage());
                                break;
                            case 12:
                                entity = new Wall(j, i, Sprite.wall_topmid.getFxImage());
                                break;
                            case 13:
                                entity = new Wall(j, i, Sprite.wall_topright.getFxImage());
                                break;
                            case 14:
                                entity = new Wall(j, i, Sprite.wall_midleft.getFxImage());
                                break;
                            case 15:
                                entity = new Wall(j, i, Sprite.wall_midright.getFxImage());
                                break;
                            case 16:
                                entity = new Wall(j, i, Sprite.wall_bottomleft.getFxImage());
                                break;
                            case 17:
                                entity = new Wall(j, i, Sprite.wall_bottommid.getFxImage());
                                break;
                            case 18:
                                entity = new Wall(j, i, Sprite.wall_bottomright.getFxImage());
                                break;

                            default:
                                if (BombermanGame.level == 1) {
                                    entity = new Grass(j, i, Sprite.grass1.getFxImage());
                                } else if (BombermanGame.level == 2) {
                                    entity = new Grass(j, i, Sprite.grass2.getFxImage());
                                } else {
                                    entity = new Grass(j, i, Sprite.grass3.getFxImage());
                                }
                        }
                        id_objects[j][i] = token;        //
//                        System.out.print(id_objects[j][i] + " ");
                        stillObjects.add(entity);              //
                    }
//                    System.out.println();
                }
            }
        } catch (IOException e) {                       // Catch exception
            e.printStackTrace();                        // printStackTrace(): Help to understand where the problem is actually happening.
        } catch (Exception e) {
            System.out.println("loi");
        }
    }
}
