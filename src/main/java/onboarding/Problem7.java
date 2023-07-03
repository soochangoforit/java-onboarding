package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = converToFriendMap(friends);
        Map<String, Integer> scoreMap = calculateFriendsScore(user, friendsMap);
        plusOnePointToVisitors(visitors, scoreMap);

        return getTopFive(user, friendsMap, scoreMap);
    }

    private static List<String> getTopFive(String user, Map<String, List<String>> friendsMap, Map<String, Integer> scoreMap) {
        return scoreMap.keySet()
                .stream()
                .filter(friend -> isNotUser(user, friend))
                .filter(friend -> isNotUserFriend(user, friendsMap, friend))
                .sorted(highestScoreFirst(scoreMap))
                .limit(5)
                .collect(Collectors.toList());
    }

    private static Comparator<String> highestScoreFirst(Map<String, Integer> scoreMap) {
        return (friend1, friend2) -> {
            if (isSameScore(scoreMap, friend1, friend2)) {
                return friend1.compareTo(friend2);
            }
            return scoreMap.get(friend2) - scoreMap.get(friend1);
        };
    }

    private static boolean isSameScore(Map<String, Integer> scoreMap, String friend1, String friend2) {
        return scoreMap.get(friend1).equals(scoreMap.get(friend2));
    }

    private static boolean isNotUser(String user, String friend) {
        return !friend.equals(user);
    }

    private static boolean isNotUserFriend(String user, Map<String, List<String>> friendsMap, String friend) {
        return !friendsMap.get(user).contains(friend);
    }

    private static void plusOnePointToVisitors(List<String> visitors, Map<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            Integer score = scoreMap.getOrDefault(visitor, 0);
            scoreMap.put(visitor, score + 1);
        }
    }

    private static Map<String, Integer> calculateFriendsScore(String user, Map<String, List<String>> friendsMap) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for (String userFriend : friendsMap.get(user)) {
            plusTenPoint(scoreMap, friendsMap.get(userFriend), user);
        }
        return scoreMap;
    }

    private static void plusTenPoint(Map<String, Integer> scoreMap, List<String> friends, String mainUser) {
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
            friendsMap.computeIfAbsent(friend1, k -> new ArrayList<>()).add(friend2);
            friendsMap.computeIfAbsent(friend2, k -> new ArrayList<>()).add(friend1);
        }
        return friendsMap;
    }
}
