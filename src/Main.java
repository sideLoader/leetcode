import java.util.*;
import java.util.stream.Collectors;

public class Main {

    //map to hold bucketId & its contents.
    static Map<Integer, ArrayList<Integer>> basket = new HashMap<>();
    //map to hold bucketId & the size of its contents
    static Map<Integer, Integer> basketCount = new HashMap<>();

    /**
     * Among all buckets @filteredBasket,
     * prints only if the bucket has all the target elements @targetItems
     *
     * @param filteredBasket basketIds after filtering by threshold
     * @param targetItems    list of target elements
     */
    private static void printBasketContainingOnlySomeItems(
            List<Integer> filteredBasket,
            List<Integer> targetItems)
    {
        filteredBasket.forEach(x -> {
            List<Integer> basketContents = basket.get(x);
            if (basketContents.containsAll(targetItems))
                System.out.print(x + ", ");
        });
        System.out.println();
    }

    public static void main(String args[]) {

        //populating the bucket
        for (int i = 1; i <= 150; i++) {
            basketCount.put(i, 1);
            for (int j = 1; j <= i; j++) {
                if (basket.containsKey(i)) {
                    List<Integer> value = basket.get(i);
                    if (i % j == 0) {
                        value.add(j);
                        basketCount.put(i, basketCount.get(i) + 1);
                    }
                } else
                    basket.put(i, new ArrayList<>(Arrays.asList(1)));
            }
        }

        int threshold = 5;
        //filtering buckets based on threshold
        List<Integer> filteredBasket = basketCount.keySet()
                .stream()
                .filter(x -> basketCount.get(x) >= threshold)
                .collect(Collectors.toList());

        System.out.println("If the support threshold is  5 , which items are frequent?");
        filteredBasket.forEach(x -> System.out.print(x + ", "));
        System.out.println();

        System.out.println("If the support threshold is  5  then  (5,20)  is a frequent pair of items.");
        printBasketContainingOnlySomeItems(filteredBasket, Arrays.asList(5, 20));

        System.out.println("For a support threshold of  5 , give three different frequent triples containing item  10 . For each frequent triple, list 5 basket numbers where the different items appear together.");
        System.out.println("Frequent triple 1: (10, 1, 2)");
        printBasketContainingOnlySomeItems(filteredBasket, Arrays.asList(10, 1, 2));

        System.out.println("Frequent triple 2: (10, 4, 5)");
        printBasketContainingOnlySomeItems(filteredBasket, Arrays.asList(10, 4, 5));

        System.out.println("Frequent triple 3: (10, 6, 15)");
        printBasketContainingOnlySomeItems(filteredBasket, Arrays.asList(10, 6, 15));




    }

}