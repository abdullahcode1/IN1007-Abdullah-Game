package game.worlds;

import city.cs.engine.BoxShape;
import city.cs.engine.World;
import game.*;
import org.jbox2d.common.Vec2;

public class FirstWorld extends World {
    final Student student;
    private Tracker trackerMain;

    public FirstWorld() {
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

        finishLine.setNextLevel(2);

        Point pointOne = new Point(this, new Vec2(-17f, -4f));
        Point pointTwo = new Point(this, new Vec2(17.5f, 7.5f));
        Point pointThree = new Point(this, new Vec2(0f, 3f));
    }

    private void CreateBoundary() {

        Platform groundOne = new Platform(this, new BoxShape(12f, 1.5f));
        groundOne.SetType("ground",0);
        groundOne.setPosition(new Vec2(-12f, -13f));

        Platform groundTwo = new Platform(this, new BoxShape(13f, 1.5f));
        groundTwo.SetType("ground",0);
        groundTwo.setPosition(new Vec2(12f, -13f));


        Platform[] defaultContainers = new Platform[11];

        for(int i = 0; i < defaultContainers.length; i++) {
            defaultContainers[i] = new Platform(this, new BoxShape(1.5f, 1.5f));
        }

        defaultContainers[0].setPosition(new Vec2(-6f, 0f));
        defaultContainers[0].SetType("independent", 1);

        defaultContainers[1].setPosition(new Vec2(-3f, 0f));
        defaultContainers[1].SetType("independent", 1);

        defaultContainers[2].setPosition(new Vec2(0f, 0f));
        defaultContainers[2].SetType("independent", 2);

        defaultContainers[3].setPosition(new Vec2(3f, 0f));
        defaultContainers[3].SetType("independent", 4);

        defaultContainers[4].setPosition(new Vec2(6f, 0f));
        defaultContainers[4].SetType("independent", 4);


        defaultContainers[5].setPosition(new Vec2(-23f, -7.5f));
        defaultContainers[5].SetType("independent", 1);

        defaultContainers[6].setPosition(new Vec2(-20f, -7.5f));
        defaultContainers[6].SetType("independent", 1);

        defaultContainers[7].setPosition(new Vec2(-17f, -7.5f));
        defaultContainers[7].SetType("independent", 2);

        defaultContainers[8].setPosition(new Vec2(-14f, -7.5f));
        defaultContainers[8].SetType("independent", 4);

        defaultContainers[9].setPosition(new Vec2(-11f, -7.5f));
        defaultContainers[9].SetType("independent", 4);


        defaultContainers[10].setPosition(new Vec2(17.5f, 4f));
        defaultContainers[10].SetType("independent", 2);

    }
    public Student getStudent() {
        return student;
    }

    public Tracker getTracker() { return trackerMain;}

    public String getBackground() { return "data/img/background1.gif"; }

}