import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;


public class StepsManager implements Comparable<StepsManager> {
    private List<Integer> stat = new ArrayList<>();

    public int getCnt(int day) {
        if (day < 1 || day > 365) {
            throw new IllegalDayException(day);
        }
        return day > stat.size() ? -1 : stat.get(day - 1);
    }

    public List<Integer> getCNT() {
        return stat;
    }

    public void addSteps(int steps) {
        if (steps < 0) {
            throw new IllegalStepsException(steps);
        }
        stat.add(steps);
    }

    public int add(int day, int steps) {
        if (day < 1 || day > 365) {
            throw new IllegalDayException(day);
        }
        if (steps < 0) {
            throw new IllegalStepsException(steps);
        }
        if (day > stat.size()) {
            return -1;
        }
        int maxDay = stat.get(getMaxDay() - 1);
        stat.set(day - 1, stat.get(day - 1) + steps);
        return Math.max((maxDay - stat.get(day - 1)) + 1, 0);
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
        if (steps < 0){
            throw new IllegalStepsException(steps);
        }
        return stat.stream().filter(i -> i > steps);
    }

}
