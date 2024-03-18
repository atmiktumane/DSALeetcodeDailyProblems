import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    ListNode(){
        this.next = null;
    }
}

public class LinkedListImplementation {
    public static ListNode buildLL(){
        int n=-1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n==-1) return null;

        ListNode head = new ListNode(n);
        head.next = buildLL();
        return head;
    }

    public static void printLL(ListNode head){
        if(head==null) return;

        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL ");
    }

    public static void main(String[] args){
        ListNode head = buildLL();

        // print Input LinkedList
        printLL(head);
    }
}
