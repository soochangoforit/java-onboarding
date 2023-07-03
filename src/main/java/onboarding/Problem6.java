package onboarding;

import java.util.List;

public class Problem6 {
    private static final String KOREAN_REGEX = "^[가-힣]*$";
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 20;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isValidNickName(String nickName) {
        return hasOnlyKorean(nickName) && inNickNameLengthRange(nickName);
    }

    private static boolean inNickNameLengthRange(String nickName) {
        int nickNameLength = nickName.length();
        return nickNameLength >= MIN_NICKNAME_LENGTH && nickNameLength < MAX_NICKNAME_LENGTH;
    }

    private static boolean hasOnlyKorean(String nickName) {
        return nickName.matches(KOREAN_REGEX);
    }
}
