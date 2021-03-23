package com.xh.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/3/23 22:26
 * description
 */

public class NestedIterator2 implements Iterator<Integer> {


    static LinkedList<Integer> list = new LinkedList<>();

    public NestedIterator2(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            dfs(nestedList.get(i));
        }
    }

    static void dfs(NestedInteger nest) {
        if (nest.isInteger()) {
            list.addLast(nest.getInteger());
        } else {
            for (int i = 0; i < nest.getList().size(); i++) {
                dfs(nest.getList().get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return list.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

}
