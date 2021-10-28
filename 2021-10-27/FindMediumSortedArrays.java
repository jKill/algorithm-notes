package haiwaitu.t20211027;

/**
 * @Author huangjunqiao
 * @Date 2021/10/28 16:11
 * @Description 4. 寻找两个正序数组的中位数
 */
public class FindMediumSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        int idx = 0;
        int[] nums = new int[len1 + len2];
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                nums[idx++] = nums1[idx1++];
            } else {
                nums[idx++] = nums2[idx2++];
            }
        }
        while (idx1 < len1) {
            nums[idx++] = nums1[idx1++];
        }
        while (idx2 < len2) {
            nums[idx++] = nums2[idx2++];
        }

        return findMiddle(nums);
    }
    public double findMiddle(int[] nums) {
        int len = nums.length;
        if (len % 2 != 0) {
            return nums[len / 2];
        } else {
            double l = nums[(len - 1) / 2];
            double r = nums[len / 2];
            return (l + r) / 2;
        }
    }

}
