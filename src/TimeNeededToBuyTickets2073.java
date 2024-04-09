import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets2073 {
    static int timeRequiredToBuyBrute(int[] tickets, int k){
        int n = tickets.length;

        int pass = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(i);
        }

        while(tickets[k]!=0){
            int idx = q.peek();
            q.remove();

            if(tickets[idx]==0) continue;

            tickets[idx]--;
            pass++;

            if(tickets[idx]!=0){
                q.add(idx);
            }
        }
        return pass;
    }

    public static void main(String[] args){
        int[] tickets = {3,2,3};
        int k=1;

        // BRUTE FORCE ->  TC: O(N)*O(K*N)  ;  SC: O(N)
        int res1 = timeRequiredToBuyBrute(tickets, k);
        System.out.println("Time needed to Buy all tickets at index "+k + " is : "+res1);

    }
}
