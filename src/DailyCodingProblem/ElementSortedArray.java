package DailyCodingProblem;

public class ElementSortedArray {



    public static int binSearch(int input[], int s, int e, int num) {
        if(e >= s) {
            int mid = s + (e - s)/2;
            if(num == input[mid]) return mid;

            if(num < input[mid]) {
                return binSearch(input, s, mid - 1, num);
            } else {
                return binSearch(input, mid + 1, e, num);
            }
        }

        return -1;
    }


    public static int findPivot(int input[], int s, int e) {
        if(s <= e) {
            int mid = s + (e - s)/2;

            if(mid < e && input[mid +1] < input[mid])
                return mid;

            if(mid > s && input[mid] < input[mid -1])
                return mid -1;

            if(input[s] >= input[mid]) {
                return findPivot(input, s, mid - 1);
            } else {
                return findPivot(input, mid +1, e);
            }
        }

        return -1;
    }

    public static int sortedRotated(int input[], int num) {
        int n = input.length;
        int pivot = findPivot(input, 0, n);

        if(pivot == -1)
            return binSearch(input, 0, n, num);

        if(input[pivot] == num) return pivot;

        if(num <= input[0]) {
            return binSearch(input,  pivot +1, n, num);
        } else {
            return binSearch(input, 0, pivot +1, num);
        }
    }


    public static void main(String[] args) {
        /*int input[] = new int[]{1,3,4,6,7,10,12};
        System.out.println(
                binSearchIter( input, 12)
        );

        System.out.println(
                binSearch(input, 0, input.length -1, 12)
        );*/

        int input[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.print(sortedRotated(input, 2));

    }
}
