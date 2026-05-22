class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }
    
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public int get(int index) {
        if(size == 0) return -1;
        if(index > size - 1) return -1;
        if(index == 0) return this.head.val;
        if(index == size - 1) return this.tail.val;

        Node current = this.head;
        
        for(int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void insertHead(int val) {
        Node current = new Node(val);
        if(size == 0) {
            this.head = current;
            this.tail = current;
            size++;
        } else {
            current.next = this.head;
            this.head = current;
            size++;
        }
    }

    public void insertTail(int val) {
        Node current = new Node(val);
        if(size == 0) {
            this.head = current;
            this.tail = current;
            size++;
        } else {
            this.tail.next = current;
            this.tail = current;
            size++;
        }
    }

    public boolean remove(int index) {
        if(size == 0) return false;
        if(size == 1 && index == 0) { this.head = null; this.tail = null; size--; return true; }
        if(index > size - 1) return false;
        if(index == 0) { this.head = this.head.next; size--; return true; }

        Node previous = this.head;
        Node current = previous.next;
        this.head = previous;

        for(int i = 0; i<index-1; i++) {
            previous = current;
            current = current.next;
        } 
        if(index == size - 1) {
            this.tail = previous;
            this.tail.next = null;
            size--;
            return true;
        } else {
            previous.next = previous.next.next;
            size--;
            return true;
        }
        
    }

    public ArrayList<Integer> getValues() {
        ArrayList list = new ArrayList<>();
        if(size == 0) return list;
        Node current = this.head;
        for(int i = 0; i < size - 1; i++) {
            list.add(current.val);
            current = current.next;
        }
        list.add(current.val);
        return list;
    }
}
