package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    private static final int START_NUMBER = 1;

    private static final int CLAP_THREE = 3;
    private static final int CLAP_SIX = 6;
    private static final int CLAP_NINE = 9;


    public static int solution(int number) {
        final int END_NUMBER = number + 1;
        return IntStream.range(START_NUMBER, END_NUMBER)
                .map(Problem3::countClap)
                .sum();
    }

    private static int countClap(int number) {
        int count = 0;
        while(number != 0) {
            int digit = findFirstDigit(number);
            count = countValidCondition(count, digit);
            number = removeFirstDigit(number);
        }
        return count;
    }

    private static int removeFirstDigit(int number) {
        return number /= 10;
    }

    private static int findFirstDigit(int number) {
        return number % 10;
    }

    private static int countValidCondition(int count, int digit) {
        if (digit == CLAP_THREE || digit == CLAP_SIX || digit == CLAP_NINE) {
            count++;
        }
        return count;
    }
}
