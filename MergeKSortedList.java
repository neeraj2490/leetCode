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
        
        int len = lists.length;
    
        if(len == 0) {
            return null;
        }

        if(len == 1) {
            return lists[0];
        }

        ListNode prev = null;
        ListNode returnPointer = null;

        for(int i = 0; i < len; i++) {
            ListNode currentList = lists[i];
            ListNode start = null;
            ListNode current = null;
            ListNode next = null;

            while(prev != null && currentList!= null) {

                if(currentList.val <= prev.val) {
                    next = currentList;
                    currentList = currentList.next;
                }

                else {
                    next = prev;
                    prev = prev.next;
                }

                if(start == null && current == null) {
                    start = next;
                    current = next;
                } else {
                    current.next = next;
                    current = current.next;
                }
            }

            if(currentList != null && current != null) {
                current.next = currentList;
            }

            else if(prev != null && current != null) {
                current.next = prev;
            }

            else if (currentList != null && current == null) {
                start = currentList;
            }

            else if(prev!= null && current == null) {
                start = prev;
            }

            prev = start;
            returnPointer = start;
        }

        return returnPointer;
    }
}
