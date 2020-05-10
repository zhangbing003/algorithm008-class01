package linkedListCycle;

import java.util.HashSet;

public class Solution {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hash表，之前是否已访问
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
