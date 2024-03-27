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

    public static void main(String[] args){
        int[] arr = {10,5,2,6};
        int k = 100;

        // Brute Force : Nested For Loop  ->  TC: O(N^2) , SC: O(1)
        int ans1 = numSubarrayProductLessThanKBrute(arr, k);
        System.out.println("Count total no. of subarrays whose product is strictly less than k : "+ans1);

    }
}
