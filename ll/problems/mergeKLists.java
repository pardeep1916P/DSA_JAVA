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

public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0) return null;
    int n = lists.length;
    //merging first and last lists of array until length of array is 1
    while(n>1){
        int i=0;
        for(;i < n/2 ;i++){
            //merging first and last
            lists[i] = merge(lists[i],lists[n-i-1]);
        }
        n = (n+1)/2;
    }
    return lists[0];
}