package src.ll.problems;

public Node copyRandomList(Node head) {
    if(head == null) return head;
    //creating hashMap to stop pair of original and copy nodes
    HashMap<Node,Node> map = new HashMap<>();
    //copying
    Node newHead = new Node(head.val);
    Node temp1 = head.next;
    Node temp2 = newHead;
    map.put(head,newHead);
    while(temp1!=null){
        Node newNode = new Node(temp1.val);
        map.put(temp1,newNode);
        temp2.next = newNode;
        temp2 = temp2.next;
        temp1 = temp1.next;
    }
    //assigning random of new copy ll
    temp1 = head;
    temp2 = newHead;
    while(temp1!=null){
        temp2.random = map.get(temp1.random);
        temp1 = temp1.next;
        temp2 = temp2.next;
    }
    return newHead;
}