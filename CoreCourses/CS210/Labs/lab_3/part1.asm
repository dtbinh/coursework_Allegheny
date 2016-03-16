# SJ Guillaume, Lab 3, 14 September 2015
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 3 Part 1: calculating x = a - (2*b +c -d)
#      x = a - (2*b +c -d);
#	int a = 10
#	int b = 20
#	int c = -30
#	int d = -40


	.data
	.align	2	# always a good idea -- will be discussed in class
a:	.word	10	# 4 bytes of memory containing the integer 10
b:	.word	20	# 4 bytes of memory containing the integer 20
c: 	.word	-30	# 4 bytes of memory containing the integer -30
d: 	.word	-40	# 4 bytes of memory containing the integer -40
x:	.space	4	# 4 bytes of memory

	.text
	lw	$t0,b		# load contents of memory address b into $t0
	add	$t0,$t0,$t0	# 2*b
	lw	$t1,c		# load contents of memory address c into $t1
	add	$t0,$t0, $t1	# (2b) + c
	lw	$t1, d		# load contents of memeory address d into $t1
	sub 	$t0, $t0, $t1	# (2b) + c - d
	lw	$t1, a		# load contents of memory address a into $t1
	sub	$t0, $t1, $t0	# a - (2b + c - d)
	sw 	$t0, x
	
	li	$v0, 10
	syscall
