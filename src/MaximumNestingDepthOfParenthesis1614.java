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

    static int maxDepthOptimal(String s) {
        int n = s.length();
        if(n==1) return 0;

        int depth = 0;
        int maxDepth = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if(s.charAt(i)==')'){
                depth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";

        // Better Approach : Stack -> TC: O(N)  ;  SC: O(N)
        int res1 = maxDepthBetter(s);
        System.out.println("Maximum Nesting Depth of Parenthesis : "+ res1);

        // Optimal Approach : Traversing the String -> TC: O(N)  ;  SC: O(1)
        int res2 = maxDepthOptimal(s);
        System.out.println("Maximum Nesting Depth of Parenthesis : "+ res2);
    }
}
