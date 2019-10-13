package class3;

public class checkCycle {
    public boolean hasCycle(ListNode head) {
        // write your solution here
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast!=null && fast!=slow){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }

        return false;

    }
    public static void main(String[] args){
        checkCycle result = new checkCycle();
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        s1.next=s2;
        s2.next=null;
        System.out.println(result.hasCycle(s1));

    }
}
class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
}

