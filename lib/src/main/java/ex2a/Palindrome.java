package ex2a;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {
        if(S.length == 0) return true;
        if(S.length ==1) return true;
        if(S.length == 2){
            if(S[0] ==S[1] ){
                return true;
            }
            return false;
        }
        System.out.println(S[0] == S[S.length-1]);
        System.out.println(Arrays.copyOfRange(S,1,S.length-1));
        return (S[0] == S[S.length-1]) && isPalindrome(Arrays.copyOfRange(S,1,S.length-1));
    }
}
