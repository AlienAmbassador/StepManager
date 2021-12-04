import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class StepsManagerTest {
    StepsManager stepsManager = mock(StepsManager.class);
    StepBattle stepBattle = new StepBattle(stepsManager);


    @BeforeEach
    public void playInit() {
        stepBattle.addSteps(1, 1, 10000);
        stepBattle.addSteps(2, 3, 4000);
        stepBattle.addSteps(1, 2, 8000);
        stepBattle.addSteps(2, 4, 10000);
    }

    @Test
    public void playWinner() {
        int expected = 1;
        int actual = stepBattle.winner();

        Assertions.assertEquals(expected, actual);
    }
}

