package haiwaitu.t20210915;

/**
 * @Author huangjunqiao
 * @Date 2021/09/15 15:58
 * @Description 位运算-设置值
 */
public class SetValue {
    /**
     * 将第k位设置为1
     *
     * @param num
     * @param k
     * @return
     */
    public int setK1(int num, int k) {
        num |= 1 << (k - 1);
        return num < 0 ? Integer.MAX_VALUE : num;
    }

    /**
     * 将第k位设置为0
     *
     * @param num
     * @param k
     * @return
     */
    public int setK0(int num, int k) {
        // 1、考虑到0与任何数异或，都能保持原数，使用异或
        // 2、又考虑1与任何数异或，都能将数取反。可以分两种情况讨论。
        // 一、第k位如果为0，则不需要取反(与0异或)；二、如果第k位为1，则取反(与1异或)
        int kthBit = num >> (k - 1);
        if ((kthBit & 1) == 0) {
            num ^= 0;// 不需要取反，保持原数
        } else {
            num ^= 1 << (k - 1);// 第k位为1，需要取反
        }
        return num;
    }

    /**
     * 将第k位取反
     *
     * @param num
     * @param k
     * @return
     */
    public int reverseKth(int num, int k) {
        return num ^ 1 << (k - 1);
    }

}
