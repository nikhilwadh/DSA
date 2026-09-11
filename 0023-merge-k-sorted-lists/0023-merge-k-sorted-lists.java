/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode list:lists)
        {
            ListNode temp=list;
            while(temp!=null)
            {
                pq.add(temp);
                temp=temp.next;
            }
        }

        ListNode head=new ListNode(-1);
        ListNode dummy=head;
        while (!pq.isEmpty()) {
            dummy.next = pq.poll();
            dummy = dummy.next;
        }
        dummy.next=null;
        return head.next;
    }
}