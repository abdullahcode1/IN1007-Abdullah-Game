package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

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
            int nextLevel = ((FinishLine) e.getOtherBody()).getNextLevel();
            Game.getLevels().loadLevel(Game.getView(), nextLevel);
        }
    }
}
