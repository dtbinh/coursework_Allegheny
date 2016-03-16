# SJ Guillaume, Lab 3, 14 September 2015
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 3 Part 2: calculate x = (a-b)*3 + (a+b)*6;
#	x = (a-b)*3 + (a+b)*6
#      int a = 10;
#      int b = -1;
#      int x;


	.data
	.align	2	# always a good idea for the purpose of aligning bytes
a:	.word	10	# 4 bytes of memory containing the integer 42
b:	.word	-1	# 4 bytes of memory containing the integer 20
x:	.space	4	# 4 bytes of memory

	.text
	lw	$t0,a		# load contents of memory address a into $t0
	lw	$t2,a		# load contents of memory address a into $t2
	lw	$t1,b		# load b into memory address $t1
	sub	$t0,$t0,$t1	# store (a - b) in m.a. $t0
	add	$t1,$t2,$t1	# store (a + b) in m.a. $t1
	add	$t2,$t0, $t0	# add contents of memory address $t0 for (a-b)*2
	add	$t2,$t2,$t0	# add contents of memory address $t0 and $t2 for (a-b)*3
	add	$t0,$t1,$t1	# add contents of m.a. $t1 and $t1 for (a+b)*2 store in m.a $t0
	add	$t1,$t0,$t0	# add contents of m.a. $t0 for (a+b)*4 store in $t1
	add	$t0,$t1,$t0	# add contents of m.a $t0 and $t1 for (a+b)*6
	add	$t0,$t0,$t2	#add contents of $t0 and $t2 for (a-b)*3 + (a+b)*6
	sw 	$t0, x
	
	li	$v0, 10
	syscall
