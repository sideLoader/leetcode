import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SpecialStack {

    private class Node {
        int data, index;
        int frequency;

        public Node(int data, int index, int frequency) {
            this.data = data;
            this.index = index;
            this.frequency = frequency;
        }
    }

    int pushCount;
    PriorityQueue<Node> queue;
    Map<Integer, Integer> map;

    public SpecialStack() {
        pushCount = 0;
        queue = new PriorityQueue<>(new NodeComparator());
        map = new HashMap<>();
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return (n2.frequency == n1.frequency) ?
                    n2.index - n1.index : n2.frequency - n1.frequency;
        }
    }
    public void push(int data) {
        map.put(data, map.getOrDefault(data,0) + 1);
        queue.offer(new Node(data, pushCount, map.get(data)));
        pushCount++;
    }

    public int pop() {
        return queue.poll().data;
    }

    public static void main(String args[]) {
         SpecialStack specialStack = new SpecialStack();
         specialStack.push(5);
         specialStack.push(7);
         specialStack.push(5);
         specialStack.push(7);
         specialStack.push(4);
         specialStack.push(5);

         while(specialStack.queue.size() != 0)
             System.out.print(specialStack.pop() + " ");

    }
}
