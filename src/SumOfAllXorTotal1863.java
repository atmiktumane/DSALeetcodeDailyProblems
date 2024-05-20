public class SumOfAllXorTotal1863 {

    static int sum;
    static void calculateSumOfAllXor1(int[] arr, int i, int n, int _xor){
        if(i==n){
            sum += _xor;
            return;
        }

        // take
        _xor = _xor ^ arr[i];
        calculateSumOfAllXor1(arr, i+1, n, _xor);

        // not take
        _xor = _xor ^ arr[i];
        calculateSumOfAllXor1(arr, i+1, n, _xor);
    }
    static int subsetXORSumOptimal1(int[] arr) {
        int n = arr.length;
        sum =0;

        if(n==0) return sum;

        int i=0, _xor=0;

        calculateSumOfAllXor1(arr, i, n, _xor);

        return sum;
    }

    static int calculateSumOfAllXor2(int[] arr, int i, int n, int _xor){
        if(i==n){
            return _xor;
        }

        // take
        _xor = _xor ^ arr[i];
        int left = calculateSumOfAllXor2(arr, i+1, n, _xor);

        // not take
        _xor = _xor ^ arr[i];
        int right = calculateSumOfAllXor2(arr, i+1, n, _xor);

        return left + right;
    }

    static int subsetXORSumOptimal2(int[] arr) {
        int n = arr.length;

        if(n==0) return 0;

        int i=0, _xor=0;

        int res = calculateSumOfAllXor2(arr, i, n, _xor);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,6};

        // Optimal Solution 1 -> with global variable 'sum'  ->  TC: O(2^n)  ;  SC: O(n)
        int ans1 = subsetXORSumOptimal1(arr);
        System.out.println("Sum of all XOR in array : " + ans1);

        // Optimal Solution 2 -> without global variable -> TC: O(2^n)  ;  SC: O(n)
        int ans2 = subsetXORSumOptimal2(arr);
        System.out.println("Sum of all XOR in array : " + ans2);
    }
}
