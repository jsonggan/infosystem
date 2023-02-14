package ex2a;

import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {
    public int compare(Octagon a,Octagon b){
        if(a.getSide()>b.getSide()){
            return 1;
        }
        else if(a.getSide()==b.getSide()){
            return 0;
        }
        return -1;
    }
}
