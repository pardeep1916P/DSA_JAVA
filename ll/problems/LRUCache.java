package src.ll.problems;

class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int limit;
    private HashMap<Integer,Node> map;



    public LRUCache(int capacity) {
        this.limit = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        return addNode(node).value;
    }

    //helper method to delete a Node in dll
    private void deleteNode(Node oldNode){
        Node p1 = oldNode.prev;
        Node p2 = oldNode.next;
        p1.next = p2;
        p2.prev = p1;
    }

    //helper method to add node after head in dll
    private Node addNode(Node newNode){
        Node old = head.next;
        head.next = newNode;
        old.prev = newNode;
        newNode.next = old;
        newNode.prev = head;
        return newNode;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            deleteNode(old);
            map.remove(key);
        }
        if(map.size() == limit){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key,value);
        map.put(key,addNode(newNode));
    }
}