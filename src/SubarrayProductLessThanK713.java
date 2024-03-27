public class SubarrayProductLessThanK713 {

    static int numSubarrayProductLessThanKBrute(int[] nums, int k){
        int n = nums.length;

        int count = 0;

        for(int i=0; i<n; i++){
            int res = 1;
            for(int j=i; j<n; j++){
                res *= nums[j];
                if(res < k){
                    count++;
                }
            }
        }
        return count;
    }

    static int numSubarrayProductLessThanKOptimal(int[] nums, int k) {
        int n = nums.length;

        // edge case
        if(k<=1 || n==0){ // k=0  or  k=1
            return 0; // 0 total subarrays with product less than 1 because of constraint i.e., 1 <= nums[i] <= 1000
        }

        int i=0, j=0;

        int res = 1;
        int count = 0;

        while(j < n){
            res *= nums[j];

            while(res>=k && i<=j){
                res /= nums[i];
                i++;
            }

            if(res < k){
                count += j-i+1;

            }
            j++;
        }
        return count;
    }


    public static void main(String[] args){
        int[] arr = {10,5,2,6};
        int k = 100;

        // Brute Force : Nested For Loop  ->  TC: O(N^2) , SC: O(1)
        int ans1 = numSubarrayProductLessThanKBrute(arr, k);
        System.out.println("Count total no. of subarrays whose product is strictly less than k : "+ans1);

        // Optimal Approach : Sliding Window  ->  TC: O(N) , SC: O(1)
        int ans = numSubarrayProductLessThanKOptimal(arr, k);
        System.out.println("Count total no. of subarrays whose product is strictly less than k : "+ans);

    }
}
