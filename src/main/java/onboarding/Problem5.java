package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(Money m : Money.highestOrder()) {
            int count = money / m.value;
            answer.add(count);
            money -= m.value * count;
        }
        return answer;
    }

    enum Money {
        _50000_won(50000),
        _10000_won(10000),
        _5000_won(5000),
        _1000_won(1000),
        _500_won(500),
        _100_won(100),
        _50_won(50),
        _10_won(10),
        _1_won(1);

        private final int value;

        Money(int value) {
            this.value = value;
        }

        public static List<Money> highestOrder() {
            return Arrays.stream(values())
                    .sorted((o1, o2) -> o2.value - o1.value)
                    .collect(Collectors.toList());
        }
    }
}
