package tree.search;

import tree.Node;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/26 12:52
 * @description
 */
public class FirstSearch {

    // 前序遍历
    public void ftSearch(Node e) {
        System.out.println(e.element);
        ftSearch(e.left);
        ftSearch(e.right);
    }

}
