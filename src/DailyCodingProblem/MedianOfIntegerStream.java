package DailyCodingProblem;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfIntegerStream {

    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half

    public MedianOfIntegerStream(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        int input[] = {41,35,62,5,97,108};

        MedianOfIntegerStream ms = new MedianOfIntegerStream();

        for(int temp : input) {
            ms.addNum(temp);
            System.out.println(ms.findMedian());
        }

    }
}
