package leecode;

/**
 * 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class SwitchStringToRight {

    public static void main(String[] args) {

    }

    class Solution {
        public String reverseLeftWords(String s, int n) {
            String rightString = s.substring(n);
            String leftString = s.substring(0, n);
            return rightString + leftString;
        }
    }
}
