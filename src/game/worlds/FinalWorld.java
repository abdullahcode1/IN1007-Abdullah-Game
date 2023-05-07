package game.worlds;

import city.cs.engine.BoxShape;
import city.cs.engine.World;
import game.*;
import org.jbox2d.common.Vec2;

public class FinalWorld extends World {
    final Student student;
    private Tracker trackerMain;

    public FinalWorld() {
        super();
        Populate();
        student = new Student(this);
        student.setPosition(new Vec2(0f, -10f));
        student.setReturnPosition(new Vec2(0f, -10f));
        CollisionHandler obstacleMain = new CollisionHandler(student);
        student.addCollisionListener(obstacleMain);
        trackerMain = new Tracker(Game.getView(), this.getStudent());
        this.addStepListener(trackerMain);

    }


    private void Populate() {
        CreateBoundary();
    }

    private void CreateBoundary() {

        Platform groundOne = new Platform(this, new BoxShape(12f, 1.5f));
        groundOne.SetType("ground",0);
        groundOne.setPosition(new Vec2(-12f, -13f));

        Platform groundTwo = new Platform(this, new BoxShape(13f, 1.5f));
        groundTwo.SetType("ground",0);
        groundTwo.setPosition(new Vec2(12f, -13f));

    }
    public Student getStudent() {
        return student;
    }

    public Tracker getTracker() { return trackerMain;}

    public String getBackground() { return "data/img/FinalBackground.png"; }

}