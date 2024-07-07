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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        ListNode temp = null;
        ListNode current = temp;
        ListNode next = null;

        while(list1 != null && list2 != null) {

            if(list1.val <= list2.val) {
                next = list1;
                list1 = list1.next;

            }
            else {
                next = list2;
                list2 = list2.next; 
            }

            if(current == null && temp == null) {
                current = next;
                temp = next;
            } else {
                current.next = next;
                current = current.next;
            }
        }

        if(list1 != null) {
            current.next = list1;
        }

        else if(list2 != null) {
            current.next = list2;
        }
        return temp;
    }
}

/**
    1,2,4.  1,3,4
    
    1 1 2 3 4 

 */
