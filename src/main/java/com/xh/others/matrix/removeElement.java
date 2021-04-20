package com.xh.others.matrix;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/19 18:06
 * @description
 */
public class removeElement {

    public static void main(String[] args) {
        removeElement removeElement = new removeElement();
        int[] ints = {3,2,2,3};
        System.out.println(removeElement.removeElement(ints, 3));
        System.out.println(Arrays.toString(ints));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        int dpl = 0;
        int tmp = 0;
        while (i !=j){
            if (nums[i] ==val){
                dpl++;
                while (i != j){
                    if (val != nums[j]){
                        tmp = nums[i];
                        nums[i]= nums[j];
                        nums[j] = tmp;
                        break;
                    }
                    j--;
                    dpl++;
                }
            }
            i++;
        }
        return dpl;
    }

    // tql
    public int removeElement2(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
