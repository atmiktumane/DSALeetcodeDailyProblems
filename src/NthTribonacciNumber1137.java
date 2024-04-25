public class NthTribonacciNumber1137 {

    static int findTribonacciBrute(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        return findTribonacciBrute(n-1) + findTribonacciBrute(n-2) + findTribonacciBrute(n-3);
    }
    static int findTribonacciBetter(int n){
        if(n==0) return n;

        if(n==1 || n==2) return 1;

        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i=3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        return arr[n];
    }

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

        // Tribonacci Series:  0 1 1 2 4 7 13 24 44 81
        int n = 9;

        // Brute Force -> TC: O(3^n) Exponential , SC: O(N)
        int res1 = findTribonacciBrute(n);
        System.out.print(res1 + " ");


        // Better Approach -> TC: O(n) , SC: O(N)
//        int res2 = findTribonacciBetter(n);
//        System.out.println(res2);

        // Optimal Approach  -> TC: O(1) , SC: O(1)
//        int res3 = findTribonacciOptimal(n);
//        System.out.println(res3);


    }
}
