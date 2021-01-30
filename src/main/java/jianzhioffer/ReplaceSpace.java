package jianzhioffer;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 14:45
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy. "));
    }

    public static String replaceSpace(String s) {
        char[] chars = new char[s.length() * 3];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                chars[++j] ='%';
                chars[++j] ='2';
                chars[++j] ='0';
            }else {
                chars[++j] = s.charAt(i);
            }
        }
        return new String(chars);
    }

    public static String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

}
