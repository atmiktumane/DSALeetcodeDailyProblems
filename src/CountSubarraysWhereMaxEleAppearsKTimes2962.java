public class CountSubarraysWhereMaxEleAppearsKTimes2962 {
    static long countSubarrays(int[] nums, int k) {
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

            while(freqMaxEle>=k && i<=j){
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

        long ans = countSubarrays(arr, k);

        System.out.println("Total count of Subarrays where Max. Element Appears Atleast K Times : "+ans);
    }
}
