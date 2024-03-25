// Question : 442. Find All Duplicates in an Array
// TC : O(N)
// SC : O(N) -> HashMap space

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateInArray442 {

    static List<Integer> findDuplicatesBrute(int[] arr){
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]){
                    res.add(arr[i]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};

        List<Integer> ans1 = new ArrayList<>();

        ans1 = findDuplicatesBrute(arr);

        System.out.println("All Duplicate elements present in array : " + ans1);

    }
}
