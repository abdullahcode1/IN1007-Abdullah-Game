package game.worlds;

import city.cs.engine.BoxShape;
import city.cs.engine.World;
import game.*;
import org.jbox2d.common.Vec2;

public class MainWorld extends World {
    final Student student;
    private Tracker trackerMain;

    public MainWorld() {
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

        FinishLine finishLine = new FinishLine(this, new BoxShape(0.66f, 2f));
        finishLine.setPosition(new Vec2(23f, -9f));
        CreateBoundary();

        finishLine.setNextLevel(1);

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

    public String getBackground() { return "data/img/background.png"; }

}