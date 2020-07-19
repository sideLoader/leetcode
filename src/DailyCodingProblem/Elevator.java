package DailyCodingProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Elevator {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        long f = sc.nextLong();
        long s = sc.nextLong();
        long g = sc.nextLong();
        long u = sc.nextLong();
        long d = sc.nextLong();
        long counter = 0;

        if(s == g) {
            System.out.println(counter);
            return;
        }

        long tempLevel = counter;
        Queue<Long> queue = new LinkedList<>();
        queue.add(s);
        queue.add(null);

        while(!queue.isEmpty()) {
            Long temp = queue.poll();
            if(temp == null) {
                if(!queue.isEmpty())
                    queue.add(null);
                counter++;
            } else {
                if (temp == g) {
                    System.out.println(counter);
                    return;
                }
                if(!(temp + u > f)) queue.add(temp + u);
                if(!(temp - d < 0)) queue.add(temp - d);
            }
        }

        System.out.println("use the stairs");
    }
}
