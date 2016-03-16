# SJ Guillaume, Lab 3, 14 September 2015
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 3 Part 5: convert uppercase ascii value to an int between 0 and 25 representing the position of the letter in the alphabet
# int c = 65;
#store c as an int between 0 and 25


	.data
	.align 	2
c:	.ascii	"A"	#stores ascii value for "A" into variable c
	.align 2
ascVal:	.space	4	#creates space to save the 0-25 number representing the position of the letter in the alphabet
	
	
	.text
	lw	$t0, c		# stores ascii value for c in register $t0
	subi	$t0,$t0,65	# subtracts the value of 65 from ascii value to get the 0 to 25 representation
	sw	$t0, ascVal	# stores the number representation back into the variable c
	
	
	
	li	$v0, 10		# end program
	syscall
