# SJ Guillaume, Lab 3, 14 September 2015
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 3 Part 3: compute x = 7y for y = 13
#	x = y*7
#      int y = 13;
#      int x;



	.data
	.align	2	# always a good idea for the purpose of aligning bytes
y:	.word	13	# 4 bytes of memory containing the integer 13
x:	.space	4	# 4 bytes of memory

	.text
	lw	$t0,y		# load contents of memory address x into $t0
	add	$t1,$t0,$t0	# add $t0 and $t0 for 2*y and store in $t1
	add	$t1,$t1,$t1	# add $t1, $t1 for 4*y
	add	$t1,$t0,$t1	# add $t1, $t1 for 5*y
	add	$t1,$t0,$t1	# add $t1, $t1 for 6*y
	add	$t1,$t0,$t1	# add $t0, $t1 for 7*y
	sw 	$t1, x
	
	li	$v0, 10
	syscall
