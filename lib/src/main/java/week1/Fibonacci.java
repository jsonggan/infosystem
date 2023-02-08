package week1;


public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacciSequence(5));
    }

    public static String getFibonacciSequence(int n) {
        int[] fib = new int[n];
        String result = "";
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        for (int i = 0;i<fib.length;i++){
            result += Integer.toString(fib[i]);
            if (i != fib.length-1){
                result += ",";
            }

        }

        return result;
    }
}

