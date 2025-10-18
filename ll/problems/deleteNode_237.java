package src.ll.problems;

//we can not delete the node with out preceding pointer so, change its value from next node value
// 4->5->1->9     4->1->1->9   here we erased the node value but we have duplicate
//we can't delete the first 1 so, go for deleting the second 1
//4->1->9
public void deleteNode(ListNode node) {
    node.val=node.next.val;
    node.next=node.next.next;
}