package DailyCodingProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class MergeKSortedLists {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node mergeList(Node firstList, Node secondList) {
        if(firstList == null) return secondList;
        if(secondList == null) return firstList;

        Node current;

        if(firstList.data < secondList.data) {
            current = firstList;
            current.next = mergeList(firstList.next, secondList);
        } else {
            current = secondList;
            current.next = mergeList(firstList, secondList.next);
        }

        return current;
    }

    private static void print(Node list) {
        Node temp = list;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node insert(Node ... nodes) {
        return Arrays.stream(nodes)
                .reduce((a,b) -> mergeList(a,b))
                .get();
    }

    public static void main(String[] args) {
        Node firstNode = new Node(2);
        firstNode.next = new Node(5);
        firstNode.next.next = new Node(10);

        Node secondNode = new Node(1);
        secondNode.next = new Node(3);
        secondNode.next.next = new Node(9);


        Node thirdNode = new Node(90);
        thirdNode.next = new Node(4);

        Node fourthNode = new Node(56);
        fourthNode.next = new Node(1009);

        print(mergeList(
                mergeList(fourthNode, secondNode),
                mergeList(thirdNode, firstNode)
        ));

    }
}
