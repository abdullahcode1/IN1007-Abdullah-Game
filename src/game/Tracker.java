package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Student student;

    public Tracker(GameView view, Student student) {
        this.view = view;
        this.student = student;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.getGameViewCentre(student.getPosition());
        student.stateManager(student.getLinearVelocity());

    }
}