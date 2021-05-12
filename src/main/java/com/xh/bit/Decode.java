package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/11 12:45
 * <p>
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 * <p>
 * 题解：
 * https://leetcode-cn.com/problems/decode-xored-permutation/solution/ji-shuang-yi-wen-dai-ni-shua-liang-dao-j-mujs/
 * <p>
 * ref: {@link DecodeXoredArray}
 */
public class Decode {

    public static void main(String[] args) {
        for (int i = 1; i < 6; i += 2) {
            System.out.println(i);
        }
    }


    public int[] decode(int[] encoded) {
        int length = encoded.length;
        // get the first one

        // BCDE
        int orone = 0;
        for (int i = 1; i < length; i += 2) {
            orone ^= encoded[i];
        }
        // ABCDE
        int allor = 0;
        for (int i = 1; i <= length + 1; i++) {
            allor ^= i;
        }

        // A
        int first = orone ^ allor;

        // get results
        int[] res = new int[length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
