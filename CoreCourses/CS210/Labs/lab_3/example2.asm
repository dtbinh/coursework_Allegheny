# Bob Roos, Lab 3, 14 September 2015
# Example 2:  computing c = 5*(a+b) WITHOUT using multiplication, and
# using as few registers as possible (Note how we re-use $t0 and $t1.)
#      int a = 42;
#      int b = 20;
#      int temp = a+b;
#      int c = temp;
#      c = c+c; /* now c = 2*(a+b)
#      c = c+c; /* now c = 4*(a+b)
#      c = c+temp; /* now c = 5*(a+b)


	.data
	.align	2	# always a good idea -- will be discussed in class
a:	.word	42	# 4 bytes of memory containing the integer 42
b:	.word	20	# 4 bytes of memory containing the integer 20
c:	.space	4	# 4 bytes of memory

	.text
	lw	$t0,a		# load contents of memory address a into $t0
	lw	$t1,b		# load contents of memory address b into $t1
	add	$t0,$t0,$t1	# $t0 (i.e., temp) = a+b
	add	$t1,$zero,$t0	# copy $t0 into $t1 (i.e., c)
	add	$t1,$t1,$t1	# c = c+c
	add	$t1,$t1,$t1	# c = c+c
	add	$t1,$t1,$t0	# c = c + temp
	sw	$t1,c		# store result in address c
	
	
	 
