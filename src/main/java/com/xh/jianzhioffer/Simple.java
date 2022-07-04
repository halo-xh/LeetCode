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
    int[] lt = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    int[] ht = new int[]{1, 2, 4, 8};
    int[] mt = new int[]{1, 2, 4, 8, 16, 32};
    int turnedOn = 0;
    ArrayList<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        this.turnedOn = turnedOn;
//        dfs2(0, 0, 0, 0);
        dfs3(0, 0, 0, 0, 0, false);
        return res;
    }

    private void dfs2(int ct, int idx, int hour, int minute) {
        if (ct > turnedOn) {
            return;
        }
        if (ct == turnedOn) {
//          res.add(hour + ":" + String.format("%02d", minute));  这个看着很爽. 会导致慢很多. 17 ms
//          res.add(String.valueOf(hour) + ':' + ((minute < 10) ? "0" : "") + minute); 这个看着很爽. 也会慢. 9 ms
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = idx; i < lt.length; i++) {
            if (i <= 3) {
                int newHour = hour + lt[i];
                if (newHour > 11) {
                    continue;
                }
                dfs2(ct + 1, i + 1, newHour, minute);
            } else {
                int newMinute = minute + lt[i];
                if (newMinute > 59) {
                    continue;
                }
                dfs2(ct + 1, i + 1, hour, newMinute);
            }
        }
    }

    private void dfs3(int ct, int hdx, int mdx, int hour, int minute, boolean finishedH) {
        if (ct > turnedOn || hour > 11 || minute > 59) {
            return;
        }
        if (ct == turnedOn) {
            res.add(String.valueOf(hour) + ':' + ((minute < 10) ? "0" : "") + minute);
            return;
        }
        for (int i = hdx; i < ht.length && !finishedH; i++) {
            int newHour = hour + ht[i];
            dfs3(ct + 1, i + 1, mdx, newHour, minute, false);
        }
        for (int i = mdx; i < mt.length; i++) {
            int newMinute = minute + mt[i];
            if (newMinute > 59) {
                continue;
            }
            dfs3(ct + 1, hdx, i + 1, hour, newMinute, true);
        }
    }


    //https://leetcode.cn/problems/sum-of-all-subset-xor-totals/
    int ress = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ress;
    }

    private void dfs(int[] nums, int idx, int val) {
        ress += val;
        for (int i = idx; i < nums.length; i++) {
            dfs(nums, i + 1, val ^ nums[i]);
        }
    }

    //https://leetcode.cn/problems/UEcfPD/
    int max = -1;
    int limit = 0;
    int[][] attribute = null;
    int[][] cookbooks = null;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.limit = limit;
        this.attribute = attribute;
        this.cookbooks = cookbooks;
        dfsPerfectMenu(materials, 0, 0, 0);
        return max;
    }

    private void dfsPerfectMenu(int[] materials, int idx, int nl, int r) {
        if (nl >= limit && idx == cookbooks.length) {
            max = Math.max(max, r);
        }
        for (int i = idx; i < cookbooks.length; i++) {
            int a1 = cookbooks[i][0];
            int a2 = cookbooks[i][1];
            int a3 = cookbooks[i][2];
            int a4 = cookbooks[i][3];
            int a5 = cookbooks[i][4];
            int m1 = materials[0] - a1;
            int m2 = materials[1] - a2;
            int m3 = materials[2] - a3;
            int m4 = materials[3] - a4;
            int m5 = materials[4] - a5;
            if (m1 >= 0 && m2 >= 0 && m3 >= 0 && m4 >= 0 && m5 >= 0) {
                dfsPerfectMenu(new int[]{m1, m2, m3, m4, m5}, i + 1, nl + attribute[i][1], r + attribute[i][0]);
                dfsPerfectMenu(materials, i + 1, nl, r);
            }
        }
    }

    //https://leetcode.cn/problems/letter-case-permutation/
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        dsfLetterCasePermutation(chars, 0, res);
        return res;
    }

    private void dsfLetterCasePermutation(char[] chars, int idx, ArrayList<String> res) {
        res.add(new String(chars));
        for (int i = idx; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    chars[i] = Character.toLowerCase(chars[i]);
                    dsfLetterCasePermutation(chars, i + 1, res);
                    chars[i] = Character.toUpperCase(chars[i]);
                } else {
                    chars[i] = Character.toUpperCase(chars[i]);
                    dsfLetterCasePermutation(chars, i + 1, res);
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            }
        }
    }


    //https://leetcode.cn/problems/generate-parentheses/
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        dfsGenerateParenthesis(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfsGenerateParenthesis(int max, int left, int right, StringBuilder s, ArrayList<String> res) {
        if (max * 2 == s.length()) {
            res.add(s.toString());
            return;
        }
        if (left < max) {
            s.append("(");
            dfsGenerateParenthesis(max, left + 1, right, s, res);
            s.deleteCharAt(s.length() - 1);
        }
        if (right < left) {
            s.append(")");
            dfsGenerateParenthesis(max, left, right + 1, s, res);
            s.deleteCharAt(s.length() - 1);
        }
    }

    //为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。
    // 如果在遍历过程中balance 的值小于零，或者结束时balance 的值不为零，那么该序列就是无效的，否则它是有效的。
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    //https://leetcode.cn/problems/all-paths-from-source-to-target/
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(0);
        dfsAllPathsSourceTarget(res, graph, 0, list);
        return res;
    }

    private void dfsAllPathsSourceTarget(List<List<Integer>> res, int[][] graph, int idx, LinkedList<Integer> cur) {
        if (cur.getLast() == graph.length - 1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int[] ints = graph[idx];
        for (int anInt : ints) {
            cur.addLast(anInt);
            dfsAllPathsSourceTarget(res, graph, anInt, cur);
            cur.removeLast();
        }
    }

    //https://leetcode.cn/problems/combination-sum-iii/
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfsCombinationSum3(res, 0, list, k, n);
        return res;
    }

    private void dfsCombinationSum3(List<List<Integer>> res, int idx, LinkedList<Integer> list, int ct, int remain) {
        if (ct == 0 && remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            int r = remain - arr[i];
            if (r < 0) {
                break;
            }
            list.addLast(arr[i]);
            dfsCombinationSum3(res, i + 1, list, ct - 1, remain - arr[i]);
            list.removeLast();
        }
    }

    //https://leetcode.cn/problems/combination-sum/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfsCombinationSum(res, candidates, 0, list, target);
        return res;
    }

    private void dfsCombinationSum(List<List<Integer>> res, int[] candidates, int idx, LinkedList<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int reamin = target - candidates[i];
            if (reamin < 0) {
                break;
            }
            list.addLast(candidates[i]);
            dfsCombinationSum(res, candidates, i, list, reamin);
            list.removeLast();
        }
    }


    public static void main(String[] args) {
        Simple simple = new Simple();
        int[] nums = {2, 3, 5};
        int sum = simple.subsetXORSum(nums);
        System.out.println("sum = " + sum);
        System.out.println(simple.letterCasePermutation("a1b2"));
        System.out.println(simple.combinationSum3(3, 7));
        System.out.println(simple.combinationSum(nums, 8));
    }


}
