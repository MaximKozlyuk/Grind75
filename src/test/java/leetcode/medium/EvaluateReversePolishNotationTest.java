package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluateReversePolishNotationTest {

    @Test
    public void test1() {
        var tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        var expected = 22;
        var actual = new EvaluateReversePolishNotation().evalRPN(tokens);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        var tokens = new String[]{"2","1","+","3","*"};
        var expected = 9;
        var actual = new EvaluateReversePolishNotation().evalRPN(tokens);
        Assertions.assertEquals(expected, actual);
    }

}
