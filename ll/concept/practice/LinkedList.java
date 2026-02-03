package src.ll.concept.practice;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            if(temp != head) System.out.print("->");
            System.out.print(temp.value);
            temp = temp.next;
        }
    }

}