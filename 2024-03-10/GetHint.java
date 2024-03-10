package haiwaitu.t20240310;

/**
 * @Author huangjunqiao
 * @Date 2024/03/10 20:24
 * @Description 299. 猜数字游戏
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        // 时间：O(n)，空间：O(1)
        int n = guess.length();
        int bull = 0, cow = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                cntS[secret.charAt(i) - '0']++;
                cntG[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(cntS[i], cntG[i]);
        }
        return bull + "A" + cow + "B";
    }
}
