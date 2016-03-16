# Lab 9 Sample Computation
#    "Use function f to calculate the value of (2w & x) - (y + 99). Save registers
#    s0, s1, and ra on the stack and restore them before returning. Use shifting to multiply.
#    Use an 'immediate' instruction for the addition."

########  DON'T CHANGE ANYTHING BETWEEN HERE AND THE NEXT "########" COMMENT
	.data
	.align	2
w:	.word	77		# See problem description
x:	.word	-14		# See problem description
y:	.word	89		# See problem description

	.text
	li	$s0,9999	# Dummy value to test that s0 gets restored
	li	$s1,-99999	# Dummy value to test that s1 gets restored
	lw	$a0,w		# Pass w to f in register a0
	lw	$a1,x		# Pass x to f in register a1
	lw	$a2,y		# Pass y to f in register a2
	jal	f		# Call function f
	
	move	$a0,$v0		# Print the result returned from f in register v0
	li	$v0,1
	syscall
	
	li	$v0,10		# Normal program termination
	syscall
########  DON'T CHANGE ANYTHING BETWEEN HERE AND THE PREVIOUS "########" COMMENT
	
f:	addi	$sp,$sp,-12	# space to save three registers
	sw	$s0,0($sp)	# save register s0
	sw	$s1,4($sp)	# save register s1
	sw	$ra,8($sp)	# save register ra
	
	sll	$s0,$a0,1	# s0 = 2w
	and	$s0,$s0,$a1	# s0 = s0 & x = 2w & x
	addi	$s1,$a2,99	# s1 = y+99
	sub	$v0,$s0,$s1	# v0 = s0-s1 = final result
	
	lw	$ra,8($sp)	# restore ra
	lw	$s1,4($sp)	# restore s1
	lw	$s0,0($sp)	# restore s0
	addi	$sp,$sp,12	# clean up stack
	jr	$ra		# return