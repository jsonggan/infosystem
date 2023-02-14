package ex2a;

import java.util.ArrayList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed



    Permutation(final String str){
        in = str;
        // additional initialization if needed

    }
    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        permuteHelper("",in);
    }
    public void permuteHelper(String prefix, String suffix){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        int n = suffix.length();
        if(n == 0){
            a.add(prefix);
        }
        for (int i =0; i<n;i++){
            permuteHelper(prefix + suffix.charAt(i),suffix.substring(0,i)+suffix.substring(i+1,n));
        }
    }

    public ArrayList<String> getA(){
        return a;
    }
}
