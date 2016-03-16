 #!/bin/bash
 echo Experiment 3: Shell vs Insertion Sort by Array Length

echo BEGIN EXPERIMENT 3

echo Results 3.1 >results.txt
 COUNTER=0
         while [  $COUNTER -lt 6 ]
	 do
              echo Trial $COUNTER>results.txt
                let COUNTER=COUNTER+1 
                java-algs4 Experiment3 Shell Insertion 100 10 #>>results.txt
		echo "finished " $COUNTER
         done

 COUNTER=0

echo Results 3.2 >results.txt
         while [  $COUNTER -lt 6 ]; do
             echo Trial $COUNTER >results.txt
                let COUNTER=COUNTER+1 
                java-algs4 Experiment3 Shell Insertion 1000 10 #>>results.txt
		echo "finished " $COUNTER
         done

 COUNTER=0

echo "Results 3.3">>results.txt
         while [  $COUNTER -lt 6 ]; do
             echo Trial $COUNTER >results.txt
                let COUNTER=COUNTER+1 
                java-algs4 Experiment3 Shell Insertion 10000 10 #>>results.txt
		 echo "finished " $COUNTER
         done

 COUNTER=0

echo "Results 3.4" >results.txt
         while [  $COUNTER -lt 6 ]; do
             echo Trial $COUNTER >results.txt
                let COUNTER=COUNTER+1 
                java-algs4 Experiment3 Shell Insertion 100000 10 #>>results.txt
		#echo "finished " $COUNTER
         done
    

