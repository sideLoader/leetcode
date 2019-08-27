import java.util.LinkedList;

public class MinimumDenomination {

    public static void main(String args[]) {
        int denom[] = new int[] {1,2,5,10,20,25};

        int amount = 40, count = 0;
        LinkedList<Integer> solution = new LinkedList();
        for(int i = denom.length -1; i >= 0 && amount > 0;) {
            if(denom[i] <= amount) {
                amount -= denom[i];
                count++;
                solution.addLast(denom[i]);
            } else {
                i--;
            }
        }

        System.out.println(count);
        solution.stream().forEach(x -> System.out.print(x + " "));

    }
}