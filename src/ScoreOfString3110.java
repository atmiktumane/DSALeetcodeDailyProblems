public class ScoreOfString3110 {
    static int scoreOfString(String s) {
        int n = s.length();

        int res = 0;
        for(int i=1; i<n; i++){
            char ch1 = s.charAt(i);
            char ch0 = s.charAt(i-1);

            int difference = (int)(ch0) - (int)(ch1);
            int temp = Math.abs(difference);

            res += temp;

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "hello";

        // Optimal Solution : TC: O(N) ; SC: O(1)
        int ans = scoreOfString(s);

        System.out.println("Sum of absolute difference between ASCII Values of adjacent char : " + ans);

    }
}
