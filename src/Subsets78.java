import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    static void generateSubsetFn(int[] arr, int i, int n, List<Integer> ds, List<List<Integer>> res){
        if(i==n){
//            System.out.println(ds);
            res.add(new ArrayList<>(ds));
            return;
        }

        // take
        ds.add(arr[i]);
        generateSubsetFn(arr, i+1, n, ds, res);

        // not take
        ds.remove(ds.size()-1);
        generateSubsetFn(arr, i+1, n, ds, res);
    }

    static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        // edge case
        if(n==0) return res;

        List<Integer> ds = new ArrayList<>();
        int i=0;

        generateSubsetFn(nums, i, n, ds, res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        // Optimal Solution : Recursion -> TC: O(2^n * n) -> extra n time for storing elements in List 'ds'  ; SC: O(n)
        List<List<Integer>> ans = new ArrayList<>();

        ans = subsets(nums);

        System.out.println(ans);
    }
}
