package edu.allegheny.benchmark;

public class IterativeFibonacci {

    /** Iteratively calculate the kth Fibonacci number.
     *
     * @param k indicates which Fibonacci number to compute.  @return the kth
     * Fibonacci number.
     */
    public static int fib(int k) {

    int finalFibValue = 1;

    int first = 1; int second = 1; int current;

    // initial easy case: If k <= 2 then fib(k) = 1.
    if (k <= 2) { return finalFibValue; }

    // iterative case; use iteration to compute the final response
    else {
		
        // add in the first two values and then begin the iterative calculation
        current = first + second;
		
        for(int i = 0; i < k-2; i++) {
		 
            // add in the value for current to our running total 
            current = first + second;
	
            //finalFibValue = finalFibValue + current;

            // adjust the values for first and second
            first = second; second = current;		    

        }

        finalFibValue = current; return finalFibValue;

        } 
    }

    /** Iteratively calcualte the kth Fibonacci number.
     *
     * @param k indicates which Fibonacci number to compute.  @return the kth
     * Fibonacci number.
     */
    public static long fibLong(int k) {

    long finalFibValue = 1;

    long first = 1; long second = 1; long current;

    // initial easy case: If k <= 2 then fib(k) = 1.
    if (k <= 2) { return finalFibValue; }

    // iterative case; use iteration to compute the final response
    else {
		
        // add in the first two values and then begin the iterative calculation
        current = first + second;
		
        for(int i = 0; i < k-2; i++) {
		 
            // add in the value for current to our running total 
            current = first + second;
	
            //finalFibValue = finalFibValue + current;

            // adjust the values for first and second
            first = second; second = current;		    

        }

        finalFibValue = current; return finalFibValue;

        } 
    }

}
