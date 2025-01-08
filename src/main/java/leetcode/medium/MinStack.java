package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack
 */
public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minValuesStack = new Stack<>();

    public MinStack() {}

    public void push(int val) {
        stack.push(val);
        minValuesStack.push(
                minValuesStack.isEmpty()
                        ? val
                        : Math.min(val, getMin())
        );
    }

    public void pop() {
        stack.pop();
        minValuesStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValuesStack.peek();
    }

}
