package src.ll.problems;

public Node flatten(Node head) {
    if(head == null) return head;
    Node curr = head;
    while(curr != null){
        if(curr.child != null){ // if child exists
            Node next = curr.next;
            curr.next = flatten(curr.child); //recursive call to same method
            curr.next.prev = curr;
            curr.child = null;
            while(curr.next != null) curr = curr.next; // finding tail of child's flatten list
            if(next != null){   //if it is the not last node
                curr.next = next;
                next.prev = curr;
            }
        }
        curr = curr.next;
    }
    return head;
}