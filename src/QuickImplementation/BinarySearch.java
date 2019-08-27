package QuickImplementation;



public class BinarySearch {
    private static int n;
    private int data[];

    void populateData() {
        n = 7;
        data = new int[]{1, 3, 4, 6, 10, 14, 15};
    }

    int searchRecursive(int element) {
        return searchRecursive(element, 0, n - 1);
    }

    int searchRecursive(int element, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == data[mid]) return mid;
            else if (element < data[mid])
                return searchRecursive(element, start, mid - 1);
            else
                return searchRecursive(element, mid + 1, end);
        }

        return -1;
    }

    int searchIterative(int element) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == data[mid]) return mid;
            else if (element < data[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    void print() {
        for (int i : data)
            System.out.print(i + " ");
        System.out.println();
    }


    public static void main(String args[]) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.populateData();
        System.out.println(binarySearch.searchRecursive(6));
    }
}