import java.util.*;

public class MinimumRounds {
    public int minimumRounds(int[] tasks) {
        // 贪心，时间：O(n)，空间O:(n)
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int task : tasks) {
            cnt.put(task, cnt.getOrDefault(task, 0) + 1);
        }
        int round = 0;
        for (int num : cnt.values()) {
            if (num == 1) {
                return -1;
            }
            if (num % 3 == 0) {
                round += num / 3;
            } else {
                round += 1 + num / 3;
            }
        }
        return round;
    }
}
