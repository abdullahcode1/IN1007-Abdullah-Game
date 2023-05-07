package game.worlds;

import city.cs.engine.BoxShape;
import city.cs.engine.World;
import game.*;
import org.jbox2d.common.Vec2;

public class ThirdWorld extends World {

    final Student student;
    private Tracker trackerMain;

    public ThirdWorld() {
        super();
        Populate();
        student = new Student(this);
        student.setPosition(new Vec2(0f, 3f));
        student.setReturnPosition(new Vec2(0f, 3f));
        CollisionHandler obstacleMain = new CollisionHandler(student);
        student.addCollisionListener(obstacleMain);
        trackerMain = new Tracker(Game.getView(), this.getStudent());

        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(-15.5f, -10f));
        EnemyController enemyController = new EnemyController(enemy);
        enemy.addCollisionListener(enemyController);

        Enemy secondEnemy = new Enemy(this);
        secondEnemy.setPosition(new Vec2(3.5f, -10f));
        EnemyController secondEnemyController = new EnemyController(secondEnemy);
        secondEnemy.addCollisionListener(secondEnemyController);

        Enemy thirdEnemy = new Enemy(this);
        thirdEnemy.setPosition(new Vec2(-15.5f, 5f));
        EnemyController thirdEnemyController = new EnemyController(thirdEnemy);
        thirdEnemy.addCollisionListener(thirdEnemyController);

        Enemy fourthEnemy = new Enemy(this);
        fourthEnemy.setPosition(new Vec2(15.5f, 5f));
        EnemyController fourthEnemyController = new EnemyController(fourthEnemy);
        fourthEnemy.addCollisionListener(fourthEnemyController);

        this.addStepListener(trackerMain);


    }

    private void Populate() {
        FinishLine finishLine = new FinishLine(this, new BoxShape(0.66f, 2f));
        finishLine.setPosition(new Vec2(23f, -6.5f));
        CreateBoundary();

        finishLine.setNextLevel(4); //There is no level 4 but to finish the game

        Point pointOne = new Point(this, new Vec2(0f, -7f));
        Point pointTwo = new Point(this, new Vec2(-15.5f, 7f));
        Point pointThree = new Point(this, new Vec2(15.5f, 7f));
        Point pointfour = new Point(this, new Vec2(-15f, -7.5f));
        Point pointfive = new Point(this, new Vec2(15f, -7.5f));

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

        defaultContainers[3].setPosition(new Vec2(-18.5f, 2f));
        defaultContainers[3].SetType("independent", 4);//done

        defaultContainers[4].setPosition(new Vec2(-21.5f, 2f));
        defaultContainers[4].SetType("independent", 4);//done

        defaultContainers[5].setPosition(new Vec2(-9.5f, 5f));
        defaultContainers[5].SetType("wall", 4);//done
        defaultContainers[5].setBoundary(true);

        defaultContainers[6].setPosition(new Vec2(0f, -10f));
        defaultContainers[6].SetType("wall", 4);
        defaultContainers[6].setBoundary(true);//done

        defaultContainers[8].setPosition(new Vec2(-21.5f, 5f));
        defaultContainers[8].SetType("wall", 1);//done
        defaultContainers[8].setBoundary(true);

        defaultContainers[10].setPosition(new Vec2(-23f,-10f));
        defaultContainers[10].SetType("wall", 1);
        defaultContainers[10].setBoundary(true); //done

        defaultContainers[11].setPosition(new Vec2(9.5f, 2f));
        defaultContainers[11].SetType("independent", 1);

        defaultContainers[12].setPosition(new Vec2(12.5f, 2f));
        defaultContainers[12].SetType("independent", 2);

        defaultContainers[13].setPosition(new Vec2(15.5f, 2f));
        defaultContainers[13].SetType("independent", 4);

        defaultContainers[14].setPosition(new Vec2(18.5f, 2f));
        defaultContainers[14].SetType("independent", 4);

        defaultContainers[15].setPosition(new Vec2(21.5f, 2f));
        defaultContainers[15].SetType("independent", 4);

        defaultContainers[16].setPosition(new Vec2(21.5f, 5f));
        defaultContainers[16].SetType("wall", 1);
        defaultContainers[16].setBoundary(true);

        defaultContainers[17].setPosition(new Vec2(9.5f, 5f));
        defaultContainers[17].SetType("wall", 1);
        defaultContainers[17].setBoundary(true);

        defaultContainers[20].setPosition(new Vec2(23f, -10f));
        defaultContainers[20].SetType("wall", 1);
        defaultContainers[20].setBoundary(true); //done

    }
    public Student getStudent() {
        return student;
    }

    public Tracker getTracker() { return trackerMain;}

    public String getBackground() { return "data/img/background3.gif"; }


}
