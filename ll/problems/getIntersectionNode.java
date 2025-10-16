package src.ll.problems;

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null || headB==null) return null;
    HashSet<ListNode> visited=new HashSet<>();
    ListNode tempA=headA,tempB=headB;
    while(tempA!=null) {
        visited.add(tempA);
        tempA=tempA.next;
    }
    while(tempB!=null){
        if(visited.contains(tempB)) return tempB;
        visited.add(tempB);
        tempB=tempB.next;
    }
    return null;
}