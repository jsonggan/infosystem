package week1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteration {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(50);
        list.add(89);
        list.add(3);
        list.add(16);
        list.add(5);
        forLoop(list);
        forEach(list);
        whileLoop(list);
    }

    public static void forLoop(List<Integer> list){
        for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void forEach(List<Integer> list){
        for (Integer item:list){
            System.out.println(item);
        }
    }


    public static void whileLoop(List<Integer> list){
        System.out.println("while");
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
