/* Use this file for problem 2 in lab 9. Be sure to replace
 * these comments with your own
 */

/**********  DON'T CHANGE ANY C CODE EXCEPT THE arrayCalc FUNCTION! *********/
#include <stdio.h>

/* Function prototype: */
void arrayCalc(int a[], int len);

int main() {
    int a1[] = {4,2,9,-1,6 3};
    int a2[] = {10,9,11,12,15,28,19};
    int a3[] = {2,3,5,8,0 19,1};
    int l1 = 6, l2 = 7, l3 = 7, i;
    arrayCalc(a1);
    for (i = 0; i < l1; i++) { printf("%d ",a1[i]); }
    printf("\n");
    arrayCalc(a2);
    for (i = 0; i < l2; i++) { printf("%d ",a2[i]); }
    printf("\n");
    arrayCalc(a3);
    for (i = 0; i < l3; i++) { printf("%d ",a3[i]); }
    printf("\n");
}

/***********  CHANGE THE FOLLOWING FUNCTION ACCORDING TO THE PROBLEM ******/
void arrayCalc(int a[], int len) {

}

