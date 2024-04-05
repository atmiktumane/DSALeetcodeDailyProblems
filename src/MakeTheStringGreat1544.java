// Question : 1544. Make the String Great
// TC : O(N)
// SC : O(1)

public class MakeTheStringGreat1544 {

    static String makeGoodOptimal(String s) {
        int n = s.length();
        String result = "";

        for(int i=0; i<n; i++){
            if(result.length()==0){
                result += s.charAt(i);
                continue;
            }

            if(Math.abs((int)(result.charAt(result.length()-1)) - (int)(s.charAt(i))) == 32){
                result = result.substring(0, result.length()-1);
            }
            else{
                result += s.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "leEeetcode";

        String res = makeGoodOptimal(s);

        System.out.println(res);
    }
}
