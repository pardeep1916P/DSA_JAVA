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
    }

    public void getHead(){
        System.out.println();
        if(head == null) System.out.print("null");
        else System.out.print("HEAD->"+ head.value);
    }

    public void getTail(){
        System.out.println();
        if(tail == null) System.out.print("null");
        else System.out.print("TAIL->"+ tail.value);
    }

    public void getLength(){
        System.out.println();
        System.out.print("LENGTH->"+length);
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

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp!=null){
            temp.value = value;
            return true;
        }
        return false;
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

    public Node removeLast(){
        if(head == null) return null;
        Node pre = head;
        Node temp = head;

        while(temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;

    }

    public Node remove(int index){
        if(index<0 || index>=length) return null;
        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();
        Node pre = get(index-1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

}