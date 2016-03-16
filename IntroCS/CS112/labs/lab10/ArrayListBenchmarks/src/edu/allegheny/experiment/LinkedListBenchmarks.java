package edu.allegheny.experiment;

import java.util.LinkedList;

public class LinkedListBenchmarks {

    private static int initialListSize = 1000000;
    private static int FrontNumber = 4000;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for(int i = 0; i<initialListSize; i++) {    //creates a LinkedList of initial size
            linkedList.add(i);
        }
        System.out.println();
        System.out.println("Benchmark for adding to the front of the LinkedList: ");
        System.out.println("linkedList size = " + linkedList.size());

        long beforeLinkedListFrontAdd = System.currentTimeMillis();
        for(int i = 0; i<FrontNumber; i++){    //adds variable number of indices to front of LinkedList
            linkedList.add(i, i);
        }
        long afterLinkedListFrontAdd = System.currentTimeMillis();

        System.out.println("LinkedList elapsed time = " + (afterLinkedListFrontAdd - beforeLinkedListFrontAdd));
        System.out.println("LinkedList average add time = " + (double)(afterLinkedListFrontAdd - beforeLinkedListFrontAdd) / (double)FrontNumber);

        System.out.println("Benchmark for removing from the front of the LinkedList: ");
        removeFromFront();

    }

    //removes x number of elements from the front of the LinkedList
    public static void removeFromFront(){

        LinkedList<Integer> LinkedList2 = new LinkedList<Integer>();

        for(int i = 0; i<initialListSize; i++) {    //creates list of initial size
            LinkedList2.add(i);
        }
        System.out.println("LinkedList size = " + LinkedList2.size());

        long beforeRemove = System.currentTimeMillis();
        for(int i = 0; i<FrontNumber; i++){    //deletes variable number of indices from front of LinkedList
            LinkedList2.remove(0);
        }
        long afterRemove = System.currentTimeMillis();
        long time = afterRemove - beforeRemove;
        System.out.println("LinkedList elapsed time = " + time);
        System.out.println("LinkedList average remove time = " + (double)(time) / (double)FrontNumber);

    }

}
