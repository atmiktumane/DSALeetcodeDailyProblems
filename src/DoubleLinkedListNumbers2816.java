import java.util.Stack;

public class DoubleLinkedListNumbers2816 {
    static ListNode doubleLinkedList(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode temp = head;
        while(temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }

        int num, rem, carry;

        num = st.peek();
        st.pop();

        num = num*2;
        rem = num%10;
        carry = num/10;

        ListNode newNode = new ListNode(rem);
        newNode.next = null;

        while(!st.isEmpty()){
            num = st.peek();
            st.pop();

            num *= 2;
            num += carry;

            rem = num%10;
            carry = num/10;

            ListNode curr = new ListNode(rem);
            curr.next = newNode;
            newNode = curr;
        }

        if(carry >0){
            ListNode curr = new ListNode(carry);
            curr.next = newNode;
            newNode = curr;
        }

        return newNode;
    }

    static int recursiveFn(ListNode head){
        if(head==null){
            return 0;
        }

        int carry = recursiveFn(head.next);

        int num = head.val;
        num = num * 2; // double
        num = num + carry; // add carry

        int rem = num % 10;
        carry = num/10;

        head.val = rem;
        return carry;

    }

    static ListNode doubleItBetter(ListNode head) {
        int carry = recursiveFn(head);

        if(carry > 0){
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }
        return head;
    }

    static ListNode doubleItOptimal(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        int num = curr.val * 2;
        int rem = num%10;
        int carry = num/10;

        curr.val = rem;

        if(carry > 0){
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }

        prev = curr;
        curr = curr.next;

        while(curr != null){
            num = curr.val * 2;
            rem = num%10;
            carry = num/10;

            curr.val = rem;

            if(carry > 0){
                prev.val = prev.val + carry;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListImplementation.buildLL();
        LinkedListImplementation.printLL(head);

        // Better Solution : Using stack -> creating new LinkedList ->  TC: O(N) ; SC: O(N)
//        ListNode newHead1 = doubleLinkedList(head);
//        LinkedListImplementation.printLL(newHead1);

        // Better Solution 2 : Using recursion -> modifying given LinkedList -> TC: O(N) ; SC: O(N)
//        ListNode newHead2 = doubleItBetter(head);
//        LinkedListImplementation.printLL(newHead2);

        // Optimal Solution  : Using Left To Right LL traversal -> modifying given LinkedList -> TC: O(N) ; SC: O(1)
        ListNode newHead3 = doubleItOptimal(head);
        LinkedListImplementation.printLL(newHead3);
    }
}
