import java.util.Stack;

public class RemoveKDigits402 {

    static String reverseStringFn(String res){
        char[] arr = res.toCharArray();
        int i=0;
        int j=res.length()-1;

        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }

    static String removeKdigits(String str, int k) {
        int n = str.length();

        if(n==k) return "0";

        Stack<Character> st = new Stack<>();

        if(str.charAt(0)!='0'){
            st.push(str.charAt(0));
        }

        for(int i=1; i<n; i++){

            while(!st.isEmpty() && k>0 && str.charAt(i)<st.peek()){
                st.pop();
                k--;
            }

            if(st.isEmpty() && str.charAt(i)=='0') continue;

            st.push(str.charAt(i));
        }

        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        String res = "";

        if(st.isEmpty()){
            res += '0';
        }
        else{
            while(!st.isEmpty()){
                res += st.peek();
                st.pop();
            }
        }

        // reverse res
        String ans = reverseStringFn(res);

        return ans;
    }

    public static void main(String[] args) {
        String str = "1432219";
        int k = 3;
        String result = removeKdigits(str, k);

        System.out.println("Lowest Integer after K Digits removal : "+ result);
    }
}
