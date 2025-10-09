package src.ll;

public class LinkedList{
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int length;
    public LinkedList(int value){
        Node newNode =new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void printList(){
        if(head==null){
            System.out.println("Empty");
        }
        Node temp=head;

        while(temp!= null){
            System.out.print(temp.value);
            if(temp!=tail){
                System.out.print("->");
            }
            temp=temp.next;
        }
        System.out.println();
    }
    public void getHead(){
        if (head==null) {
            System.out.println("Empty");
        }else{
            System.out.println("Head :" + head.value);
        }
    }
    public void getTail(){
        if (tail==null) {
            System.out.println("Empty");
        }else{
            System.out.println("Tail :" + tail.value);
        }
    }
    public void getLength(){
            System.out.println("Length :" + length);
    }
}