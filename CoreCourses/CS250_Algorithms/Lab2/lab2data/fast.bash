 #!/bin/bash
 echo FourSumFast.java execution times

echo BEGIN EXPERIMENT 

 echo "Results for 256.txt">>results.txt
 COUNTER=0
         while [  $COUNTER -lt 5 ]; do
             echo Trial $COUNTER>>results.txt
                 let COUNTER=COUNTER+1 
	     java-algs4 FourSumFast 256ints.txt>>results.txt
         done

 echo "Results for 512.txt">>results.txt

  COUNTER=0
         while [  $COUNTER -lt 5 ]; do
             echo Trial $COUNTER>>results.txt
             let COUNTER=COUNTER+1 
	     java-algs4 FourSumFast 512ints.txt>>results.txt
         done
echo "Results for 1000.txt">>results.txt

  COUNTER=0
         while [  $COUNTER -lt 5 ]; do
             echo Trial $COUNTER>>results.txt
             let COUNTER=COUNTER+1 
	     java-algs4 FourSumFast 1Kints.txt>>results.txt

         done
echo "Results for 2000.txt">>results.txt

 COUNTER=0
         while [  $COUNTER -lt 5 ]; do
             echo Trial $COUNTER>>results.txt

             let COUNTER=COUNTER+1 
	     java-algs4 FourSumFast 2Kints.txt>> results.txt

         done

