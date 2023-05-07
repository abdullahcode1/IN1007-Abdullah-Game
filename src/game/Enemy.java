package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Enemy extends Walker {

    private int direction;

    private static final Shape studentShape = new BoxShape(1, 0.9f);

    public Enemy(World world) {
        super(world, studentShape);
        setFillColor(Color.PINK);
        direction = 1;
        startWalking(3);
        this.addImage(new BodyImage("data/gifs/enemy/enemy-move-right.gif",2));
    }



    public void SwitchDirection() {
        stopWalking();
        if (direction == 1) {
            direction = 0;
            startWalking(-3f);
            this.removeAllImages();
            this.addImage(new BodyImage("data/gifs/enemy/enemy-move-left.gif",2));
        } else {
            direction = 1;
            startWalking(3f);
            this.removeAllImages();
            this.addImage(new BodyImage("data/gifs/enemy/enemy-move-right.gif",2));
        }
    }
}
