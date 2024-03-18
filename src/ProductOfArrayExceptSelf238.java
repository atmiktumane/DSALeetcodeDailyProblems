// Question : 238. Product of Array Except Self
// Explanation : return result array having product of all elements except current element

public class ProductOfArrayExceptSelf238 {
    static void printArray(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }System.out.println();
    }

    static void productExceptSelfBrute(int[] arr){
        int n = arr.length;

        int[] res = new int[n];

        for(int i=0; i<n; i++){
            int temp = 1;
            for(int j=0; j<n; j++){
                if(i != j){
                    temp *= arr[j];
                }
            }
            res[i] = temp;
        }

        printArray(res);
    }

    static void productExceptSelfBetter(int[] arr){
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int[] res = new int[n];

        // insert product elements in leftPrefix array
        left[0] = 1;
        for(int i=1; i<n; i++){
            left[i] = left[i-1] * arr[i-1];
        }

        // insert product elements in rightSuffix array
        right[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1] * arr[i+1];
        }

        // insert product elements to result array
        for(int i=0; i<n; i++){
            res[i] = left[i] * right[i];
        }

        printArray(res);
    }

    static void productExceptSelfOptimal(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        if(n==0 || n==1) return ;

        res[0]=1;

        // product of (all left elements to the current element)
        for(int i=1; i<n; i++){
            res[i] = res[i-1] * arr[i-1];
        }

        int right_product = 1;
        for(int i=n-1; i>=0; i--){
            res[i] = res[i] * right_product;
            right_product *= arr[i];
        }

        printArray(res);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};

        // Brute force Approach  ->  TC: O(N^2)  ;  SC: O(1)
//        productExceptSelfBrute(arr);

        // Better Approach ->  TC: O(3N)  ;   SC: O(2N)
//        productExceptSelfBetter(arr);

        // Optimal Approach -> TC: O(N)  ; SC: O(1)
        productExceptSelfOptimal(arr);
    }
}
