package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Problem6 {
    private static final String KOREAN_REGEX = "^[가-힣]*$";
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 20;
    private static final String EMAIL_DOMAIN = "@email.com";
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final int EMAIL_IDX = 0;
    private static final int NICKNAME_IDX = 1;

    public static List<String> solution(List<List<String>> forms) {

        final HashMap<String, List<String>> twoLetters = new HashMap<>();

        forms.stream()
                .filter(form -> isValidEmail(extractEmail(form)) && isValidNickName(extractNickName(form)))
                .forEach(form -> addWordsFromNickName(twoLetters, extractEmail(form), extractNickName(form)));


        return twoLetters.values().stream()
                .filter(emails -> emails.size() >= 2)
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .collect(toList());
    }

    private static boolean hasWordDuplicated(List<String> emails) {
        return emails.size() >= 2;
    }

    private static void addWordsFromNickName(HashMap<String, List<String>> twoLetters, String email, String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String word = nickName.substring(i, i + 2);
            twoLetters.computeIfAbsent(word, k -> new ArrayList<>()).add(email);
        }
    }

    private static String extractNickName(List<String> form) {
        return form.get(NICKNAME_IDX);
    }

    private static String extractEmail(List<String> form) {
        return form.get(EMAIL_IDX);
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

    private static boolean isValidEmail(String email) {
        return endedWithDomain(email) && inEmailLengthRange(email);
    }

    private static boolean inEmailLengthRange(String email) {
        int emailLength = email.length();
        return emailLength >= MIN_EMAIL_LENGTH && emailLength < MAX_EMAIL_LENGTH;
    }

    private static boolean endedWithDomain(String email) {
        return email.endsWith(EMAIL_DOMAIN);
    }
}
