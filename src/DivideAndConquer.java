
class Pair {
    int a,b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class DivideAndConquer {

    int sum(int nums[], int start, int end) {
        if(start == end) return nums[start];

        if(start == end -1) {
            return nums[start] + nums[end];
        } else {
            int mid = start + (end - start)/2;
            return sum(nums, start,  mid) + sum(nums, mid +1, end);
        }
    }

    Pair twoMaxRegular(int nums[]) {
        int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for(int num : nums) {

            if(num > max) max = num;
            if(num > max2 && num != max) max2 = num;
        }

        return new Pair(max, max2);
    }
    public static void main(String args[]) {
        DivideAndConquer dc = new DivideAndConquer();

        System.out.println(dc.sum(new int[]{1,2,3,4,5}, 0, 4));
    }
}
