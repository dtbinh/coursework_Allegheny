# Bob Roos  Lab 5 Sample Program
# This does "slow multiplication" of nonnegative integers a and b.
# It simply loops "a" times, adding "b" to a cumulative sum each time.
# This is a "destructive" multiply--it reduces "a" to zero. It would
# be a trivial matter to preserve the original value of "a" prior to
# executing the loop so that both "a" and "b" may be used later in other
# calculations.

	.data
prompt:	.asciiz	"Enter two non-negative integers to be multiplied, one per line: "

	.text
# Section 1 of program: read in the two integers and save them in registers s0, s1:
	la	$a0,prompt	# ask user to enter values
	li	$v0,4		# print_string
	syscall
	li	$v0,5		# read_int
	syscall
	add	$s0,$zero,$v0	# First integer a in s0
	li	$v0,5		# read_int
	syscall
	add	$s1,$zero,$v0	# Second integer b in s1
	
# Section 2 of program: use s0 to count down to 0 while adding b to sum:
	li	$s2,0	# Sum in s2
loop:	beq	$zero,$s0,done	# If a == 0, done
	add	$s2,$s2,$s1	# sum = sum + b
	addi	$s0,$s0,-1	# a = a-1
	j	loop
done:	add	$a0,$zero,$s2	# Copy sum into a0 for printing
	li	$v0,1		# print_int
	syscall
	
# Section 3: terminate program normally:
	li	$v0,10
	syscall