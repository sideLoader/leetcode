import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long input[] = new long[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            input[i] = sc.nextLong();

        long sum = Arrays.stream(input).sum();
        System.out.println((sum % 2 == 0) ? "YES" : "NO");
    }
}