#SJ Guillaume
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 6 Part 2

	.data
	.align	2
a1:	.word	10,20,30,40	# the array to be rotated
lab1:	.asciiz	"Unrotated array: "
lab2:	.asciiz	"Rotated array: "
space:	.asciiz	" "
nl:	.asciiz	"\n"

	.text
	la	$a0,lab1	# Print label for unrotated array
	li	$v0,4
	syscall
	
	la	$a0,a1		# Print the unrotated array
	li	$a1,4
	jal	aprint
	
###########
#  Your code for rotating the array
#  goes in place of this comment block
###########


#need to load address of a1 at 0
#load address of a1 at zero again
#load the word at a1 0 to save for later
#then start incrementing the address, then load word from that address, and save word to the previous place address
#this all makes sense
#then save the last address with the word from the register before

	la	$t0, a1		#load address for a1				t0 = 0
	la	$t1, a1		#load address for a1				t1 = 0
	lw	$t3, a1		#load word at a1 0 to $t3 for later		t3 = 10
	li	$t5, 0		#number of loop iteration
	li	$t6, 4		#total number of items in array
check:	li	$t7, 0		#to store result of slt
	addi	$t5, $t5, 1
	slt	$t7, $t5, $t6
	bne	$t7, $zero, rotate
	beq	$t7, $zero, last
	
rotate:	addi	$t1, $t1, 4	#add 4 to t1					t1 = 4
	lw	$t4, ($t1)	#load contents at address t1 into t4		a1 1 = 20
	sw	$t4, ($t0)	#save word to address t0			a1 0 = 20
	addi	$t0, $t0, 4	#add 4 to t0					t0 = 0
	j	check
last:	sw	$t3, ($t0)	#saves 10 to a1 3				a1 3 = 10
	

	
	
	
	la	$a0, a1
	li	$v0, 4
	syscall

	

	
	la	$a0,lab2	# Print label for rotated array
	li	$v0,4
	syscall
	
	la	$a0,a1		# Print the rotated array
	li	$a1,4
	jal	aprint
		
	li	$v0,10		# Terminate program
	syscall	

#########################################################
############ Function aprint:
############    prints array at address a0 of length a1
#########################################################

aprint:	addi	$sp,$sp,-8	# Save $s0 and $s1 on the stack
	sw	$s0,0($sp)
	sw	$s1,4($sp)
	
	move	$s0,$a0		# Save a0 in s0--we need a0 for syscalls
	li	$s1,0		# s1 is our loop counter
	
loop:	slt	$t0,$s1,$a1	# See if we're done yet
	beq	$t0,$zero,done	# exit loop if s1 >= a1 (i.e., if counter >= array size)
	lw	$a0,0($s0)	# Print next array element:
	li	$v0,1
	syscall
	
	la	$a0,space	# Print a space after the array element:
	li	$v0,4
	syscall
	
	addi	$s0,$s0,4	# Move forward to next array value (4 bytes per int)
	addi	$s1,$s1,1	# Increment the loop counter
	j	loop
	
done:	la	$a0,nl		# Print a newline:
	li	$v0,4
	syscall
	
	lw	$s0,0($sp)	# Restore the old values of s0, s1
	lw	$s1,4($sp)
	addi	$sp,$sp,8
	
	jr	$ra		# Finished--return to caller
