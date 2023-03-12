package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.awt.*;

public class FinishLine extends StaticBody {

    private int nextLevel;

    public FinishLine(World world, BoxShape obstacleSize) {

        super(world, obstacleSize);
        setFillColor(Color.green);
        setLineColor(Color.green);
        addImage(new BodyImage("data/gifs/portal-blue.gif", 4));
    }
}
