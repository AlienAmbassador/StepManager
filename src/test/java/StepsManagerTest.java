import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StepsManagerTest {
    StepsManager stepsManager = new StepsManager();

    @Test
    public void addStepsInDict() {
        stepsManager.add(4, 2000);
        int actual = stepsManager.add(4, 1000);
        int expected = 2000;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ifMaxStepsReached() {
        stepsManager.add(5, 4500);
        int actual = stepsManager.add(5, 1000);
        int expected = -500;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addedStepsSeveralTimes() {
        for (int i = 0; i < 9; i++) {
            stepsManager.add(6, 500);
        }
        int actual = stepsManager.add(6, 500);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}
