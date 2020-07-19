public class SegmentTree {
    static int n;
    static int seg[];

    private int getMid(int start, int end) {
        return start + (end - start)/2;
    }

    public SegmentTree(int input[]) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int)(Math.pow(2, x)) -1;

        seg = new int[maxSize];
        construct(input, 0, n -1, 0);
    }

    private int construct(int input[], int start, int end, int index) {
        if(start == end) {
            seg[index] = input[start];
            return input[start];
        }

        int mid = getMid(start, end);
        seg[index] = construct(input, start, mid,(index * 2) + 1) +
                construct(input, mid +1, end,(index * 2) +2);

        return seg[index];
    }

    public int sum(int start, int end) {
        return (start < 0 || end > n -1 || start > end) ? -1 :
                getSumUtil(0, n -1, start, end , 0);
    }

    private int getSumUtil(int ss, int se, int start, int end, int index) {
        if (start <= ss && end >= se)
            return seg[index];

        if (se < start || ss > end)
            return 0;

        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, start, end, 2 * index + 1) +
                getSumUtil(mid + 1, se, start, end, 2 * index + 2);
    }

    public void update(int input[], int index, int value) {
        if(index < 0 || index > n -1) return;

        int diff = value - input[index];
        input[index] = value;

        updateUtil(0, n -1, index, diff, 0);
    }

    private void updateUtil(int x, int y, int index, int diff, int updateIndex) {
        if(index < x || index > y) return;

        seg[updateIndex] += diff;
        if(x != y) {
            int mid = getMid(x, y);
            updateUtil(x, mid, index, diff, 2 * updateIndex +1);
            updateUtil(mid +1, y, index, diff, 2 * updateIndex +2);
        }
    }

    public static void main(String[] args) {
        int input[] = {1,3,5,7,9,11};
        n = input.length;
        SegmentTree tree = new SegmentTree(input);

        System.out.println(tree.sum(1,3));
        tree.update(input, 1, 10);
        System.out.println(tree.sum(1,3));
    }
}
