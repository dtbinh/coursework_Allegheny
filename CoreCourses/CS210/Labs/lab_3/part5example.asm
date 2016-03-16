# SJ Guillaume, Lab 3, 14 September 2015
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 3 Part 5: ascii values


	.data
	.align 	2
letter:	.ascii	"A"
	
	
	.text
	lw	$t0, letter	# stores ascii value for a in register $t0
	
	li	$v0, 10		# end program
	syscall
