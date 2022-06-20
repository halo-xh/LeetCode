package com.xh.others;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Xiao Hong
 * @since 2022-06-20
 */
public class RangeModule {

    TreeMap<Integer, Boolean> map = new TreeMap<>();


    public RangeModule() {

    }

    public void addRange(int left, int right) {
        SortedMap<Integer, Boolean> subMap = map.subMap(left, right);
        Integer floorKey = map.floorKey(left);
        if (floorKey != null) {
            Boolean fv = map.get(floorKey);
            subMap.keySet().forEach(map::remove);
            if (!fv) {
                map.put(left, true);
            }
        } else {
            subMap.keySet().forEach(map::remove);
            map.put(left, true);
        }
        Integer cr = map.ceilingKey(right);
        if (cr != null) {
            if (map.get(cr)) {
                if (cr != right) {
                    map.put(right, false);
                } else {
                    map.remove(right);
                }
            }
        } else {
            map.put(right, false);
        }

    }

    public boolean queryRange(int left, int right) {
        Integer ceilingKey = map.ceilingKey(right);
        if (ceilingKey == null) {
            return false;
        }
        Integer floorKey = map.floorKey(left);
        if (floorKey == null) {
            return false;
        }
        return map.subMap(left, right).size() == 1 && map.get(floorKey) && !map.get(ceilingKey);
    }

    public void removeRange(int left, int right) {
        Integer integer = map.floorKey(left);
        if (integer != null && integer > right) {
            return;
        }
        SortedMap<Integer, Boolean> subMap = map.subMap(left, right);
        subMap.keySet().forEach(map::remove);
        Integer cr = map.ceilingKey(right);
        if (integer != null) {
            Boolean cb = map.get(integer);
            if (cb) {
                if (integer != left) {
                    map.put(left, false);
                }
            }
        }
        if (cr != null) {
            Boolean aBoolean = map.get(cr);
            if (!aBoolean) {
                if (right != cr) {
                    map.put(right, true);
                }
            }
        }

    }

}
