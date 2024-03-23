// Question : 143. Reorder List
// TC : O(N)
// SC : O(N)    -> extra space of stack to store all nodes

import java.util.Stack;

public class ReorderList143 {

    static void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode temp = head;
        int size = 0;
        Stack<ListNode> st = new Stack<>();

        // find size of LinkedList and store all nodes in stack
        while(temp!=null){
            st.push(temp);
            size++;
            temp = temp.next;
        }

        ListNode curr = head;
        int k = size/2;

        while(k>0){
            ListNode topNode = st.peek();
            st.pop();
            temp = curr.next;
            curr.next = topNode;
            topNode.next = temp;
            curr = temp;
            k--;
        }
        curr.next = null;

    }

    public static void main(String[] args){
        // user-input LinkedList
        ListNode head = LinkedListImplementation.buildLL();

        // void function to reorder the LinkedList according to given Question
        reorderList(head);

        // print LinkedList
        LinkedListImplementation.printLL(head);
    }
}
