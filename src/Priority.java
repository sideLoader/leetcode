import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " -> " + age;
    }
}

public class Priority {

    public static void main(String args[]) {

       /* List<Person> personList = Arrays.asList(
            new Person("jhgf",67),
            new Person("nb",45),
            new Person("nb", 42),
            new Person("bv", 78)
        );

        Comparator<Person> personComparator = (p1, p2) -> {
          int firstPass = p1.name.compareTo(p2.name);

          return (firstPass == 0) ? p1.age - p2.age : firstPass;
        };

        //personList.stream().sorted(personComparator).forEach(System.out::println); */


        Queue<Integer> q = new PriorityQueue<>((n1, n2) -> n1 - n2);

        //Queue<Person> heap = new PriorityQueue<>(personComparator);

        for(int i = 10; i >= 0; i--) {
            if(q.size() > 5)
                q.poll();
             else {
                 q.add(i);
            }
        }

        while(q.size() != 0) {
            System.out.println(q.poll());
        }
    }
}
