import java.util.*;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        int open = n;
        int close = n;
        
        if (n == 1) {
            result.add("()");
            return result;
        }
        
        Stack<String> stk = new Stack<String>();
        backtrack(stk, result, n, 0, 0);
        
        return result;
    }
    
    public void backtrack(Stack stk, List result, int n, int open, int close) {
        String str = "";
        
        if (open == close && close == n) {
            ArrayList<String> arr = new ArrayList(stk);
            for (String c : arr) {
                str += c;
            }
            
            result.add(str);
            return;
        }
        
        if (open < n) {
            stk.push("(");
            backtrack(stk, result, n, open + 1, close);
            stk.pop();
        }
        
        if (close < open) {
            stk.push(")");
            backtrack(stk, result, n, open, close + 1);
            stk.pop();
        }
    }
}