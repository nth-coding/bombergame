package entities;

import graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity  {
    protected int x; // Tọa độ X tính từ góc trái trên trong Canvas
    protected int y; // Tọa độ Y tính từ góc trái trên trong Canvas

    protected Image img;

    // player speed
    private int VelX; // velocity Ox
    private int VelY; // velocity Oy

    protected int isMove; // jump with pixel
    protected int swap; // swap image
    protected String direction; // direction of player
    protected int count; // count step of a jump
    protected int countToRun; // run after count frame
    protected boolean life; // life of enemy

    // Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity() {

    }

    public Entity(boolean life) {
        this.life = life;
    }

    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public Entity(int isMove, int swap, String direction, int count, int countToRun) {
        this.isMove = isMove;
        this.swap = swap;
        this.direction = direction;
        this.count = count;
        this.countToRun = countToRun;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getVelX() {
        return VelX;
    }

    public void setVelX(int velX) {
        VelX = velX;
    }

    public int getVelY() {
        return VelY;
    }

    public void setVelY(int velY) {
        VelY = velY;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public int getIsMove() {
        return isMove;
    }

    public void setIsMove(int isMove) {
        this.isMove = isMove;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountToRun() {
        return countToRun;
    }

    public void setCountToRun(int countToRun) {
        this.countToRun = countToRun;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
