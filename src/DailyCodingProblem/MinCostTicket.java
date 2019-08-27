package DailyCodingProblem;

//https://leetcode.com/contest/weekly-contest-121/problems/minimum-cost-for-tickets/


public class MinCostTicket {
    private int mincostTickets(int days[], int costs[], int index, int value) {
        if(index >= days.length)
            return value;

        int day1 = index +1;

        int i;
        for(i = index; i < days.length; i++)
            if(days[i] > days[index] + 6) {
                i--;
                break;
            }

        int day7 = i;
        for(i = index; i < days.length; i++) {
            if(days[i] > days[index] + 14) {
                i--;
                break;
            }
        }
        int day15 = i;

        return Math.min(
                mincostTickets(days, costs, day1, value + costs[0]),
                Math.min(
                        mincostTickets(days, costs, day7, value + costs[1]),
                        mincostTickets(days, costs, day15, value + costs[2])
                )
        );
    }

    public int mincostTickets(int[] days, int[] costs) {
        return mincostTickets(days, costs, 0, 0);
    }


    public static void main(String[] args) {
        int days[] = {1,4,6,7,9,20};
        int costs[] = {2,7,15};

        System.out.println((new MinCostTicket()).mincostTickets(days, costs));
    }
}
