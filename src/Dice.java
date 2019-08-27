
import java.util.LinkedList;

public class Dice {

    public void dicePermutations(int total) {
        for (int i = 1; i <= 6; i++)
            dicePermutations(i, total, new LinkedList<>());
    }

    private void dicePermutations(int dices, int total, LinkedList<Integer> collected) {
        if (dices == 0) {
            if (total == 0) {
                collected.stream().forEach(x -> System.out.print(x + " "));
                System.out.println();
            }
        } else if ((total >= dices * 1) && (total <= dices * 6)) {
            for (int i = 1; i <= 6; i++) {
                collected.add(i);
                dicePermutations(dices - 1, total - i, collected);
                collected.removeLast();
            }
        }
    }

    public static void main(String args[]) {
        new Dice().dicePermutations(5);
    }
}