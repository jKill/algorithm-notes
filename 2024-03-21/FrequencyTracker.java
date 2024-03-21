package haiwaitu.t20240321;

/**
 * @Author huangjunqiao
 * @Date 2024/03/21 19:59
 * @Description 2671. 频率跟踪器
 */
public class FrequencyTracker {
    // 双数组，add时间：O(1)，delete时间：O(1)，hasFrequency时间：O(1)，空间：O(n)
    int[] cnts;
    int[] freqCnts;
    public static final int MAX_NUM = 100 * 1000;
    public FrequencyTracker() {
        cnts = new int[MAX_NUM + 1];
        freqCnts = new int[MAX_NUM + 1];
    }

    public void add(int number) {
        freqCnts[cnts[number]]--;
        cnts[number]++;
        freqCnts[cnts[number]]++;
    }

    public void deleteOne(int number) {
        if (cnts[number] > 0) {
            freqCnts[cnts[number]]--;
            cnts[number]--;
            if (cnts[number] > 0) {
                freqCnts[cnts[number]]++;
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqCnts[frequency] > 0;
    }
}
