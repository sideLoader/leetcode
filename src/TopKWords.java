
import java.util.*;

public class TopKWords {

    public static void main(String args[]) {
        List<String> words = Arrays.asList("list","of","of","words","list","list");

        Map<String, Integer> count = new HashMap<>();
        for(String word : words)
            count.put(word, count.getOrDefault(word, 0) +1);

        List<String> result = new ArrayList(count.keySet());
        Collections.sort(result, (w1, w2) ->
            count.get(w1) != count.get(w2) ? count.get(w2) - count.get(w1) :
            w1.compareTo(w2));

        result.stream().forEach(System.out::println);

        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> count.get(w1) != count.get(w2) ?
                        count.get(w1) - count.get(w2) : w2.compareTo(w1) );

        for(String word : count.keySet()) {
            heap.offer(word);
            if(heap.size() > 2) heap.poll();
        }

        List<String> resultHeap = new ArrayList<>();
        while(!heap.isEmpty()) resultHeap.add(heap.poll());

        resultHeap.stream().forEach(System.out::println);

    }
}
