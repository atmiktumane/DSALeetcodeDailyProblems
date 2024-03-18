// Question : 349. Intersection Of Two Arrays
// TC : O(M+N)
// SC : O(M) // using extra space for taking HashSet

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOf2Arrays349 {
    public static void main(String[] args){
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

        int m = arr1.length;
        int n = arr2.length;

        HashSet<Integer> set1 = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();

        // add arr1 elements to Set
        for(int i=0; i<m; i++){
            set1.add(arr1[i]);
        }

        // traverse arr2 and compare arr2 elements with Set elements
        for(int j=0; j<n; j++){
            if(set1.contains(arr2[j])){
                res.add(arr2[j]);
                boolean removed = set1.remove(arr2[j]);
            }
        }

        System.out.println("Intersection of Two Arrays : "+ res);
    }
}
