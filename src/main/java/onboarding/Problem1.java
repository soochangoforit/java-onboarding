package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    private static final int RESULT_ERROR = -1;
    private static final int RESULT_POBI_WIN = 1;
    private static final int RESULT_CRONG_WIN = 2;
    private static final int RESULT_DRAW = 0;

    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int PAGE_COUNT = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotValid(pobi, crong)){
            return RESULT_ERROR;
        }

        int pobiNum = getMaxNum(pobi);
        int crongNum = getMaxNum(crong);

        return findResult(pobiNum, crongNum);
    }

    private static int findResult(int pobiNum, int crongNum) {
        if (pobiNum > crongNum) {
            return RESULT_POBI_WIN;
        }

        if (pobiNum < crongNum) {
            return RESULT_CRONG_WIN;
        }

        return RESULT_DRAW;
    }

    private static boolean isNotValid(List<Integer> pobi, List<Integer> crong) {
        if(isNotTwoPages(pobi) || isNotTwoPages(crong)){
            return true;
        }

        if (isNotLeftPageRange(pobi) || isNotRightPageRange(crong)){
            return true;
        }

        if(isLeftBiggerThanRight(pobi) || isLeftBiggerThanRight(crong)){
            return true;
        }

        if (isNotContinuous(pobi) || isNotContinuous(crong)){
            return true;
        }

        if (isLeftNotOdd(pobi) || isLeftNotOdd(crong)){
            return true;
        }

        return false;
    }

    private static int getMaxNum(List<Integer> pages) {
        int leftSumResult = getSum(pages.get(LEFT_PAGE_INDEX));
        int leftMultiplicationResult = getMultiplication(pages.get(LEFT_PAGE_INDEX));
        int rightSumResult = getSum(pages.get(RIGHT_PAGE_INDEX));
        int rightMultiplicationResult = getMultiplication(pages.get(RIGHT_PAGE_INDEX));

        int leftLargerNumber = Math.max(leftSumResult, leftMultiplicationResult);
        int rightLargerNumber = Math.max(rightSumResult, rightMultiplicationResult);

        return Math.max(leftLargerNumber, rightLargerNumber);
    }

    private static int getSum(int number) {
        int result = 0;

        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }

    private static int getMultiplication(int number) {
        int result = 1;

        while (number != 0) {
            result *= number % 10;
            number /= 10;
        }

        return result;
    }

    private static boolean isNotTwoPages(List<Integer> pages) {
        return pages.size() != PAGE_COUNT;
    }

    private static boolean isNotContinuous(List<Integer> pages) {
        return pages.get(RIGHT_PAGE_INDEX) - pages.get(LEFT_PAGE_INDEX) != 1;
    }

    private static boolean isLeftBiggerThanRight(List<Integer> pages) {
        return pages.get(LEFT_PAGE_INDEX) > pages.get(RIGHT_PAGE_INDEX);
    }

    private static boolean isLeftNotOdd(List<Integer> pages) {
        return pages.get(LEFT_PAGE_INDEX) % 2 == 0;
    }

    private static boolean isNotLeftPageRange(List<Integer> pages) {
        return pages.get(LEFT_PAGE_INDEX) < 1 || pages.get(LEFT_PAGE_INDEX) > 399;
    }

    private static boolean isNotRightPageRange(List<Integer> pages) {
        return pages.get(RIGHT_PAGE_INDEX) < 2 || pages.get(RIGHT_PAGE_INDEX) > 400;
    }
}