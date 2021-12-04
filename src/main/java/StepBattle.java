import java.util.ArrayList;
import java.util.List;

public class StepBattle {
    private List<StepsManager> firstPlayer = new ArrayList<>();
    private List<StepsManager> secondPlayer = new ArrayList<>();

    private int sumCnt1;
    private int sumCnt2;

    public StepsManager manager;

    public StepBattle(StepsManager manager) {
        this.manager = manager;
    }

    public void addSteps(int player, int day, int steps) {
        if (player == 1) {
            firstPlayer.add(new StepsManager(day, steps));
        }
        if (player == 2) {
            secondPlayer.add(new StepsManager(day, steps));
        }

    }

    public int winner() {
        for (StepsManager day : firstPlayer) {
            sumCnt1 += day.getCnt();
        }
        for (StepsManager day : secondPlayer) {
            sumCnt2 += day.getCnt();
        }
        if (sumCnt2 > sumCnt1) {
            return 2;
        } else if (sumCnt1 == sumCnt2) {
            return 0;
        } else {
            return 1;
        }
    }
}
