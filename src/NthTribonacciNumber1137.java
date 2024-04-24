public class NthTribonacciNumber1137 {
    static int findTribonacciOptimal(int n) {
        if(n==0) return n;

        if(n==1 || n==2) return 1;

        int t0 = 0, t1=1, t2 = 1;
        int sum = 0;

        for(int i=3; i<=n; i++){
            sum = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;

        // Optimal Approach  -> TC: O(1) , SC: O(1)
        int res = findTribonacciOptimal(n);

        System.out.println(res);


    }
}
