import java.util.*;

class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } 
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }

        result += sign * number;
        return result;
    }
}