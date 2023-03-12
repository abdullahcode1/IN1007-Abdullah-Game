package game;

import city.cs.engine.*;

import java.awt.Color;

public class Platform extends StaticBody {
    private static final String GROUND_IMAGE_PATH = "data/img/tiles/ground/ground";
    private static final String EDGE_RIGHT_SINGLE_PATH = "data/img/tiles/platform-edge-right-single.png";
    private static final String INDEPENDENT_IMAGE_PATH = "data/img/tiles/independent/independent";
    private static final String WALL_IMAGE_PATH = "data/img/tiles/wall/wall";
    private static final String BLANK_IMAGE_PATH = "data/img/tiles/blank";

    private boolean isBoundary;

    private String type;

    public Platform(World world, BoxShape obstacleSize) {
        super(world, obstacleSize);
        setAlwaysOutline(false);
        setFillColor(Color.GRAY);
        setLineColor(Color.GRAY);
        SetType("default", 0);
        isBoundary = false;
    }


    public void SetType(String type, int variation) {
        this.type = type;
        switch (type) {
            case "default", "wall" -> addImage(new BodyImage(WALL_IMAGE_PATH + variation + ".png", 3));
            case "platform-edge-right-single" -> addImage(new BodyImage(EDGE_RIGHT_SINGLE_PATH, 3));
            case "ground" -> addImage(new BodyImage(GROUND_IMAGE_PATH + variation + ".png", 3));
            case "independent" -> addImage(new BodyImage(INDEPENDENT_IMAGE_PATH + variation + ".png", 3));
            case "blank" -> addImage(new BodyImage(BLANK_IMAGE_PATH + ".png", 2));

        }
    }

    public boolean getBoundary() {
        return isBoundary;
    }

    public void setBoundary(boolean isBoundary) {
        this.isBoundary = isBoundary;
    }
}
