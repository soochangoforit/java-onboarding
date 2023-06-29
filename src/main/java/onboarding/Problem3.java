package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int num = 1; num <= number; num++) {
            answer += getCountOfThreeOrSixOrNine(num);
        }
        return answer;
    }

    private static int getCountOfThreeOrSixOrNine(int number) {
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
        if (digit == 3 || digit == 6 || digit == 9) {
            count++;
        }
        return count;
    }
}
