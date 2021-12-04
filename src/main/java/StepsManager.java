import java.util.HashMap;

public class StepsManager {
    private int cnt;
    private HashMap<Integer, Integer> stat = new HashMap<>();

    public StepsManager(int day, int steps) {
        stat.put(day, steps);
        this.cnt = steps;
    }

    public int getCnt() {
        return cnt;
    }

}
