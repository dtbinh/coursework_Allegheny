/* SJ Guillaume
 * Lab 1
 * 210 Fall 2015
 * Part 4.a printing line numbers for a file input
 */

#include <stdio.h>

/*print a file with line numbers*/

main(){
    int lineNum, c;

    lineNum = 0;
    c = 0;
    while((c= getchar()) != EOF){
        if(c != '\n'){
            lineNum++;
            printf("%3d. ", lineNum);
            while(c != '\n'){
                putchar(c);
                c = getchar();
            }
            printf("\n");
        }
    }
}
/*
if(c== '\n'){
        lineNum++;
        putchar(c);
        printf("%3d %d\n", lineNum, putchar(c));
        }
        else{
            putchar(c);
        }
    }
*/
