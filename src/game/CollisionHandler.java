package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import obstacle.Obstacle;

public class CollisionHandler implements CollisionListener {

    private final Student student;
    public CollisionHandler(Student s) {
        this.student = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Obstacle) {
            student.Respawn();
        } else if (e.getOtherBody() instanceof Point) {

            student.stateManager(student.getLinearVelocity());
            student.addCollectedFlippers((Point) e.getOtherBody());

        } else if (e.getOtherBody() instanceof FinishLine) {
            e.getOtherBody().destroy();
            student.destroy();
            Game.getLevels().loadLevel(Game.getView(), ((FinishLine) e.getOtherBody()).getNextLevel());
        }
    }
}
