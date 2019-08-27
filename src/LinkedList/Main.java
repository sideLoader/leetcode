package LinkedList;

class MyLinkedList {

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    public MyLinkedList() {
        head = null;
    }

    void insertBack(int data) {
        if(head == null)
            head = new Node(data);
        else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }
    }

    void insertFront(int data) {
        Node newNode = new Node(data);
        if((head == null))
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    void skipEveryNthElement(int index) {
        if(index <= 1) return;

        Node prev = null,temp = head;
        int count = 1;
        while(temp != null) {
            if(index == count) {
                prev.next = temp.next;
                count = 0;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }
    }

    int getNthElementFromEnd(int index) {
        if(head == null) return -1;

        Node track = head,temp = head;
        int count = index;
        while(count > 0) {
            temp = temp.next;
            count--;
        }
        while(temp != null) {
            temp = temp.next;
            track = track.next;
        }
        return track.data;
    }

    void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse() {
        Node current = head;
        Node next, prev = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void reverseRecursive() { reverse(head);}
    void reverse(Node curr) {
        if(curr.next == null) {
            head = curr;
            return;
        } else {
            reverse(curr.next);
            Node temp = curr.next;
            temp.next = curr;
            curr.next = null;
        }
    }


}
public class Main {

    static MyLinkedList getList() {
        MyLinkedList list = new MyLinkedList();
        list.insertBack(1);
        list.insertBack(2);
        list.insertBack(3);
        list.insertBack(4);
        list.insertBack(5);
        list.insertBack(6);
        list.insertBack(7);
        list.insertBack(8);
        list.insertBack(9);
        list.insertBack(10);
        list.insertFront(0);
        return list;
    }

    public static void main(String args[]) {
        MyLinkedList list = getList();
        list.printList();
       // list.skipEveryNthElement(3);
       // list.printList();

    }
}
