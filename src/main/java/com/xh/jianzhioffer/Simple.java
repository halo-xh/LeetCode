package com.xh.jianzhioffer;

import com.xh.common.ListNode;
import com.xh.tree.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Xiao Hong
 * @since 2022-06-28
 */
public class Simple {


    //https://leetcode.cn/problems/roman-to-integer/
    public int romanToInt(String s) {
        Map<Character, Integer> val = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int res = 0;
        char[] chars = s.toCharArray();
        int max = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer integer = val.get(chars[i]);
            if (max < integer) {
                res += integer;
                max = integer;
            } else {
                res -= integer;
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/zigzag-conversion/
    public String convert(String s, int numRows) {
        List<List<String>> rs = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rs.add(new ArrayList<>());
        }
        char[] chars = s.toCharArray();
        boolean frd = true;
        int i = 0;
        while (i < chars.length) {
            if (frd) {
                for (List<String> r : rs) {
                    if (i >= chars.length) {
                        break;
                    }
                    r.add(String.valueOf(chars[i++]));
                }
                frd = false;
            } else {
                for (int i1 = rs.size() - 2; i1 >= 1; i1--) {
                    if (i >= chars.length) {
                        break;
                    }
                    rs.get(i1).add(String.valueOf(chars[i++]));
                }
                frd = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for (List<String> r : rs) {
            for (String s1 : r) {
                res.append(s1);
            }
        }
        return res.toString();
    }

    //https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    //https://leetcode.cn/problems/length-of-last-word/
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int length = s.length() - 1; length >= 0; length--) {
            if (s.charAt(length) == ' ') {
                if (res != 0) {
                    break;
                }
            } else {
                res++;
            }
        }
        return res;
    }


    //https://leetcode.cn/problems/plus-one/
    public static int[] plusOne(int[] digits) {
        int start = digits.length - 1;
        int res = ++digits[start];
        while (start != 0 && res == 10) {
            digits[start] = 0;
            start--;
            res = ++digits[start];
        }
        if (digits[0] == 10) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
        return digits;
    }

    //https://leetcode.cn/problems/add-binary/
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int m = a.length() - b.length();
        for (int i = 0; i < m; i++) {
            b = "0" + b;
        }
        char[] chars = a.toCharArray();
        boolean add = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char cb = b.charAt(i);
            if (chars[i] == '1' && cb == '1') {
                if (add) {
                    chars[i] = '1';
                } else {
                    chars[i] = '0';
                }
                add = true;
            } else if ((chars[i] == '1' && cb == '0') || (chars[i] == '0' && cb == '1')) {
                if (add) {
                    chars[i] = '0';
                } else {
                    chars[i] = '1';
                }
            } else if (chars[i] == '0' && cb == '0') {
                if (add) {
                    chars[i] = '1';
                    add = false;
                }
            }
        }
        String s = new String(chars);
        if (add) {
            s = '1' + s;
        }
        return s;
    }


    //https://leetcode.cn/problems/balanced-binary-tree/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (isBalanced(root.left) && isBalanced(root.right)) && Math.abs(height(root.right) - height(root.left)) <= 1;

    }

    private int height(TreeNode right) {
        if (right == null) {
            return 0;
        }
        return Math.max(height(right.left), height(right.right)) + 1;
    }

    //https://leetcode.cn/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    //https://leetcode.cn/problems/excel-sheet-column-title/
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    //https://leetcode.cn/problems/excel-sheet-column-number/
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int length = columnTitle.length() - 1; length >= 0; length--) {
            char c = columnTitle.charAt(length);
            int ci = (c - 'A') + 1;
            res += ci * Math.pow(26, (columnTitle.length() - 1 - length));
        }
        return res;
    }

    //https://leetcode.cn/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n, fast = sqSum(n);
        while (slow != fast) {
            slow = sqSum(slow);
            fast = sqSum(sqSum(fast));
        }
        return slow == 1;
    }

    private static int sqSum(int n) {
        int sum = 0;
        while (n > 0) {
            int x = n % 10;
            sum += x * x;
            n /= 10;
            System.out.println("n = " + n);
        }
        return sum;
    }


    //https://leetcode.cn/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() == nums.length;
    }

    //https://leetcode.cn/problems/add-digits/
    public static int addDigits(int num) {
        int sum = sumM(num);
        while (sum > 9) {
            sum = sumM(sum);
        }
        return sum;
    }

    private static int sumM(int num) {
        int s = 0;
        while (num != 0) {
            int x = num % 10;
            s += x;
            num /= 10;
        }
        return s;
    }

    //https://leetcode.cn/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode pre = node;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return node.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }


    //https://leetcode.cn/problems/isomorphic-strings/
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    //https://leetcode.cn/problems/contains-duplicate-ii/
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                integers.remove(nums[i - k - 1]);
            }
            if (integers.contains(nums[i])) {
                return true;
            }
            integers.add(nums[i]);
        }
        return false;
    }


    //https://leetcode.cn/problems/implement-stack-using-queues/
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    public void push(int x) {
        arrayDeque.push(x);
    }

    public int pop() {
        return arrayDeque.pop();
    }

    public int top() {
        return arrayDeque.pop();
    }

    public boolean empty() {
        return arrayDeque.isEmpty();
    }

    //https://leetcode.cn/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode right = pop.right;
            pop.right = pop.left;
            pop.left = right;
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return root;
    }


    //https://leetcode.cn/problems/summary-ranges/
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        int pre = nums[0], start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre + 1) {
                if (start != pre) {
                    res.add(start + "->" + pre);
                } else {
                    res.add(String.valueOf(pre));
                }
                start = nums[i];
                pre = start;
            } else {
                pre = nums[i];
            }
        }
        if (start != pre) {
            res.add(start + "->" + pre);
        } else {
            res.add(String.valueOf(pre));
        }
        return res;
    }


    //https://leetcode.cn/problems/implement-queue-using-stacks/
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push2(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop2() {
        return stack1.pop();
    }

    public int peek2() {
        return stack1.peek();
    }

    public boolean empty2() {
        return stack1.isEmpty();
    }

    //https://leetcode.cn/problems/prime-arrangements/
    public int numPrimeArrangements(int n) {
        // 计算质数个数
        int pct = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                pct++;
            }
        }
        return (int) ((asa(pct) * asa(n - pct)) % mod);
    }

    private boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        for (int j = 2; j * j <= i; j++) {
            if ((i % j) == 0) {
                return false;
            }
        }
        return true;
    }

    int mod = (int) (1e9 + 7);

    private long asa(int a) {
        long res = 1;
        for (int i = 1; i <= a; i++) {
            res = res * i % mod;
        }
        return res;
    }

    //https://leetcode.cn/problems/palindrome-linked-list/
    //找到前半部分链表的尾节点。
    //反转后半部分链表。
    //判断是否回文。
    //恢复链表。
    //返回结果。
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode last = reverseHalf(mid.next);
        ListNode l = last;
        boolean res = true;
        ListNode p1 = head;
        while (last != null && p1 != null) {
            if (p1.val != last.val) {
                res = false;
                break;
            }
            last = last.next;
            p1 = p1.next;
        }
        reverseHalf(l);
        return res;
    }

    private ListNode reverseHalf(ListNode next) {
        ListNode pre = null;
        ListNode node = next;
        while (node != null) {
            ListNode listNode = node.next;
            node.next = pre;
            pre = node;
            node = listNode;
        }
        return pre;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //https://leetcode.cn/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    //https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            while (true) {
                if (p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;
                } else if (p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;
                } else {
                    break;
                }
            }
            return ancestor;
        }
    }

    static boolean found = false;
    static ArrayDeque<Integer> treeNodes = new ArrayDeque<>();

    private static void dsf(TreeNode root, TreeNode p) {
        if (root == null) {
            if (!treeNodes.isEmpty()) {
                treeNodes.removeLast();
            }
            return;
        }
        treeNodes.addLast(root.val);
        if (root.val == p.val) {
            found = true;
            return;
        }
        dsf(root.left, p);
        if (found) {
            return;
        }
        dsf(root.right, p);
        if (found) {
            return;
        }
        if (root.val != p.val) {
            if (!treeNodes.isEmpty()) {
                treeNodes.removeLast();
            }
        }
    }

    // https://leetcode.cn/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String path) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            String s = path + "->" + root.val;
            res.add(s.replaceFirst("->", ""));
            return;
        }
        path += "->" + root.val;
        dfs(root.left, res, path);
        dfs(root.right, res, path);
    }

    //https://leetcode.cn/problems/binary-watch/
    int[] h = new int[]{1, 2, 4, 8};
    int[] m = new int[]{1, 2, 4, 8, 16, 32};
    ArrayList<String> res = new ArrayList<>();
    int total = 0;

    public List<String> readBinaryWatch(int turnedOn) {
        total = turnedOn;
        dfs2(0, 0, 0, 0, 0);
        return res;
    }

    private void dfs2(int used, int idx, int idxy, int minute, int hour) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (used == total) {
            res.add(hour + ":" + String.format("%02d", minute));
            return;
        }
        ++used;
        hour += h[++idx];
        minute += m[++idxy];
        dfs2(used, idx, idxy, minute, hour);
    }

    //https://leetcode.cn/problems/sum-of-all-subset-xor-totals/


    public static void main(String[] args) {

        TreeNode treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(4,
                                                new TreeNode(7,
                                                        new TreeNode(9),
                                                        new TreeNode(17)),
                                                new TreeNode(10)),
                                        new TreeNode(13)),
                                new TreeNode(14)),
                        new TreeNode(11));

        dsf(treeNode, new TreeNode(13));
        System.out.println(treeNodes);
    }


}
