package com.xh.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/6/21 9:27
 * @description
 */
public class ReadBinaryWatch {

    public static void main(String[] args) {
        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
        readBinaryWatch.readBinaryWatch(9);
        System.out.println(String.format("%02d", 0));
    }

    List<String> res = new ArrayList<>();
    int[] hs = new int[]{1, 2, 4, 8};
    int[] mins = new int[]{1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        backtrack(0, 0, turnedOn, 0, 0, true, true);
        return res;
    }

    private void backtrack(int h, int min, int num, int currentHindex, int currentMindex, boolean chooseHour, boolean chooseMin) {
        if (num == 0) {
            String r = h + ":" + String.format("%02d", min);
            res.add(r);
            return;
        }
        if (chooseHour) {
            for (int i = currentHindex; i < hs.length; i++) {
                int ch = hs[i];
                int newh = ch + h;
                backtrack(newh, min, num - 1, i, currentMindex, newh < 12, chooseMin);
            }
        }
        if (chooseMin) {
            for (int i = currentMindex; i < mins.length; i++) {
                int cm = mins[i];
                int newm = cm + min;
                backtrack(h, newm, num - 1, currentHindex, i, chooseHour, newm < 60);
            }
        }
//        backtrack(0, 0, num, 0, 0, true, true);
    }


    // 暴力
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) +Integer.bitCount(j)==turnedOn){
                    String r = i + ":" + String.format("%02d", j);
                    res.add(r);
                }
            }
        }
        return res;
    }

}
