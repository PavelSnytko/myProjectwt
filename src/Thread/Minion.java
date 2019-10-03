package Thread;
import java.util.*;
public class Minion extends Thread{
    private Map<RobotDetails, Integer> robotDetailsStorage = new HashMap<>();

    private RubbishDump rubbishDump;
    private int createdRobotsCount = 0;
    private int nightCount;

    public Minion(RubbishDump rubbishDump, int nightCount) {
        this.rubbishDump = rubbishDump;
        this.nightCount = nightCount;

        RobotDetails[] robotDetailsEnum = RobotDetails.values();
        for (int i = 0; i < robotDetailsEnum.length; i++) {
            this.robotDetailsStorage.put(robotDetailsEnum[i], 0);
        }
    }

    public int getCreatedRobotsCount() {
        return createdRobotsCount;
    }

    private void tryToCreateRobot() {
        boolean isRobotCreated = true;

        for (Map.Entry<RobotDetails, Integer> rd : robotDetailsStorage.entrySet()) {
            if (rd.getValue() <= 0) {
                isRobotCreated = false;
                break;
            }
        }

        if (isRobotCreated) {
            createRobot();
        }
    }

    private void createRobot() {
        for (Map.Entry<RobotDetails, Integer> item : robotDetailsStorage.entrySet()) {
            robotDetailsStorage.put(item.getKey(), item.getValue() - 1);
        }
        createdRobotsCount++;
    }

    public void getRobotDetailsFromRubbishDump(int detailsCount) {
        for (int i = 0; i < detailsCount; i++) {
            RobotDetails rd = (RobotDetails) this.rubbishDump.getRubbish();
            if (rd == null) {
                continue;
            } else {
                this.robotDetailsStorage.put(rd, robotDetailsStorage.get(rd) + 1);
            }
        }
    }

    @Override
    public void run() {
        Random rm = new Random();
        for (int i = 0; i < nightCount; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }

            getRobotDetailsFromRubbishDump(rm.nextInt(4) + 1);
            System.out.println("Minions details: " + robotDetailsStorage);
            System.out.println("Try to create robot");
            tryToCreateRobot();
        }
    }
}
