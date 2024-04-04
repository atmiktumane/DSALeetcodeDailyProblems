import java.util.Stack;

public class MaximumNestingDepthOfParenthesis1614 {
    static int maxDepthBetter(String s) {
        int n = s.length();
        if(n==1) return 0;

        Stack<Character> st = new Stack<>();

        int maxDepth = 0; // result

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else if(s.charAt(i)==')'){
                st.pop();
            }

            maxDepth = Math.max(maxDepth, (int)st.size());
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";

        // Better Approach : Stack -> TC: O(N)  ;  SC: O(N)
        int res = maxDepthBetter(s);
        System.out.println("Maximum Nesting Depth of Parenthesis : "+ res);
    }
}
