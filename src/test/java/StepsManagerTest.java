import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class StepsManagerTest {
    StepsManager firstManager = new StepsManager();
    StepsManager secondManager = new StepsManager();
    StepsManager thirdManager = new StepsManager();

    @ParameterizedTest
    @CsvSource({"7000, 12000, 17000, -1", "8000, 8000, 16000, 0", "13000, 6000, 8000, 1"})
    public void checkComparator(int steps1, int steps2, int min, int expected) {
        StepsComparator comp = new StepsComparator(min);

        firstManager.addSteps(steps1);
        firstManager.addSteps(steps1 + 7000);
        firstManager.addSteps(steps1 + 12000);

        secondManager.addSteps(steps2);
        secondManager.addSteps(steps2 + 7000);
        secondManager.addSteps(steps2 + 12000);

        int actual = comp.compare(firstManager, secondManager);
        Assertions.assertEquals(expected, actual, "PedometerManagerDaysComparator class");
    }

    @Test
    public void stepsBelowZero() {
        StepsManager stepsManager = new StepsManager();
        Assertions.assertThrows(IllegalStepsException.class, () -> stepsManager.add(5, -300));
    }
    
    @Test
    public void dayTooBigValue() {
        StepsManager stepsManager = new StepsManager();
        Assertions.assertThrows(IllegalDayException.class, () -> stepsManager.add(367, 5000));
    }

    @Test
    public void dayBelowZero() {
        StepsManager stepsManager = new StepsManager();
        Assertions.assertThrows(IllegalDayException.class, () -> stepsManager.add(-1, 7000));
    }


}
