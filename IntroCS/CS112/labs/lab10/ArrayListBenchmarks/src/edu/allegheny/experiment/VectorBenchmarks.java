package edu.allegheny.experiment;

import java.util.Vector;

public class VectorBenchmarks{

    private static int initialListSize = 1000000;
    private static int FrontNumber = 4000;

    public static void main(String[]args){
        Vector<Integer> vector = new Vector<Integer>();

        for(int i = 0; i<initialListSize; i++){  //create a vector of initial size, adds to back of vector
            vector.add(i);
        }
        // System.out.println();
        System.out.println("Benchmark for adding to the front of the Vector: ");

        System.out.println("Vector size = "+ vector.size());

        long beforeVectorFrontAdd = System.currentTimeMillis();
        for(int i = 0; i<FrontNumber; i++){    //adds variable number of indices to front, one per iteration
            vector.add(i, i);
        }
        long afterVectorFrontAdd = System.currentTimeMillis();

        System.out.println("Vector elapsed time = " + (afterVectorFrontAdd - beforeVectorFrontAdd));
        System.out.println("Vector average add time = " + (double)(afterVectorFrontAdd - beforeVectorFrontAdd) / (double)FrontNumber);

        System.out.println("Benchmark for removing from the front of the Vector: ");
        removeFromFront();

    }


    //method removes x number of elements from the front of the Vector
    public static void removeFromFront(){

        Vector<Integer> Vector2 = new Vector<Integer>();

        for(int i = 0; i<initialListSize; i++) {    //creates vector of initial size
            Vector2.add(i);
        }
        System.out.println("Vector size = " + Vector2.size());

        long beforeRemove = System.currentTimeMillis();
        for(int i = 0; i<FrontNumber; i++){    //deletes variable number of indices from front of Vector
            Vector2.remove(0);
        }
        long afterRemove = System.currentTimeMillis();
        long time = afterRemove - beforeRemove;
        System.out.println("Vector elapsed time = " + time);
        System.out.println("Vector average remove time = " + (double)(time) / (double)FrontNumber);

    }


}
