package game;

public class Levels {
    int levelNumber;
    Student currentStudent;

    public Levels() {}

    public void loadLevel(GameView view, int level) {
        view.getWorld().stop();
        if (level == 1) {
            MainWorld firstWorld = new MainWorld();
            currentStudent = firstWorld.getStudent();
            view.setWorld(firstWorld);
        } else if (level == 2) {
            SecondWorld secondWorld = new SecondWorld();
            currentStudent = new SecondWorld().getStudent();
            view.setWorld(secondWorld);
        }
        view.addKeyListener(new StudentController(currentStudent));
        view.getWorld().start();
    }

    public void unloadLevel(GameView view) {
        view.getWorld().stop();
    }

    public void setCurrentLevel(int newLevelNumber) {
        levelNumber = newLevelNumber;
        unloadLevel(Game.getView());
        loadLevel(Game.getView(), levelNumber);
    }

    public void resetLevel() {
        currentStudent.getCollectedFlippers()
                .stream()
                .filter(n -> !n.getState())
                .forEach(n -> n.setState(false));
    }

    public void deadStudent() {
        setCurrentLevel(1);
    }
}
