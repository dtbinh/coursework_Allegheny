#Paste the following code into MARS:
    .data
    .align 2
message:    .asciiz "The result of the operation entered above is: "
    .align 2
x:  .word   10
    .align 2 
y:  .word 30
    .text
#load the contents of x and y into $s0 and $s1 respectively
lw    $s0, x
lw    $s1, y
#add x + y and store result in $s0
add   $s0, $s0, $s1
#print result
li    $v0, 4
la    $a0, message
syscall
li    $v0, 1
add   $a0, $s0, $zero
syscall
    #close program
    li  $v0, 10
    syscall
