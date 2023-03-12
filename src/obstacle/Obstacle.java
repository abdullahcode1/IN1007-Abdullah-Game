package obstacle;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.awt.*;


public class Obstacle extends StaticBody {

    public Obstacle(World world, BoxShape obstacleSize) {
        super(world, obstacleSize);
        setAlwaysOutline(false);
        setFillColor(Color.red);
        setLineColor(Color.red);
    }
}
