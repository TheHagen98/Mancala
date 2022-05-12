package mancala.Model;

import java.awt.*;

abstract public class Sprite {
    protected int x;
    protected int y;


    abstract public void draw(Graphics2D graphics2D);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) { this.x=x; }

    public void setY(int y) { this.y = y; }
}
