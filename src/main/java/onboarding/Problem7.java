package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = converToFriendMap(friends);
        Map<String, Integer> scoreMap = calculateFriendsScore(user, friendsMap);

        return answer;
    }

    private static Map<String, Integer> calculateFriendsScore(String user, Map<String, List<String>> friendsMap) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for (String userFriend : friendsMap.get(user)) {
            plusTenPoint(scoreMap, friendsMap.get(userFriend));
        }
        return scoreMap;
    }

    private static void plusTenPoint(Map<String, Integer> scoreMap, List<String> friends) {
        for(String friend : friends) {
            Integer score = scoreMap.getOrDefault(friend, 0);
            scoreMap.put(friend, score + 10);
        }
    }

    private static HashMap<String, List<String>> converToFriendMap(List<List<String>> friends) {
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
