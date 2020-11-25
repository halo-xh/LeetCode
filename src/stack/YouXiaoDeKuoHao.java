package stack;

import java.util.LinkedList;

/**
 * author  Xiao Hong
 * date  2020/9/21 22:13
 * description
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class YouXiaoDeKuoHao {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('#');
        for (char aChar : chars) {
            Character peek = stack.peek();
            if (aChar == ')' && peek == '(') {
                stack.pop();
            } else if (aChar == '}' && peek == '{') {
                stack.pop();
            } else if (aChar == ']' && peek == '[') {
                stack.pop();
            } else {
                stack.push(aChar == ' ' ? null : aChar);
            }
        }
        return stack.pop() == '#';
    }

}
