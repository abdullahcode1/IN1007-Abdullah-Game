package game.worlds;

import city.cs.engine.BoxShape;
import city.cs.engine.World;
import game.*;
import org.jbox2d.common.Vec2;

public class SecondWorld extends World {

    final Student student;
    private Tracker trackerMain;

    public SecondWorld() {
        super();
        Populate();
        student = new Student(this);
        student.setPosition(new Vec2(0f, 3f));
        student.setReturnPosition(new Vec2(0f, 3f));
        CollisionHandler obstacleMain = new CollisionHandler(student);
        student.addCollisionListener(obstacleMain);
        trackerMain = new Tracker(Game.getView(), this.getStudent());

        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(-15.5f, -8f));
        EnemyController enemyController = new EnemyController(enemy);
        enemy.addCollisionListener(enemyController);
        this.addStepListener(trackerMain);

    }

    private void Populate() {
        FinishLine finishLine = new FinishLine(this, new BoxShape(0.66f, 2f));
        finishLine.setPosition(new Vec2(23f, -6.5f));
        CreateBoundary();

        finishLine.setNextLevel(3);

        Point pointOne = new Point(this, new Vec2(0f, -7f));
        Point pointTwo = new Point(this, new Vec2(-12.5f, 5f));
        Point pointThree = new Point(this, new Vec2(12.5f, 5f));
    }

    private void CreateBoundary() {

        Platform groundOne = new Platform(this, new BoxShape(12f, 1.5f));
        groundOne.SetType("ground",0);
        groundOne.setPosition(new Vec2(-12f, -13f));

        Platform groundTwo = new Platform(this, new BoxShape(12f, 1.5f));
        groundTwo.SetType("ground",0);
        groundTwo.setPosition(new Vec2(12f, -13f));



        Platform[] defaultContainers = new Platform[25];

        for(int i = 0; i < defaultContainers.length; i++) {
            defaultContainers[i] = new Platform(this, new BoxShape(1.5f, 1.5f));
        }

        defaultContainers[0].setPosition(new Vec2(-9.5f, 2f));
        defaultContainers[0].SetType("independent", 1);//done

        defaultContainers[1].setPosition(new Vec2(-12.5f, 2f));
        defaultContainers[1].SetType("independent", 2);//done

        defaultContainers[2].setPosition(new Vec2(-15.5f, 2f));
        defaultContainers[2].SetType("independent", 4);//done

        defaultContainers[16].setPosition(new Vec2(-23f,-10f));
        defaultContainers[16].SetType("wall", 1);
        defaultContainers[16].setBoundary(true); //done

        defaultContainers[17].setPosition(new Vec2(9.5f, 2f));
        defaultContainers[17].SetType("independent", 1);//done

        defaultContainers[18].setPosition(new Vec2(12.5f, 2f));
        defaultContainers[18].SetType("independent", 2);//done

        defaultContainers[19].setPosition(new Vec2(15.5f, 2f));
        defaultContainers[19].SetType("independent", 4);//done


        defaultContainers[20].setPosition(new Vec2(23f, -10f));
        defaultContainers[20].SetType("wall", 1);
        defaultContainers[20].setBoundary(true); //done

    }
    public Student getStudent() {
        return student;
    }

    public Tracker getTracker() { return trackerMain;}


    public String getBackground() { return "data/img/background2.gif"; }

}
