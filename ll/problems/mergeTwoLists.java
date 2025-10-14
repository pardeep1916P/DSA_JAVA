package src.ll.problems;

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) { //if llist1 first node is smallest
            curr.next = list1;
            list1 = list1.next;
        } else { //if llist2 first node is smallest
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }
    if (list1 != null) curr.next = list1; //if llist2 is empty
    if (list2 != null) curr.next = list2; //if llist1 is empty
    return dummy.next;
}