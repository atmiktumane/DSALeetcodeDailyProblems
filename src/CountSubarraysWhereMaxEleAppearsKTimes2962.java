// Question: 2962. Count Subarrays Where Max Element appears atleast K times
// TC : O(N)
// SC : O(1)
public class CountSubarraysWhereMaxEleAppearsKTimes2962 {

    static long countSubarraysBrute(int[] nums, int k) {
        int n = nums.length;

        if(n < k) return 0;

        // get max Element
        int maxEle = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > maxEle){
                maxEle = nums[i];
            }
        }

        long res = 0;

        for(int i=0; i<n; i++){
            int freq=  0;
            for(int j=i; j<n; j++){
                if(nums[j] == maxEle){
                    freq++;
                }

                if(freq >= k){
                    res++;
                }
            }
        }
        return res;
    }
    static long countSubarraysOptimal(int[] nums, int k) {
        int n = nums.length;

        if(n < k) return 0;

        // get max Element
        int maxEle = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > maxEle){
                maxEle = nums[i];
            }
        }

        long res = 0;
        int freqMaxEle = 0; // frequency of max. element

        int i=0, j=0;

        while(j<n){
            if(nums[j] == maxEle){
                freqMaxEle++;
            }

            while(freqMaxEle>=k && i<j){
                res += n-j;
                if(nums[i] == maxEle){
                    freqMaxEle--;
                }
                i++;
            }
            j++;
        }

        return res;

    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,3};
        int k=2;

        // Brute Force Approach : Nested For loop  ->  TC: O(N^2) , SC: O(1)
        long ans1 = countSubarraysBrute(arr, k);
        System.out.println("Total count of Subarrays where Max. Element Appears Atleast K Times : "+ans1);

        // Optimal Approach : Sliding Window  ->  TC: O(N) , SC: O(1)
        long ans2 = countSubarraysOptimal(arr, k);
        System.out.println("Total count of Subarrays where Max. Element Appears Atleast K Times : "+ans2);
    }
}
