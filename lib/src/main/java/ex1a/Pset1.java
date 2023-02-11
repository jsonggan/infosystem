package ex1a;

import java.util.Arrays;
import java.util.HashSet;

public class Pset1 {

//    public static void main(String[] args){
//        int count1[] = new int [3];
//        Arrays.fill(count1,0);
//        System.out.println(count1);
//    }
    public static boolean isAllCharacterUnique(String sIn) {
        HashSet<String> finalList = new HashSet<String>();

        for (int i = 0; i < sIn.length(); i++) {
            finalList.add(String.valueOf(sIn.charAt(i)));
        }
        if (finalList.size() == sIn.length()){
            return true;
        }
        return false;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        int noOfChar = 128;
        int count[] = new int[noOfChar];

        for ( int i= 0; i<sIn1.length() && i<sIn2.length();i++){
            count[sIn1.charAt(i)]++;
            count[sIn2.charAt(i)]--;
        }
        if (sIn1.length() != sIn2.length()) return false;
        for (int i=0 ;i<noOfChar;i++) if (count[i] != 0) return false;

        return true;
    }
}
