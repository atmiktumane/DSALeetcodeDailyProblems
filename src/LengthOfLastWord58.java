// Question : 58. Length of Last Word in a String
// TC : O(N)
// SC : O(1)

import java.util.Stack;

public class LengthOfLastWord58 {
    static int lengthOfLastWordBetter(String s) {
        int n = s.length();

        if(n==0) return 0;

        Stack<String> st = new Stack<>();
        String temp = "";

        for(int i=0; i<n; i++){
            if(s.charAt(i)!=' '){
                temp += s.charAt(i);
            }
            else{
                if(temp.length()>0)
                    st.push(temp);
                temp = "";
            }
        }

        if(temp!=""){
            return temp.length();
        }
        else{
            return st.peek().length();
        }
    }

    static int lengthOfLastWordOptimal(String s) {
        int n = s.length();

        if(n==0) return 0;

        String currStr = "";
        String prevStr = "";

        for(int i=0; i<n; i++){
            if(s.charAt(i)!=' '){
                currStr += s.charAt(i);
            }
            else{
                if(currStr.length()>0)
                    prevStr = currStr;
                currStr = "";
            }
        }

        if(currStr!=""){
            return currStr.length();
        }
        else{
            return prevStr.length();
        }
    }

    public static void main(String[] args) {
        String str = "luffy is still joyboy";

        // Better Approach : Using stack
        int res1 = lengthOfLastWordBetter(str);
        System.out.println("Length of Last word : "+res1);

        // Optimal Approach : Using 2 variables (currString, PrevString)
        int res2 = lengthOfLastWordOptimal(str);
        System.out.println("Length of Last word : "+res2);
    }
}
