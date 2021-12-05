import java.util.Comparator;
import java.util.List;

public class StepsComparator implements Comparator<StepsManager> {
    private int minSteps = 0;

    public StepsComparator(int minSteps){
        this.minSteps = minSteps;
    }

    @Override
    public int compare(StepsManager firstManager, StepsManager secondManager) {
        List<Integer> firstList = firstManager.getCNT();
        List<Integer> secondList = secondManager.getCNT();
        int firstManagerDays = 0;
        int secondManagerDays = 0;

        for (int i : firstList){
            if (i > minSteps){
                firstManagerDays++;
            }
        }
        for (int i : secondList) {
            if (i > minSteps) {
                secondManagerDays++;
            }
        }
        return firstManagerDays - secondManagerDays;
    }
}

