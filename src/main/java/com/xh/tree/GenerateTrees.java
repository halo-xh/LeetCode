package com.xh.tree;


import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        // 1 0; 2 2; 3 5;
        // [1,null,2]
        // [2,1]

        //  [1,null,3,2],
        //  [3,2,null,1],
        //  [3,1,null,null,2],
        //  [2,1,3],
        //  [1,null,2,null,3]


        return null;
    }

    /**
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST2(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST2(nums, left, mid - 1);
        root.right = sortedArrayToBST2(nums, mid + 1, right);
        return root;
    }

    /**
     * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    private TreeNode buildTree(ListNode left, ListNode right){
        if (left == right){
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode rt = new TreeNode(mid.val);
        rt.right = buildTree(mid,right);
        rt.left = buildTree(left,mid);
        return rt;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next!=null) {  //走2步  fast.next!=null
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
