package dp;

/**
 * author  Xiao Hong
 * date  2020/11/23 22:35
 * description
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/
 *
 */

public class ChiJuZi {

    public static void main(String[] args) {

    }


    public int minDays(int n) {

        return 0;
    }

    public static double CatalanNumber(int n) {
        if (n == 1) {
            return 1;
        } else {
            return CatalanNumber(n - 1) * 2 * (2 * n - 1) / (n + 1);
        }
    }

}
