package com.xh.others.matrix;


/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/24 17:44
 * <p>
 * https://leetcode-cn.com/problems/flipping-an-image/
 */
public class FlipAndInvertImage {


    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] revert = revert(A[i]);
            A[i] = revert;
        }
        return A;
    }

    private int[] revert(int[] r) {
        int[] res = new int[r.length];
        for (int i = r.length - 1; i >= 0; i--) {
            res[r.length - 1 - i] = r[i] ^ 1;
        }
        return res;
    }

//    private static int[] revert2(int[] r) {
//        for (int i = r.length / 2; i >= 0; i--) {
//            int tep = r[r.length - 1 - i];
//            System.out.println(tep);
//            r[r.length - 1 - i] = r[i] ^ 1;
//            r[i] = tep ^ 1;
//        }
//        return r;
//    }

}
