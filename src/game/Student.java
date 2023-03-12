package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.ArrayList;

public class Student extends Walker {
    private String currentImage;
    private  Vec2 lastSaveLocation;

    private ArrayList<Point> collectedPoints = new ArrayList<>();

    private static final Shape studentShape = new BoxShape(1, 1.25f);

    private int currentHealth = 3;


    public Student(World world) {
        super(world, studentShape);
        setFillColor(Color.PINK);
    }

    public void returnStudent() {
        setPosition(lastSaveLocation);
    }

    public void setReturnPosition(Vec2 saveLocation) {
        lastSaveLocation = saveLocation;
    }

    @Override
    public void jump(float speed) {
        Vec2 v = this.getLinearVelocity();

        if (Math.abs(v.y) < 0.01F) {
            this.setLinearVelocity(new Vec2(v.x, speed));
        }
    }


    public void stateManager(Vec2 velocity) {
        String newState = null;
        if ( velocity.x > -0.1 && velocity.x < 0.1 && velocity.y < 0.1) {
            newState = "idle";
        } else if (velocity.x >= 0.1) {
            newState = "run";
        } else if (velocity.x <= -0.1) {
            newState = "run-left";
        }

        if (newState != null && !newState.equals(currentImage)) {
            this.removeAllImages();
            this.addImage(new BodyImage("data/gifs/character/character-" + newState + ".gif", 2.5f));


            currentImage = newState;
        }
    }



    public void Respawn() {
        this.returnStudent();
        this.setLinearVelocity(new Vec2(0,0));
        setCurrentHealth(currentHealth- 1);
        Game.resetStudent();
    }

    public void addCollectedFlippers(Point collectedPoint) {
        collectedPoint.setState(true);
        collectedPoints.add(collectedPoint);

    }
    public void setCollectedFlippers(ArrayList<Point> collectedPoints) {
        this.collectedPoints = collectedPoints;
    }

    public ArrayList<Point> getCollectedFlippers() {
        return collectedPoints;
    }


    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        System.out.println(currentHealth);
        if (this.currentHealth == 0) {
            Game.loadWorld(Game.getView());
        }
    }
}