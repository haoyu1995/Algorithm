package Strengthpractice2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.

        //solution : k-way together + minheap

        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(listOfLists.size(),
                new Comparator<ListNode>(){
                    @Override
                    public int compare(ListNode o1, ListNode o2){
                        if (o1.value == o2.value){
                            return 0;
                        }
                        return o1.value < o2.value ? -1: 1;
                    }
                });

        // offer all start node of k lists into min heap
        int k = listOfLists.size();
        for (int i = 0; i < k; i++){
            minheap.offer(listOfLists.get(i));
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minheap.isEmpty()){
            ListNode temp = minheap.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null){
                minheap.offer(temp.next);
            }
        }
        return dummy.next;
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
