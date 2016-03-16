 # Bob Roos   Lab 4
# Example of integer input/output.
#
# When you run the program in MARS, type two integers,
# ON SEPARATE LINES, in the console area at the bottom
# of the MARS screen.
# Their sum and difference will be displayed.
#
# For variety, the first input value is saved in memory;
# the second one is merely copied into a temporary register.

        .data
        .align     2      # get to a word boundary
b:      .space     4      # space for second operand
nl:     .asciiz  "\n"     # newline character

        .text
        li       $v0,5    # code for read_int
        syscall           # perform the read
        add      $t0,$zero,$v0    # save it in register $t0

        li       $v0,5    # load code for read_int
        syscall           # perform the read
        sw       $v0,b    # save it in memory

        # Find and print the sum:
        lw       $t1,b
        add      $a0,$t0,$t1  # put their sum into $a0
        li       $v0,1    # code for print_int
        syscall           # perform the print
        
        # Print the newline string:
        la       $a0,nl
        li       $v0,4
        syscall

        sub      $a0,$t0,$t1 # put the difference into $a0
        li       $v0,1    # code for print_int
        syscall           # perform the print

        li       $v0,10   # code for system exit
        syscall           # terminate program
