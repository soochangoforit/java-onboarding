package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char getGreenFrogChar(char originChar) {
        if(Character.isAlphabetic(originChar)){
            return convertGreenFrogChar(originChar);
        }
        return originChar;
    }

    private static char convertGreenFrogChar(char originChar) {
        if(Character.isUpperCase(originChar)){
            return convertGreenFrogUpperCase(originChar);
        }
        return convertGreenFrogLowerCase(originChar);
    }

    private static char convertGreenFrogLowerCase(char originChar) {
        return (char) ('a' + ('z' - originChar));
    }

    private static char convertGreenFrogUpperCase(char originChar) {
        return (char) ('A' + ('Z' - originChar));
    }
}
