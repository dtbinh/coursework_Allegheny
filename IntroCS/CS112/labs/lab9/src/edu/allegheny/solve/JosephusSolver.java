package edu.allegheny.solve;

import net.datastructures.*;

public class JosephusSolver {

    /** Solution of the Josephus problem using a queue. */
    public static <E> E Josephus(Queue<E> Q, int k) {
        if (Q.isEmpty()) return null;
        while (Q.size() > 1) {
            System.out.println("  Queue: " + Q + "  k = " + k);
            for (int i=0; i < k; i++)
                Q.enqueue(Q.dequeue());  // move the front element to the end
            E e = Q.dequeue(); // remove the front element from the collection
            System.out.println("    " + e + " is out");
        }
        return Q.dequeue();  // the winner
    }

    /** Build a queue from an array of objects */
    public static <E> Queue<E> buildQueue(E a[]) {
        Queue<E> Q = new NodeQueue<E>();
        for (int i=0; i<a.length; i++)
            Q.enqueue(a[i]);
        return Q;
    }


    /** Tester method */
    public static void main(String[] args){
       String children = args[0];
       String steps = args[1];

        int childrenNum = Integer.parseInt(children);
        int stepsNum = Integer.parseInt(steps);

        String[] namesList = new String[childrenNum]; //create array to store names
        int c = 0;
        for(int i=0; i<childrenNum; i++){   //create children and store in array
            namesList[i] = Integer.toString(c);
            c++;
        }


        long startTime = System.currentTimeMillis();
        System.out.println("Champion is: "+Josephus(buildQueue(namesList), stepsNum));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: "+totalTime);
    }
}

