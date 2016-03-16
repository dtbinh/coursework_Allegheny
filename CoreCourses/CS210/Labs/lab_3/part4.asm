# SJ Guillaume, Lab 3, 14 September 2015
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 3 Part 4: optimize part 1 of lab 3 by using fewer mips instructions
#      int a = 42;
#      int b = a + 17;

	.data
	.align	2	# always a good idea -- will be discussed in class
a:	.word	42	# 4 bytes of memory containing the integer 42
b:	.space	4	# 4 bytes of memory

	.text
	lw	$t0,a		# load contents of memory address a into $t0
	addi	$t0,$t0, 17	# $t0 = $t0 + 17
	sw	$t0,b		# store result in address b
	
	li 	$v0, 10
	syscall	
