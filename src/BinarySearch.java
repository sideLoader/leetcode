
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

class BinarySearch {
    static int input[];
    int data;

    int search(int data) {
        this.data = data;
        return search(0, input.length -1);
    }

    private int search(int start, int end) {
        if(start > end) {
            return -1;
        } else {
            int mid = start + (end - start)/2;
            return (data == input[mid]) ? mid :
                    (data < input[mid]) ? search(start, mid -1) : search(mid +1, end);
        }
    }

    public static void main(String args[]) {

        BinarySearch binarySearch = new BinarySearch();
        Scanner scanner = new Scanner(System.in);
        String ip[] = scanner.nextLine().split(" ");
        input = new int[ip.length];
        for(int i = 0; i < ip.length; i++)
            input[i] = Integer.parseInt(ip[i]);


        System.out.println(binarySearch.search(4));

    }
}
