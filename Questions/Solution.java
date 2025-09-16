import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        if(arr[0] == ')' || arr[0] == ']' || arr[0] == '}'){
            return false;
        }
        for(char i : arr){
            if((i == '(' || i == '[' || i == '{')){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(i == ')' && top!= '('){
                    return false;
                }
                if(i == ']' && top!= '['){
                    return false;
                }
                if(i == '}' && top!= '{'){
                    return false;
                }
            } 
        }
        return stack.isEmpty();
    }
} {
    
}
