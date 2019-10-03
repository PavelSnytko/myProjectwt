package Thread;
import java.util.*;
import java.util.stream.Collectors;
public class Rubbish_Dump implements RubbishDump {
    private static Rubbish_Dump instance = null;
    public Map<RobotDetails, Integer> robotDetails = new HashMap<>();


    private Rubbish_Dump() {
        RobotDetails[] robotDetailsEnum = RobotDetails.values();
        for (int i = 0; i < robotDetailsEnum.length; i++) {
            this.robotDetails.put(robotDetailsEnum[i], 0);
        }
    }

    public static Rubbish_Dump getInstance() {
        if (instance == null) {
            instance = new Rubbish_Dump();
        }
        return instance;
    }


    @Override
    public void putRubbish(Enum rubbish) {
        this.robotDetails.put((RobotDetails) rubbish, this.robotDetails.get(rubbish) + 1);
    }

    @Override
    public Enum getRubbish() {
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
