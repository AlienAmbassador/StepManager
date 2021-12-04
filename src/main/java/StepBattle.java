import java.util.ArrayList;
import java.util.List;

public class StepBattle {
   private StepsManager firstPlayer;
   private StepsManager secondPlayer;


    public void addSteps(int player, int day, int steps) {
        if (player == 1) {
            firstPlayer.add(day, steps);
        }
        if (player == 2) {
            secondPlayer.add(day, steps);
        }

    }

    public int winner() {
        int firstCnt = 0;
        int secondCnt = 0;
        for (int i : firstPlayer.getCNT()){
            firstCnt += i;
        }
        for (int i : secondPlayer.getCNT()){
            secondCnt += i;
        }
        if (firstCnt > secondCnt){
            return 1;
        }if (firstCnt < secondCnt){
            return 2;
        }else{
            return 0;
        }
    }
}
