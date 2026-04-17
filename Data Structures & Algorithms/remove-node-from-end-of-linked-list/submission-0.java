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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 뒤에서 n번째를 찾기 위한 reverse 로직
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // dummy 코드
        ListNode reversedHead = prev;
        ListNode dummy = new ListNode();
        dummy.next = reversedHead;

        ListNode node = dummy;
        
        // n번째 찾고 remove하기
        for(int i = 0; i < n - 1; i++){
            node = node.next;
        }

       node.next = node.next.next;

        // 다시 reverse ?
        prev = null;
        curr = dummy.next;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
