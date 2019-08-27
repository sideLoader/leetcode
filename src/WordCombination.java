
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WordCombination {


    public void printCombination(String str) {
        printCombination(str, "");
    }

    private void printCombination(String str, String soFar) {
        if(str.isEmpty()) {
            System.out.println(soFar);
        } else {
            for(char curr : str.toCharArray()) {
                soFar = soFar.concat(String.valueOf(curr));
                str = str.substring(1);

                printCombination(str, soFar);

                soFar = soFar.substring(0, soFar.length() -1);
                str = str.concat(String.valueOf(curr));
            }
        }
    }



    /*private List<String> binaryCombination(int size, String str, List<String> solution) {
        if(size == 0) {
            solution.add(str);
        } else {
            binaryCombination(size -1, str + "0", solution);
            binaryCombination(size -1, str + "1", solution);
        }

        return solution;
    }*/

    private String appendString(String str, int size) {
        while(str.length() < size)
            str = "0" + str;

        return str;
    }

    private List<String> binaryCombination(int size, String str, List<String> solution) {
        for(int i = 0; i < Math.pow(2, size); i++)
            System.out.println(appendString(Integer.toBinaryString(i), size));

        return new LinkedList<>();
    }



    public int numCombination(int[] str) {
        List<String> binComb = binaryCombination(str.length, "", new ArrayList<>());

        List<Integer> lengthList = binComb.stream().map(x -> {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < x.length(); i++) {
                if(x.charAt(i) == '1')
                    sb.append(str[i] + "-");
            }
            return sb.toString();
        }).filter(x -> !x.isEmpty()).map(x -> {
            int result, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            String nums[] = x.split("-");
            if(nums.length != 1) {
                for (String temp : nums) {
                    int digit = Integer.parseInt(temp);
                    if (digit > max) max = digit;
                    if (digit < min) min = digit;
                }
                result = max - min;
            } else
                result = 0;
            return result;

        }).collect(Collectors.toList());

        int mod = (int)Math.pow(10,9) + 7;
        return lengthList.stream().mapToInt(Integer::intValue).sum() % mod;
    }

    public static void main(String args[]) {

        WordCombination wc = new WordCombination();
        //wc.printCombination("vped");
        //System.out.println(wc.letterCombination(new int[]{7,8,8,10,4}));
        //String a = "";
        //List<String> df = Arrays.stream(a.split("-")).collect(Collectors.toList());
        //df.stream().forEach(System.out::println);
        //System.out.println("end");

        wc.binaryCombination(3,"", new ArrayList<>());
    }

}
