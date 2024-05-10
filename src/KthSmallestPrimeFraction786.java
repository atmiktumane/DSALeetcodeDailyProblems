import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction786 {
    static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        // Min Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.offer(new int[]{arr[i], arr[j]});
            }
        }

        int[] result = null;
        for (int i = 0; i < k; ++i) {
            result = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k=3;

        // Solution -> Using MinHeap -> Priority Queue ->  TC: O(n*n*logK) ; SC: O(n)
        int[] res = kthSmallestPrimeFraction(arr, k);

        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }

    }
}
