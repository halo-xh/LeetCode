package com.xh.others;

/**
 * author  Xiao Hong
 * date  2021/3/19 22:15
 * description
 * https://leetcode-cn.com/problems/design-parking-system/
 */

public class ParkingSystem {

    private int cbig;
    private int cmedium;
    private int csmall;

    public ParkingSystem(int big, int medium, int small) {
        this.cbig = big;
        this.cmedium = medium;
        this.csmall = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                return cbig-- > 0;
            case 2:
                return cmedium-- > 0;
            case 3:
                return csmall-- > 0;
        }
        return false;
    }

}

