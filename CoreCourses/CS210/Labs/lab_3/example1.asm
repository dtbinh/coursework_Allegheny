# Bob Roos, Lab 3, 14 September 2015
# Example 1: creating space in memory and computing:
#      int a = 42;
#      int b = a + 17;

	.data
	.align	2	# always a good idea -- will be discussed in class
a:	.word	42	# 4 bytes of memory containing the integer 42
b:	.space	4	# 4 bytes of memory

	.text
	lw	$t0,a		# load contents of memory address a into $t0
	li	$t1,17		# $t1 = 17
	add	$t0,$t0,$t1	# $t0 = $t0 + $t1
	sw	$t0,b		# store result in address b
	
	
	 
