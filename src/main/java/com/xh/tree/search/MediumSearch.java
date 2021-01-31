package com.xh.tree.search;

import com.xh.tree.Node;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/26 12:57
 * @description
 */
public class MediumSearch {


    // zhong序遍历
    public void mdSearch(Node e) {
        mdSearch(e.left);
        System.out.println(e.element);
        mdSearch(e.right);
    }
}
