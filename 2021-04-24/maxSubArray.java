package haiwaitu.t20210424;

/**
 * @Author huangjunqiao
 * @Date 2021/04/24 16:32
 * @Description 53. 最大子序和
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
//         动态规划
//         int[] dp = new int[nums.length];
//         dp[0] = nums[0];
//         if (nums.length == 1) {
//             return dp[0];
//         }
//         int max = dp[0];
//         for (int i = 1; i < nums.length; i++) {
//             dp[i] = Math.max(nums[i], (dp[i - 1] + nums[i]));
//             max = dp[i] > max ? dp[i] : max;
//         }
//         return max;

        // 分治
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
             // 长度为1的子区间，lSum,rSum,iSum,mSum均为nums[l]的值
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        // 以中间为分界线，递归处理左右子区间
        int m = (l + r) >> 1;
        Status lStatus = getInfo(nums, l, m);
        Status rStatus = getInfo(nums,m + 1, r);
        // 实际计算lSum,rSum，mSum,iSum的值
        return pushUp(lStatus, rStatus);
    }

    /**
     * lSum可能是左子区间的lSum，也可能跨越了m点，为左子区间的iSum与右子区间lSum的和；
     * rSum可能是右子区间的rSum，也可能跨域了m点，为右子区间的iSum与左子区间rSum的和；
     * 在没跨越m点情况下，mSum可能是左子区间的mSum，也可能是右子区间的mSum；若跨域了m点，
     * mSum为左子区间rSum与右子区间lSum之和，mSum取三者最大值；
     * iSum最简单，直接取左右子区间iSum之和即可。
     * @param l
     * @param r
     * @return
     */
    public Status pushUp(Status l, Status r) {
        int lSum = Math.max(l.lSum, (l.iSum + r.lSum));
        int rSum = Math.max(r.rSum, (r.iSum + l.rSum));
        int mSum = Math.max(l.mSum, Math.max(r.mSum, l.rSum + r.lSum));
        int iSum = l.iSum + r.iSum;
        return new Status(lSum, rSum, mSum, iSum);
    }

    /**
     * 辅助类，lSum 表示 [l,r]内以 ll 为左端点的最大子段和
     * rSum 表示 [l,r]内以 rr 为右端点的最大子段和
     * mSum 表示 [l,r]内的最大子段和
     * iSum 表示 [l,r] 的区间和
     *
     */
    public class Status {
        public int lSum, rSum, mSum, iSum;
        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

}
