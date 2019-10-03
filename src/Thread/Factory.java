package Thread;
import java.util.Random;

public class Factory extends Thread {
    private RubbishDump rubbishDump;
    int nightCount;

    public Factory(RubbishDump rubbishDump, int nightCount) {
        this.rubbishDump = rubbishDump;
        this.nightCount = nightCount;
        throwsDetailsToRubbishDump(20);
    }

    public void throwsDetailsToRubbishDump(int detailsCount) {
        Random rm = new Random();
        RobotDetails[] robotDetailsEnum = RobotDetails.values();

        for (int i = 0; i < detailsCount; i++) {
            this.rubbishDump.putRubbish(robotDetailsEnum[rm.nextInt(robotDetailsEnum.length)]);
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

            Integer num = rm.nextInt(4) + 1;
            System.out.println(String.format("Factory throws %d details", num));
            throwsDetailsToRubbishDump(num);
        }
    }
}
