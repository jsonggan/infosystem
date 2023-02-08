package week1;

import java.util.List;

public class IteratingExamples {
    public static void main(String[] args){
//        System.out.println(Act2Iterator([1,2,3,4,5]));
    }

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;

        sum = iteration(integers);

        return sum;
    }

    public static int Act2ForEach(List<Integer> integers){
        int result = 0;
        for (int i=0;i<integers.size();i++){
            result += integers.get(i);
        }
        return result;
    }

    public static int iteration(List<Integer> integers){
        if (integers.size() == 1){
            return integers.get(0);
        }

        return integers.get(0)+ iteration(integers.subList(1,integers.size()));
    }
}
