// Question : 1171. Remove Zero sum consecutive nodes from LinkedList
// TC : O()
// SC : O()

import java.util.HashMap;

public class Remove0SumConsecutiveListNode1171 {
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int psum = 0;

        ListNode l1 = dummy;
        HashMap<Integer, ListNode> mp = new HashMap<>();

        while(l1 != null){
            psum += l1.val;
            if(!mp.containsKey(psum)){
                mp.put(psum, l1);
            }
            else{
                ListNode start = mp.get(psum);
                ListNode temp = start.next;
                int var = psum;
                while(temp!=l1){
                    var += temp.val;
                    mp.remove(var);
                    temp = temp.next;
                }
                start.next = temp.next;
            }
            l1 = l1.next;

        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = LinkedListImplementation.buildLL();

        // print Input LinkedList
        LinkedListImplementation.printLL(head);

        ListNode newHead = removeZeroSumSublists(head);

        LinkedListImplementation.printLL(newHead);
    }
}
