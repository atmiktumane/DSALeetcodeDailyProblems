// Question : 621. Task Scheduler
// TC : O(N) -> Priority Queue (Constant time of log(26) + HashMap O(26) + Array Traversed O(N)
// SC : constant space for Priority Queue O(26) + HashMap O(26)

import java.util.*;

public class TaskScheduler621 {
    static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();

        for(char t : tasks){
            counts.put(t, counts.getOrDefault(t,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue(counts.size(), Collections.reverseOrder());
        pq.addAll(counts.values());

        int result = 0;
        while(!pq.isEmpty()){
            int time = 0;
            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                if(!pq.isEmpty()){
                    tmp.add(pq.remove()-1);
                    time++;
                }
            }
            for(int t: tmp){
                if(t>0) pq.add(t);
            }
            result += pq.isEmpty() ? time : n+1;
        }
        return result;
    }
    public static void main(String[] args){
        char[] arr = {'A','A','A','B','B','B'};
        int n = 3;

        int res = leastInterval(arr, n);

        System.out.println("The minimum number of intervals to complete all tasks : "+res);
    }
}
