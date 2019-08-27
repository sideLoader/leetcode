import java.util.Arrays;

public class MergeSort {

    static int input[] = new int[] {4,7,1,12,24,42,2,10};
    static int tempArray[] = new int[input.length];

    public void sort(int input[]) {
        sort(0, input.length -1);
    }

    private void sort(int l, int r) {
        if(l < r) {
            int mid = (r+l)/2;

            sort(l, mid);
            sort(mid +1, r);
            merge(l, mid, r);
        }

    }

    private void merge(int l, int m, int r) {
        for(int i = l; i <= r; i++)
            tempArray[i] = input[i];

        int i = l;
        int j = m + 1;
        int k = l;

        while(i <= m && j <= r) {
            if(tempArray[i] <= tempArray[j]) {
                input[k] = tempArray[i];
                i++;
            } else {
                input[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while(i <= m) {
            input[k] = tempArray[i];
            i++;
            k++;
        }

        while(j <= r) {
            input[k] = tempArray[j];
            j++;
            k++;
        }

    }

    public static void main(String args[]) {

        new MergeSort().sort(input);
        Arrays.stream(input).forEach(x -> System.out.print(x + " "));
    }
}
