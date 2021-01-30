package jianzhioffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 15:49
 * @description 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

    LinkedList<Integer> stack1 = new LinkedList<>(); //只进
    LinkedList<Integer> stack2 = new LinkedList<>(); // 只出

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


}
