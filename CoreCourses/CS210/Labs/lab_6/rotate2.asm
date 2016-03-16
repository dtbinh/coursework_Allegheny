#SJ Guillaume
# I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
# Lab 6 Part 3
	.data
	.align	2
a1:	.word	10,20,30,40	# first array, size 4
a2:	.word	3		# second array, size 1
a3:	.word	11,12,13,14,15,16,17,18,19	# third array, size 9
lab1:	.asciiz	"Unrotated array: "
lab2:	.asciiz	"Rotated array: "
space:	.asciiz	" "
nl:	.asciiz	"\n"

	.text
# First array:
	la	$a0,lab1	# Print label for unrotated array
	li	$v0,4
	syscall
	
	la	$a0,a1		# Print the unrotated array
	li	$a1,4
	jal	aprint
	

	la	$a0,a1		#perform rotation
	li	$a1,4
	jal	rotl

	
	la	$a0,lab2	# Print label for rotated array
	li	$v0,4
	syscall
	
	la	$a0,a1		# Print the rotated array
	li	$a1,4
	jal	aprint
# Second array:
	la	$a0,lab1	# Print label for unrotated array
	li	$v0,4
	syscall
	
	la	$a0,a2		# Print the unrotated array
	li	$a1,1
	jal	aprint

	la	$a0,a2		#perform rotation
	li	$a1, 1
	jal	rotl

	
	la	$a0,lab2	# Print label for rotated array
	li	$v0,4
	syscall
	
	la	$a0,a2		# Print the rotated array
	li	$a1,1
	jal	aprint
# Third array:
	la	$a0,lab1	# Print label for unrotated array
	li	$v0,4
	syscall
	
	la	$a0,a3		# Print the unrotated array
	li	$a1,9
	jal	aprint

	la	$a0,a3		#perform rotation
	li	$a1,9
	jal	rotl

	
	la	$a0,lab2	# Print label for rotated array
	li	$v0,4
	syscall
	
	la	$a0,a3		# Print the rotated array
	li	$a1,9
	jal	aprint
	
	li	$v0,10		# Terminate program
	syscall	

#########################################################
############ Function aprint:
############    prints array at address a0 of length a1
#########################################################

aprint:	addi	$sp,$sp,-8	# Save $s0 and $s1 on the stack
	sw	$s0,0($sp)	#array address
	sw	$s1,4($sp)	#array size
	
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

#############
# YOUR rotl FUNCTION GOES HERE.
# WARNING: BE SURE YOU USE DIFFERENT LABEL NAMES FROM THE
# ONES IN "aprint". DON'T USE "loop" OR "done"--THEY'RE TAKEN!
#############

rotl:	addi	$sp,$sp,-8	# Save $s0 and $s1 on the stack
	sw	$s0,0($sp)	#array number						
	sw	$s1,4($sp)	#array size

	move	$s0,$a0		# array info in s0
	move	$s1,$a1		# array size in s1
	li	$t0,1		# t0 is our counter
	lw	$t1, 0($s0)	#holds first value in temp t1
	li	$t2, 2		#load 2 into t2
	li	$t4, 0		#array place counter


check:	slt	$t3, $t0, $s1	#checks that the iteration is less than total number of indexes in array
	addi	$t0, $t0, 1	#adds one to counter t0
	bne	$t3, $zero, rotate	#if t0 is < total number then go to rotate function
	beq	$t3, $zero, last	#if t0 is 1 then go to last function
	
rotate:	addi	$s2, $s0, 4	#add 4 
	lw	$t5, ($s2)	#load contents of array index +1 to t5
	sw	$t5, ($s0) 	#save word to left index
	addi	$s0, $s0, 4	#add 4 to s0					
	j	check
last:	sw	$t1, ($s0)	#saves original first to final index				
	
	jr	$ra		# Finished--return to caller


