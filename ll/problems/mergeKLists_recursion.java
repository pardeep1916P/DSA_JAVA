package src.ll.problems;

//helper method to merge two sorted lists
public ListNode merge(ListNode l1,ListNode l2){
    ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;
    while(l1 != null && l2 != null){
        if(l1.val <= l2.val){
            temp.next = l1;
            l1 = l1.next;
        }else{
            temp.next = l2;
            l2 = l2.next;
        }
        temp = temp.next;
    }
    if(l1!=null) temp.next = l1;
    if(l2!=null) temp.next = l2;
    return dummy.next;
}

// recursive divide and conquer
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    return mergeKListsHelper(lists, 0, lists.length - 1);
}

private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
    if (start == end) return lists[start]; // base case: single list
    if (start > end) return null; // invalid case

    int mid = start + (end - start) / 2;
    // divide
    ListNode left = mergeKListsHelper(lists, start, mid);
    ListNode right = mergeKListsHelper(lists, mid + 1, end);
    // conquer
    return merge(left, right);
}