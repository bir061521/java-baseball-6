package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerUtil {


    public List<Integer> generateNumber(){
        List<Integer>computerNums = new ArrayList<>();

        while(computerNums.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNums.contains(randomNumber)){
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }
}
