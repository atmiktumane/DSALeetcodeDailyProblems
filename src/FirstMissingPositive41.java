import java.util.HashSet;

public class FirstMissingPositive41 {

    static int firstMissingPositiveBetter(int[] arr){
        int n = arr.length;

        HashSet<Integer> sp = new HashSet<>();

        for(int i=0; i<n; i++){
            sp.add(arr[i]);
        }

        for(int i=1; i<Integer.MAX_VALUE; i++){
            if(sp.contains(i)) continue;
            else return i;
        }

        return -1;
    }
    static int firstMissingPositiveOptimal(int[] nums) {
        int n = nums.length;

        boolean contains1 = false;

        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                contains1 = true;
            }

            if(nums[i]<=0 || nums[i]>n){ // [1, n]
                nums[i] = 1;
            }
        }

        if(contains1 == false) return 1;

        for(int i=0; i<n; i++){
            int num = Math.abs(nums[i]);
            int idx = num-1;

            if(nums[idx] < 0) continue;

            nums[idx] *= -1;
        }

        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }

        return n+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,11,12};

        // Better Approach using HashSet
        int res1 = firstMissingPositiveBetter(arr);
        System.out.println("First Missing Positive : "+res1);

        // Optimal Approach using {number as index} pattern which is also used in "Find Repeat and Missing Number"
        int res = firstMissingPositiveOptimal(arr);
        System.out.println("First Missing Positive : "+res1);
    }
}
