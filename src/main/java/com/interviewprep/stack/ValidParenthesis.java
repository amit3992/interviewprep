package com.interviewprep.stack;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && stack.isEmpty() || c == '}' && stack.isEmpty() || c == ']' && stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peek() == '(' || c == '}' && stack.peek() == '{' || c == ']' && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                open--;
                if (open < 0) {
                    return false;
                }
            }
        }
        return open == 0;
    }

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()"));
        System.out.println(validParenthesis.isValid("()[]{}"));
        System.out.println(validParenthesis.isValid("(]"));


        System.out.println(validParenthesis.isValid2("()"));
        System.out.println(validParenthesis.isValid2("()[]{}"));
        System.out.println(validParenthesis.isValid2("(]"));
    }
}
