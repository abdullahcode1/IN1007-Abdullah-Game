package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Point extends StaticBody {

    private static final Shape pointShape = new BoxShape(1,1);
    private boolean isDestroyed;

    private final Vec2 savedPosition;


    public Point(World world, Vec2 position) {
        super(world, pointShape);
        setFillColor(Color.MAGENTA);
        this.addImage(new BodyImage("data/gifs/blue-coin.gif", 2));
        savedPosition = position;
        setPosition(savedPosition);
    }

    public boolean getState() {
        return isDestroyed;
    }

    public void setState(boolean isDestroyed) {
        this.destroy();

        if (!isDestroyed) {
            this.isDestroyed = isDestroyed;
            new Point(Game.getView().getWorld(), savedPosition);
        }
    }

    public void ResetPoint() {
        this.setState(false);
    }

}
