package uet.oop.bomberman.graphics;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.entities.Grass;

import static uet.oop.bomberman.BombermanGame.*;

import uet.oop.bomberman.BombermanGame.*;

// Import library
import java.io.File;
import java.io.FileReader;
import java.io.IOException; // IOException is the base class for exceptions thrown while accessing information using streams, files and directories.
import java.util.Scanner;
import java.util.StringTokenizer; // The java.util.StringTokenizer class allows you to split a string into its token elements.

public class MapCreation {
    // Constructor MapCreation with parameter "level" in string data type.
    public MapCreation(String level) {
        System.out.println(System.getProperty("user.dir"));
        File fileName = new File("res/levels/Level1.txt");                      // Create object fileName from class File in File library imported.
        try (FileReader inputFile = new FileReader(fileName)) {     // Try to create new object from class FileReader.
            Scanner ip = new Scanner(inputFile);                    // Create object ip from class Scanner.
            String line = ip.nextLine();                            // Input variable line in string data type.
            System.out.println("1");
            //StringTokenizer
            StringTokenizer tokens = new StringTokenizer(line);
            BombermanGame.level = Integer.parseInt(tokens.nextToken());
            // Create object tokens from class StringTokenizer in library imported.
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());
            System.out.println("2");
            while (ip.hasNextLine()) {
                System.out.println("2.1");
                id_objects = new int[width][height];                 // Create new object id_object from main file.
                //string_id_objects = new String[width][height];                 // Create new object id_object from main file.
                list_kill = new int[width][height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                //string_list_kill = new String[width][height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                System.out.println("2.2");
                for (int i = 0; i < height; ++i) {
                    System.out.println("2.3");
                    String lineTile = ip.nextLine();               // Input variable lineTile in string data type.
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);      // Create object tokenTile from class StringTokenizer in library imported.
                    System.out.println("3");
                    for (int j = 0; j < width; j++) {
                        int token = Integer.parseInt(tokenTile.nextToken());
                        Entity entity;                              // Create object entity from class Entity.

                        // This switch statement running, and we got a full map for a game.
                        // Through the program, in the for-loop statement, we can get the map according to each loop it passed.
                        switch (token) {
                            case 1:
                                entity = new Portal(j, i, Sprite.grass.getFxImage());       // In case 1, set entity object equal to object portal with scaled size.
                                token = 0;
                                break;
                            case 2:
                                entity = new Wall(j, i, Sprite.wall.getFxImage());          // In case 2, set entity object equal to object wall with scaled size.
                                break;
                            case 3:
                                entity = new Brick(j, i, Sprite.brick.getFxImage());        // In case 3, set entity object equal to object brick with scaled size.
                                break;
                            default:
                                entity = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        id_objects[j][i] = token;        //
                        stillObjects.add(entity);              //
                    }
                }
            }
        } catch (IOException e) {                       // Catch exception
            e.printStackTrace();                        // printStackTrace(): Help to understand where the problem is actually happening.
        } catch (Exception e) {
            System.out.println("loi");
        }
    }
}
