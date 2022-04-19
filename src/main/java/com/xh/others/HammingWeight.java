package com.xh.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/3/22 19:29
 * description
 * https://leetcode-cn.com/problems/number-of-1-bits/submissions/
 */

public class HammingWeight {

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(3));
        String s = "loveleetcode";char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, c)));

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    //[3,2,1,0,1,0,0,1,2,2,1,0]
    //https://leetcode-cn.com/problems/shortest-distance-to-a-character/
    public static int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        boolean first = true;
        int lastIdx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c){
                if (first){
                    for (int j = 0; j < i; j++) {
                        res[j] = i -j;
                    }
                    first = false;
                }else {
                    for (int j = lastIdx; j < i; j++) {
                        res[j] = Math.min(j - lastIdx, i - j);
                    }
                }
                lastIdx = i;
            }
        }
        for (int j = lastIdx; j < chars.length; j++) {
            res[j] = j - lastIdx;
        }
        return res;
    }


}
