package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, List<String>> friendsMap = friendsMap(friends);

        return answer;
    }

    private static HashMap<String, List<String>> friendsMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            friendsMap.computeIfAbsent(friend1, k -> Collections.emptyList()).add(friend2);
            friendsMap.computeIfAbsent(friend2, k -> Collections.emptyList()).add(friend1);
        }
        return friendsMap;
    }
}
