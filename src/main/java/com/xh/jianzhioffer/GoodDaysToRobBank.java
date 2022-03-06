package com.xh.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int length = security.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            if (security[i - 1] >= security[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            if (security[i] >= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (left[i] > time && right[i] > time) {
                res.add(i);
            }
        }
        return res;
    }


}
