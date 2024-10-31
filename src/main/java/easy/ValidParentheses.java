package easy;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()") + "\n");
        System.out.println(isValid("()[]{}") + "\n");
        System.out.println(isValid("(]") + "\n");
        System.out.println(isValid("([])") + "\n");
        System.out.println(isValid("())") + "\n");
        System.out.println(isValid("[)") + "\n");
        System.out.println(isValid("((") + "\n");
        System.out.println(isValid("))") + "\n");
    }

    private static final Set<Character> closeBrackets = new HashSet<>(){{
        add(')');
        add('}');
        add(']');
    }};

    private static final HashMap<Character, Character> bracketsMapping = new HashMap<>(){{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    private static boolean isCloseBracket(Character toCheck) {
        return closeBrackets.contains(toCheck);
    }

    /*
    https://leetcode.com/problems/valid-parentheses/
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
     */
    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        var bracketsOrder = new Stack<Character>();
        bracketsOrder.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            var currentBracket = s.charAt(i);
            if (isCloseBracket(currentBracket)) {
                var openBracketOfCurrent = bracketsMapping.get(currentBracket);
                if (bracketsOrder.isEmpty() || !openBracketOfCurrent.equals(bracketsOrder.peek())) {
                    return false;
                } else {
                    bracketsOrder.pop();
                }
            } else {
                bracketsOrder.add(currentBracket);
            }
        }
        return bracketsOrder.isEmpty();
    }

}
