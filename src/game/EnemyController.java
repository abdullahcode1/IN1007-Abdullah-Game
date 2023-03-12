package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class EnemyController implements CollisionListener {

    private final Enemy collidedEnemy;

    public EnemyController(Enemy c) {
        collidedEnemy = c;
    }


    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Platform) {
            Platform targetPlatform = (Platform) collisionEvent.getOtherBody();
            if (targetPlatform.getBoundary()) {
                collidedEnemy.SwitchDirection();
            }
        } else if (collisionEvent.getOtherBody() instanceof Student) {
            ((Student) collisionEvent.getOtherBody()).Respawn();
        }


    }
}