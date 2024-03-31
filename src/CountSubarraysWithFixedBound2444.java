public class CountSubarraysWithFixedBound2444 {
    static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        int minPos=-1, maxPos=-1, culpritPos=-1;

        long ans = 0;

        for(int i=0; i<n; i++){
            if(nums[i]<minK || nums[i]>maxK){
                culpritPos = i;
            }
            if(nums[i]==minK){
                minPos = i;
            }
            if(nums[i]==maxK){
                maxPos = i;
            }

            int smallerIndex = Math.min(minPos, maxPos);
            int temp = smallerIndex - culpritPos;

            if(temp <=0){
                ans += 0;
            }
            else{
                ans += temp;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,2,7,5};
        int minK = 1;
        int maxK = 5;

        long res = countSubarrays(nums, minK, maxK);

        System.out.println("Total number of subarrays with Fixed Bound : "+res);
    }
}
