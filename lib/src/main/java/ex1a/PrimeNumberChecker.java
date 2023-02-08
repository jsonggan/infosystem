package ex1a;

public class PrimeNumberChecker {
    public static void main(String[] args){
        System.out.println(isPrime(3));
    }
    public static int isPrime(int num){
        for (int i=2;i< num;i++){
            if(num%i == 0){
                return 0;
            }
        }
        return 1;
    }
}
