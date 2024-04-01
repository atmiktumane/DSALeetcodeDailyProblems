// Question : 287. Find the duplicate element
// TC : O(N)
// SC : O(1)

import java.util.HashMap;

public class FindDuplicateNumber287 {

    static int findDuplicateBetter(int[] arr) {
        int n = arr.length;
        if(n==0 || n==1) return -1;

        HashMap<Integer, Integer> mp = new HashMap<>();

        // store (element + occurence) in HashMap
        for(int i=0; i<n; i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], 1);
            }
            else{
                mp.put( arr[i], mp.get(arr[i])+1 );
            }
        }

        for(int key: mp.keySet()){
            if(mp.get(key) > 1){
                return key;
            }
        }

        return -1;

    }

    static int findDuplicateOptimal(int[] nums){
        int n = nums.length;
        if(n==0 || n==1) return -1;

        for(int i=0; i<n; i++){
            int num = Math.abs(nums[i]);
            int idx = num-1;

            if(nums[idx] <0) return num;
            else{
                nums[idx] *= -1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,2};

        // Better Solution : HashMap
        int dupElement = findDuplicateBetter(arr);
        System.out.println("Duplicate Element in given input array : "+dupElement);

        // Optimal Solution : elements in range [1,n], mark visited elements to -ve
        int dupElement1 = findDuplicateOptimal(arr);
        System.out.println("Duplicate Element in given input array : "+dupElement1);
    }
}
