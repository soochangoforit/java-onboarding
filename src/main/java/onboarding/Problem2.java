package onboarding;

import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            String removedDuplicate = removeDuplicate(cryptogram);
            if (removedDuplicate.equals(cryptogram)) {
                return cryptogram;
            }
            cryptogram = removedDuplicate;
        }
    }

    private static String removeDuplicate(String cryptogram) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, cryptogram.length()).forEach(currentIdx -> {
            if (!duplicatedWithLeft(cryptogram, currentIdx) && !duplicatedWithRight(cryptogram, currentIdx)) {
                result.append(cryptogram.charAt(currentIdx));
            }
        });
        return result.toString();
    }

    private static boolean duplicatedWithRight(String cryptogram, int curIdx) {
        if (curIdx == cryptogram.length() - 1) {
            return false;
        }
        return cryptogram.charAt(curIdx) == cryptogram.charAt(curIdx + 1);
    }

    private static boolean duplicatedWithLeft(String cryptogram, int curIdx) {
        if (curIdx == 0) {
            return false;
        }
        return cryptogram.charAt(curIdx) == cryptogram.charAt(curIdx - 1);
    }
}