package class3;

public class reorderLinkedList {
    public ListNode reorder(ListNode head) {
        // Write your solution here
        //1.first we need to find the middle node
        //2.and then reverse the 2nd half list to get Nn->Nn-1->.....->N(2n+1)
        //3.Merge the 1st half and the 2nd half

        //corner case
        if(head==null||head.next==null){
            return head;
        }
        //step1
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //cut into 2 lists
        ListNode head2 = slow.next;
        slow.next=null;

        //step2
        ListNode half2=reverseList(head2);

        //step3
        return merge(head,half2);
    }

    private ListNode reverseList(ListNode head){
        //recursion
        //base case
        if(head==null||head.next==null){
            return head;
        }
        //recursive rules
        ListNode tail = head.next;
        ListNode newhead = reverseList(tail);
        tail.next=head;
        head.next=null;
        return newhead;
    }

    private ListNode merge(ListNode h1,ListNode h2){
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(h1!=null&&h2!=null){
            cur.next=h1;
            cur.next.next=h2;
            h1=h1.next;
            h2=h2.next;
            cur=cur.next.next;
        }
        if(h1!=null){
            cur.next=h1;
        }
        if(h2!=null){
            cur.next=h2;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        reorderLinkedList result = new reorderLinkedList();
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        ListNode s6 = new ListNode(6);
        s1.next=s2;
        s2.next=s3;
        s3.next=s4;
        s4.next=s5;
        s5.next=s6;
        s6.next=null;
        System.out.println(result.reorder(s1));
    }
}


