package com.xh.others;

import java.util.LinkedList;

public class RecentCounter {

    LinkedList<Integer> linkedList = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        linkedList.addLast(t);
        while (!linkedList.isEmpty()) {
            Integer peek = linkedList.peek();
            if (t - peek > 3000) {
                linkedList.pop();
            } else {
                break;
            }
        }
        return linkedList.size();
    }

}
