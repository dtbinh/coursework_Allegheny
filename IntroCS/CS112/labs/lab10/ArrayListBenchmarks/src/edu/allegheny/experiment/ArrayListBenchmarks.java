package edu.allegheny.experiment;

import java.util.ArrayList;

public class ArrayListBenchmarks {

    private static int initialListSize = 1000000;
    private static int FrontNumber = 4000;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i<initialListSize; i++) {    //creates array of initial size
            arrayList.add(i);
        }
        System.out.println();
        System.out.println("Benchmark for adding to the front of the ArrayList: ");
        System.out.println("ArrayList size = " + arrayList.size());

        long beforeArrayListFrontAdd = System.currentTimeMillis();
        for(int i = 0; i<FrontNumber; i++){    //adds variable number of indices to front of ArrayList
            arrayList.add(i, i);
        }
        long afterArrayListFrontAdd = System.currentTimeMillis();

        System.out.println("ArrayList elapsed time = " + (afterArrayListFrontAdd - beforeArrayListFrontAdd));
        System.out.println("ArrayList average add time = " + (double)(afterArrayListFrontAdd - beforeArrayListFrontAdd) / (double)FrontNumber);

        System.out.println("Benchmark for removing from the front of the ArrayList: ");
        removeFromFront();

    }

    //removes x number of elements from the front of the ArrayList
    public static void removeFromFront(){

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();

        for(int i = 0; i<initialListSize; i++) {    //creates array of initial size
            arrayList2.add(i);
        }
       // System.out.println("ArrayList2 size = " + arrayList2.size());

        long beforeRemove = System.currentTimeMillis();
        for(int i = 0; i<FrontNumber; i++){    //deletes variable number of indices from front of ArrayList
            arrayList2.remove(0);
            }
        System.out.println("ArrayList2 size after remove: "+ arrayList2.size());
        long afterRemove = System.currentTimeMillis();
        long time = afterRemove - beforeRemove;
        System.out.println("ArrayList elapsed time = " + time);
        System.out.println("ArrayList average remove time = " + (double)(time) / (double)FrontNumber);

    }
}
