package baseball.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import static baseball.constant.MessageConst.*;
import static baseball.constant.NumberConst.*;


public class InputValidation {



    public List<Integer>validateInputNum(String input){
        validateInputLength(input);
        List<Integer>inputNums = changeStrToSList(input);
        validateInputDuplicated(inputNums);
        validateInputRange(inputNums);

        return inputNums;
    }


    //input->stream
    private List<Integer>changeStrToSList(String input){
        return Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

    }
    //길이
    public void validateInputLength(String input){
        if(input.length() > 3){
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION);
        }
    }
    //범위
    public void validateInputRange(List<Integer> inputNums){
       boolean checkRange = inputNums.stream().allMatch(num -> FIRST_RANGE <= num && num <= LAST_RANGE );
       if(!checkRange){
           throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION);
       }

    }
    //중복
    public void validateInputDuplicated(List<Integer>inputNums){
       if(inputNums.stream().distinct().count() != INPUT_LENGTH){
           throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION);
       }
    }
    public static void validateGameControlInput(int input) {
        if (input < RESTART_NUM || input > EXIT_NUM) {
            throw new IllegalArgumentException(GAME_CONTROL_EXCEPTION_MSG);
        }

    }
}
