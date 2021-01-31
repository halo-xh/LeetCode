package com.xh.tree.search;

import com.xh.tree.Node;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/26 12:58
 * @description
 */
public class LastSearch {

    // hou序遍历
    public void ltOrderSearch(Node e) {
        ltOrderSearch(e.left);
        ltOrderSearch(e.right);
        System.out.println(e.element);

    }
}
