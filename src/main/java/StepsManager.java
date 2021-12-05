import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;


public class StepsManager implements Comparable<StepsManager> {
    private List<Integer> stat = new ArrayList<>();

    public int getCnt(int day) {
        if (day < 1 || day > stat.size()) {
            return -1;
        }
        return stat.get(day - 1);
    }

    public List<Integer> getCNT() {
        return stat;
    }

    public void addSteps(int steps) {
        if (steps >= 0) {
            stat.add(steps);
        }
    }

    public void add(int day, int steps) {
        if ((day > stat.size() || day < 1) || steps < 0)
            return;
        int maxDay = stat.get(getMaxDay() - 1);
        stat.set(day - 1, stat.get(day - 1) + steps);
    }

    public int getMaxDay() {
        int maxDay = 0;
        for (int i = 0; i < stat.size(); i++) {
            if (stat.get(i) > stat.get(maxDay)) {
                maxDay = i;
            }
        }
        return maxDay + 1;
    }

    @Override
    public int compareTo(StepsManager o) {
        int firstStepManager = 0;
        int secondStepManager = 0;
        for (int i : stat) {
            firstStepManager += i;
        }
        for (int i : o.getCNT()) {
            secondStepManager += i;
        }
        return firstStepManager - secondStepManager;
    }

    public Stream<Integer> getAllAbove(int steps) {
        return stat.stream().filter(i -> i > steps);
    }

}
