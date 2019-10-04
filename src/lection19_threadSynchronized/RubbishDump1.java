package lection19_threadSynchronized;
import Thread.Rubbish_Dump;
import Thread.RobotDetails;

import java.util.*;
import java.util.stream.Collectors;

 class RubbishDump implements Thread.RubbishDump{
    private static Rubbish_Dump instance = null;
    public Map<RobotDetails, Integer> robotDetails = new HashMap<>();


    private RubbishDump1() {
        RobotDetails[] robotDetailsEnum = RobotDetails.values();
        for (int i = 0; i < robotDetailsEnum.length; i++) {
            this.robotDetails.put(robotDetailsEnum[i], 0);
        }
    }

    public static synchronized Rubbish_Dump getInstance() {
        if (instance == null) {
            instance = new RubbishDump1();
        }
        return instance;
    }


    @Override
    public synchronized void putRubbish(Enum rubbish) {
        this.robotDetails.put((RobotDetails) rubbish, this.robotDetails.get(rubbish) + 1);
    }

    @Override
    public synchronized Enum getRubbish() {
        List<RobotDetails> robotDetails = this.robotDetails.keySet()
                .stream()
                .filter((s) -> this.robotDetails.get(s) > 0)
                .collect(Collectors.toList());

        if(robotDetails.size() > 0){
            return robotDetails.get(new Random().nextInt(robotDetails.size()));
        }else{
            return null;
        }
    }
}
