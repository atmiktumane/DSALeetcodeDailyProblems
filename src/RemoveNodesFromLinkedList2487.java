import java.util.Stack;

public class RemoveNodesFromLinkedList2487 {
    static ListNode removeNodesStack(ListNode head){
        if(head== null || head.next == null) return head;

        ListNode temp = head;
        Stack<Integer> st = new Stack<>();

        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }

        int maxEle = st.peek();
        st.pop();

        ListNode newHead = new ListNode(maxEle);
        newHead.next = null;

        while(!st.isEmpty()){
            if(maxEle > st.peek()){
                st.pop();
            }
            else{
                maxEle = st.peek();
                st.pop();
                ListNode l1 = new ListNode(maxEle);
                l1.next = newHead;
                newHead = l1;
            }
        }
        return newHead;
    }

    static ListNode removeNodesRecursion(ListNode head){
        if(head== null || head.next == null) return head;

        ListNode newNode = removeNodesRecursion(head.next);

        if(head.val < newNode.val){
            // delete head;
            return newNode;
        }
        else{
            head.next = newNode;
            return head;
        }
    }

    static ListNode reverseFn(ListNode head){
        // if(head== null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nexPtr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexPtr;
        }
        return prev;
    }

    static ListNode removeNodes(ListNode head) {
        if(head== null || head.next == null) return head;

        ListNode newHead = reverseFn(head);

        ListNode prev = newHead;
        ListNode curr = newHead.next;
        int maxEle = newHead.val;

        while(curr != null){
            ListNode nexPtr = curr.next;

            if(curr.val < maxEle){
                prev.next = nexPtr;
                curr = nexPtr;
            }
            else{
                maxEle = curr.val;
                prev = curr;
                curr = nexPtr;
            }
        }

        return reverseFn(newHead);
    }

    public static void main(String[] args) {
        // 5 -> 2 -> 13 -> 3 -> 8 -> null

        ListNode head = LinkedListImplementation.buildLL();

        LinkedListImplementation.printLL(head);

        // Better Solution 1 : Using Stack ->  TC: O(N) ; SC: O(N)
        ListNode head1 = removeNodesStack(head);
        LinkedListImplementation.printLL(head1);

        // Better Solution 2 : Using Recursion -> TC: O(N) ; SC: O(N)
        ListNode head2 = removeNodesRecursion(head);
        LinkedListImplementation.printLL(head2);

        // Optimal Solution : Reverse LinkedList and then find solution -> TC: O(N) ; SC: O(1)
        ListNode head3 = removeNodes(head);
        LinkedListImplementation.printLL(head3);
    }
}
