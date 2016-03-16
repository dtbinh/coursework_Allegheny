/*SJ Guillaume
 * CS210
 * Honor Code: This is my work, developed using the base code provided by Professor Roos
 */



#include <stdio.h>
#include <string.h>
/* We set LINELENGTH to 82: 80 characters + newline + \0 */
#define LINELENGTH 82

int main() {
    char line[LINELENGTH];     /* The expression input by the user */
    char *linepointer; /* Pointer needed by strsep function */
    char *word;        /* A single number or operator in the input */
    char op;           /* Hold an operator (+ or -) */
    char message[] = "The result of the operation entered above is: ";
    char word1, word2;
    int i = 0;

    printf("Enter an integer, variable, or combination expression:\n");

    /*read in expression*/
    fgets(line,LINELENGTH,stdin);
    line[strlen(line)-1] = '\0'; /* get rid of newline character */
    printf("#Paste the following code into MARS:\n");

    /* Get ready to use strsep: */
    linepointer = line; /* Initially, linepointer points to first char in input */
    word = strsep(&linepointer," "); /* Read in first number or variable */
    if(! isdigit(word[0])){ /*if the word is not a digit, it is a letter(we are using variables)*/
        printf("    .data\n");
        printf("    .align 2\n");
        printf("message:    .asciiz \"%s\"\n",message);
        printf("    .align 2\n");
        printf("x:  .word   10\n");
        while ((word = strsep(&linepointer," "))!= NULL) {  /*we need to get the operator next*/
            if (strlen(word) == 0){
                continue; /* User entered multiple blanks */
            }
            if (! isdigit(word[0])) { /* if it's not a digit, then it's an operator */
                op = word[0]; /* save the operator until we read in next number */
            }
            if( op == '+'){
                while ((word = strsep(&linepointer," "))!= NULL) {  /*here we are getting the next number or variable*/
                    if (strlen(word) == 0) continue; /* User entered multiple blanks */
                    if (! isdigit(word[0])) { /* if it's not a digit, then it's a variable */
                        /*VARIABLE + VARIABLE*/
                        printf("    .align 2 \n");
                        printf("y:  .word 30\n");
                        printf("    .text\n");
                        printf("#load the contents of x and y into $s0 and $s1 respectively\n");
                            printf("lw    $s0, x\n");
                        printf("lw    $s1, y\n");
                        printf("#add x + y and store result in $s0\n");
                        printf("add   $s0, $s0, $s1\n");
                        printf("#print result\n");
                            printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                        break;
                    }
                    if(isdigit(word[0])){
                        /*VARIABLE + NUMBER*/
                        word2 = word[0];
                        printf(".text\n");
                        printf("#load the contents of x into $s0\n");
                        printf("lw    $s0, x\n");
                        printf("#put second value into $s1\n");
                        printf("li    $s1, %s\n",word);
                        printf("#add x + NUMBER and store result in $s0\n");
                        printf("add   $s0, $s0, $s1\n");
                        /* print out result*/
                        printf("#print result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");

                    }
                }
            }
            if(op == '-'){
                while ((word = strsep(&linepointer," "))!= NULL) {  /*here we are getting the next number or variable*/
                    if (strlen(word) == 0) continue; /* User entered multiple blanks */
                    if (! isdigit(word[0])) { /* if it's not a digit, then it's a variable */
                        /*VARIABLE - VARIABLE*/
                        printf("    .align 2 \n");
                        printf("y:  .word 30\n");
                        /*part for deciding what to do with the operator*/
                        printf("    .text\n");
                        printf("#store x and y in $s0 and $s1 repectivly\n");
                        printf("lw    $s0, x\n");
                        printf("lw    $s1, y\n");
                        printf("#$s0 = x - y");
                        printf("add   $s0, $s0, $s1\n");
                        printf("#print result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                        break;
                    }
                    if(isdigit(word[0])){
                        /*VARIABLE - NUMBER*/
                        word2 = word[0];
                        printf(".text\n");
                        printf("#store value of x in $s0\n");
                        printf("lw    $s0, x\n");
                        printf("#store value of NUMBER in $s1\n");
                        printf("li    $s1, %s\n",word);
                        printf("#$s0 = x - NUMBER\n");
                        printf("sub   $s0, $s0, $s1\n");
                        printf("#print result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                    }
                }
            }
            if(op == 'x'){
                while ((word = strsep(&linepointer," "))!= NULL) {
                    if (strlen(word) == 0) continue; /* User entered multiple blanks */
                    if (! isdigit(word[0])) { /* if it's not a digit, then it's a variable */
                        /*VARIABLE x VARIABLE*/
                        printf("    .align 2\n");
                        printf("y:  .word  30\n");
                        printf(".text\n");
                        printf("#load x into $s0\n");
                        printf("lw    $s0, x\n");
                        printf("#load y into $s1\n");
                        printf("lw    $s1, y\n");
                        printf("li    $s2, 0\n");
                        printf("# $s2 = x x y\n");
                        printf("loop:    beq   $zero, $s0, done\n");
                        printf("add   $s2, $s2, $s1\n");
                        printf("addi  $s0, $s0, -1\n");
                        printf("j    loop\n");
                        printf("    #print out message and result\n");
                        printf("done:    li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s2, $zero\n");
                        printf("syscall\n");
                    }
                    if(isdigit(word[0])){
                        /*VARIABLE x NUMBER*/
                        word2 = word[0];
                        printf("    .data\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);
                        printf("    .text\n");
                        printf("#load var and num into $s0 and $s1\n");
                        printf("lw    $s0, x\n");
                        printf("li    $s1, %c\n",word2);
                        printf("# $s2 = VAR x NUM\n");
                        printf("li    $s2, 0\n");
                        printf("loop:    beq   $zero, $s0, done\n");
                        printf("add   $s2, $s2, $s1\n");
                        printf("addi  $s0, $s0, -1\n");
                        printf("j    loop\n");
                        printf("    #print out message and result\n");
                        printf("done:    li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s2, $zero\n");
                        printf("syscall\n");
                    }
                }
            }
        }
    }
    /* the first thing is a number*/
    else{
        word1 = word[0];
        while((word = strsep(&linepointer," "))!= NULL) {   /*get the operator*/
            if (strlen(word) == 0){
                continue; /* User entered multiple blanks */
            }
            if (! isdigit(word[0])) { /* if it's not a digit, then it's an operator */
                op = word[0]; /* save the operator until we read in next number */
            }
            if (op == '+'){
                while ((word = strsep(&linepointer," "))!= NULL) {
                    if (strlen(word) == 0) continue; /* User entered multiple blanks */
                    if (! isdigit(word[0])) { /* if it's not a digit, then it's a variable */
                        /*NUMBER + VARIABLE*/
                        printf(".data\n");
                        printf("    .align 2\n");
                        printf("y:  .word  30\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);
                        printf(".text\n");
                        printf("#store number in $s0\n");
                        printf("li    $s0, %c\n", word1);
                        printf("#store y in $s1\n");
                        printf("lw    $s1, y\n");
                        printf("#$s0 = NUM + y\n");
                        printf("add   $s0, $s0, $s1\n");
                        printf("    #print out message and result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                    }
                    if(isdigit(word[0])){
                        /*NUMBER + NUMBER*/
                        word2 = word[0];
                        printf("    .data\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);
                        printf("    .text\n");
                        printf("#store NUM and NUM in $s0, $s1 respectively\n");
                        printf("li    $s0, %c\n",word1);
                        printf("li    $s1, %c\n",word2);
                        printf("# $s0 = NUM + NUM\n");
                        printf("add   $s0, $s0, $s1\n");
                        printf("    #print out message and result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                    }
                }
            }
            if (op == '-'){
                while ((word = strsep(&linepointer," "))!= NULL) {
                    if (strlen(word) == 0) continue; /* User entered multiple blanks */
                    if (! isdigit(word[0])) { /* if it's not a digit, then it's a variable */
                        /*NUMBER - VARIABLE*/
                        printf(".data\n");
                        printf("    .align 2\n");
                        printf("y:  .word  30\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);
                        printf(".text\n");
                        printf("#let $s0 have the value of NUM\n");
                        printf("li    $s0, %c\n", word1);
                        printf("#let $s1 have the value of y\n");
                        printf("lw    $s1, y\n");
                        printf("# $s0 = NUM - y\n");
                        printf("sub   $s0, $s0, $s1\n");
                        printf("    #print out message and result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                    }
                    if(isdigit(word[0])){
                        /*NUMBER - NUMBER*/
                        word2 = word[0];
                        printf("    .data\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);

                        printf("    .text\n");
                        printf("#let $s0 and $s1 hold the two numbers\n");
                        printf("li    $s0, %c\n",word1);
                        printf("li    $s1, %c\n",word2);
                        printf("# $s0 = NUM - NUM\n");
                        printf("sub   $s0, $s0, $s1\n");
                        printf("    #print out message and result\n");
                        printf("li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s0, $zero\n");
                        printf("syscall\n");
                    }
                }
            }
            if (op == 'x'){
                while ((word = strsep(&linepointer," "))!= NULL) {
                    if (strlen(word) == 0) continue; /* User entered multiple blanks */
                    if (! isdigit(word[0])) { /* if it's not a digit, then it's a variable */
                        /*NUMBER x VARIABLE*/
                        printf(".data\n");
                        printf("    .align 2\n");
                        printf("y:  .word  30\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);
                        printf(".text\n");
                        printf("#load $s0 with the first number\n");
                        printf("li    $s0, %c\n", word1);
                        printf("#load y into $s1\n");
                        printf("lw    $s1, y\n");
                        printf("li    $s2, 0\n");
                        printf("# $s2 = NUM x y\n");
                        printf("loop:    beq   $zero, $s0, done\n");
                        printf("add   $s2, $s2, $s1\n");
                        printf("addi  $s0, $s0, -1\n");
                        printf("j    loop\n");
                        printf("    #print out message and result\n");
                        printf("done:    li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s2, $zero\n");
                        printf("syscall\n");
                    }
                    if(isdigit(word[0])){
                        /*NUMBER x NUMBER*/
                        word2 = word[0];
                        printf("    .data\n");
                        printf("    .align 2\n");
                        printf("message:    .asciiz \"%s\"\n",message);
                        printf("    .text\n");
                        printf("#load num and num into $s0 and $s1\n");
                        printf("li    $s0, %c\n",word1);
                        printf("li    $s1, %c\n",word2);
                        printf("# $s2 = NUM x NUM\n");
                        printf("li    $s2, 0\n");
                        printf("loop:    beq   $zero, $s0, done\n");
                        printf("add   $s2, $s2, $s1\n");
                        printf("addi  $s0, $s0, -1\n");
                        printf("j    loop\n");
                        printf("    #print out message and result\n");
                        printf("done:    li    $v0, 4\n");
                        printf("la    $a0, message\n");
                        printf("syscall\n");
                        printf("li    $v0, 1\n");
                        printf("add   $a0, $s2, $zero\n");
                        printf("syscall\n");
                    }
                }
            }
        }
    }
    /*close program*/
    printf("    #close program\n");
    printf("    li  $v0, 10\n");
    printf("    syscall\n");
}
