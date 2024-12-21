package leetcode.medium;

import java.util.*;

public final class EvaluateReversePolishNotation {

    private static final class TokensState {

        private static final Set<String> VALID_OPERANDS = new HashSet<>(){{
            add("+");
            add("-");
            add("*");
            add("/");
        }};

         private final List<String> listTokens;

        public TokensState(List<String> listTokens) {
            this.listTokens = listTokens;
        }

        public int nextOperandIndex() {
            for (int i = 0; i < listTokens.size(); i++) {
                if (VALID_OPERANDS.contains(listTokens.get(i))) {
                    return i;
                }
            }
            return -1;
        }

        public String get(int index) {
            return listTokens.get(index);
        }

        public void setResult(int doneOperandIndex, int currentResult) {
            listTokens.set(doneOperandIndex, String.valueOf(currentResult));
            listTokens.remove(doneOperandIndex - 1);
            var toProbablyRemove = doneOperandIndex - 2;
            if (toProbablyRemove >= 0) {
                listTokens.remove(toProbablyRemove);
            }
        }
    }

    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     */
    public int evalRPN(String[] tokens) {
        var tokensState = new TokensState(new ArrayList<>(Arrays.asList(tokens)));

        for (;;) {
            var nextOperandIndex = tokensState.nextOperandIndex();
            if (nextOperandIndex == -1) {
                break;
            }
            var nextOperand = tokensState.get(nextOperandIndex);
            int right = Integer.parseInt(tokensState.get(nextOperandIndex - 1));
            int left = Integer.parseInt(tokensState.get(nextOperandIndex - 2));
            var currentResult = doOperation(left, right, nextOperand);
            tokensState.setResult(nextOperandIndex, currentResult);
        }
        return Integer.parseInt(tokensState.get(0));
    }

    private int doOperation(int left, int right, String nextOperand) {
        return switch (nextOperand) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "/" -> left / right;
            case "*" -> left * right;
            default -> throw new RuntimeException("AHTUNG!!!");
        };
    }

}
