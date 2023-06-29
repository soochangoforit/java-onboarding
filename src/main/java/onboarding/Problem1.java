package onboarding;

import java.util.List;

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

        return 0;
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