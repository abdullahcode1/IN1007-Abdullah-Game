package game;

import city.cs.engine.BoxShape;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class MainWorld extends World {
    final Student student;
    private Tracker trackerMain;

    public MainWorld() {
        super();
        //init ground
        Populate();
        //make a character (with an overlaid image)
        student = new Student(this);
        student.setPosition(new Vec2(-18f, 6f));
        student.setReturnPosition(new Vec2(-12f, -6f));
        CollisionHandler obstacleMain = new CollisionHandler(student);
        student.addCollisionListener(obstacleMain);
        trackerMain = new Tracker(Game.getView(), this.getStudent());

        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(-15.5f, -8f));
        EnemyController enemyOneController = new EnemyController(enemy);
        enemy.addCollisionListener(enemyOneController);

        Enemy secondEnemy = new Enemy(this);
        secondEnemy.setPosition(new Vec2(3.5f, -8f));
        EnemyController secondEnemyController = new EnemyController(secondEnemy);
        enemy.addCollisionListener(secondEnemyController);
        this.addStepListener(trackerMain);

    }

    private void Populate() {

        FinishLine finishLine = new FinishLine(this, new BoxShape(0.66f, 2f));
        finishLine.setPosition(new Vec2(15f, -6f));
        CreateBoundary();


        Point pointOne = new Point(this, new Vec2(-9f, -6f));
        Point pointTwo = new Point(this, new Vec2(17.5f, 7.5f));
    }

        private void CreateBoundary() {

            Platform groundOne = new Platform(this, new BoxShape(10f, 1.5f));
            groundOne.SetType("ground",0);
            groundOne.setPosition(new Vec2(-10f, -10.5f));

            Platform groundTwo = new Platform(this, new BoxShape(10f, 1.5f));
            groundTwo.SetType("ground",0);
            groundTwo.setPosition(new Vec2(10f, -10.5f));

            Platform roofOne = new Platform(this, new BoxShape(10f, 1f));
            roofOne.setPosition(new Vec2(0f, 13f));

            Platform[] defaultContainers = new Platform[25];

            for(int i = 0; i < defaultContainers.length; i++) {
                defaultContainers[i] = new Platform(this, new BoxShape(1.5f, 1.5f));
            }

            defaultContainers[0].setPosition(new Vec2(-12.5f, -1f));
            defaultContainers[0].SetType("independent", 1);

            defaultContainers[1].setPosition(new Vec2(-9.5f, -1f));
            defaultContainers[1].SetType("independent", 2);

            defaultContainers[2].setPosition(new Vec2(-6.5f, -1f));
            defaultContainers[2].SetType("independent", 4);

            defaultContainers[10].setPosition(new Vec2(-18.5f, 4.5f));
            defaultContainers[10].SetType("platform-edge-right-single", 0);

            defaultContainers[15].setPosition(new Vec2(0f,-7.5f));
            defaultContainers[15].SetType("wall", 1);
            defaultContainers[15].setBoundary(true);

            defaultContainers[16].setPosition(new Vec2(-21.5f,-7.5f));
            defaultContainers[16].SetType("wall", 1);
            defaultContainers[16].setBoundary(true);

            defaultContainers[17].setPosition(new Vec2(9.5f, 2f));
            defaultContainers[17].SetType("independent", 1);

            defaultContainers[18].setPosition(new Vec2(12.5f, 2f));
            defaultContainers[18].SetType("independent", 2);

            defaultContainers[19].setPosition(new Vec2(15.5f, 2f));
            defaultContainers[19].SetType("independent", 4);
        }
    public Student getStudent() {
        return student;
    }

    public Tracker getTracker() { return trackerMain;}


}