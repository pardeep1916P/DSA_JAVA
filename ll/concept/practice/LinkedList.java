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
        System.out.println();
        while(temp!=null) {
            if (temp != head) System.out.print("->");
            System.out.print(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean append(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
        return true;
    }

    public boolean prepend(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        length++;
        return true;

    }

    public Node get(int index){
        if(index<0 || index>length) return null;
        Node temp = head;
        for(int i=0; i<index; i++) temp = temp.next;
        return temp;
    }

    public boolean insert(int index, int value){
        if(index<0 || index>length) return false;
        else if(index == 0) return prepend(value);
        else if(index == length) return append(value);
        else{
            Node newNode = new Node(value);
            Node temp = get(index-1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
        return true;
    }

    public Node removeFirst(){
        if(head == null) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(head == null) tail = null;
        return temp;
    }

}