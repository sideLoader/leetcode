package QuickImplementation;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SortedArray {

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(l1 == null && l2 != null) {
            curr.next = new ListNode(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }

        while(l1 != null && l2 == null) {
            curr.next = new ListNode(l1.val);
            l1 = l1.next;
            curr = curr.next;
        }

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }

        return head.next;

    }


    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int last = n -1;

        while(last != 0) {
            int i = 0, j = last;

            while(i < j) {
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                i++; j--;

                if(i >= j)
                    last = j;
            }
        }
        return lists[0];
    }

    public static void main(String args[]) {

    }
}