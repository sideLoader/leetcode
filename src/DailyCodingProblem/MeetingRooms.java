package DailyCodingProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Meeting implements Comparable {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        Meeting that = (Meeting)o;
        int diff = this.start - that.start;

        return (diff == 0) ? this.end - this.end : diff;
    }

    @Override
    public String toString() {
        return "(" + this.start + ", " + this.end + ")";
    }
}

public class MeetingRooms {

    public static void main(String[] args) {
        Meeting input[] = new Meeting[]{
                new Meeting(0, 30),
                new Meeting(5, 10),
                new Meeting(15, 20)
        };

        //Arrays.sort(input);

        Queue<Integer> q = new PriorityQueue<>();
        q.add(input[0].end);

        for (int i = 1; i < input.length; i++) {
            if (input[i].start >= q.peek()) {
                q.poll();
            }
            q.add(input[i].end);
        }

        System.out.println(q.size());


    }
}
