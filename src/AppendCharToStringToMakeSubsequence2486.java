public class AppendCharToStringToMakeSubsequence2486 {
    static int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i=0, j=0, res=0;

        while(i<m && j<n){
            if(t.charAt(j) == s.charAt(i)){
                j++;
                i++;
            }
            else{
                i++;
            }
        }

        if(j<n){
            res = n-j;
        }
        return res;
    }

    public static void main(String[] args) {
        String s= "coaching";
        String t = "coding";


        // Optimal Solution : TC: O(n) ; SC: O(1)
        int ans = appendCharacters(s, t);
        System.out.println("the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s : "+ ans);
    }
}
