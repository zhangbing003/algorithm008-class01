package validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character c : chars){
            if (c.equals('{')){
                stack.add('}');
            } else if (c.equals('[')){
                stack.add(']');
            } else if (c.equals('(')){
                stack.add(')');
            } else {
                if (!c.equals(stack.pop())){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
