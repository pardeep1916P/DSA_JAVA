package src.ll.problems;

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null || headB==null) return null;
    ListNode tempA=headA,tempB=headB;
    while(tempA!=tempB){
        tempA = (tempA!=null)? tempA.next:headB;
        tempB = (tempB!=null)? tempB.next:headA;
    }
    return tempA;
}