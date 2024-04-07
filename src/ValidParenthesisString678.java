// Question : 678. Valid Parenthesis String
// TC : O(2N)
// SC : O(1)

public class ValidParenthesisString678 {
    static boolean checkValidString(String s) {
        int n = s.length();

        int openCount = 0;
        int closeCount = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                openCount++;
            }
            else{
                openCount--;
                if(openCount<0) return false;
            }
        }

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)==')' || s.charAt(i)=='*'){
                closeCount++;
            }
            else{
                closeCount--;
                if(closeCount<0) return false;
            }
        }

        if(openCount<0 || closeCount<0){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "(*))";

        boolean res = checkValidString(s);

        if(res==true){
            System.out.println("String is Valid");
        }
        else{
            System.out.println("String is Not Valid");
        }

    }
}
