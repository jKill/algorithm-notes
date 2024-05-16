import java.util.Arrays;

public class FindMinimumTime {
    public int findMinimumTime(int[][] tasks) {
        // 1、按结束时间排序
        int res = 0;
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        // 2、构造run数组，记录哪些时间点有任务在跑
        int[] run = new int[tasks[n - 1][1] + 1];
        for (int[] task : tasks) {
            // 3、 [start,end]内有在跑的时间t比当前duration大，则放到已经在跑的时间一起跑，尽可能利用同时跑的优势
            int start = task[0], end = task[1], duration = task[2];
            for (int j = start; j <= end; j++) {
                duration -= run[j];
            }
            // 4、 若比duation小，则将用完t后，将剩余的duration-t尽可能往后排，使得更有希望和后面的任务重合
            duration = Math.max(0, duration);
            for (int j = end; j >= 0 && duration > 0; j--) {
                if (run[j] == 0) {
                    duration--;
                    run[j] = 1;
                    res++;
                }
            }
        }
        return res;
    }
}
